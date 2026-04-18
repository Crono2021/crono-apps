.class public final Landroidx/media3/extractor/text/ssa/SsaParser;
.super Ljava/lang/Object;
.source "SsaParser.java"

# interfaces
.implements Landroidx/media3/extractor/text/SubtitleParser;


# static fields
.field public static final CUE_REPLACEMENT_BEHAVIOR:I = 0x1

.field private static final DEFAULT_MARGIN:F = 0.05f

.field private static final DIALOGUE_LINE_PREFIX:Ljava/lang/String; = "Dialogue:"

.field static final FORMAT_LINE_PREFIX:Ljava/lang/String; = "Format:"

.field private static final SSA_TIMECODE_PATTERN:Ljava/util/regex/Pattern;

.field static final STYLE_LINE_PREFIX:Ljava/lang/String; = "Style:"

.field private static final TAG:Ljava/lang/String; = "SsaParser"


# instance fields
.field private final dialogueFormatFromInitializationData:Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;

.field private final haveInitializationData:Z

.field private final parsableByteArray:Landroidx/media3/common/util/ParsableByteArray;

.field private screenHeight:F

.field private screenWidth:F

.field private styles:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/media3/extractor/text/ssa/SsaStyle;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 66
    nop

    .line 67
    const-string v0, "(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/text/ssa/SsaParser;->SSA_TIMECODE_PATTERN:Ljava/util/regex/Pattern;

    .line 66
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 96
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/extractor/text/ssa/SsaParser;-><init>(Ljava/util/List;)V

    .line 97
    return-void
.end method

