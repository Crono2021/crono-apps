.class public final Lcoil/compose/ContentPainterModifier;
.super Landroidx/compose/ui/platform/InspectorValueInfo;
.source "ContentPainterModifier.kt"

# interfaces
.implements Landroidx/compose/ui/layout/LayoutModifier;
.implements Landroidx/compose/ui/draw/DrawModifier;


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nContentPainterModifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContentPainterModifier.kt\ncoil/compose/ContentPainterModifier\n+ 2 InspectableValue.kt\nandroidx/compose/ui/platform/InspectableValueKt\n+ 3 Size.kt\nandroidx/compose/ui/geometry/SizeKt\n+ 4 Utils.kt\ncoil/compose/UtilsKt\n+ 5 Size.kt\nandroidx/compose/ui/geometry/Size\n+ 6 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n1#1,205:1\n135#2:206\n152#3:207\n152#3:208\n152#3:209\n152#3:210\n159#3:211\n159#3:214\n87#4:212\n87#4:213\n66#5:215\n70#5:216\n66#5,5:217\n120#6,4:222\n*S KotlinDebug\n*F\n+ 1 ContentPainterModifier.kt\ncoil/compose/ContentPainterModifier\n*L\n38#1:206\n62#1:207\n76#1:208\n90#1:209\n104#1:210\n120#1:211\n147#1:214\n125#1:212\n126#1:213\n165#1:215\n167#1:216\n179#1:217,5\n195#1:222,4\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0080\u0008\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\u0008\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0005H\u00c2\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c2\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c2\u0003J\t\u0010\u0017\u001a\u00020\u000bH\u00c2\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u00c2\u0003J=\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\rH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\u001d\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\u0008#\u0010\u0013J\t\u0010$\u001a\u00020%H\u00d6\u0001J\u000c\u0010&\u001a\u00020\'*\u00020(H\u0016J\u001c\u0010)\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u001c\u0010.\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u00020\u001fH\u0016J)\u00100\u001a\u000201*\u0002022\u0006\u0010+\u001a\u0002032\u0006\u0010\"\u001a\u00020!H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\u00084\u00105J\u001c\u00106\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u001c\u00107\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u00020\u001fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008\u00a1\u001e0\u0001\n\u0002\u0008\u0019\u00a8\u00068"
    }
    d2 = {
        "Lcoil/compose/ContentPainterModifier;",
        "Landroidx/compose/ui/layout/LayoutModifier;",
        "Landroidx/compose/ui/draw/DrawModifier;",
        "Landroidx/compose/ui/platform/InspectorValueInfo;",
        "painter",
        "Landroidx/compose/ui/graphics/painter/Painter;",
        "alignment",
        "Landroidx/compose/ui/Alignment;",
        "contentScale",
        "Landroidx/compose/ui/layout/ContentScale;",
        "alpha",
        "",
        "colorFilter",
        "Landroidx/compose/ui/graphics/ColorFilter;",
        "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V",
        "calculateScaledSize",
        "Landroidx/compose/ui/geometry/Size;",
        "dstSize",
        "calculateScaledSize-E7KxVPU",
        "(J)J",
        "component1",
        "component2",
        "component3",
        "component4",
        "component5",
        "copy",
        "equals",
        "",
        "other",
        "",
        "hashCode",
        "",
        "modifyConstraints",
        "Landroidx/compose/ui/unit/Constraints;",
        "constraints",
        "modifyConstraints-ZezNO4M",
        "toString",
        "",
        "draw",
        "",
        "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;",
        "maxIntrinsicHeight",
        "Landroidx/compose/ui/layout/IntrinsicMeasureScope;",
        "measurable",
        "Landroidx/compose/ui/layout/IntrinsicMeasurable;",
        "width",
        "maxIntrinsicWidth",
        "height",
        "measure",
        "Landroidx/compose/ui/layout/MeasureResult;",
        "Landroidx/compose/ui/layout/MeasureScope;",
        "Landroidx/compose/ui/layout/Measurable;",
        "measure-3p2s80s",
        "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;",
        "minIntrinsicHeight",
        "minIntrinsicWidth",
        "coil-compose-base_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field private final alignment:Landroidx/compose/ui/Alignment;

.field private final alpha:F

.field private final colorFilter:Landroidx/compose/ui/graphics/ColorFilter;

.field private final contentScale:Landroidx/compose/ui/layout/ContentScale;

.field private final painter:Landroidx/compose/ui/graphics/painter/Painter;


# direct methods
.method public constructor <init>(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V
    .locals 8
    .param p1, "painter"    # Landroidx/compose/ui/graphics/painter/Painter;
    .param p2, "alignment"    # Landroidx/compose/ui/Alignment;
    .param p3, "contentScale"    # Landroidx/compose/ui/layout/ContentScale;
    .param p4, "alpha"    # F
    .param p5, "colorFilter"    # Landroidx/compose/ui/graphics/ColorFilter;

    .line 37
    nop

    .line 38
    const/4 v0, 0x0

    .line 206
    .local v0, "$i$f$debugInspectorInfo":I
    invoke-static {}, Landroidx/compose/ui/platform/InspectableValueKt;->isDebugInspectorInfoEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    new-instance v1, Lcoil/compose/ContentPainterModifier$special$$inlined$debugInspectorInfo$1;

    move-object v2, v1

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    move v6, p4

    move-object v7, p5

    invoke-direct/range {v2 .. v7}, Lcoil/compose/ContentPainterModifier$special$$inlined$debugInspectorInfo$1;-><init>(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V

    check-cast v1, Lkotlin/jvm/functions/Function1;

    goto :goto_0

    :cond_0
    invoke-static {}, Landroidx/compose/ui/platform/InspectableValueKt;->getNoInspectorInfo()Lkotlin/jvm/functions/Function1;

    move-result-object v1

    .line 37
    .end local v0    # "$i$f$debugInspectorInfo":I
    :goto_0
    invoke-direct {p0, v1}, Landroidx/compose/ui/platform/InspectorValueInfo;-><init>(Lkotlin/jvm/functions/Function1;)V

    .line 32
    iput-object p1, p0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    .line 33
    iput-object p2, p0, Lcoil/compose/ContentPainterModifier;->alignment:Landroidx/compose/ui/Alignment;

    .line 34
    iput-object p3, p0, Lcoil/compose/ContentPainterModifier;->contentScale:Landroidx/compose/ui/layout/ContentScale;

    .line 35
    iput p4, p0, Lcoil/compose/ContentPainterModifier;->alpha:F

    .line 36
    iput-object p5, p0, Lcoil/compose/ContentPainterModifier;->colorFilter:Landroidx/compose/ui/graphics/ColorFilter;

    .line 31
    return-void
.end method

.method private final calculateScaledSize-E7KxVPU(J)J
    .locals 10
    .param p1, "dstSize"    # J

    .line 115
    invoke-static {p1, p2}, Landroidx/compose/ui/geometry/Size;->isEmpty-impl(J)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 116
    sget-object v0, Landroidx/compose/ui/geometry/Size;->Companion:Landroidx/compose/ui/geometry/Size$Companion;

    invoke-virtual {v0}, Landroidx/compose/ui/geometry/Size$Companion;->getZero-NH-jbRc()J

    move-result-wide v0

    return-wide v0

    .line 119
    :cond_0
    iget-object v0, p0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    invoke-virtual {v0}, Landroidx/compose/ui/graphics/painter/Painter;->getIntrinsicSize-NH-jbRc()J

    move-result-wide v0

    .line 120
    .local v0, "intrinsicSize":J
    move-wide v2, v0

    .local v2, "$this$isUnspecified$iv":J
    const/4 v4, 0x0

    .line 211
    .local v4, "$i$f$isUnspecified-uvyYCjk":I
    sget-object v5, Landroidx/compose/ui/geometry/Size;->Companion:Landroidx/compose/ui/geometry/Size$Companion;

    invoke-virtual {v5}, Landroidx/compose/ui/geometry/Size$Companion;->getUnspecified-NH-jbRc()J

    move-result-wide v5

    cmp-long v5, v2, v5

    const/4 v6, 0x1

    const/4 v7, 0x0

    if-nez v5, :cond_1

    move v2, v6

    goto :goto_0

    :cond_1
    move v2, v7

    .line 120
    .end local v2    # "$this$isUnspecified$iv":J
    .end local v4    # "$i$f$isUnspecified-uvyYCjk":I
    :goto_0
    if-eqz v2, :cond_2

    .line 121
    return-wide p1

    .line 125
    :cond_2
    invoke-static {v0, v1}, Landroidx/compose/ui/geometry/Size;->getWidth-impl(J)F

    move-result v2

    .local v2, "$this$takeOrElse$iv":F
    const/4 v3, 0x0

    .line 212
    .local v3, "$i$f$takeOrElse":I
    invoke-static {v2}, Ljava/lang/Float;->isInfinite(F)Z

    move-result v4

    if-nez v4, :cond_3

    invoke-static {v2}, Ljava/lang/Float;->isNaN(F)Z

    move-result v4

    if-nez v4, :cond_3

    move v4, v6

    goto :goto_1

    :cond_3
    move v4, v7

    :goto_1
    if-eqz v4, :cond_4

    goto :goto_2

    :cond_4
    const/4 v4, 0x0

    .line 125
    .local v4, "$i$a$-takeOrElse-ContentPainterModifier$calculateScaledSize$srcSize$1":I
    invoke-static {p1, p2}, Landroidx/compose/ui/geometry/Size;->getWidth-impl(J)F

    move-result v4

    .line 212
    .end local v4    # "$i$a$-takeOrElse-ContentPainterModifier$calculateScaledSize$srcSize$1":I
    move v2, v4

    .line 126
    .end local v2    # "$this$takeOrElse$iv":F
    .end local v3    # "$i$f$takeOrElse":I
    :goto_2
    invoke-static {v0, v1}, Landroidx/compose/ui/geometry/Size;->getHeight-impl(J)F

    move-result v3

    .local v3, "$this$takeOrElse$iv":F
    const/4 v4, 0x0

    .line 213
    .local v4, "$i$f$takeOrElse":I
    invoke-static {v3}, Ljava/lang/Float;->isInfinite(F)Z

    move-result v5

    if-nez v5, :cond_5

    invoke-static {v3}, Ljava/lang/Float;->isNaN(F)Z

    move-result v5

    if-nez v5, :cond_5

    move v5, v6

    goto :goto_3

    :cond_5
    move v5, v7

    :goto_3
    if-eqz v5, :cond_6

    goto :goto_4

    :cond_6
    const/4 v5, 0x0

    .line 126
    .local v5, "$i$a$-takeOrElse-ContentPainterModifier$calculateScaledSize$srcSize$2":I
    invoke-static {p1, p2}, Landroidx/compose/ui/geometry/Size;->getHeight-impl(J)F

    move-result v5

    .line 213
    .end local v5    # "$i$a$-takeOrElse-ContentPainterModifier$calculateScaledSize$srcSize$2":I
    move v3, v5

    .line 124
    .end local v3    # "$this$takeOrElse$iv":F
    .end local v4    # "$i$f$takeOrElse":I
    :goto_4
    invoke-static {v2, v3}, Landroidx/compose/ui/geometry/SizeKt;->Size(FF)J

    move-result-wide v2

    .line 128
    .local v2, "srcSize":J
    iget-object v4, p0, Lcoil/compose/ContentPainterModifier;->contentScale:Landroidx/compose/ui/layout/ContentScale;

    invoke-interface {v4, v2, v3, p1, p2}, Landroidx/compose/ui/layout/ContentScale;->computeScaleFactor-H7hwNQA(JJ)J

    move-result-wide v4

    .line 129
    .local v4, "scaleFactor":J
    invoke-static {v4, v5}, Landroidx/compose/ui/layout/ScaleFactor;->getScaleX-impl(J)F

    move-result v8

    invoke-static {v8}, Ljava/lang/Float;->isInfinite(F)Z

    move-result v9

    if-nez v9, :cond_7

    invoke-static {v8}, Ljava/lang/Float;->isNaN(F)Z

    move-result v8

    if-nez v8, :cond_7

    move v8, v6

    goto :goto_5

    :cond_7
    move v8, v7

    :goto_5
    if-eqz v8, :cond_a

    invoke-static {v4, v5}, Landroidx/compose/ui/layout/ScaleFactor;->getScaleY-impl(J)F

    move-result v8

    invoke-static {v8}, Ljava/lang/Float;->isInfinite(F)Z

    move-result v9

    if-nez v9, :cond_8

    invoke-static {v8}, Ljava/lang/Float;->isNaN(F)Z

    move-result v8

    if-nez v8, :cond_8

    goto :goto_6

    :cond_8
    move v6, v7

    :goto_6
    if-nez v6, :cond_9

    goto :goto_7

    .line 133
    :cond_9
    invoke-static {v4, v5, v2, v3}, Landroidx/compose/ui/layout/ScaleFactorKt;->times-m-w2e94(JJ)J

    move-result-wide v6

    return-wide v6

    .line 130
    :cond_a
    :goto_7
    return-wide p1
.end method

.method private final component1()Landroidx/compose/ui/graphics/painter/Painter;
    .locals 1

    iget-object v0, p0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    return-object v0
.end method

.method private final component2()Landroidx/compose/ui/Alignment;
    .locals 1

    iget-object v0, p0, Lcoil/compose/ContentPainterModifier;->alignment:Landroidx/compose/ui/Alignment;

    return-object v0
.end method

.method private final component3()Landroidx/compose/ui/layout/ContentScale;
    .locals 1

    iget-object v0, p0, Lcoil/compose/ContentPainterModifier;->contentScale:Landroidx/compose/ui/layout/ContentScale;

    return-object v0
.end method

.method private final component4()F
    .locals 1

    iget v0, p0, Lcoil/compose/ContentPainterModifier;->alpha:F

    return v0
.end method

.method private final component5()Landroidx/compose/ui/graphics/ColorFilter;
    .locals 1

    iget-object v0, p0, Lcoil/compose/ContentPainterModifier;->colorFilter:Landroidx/compose/ui/graphics/ColorFilter;

    return-object v0
.end method

.method public static synthetic copy$default(Lcoil/compose/ContentPainterModifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILjava/lang/Object;)Lcoil/compose/ContentPainterModifier;
    .locals 3

    and-int/lit8 p7, p6, 0x1

    if-eqz p7, :cond_0

    iget-object p1, p0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    :cond_0
    and-int/lit8 p7, p6, 0x2

    if-eqz p7, :cond_1

    iget-object p2, p0, Lcoil/compose/ContentPainterModifier;->alignment:Landroidx/compose/ui/Alignment;

    :cond_1
    move-object p7, p2

    and-int/lit8 p2, p6, 0x4

    if-eqz p2, :cond_2

    iget-object p3, p0, Lcoil/compose/ContentPainterModifier;->contentScale:Landroidx/compose/ui/layout/ContentScale;

    :cond_2
    move-object v0, p3

    and-int/lit8 p2, p6, 0x8

    if-eqz p2, :cond_3

    iget p4, p0, Lcoil/compose/ContentPainterModifier;->alpha:F

    :cond_3
    move v1, p4

    and-int/lit8 p2, p6, 0x10

    if-eqz p2, :cond_4

    iget-object p5, p0, Lcoil/compose/ContentPainterModifier;->colorFilter:Landroidx/compose/ui/graphics/ColorFilter;

    :cond_4
    move-object v2, p5

    move-object p2, p0

    move-object p3, p1

    move-object p4, p7

    move-object p5, v0

    move p6, v1

    move-object p7, v2

    invoke-virtual/range {p2 .. p7}, Lcoil/compose/ContentPainterModifier;->copy(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)Lcoil/compose/ContentPainterModifier;

    move-result-object p0

    return-object p0
.end method

.method private final modifyConstraints-ZezNO4M(J)J
    .locals 21
    .param p1, "constraints"    # J

    .line 138
    move-object/from16 v0, p0

    move-wide/from16 v9, p1

    invoke-static/range {p1 .. p2}, Landroidx/compose/ui/unit/Constraints;->getHasFixedWidth-impl(J)Z

    move-result v11

    .line 139
    .local v11, "hasFixedWidth":Z
    invoke-static/range {p1 .. p2}, Landroidx/compose/ui/unit/Constraints;->getHasFixedHeight-impl(J)Z

    move-result v12

    .line 140
    .local v12, "hasFixedHeight":Z
    if-eqz v11, :cond_0

    if-eqz v12, :cond_0

    .line 141
    return-wide v9

    .line 145
    :cond_0
    invoke-static/range {p1 .. p2}, Landroidx/compose/ui/unit/Constraints;->getHasBoundedWidth-impl(J)Z

    move-result v1

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-eqz v1, :cond_1

    invoke-static/range {p1 .. p2}, Landroidx/compose/ui/unit/Constraints;->getHasBoundedHeight-impl(J)Z

    move-result v1

    if-eqz v1, :cond_1

    move v1, v2

    goto :goto_0

    :cond_1
    move v1, v3

    :goto_0
    move v13, v1

    .line 146
    .local v13, "hasBoundedSize":Z
    iget-object v1, v0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    invoke-virtual {v1}, Landroidx/compose/ui/graphics/painter/Painter;->getIntrinsicSize-NH-jbRc()J

    move-result-wide v14

    .line 147
    .local v14, "intrinsicSize":J
    move-wide v4, v14

    .local v4, "$this$isUnspecified$iv":J
    const/4 v1, 0x0

    .line 214
    .local v1, "$i$f$isUnspecified-uvyYCjk":I
    sget-object v6, Landroidx/compose/ui/geometry/Size;->Companion:Landroidx/compose/ui/geometry/Size$Companion;

    invoke-virtual {v6}, Landroidx/compose/ui/geometry/Size$Companion;->getUnspecified-NH-jbRc()J

    move-result-wide v6

    cmp-long v6, v4, v6

    if-nez v6, :cond_2

    move v1, v2

    goto :goto_1

    :cond_2
    move v1, v3

    .line 147
    .end local v1    # "$i$f$isUnspecified-uvyYCjk":I
    .end local v4    # "$this$isUnspecified$iv":J
    :goto_1
    if-eqz v1, :cond_4

    .line 148
    if-eqz v13, :cond_3

    .line 149
    nop

    .line 150
    invoke-static/range {p1 .. p2}, Landroidx/compose/ui/unit/Constraints;->getMaxWidth-impl(J)I

    move-result v3

    .line 149
    const/4 v4, 0x0

    .line 151
    invoke-static/range {p1 .. p2}, Landroidx/compose/ui/unit/Constraints;->getMaxHeight-impl(J)I

    move-result v5

    .line 149
    const/4 v6, 0x0

    const/16 v7, 0xa

    const/4 v8, 0x0

    move-wide/from16 v1, p1

    invoke-static/range {v1 .. v8}, Landroidx/compose/ui/unit/Constraints;->copy-Zbe2FdA$default(JIIIIILjava/lang/Object;)J

    move-result-wide v1

    return-wide v1

    .line 154
    :cond_3
    return-wide v9

    :cond_4
    const/4 v1, 0x0

    .local v1, "dstWidth":F
    const/4 v4, 0x0

    .line 163
    .local v4, "dstHeight":F
    if-eqz v13, :cond_6

    if-nez v11, :cond_5

    if-eqz v12, :cond_6

    .line 164
    :cond_5
    invoke-static/range {p1 .. p2}, Landroidx/compose/ui/unit/Constraints;->getMaxWidth-impl(J)I

    move-result v2

    int-to-float v1, v2

    .line 165
    invoke-static/range {p1 .. p2}, Landroidx/compose/ui/unit/Constraints;->getMaxHeight-impl(J)I

    move-result v2

    int-to-float v2, v2

    move v8, v1

    move v7, v2

    .end local v4    # "dstHeight":F
    .local v2, "dstHeight":F
    goto :goto_6

    .end local v2    # "dstHeight":F
    .restart local v4    # "dstHeight":F
    :cond_6
    const/4 v5, 0x0

    .line 215
    .local v5, "$i$f$component1-impl":I
    invoke-static {v14, v15}, Landroidx/compose/ui/geometry/Size;->getWidth-impl(J)F

    move-result v5

    .line 167
    .end local v5    # "$i$f$component1-impl":I
    nop

    .local v5, "intrinsicWidth":F
    const/4 v6, 0x0

    .line 216
    .local v6, "$i$f$component2-impl":I
    invoke-static {v14, v15}, Landroidx/compose/ui/geometry/Size;->getHeight-impl(J)F

    move-result v6

    .line 167
    .end local v6    # "$i$f$component2-impl":I
    nop

    .line 168
    .local v6, "intrinsicHeight":F
    nop

    .line 169
    invoke-static {v5}, Ljava/lang/Float;->isInfinite(F)Z

    move-result v7

    if-nez v7, :cond_7

    invoke-static {v5}, Ljava/lang/Float;->isNaN(F)Z

    move-result v7

    if-nez v7, :cond_7

    move v7, v2

    goto :goto_2

    :cond_7
    move v7, v3

    :goto_2
    if-eqz v7, :cond_8

    invoke-static {v9, v10, v5}, Lcoil/compose/UtilsKt;->constrainWidth-K40F9xA(JF)F

    move-result v7

    goto :goto_3

    .line 170
    :cond_8
    invoke-static/range {p1 .. p2}, Landroidx/compose/ui/unit/Constraints;->getMinWidth-impl(J)I

    move-result v7

    int-to-float v7, v7

    .line 168
    :goto_3
    move v1, v7

    .line 172
    nop

    .line 173
    invoke-static {v6}, Ljava/lang/Float;->isInfinite(F)Z

    move-result v7

    if-nez v7, :cond_9

    invoke-static {v6}, Ljava/lang/Float;->isNaN(F)Z

    move-result v7

    if-nez v7, :cond_9

    goto :goto_4

    :cond_9
    move v2, v3

    :goto_4
    if-eqz v2, :cond_a

    invoke-static {v9, v10, v6}, Lcoil/compose/UtilsKt;->constrainHeight-K40F9xA(JF)F

    move-result v2

    goto :goto_5

    .line 174
    :cond_a
    invoke-static/range {p1 .. p2}, Landroidx/compose/ui/unit/Constraints;->getMinHeight-impl(J)I

    move-result v2

    int-to-float v2, v2

    .line 172
    :goto_5
    move v8, v1

    move v7, v2

    .line 179
    .end local v1    # "dstWidth":F
    .end local v4    # "dstHeight":F
    .end local v5    # "intrinsicWidth":F
    .end local v6    # "intrinsicHeight":F
    .local v7, "dstHeight":F
    .local v8, "dstWidth":F
    :goto_6
    invoke-static {v8, v7}, Landroidx/compose/ui/geometry/SizeKt;->Size(FF)J

    move-result-wide v1

    invoke-direct {v0, v1, v2}, Lcoil/compose/ContentPainterModifier;->calculateScaledSize-E7KxVPU(J)J

    move-result-wide v1

    const/4 v3, 0x0

    .line 217
    .local v3, "$i$f$component1-impl":I
    invoke-static {v1, v2}, Landroidx/compose/ui/geometry/Size;->getWidth-impl(J)F

    move-result v3

    .line 179
    .end local v3    # "$i$f$component1-impl":I
    move/from16 v16, v3

    .local v16, "scaledWidth":F
    const/4 v3, 0x0

    .line 221
    .local v3, "$i$f$component2-impl":I
    invoke-static {v1, v2}, Landroidx/compose/ui/geometry/Size;->getHeight-impl(J)F

    move-result v1

    .line 179
    .end local v3    # "$i$f$component2-impl":I
    move/from16 v17, v1

    .line 180
    .local v17, "scaledHeight":F
    nop

    .line 181
    invoke-static/range {v16 .. v16}, Lkotlin/math/MathKt;->roundToInt(F)I

    move-result v1

    invoke-static {v9, v10, v1}, Landroidx/compose/ui/unit/ConstraintsKt;->constrainWidth-K40F9xA(JI)I

    move-result v3

    .line 180
    const/4 v4, 0x0

    .line 182
    invoke-static/range {v17 .. v17}, Lkotlin/math/MathKt;->roundToInt(F)I

    move-result v1

    invoke-static {v9, v10, v1}, Landroidx/compose/ui/unit/ConstraintsKt;->constrainHeight-K40F9xA(JI)I

    move-result v5

    .line 180
    const/4 v6, 0x0

    const/16 v18, 0xa

    const/16 v19, 0x0

    move-wide/from16 v1, p1

    move/from16 v20, v7

    .end local v7    # "dstHeight":F
    .local v20, "dstHeight":F
    move/from16 v7, v18

    move/from16 v18, v8

    .end local v8    # "dstWidth":F
    .local v18, "dstWidth":F
    move-object/from16 v8, v19

    invoke-static/range {v1 .. v8}, Landroidx/compose/ui/unit/Constraints;->copy-Zbe2FdA$default(JIIIIILjava/lang/Object;)J

    move-result-wide v1

    return-wide v1
.end method


# virtual methods
.method public final copy(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)Lcoil/compose/ContentPainterModifier;
    .locals 7

    new-instance v6, Lcoil/compose/ContentPainterModifier;

    move-object v0, v6

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcoil/compose/ContentPainterModifier;-><init>(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V

    return-object v6
.end method

.method public draw(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V
    .locals 19
    .param p1, "$this$draw"    # Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;

    .line 187
    move-object/from16 v0, p0

    invoke-interface/range {p1 .. p1}, Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;->getSize-NH-jbRc()J

    move-result-wide v1

    invoke-direct {v0, v1, v2}, Lcoil/compose/ContentPainterModifier;->calculateScaledSize-E7KxVPU(J)J

    move-result-wide v1

    .line 188
    .local v1, "scaledSize":J
    iget-object v3, v0, Lcoil/compose/ContentPainterModifier;->alignment:Landroidx/compose/ui/Alignment;

    .line 189
    invoke-static {v1, v2}, Lcoil/compose/UtilsKt;->toIntSize-uvyYCjk(J)J

    move-result-wide v4

    .line 190
    invoke-interface/range {p1 .. p1}, Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;->getSize-NH-jbRc()J

    move-result-wide v6

    invoke-static {v6, v7}, Lcoil/compose/UtilsKt;->toIntSize-uvyYCjk(J)J

    move-result-wide v6

    .line 191
    invoke-interface/range {p1 .. p1}, Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;->getLayoutDirection()Landroidx/compose/ui/unit/LayoutDirection;

    move-result-object v8

    .line 188
    invoke-interface/range {v3 .. v8}, Landroidx/compose/ui/Alignment;->align-KFBX0sM(JJLandroidx/compose/ui/unit/LayoutDirection;)J

    move-result-wide v3

    invoke-static {v3, v4}, Landroidx/compose/ui/unit/IntOffset;->component1-impl(J)I

    move-result v9

    .local v9, "dx":I
    invoke-static {v3, v4}, Landroidx/compose/ui/unit/IntOffset;->component2-impl(J)I

    move-result v10

    .line 195
    .local v10, "dy":I
    move-object/from16 v11, p1

    check-cast v11, Landroidx/compose/ui/graphics/drawscope/DrawScope;

    .local v11, "$this$translate$iv":Landroidx/compose/ui/graphics/drawscope/DrawScope;
    int-to-float v12, v9

    .local v12, "left$iv":F
    int-to-float v3, v10

    .local v3, "top$iv":F
    move v13, v3

    .end local v3    # "top$iv":F
    .local v13, "top$iv":F
    const/4 v14, 0x0

    .line 222
    .local v14, "$i$f$translate":I
    invoke-interface {v11}, Landroidx/compose/ui/graphics/drawscope/DrawScope;->getDrawContext()Landroidx/compose/ui/graphics/drawscope/DrawContext;

    move-result-object v3

    invoke-interface {v3}, Landroidx/compose/ui/graphics/drawscope/DrawContext;->getTransform()Landroidx/compose/ui/graphics/drawscope/DrawTransform;

    move-result-object v3

    invoke-interface {v3, v12, v13}, Landroidx/compose/ui/graphics/drawscope/DrawTransform;->translate(FF)V

    .line 223
    move-object v4, v11

    .local v4, "$this$draw_u24lambda_u244":Landroidx/compose/ui/graphics/drawscope/DrawScope;
    const/4 v15, 0x0

    .line 196
    .local v15, "$i$a$-translate-ContentPainterModifier$draw$1":I
    iget-object v8, v0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    .local v8, "$this$draw_u24lambda_u244_u24lambda_u243":Landroidx/compose/ui/graphics/painter/Painter;
    const/16 v16, 0x0

    .line 197
    .local v16, "$i$a$-with-ContentPainterModifier$draw$1$1":I
    iget v7, v0, Lcoil/compose/ContentPainterModifier;->alpha:F

    iget-object v5, v0, Lcoil/compose/ContentPainterModifier;->colorFilter:Landroidx/compose/ui/graphics/ColorFilter;

    move-object v3, v8

    move-object/from16 v17, v5

    move-wide v5, v1

    move-object/from16 v18, v8

    .end local v8    # "$this$draw_u24lambda_u244_u24lambda_u243":Landroidx/compose/ui/graphics/painter/Painter;
    .local v18, "$this$draw_u24lambda_u244_u24lambda_u243":Landroidx/compose/ui/graphics/painter/Painter;
    move-object/from16 v8, v17

    invoke-virtual/range {v3 .. v8}, Landroidx/compose/ui/graphics/painter/Painter;->draw-x_KDEd0(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/ui/graphics/ColorFilter;)V

    .line 198
    nop

    .line 196
    .end local v16    # "$i$a$-with-ContentPainterModifier$draw$1$1":I
    .end local v18    # "$this$draw_u24lambda_u244_u24lambda_u243":Landroidx/compose/ui/graphics/painter/Painter;
    nop

    .line 199
    nop

    .line 223
    .end local v4    # "$this$draw_u24lambda_u244":Landroidx/compose/ui/graphics/drawscope/DrawScope;
    .end local v15    # "$i$a$-translate-ContentPainterModifier$draw$1":I
    nop

    .line 224
    invoke-interface {v11}, Landroidx/compose/ui/graphics/drawscope/DrawScope;->getDrawContext()Landroidx/compose/ui/graphics/drawscope/DrawContext;

    move-result-object v3

    invoke-interface {v3}, Landroidx/compose/ui/graphics/drawscope/DrawContext;->getTransform()Landroidx/compose/ui/graphics/drawscope/DrawTransform;

    move-result-object v3

    neg-float v4, v12

    neg-float v5, v13

    invoke-interface {v3, v4, v5}, Landroidx/compose/ui/graphics/drawscope/DrawTransform;->translate(FF)V

    .line 225
    nop

    .line 202
    .end local v11    # "$this$translate$iv":Landroidx/compose/ui/graphics/drawscope/DrawScope;
    .end local v12    # "left$iv":F
    .end local v13    # "top$iv":F
    .end local v14    # "$i$f$translate":I
    invoke-interface/range {p1 .. p1}, Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;->drawContent()V

    .line 203
    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5

    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    return v0

    :cond_0
    instance-of v1, p1, Lcoil/compose/ContentPainterModifier;

    const/4 v2, 0x0

    if-nez v1, :cond_1

    return v2

    :cond_1
    move-object v1, p1

    check-cast v1, Lcoil/compose/ContentPainterModifier;

    iget-object v3, p0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    iget-object v4, v1, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    return v2

    :cond_2
    iget-object v3, p0, Lcoil/compose/ContentPainterModifier;->alignment:Landroidx/compose/ui/Alignment;

    iget-object v4, v1, Lcoil/compose/ContentPainterModifier;->alignment:Landroidx/compose/ui/Alignment;

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_3

    return v2

    :cond_3
    iget-object v3, p0, Lcoil/compose/ContentPainterModifier;->contentScale:Landroidx/compose/ui/layout/ContentScale;

    iget-object v4, v1, Lcoil/compose/ContentPainterModifier;->contentScale:Landroidx/compose/ui/layout/ContentScale;

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    return v2

    :cond_4
    iget v3, p0, Lcoil/compose/ContentPainterModifier;->alpha:F

    iget v4, v1, Lcoil/compose/ContentPainterModifier;->alpha:F

    invoke-static {v3, v4}, Ljava/lang/Float;->compare(FF)I

    move-result v3

    if-eqz v3, :cond_5

    return v2

    :cond_5
    iget-object v3, p0, Lcoil/compose/ContentPainterModifier;->colorFilter:Landroidx/compose/ui/graphics/ColorFilter;

    iget-object v1, v1, Lcoil/compose/ContentPainterModifier;->colorFilter:Landroidx/compose/ui/graphics/ColorFilter;

    invoke-static {v3, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_6

    return v2

    :cond_6
    return v0
.end method

.method public hashCode()I
    .locals 3

    iget-object v0, p0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    invoke-virtual {v0}, Landroidx/compose/ui/graphics/painter/Painter;->hashCode()I

    move-result v0

    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcoil/compose/ContentPainterModifier;->alignment:Landroidx/compose/ui/Alignment;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    add-int/2addr v1, v2

    mul-int/lit8 v0, v1, 0x1f

    iget-object v2, p0, Lcoil/compose/ContentPainterModifier;->contentScale:Landroidx/compose/ui/layout/ContentScale;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lcoil/compose/ContentPainterModifier;->alpha:F

    invoke-static {v2}, Ljava/lang/Float;->hashCode(F)I

    move-result v2

    add-int/2addr v1, v2

    mul-int/lit8 v0, v1, 0x1f

    iget-object v2, p0, Lcoil/compose/ContentPainterModifier;->colorFilter:Landroidx/compose/ui/graphics/ColorFilter;

    if-nez v2, :cond_0

    const/4 v2, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {v2}, Landroidx/compose/ui/graphics/ColorFilter;->hashCode()I

    move-result v2

    :goto_0
    add-int/2addr v0, v2

    return v0
.end method

.method public maxIntrinsicHeight(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I
    .locals 10
    .param p1, "$this$maxIntrinsicHeight"    # Landroidx/compose/ui/layout/IntrinsicMeasureScope;
    .param p2, "measurable"    # Landroidx/compose/ui/layout/IntrinsicMeasurable;
    .param p3, "width"    # I

    .line 104
    iget-object v0, p0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    invoke-virtual {v0}, Landroidx/compose/ui/graphics/painter/Painter;->getIntrinsicSize-NH-jbRc()J

    move-result-wide v0

    .local v0, "$this$isSpecified$iv":J
    const/4 v2, 0x0

    .line 210
    .local v2, "$i$f$isSpecified-uvyYCjk":I
    sget-object v3, Landroidx/compose/ui/geometry/Size;->Companion:Landroidx/compose/ui/geometry/Size$Companion;

    invoke-virtual {v3}, Landroidx/compose/ui/geometry/Size$Companion;->getUnspecified-NH-jbRc()J

    move-result-wide v3

    cmp-long v3, v0, v3

    if-eqz v3, :cond_0

    const/4 v3, 0x1

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    .line 104
    .end local v0    # "$this$isSpecified$iv":J
    .end local v2    # "$i$f$isSpecified-uvyYCjk":I
    :goto_0
    if-eqz v3, :cond_1

    .line 105
    const/4 v4, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/16 v8, 0xd

    const/4 v9, 0x0

    move v5, p3

    invoke-static/range {v4 .. v9}, Landroidx/compose/ui/unit/ConstraintsKt;->Constraints$default(IIIIILjava/lang/Object;)J

    move-result-wide v0

    .line 106
    .local v0, "constraints":J
    invoke-direct {p0, v0, v1}, Lcoil/compose/ContentPainterModifier;->modifyConstraints-ZezNO4M(J)J

    move-result-wide v2

    invoke-static {v2, v3}, Landroidx/compose/ui/unit/Constraints;->getMaxWidth-impl(J)I

    move-result v2

    invoke-interface {p2, v2}, Landroidx/compose/ui/layout/IntrinsicMeasurable;->maxIntrinsicHeight(I)I

    move-result v2

    .line 107
    .local v2, "layoutHeight":I
    int-to-float v3, p3

    int-to-float v4, v2

    invoke-static {v3, v4}, Landroidx/compose/ui/geometry/SizeKt;->Size(FF)J

    move-result-wide v3

    invoke-direct {p0, v3, v4}, Lcoil/compose/ContentPainterModifier;->calculateScaledSize-E7KxVPU(J)J

    move-result-wide v3

    .line 108
    .local v3, "scaledSize":J
    invoke-static {v3, v4}, Landroidx/compose/ui/geometry/Size;->getHeight-impl(J)F

    move-result v5

    invoke-static {v5}, Lkotlin/math/MathKt;->roundToInt(F)I

    move-result v5

    invoke-static {v5, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    .end local v0    # "constraints":J
    .end local v2    # "layoutHeight":I
    .end local v3    # "scaledSize":J
    goto :goto_1

    .line 110
    :cond_1
    invoke-interface {p2, p3}, Landroidx/compose/ui/layout/IntrinsicMeasurable;->maxIntrinsicHeight(I)I

    move-result v0

    .line 104
    :goto_1
    return v0
.end method

.method public maxIntrinsicWidth(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I
    .locals 10
    .param p1, "$this$maxIntrinsicWidth"    # Landroidx/compose/ui/layout/IntrinsicMeasureScope;
    .param p2, "measurable"    # Landroidx/compose/ui/layout/IntrinsicMeasurable;
    .param p3, "height"    # I

    .line 76
    iget-object v0, p0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    invoke-virtual {v0}, Landroidx/compose/ui/graphics/painter/Painter;->getIntrinsicSize-NH-jbRc()J

    move-result-wide v0

    .local v0, "$this$isSpecified$iv":J
    const/4 v2, 0x0

    .line 208
    .local v2, "$i$f$isSpecified-uvyYCjk":I
    sget-object v3, Landroidx/compose/ui/geometry/Size;->Companion:Landroidx/compose/ui/geometry/Size$Companion;

    invoke-virtual {v3}, Landroidx/compose/ui/geometry/Size$Companion;->getUnspecified-NH-jbRc()J

    move-result-wide v3

    cmp-long v3, v0, v3

    if-eqz v3, :cond_0

    const/4 v3, 0x1

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    .line 76
    .end local v0    # "$this$isSpecified$iv":J
    .end local v2    # "$i$f$isSpecified-uvyYCjk":I
    :goto_0
    if-eqz v3, :cond_1

    .line 77
    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v8, 0x7

    const/4 v9, 0x0

    move v7, p3

    invoke-static/range {v4 .. v9}, Landroidx/compose/ui/unit/ConstraintsKt;->Constraints$default(IIIIILjava/lang/Object;)J

    move-result-wide v0

    .line 78
    .local v0, "constraints":J
    invoke-direct {p0, v0, v1}, Lcoil/compose/ContentPainterModifier;->modifyConstraints-ZezNO4M(J)J

    move-result-wide v2

    invoke-static {v2, v3}, Landroidx/compose/ui/unit/Constraints;->getMaxHeight-impl(J)I

    move-result v2

    invoke-interface {p2, v2}, Landroidx/compose/ui/layout/IntrinsicMeasurable;->maxIntrinsicWidth(I)I

    move-result v2

    .line 79
    .local v2, "layoutWidth":I
    int-to-float v3, v2

    int-to-float v4, p3

    invoke-static {v3, v4}, Landroidx/compose/ui/geometry/SizeKt;->Size(FF)J

    move-result-wide v3

    invoke-direct {p0, v3, v4}, Lcoil/compose/ContentPainterModifier;->calculateScaledSize-E7KxVPU(J)J

    move-result-wide v3

    .line 80
    .local v3, "scaledSize":J
    invoke-static {v3, v4}, Landroidx/compose/ui/geometry/Size;->getWidth-impl(J)F

    move-result v5

    invoke-static {v5}, Lkotlin/math/MathKt;->roundToInt(F)I

    move-result v5

    invoke-static {v5, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    .end local v0    # "constraints":J
    .end local v2    # "layoutWidth":I
    .end local v3    # "scaledSize":J
    goto :goto_1

    .line 82
    :cond_1
    invoke-interface {p2, p3}, Landroidx/compose/ui/layout/IntrinsicMeasurable;->maxIntrinsicWidth(I)I

    move-result v0

    .line 76
    :goto_1
    return v0
.end method

.method public measure-3p2s80s(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;
    .locals 8
    .param p1, "$this$measure_u2d3p2s80s"    # Landroidx/compose/ui/layout/MeasureScope;
    .param p2, "measurable"    # Landroidx/compose/ui/layout/Measurable;
    .param p3, "constraints"    # J

    .line 52
    invoke-direct {p0, p3, p4}, Lcoil/compose/ContentPainterModifier;->modifyConstraints-ZezNO4M(J)J

    move-result-wide v0

    invoke-interface {p2, v0, v1}, Landroidx/compose/ui/layout/Measurable;->measure-BRTryo0(J)Landroidx/compose/ui/layout/Placeable;

    move-result-object v0

    .line 53
    .local v0, "placeable":Landroidx/compose/ui/layout/Placeable;
    invoke-virtual {v0}, Landroidx/compose/ui/layout/Placeable;->getWidth()I

    move-result v2

    invoke-virtual {v0}, Landroidx/compose/ui/layout/Placeable;->getHeight()I

    move-result v3

    const/4 v4, 0x0

    new-instance v1, Lcoil/compose/ContentPainterModifier$measure$1;

    invoke-direct {v1, v0}, Lcoil/compose/ContentPainterModifier$measure$1;-><init>(Landroidx/compose/ui/layout/Placeable;)V

    move-object v5, v1

    check-cast v5, Lkotlin/jvm/functions/Function1;

    const/4 v6, 0x4

    const/4 v7, 0x0

    move-object v1, p1

    invoke-static/range {v1 .. v7}, Landroidx/compose/ui/layout/MeasureScope;->layout$default(Landroidx/compose/ui/layout/MeasureScope;IILjava/util/Map;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Landroidx/compose/ui/layout/MeasureResult;

    move-result-object v1

    return-object v1
.end method

.method public minIntrinsicHeight(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I
    .locals 10
    .param p1, "$this$minIntrinsicHeight"    # Landroidx/compose/ui/layout/IntrinsicMeasureScope;
    .param p2, "measurable"    # Landroidx/compose/ui/layout/IntrinsicMeasurable;
    .param p3, "width"    # I

    .line 90
    iget-object v0, p0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    invoke-virtual {v0}, Landroidx/compose/ui/graphics/painter/Painter;->getIntrinsicSize-NH-jbRc()J

    move-result-wide v0

    .local v0, "$this$isSpecified$iv":J
    const/4 v2, 0x0

    .line 209
    .local v2, "$i$f$isSpecified-uvyYCjk":I
    sget-object v3, Landroidx/compose/ui/geometry/Size;->Companion:Landroidx/compose/ui/geometry/Size$Companion;

    invoke-virtual {v3}, Landroidx/compose/ui/geometry/Size$Companion;->getUnspecified-NH-jbRc()J

    move-result-wide v3

    cmp-long v3, v0, v3

    if-eqz v3, :cond_0

    const/4 v3, 0x1

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    .line 90
    .end local v0    # "$this$isSpecified$iv":J
    .end local v2    # "$i$f$isSpecified-uvyYCjk":I
    :goto_0
    if-eqz v3, :cond_1

    .line 91
    const/4 v4, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/16 v8, 0xd

    const/4 v9, 0x0

    move v5, p3

    invoke-static/range {v4 .. v9}, Landroidx/compose/ui/unit/ConstraintsKt;->Constraints$default(IIIIILjava/lang/Object;)J

    move-result-wide v0

    .line 92
    .local v0, "constraints":J
    invoke-direct {p0, v0, v1}, Lcoil/compose/ContentPainterModifier;->modifyConstraints-ZezNO4M(J)J

    move-result-wide v2

    invoke-static {v2, v3}, Landroidx/compose/ui/unit/Constraints;->getMaxWidth-impl(J)I

    move-result v2

    invoke-interface {p2, v2}, Landroidx/compose/ui/layout/IntrinsicMeasurable;->minIntrinsicHeight(I)I

    move-result v2

    .line 93
    .local v2, "layoutHeight":I
    int-to-float v3, p3

    int-to-float v4, v2

    invoke-static {v3, v4}, Landroidx/compose/ui/geometry/SizeKt;->Size(FF)J

    move-result-wide v3

    invoke-direct {p0, v3, v4}, Lcoil/compose/ContentPainterModifier;->calculateScaledSize-E7KxVPU(J)J

    move-result-wide v3

    .line 94
    .local v3, "scaledSize":J
    invoke-static {v3, v4}, Landroidx/compose/ui/geometry/Size;->getHeight-impl(J)F

    move-result v5

    invoke-static {v5}, Lkotlin/math/MathKt;->roundToInt(F)I

    move-result v5

    invoke-static {v5, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    .end local v0    # "constraints":J
    .end local v2    # "layoutHeight":I
    .end local v3    # "scaledSize":J
    goto :goto_1

    .line 96
    :cond_1
    invoke-interface {p2, p3}, Landroidx/compose/ui/layout/IntrinsicMeasurable;->minIntrinsicHeight(I)I

    move-result v0

    .line 90
    :goto_1
    return v0
.end method

.method public minIntrinsicWidth(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I
    .locals 10
    .param p1, "$this$minIntrinsicWidth"    # Landroidx/compose/ui/layout/IntrinsicMeasureScope;
    .param p2, "measurable"    # Landroidx/compose/ui/layout/IntrinsicMeasurable;
    .param p3, "height"    # I

    .line 62
    iget-object v0, p0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    invoke-virtual {v0}, Landroidx/compose/ui/graphics/painter/Painter;->getIntrinsicSize-NH-jbRc()J

    move-result-wide v0

    .local v0, "$this$isSpecified$iv":J
    const/4 v2, 0x0

    .line 207
    .local v2, "$i$f$isSpecified-uvyYCjk":I
    sget-object v3, Landroidx/compose/ui/geometry/Size;->Companion:Landroidx/compose/ui/geometry/Size$Companion;

    invoke-virtual {v3}, Landroidx/compose/ui/geometry/Size$Companion;->getUnspecified-NH-jbRc()J

    move-result-wide v3

    cmp-long v3, v0, v3

    if-eqz v3, :cond_0

    const/4 v3, 0x1

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    .line 62
    .end local v0    # "$this$isSpecified$iv":J
    .end local v2    # "$i$f$isSpecified-uvyYCjk":I
    :goto_0
    if-eqz v3, :cond_1

    .line 63
    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v8, 0x7

    const/4 v9, 0x0

    move v7, p3

    invoke-static/range {v4 .. v9}, Landroidx/compose/ui/unit/ConstraintsKt;->Constraints$default(IIIIILjava/lang/Object;)J

    move-result-wide v0

    .line 64
    .local v0, "constraints":J
    invoke-direct {p0, v0, v1}, Lcoil/compose/ContentPainterModifier;->modifyConstraints-ZezNO4M(J)J

    move-result-wide v2

    invoke-static {v2, v3}, Landroidx/compose/ui/unit/Constraints;->getMaxHeight-impl(J)I

    move-result v2

    invoke-interface {p2, v2}, Landroidx/compose/ui/layout/IntrinsicMeasurable;->minIntrinsicWidth(I)I

    move-result v2

    .line 65
    .local v2, "layoutWidth":I
    int-to-float v3, v2

    int-to-float v4, p3

    invoke-static {v3, v4}, Landroidx/compose/ui/geometry/SizeKt;->Size(FF)J

    move-result-wide v3

    invoke-direct {p0, v3, v4}, Lcoil/compose/ContentPainterModifier;->calculateScaledSize-E7KxVPU(J)J

    move-result-wide v3

    .line 66
    .local v3, "scaledSize":J
    invoke-static {v3, v4}, Landroidx/compose/ui/geometry/Size;->getWidth-impl(J)F

    move-result v5

    invoke-static {v5}, Lkotlin/math/MathKt;->roundToInt(F)I

    move-result v5

    invoke-static {v5, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    .end local v0    # "constraints":J
    .end local v2    # "layoutWidth":I
    .end local v3    # "scaledSize":J
    goto :goto_1

    .line 68
    :cond_1
    invoke-interface {p2, p3}, Landroidx/compose/ui/layout/IntrinsicMeasurable;->minIntrinsicWidth(I)I

    move-result v0

    .line 62
    :goto_1
    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ContentPainterModifier(painter="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcoil/compose/ContentPainterModifier;->painter:Landroidx/compose/ui/graphics/painter/Painter;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", alignment="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcoil/compose/ContentPainterModifier;->alignment:Landroidx/compose/ui/Alignment;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", contentScale="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcoil/compose/ContentPainterModifier;->contentScale:Landroidx/compose/ui/layout/ContentScale;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", alpha="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcoil/compose/ContentPainterModifier;->alpha:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", colorFilter="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcoil/compose/ContentPainterModifier;->colorFilter:Landroidx/compose/ui/graphics/ColorFilter;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x29

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
