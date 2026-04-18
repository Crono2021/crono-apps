.class public final Lcoil/compose/AsyncImagePainterKt;
.super Ljava/lang/Object;
.source "AsyncImagePainter.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAsyncImagePainter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncImagePainter.kt\ncoil/compose/AsyncImagePainterKt\n+ 2 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Size.kt\nandroidx/compose/ui/geometry/SizeKt\n*L\n1#1,413:1\n25#2:414\n1097#3,6:415\n76#4:421\n1#5:422\n159#6:423\n*S KotlinDebug\n*F\n+ 1 AsyncImagePainter.kt\ncoil/compose/AsyncImagePainterKt\n*L\n141#1:414\n141#1:415,6\n146#1:421\n401#1:423\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000}\n\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0001\u001ai\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0014\u0008\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0016\u0008\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0016H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\u0008\u0017\u0010\u0018\u001a\u00a7\u0001\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0016\u0008\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0016\u0008\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0016\u0008\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0016H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\u0008#\u0010$\u001a\u001a\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0008\u0008\u0002\u0010)\u001a\u00020(H\u0002\u001a\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002\u001a\u001b\u0010-\u001a\u0004\u0018\u00010.*\u00020\u0005H\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\u0008/\u00100\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u001b\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\u0008\u0019\n\u0005\u0008\u00a1\u001e0\u0001\u00a8\u00061"
    }
    d2 = {
        "fakeTransitionTarget",
        "coil/compose/AsyncImagePainterKt$fakeTransitionTarget$1",
        "Lcoil/compose/AsyncImagePainterKt$fakeTransitionTarget$1;",
        "isPositive",
        "",
        "Landroidx/compose/ui/geometry/Size;",
        "isPositive-uvyYCjk",
        "(J)Z",
        "rememberAsyncImagePainter",
        "Lcoil/compose/AsyncImagePainter;",
        "model",
        "",
        "imageLoader",
        "Lcoil/ImageLoader;",
        "transform",
        "Lkotlin/Function1;",
        "Lcoil/compose/AsyncImagePainter$State;",
        "onState",
        "",
        "contentScale",
        "Landroidx/compose/ui/layout/ContentScale;",
        "filterQuality",
        "Landroidx/compose/ui/graphics/FilterQuality;",
        "rememberAsyncImagePainter-5jETZwI",
        "(Ljava/lang/Object;Lcoil/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;",
        "placeholder",
        "Landroidx/compose/ui/graphics/painter/Painter;",
        "error",
        "fallback",
        "onLoading",
        "Lcoil/compose/AsyncImagePainter$State$Loading;",
        "onSuccess",
        "Lcoil/compose/AsyncImagePainter$State$Success;",
        "onError",
        "Lcoil/compose/AsyncImagePainter$State$Error;",
        "rememberAsyncImagePainter-3HmZ8SU",
        "(Ljava/lang/Object;Lcoil/ImageLoader;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;",
        "unsupportedData",
        "",
        "name",
        "",
        "description",
        "validateRequest",
        "request",
        "Lcoil/request/ImageRequest;",
        "toSizeOrNull",
        "Lcoil/size/Size;",
        "toSizeOrNull-uvyYCjk",
        "(J)Lcoil/size/Size;",
        "coil-compose-base_release"
    }
    k = 0x2
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field private static final fakeTransitionTarget:Lcoil/compose/AsyncImagePainterKt$fakeTransitionTarget$1;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 409
    new-instance v0, Lcoil/compose/AsyncImagePainterKt$fakeTransitionTarget$1;

    invoke-direct {v0}, Lcoil/compose/AsyncImagePainterKt$fakeTransitionTarget$1;-><init>()V

    sput-object v0, Lcoil/compose/AsyncImagePainterKt;->fakeTransitionTarget:Lcoil/compose/AsyncImagePainterKt$fakeTransitionTarget$1;

    return-void
.end method

.method public static final synthetic access$getFakeTransitionTarget$p()Lcoil/compose/AsyncImagePainterKt$fakeTransitionTarget$1;
    .locals 1

    .line 1
    sget-object v0, Lcoil/compose/AsyncImagePainterKt;->fakeTransitionTarget:Lcoil/compose/AsyncImagePainterKt$fakeTransitionTarget$1;

    return-object v0
.end method