.method public constructor <init>(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "[B>;)V"
        }
    .end annotation

    .line 108
    .local p1, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 109
    const v0, -0x800001

    iput v0, p0, Landroidx/media3/extractor/text/ssa/SsaParser;->screenWidth:F

    .line 110
    iput v0, p0, Landroidx/media3/extractor/text/ssa/SsaParser;->screenHeight:F

    .line 111
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {v0}, Landroidx/media3/common/util/ParsableByteArray;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/text/ssa/SsaParser;->parsableByteArray:Landroidx/media3/common/util/ParsableByteArray;

    .line 113
    const/4 v0, 0x0

    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 114
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroidx/media3/extractor/text/ssa/SsaParser;->haveInitializationData:Z

    .line 118
    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    invoke-static {v0}, Landroidx/media3/common/util/Util;->fromUtf8Bytes([B)Ljava/lang/String;

    move-result-object v0

    .line 119
    .local v0, "formatLine":Ljava/lang/String;
    const-string v2, "Format:"

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 120
    nop

    .line 121
    invoke-static {v0}, Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;->fromFormatLine(Ljava/lang/String;)Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;

    move-result-object v2

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;

    iput-object v2, p0, Landroidx/media3/extractor/text/ssa/SsaParser;->dialogueFormatFromInitializationData:Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;

    .line 122
    new-instance v2, Landroidx/media3/common/util/ParsableByteArray;

    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [B

    invoke-direct {v2, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>([B)V

    sget-object v1, Lcom/google/common/base/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {p0, v2, v1}, Landroidx/media3/extractor/text/ssa/SsaParser;->parseHeader(Landroidx/media3/common/util/ParsableByteArray;Ljava/nio/charset/Charset;)V

    .line 123
    .end local v0    # "formatLine":Ljava/lang/String;
    goto :goto_0

    .line 124
    :cond_0
    iput-boolean v0, p0, Landroidx/media3/extractor/text/ssa/SsaParser;->haveInitializationData:Z

    .line 125
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/extractor/text/ssa/SsaParser;->dialogueFormatFromInitializationData:Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;

    .line 127
    :goto_0
    return-void
.end method

.method private static addCuePlacerholderByTime(JLjava/util/List;Ljava/util/List;)I
    .locals 4
    .param p0, "timeUs"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/List<",
            "Ljava/lang/Long;",
            ">;",
            "Ljava/util/List<",
            "Ljava/util/List<",
            "Landroidx/media3/common/text/Cue;",
            ">;>;)I"
        }
    .end annotation

    .line 561
    .local p2, "sortedCueTimesUs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    .local p3, "cues":Ljava/util/List;, "Ljava/util/List<Ljava/util/List<Landroidx/media3/common/text/Cue;>;>;"
    const/4 v0, 0x0

    .line 562
    .local v0, "insertionIndex":I
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_2

    .line 563
    invoke-interface {p2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    cmp-long v2, v2, p0

    if-nez v2, :cond_0

    .line 564
    return v1

    .line 567
    :cond_0
    invoke-interface {p2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    cmp-long v2, v2, p0

    if-gez v2, :cond_1

    .line 568
    add-int/lit8 v0, v1, 0x1

    .line 569
    goto :goto_1

    .line 562
    :cond_1
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 572
    .end local v1    # "i":I
    :cond_2
    :goto_1
    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {p2, v0, v1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 574
    nop

    .line 576
    new-instance v1, Ljava/util/ArrayList;

    if-nez v0, :cond_3

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    goto :goto_2

    :cond_3
    add-int/lit8 v2, v0, -0x1

    invoke-interface {p3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Collection;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 574
    :goto_2
    invoke-interface {p3, v0, v1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 577
    return v0
.end method

.method private static computeDefaultLineOrPosition(I)F
    .locals 1
    .param p0, "anchor"    # I

    .line 540
    packed-switch p0, :pswitch_data_0

    .line 549
    const v0, -0x800001

    return v0

    .line 546
    :pswitch_0
    const v0, 0x3f733333    # 0.95f

    return v0

    .line 544
    :pswitch_1
    const/high16 v0, 0x3f000000    # 0.5f

    return v0

    .line 542
    :pswitch_2
    const v0, 0x3d4ccccd    # 0.05f

    return v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static createCue(Ljava/lang/String;Landroidx/media3/extractor/text/ssa/SsaStyle;Landroidx/media3/extractor/text/ssa/SsaStyle$Overrides;FF)Landroidx/media3/common/text/Cue;
    .locals 8
    .param p0, "text"    # Ljava/lang/String;
    .param p1, "style"    # Landroidx/media3/extractor/text/ssa/SsaStyle;
    .param p2, "styleOverrides"    # Landroidx/media3/extractor/text/ssa/SsaStyle$Overrides;
    .param p3, "screenWidth"    # F
    .param p4, "screenHeight"    # F

    .line 389
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, p0}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 390
    .local v0, "spannableText":Landroid/text/SpannableString;
    new-instance v1, Landroidx/media3/common/text/Cue$Builder;

    invoke-direct {v1}, Landroidx/media3/common/text/Cue$Builder;-><init>()V

    invoke-virtual {v1, v0}, Landroidx/media3/common/text/Cue$Builder;->setText(Ljava/lang/CharSequence;)Landroidx/media3/common/text/Cue$Builder;

    move-result-object v1

    .line 392
    .local v1, "cue":Landroidx/media3/common/text/Cue$Builder;
    const v2, -0x800001

    const/4 v3, 0x0

    if-eqz p1, :cond_7

    .line 393
    iget-object v4, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->primaryColor:Ljava/lang/Integer;

    const/16 v5, 0x21

    if-eqz v4, :cond_0

    .line 394
    new-instance v4, Landroid/text/style/ForegroundColorSpan;

    iget-object v6, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->primaryColor:Ljava/lang/Integer;

    .line 395
    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    invoke-direct {v4, v6}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    .line 397
    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v6

    .line 394
    invoke-virtual {v0, v4, v3, v6, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 400
    :cond_0
    iget v4, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->borderStyle:I

    const/4 v6, 0x3

    if-ne v4, v6, :cond_1

    iget-object v4, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->outlineColor:Ljava/lang/Integer;

    if-eqz v4, :cond_1

    .line 401
    new-instance v4, Landroid/text/style/BackgroundColorSpan;

    iget-object v7, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->outlineColor:Ljava/lang/Integer;

    .line 402
    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v7

    invoke-direct {v4, v7}, Landroid/text/style/BackgroundColorSpan;-><init>(I)V

    .line 404
    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v7

    .line 401
    invoke-virtual {v0, v4, v3, v7, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 407
    :cond_1
    iget v4, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->fontSize:F

    cmpl-float v4, v4, v2

    const/4 v7, 0x1

    if-eqz v4, :cond_2

    cmpl-float v4, p4, v2

    if-eqz v4, :cond_2

    .line 408
    iget v4, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->fontSize:F

    div-float/2addr v4, p4

    invoke-virtual {v1, v4, v7}, Landroidx/media3/common/text/Cue$Builder;->setTextSize(FI)Landroidx/media3/common/text/Cue$Builder;

    .line 411
    :cond_2
    iget-boolean v4, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->bold:Z

    if-eqz v4, :cond_3

    iget-boolean v4, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->italic:Z

    if-eqz v4, :cond_3

    .line 412
    new-instance v4, Landroid/text/style/StyleSpan;

    invoke-direct {v4, v6}, Landroid/text/style/StyleSpan;-><init>(I)V

    .line 415
    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v6

    .line 412
    invoke-virtual {v0, v4, v3, v6, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_0

    .line 417
    :cond_3
    iget-boolean v4, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->bold:Z

    if-eqz v4, :cond_4

    .line 418
    new-instance v4, Landroid/text/style/StyleSpan;

    invoke-direct {v4, v7}, Landroid/text/style/StyleSpan;-><init>(I)V

    .line 421
    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v6

    .line 418
    invoke-virtual {v0, v4, v3, v6, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_0

    .line 423
    :cond_4
    iget-boolean v4, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->italic:Z

    if-eqz v4, :cond_5

    .line 424
    new-instance v4, Landroid/text/style/StyleSpan;

    const/4 v6, 0x2

    invoke-direct {v4, v6}, Landroid/text/style/StyleSpan;-><init>(I)V

    .line 427
    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v6

    .line 424
    invoke-virtual {v0, v4, v3, v6, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 430
    :cond_5
    :goto_0
    iget-boolean v4, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->underline:Z

    if-eqz v4, :cond_6

    .line 431
    new-instance v4, Landroid/text/style/UnderlineSpan;

    invoke-direct {v4}, Landroid/text/style/UnderlineSpan;-><init>()V

    .line 434
    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v6

    .line 431
    invoke-virtual {v0, v4, v3, v6, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 437
    :cond_6
    iget-boolean v4, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->strikeout:Z

    if-eqz v4, :cond_7

    .line 438
    new-instance v4, Landroid/text/style/StrikethroughSpan;

    invoke-direct {v4}, Landroid/text/style/StrikethroughSpan;-><init>()V

    .line 441
    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v6

    .line 438
    invoke-virtual {v0, v4, v3, v6, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 447
    :cond_7
    iget v4, p2, Landroidx/media3/extractor/text/ssa/SsaStyle$Overrides;->alignment:I

    const/4 v5, -0x1

    if-eq v4, v5, :cond_8

    .line 448
    iget v4, p2, Landroidx/media3/extractor/text/ssa/SsaStyle$Overrides;->alignment:I

    .local v4, "alignment":I
    goto :goto_1

    .line 449
    .end local v4    # "alignment":I
    :cond_8
    if-eqz p1, :cond_9

    .line 450
    iget v4, p1, Landroidx/media3/extractor/text/ssa/SsaStyle;->alignment:I

    .restart local v4    # "alignment":I
    goto :goto_1

    .line 452
    .end local v4    # "alignment":I
    :cond_9
    const/4 v4, -0x1

    .line 454
    .restart local v4    # "alignment":I
    :goto_1
    invoke-static {v4}, Landroidx/media3/extractor/text/ssa/SsaParser;->toTextAlignment(I)Landroid/text/Layout$Alignment;

    move-result-object v5

    invoke-virtual {v1, v5}, Landroidx/media3/common/text/Cue$Builder;->setTextAlignment(Landroid/text/Layout$Alignment;)Landroidx/media3/common/text/Cue$Builder;

    move-result-object v5

    .line 455
    invoke-static {v4}, Landroidx/media3/extractor/text/ssa/SsaParser;->toPositionAnchor(I)I

    move-result v6

    invoke-virtual {v5, v6}, Landroidx/media3/common/text/Cue$Builder;->setPositionAnchor(I)Landroidx/media3/common/text/Cue$Builder;

    move-result-object v5

    .line 456
    invoke-static {v4}, Landroidx/media3/extractor/text/ssa/SsaParser;->toLineAnchor(I)I

    move-result v6

    invoke-virtual {v5, v6}, Landroidx/media3/common/text/Cue$Builder;->setLineAnchor(I)Landroidx/media3/common/text/Cue$Builder;

    .line 458
    iget-object v5, p2, Landroidx/media3/extractor/text/ssa/SsaStyle$Overrides;->position:Landroid/graphics/PointF;

    if-eqz v5, :cond_a

    cmpl-float v5, p4, v2

    if-eqz v5, :cond_a

    cmpl-float v2, p3, v2

    if-eqz v2, :cond_a

    .line 461
    iget-object v2, p2, Landroidx/media3/extractor/text/ssa/SsaStyle$Overrides;->position:Landroid/graphics/PointF;

    iget v2, v2, Landroid/graphics/PointF;->x:F

    div-float/2addr v2, p3

    invoke-virtual {v1, v2}, Landroidx/media3/common/text/Cue$Builder;->setPosition(F)Landroidx/media3/common/text/Cue$Builder;

    .line 462
    iget-object v2, p2, Landroidx/media3/extractor/text/ssa/SsaStyle$Overrides;->position:Landroid/graphics/PointF;

    iget v2, v2, Landroid/graphics/PointF;->y:F

    div-float/2addr v2, p4

    invoke-virtual {v1, v2, v3}, Landroidx/media3/common/text/Cue$Builder;->setLine(FI)Landroidx/media3/common/text/Cue$Builder;

    goto :goto_2

    .line 465
    :cond_a
    invoke-virtual {v1}, Landroidx/media3/common/text/Cue$Builder;->getPositionAnchor()I

    move-result v2

    invoke-static {v2}, Landroidx/media3/extractor/text/ssa/SsaParser;->computeDefaultLineOrPosition(I)F

    move-result v2

    invoke-virtual {v1, v2}, Landroidx/media3/common/text/Cue$Builder;->setPosition(F)Landroidx/media3/common/text/Cue$Builder;

    .line 466
    invoke-virtual {v1}, Landroidx/media3/common/text/Cue$Builder;->getLineAnchor()I

    move-result v2

    invoke-static {v2}, Landroidx/media3/extractor/text/ssa/SsaParser;->computeDefaultLineOrPosition(I)F

    move-result v2

    invoke-virtual {v1, v2, v3}, Landroidx/media3/common/text/Cue$Builder;->setLine(FI)Landroidx/media3/common/text/Cue$Builder;

    .line 469
    :goto_2
    invoke-virtual {v1}, Landroidx/media3/common/text/Cue$Builder;->build()Landroidx/media3/common/text/Cue;

    move-result-object v2

    return-object v2
.end method

.method private detectUtfCharset(Landroidx/media3/common/util/ParsableByteArray;)Ljava/nio/charset/Charset;
    .locals 2
    .param p1, "data"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 191
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readUtfCharsetFromBom()Ljava/nio/charset/Charset;

    move-result-object v0

    .line 192
    .local v0, "charset":Ljava/nio/charset/Charset;
    if-eqz v0, :cond_0

    move-object v1, v0

    goto :goto_0

    :cond_0
    sget-object v1, Lcom/google/common/base/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    :goto_0
    return-object v1
.end method

.method private parseDialogueLine(Ljava/lang/String;Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;Ljava/util/List;Ljava/util/List;)V
    .locals 18
    .param p1, "dialogueLine"    # Ljava/lang/String;
    .param p2, "format"    # Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;",
            "Ljava/util/List<",
            "Ljava/util/List<",
            "Landroidx/media3/common/text/Cue;",
            ">;>;",
            "Ljava/util/List<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .line 322
    .local p3, "cues":Ljava/util/List;, "Ljava/util/List<Ljava/util/List<Landroidx/media3/common/text/Cue;>;>;"
    .local p4, "cueTimesUs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move-object/from16 v4, p4

    const-string v5, "Dialogue:"

    invoke-virtual {v1, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    invoke-static {v6}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 323
    nop

    .line 324
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    invoke-virtual {v1, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    const-string v6, ","

    iget v7, v2, Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;->length:I

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v5

    .line 325
    .local v5, "lineValues":[Ljava/lang/String;
    array-length v6, v5

    iget v7, v2, Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;->length:I

    const-string v8, "SsaParser"

    if-eq v6, v7, :cond_0

    .line 326
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Skipping dialogue line with fewer columns than format: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v8, v6}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 327
    return-void

    .line 330
    :cond_0
    iget v6, v2, Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;->startTimeIndex:I

    aget-object v6, v5, v6

    invoke-static {v6}, Landroidx/media3/extractor/text/ssa/SsaParser;->parseTimecodeUs(Ljava/lang/String;)J

    move-result-wide v6

    .line 331
    .local v6, "startTimeUs":J
    const-wide v9, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v11, v6, v9

    const-string v12, "Skipping invalid timing: "

    if-nez v11, :cond_1

    .line 332
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 333
    return-void

    .line 336
    :cond_1
    iget v11, v2, Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;->endTimeIndex:I

    aget-object v11, v5, v11

    invoke-static {v11}, Landroidx/media3/extractor/text/ssa/SsaParser;->parseTimecodeUs(Ljava/lang/String;)J

    move-result-wide v13

    .line 337
    .local v13, "endTimeUs":J
    cmp-long v9, v13, v9

    if-nez v9, :cond_2

    .line 338
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 339
    return-void

    .line 344
    :cond_2
    iget-object v8, v0, Landroidx/media3/extractor/text/ssa/SsaParser;->styles:Ljava/util/Map;

    if-eqz v8, :cond_3

    iget v8, v2, Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;->styleIndex:I

    const/4 v9, -0x1

    if-eq v8, v9, :cond_3

    .line 345
    iget-object v8, v0, Landroidx/media3/extractor/text/ssa/SsaParser;->styles:Ljava/util/Map;

    iget v9, v2, Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;->styleIndex:I

    aget-object v9, v5, v9

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v8, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroidx/media3/extractor/text/ssa/SsaStyle;

    goto :goto_0

    .line 346
    :cond_3
    const/4 v8, 0x0

    :goto_0
    nop

    .line 347
    .local v8, "style":Landroidx/media3/extractor/text/ssa/SsaStyle;
    iget v9, v2, Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;->textIndex:I

    aget-object v9, v5, v9

    .line 348
    .local v9, "rawText":Ljava/lang/String;
    invoke-static {v9}, Landroidx/media3/extractor/text/ssa/SsaStyle$Overrides;->parseFromDialogue(Ljava/lang/String;)Landroidx/media3/extractor/text/ssa/SsaStyle$Overrides;

    move-result-object v10

    .line 349
    .local v10, "styleOverrides":Landroidx/media3/extractor/text/ssa/SsaStyle$Overrides;
    nop

    .line 350
    invoke-static {v9}, Landroidx/media3/extractor/text/ssa/SsaStyle$Overrides;->stripStyleOverrides(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 351
    const-string v12, "\\N"

    const-string v15, "\n"

    invoke-virtual {v11, v12, v15}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v11

    .line 352
    const-string v12, "\\n"

    invoke-virtual {v11, v12, v15}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v11

    .line 353
    const-string v12, "\\h"

    const-string/jumbo v15, "\u00a0"

    invoke-virtual {v11, v12, v15}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v11

    .line 354
    .local v11, "text":Ljava/lang/String;
    iget v12, v0, Landroidx/media3/extractor/text/ssa/SsaParser;->screenWidth:F

    iget v15, v0, Landroidx/media3/extractor/text/ssa/SsaParser;->screenHeight:F

    invoke-static {v11, v8, v10, v12, v15}, Landroidx/media3/extractor/text/ssa/SsaParser;->createCue(Ljava/lang/String;Landroidx/media3/extractor/text/ssa/SsaStyle;Landroidx/media3/extractor/text/ssa/SsaStyle$Overrides;FF)Landroidx/media3/common/text/Cue;

    move-result-object v12

    .line 356
    .local v12, "cue":Landroidx/media3/common/text/Cue;
    invoke-static {v6, v7, v4, v3}, Landroidx/media3/extractor/text/ssa/SsaParser;->addCuePlacerholderByTime(JLjava/util/List;Ljava/util/List;)I

    move-result v15

    .line 357
    .local v15, "startTimeIndex":I
    invoke-static {v13, v14, v4, v3}, Landroidx/media3/extractor/text/ssa/SsaParser;->addCuePlacerholderByTime(JLjava/util/List;Ljava/util/List;)I

    move-result v0

    .line 359
    .local v0, "endTimeIndex":I
    move/from16 v16, v15

    move/from16 v1, v16

    .local v1, "i":I
    :goto_1
    if-ge v1, v0, :cond_4

    .line 360
    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v16

    move/from16 v17, v0

    .end local v0    # "endTimeIndex":I
    .local v17, "endTimeIndex":I
    move-object/from16 v0, v16

    check-cast v0, Ljava/util/List;

    invoke-interface {v0, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 359
    add-int/lit8 v1, v1, 0x1

    move/from16 v0, v17

    goto :goto_1

    .line 362
    .end local v1    # "i":I
    .end local v17    # "endTimeIndex":I
    .restart local v0    # "endTimeIndex":I
    :cond_4
    return-void
.end method

.method private parseEventBody(Landroidx/media3/common/util/ParsableByteArray;Ljava/util/List;Ljava/util/List;Ljava/nio/charset/Charset;)V
    .locals 4
    .param p1, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p4, "charset"    # Ljava/nio/charset/Charset;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/util/ParsableByteArray;",
            "Ljava/util/List<",
            "Ljava/util/List<",
            "Landroidx/media3/common/text/Cue;",
            ">;>;",
            "Ljava/util/List<",
            "Ljava/lang/Long;",
            ">;",
            "Ljava/nio/charset/Charset;",
            ")V"
        }
    .end annotation

    .line 297
    .local p2, "cues":Ljava/util/List;, "Ljava/util/List<Ljava/util/List<Landroidx/media3/common/text/Cue;>;>;"
    .local p3, "cueTimesUs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    iget-boolean v0, p0, Landroidx/media3/extractor/text/ssa/SsaParser;->haveInitializationData:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/extractor/text/ssa/SsaParser;->dialogueFormatFromInitializationData:Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 299
    .local v0, "format":Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;
    :cond_1
    :goto_0
    invoke-virtual {p1, p4}, Landroidx/media3/common/util/ParsableByteArray;->readLine(Ljava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object v1

    move-object v2, v1

    .local v2, "currentLine":Ljava/lang/String;
    if-eqz v1, :cond_4

    .line 300
    const-string v1, "Format:"

    invoke-virtual {v2, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 301
    invoke-static {v2}, Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;->fromFormatLine(Ljava/lang/String;)Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;

    move-result-object v0

    goto :goto_0

    .line 302
    :cond_2
    const-string v1, "Dialogue:"

    invoke-virtual {v2, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 303
    if-nez v0, :cond_3

    .line 304
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Skipping dialogue line before complete format: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v3, "SsaParser"

    invoke-static {v3, v1}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 305
    goto :goto_0

    .line 307
    :cond_3
    invoke-direct {p0, v2, v0, p2, p3}, Landroidx/media3/extractor/text/ssa/SsaParser;->parseDialogueLine(Ljava/lang/String;Landroidx/media3/extractor/text/ssa/SsaDialogueFormat;Ljava/util/List;Ljava/util/List;)V

    goto :goto_0

    .line 310
    :cond_4
    return-void
.end method

.method private parseHeader(Landroidx/media3/common/util/ParsableByteArray;Ljava/nio/charset/Charset;)V
    .locals 3
    .param p1, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p2, "charset"    # Ljava/nio/charset/Charset;

    .line 203
    nop

    :cond_0
    :goto_0
    invoke-virtual {p1, p2}, Landroidx/media3/common/util/ParsableByteArray;->readLine(Ljava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .local v1, "currentLine":Ljava/lang/String;
    if-eqz v0, :cond_4

    .line 204
    const-string v0, "[Script Info]"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 205
    invoke-direct {p0, p1, p2}, Landroidx/media3/extractor/text/ssa/SsaParser;->parseScriptInfo(Landroidx/media3/common/util/ParsableByteArray;Ljava/nio/charset/Charset;)V

    goto :goto_0

    .line 206
    :cond_1
    const-string v0, "[V4+ Styles]"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 207
    invoke-static {p1, p2}, Landroidx/media3/extractor/text/ssa/SsaParser;->parseStyles(Landroidx/media3/common/util/ParsableByteArray;Ljava/nio/charset/Charset;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/text/ssa/SsaParser;->styles:Ljava/util/Map;

    goto :goto_0

    .line 208
    :cond_2
    const-string v0, "[V4 Styles]"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 209
    const-string v0, "SsaParser"

    const-string v2, "[V4 Styles] are not supported"

    invoke-static {v0, v2}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 210
    :cond_3
    const-string v0, "[Events]"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 212
    return-void

    .line 215
    :cond_4
    return-void
.end method

.method private parseScriptInfo(Landroidx/media3/common/util/ParsableByteArray;Ljava/nio/charset/Charset;)V
    .locals 6
    .param p1, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p2, "charset"    # Ljava/nio/charset/Charset;

    .line 229
    nop

    :goto_0
    invoke-virtual {p1, p2}, Landroidx/media3/common/util/ParsableByteArray;->readLine(Ljava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .local v1, "currentLine":Ljava/lang/String;
    if-eqz v0, :cond_3

    .line 230
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1, p2}, Landroidx/media3/common/util/ParsableByteArray;->peekChar(Ljava/nio/charset/Charset;)C

    move-result v0

    const/16 v2, 0x5b

    if-eq v0, v2, :cond_3

    .line 231
    :cond_0
    const-string v0, ":"

    invoke-virtual {v1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 232
    .local v0, "infoNameAndValue":[Ljava/lang/String;
    array-length v2, v0

    const/4 v3, 0x2

    if-eq v2, v3, :cond_1

    .line 233
    goto :goto_0

    .line 235
    :cond_1
    const/4 v2, 0x0

    aget-object v3, v0, v2

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/google/common/base/Ascii;->toLowerCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v4

    const/4 v5, 0x1

    packed-switch v4, :pswitch_data_0

    :cond_2
    goto :goto_1

    :pswitch_0
    const-string/jumbo v2, "playresy"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v5

    goto :goto_2

    :pswitch_1
    const-string/jumbo v4, "playresx"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    goto :goto_2

    :goto_1
    const/4 v2, -0x1

    :goto_2
    packed-switch v2, :pswitch_data_1

    goto :goto_3

    .line 245
    :pswitch_2
    :try_start_0
    aget-object v2, v0, v5

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v2

    iput v2, p0, Landroidx/media3/extractor/text/ssa/SsaParser;->screenHeight:F
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 248
    goto :goto_3

    .line 246
    :catch_0
    move-exception v2

    goto :goto_3

    .line 238
    :pswitch_3
    :try_start_1
    aget-object v2, v0, v5

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v2

    iput v2, p0, Landroidx/media3/extractor/text/ssa/SsaParser;->screenWidth:F
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    .line 241
    goto :goto_3

    .line 239
    :catch_1
    move-exception v2

    .line 242
    nop

    .line 251
    .end local v0    # "infoNameAndValue":[Ljava/lang/String;
    :goto_3
    goto :goto_0

    .line 252
    :cond_3
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x70092d0c
        :pswitch_1
        :pswitch_0
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_3
        :pswitch_2
    .end packed-switch
.end method

.method private static parseStyles(Landroidx/media3/common/util/ParsableByteArray;Ljava/nio/charset/Charset;)Ljava/util/Map;
    .locals 5
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "charset"    # Ljava/nio/charset/Charset;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/util/ParsableByteArray;",
            "Ljava/nio/charset/Charset;",
            ")",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/media3/extractor/text/ssa/SsaStyle;",
            ">;"
        }
    .end annotation

    .line 265
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    .line 266
    .local v0, "styles":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroidx/media3/extractor/text/ssa/SsaStyle;>;"
    const/4 v1, 0x0

    .line 268
    .local v1, "formatInfo":Landroidx/media3/extractor/text/ssa/SsaStyle$Format;
    :cond_0
    :goto_0
    invoke-virtual {p0, p1}, Landroidx/media3/common/util/ParsableByteArray;->readLine(Ljava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object v2

    move-object v3, v2

    .local v3, "currentLine":Ljava/lang/String;
    if-eqz v2, :cond_5

    .line 269
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v2

    if-eqz v2, :cond_1

    invoke-virtual {p0, p1}, Landroidx/media3/common/util/ParsableByteArray;->peekChar(Ljava/nio/charset/Charset;)C

    move-result v2

    const/16 v4, 0x5b

    if-eq v2, v4, :cond_5

    .line 270
    :cond_1
    const-string v2, "Format:"

    invoke-virtual {v3, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 271
    invoke-static {v3}, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;->fromFormatLine(Ljava/lang/String;)Landroidx/media3/extractor/text/ssa/SsaStyle$Format;

    move-result-object v1

    goto :goto_0

    .line 272
    :cond_2
    const-string v2, "Style:"

    invoke-virtual {v3, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 273
    if-nez v1, :cond_3

    .line 274
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Skipping \'Style:\' line before \'Format:\' line: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v4, "SsaParser"

    invoke-static {v4, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 275
    goto :goto_0

    .line 277
    :cond_3
    invoke-static {v3, v1}, Landroidx/media3/extractor/text/ssa/SsaStyle;->fromStyleLine(Ljava/lang/String;Landroidx/media3/extractor/text/ssa/SsaStyle$Format;)Landroidx/media3/extractor/text/ssa/SsaStyle;

    move-result-object v2

    .line 278
    .local v2, "style":Landroidx/media3/extractor/text/ssa/SsaStyle;
    if-eqz v2, :cond_4

    .line 279
    iget-object v4, v2, Landroidx/media3/extractor/text/ssa/SsaStyle;->name:Ljava/lang/String;

    invoke-interface {v0, v4, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 281
    .end local v2    # "style":Landroidx/media3/extractor/text/ssa/SsaStyle;
    :cond_4
    goto :goto_0

    .line 283
    :cond_5
    return-object v0
.end method

.method private static parseTimecodeUs(Ljava/lang/String;)J
    .locals 9
    .param p0, "timeString"    # Ljava/lang/String;

    .line 371
    sget-object v0, Landroidx/media3/extractor/text/ssa/SsaParser;->SSA_TIMECODE_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 372
    .local v0, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v1

    if-nez v1, :cond_0

    .line 373
    const-wide v1, -0x7fffffffffffffffL    # -4.9E-324

    return-wide v1

    .line 375
    :cond_0
    nop

    .line 376
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v1

    const-wide/16 v3, 0x3c

    mul-long/2addr v1, v3

    mul-long/2addr v1, v3

    const-wide/32 v5, 0xf4240

    mul-long/2addr v1, v5

    .line 377
    .local v1, "timestampUs":J
    const/4 v7, 0x2

    invoke-virtual {v0, v7}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-static {v7}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v7

    mul-long/2addr v7, v3

    mul-long/2addr v7, v5

    add-long/2addr v1, v7

    .line 378
    const/4 v3, 0x3

    invoke-virtual {v0, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    mul-long/2addr v3, v5

    add-long/2addr v1, v3

    .line 379
    const/4 v3, 0x4

    invoke-virtual {v0, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    const-wide/16 v5, 0x2710

    mul-long/2addr v3, v5

    add-long/2addr v1, v3

    .line 380
    return-wide v1
.end method

.method private static toLineAnchor(I)I
    .locals 3
    .param p0, "alignment"    # I

    .line 496
    const/high16 v0, -0x80000000

    packed-switch p0, :pswitch_data_0

    .line 512
    :pswitch_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown alignment: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "SsaParser"

    invoke-static {v2, v1}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 513
    return v0

    .line 508
    :pswitch_1
    const/4 v0, 0x0

    return v0

    .line 504
    :pswitch_2
    const/4 v0, 0x1

    return v0

    .line 500
    :pswitch_3
    const/4 v0, 0x2

    return v0

    .line 510
    :pswitch_4
    return v0

    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_4
        :pswitch_0
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_1
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method private static toPositionAnchor(I)I
    .locals 3
    .param p0, "alignment"    # I

    .line 518
    const/high16 v0, -0x80000000

    packed-switch p0, :pswitch_data_0

    .line 534
    :pswitch_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown alignment: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "SsaParser"

    invoke-static {v2, v1}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 535
    return v0

    .line 530
    :pswitch_1
    const/4 v0, 0x2

    return v0

    .line 526
    :pswitch_2
    const/4 v0, 0x1

    return v0

    .line 522
    :pswitch_3
    const/4 v0, 0x0

    return v0

    .line 532
    :pswitch_4
    return v0

    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_4
        :pswitch_0
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private static toTextAlignment(I)Landroid/text/Layout$Alignment;
    .locals 3
    .param p0, "alignment"    # I

    .line 474
    const/4 v0, 0x0

    packed-switch p0, :pswitch_data_0

    .line 490
    :pswitch_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown alignment: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "SsaParser"

    invoke-static {v2, v1}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 491
    return-object v0

    .line 486
    :pswitch_1
    sget-object v0, Landroid/text/Layout$Alignment;->ALIGN_OPPOSITE:Landroid/text/Layout$Alignment;

    return-object v0

    .line 482
    :pswitch_2
    sget-object v0, Landroid/text/Layout$Alignment;->ALIGN_CENTER:Landroid/text/Layout$Alignment;

    return-object v0

    .line 478
    :pswitch_3
    sget-object v0, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    return-object v0

    .line 488
    :pswitch_4
    return-object v0

    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_4
        :pswitch_0
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public getCueReplacementBehavior()I
    .locals 1

    .line 131
    const/4 v0, 0x1

    return v0
.end method

.method public parse([BIILandroidx/media3/extractor/text/SubtitleParser$OutputOptions;Landroidx/media3/common/util/Consumer;)V
    .locals 23
    .param p1, "data"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .param p4, "outputOptions"    # Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([BII",
            "Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;",
            "Landroidx/media3/common/util/Consumer<",
            "Landroidx/media3/extractor/text/CuesWithTiming;",
            ">;)V"
        }
    .end annotation

    .line 141
    .local p5, "output":Landroidx/media3/common/util/Consumer;, "Landroidx/media3/common/util/Consumer<Landroidx/media3/extractor/text/CuesWithTiming;>;"
    move-object/from16 v0, p0

    move/from16 v1, p2

    move-object/from16 v2, p4

    move-object/from16 v3, p5

    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 142
    .local v4, "cues":Ljava/util/List;, "Ljava/util/List<Ljava/util/List<Landroidx/media3/common/text/Cue;>;>;"
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 144
    .local v5, "startTimesUs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    iget-object v6, v0, Landroidx/media3/extractor/text/ssa/SsaParser;->parsableByteArray:Landroidx/media3/common/util/ParsableByteArray;

    add-int v7, v1, p3

    move-object/from16 v8, p1

    invoke-virtual {v6, v8, v7}, Landroidx/media3/common/util/ParsableByteArray;->reset([BI)V

    .line 145
    iget-object v6, v0, Landroidx/media3/extractor/text/ssa/SsaParser;->parsableByteArray:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 146
    iget-object v6, v0, Landroidx/media3/extractor/text/ssa/SsaParser;->parsableByteArray:Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {v0, v6}, Landroidx/media3/extractor/text/ssa/SsaParser;->detectUtfCharset(Landroidx/media3/common/util/ParsableByteArray;)Ljava/nio/charset/Charset;

    move-result-object v6

    .line 148
    .local v6, "charset":Ljava/nio/charset/Charset;
    iget-boolean v7, v0, Landroidx/media3/extractor/text/ssa/SsaParser;->haveInitializationData:Z

    if-nez v7, :cond_0

    .line 149
    iget-object v7, v0, Landroidx/media3/extractor/text/ssa/SsaParser;->parsableByteArray:Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {v0, v7, v6}, Landroidx/media3/extractor/text/ssa/SsaParser;->parseHeader(Landroidx/media3/common/util/ParsableByteArray;Ljava/nio/charset/Charset;)V

    .line 151
    :cond_0
    iget-object v7, v0, Landroidx/media3/extractor/text/ssa/SsaParser;->parsableByteArray:Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {v0, v7, v4, v5, v6}, Landroidx/media3/extractor/text/ssa/SsaParser;->parseEventBody(Landroidx/media3/common/util/ParsableByteArray;Ljava/util/List;Ljava/util/List;Ljava/nio/charset/Charset;)V

    .line 155
    iget-wide v9, v2, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    const-wide v11, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v7, v9, v11

    if-eqz v7, :cond_1

    iget-boolean v7, v2, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->outputAllCues:Z

    if-eqz v7, :cond_1

    .line 156
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0

    .line 157
    :cond_1
    const/4 v7, 0x0

    :goto_0
    nop

    .line 158
    .local v7, "cuesWithTimingBeforeRequestedStartTimeUs":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/extractor/text/CuesWithTiming;>;"
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_1
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v10

    if-ge v9, v10, :cond_7

    .line 159
    invoke-interface {v4, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/util/List;

    .line 160
    .local v10, "cuesForThisStartTime":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/text/Cue;>;"
    invoke-interface {v10}, Ljava/util/List;->isEmpty()Z

    move-result v13

    if-eqz v13, :cond_2

    if-eqz v9, :cond_2

    .line 163
    goto :goto_3

    .line 164
    :cond_2
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v13

    add-int/lit8 v13, v13, -0x1

    if-eq v9, v13, :cond_6

    .line 168
    invoke-interface {v5, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/Long;

    invoke-virtual {v13}, Ljava/lang/Long;->longValue()J

    move-result-wide v19

    .line 170
    .local v19, "startTimeUs":J
    add-int/lit8 v13, v9, 0x1

    invoke-interface {v5, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/Long;

    invoke-virtual {v13}, Ljava/lang/Long;->longValue()J

    move-result-wide v13

    invoke-interface {v5, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/Long;

    invoke-virtual {v15}, Ljava/lang/Long;->longValue()J

    move-result-wide v15

    sub-long v21, v13, v15

    .line 171
    .local v21, "durationUs":J
    iget-wide v13, v2, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    cmp-long v13, v13, v11

    if-eqz v13, :cond_4

    iget-wide v13, v2, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    cmp-long v13, v19, v13

    if-ltz v13, :cond_3

    goto :goto_2

    .line 174
    :cond_3
    if-eqz v7, :cond_5

    .line 175
    new-instance v15, Landroidx/media3/extractor/text/CuesWithTiming;

    move-object v13, v15

    move-object v14, v10

    move-object v11, v15

    move-wide/from16 v15, v19

    move-wide/from16 v17, v21

    invoke-direct/range {v13 .. v18}, Landroidx/media3/extractor/text/CuesWithTiming;-><init>(Ljava/util/List;JJ)V

    invoke-interface {v7, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 172
    :cond_4
    :goto_2
    new-instance v11, Landroidx/media3/extractor/text/CuesWithTiming;

    move-object v13, v11

    move-object v14, v10

    move-wide/from16 v15, v19

    move-wide/from16 v17, v21

    invoke-direct/range {v13 .. v18}, Landroidx/media3/extractor/text/CuesWithTiming;-><init>(Ljava/util/List;JJ)V

    invoke-interface {v3, v11}, Landroidx/media3/common/util/Consumer;->accept(Ljava/lang/Object;)V

    .line 158
    .end local v10    # "cuesForThisStartTime":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/text/Cue;>;"
    .end local v19    # "startTimeUs":J
    .end local v21    # "durationUs":J
    :cond_5
    :goto_3
    add-int/lit8 v9, v9, 0x1

    const-wide v11, -0x7fffffffffffffffL    # -4.9E-324

    goto :goto_1

    .line 166
    .restart local v10    # "cuesForThisStartTime":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/text/Cue;>;"
    :cond_6
    new-instance v11, Ljava/lang/IllegalStateException;

    invoke-direct {v11}, Ljava/lang/IllegalStateException;-><init>()V

    throw v11

    .line 179
    .end local v9    # "i":I
    .end local v10    # "cuesForThisStartTime":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/text/Cue;>;"
    :cond_7
    if-eqz v7, :cond_8

    .line 180
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_4
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_8

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroidx/media3/extractor/text/CuesWithTiming;

    .line 181
    .local v10, "cuesWithTiming":Landroidx/media3/extractor/text/CuesWithTiming;
    invoke-interface {v3, v10}, Landroidx/media3/common/util/Consumer;->accept(Ljava/lang/Object;)V

    .line 182
    .end local v10    # "cuesWithTiming":Landroidx/media3/extractor/text/CuesWithTiming;
    goto :goto_4

    .line 184
    :cond_8
    return-void
.end method