.method public static final synthetic access$toSizeOrNull-uvyYCjk(J)Lcoil/size/Size;
    .locals 1
    .param p0, "$receiver"    # J

    .line 1
    invoke-static {p0, p1}, Lcoil/compose/AsyncImagePainterKt;->toSizeOrNull-uvyYCjk(J)Lcoil/size/Size;

    move-result-object v0

    return-object v0
.end method

.method private static final isPositive-uvyYCjk(J)Z
    .locals 4
    .param p0, "$this$isPositive"    # J

    .line 398
    invoke-static {p0, p1}, Landroidx/compose/ui/geometry/Size;->getWidth-impl(J)F

    move-result v0

    float-to-double v0, v0

    const-wide/high16 v2, 0x3fe0000000000000L    # 0.5

    cmpl-double v0, v0, v2

    if-ltz v0, :cond_0

    invoke-static {p0, p1}, Landroidx/compose/ui/geometry/Size;->getHeight-impl(J)F

    move-result v0

    float-to-double v0, v0

    cmpl-double v0, v0, v2

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public static final rememberAsyncImagePainter-3HmZ8SU(Ljava/lang/Object;Lcoil/ImageLoader;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;
    .locals 20
    .param p0, "model"    # Ljava/lang/Object;
    .param p1, "imageLoader"    # Lcoil/ImageLoader;
    .param p2, "placeholder"    # Landroidx/compose/ui/graphics/painter/Painter;
    .param p3, "error"    # Landroidx/compose/ui/graphics/painter/Painter;
    .param p4, "fallback"    # Landroidx/compose/ui/graphics/painter/Painter;
    .param p5, "onLoading"    # Lkotlin/jvm/functions/Function1;
    .param p6, "onSuccess"    # Lkotlin/jvm/functions/Function1;
    .param p7, "onError"    # Lkotlin/jvm/functions/Function1;
    .param p8, "contentScale"    # Landroidx/compose/ui/layout/ContentScale;
    .param p9, "filterQuality"    # I
    .param p10, "$composer"    # Landroidx/compose/runtime/Composer;
    .param p11, "$changed"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lcoil/ImageLoader;",
            "Landroidx/compose/ui/graphics/painter/Painter;",
            "Landroidx/compose/ui/graphics/painter/Painter;",
            "Landroidx/compose/ui/graphics/painter/Painter;",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Lcoil/compose/AsyncImagePainter$State$Loading;",
            "Lkotlin/Unit;",
            ">;",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Lcoil/compose/AsyncImagePainter$State$Success;",
            "Lkotlin/Unit;",
            ">;",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Lcoil/compose/AsyncImagePainter$State$Error;",
            "Lkotlin/Unit;",
            ">;",
            "Landroidx/compose/ui/layout/ContentScale;",
            "I",
            "Landroidx/compose/runtime/Composer;",
            "II)",
            "Lcoil/compose/AsyncImagePainter;"
        }
    .end annotation

    move-object/from16 v9, p10

    move/from16 v10, p11

    move/from16 v0, p12

    const v1, 0x7f996210

    invoke-interface {v9, v1}, Landroidx/compose/runtime/Composer;->startReplaceableGroup(I)V

    const-string v2, "C(rememberAsyncImagePainter)P(5,4,9,1,2,7,8,6!,3:c#ui.graphics.FilterQuality)"

    invoke-static {v9, v2}, Landroidx/compose/runtime/ComposerKt;->sourceInformation(Landroidx/compose/runtime/Composer;Ljava/lang/String;)V

    and-int/lit8 v2, v0, 0x4

    if-eqz v2, :cond_0

    .line 88
    const/4 v2, 0x0

    move-object v11, v2

    .end local p2    # "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    .local v2, "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    goto :goto_0

    .line 0
    .end local v2    # "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    .restart local p2    # "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    :cond_0
    move-object/from16 v11, p2

    .line 88
    .end local p2    # "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    .local v11, "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    :goto_0
    and-int/lit8 v2, v0, 0x8

    if-eqz v2, :cond_1

    .line 89
    const/4 v2, 0x0

    move-object v12, v2

    .end local p3    # "error":Landroidx/compose/ui/graphics/painter/Painter;
    .local v2, "error":Landroidx/compose/ui/graphics/painter/Painter;
    goto :goto_1

    .line 88
    .end local v2    # "error":Landroidx/compose/ui/graphics/painter/Painter;
    .restart local p3    # "error":Landroidx/compose/ui/graphics/painter/Painter;
    :cond_1
    move-object/from16 v12, p3

    .line 89
    .end local p3    # "error":Landroidx/compose/ui/graphics/painter/Painter;
    .local v12, "error":Landroidx/compose/ui/graphics/painter/Painter;
    :goto_1
    and-int/lit8 v2, v0, 0x10

    if-eqz v2, :cond_2

    .line 90
    move-object v2, v12

    move-object v13, v2

    .end local p4    # "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    .local v2, "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    goto :goto_2

    .line 89
    .end local v2    # "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    .restart local p4    # "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    :cond_2
    move-object/from16 v13, p4

    .line 90
    .end local p4    # "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    .local v13, "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    :goto_2
    and-int/lit8 v2, v0, 0x20

    if-eqz v2, :cond_3

    .line 91
    const/4 v2, 0x0

    move-object v14, v2

    .end local p5    # "onLoading":Lkotlin/jvm/functions/Function1;
    .local v2, "onLoading":Lkotlin/jvm/functions/Function1;
    goto :goto_3

    .line 90
    .end local v2    # "onLoading":Lkotlin/jvm/functions/Function1;
    .restart local p5    # "onLoading":Lkotlin/jvm/functions/Function1;
    :cond_3
    move-object/from16 v14, p5

    .line 91
    .end local p5    # "onLoading":Lkotlin/jvm/functions/Function1;
    .local v14, "onLoading":Lkotlin/jvm/functions/Function1;
    :goto_3
    and-int/lit8 v2, v0, 0x40

    if-eqz v2, :cond_4

    .line 92
    const/4 v2, 0x0

    move-object v15, v2

    .end local p6    # "onSuccess":Lkotlin/jvm/functions/Function1;
    .local v2, "onSuccess":Lkotlin/jvm/functions/Function1;
    goto :goto_4

    .line 91
    .end local v2    # "onSuccess":Lkotlin/jvm/functions/Function1;
    .restart local p6    # "onSuccess":Lkotlin/jvm/functions/Function1;
    :cond_4
    move-object/from16 v15, p6

    .line 92
    .end local p6    # "onSuccess":Lkotlin/jvm/functions/Function1;
    .local v15, "onSuccess":Lkotlin/jvm/functions/Function1;
    :goto_4
    and-int/lit16 v2, v0, 0x80

    if-eqz v2, :cond_5

    .line 93
    const/4 v2, 0x0

    move-object v8, v2

    .end local p7    # "onError":Lkotlin/jvm/functions/Function1;
    .local v2, "onError":Lkotlin/jvm/functions/Function1;
    goto :goto_5

    .line 92
    .end local v2    # "onError":Lkotlin/jvm/functions/Function1;
    .restart local p7    # "onError":Lkotlin/jvm/functions/Function1;
    :cond_5
    move-object/from16 v8, p7

    .line 93
    .end local p7    # "onError":Lkotlin/jvm/functions/Function1;
    .local v8, "onError":Lkotlin/jvm/functions/Function1;
    :goto_5
    and-int/lit16 v2, v0, 0x100

    if-eqz v2, :cond_6

    .line 94
    sget-object v2, Landroidx/compose/ui/layout/ContentScale;->Companion:Landroidx/compose/ui/layout/ContentScale$Companion;

    invoke-virtual {v2}, Landroidx/compose/ui/layout/ContentScale$Companion;->getFit()Landroidx/compose/ui/layout/ContentScale;

    move-result-object v2

    move-object/from16 v16, v2

    .end local p8    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .local v2, "contentScale":Landroidx/compose/ui/layout/ContentScale;
    goto :goto_6

    .line 93
    .end local v2    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .restart local p8    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    :cond_6
    move-object/from16 v16, p8

    .line 94
    .end local p8    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .local v16, "contentScale":Landroidx/compose/ui/layout/ContentScale;
    :goto_6
    and-int/lit16 v0, v0, 0x200

    if-eqz v0, :cond_7

    .line 95
    sget-object v0, Landroidx/compose/ui/graphics/drawscope/DrawScope;->Companion:Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;

    invoke-virtual {v0}, Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;->getDefaultFilterQuality-f-v9h1I()I

    move-result v0

    move/from16 v17, v0

    .end local p9    # "filterQuality":I
    .local v0, "filterQuality":I
    goto :goto_7

    .line 94
    .end local v0    # "filterQuality":I
    .restart local p9    # "filterQuality":I
    :cond_7
    move/from16 v17, p9

    .line 95
    .end local p9    # "filterQuality":I
    .local v17, "filterQuality":I
    :goto_7
    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 96
    const/4 v0, -0x1

    const-string v2, "coil.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:95)"

    invoke-static {v1, v10, v0, v2}, Landroidx/compose/runtime/ComposerKt;->traceEventStart(IIILjava/lang/String;)V

    .line 97
    :cond_8
    nop

    .line 98
    nop

    .line 99
    invoke-static {v11, v12, v13}, Lcoil/compose/UtilsKt;->transformOf(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;)Lkotlin/jvm/functions/Function1;

    move-result-object v2

    .line 100
    invoke-static {v14, v15, v8}, Lcoil/compose/UtilsKt;->onStateOf(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;

    move-result-object v3

    .line 101
    nop

    .line 102
    shr-int/lit8 v0, v10, 0xc

    const v1, 0xe000

    and-int/2addr v0, v1

    or-int/lit8 v0, v0, 0x48

    const/high16 v1, 0x70000

    shr-int/lit8 v4, v10, 0xc

    and-int/2addr v1, v4

    or-int v7, v0, v1

    const/16 v18, 0x0

    .line 96
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v4, v16

    move/from16 v5, v17

    move-object/from16 v6, p10

    move-object/from16 v19, v8

    .end local v8    # "onError":Lkotlin/jvm/functions/Function1;
    .local v19, "onError":Lkotlin/jvm/functions/Function1;
    move/from16 v8, v18

    invoke-static/range {v0 .. v8}, Lcoil/compose/AsyncImagePainterKt;->rememberAsyncImagePainter-5jETZwI(Ljava/lang/Object;Lcoil/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;

    move-result-object v0

    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z

    move-result v1

    if-eqz v1, :cond_9

    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V

    :cond_9
    invoke-interface/range {p10 .. p10}, Landroidx/compose/runtime/Composer;->endReplaceableGroup()V

    return-object v0
.end method

.method public static final rememberAsyncImagePainter-5jETZwI(Ljava/lang/Object;Lcoil/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;
    .locals 17
    .param p0, "model"    # Ljava/lang/Object;
    .param p1, "imageLoader"    # Lcoil/ImageLoader;
    .param p2, "transform"    # Lkotlin/jvm/functions/Function1;
    .param p3, "onState"    # Lkotlin/jvm/functions/Function1;
    .param p4, "contentScale"    # Landroidx/compose/ui/layout/ContentScale;
    .param p5, "filterQuality"    # I
    .param p6, "$composer"    # Landroidx/compose/runtime/Composer;
    .param p7, "$changed"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lcoil/ImageLoader;",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Lcoil/compose/AsyncImagePainter$State;",
            "+",
            "Lcoil/compose/AsyncImagePainter$State;",
            ">;",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Lcoil/compose/AsyncImagePainter$State;",
            "Lkotlin/Unit;",
            ">;",
            "Landroidx/compose/ui/layout/ContentScale;",
            "I",
            "Landroidx/compose/runtime/Composer;",
            "II)",
            "Lcoil/compose/AsyncImagePainter;"
        }
    .end annotation

    move-object/from16 v0, p1

    move-object/from16 v1, p6

    const v2, -0x78701fba

    invoke-interface {v1, v2}, Landroidx/compose/runtime/Composer;->startReplaceableGroup(I)V

    const-string v3, "C(rememberAsyncImagePainter)P(3,2,5,4!,1:c#ui.graphics.FilterQuality)"

    invoke-static {v1, v3}, Landroidx/compose/runtime/ComposerKt;->sourceInformation(Landroidx/compose/runtime/Composer;Ljava/lang/String;)V

    and-int/lit8 v3, p8, 0x4

    if-eqz v3, :cond_0

    .line 133
    sget-object v3, Lcoil/compose/AsyncImagePainter;->Companion:Lcoil/compose/AsyncImagePainter$Companion;

    invoke-virtual {v3}, Lcoil/compose/AsyncImagePainter$Companion;->getDefaultTransform()Lkotlin/jvm/functions/Function1;

    move-result-object v3

    .end local p2    # "transform":Lkotlin/jvm/functions/Function1;
    .local v3, "transform":Lkotlin/jvm/functions/Function1;
    goto :goto_0

    .line 0
    .end local v3    # "transform":Lkotlin/jvm/functions/Function1;
    .restart local p2    # "transform":Lkotlin/jvm/functions/Function1;
    :cond_0
    move-object/from16 v3, p2

    .line 133
    .end local p2    # "transform":Lkotlin/jvm/functions/Function1;
    .restart local v3    # "transform":Lkotlin/jvm/functions/Function1;
    :goto_0
    and-int/lit8 v4, p8, 0x8

    if-eqz v4, :cond_1

    .line 134
    const/4 v4, 0x0

    .end local p3    # "onState":Lkotlin/jvm/functions/Function1;
    .local v4, "onState":Lkotlin/jvm/functions/Function1;
    goto :goto_1

    .line 133
    .end local v4    # "onState":Lkotlin/jvm/functions/Function1;
    .restart local p3    # "onState":Lkotlin/jvm/functions/Function1;
    :cond_1
    move-object/from16 v4, p3

    .line 134
    .end local p3    # "onState":Lkotlin/jvm/functions/Function1;
    .restart local v4    # "onState":Lkotlin/jvm/functions/Function1;
    :goto_1
    and-int/lit8 v5, p8, 0x10

    if-eqz v5, :cond_2

    .line 135
    sget-object v5, Landroidx/compose/ui/layout/ContentScale;->Companion:Landroidx/compose/ui/layout/ContentScale$Companion;

    invoke-virtual {v5}, Landroidx/compose/ui/layout/ContentScale$Companion;->getFit()Landroidx/compose/ui/layout/ContentScale;

    move-result-object v5

    .end local p4    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .local v5, "contentScale":Landroidx/compose/ui/layout/ContentScale;
    goto :goto_2

    .line 134
    .end local v5    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .restart local p4    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    :cond_2
    move-object/from16 v5, p4

    .line 135
    .end local p4    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .restart local v5    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    :goto_2
    and-int/lit8 v6, p8, 0x20

    if-eqz v6, :cond_3

    .line 136
    sget-object v6, Landroidx/compose/ui/graphics/drawscope/DrawScope;->Companion:Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;

    invoke-virtual {v6}, Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;->getDefaultFilterQuality-f-v9h1I()I

    move-result v6

    .end local p5    # "filterQuality":I
    .local v6, "filterQuality":I
    goto :goto_3

    .line 135
    .end local v6    # "filterQuality":I
    .restart local p5    # "filterQuality":I
    :cond_3
    move/from16 v6, p5

    .line 136
    .end local p5    # "filterQuality":I
    .restart local v6    # "filterQuality":I
    :goto_3
    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z

    move-result v7

    if-eqz v7, :cond_4

    .line 137
    const/4 v7, -0x1

    const-string v8, "coil.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:136)"

    move/from16 v9, p7

    invoke-static {v2, v9, v7, v8}, Landroidx/compose/runtime/ComposerKt;->traceEventStart(IIILjava/lang/String;)V

    goto :goto_4

    .line 136
    :cond_4
    move/from16 v9, p7

    .line 138
    :goto_4
    const/16 v2, 0x8

    move-object/from16 v7, p0

    invoke-static {v7, v1, v2}, Lcoil/compose/UtilsKt;->requestOf(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Lcoil/request/ImageRequest;

    move-result-object v2

    .line 139
    .local v2, "request":Lcoil/request/ImageRequest;
    invoke-static {v2}, Lcoil/compose/AsyncImagePainterKt;->validateRequest(Lcoil/request/ImageRequest;)V

    .line 141
    const/4 v8, 0x0

    .local v8, "$changed$iv":I
    const/4 v10, 0x0

    .local v10, "$i$f$remember":I
    const v11, -0x1d58f75c

    invoke-interface {v1, v11}, Landroidx/compose/runtime/Composer;->startReplaceableGroup(I)V

    const-string v11, "CC(remember):Composables.kt#9igjgp"

    invoke-static {v1, v11}, Landroidx/compose/runtime/ComposerKt;->sourceInformation(Landroidx/compose/runtime/Composer;Ljava/lang/String;)V

    .line 414
    const/4 v11, 0x0

    .local v11, "invalid$iv$iv":Z
    move-object/from16 v12, p6

    .local v12, "$this$cache$iv$iv":Landroidx/compose/runtime/Composer;
    const/4 v13, 0x0

    .line 415
    .local v13, "$i$f$cache":I
    invoke-interface {v12}, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;

    move-result-object v14

    .local v14, "it$iv$iv":Ljava/lang/Object;
    const/4 v15, 0x0

    .line 416
    .local v15, "$i$a$-let-ComposerKt$cache$1$iv$iv":I
    sget-object v16, Landroidx/compose/runtime/Composer;->Companion:Landroidx/compose/runtime/Composer$Companion;

    invoke-virtual/range {v16 .. v16}, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;

    move-result-object v7

    if-ne v14, v7, :cond_5

    .line 417
    const/4 v7, 0x0

    .line 141
    .local v7, "$i$a$-remember-AsyncImagePainterKt$rememberAsyncImagePainter$painter$1":I
    move/from16 p2, v7

    .end local v7    # "$i$a$-remember-AsyncImagePainterKt$rememberAsyncImagePainter$painter$1":I
    .local p2, "$i$a$-remember-AsyncImagePainterKt$rememberAsyncImagePainter$painter$1":I
    new-instance v7, Lcoil/compose/AsyncImagePainter;

    invoke-direct {v7, v2, v0}, Lcoil/compose/AsyncImagePainter;-><init>(Lcoil/request/ImageRequest;Lcoil/ImageLoader;)V

    .line 417
    .end local p2    # "$i$a$-remember-AsyncImagePainterKt$rememberAsyncImagePainter$painter$1":I
    nop

    .line 418
    .local v7, "value$iv$iv":Ljava/lang/Object;
    invoke-interface {v12, v7}, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V

    .line 419
    nop

    .end local v7    # "value$iv$iv":Ljava/lang/Object;
    goto :goto_5

    .line 420
    :cond_5
    move-object v7, v14

    .line 416
    :goto_5
    nop

    .line 415
    .end local v14    # "it$iv$iv":Ljava/lang/Object;
    .end local v15    # "$i$a$-let-ComposerKt$cache$1$iv$iv":I
    nop

    .line 414
    .end local v11    # "invalid$iv$iv":Z
    .end local v12    # "$this$cache$iv$iv":Landroidx/compose/runtime/Composer;
    .end local v13    # "$i$f$cache":I
    invoke-interface/range {p6 .. p6}, Landroidx/compose/runtime/Composer;->endReplaceableGroup()V

    .line 141
    .end local v8    # "$changed$iv":I
    .end local v10    # "$i$f$remember":I
    check-cast v7, Lcoil/compose/AsyncImagePainter;

    .line 142
    .local v7, "painter":Lcoil/compose/AsyncImagePainter;
    invoke-virtual {v7, v3}, Lcoil/compose/AsyncImagePainter;->setTransform$coil_compose_base_release(Lkotlin/jvm/functions/Function1;)V

    .line 143
    invoke-virtual {v7, v4}, Lcoil/compose/AsyncImagePainter;->setOnState$coil_compose_base_release(Lkotlin/jvm/functions/Function1;)V

    .line 144
    invoke-virtual {v7, v5}, Lcoil/compose/AsyncImagePainter;->setContentScale$coil_compose_base_release(Landroidx/compose/ui/layout/ContentScale;)V

    .line 145
    invoke-virtual {v7, v6}, Lcoil/compose/AsyncImagePainter;->setFilterQuality-vDHp3xo$coil_compose_base_release(I)V

    .line 146
    invoke-static {}, Landroidx/compose/ui/platform/InspectionModeKt;->getLocalInspectionMode()Landroidx/compose/runtime/ProvidableCompositionLocal;

    move-result-object v8

    check-cast v8, Landroidx/compose/runtime/CompositionLocal;

    .local v8, "this_$iv":Landroidx/compose/runtime/CompositionLocal;
    const/4 v10, 0x0

    .local v10, "$changed$iv":I
    const/4 v11, 0x0

    .line 421
    .local v11, "$i$f$getCurrent":I
    const v12, 0x789c5f52

    const-string v13, "CC:CompositionLocal.kt#9igjgp"

    invoke-static {v1, v12, v13}, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer;ILjava/lang/String;)V

    invoke-interface {v1, v8}, Landroidx/compose/runtime/Composer;->consume(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;

    move-result-object v12

    invoke-static/range {p6 .. p6}, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V

    .end local v8    # "this_$iv":Landroidx/compose/runtime/CompositionLocal;
    .end local v10    # "$changed$iv":I
    .end local v11    # "$i$f$getCurrent":I
    check-cast v12, Ljava/lang/Boolean;

    invoke-virtual {v12}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    .line 146
    invoke-virtual {v7, v8}, Lcoil/compose/AsyncImagePainter;->setPreview$coil_compose_base_release(Z)V

    .line 147
    invoke-virtual {v7, v0}, Lcoil/compose/AsyncImagePainter;->setImageLoader$coil_compose_base_release(Lcoil/ImageLoader;)V

    .line 148
    invoke-virtual {v7, v2}, Lcoil/compose/AsyncImagePainter;->setRequest$coil_compose_base_release(Lcoil/request/ImageRequest;)V

    .line 149
    invoke-virtual {v7}, Lcoil/compose/AsyncImagePainter;->onRemembered()V

    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z

    move-result v8

    if-eqz v8, :cond_6

    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V

    :cond_6
    invoke-interface/range {p6 .. p6}, Landroidx/compose/runtime/Composer;->endReplaceableGroup()V

    .line 150
    return-object v7
.end method

.method private static final toSizeOrNull-uvyYCjk(J)Lcoil/size/Size;
    .locals 6
    .param p0, "$this$toSizeOrNull_u2duvyYCjk"    # J

    .line 400
    nop

    .line 401
    move-wide v0, p0

    .local v0, "$this$isUnspecified$iv":J
    const/4 v2, 0x0

    .line 423
    .local v2, "$i$f$isUnspecified-uvyYCjk":I
    sget-object v3, Landroidx/compose/ui/geometry/Size;->Companion:Landroidx/compose/ui/geometry/Size$Companion;

    invoke-virtual {v3}, Landroidx/compose/ui/geometry/Size$Companion;->getUnspecified-NH-jbRc()J

    move-result-wide v3

    cmp-long v3, v0, v3

    const/4 v4, 0x1

    const/4 v5, 0x0

    if-nez v3, :cond_0

    move v0, v4

    goto :goto_0

    :cond_0
    move v0, v5

    .line 401
    .end local v0    # "$this$isUnspecified$iv":J
    .end local v2    # "$i$f$isUnspecified-uvyYCjk":I
    :goto_0
    if-eqz v0, :cond_1

    sget-object v0, Lcoil/size/Size;->ORIGINAL:Lcoil/size/Size;

    goto :goto_5

    .line 402
    :cond_1
    invoke-static {p0, p1}, Lcoil/compose/AsyncImagePainterKt;->isPositive-uvyYCjk(J)Z

    move-result v0

    if-eqz v0, :cond_6

    new-instance v0, Lcoil/size/Size;

    .line 403
    invoke-static {p0, p1}, Landroidx/compose/ui/geometry/Size;->getWidth-impl(J)F

    move-result v1

    invoke-static {v1}, Ljava/lang/Float;->isInfinite(F)Z

    move-result v2

    if-nez v2, :cond_2

    invoke-static {v1}, Ljava/lang/Float;->isNaN(F)Z

    move-result v1

    if-nez v1, :cond_2

    move v1, v4

    goto :goto_1

    :cond_2
    move v1, v5

    :goto_1
    if-eqz v1, :cond_3

    invoke-static {p0, p1}, Landroidx/compose/ui/geometry/Size;->getWidth-impl(J)F

    move-result v1

    invoke-static {v1}, Lkotlin/math/MathKt;->roundToInt(F)I

    move-result v1

    invoke-static {v1}, Lcoil/size/-Dimensions;->Dimension(I)Lcoil/size/Dimension$Pixels;

    move-result-object v1

    goto :goto_2

    :cond_3
    sget-object v1, Lcoil/size/Dimension$Undefined;->INSTANCE:Lcoil/size/Dimension$Undefined;

    :goto_2
    check-cast v1, Lcoil/size/Dimension;

    .line 404
    invoke-static {p0, p1}, Landroidx/compose/ui/geometry/Size;->getHeight-impl(J)F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->isInfinite(F)Z

    move-result v3

    if-nez v3, :cond_4

    invoke-static {v2}, Ljava/lang/Float;->isNaN(F)Z

    move-result v2

    if-nez v2, :cond_4

    goto :goto_3

    :cond_4
    move v4, v5

    :goto_3
    if-eqz v4, :cond_5

    invoke-static {p0, p1}, Landroidx/compose/ui/geometry/Size;->getHeight-impl(J)F

    move-result v2

    invoke-static {v2}, Lkotlin/math/MathKt;->roundToInt(F)I

    move-result v2

    invoke-static {v2}, Lcoil/size/-Dimensions;->Dimension(I)Lcoil/size/Dimension$Pixels;

    move-result-object v2

    goto :goto_4

    :cond_5
    sget-object v2, Lcoil/size/Dimension$Undefined;->INSTANCE:Lcoil/size/Dimension$Undefined;

    :goto_4
    check-cast v2, Lcoil/size/Dimension;

    .line 402
    invoke-direct {v0, v1, v2}, Lcoil/size/Size;-><init>(Lcoil/size/Dimension;Lcoil/size/Dimension;)V

    goto :goto_5

    .line 406
    :cond_6
    const/4 v0, 0x0

    .line 407
    :goto_5
    return-object v0
.end method

.method private static final unsupportedData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Void;
    .locals 3
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "description"    # Ljava/lang/String;

    .line 396
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unsupported type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ". "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static synthetic unsupportedData$default(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/Void;
    .locals 0

    .line 393
    and-int/lit8 p2, p2, 0x2

    if-eqz p2, :cond_0

    .line 395
    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    const-string p2, "If you wish to display this "

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string p2, ", use androidx.compose.foundation.Image."

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 393
    :cond_0
    invoke-static {p0, p1}, Lcoil/compose/AsyncImagePainterKt;->unsupportedData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Void;

    move-result-object p0

    return-object p0
.end method

.method private static final validateRequest(Lcoil/request/ImageRequest;)V
    .locals 4
    .param p0, "request"    # Lcoil/request/ImageRequest;

    .line 381
    invoke-virtual {p0}, Lcoil/request/ImageRequest;->getData()Ljava/lang/Object;

    move-result-object v0

    .line 382
    instance-of v1, v0, Lcoil/request/ImageRequest$Builder;

    if-nez v1, :cond_5

    .line 386
    instance-of v1, v0, Landroidx/compose/ui/graphics/ImageBitmap;

    const/4 v2, 0x2

    const/4 v3, 0x0

    if-nez v1, :cond_4

    .line 387
    instance-of v1, v0, Landroidx/compose/ui/graphics/vector/ImageVector;

    if-nez v1, :cond_3

    .line 388
    instance-of v0, v0, Landroidx/compose/ui/graphics/painter/Painter;

    if-nez v0, :cond_2

    .line 390
    invoke-virtual {p0}, Lcoil/request/ImageRequest;->getTarget()Lcoil/target/Target;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    if-eqz v0, :cond_1

    .line 391
    return-void

    .line 422
    :cond_1
    const/4 v0, 0x0

    .line 390
    .local v0, "$i$a$-require-AsyncImagePainterKt$validateRequest$1":I
    nop

    .end local v0    # "$i$a$-require-AsyncImagePainterKt$validateRequest$1":I
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "request.target must be null."

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 388
    :cond_2
    const-string v0, "Painter"

    invoke-static {v0, v3, v2, v3}, Lcoil/compose/AsyncImagePainterKt;->unsupportedData$default(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/Void;

    new-instance v0, Lkotlin/KotlinNothingValueException;

    invoke-direct {v0}, Lkotlin/KotlinNothingValueException;-><init>()V

    throw v0

    .line 387
    :cond_3
    const-string v0, "ImageVector"

    invoke-static {v0, v3, v2, v3}, Lcoil/compose/AsyncImagePainterKt;->unsupportedData$default(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/Void;

    new-instance v0, Lkotlin/KotlinNothingValueException;

    invoke-direct {v0}, Lkotlin/KotlinNothingValueException;-><init>()V

    throw v0

    .line 386
    :cond_4
    const-string v0, "ImageBitmap"

    invoke-static {v0, v3, v2, v3}, Lcoil/compose/AsyncImagePainterKt;->unsupportedData$default(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/Void;

    new-instance v0, Lkotlin/KotlinNothingValueException;

    invoke-direct {v0}, Lkotlin/KotlinNothingValueException;-><init>()V

    throw v0

    .line 383
    :cond_5
    nop

    .line 384
    nop

    .line 382
    const-string v0, "ImageRequest.Builder"

    const-string v1, "Did you forget to call ImageRequest.Builder.build()?"

    invoke-static {v0, v1}, Lcoil/compose/AsyncImagePainterKt;->unsupportedData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Void;

    new-instance v0, Lkotlin/KotlinNothingValueException;

    invoke-direct {v0}, Lkotlin/KotlinNothingValueException;-><init>()V

    throw v0
.end method
