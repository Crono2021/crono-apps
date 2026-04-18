.class public final Lcoil/compose/AsyncImageKt;
.super Ljava/lang/Object;
.source "AsyncImage.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAsyncImage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncImage.kt\ncoil/compose/AsyncImageKt\n+ 2 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 4 Composer.kt\nandroidx/compose/runtime/Updater\n+ 5 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,243:1\n123#2,5:244\n129#2,5:257\n134#2:268\n136#2:271\n286#3,8:249\n294#3,2:269\n25#3:272\n4144#4,6:262\n1097#5,6:273\n*S KotlinDebug\n*F\n+ 1 AsyncImage.kt\ncoil/compose/AsyncImageKt\n*L\n165#1:244,5\n165#1:257,5\n165#1:268\n165#1:271\n165#1:249,8\n165#1:269,2\n189#1:272\n165#1:262,6\n189#1:273,6\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u009d\u0001\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0014\u0008\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u000c0\u000b2\u0016\u0008\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\u0008\u0018\u0010\u0019\u001a\u00db\u0001\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0016\u0008\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\u0008\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\u0008\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\u0008$\u0010%\u001aI\u0010&\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\'\u001a\u00020\u001b2\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0001\u00a2\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0010\u001a\u00020\u0011H\u0001\u00a2\u0006\u0002\u0010,\u001a\u0016\u0010\u0004\u001a\u00020\t*\u00020\t2\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0003\u001a\u001b\u0010-\u001a\u0004\u0018\u00010.*\u00020/H\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\u00080\u00101\u0082\u0002\u000b\n\u0005\u0008\u00a1\u001e0\u0001\n\u0002\u0008\u0019\u00a8\u00062"
    }
    d2 = {
        "AsyncImage",
        "",
        "model",
        "",
        "contentDescription",
        "",
        "imageLoader",
        "Lcoil/ImageLoader;",
        "modifier",
        "Landroidx/compose/ui/Modifier;",
        "transform",
        "Lkotlin/Function1;",
        "Lcoil/compose/AsyncImagePainter$State;",
        "onState",
        "alignment",
        "Landroidx/compose/ui/Alignment;",
        "contentScale",
        "Landroidx/compose/ui/layout/ContentScale;",
        "alpha",
        "",
        "colorFilter",
        "Landroidx/compose/ui/graphics/ColorFilter;",
        "filterQuality",
        "Landroidx/compose/ui/graphics/FilterQuality;",
        "AsyncImage-MvsnxeU",
        "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V",
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
        "AsyncImage-Q4Kwu38",
        "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V",
        "Content",
        "painter",
        "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;I)V",
        "updateRequest",
        "Lcoil/request/ImageRequest;",
        "request",
        "(Lcoil/request/ImageRequest;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)Lcoil/request/ImageRequest;",
        "toSizeOrNull",
        "Lcoil/size/Size;",
        "Landroidx/compose/ui/unit/Constraints;",
        "toSizeOrNull-BRTryo0",
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


# direct methods
.method public static final AsyncImage-MvsnxeU(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V
    .locals 30
    .param p0, "model"    # Ljava/lang/Object;
    .param p1, "contentDescription"    # Ljava/lang/String;
    .param p2, "imageLoader"    # Lcoil/ImageLoader;
    .param p3, "modifier"    # Landroidx/compose/ui/Modifier;
    .param p4, "transform"    # Lkotlin/jvm/functions/Function1;
    .param p5, "onState"    # Lkotlin/jvm/functions/Function1;
    .param p6, "alignment"    # Landroidx/compose/ui/Alignment;
    .param p7, "contentScale"    # Landroidx/compose/ui/layout/ContentScale;
    .param p8, "alpha"    # F
    .param p9, "colorFilter"    # Landroidx/compose/ui/graphics/ColorFilter;
    .param p10, "filterQuality"    # I
    .param p11, "$composer"    # Landroidx/compose/runtime/Composer;
    .param p12, "$changed"    # I
    .param p13, "$changed1"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Ljava/lang/String;",
            "Lcoil/ImageLoader;",
            "Landroidx/compose/ui/Modifier;",
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
            "Landroidx/compose/ui/Alignment;",
            "Landroidx/compose/ui/layout/ContentScale;",
            "F",
            "Landroidx/compose/ui/graphics/ColorFilter;",
            "I",
            "Landroidx/compose/runtime/Composer;",
            "III)V"
        }
    .end annotation

    .line 131
    move/from16 v14, p14

    const v0, -0x79027051

    move-object/from16 v1, p11

    invoke-interface {v1, v0}, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;

    move-result-object v15

    .end local p11    # "$composer":Landroidx/compose/runtime/Composer;
    .local v15, "$composer":Landroidx/compose/runtime/Composer;
    const-string v1, "C(AsyncImage)P(7,3,6,8,10,9!1,4!,5:c#ui.graphics.FilterQuality)"

    invoke-static {v15, v1}, Landroidx/compose/runtime/ComposerKt;->sourceInformation(Landroidx/compose/runtime/Composer;Ljava/lang/String;)V

    move/from16 v13, p12

    .local v13, "$dirty":I
    move/from16 v1, p13

    .local v1, "$dirty1":I
    and-int/lit8 v2, v14, 0x8

    if-eqz v2, :cond_0

    .line 123
    sget-object v2, Landroidx/compose/ui/Modifier;->Companion:Landroidx/compose/ui/Modifier$Companion;

    check-cast v2, Landroidx/compose/ui/Modifier;

    move-object v12, v2

    .end local p3    # "modifier":Landroidx/compose/ui/Modifier;
    .local v2, "modifier":Landroidx/compose/ui/Modifier;
    goto :goto_0

    .line 131
    .end local v2    # "modifier":Landroidx/compose/ui/Modifier;
    .restart local p3    # "modifier":Landroidx/compose/ui/Modifier;
    :cond_0
    move-object/from16 v12, p3

    .line 123
    .end local p3    # "modifier":Landroidx/compose/ui/Modifier;
    .local v12, "modifier":Landroidx/compose/ui/Modifier;
    :goto_0
    and-int/lit8 v2, v14, 0x10

    if-eqz v2, :cond_1

    .line 124
    sget-object v2, Lcoil/compose/AsyncImagePainter;->Companion:Lcoil/compose/AsyncImagePainter$Companion;

    invoke-virtual {v2}, Lcoil/compose/AsyncImagePainter$Companion;->getDefaultTransform()Lkotlin/jvm/functions/Function1;

    move-result-object v2

    move-object/from16 v16, v2

    .end local p4    # "transform":Lkotlin/jvm/functions/Function1;
    .local v2, "transform":Lkotlin/jvm/functions/Function1;
    goto :goto_1

    .line 123
    .end local v2    # "transform":Lkotlin/jvm/functions/Function1;
    .restart local p4    # "transform":Lkotlin/jvm/functions/Function1;
    :cond_1
    move-object/from16 v16, p4

    .line 124
    .end local p4    # "transform":Lkotlin/jvm/functions/Function1;
    .local v16, "transform":Lkotlin/jvm/functions/Function1;
    :goto_1
    and-int/lit8 v2, v14, 0x20

    if-eqz v2, :cond_2

    .line 125
    const/4 v2, 0x0

    move-object/from16 v17, v2

    .end local p5    # "onState":Lkotlin/jvm/functions/Function1;
    .local v2, "onState":Lkotlin/jvm/functions/Function1;
    goto :goto_2

    .line 124
    .end local v2    # "onState":Lkotlin/jvm/functions/Function1;
    .restart local p5    # "onState":Lkotlin/jvm/functions/Function1;
    :cond_2
    move-object/from16 v17, p5

    .line 125
    .end local p5    # "onState":Lkotlin/jvm/functions/Function1;
    .local v17, "onState":Lkotlin/jvm/functions/Function1;
    :goto_2
    and-int/lit8 v2, v14, 0x40

    if-eqz v2, :cond_3

    .line 126
    sget-object v2, Landroidx/compose/ui/Alignment;->Companion:Landroidx/compose/ui/Alignment$Companion;

    invoke-virtual {v2}, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;

    move-result-object v2

    move-object/from16 v18, v2

    .end local p6    # "alignment":Landroidx/compose/ui/Alignment;
    .local v2, "alignment":Landroidx/compose/ui/Alignment;
    goto :goto_3

    .line 125
    .end local v2    # "alignment":Landroidx/compose/ui/Alignment;
    .restart local p6    # "alignment":Landroidx/compose/ui/Alignment;
    :cond_3
    move-object/from16 v18, p6

    .line 126
    .end local p6    # "alignment":Landroidx/compose/ui/Alignment;
    .local v18, "alignment":Landroidx/compose/ui/Alignment;
    :goto_3
    and-int/lit16 v2, v14, 0x80

    if-eqz v2, :cond_4

    .line 127
    sget-object v2, Landroidx/compose/ui/layout/ContentScale;->Companion:Landroidx/compose/ui/layout/ContentScale$Companion;

    invoke-virtual {v2}, Landroidx/compose/ui/layout/ContentScale$Companion;->getFit()Landroidx/compose/ui/layout/ContentScale;

    move-result-object v2

    move-object v11, v2

    .end local p7    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .local v2, "contentScale":Landroidx/compose/ui/layout/ContentScale;
    goto :goto_4

    .line 126
    .end local v2    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .restart local p7    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    :cond_4
    move-object/from16 v11, p7

    .line 127
    .end local p7    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .local v11, "contentScale":Landroidx/compose/ui/layout/ContentScale;
    :goto_4
    and-int/lit16 v2, v14, 0x100

    if-eqz v2, :cond_5

    .line 128
    const/high16 v2, 0x3f800000    # 1.0f

    move/from16 v19, v2

    .end local p8    # "alpha":F
    .local v2, "alpha":F
    goto :goto_5

    .line 127
    .end local v2    # "alpha":F
    .restart local p8    # "alpha":F
    :cond_5
    move/from16 v19, p8

    .line 128
    .end local p8    # "alpha":F
    .local v19, "alpha":F
    :goto_5
    and-int/lit16 v2, v14, 0x200

    if-eqz v2, :cond_6

    .line 129
    const/4 v2, 0x0

    move-object/from16 v20, v2

    .end local p9    # "colorFilter":Landroidx/compose/ui/graphics/ColorFilter;
    .local v2, "colorFilter":Landroidx/compose/ui/graphics/ColorFilter;
    goto :goto_6

    .line 128
    .end local v2    # "colorFilter":Landroidx/compose/ui/graphics/ColorFilter;
    .restart local p9    # "colorFilter":Landroidx/compose/ui/graphics/ColorFilter;
    :cond_6
    move-object/from16 v20, p9

    .line 129
    .end local p9    # "colorFilter":Landroidx/compose/ui/graphics/ColorFilter;
    .local v20, "colorFilter":Landroidx/compose/ui/graphics/ColorFilter;
    :goto_6
    and-int/lit16 v2, v14, 0x400

    if-eqz v2, :cond_7

    .line 130
    sget-object v2, Landroidx/compose/ui/graphics/drawscope/DrawScope;->Companion:Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;

    invoke-virtual {v2}, Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;->getDefaultFilterQuality-f-v9h1I()I

    move-result v2

    .end local p10    # "filterQuality":I
    .local v2, "filterQuality":I
    and-int/lit8 v1, v1, -0xf

    move v10, v1

    move/from16 v21, v2

    goto :goto_7

    .line 129
    .end local v2    # "filterQuality":I
    .restart local p10    # "filterQuality":I
    :cond_7
    move/from16 v21, p10

    move v10, v1

    .line 130
    .end local v1    # "$dirty1":I
    .end local p10    # "filterQuality":I
    .local v10, "$dirty1":I
    .local v21, "filterQuality":I
    :goto_7
    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z

    move-result v1

    if-eqz v1, :cond_8

    .line 131
    const-string v1, "coil.compose.AsyncImage (AsyncImage.kt:130)"

    invoke-static {v0, v13, v10, v1}, Landroidx/compose/runtime/ComposerKt;->traceEventStart(IIILjava/lang/String;)V

    .line 133
    :cond_8
    const/16 v0, 0x8

    move-object/from16 v9, p0

    invoke-static {v9, v15, v0}, Lcoil/compose/UtilsKt;->requestOf(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Lcoil/request/ImageRequest;

    move-result-object v1

    shr-int/lit8 v2, v13, 0x12

    and-int/lit8 v2, v2, 0x70

    or-int/2addr v0, v2

    invoke-static {v1, v11, v15, v0}, Lcoil/compose/AsyncImageKt;->updateRequest(Lcoil/request/ImageRequest;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)Lcoil/request/ImageRequest;

    move-result-object v22

    .line 135
    .local v22, "request":Lcoil/request/ImageRequest;
    shr-int/lit8 v0, v13, 0x6

    and-int/lit16 v0, v0, 0x380

    or-int/lit8 v0, v0, 0x48

    shr-int/lit8 v1, v13, 0x6

    and-int/lit16 v1, v1, 0x1c00

    or-int/2addr v0, v1

    shr-int/lit8 v1, v13, 0x9

    const v2, 0xe000

    and-int/2addr v1, v2

    or-int/2addr v0, v1

    shl-int/lit8 v1, v10, 0xf

    const/high16 v3, 0x70000

    and-int/2addr v1, v3

    or-int/2addr v0, v1

    const/4 v1, 0x0

    .line 134
    move-object/from16 p3, v22

    move-object/from16 p4, p2

    move-object/from16 p5, v16

    move-object/from16 p6, v17

    move-object/from16 p7, v11

    move/from16 p8, v21

    move-object/from16 p9, v15

    move/from16 p10, v0

    move/from16 p11, v1

    invoke-static/range {p3 .. p11}, Lcoil/compose/AsyncImagePainterKt;->rememberAsyncImagePainter-5jETZwI(Ljava/lang/Object;Lcoil/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;

    move-result-object v23

    .line 139
    .local v23, "painter":Lcoil/compose/AsyncImagePainter;
    invoke-virtual/range {v22 .. v22}, Lcoil/request/ImageRequest;->getSizeResolver()Lcoil/size/SizeResolver;

    move-result-object v8

    .line 141
    .local v8, "sizeResolver":Lcoil/size/SizeResolver;
    instance-of v0, v8, Lcoil/compose/ConstraintsSizeResolver;

    if-eqz v0, :cond_9

    .line 142
    move-object v0, v8

    check-cast v0, Landroidx/compose/ui/Modifier;

    invoke-interface {v12, v0}, Landroidx/compose/ui/Modifier;->then(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;

    move-result-object v0

    goto :goto_8

    .line 144
    :cond_9
    move-object v0, v12

    .line 146
    :goto_8
    move-object/from16 v1, v23

    check-cast v1, Landroidx/compose/ui/graphics/painter/Painter;

    .line 147
    nop

    .line 148
    nop

    .line 149
    nop

    .line 150
    nop

    .line 151
    shl-int/lit8 v4, v13, 0x3

    and-int/lit16 v4, v4, 0x380

    shr-int/lit8 v5, v13, 0x9

    and-int/lit16 v5, v5, 0x1c00

    or-int/2addr v4, v5

    shr-int/lit8 v5, v13, 0x9

    and-int/2addr v2, v5

    or-int/2addr v2, v4

    shr-int/lit8 v4, v13, 0x9

    and-int/2addr v3, v4

    or-int/2addr v2, v3

    const/high16 v3, 0x380000

    shr-int/lit8 v4, v13, 0x9

    and-int/2addr v3, v4

    or-int/2addr v2, v3

    .line 140
    move-object/from16 p3, v0

    move-object/from16 p4, v1

    move-object/from16 p5, p1

    move-object/from16 p6, v18

    move-object/from16 p7, v11

    move/from16 p8, v19

    move-object/from16 p9, v20

    move-object/from16 p10, v15

    move/from16 p11, v2

    invoke-static/range {p3 .. p11}, Lcoil/compose/AsyncImageKt;->Content(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;I)V

    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V

    :cond_a
    invoke-interface {v15}, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;

    move-result-object v7

    if-nez v7, :cond_b

    move-object/from16 v25, v8

    move/from16 v26, v10

    move-object/from16 v27, v11

    move-object/from16 v28, v12

    move/from16 v29, v13

    move-object/from16 p11, v15

    goto :goto_9

    :cond_b
    new-instance v24, Lcoil/compose/AsyncImageKt$AsyncImage$1;

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    move-object v4, v12

    move-object/from16 v5, v16

    move-object/from16 v6, v17

    move-object/from16 p11, v15

    move-object v15, v7

    .end local v15    # "$composer":Landroidx/compose/runtime/Composer;
    .restart local p11    # "$composer":Landroidx/compose/runtime/Composer;
    move-object/from16 v7, v18

    move-object/from16 v25, v8

    .end local v8    # "sizeResolver":Lcoil/size/SizeResolver;
    .local v25, "sizeResolver":Lcoil/size/SizeResolver;
    move-object v8, v11

    move/from16 v9, v19

    move/from16 v26, v10

    .end local v10    # "$dirty1":I
    .local v26, "$dirty1":I
    move-object/from16 v10, v20

    move-object/from16 v27, v11

    .end local v11    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .local v27, "contentScale":Landroidx/compose/ui/layout/ContentScale;
    move/from16 v11, v21

    move-object/from16 v28, v12

    .end local v12    # "modifier":Landroidx/compose/ui/Modifier;
    .local v28, "modifier":Landroidx/compose/ui/Modifier;
    move/from16 v12, p12

    move/from16 v29, v13

    .end local v13    # "$dirty":I
    .local v29, "$dirty":I
    move/from16 v13, p13

    move/from16 v14, p14

    invoke-direct/range {v0 .. v14}, Lcoil/compose/AsyncImageKt$AsyncImage$1;-><init>(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IIII)V

    move-object/from16 v0, v24

    check-cast v0, Lkotlin/jvm/functions/Function2;

    invoke-interface {v15, v0}, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V

    .line 153
    :goto_9
    return-void
.end method

.method public static final AsyncImage-Q4Kwu38(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V
    .locals 31
    .param p0, "model"    # Ljava/lang/Object;
    .param p1, "contentDescription"    # Ljava/lang/String;
    .param p2, "imageLoader"    # Lcoil/ImageLoader;
    .param p3, "modifier"    # Landroidx/compose/ui/Modifier;
    .param p4, "placeholder"    # Landroidx/compose/ui/graphics/painter/Painter;
    .param p5, "error"    # Landroidx/compose/ui/graphics/painter/Painter;
    .param p6, "fallback"    # Landroidx/compose/ui/graphics/painter/Painter;
    .param p7, "onLoading"    # Lkotlin/jvm/functions/Function1;
    .param p8, "onSuccess"    # Lkotlin/jvm/functions/Function1;
    .param p9, "onError"    # Lkotlin/jvm/functions/Function1;
    .param p10, "alignment"    # Landroidx/compose/ui/Alignment;
    .param p11, "contentScale"    # Landroidx/compose/ui/layout/ContentScale;
    .param p12, "alpha"    # F
    .param p13, "colorFilter"    # Landroidx/compose/ui/graphics/ColorFilter;
    .param p14, "filterQuality"    # I
    .param p15, "$composer"    # Landroidx/compose/runtime/Composer;
    .param p16, "$changed"    # I
    .param p17, "$changed1"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Ljava/lang/String;",
            "Lcoil/ImageLoader;",
            "Landroidx/compose/ui/Modifier;",
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
            "Landroidx/compose/ui/Alignment;",
            "Landroidx/compose/ui/layout/ContentScale;",
            "F",
            "Landroidx/compose/ui/graphics/ColorFilter;",
            "I",
            "Landroidx/compose/runtime/Composer;",
            "III)V"
        }
    .end annotation

    move-object/from16 v15, p15

    move/from16 v14, p16

    move/from16 v13, p17

    move/from16 v0, p18

    const v1, -0xea92007

    invoke-interface {v15, v1}, Landroidx/compose/runtime/Composer;->startReplaceableGroup(I)V

    const-string v2, "C(AsyncImage)P(9,3,8,10,14,5,6,12,13,11!1,4!,7:c#ui.graphics.FilterQuality)"

    invoke-static {v15, v2}, Landroidx/compose/runtime/ComposerKt;->sourceInformation(Landroidx/compose/runtime/Composer;Ljava/lang/String;)V

    and-int/lit8 v2, v0, 0x8

    if-eqz v2, :cond_0

    .line 69
    sget-object v2, Landroidx/compose/ui/Modifier;->Companion:Landroidx/compose/ui/Modifier$Companion;

    check-cast v2, Landroidx/compose/ui/Modifier;

    move-object/from16 v16, v2

    .end local p3    # "modifier":Landroidx/compose/ui/Modifier;
    .local v2, "modifier":Landroidx/compose/ui/Modifier;
    goto :goto_0

    .line 0
    .end local v2    # "modifier":Landroidx/compose/ui/Modifier;
    .restart local p3    # "modifier":Landroidx/compose/ui/Modifier;
    :cond_0
    move-object/from16 v16, p3

    .line 69
    .end local p3    # "modifier":Landroidx/compose/ui/Modifier;
    .local v16, "modifier":Landroidx/compose/ui/Modifier;
    :goto_0
    and-int/lit8 v2, v0, 0x10

    if-eqz v2, :cond_1

    .line 70
    const/4 v2, 0x0

    move-object v12, v2

    .end local p4    # "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    .local v2, "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    goto :goto_1

    .line 69
    .end local v2    # "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    .restart local p4    # "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    :cond_1
    move-object/from16 v12, p4

    .line 70
    .end local p4    # "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    .local v12, "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    :goto_1
    and-int/lit8 v2, v0, 0x20

    if-eqz v2, :cond_2

    .line 71
    const/4 v2, 0x0

    move-object v11, v2

    .end local p5    # "error":Landroidx/compose/ui/graphics/painter/Painter;
    .local v2, "error":Landroidx/compose/ui/graphics/painter/Painter;
    goto :goto_2

    .line 70
    .end local v2    # "error":Landroidx/compose/ui/graphics/painter/Painter;
    .restart local p5    # "error":Landroidx/compose/ui/graphics/painter/Painter;
    :cond_2
    move-object/from16 v11, p5

    .line 71
    .end local p5    # "error":Landroidx/compose/ui/graphics/painter/Painter;
    .local v11, "error":Landroidx/compose/ui/graphics/painter/Painter;
    :goto_2
    and-int/lit8 v2, v0, 0x40

    if-eqz v2, :cond_3

    .line 72
    move-object v2, v11

    move-object v10, v2

    .end local p6    # "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    .local v2, "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    goto :goto_3

    .line 71
    .end local v2    # "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    .restart local p6    # "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    :cond_3
    move-object/from16 v10, p6

    .line 72
    .end local p6    # "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    .local v10, "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    :goto_3
    and-int/lit16 v2, v0, 0x80

    if-eqz v2, :cond_4

    .line 73
    const/4 v2, 0x0

    move-object v9, v2

    .end local p7    # "onLoading":Lkotlin/jvm/functions/Function1;
    .local v2, "onLoading":Lkotlin/jvm/functions/Function1;
    goto :goto_4

    .line 72
    .end local v2    # "onLoading":Lkotlin/jvm/functions/Function1;
    .restart local p7    # "onLoading":Lkotlin/jvm/functions/Function1;
    :cond_4
    move-object/from16 v9, p7

    .line 73
    .end local p7    # "onLoading":Lkotlin/jvm/functions/Function1;
    .local v9, "onLoading":Lkotlin/jvm/functions/Function1;
    :goto_4
    and-int/lit16 v2, v0, 0x100

    if-eqz v2, :cond_5

    .line 74
    const/4 v2, 0x0

    move-object v8, v2

    .end local p8    # "onSuccess":Lkotlin/jvm/functions/Function1;
    .local v2, "onSuccess":Lkotlin/jvm/functions/Function1;
    goto :goto_5

    .line 73
    .end local v2    # "onSuccess":Lkotlin/jvm/functions/Function1;
    .restart local p8    # "onSuccess":Lkotlin/jvm/functions/Function1;
    :cond_5
    move-object/from16 v8, p8

    .line 74
    .end local p8    # "onSuccess":Lkotlin/jvm/functions/Function1;
    .local v8, "onSuccess":Lkotlin/jvm/functions/Function1;
    :goto_5
    and-int/lit16 v2, v0, 0x200

    if-eqz v2, :cond_6

    .line 75
    const/4 v2, 0x0

    move-object v7, v2

    .end local p9    # "onError":Lkotlin/jvm/functions/Function1;
    .local v2, "onError":Lkotlin/jvm/functions/Function1;
    goto :goto_6

    .line 74
    .end local v2    # "onError":Lkotlin/jvm/functions/Function1;
    .restart local p9    # "onError":Lkotlin/jvm/functions/Function1;
    :cond_6
    move-object/from16 v7, p9

    .line 75
    .end local p9    # "onError":Lkotlin/jvm/functions/Function1;
    .local v7, "onError":Lkotlin/jvm/functions/Function1;
    :goto_6
    and-int/lit16 v2, v0, 0x400

    if-eqz v2, :cond_7

    .line 76
    sget-object v2, Landroidx/compose/ui/Alignment;->Companion:Landroidx/compose/ui/Alignment$Companion;

    invoke-virtual {v2}, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;

    move-result-object v2

    move-object/from16 v17, v2

    .end local p10    # "alignment":Landroidx/compose/ui/Alignment;
    .local v2, "alignment":Landroidx/compose/ui/Alignment;
    goto :goto_7

    .line 75
    .end local v2    # "alignment":Landroidx/compose/ui/Alignment;
    .restart local p10    # "alignment":Landroidx/compose/ui/Alignment;
    :cond_7
    move-object/from16 v17, p10

    .line 76
    .end local p10    # "alignment":Landroidx/compose/ui/Alignment;
    .local v17, "alignment":Landroidx/compose/ui/Alignment;
    :goto_7
    and-int/lit16 v2, v0, 0x800

    if-eqz v2, :cond_8

    .line 77
    sget-object v2, Landroidx/compose/ui/layout/ContentScale;->Companion:Landroidx/compose/ui/layout/ContentScale$Companion;

    invoke-virtual {v2}, Landroidx/compose/ui/layout/ContentScale$Companion;->getFit()Landroidx/compose/ui/layout/ContentScale;

    move-result-object v2

    move-object/from16 v18, v2

    .end local p11    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .local v2, "contentScale":Landroidx/compose/ui/layout/ContentScale;
    goto :goto_8

    .line 76
    .end local v2    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .restart local p11    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    :cond_8
    move-object/from16 v18, p11

    .line 77
    .end local p11    # "contentScale":Landroidx/compose/ui/layout/ContentScale;
    .local v18, "contentScale":Landroidx/compose/ui/layout/ContentScale;
    :goto_8
    and-int/lit16 v2, v0, 0x1000

    if-eqz v2, :cond_9

    .line 78
    const/high16 v2, 0x3f800000    # 1.0f

    move/from16 v19, v2

    .end local p12    # "alpha":F
    .local v2, "alpha":F
    goto :goto_9

    .line 77
    .end local v2    # "alpha":F
    .restart local p12    # "alpha":F
    :cond_9
    move/from16 v19, p12

    .line 78
    .end local p12    # "alpha":F
    .local v19, "alpha":F
    :goto_9
    and-int/lit16 v2, v0, 0x2000

    if-eqz v2, :cond_a

    .line 79
    const/4 v2, 0x0

    move-object/from16 v20, v2

    .end local p13    # "colorFilter":Landroidx/compose/ui/graphics/ColorFilter;
    .local v2, "colorFilter":Landroidx/compose/ui/graphics/ColorFilter;
    goto :goto_a

    .line 78
    .end local v2    # "colorFilter":Landroidx/compose/ui/graphics/ColorFilter;
    .restart local p13    # "colorFilter":Landroidx/compose/ui/graphics/ColorFilter;
    :cond_a
    move-object/from16 v20, p13

    .line 79
    .end local p13    # "colorFilter":Landroidx/compose/ui/graphics/ColorFilter;
    .local v20, "colorFilter":Landroidx/compose/ui/graphics/ColorFilter;
    :goto_a
    and-int/lit16 v0, v0, 0x4000

    if-eqz v0, :cond_b

    .line 80
    sget-object v0, Landroidx/compose/ui/graphics/drawscope/DrawScope;->Companion:Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;

    invoke-virtual {v0}, Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;->getDefaultFilterQuality-f-v9h1I()I

    move-result v0

    move/from16 v21, v0

    .end local p14    # "filterQuality":I
    .local v0, "filterQuality":I
    goto :goto_b

    .line 79
    .end local v0    # "filterQuality":I
    .restart local p14    # "filterQuality":I
    :cond_b
    move/from16 v21, p14

    .line 80
    .end local p14    # "filterQuality":I
    .local v21, "filterQuality":I
    :goto_b
    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 81
    const-string v0, "coil.compose.AsyncImage (AsyncImage.kt:80)"

    invoke-static {v1, v14, v13, v0}, Landroidx/compose/runtime/ComposerKt;->traceEventStart(IIILjava/lang/String;)V

    .line 82
    :cond_c
    nop

    .line 83
    nop

    .line 84
    nop

    .line 85
    nop

    .line 86
    invoke-static {v12, v11, v10}, Lcoil/compose/UtilsKt;->transformOf(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;)Lkotlin/jvm/functions/Function1;

    move-result-object v4

    .line 87
    invoke-static {v9, v8, v7}, Lcoil/compose/UtilsKt;->onStateOf(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;

    move-result-object v5

    .line 88
    nop

    .line 89
    nop

    .line 90
    nop

    .line 91
    nop

    .line 92
    and-int/lit8 v0, v14, 0x70

    or-int/lit16 v0, v0, 0x208

    and-int/lit16 v1, v14, 0x1c00

    or-int/2addr v0, v1

    shl-int/lit8 v1, v13, 0x12

    const/high16 v2, 0x380000

    and-int/2addr v1, v2

    or-int/2addr v0, v1

    shl-int/lit8 v1, v13, 0x12

    const/high16 v2, 0x1c00000

    and-int/2addr v1, v2

    or-int/2addr v0, v1

    shl-int/lit8 v1, v13, 0x12

    const/high16 v2, 0xe000000

    and-int/2addr v1, v2

    or-int/2addr v0, v1

    const/high16 v1, 0x70000000

    shl-int/lit8 v2, v13, 0x12

    and-int/2addr v1, v2

    or-int v22, v0, v1

    shr-int/lit8 v0, v13, 0xc

    and-int/lit8 v23, v0, 0xe

    const/16 v24, 0x0

    .line 81
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, v16

    move-object/from16 v6, v17

    move-object/from16 v25, v7

    .end local v7    # "onError":Lkotlin/jvm/functions/Function1;
    .local v25, "onError":Lkotlin/jvm/functions/Function1;
    move-object/from16 v7, v18

    move-object/from16 v26, v8

    .end local v8    # "onSuccess":Lkotlin/jvm/functions/Function1;
    .local v26, "onSuccess":Lkotlin/jvm/functions/Function1;
    move/from16 v8, v19

    move-object/from16 v27, v9

    .end local v9    # "onLoading":Lkotlin/jvm/functions/Function1;
    .local v27, "onLoading":Lkotlin/jvm/functions/Function1;
    move-object/from16 v9, v20

    move-object/from16 v28, v10

    .end local v10    # "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    .local v28, "fallback":Landroidx/compose/ui/graphics/painter/Painter;
    move/from16 v10, v21

    move-object/from16 v29, v11

    .end local v11    # "error":Landroidx/compose/ui/graphics/painter/Painter;
    .local v29, "error":Landroidx/compose/ui/graphics/painter/Painter;
    move-object/from16 v11, p15

    move-object/from16 v30, v12

    .end local v12    # "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    .local v30, "placeholder":Landroidx/compose/ui/graphics/painter/Painter;
    move/from16 v12, v22

    move/from16 v13, v23

    move/from16 v14, v24

    invoke-static/range {v0 .. v14}, Lcoil/compose/AsyncImageKt;->AsyncImage-MvsnxeU(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V

    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z

    move-result v0

    if-eqz v0, :cond_d

    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V

    :cond_d
    invoke-interface/range {p15 .. p15}, Landroidx/compose/runtime/Composer;->endReplaceableGroup()V

    .line 93
    return-void
.end method

.method public static final Content(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;I)V
    .locals 19
    .param p0, "modifier"    # Landroidx/compose/ui/Modifier;
    .param p1, "painter"    # Landroidx/compose/ui/graphics/painter/Painter;
    .param p2, "contentDescription"    # Ljava/lang/String;
    .param p3, "alignment"    # Landroidx/compose/ui/Alignment;
    .param p4, "contentScale"    # Landroidx/compose/ui/layout/ContentScale;
    .param p5, "alpha"    # F
    .param p6, "colorFilter"    # Landroidx/compose/ui/graphics/ColorFilter;
    .param p7, "$composer"    # Landroidx/compose/runtime/Composer;
    .param p8, "$changed"    # I

    .line 165
    const v0, 0x9d0565

    move-object/from16 v1, p7

    invoke-interface {v1, v0}, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;

    move-result-object v1

    .end local p7    # "$composer":Landroidx/compose/runtime/Composer;
    .local v1, "$composer":Landroidx/compose/runtime/Composer;
    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v2, -0x1

    const-string v3, "coil.compose.Content (AsyncImage.kt:164)"

    move/from16 v13, p8

    invoke-static {v0, v13, v2, v3}, Landroidx/compose/runtime/ComposerKt;->traceEventStart(IIILjava/lang/String;)V

    goto :goto_0

    :cond_0
    move/from16 v13, p8

    .line 166
    :goto_0
    nop

    .line 167
    move-object/from16 v0, p0

    move-object/from16 v2, p2

    invoke-static {v0, v2}, Lcoil/compose/AsyncImageKt;->contentDescription(Landroidx/compose/ui/Modifier;Ljava/lang/String;)Landroidx/compose/ui/Modifier;

    move-result-object v3

    .line 168
    invoke-static {v3}, Landroidx/compose/ui/draw/ClipKt;->clipToBounds(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;

    move-result-object v3

    .line 170
    new-instance v10, Lcoil/compose/ContentPainterModifier;

    .line 171
    nop

    .line 172
    nop

    .line 173
    nop

    .line 174
    nop

    .line 175
    nop

    .line 170
    move-object v4, v10

    move-object/from16 v5, p1

    move-object/from16 v6, p3

    move-object/from16 v7, p4

    move/from16 v8, p5

    move-object/from16 v9, p6

    invoke-direct/range {v4 .. v9}, Lcoil/compose/ContentPainterModifier;-><init>(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V

    check-cast v10, Landroidx/compose/ui/Modifier;

    .line 169
    invoke-interface {v3, v10}, Landroidx/compose/ui/Modifier;->then(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;

    move-result-object v3

    .line 165
    sget-object v4, Lcoil/compose/AsyncImageKt$Content$1;->INSTANCE:Lcoil/compose/AsyncImageKt$Content$1;

    check-cast v4, Landroidx/compose/ui/layout/MeasurePolicy;

    .local v4, "measurePolicy$iv":Landroidx/compose/ui/layout/MeasurePolicy;
    const/16 v5, 0x30

    .local v3, "modifier$iv":Landroidx/compose/ui/Modifier;
    .local v5, "$changed$iv":I
    const/4 v6, 0x0

    .local v6, "$i$f$Layout":I
    const v7, 0x207baf9a

    invoke-interface {v1, v7}, Landroidx/compose/runtime/Composer;->startReplaceableGroup(I)V

    const-string v7, "CC(Layout)P(1)122@4734L23,125@4885L385:Layout.kt#80mrfh"

    invoke-static {v1, v7}, Landroidx/compose/runtime/ComposerKt;->sourceInformation(Landroidx/compose/runtime/Composer;Ljava/lang/String;)V

    .line 244
    const/4 v7, 0x0

    invoke-static {v1, v7}, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHash(Landroidx/compose/runtime/Composer;I)I

    move-result v7

    .line 245
    .local v7, "compositeKeyHash$iv":I
    invoke-static {v1, v3}, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;

    move-result-object v8

    .line 246
    .local v8, "materialized$iv":Landroidx/compose/ui/Modifier;
    invoke-interface {v1}, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;

    move-result-object v9

    .line 248
    .local v9, "localMap$iv":Landroidx/compose/runtime/CompositionLocalMap;
    sget-object v10, Landroidx/compose/ui/node/ComposeUiNode;->Companion:Landroidx/compose/ui/node/ComposeUiNode$Companion;

    invoke-virtual {v10}, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;

    move-result-object v10

    .line 247
    nop

    .local v10, "factory$iv$iv":Lkotlin/jvm/functions/Function0;
    const/4 v11, 0x6

    .local v11, "$changed$iv$iv":I
    const/4 v12, 0x0

    .local v12, "$i$f$ReusableComposeNode":I
    const v14, 0x53ca7ea5

    invoke-interface {v1, v14}, Landroidx/compose/runtime/Composer;->startReplaceableGroup(I)V

    const-string v14, "CC(ReusableComposeNode):Composables.kt#9igjgp"

    invoke-static {v1, v14}, Landroidx/compose/runtime/ComposerKt;->sourceInformation(Landroidx/compose/runtime/Composer;Ljava/lang/String;)V

    .line 249
    invoke-interface {v1}, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;

    move-result-object v14

    instance-of v14, v14, Landroidx/compose/runtime/Applier;

    if-nez v14, :cond_1

    invoke-static {}, Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V

    .line 250
    :cond_1
    invoke-interface {v1}, Landroidx/compose/runtime/Composer;->startReusableNode()V

    .line 251
    invoke-interface {v1}, Landroidx/compose/runtime/Composer;->getInserting()Z

    move-result v14

    if-eqz v14, :cond_2

    .line 252
    new-instance v14, Lcoil/compose/AsyncImageKt$Content$$inlined$Layout$1;

    invoke-direct {v14, v10}, Lcoil/compose/AsyncImageKt$Content$$inlined$Layout$1;-><init>(Lkotlin/jvm/functions/Function0;)V

    check-cast v14, Lkotlin/jvm/functions/Function0;

    invoke-interface {v1, v14}, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V

    goto :goto_1

    .line 254
    :cond_2
    invoke-interface {v1}, Landroidx/compose/runtime/Composer;->useNode()V

    .line 256
    :goto_1
    invoke-static {v1}, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;

    move-result-object v14

    .local v14, "$this$Layout_u24lambda_u241$iv":Landroidx/compose/runtime/Composer;
    const/4 v15, 0x0

    .line 257
    .local v15, "$i$a$-ReusableComposeNode-LayoutKt$Layout$2$iv":I
    sget-object v16, Landroidx/compose/ui/node/ComposeUiNode;->Companion:Landroidx/compose/ui/node/ComposeUiNode$Companion;

    invoke-virtual/range {v16 .. v16}, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;

    move-result-object v0

    invoke-static {v14, v4, v0}, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V

    .line 258
    sget-object v0, Landroidx/compose/ui/node/ComposeUiNode;->Companion:Landroidx/compose/ui/node/ComposeUiNode$Companion;

    invoke-virtual {v0}, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;

    move-result-object v0

    invoke-static {v14, v9, v0}, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V

    .line 259
    sget-object v0, Landroidx/compose/ui/node/ComposeUiNode;->Companion:Landroidx/compose/ui/node/ComposeUiNode$Companion;

    invoke-virtual {v0}, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;

    move-result-object v0

    invoke-static {v14, v8, v0}, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V

    .line 261
    sget-object v0, Landroidx/compose/ui/node/ComposeUiNode;->Companion:Landroidx/compose/ui/node/ComposeUiNode$Companion;

    invoke-virtual {v0}, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;

    move-result-object v0

    .local v0, "block$iv$iv":Lkotlin/jvm/functions/Function2;
    const/16 v16, 0x0

    .line 262
    .local v16, "$i$f$set-impl":I
    move-object/from16 p7, v14

    .local p7, "$this$set_impl_u24lambda_u240$iv$iv":Landroidx/compose/runtime/Composer;
    const/16 v17, 0x0

    .line 263
    .local v17, "$i$a$-with-Updater$set$1$iv$iv":I
    invoke-interface/range {p7 .. p7}, Landroidx/compose/runtime/Composer;->getInserting()Z

    move-result v18

    if-nez v18, :cond_4

    invoke-interface/range {p7 .. p7}, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;

    move-result-object v2

    move-object/from16 v18, v3

    .end local v3    # "modifier$iv":Landroidx/compose/ui/Modifier;
    .local v18, "modifier$iv":Landroidx/compose/ui/Modifier;
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    goto :goto_2

    :cond_3
    move-object/from16 v3, p7

    goto :goto_3

    .end local v18    # "modifier$iv":Landroidx/compose/ui/Modifier;
    .restart local v3    # "modifier$iv":Landroidx/compose/ui/Modifier;
    :cond_4
    move-object/from16 v18, v3

    .line 264
    .end local v3    # "modifier$iv":Landroidx/compose/ui/Modifier;
    .restart local v18    # "modifier$iv":Landroidx/compose/ui/Modifier;
    :goto_2
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    move-object/from16 v3, p7

    .end local p7    # "$this$set_impl_u24lambda_u240$iv$iv":Landroidx/compose/runtime/Composer;
    .local v3, "$this$set_impl_u24lambda_u240$iv$iv":Landroidx/compose/runtime/Composer;
    invoke-interface {v3, v2}, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V

    .line 265
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v14, v2, v0}, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V

    .line 267
    :goto_3
    nop

    .line 262
    .end local v3    # "$this$set_impl_u24lambda_u240$iv$iv":Landroidx/compose/runtime/Composer;
    .end local v17    # "$i$a$-with-Updater$set$1$iv$iv":I
    nop

    .line 267
    nop

    .line 268
    .end local v0    # "block$iv$iv":Lkotlin/jvm/functions/Function2;
    .end local v16    # "$i$f$set-impl":I
    nop

    .line 256
    .end local v14    # "$this$Layout_u24lambda_u241$iv":Landroidx/compose/runtime/Composer;
    .end local v15    # "$i$a$-ReusableComposeNode-LayoutKt$Layout$2$iv":I
    nop

    .line 269
    invoke-interface {v1}, Landroidx/compose/runtime/Composer;->endNode()V

    invoke-interface {v1}, Landroidx/compose/runtime/Composer;->endReplaceableGroup()V

    .line 270
    nop

    .end local v10    # "factory$iv$iv":Lkotlin/jvm/functions/Function0;
    .end local v11    # "$changed$iv$iv":I
    .end local v12    # "$i$f$ReusableComposeNode":I
    invoke-interface {v1}, Landroidx/compose/runtime/Composer;->endReplaceableGroup()V

    .line 271
    nop

    .end local v4    # "measurePolicy$iv":Landroidx/compose/ui/layout/MeasurePolicy;
    .end local v5    # "$changed$iv":I
    .end local v6    # "$i$f$Layout":I
    .end local v7    # "compositeKeyHash$iv":I
    .end local v8    # "materialized$iv":Landroidx/compose/ui/Modifier;
    .end local v9    # "localMap$iv":Landroidx/compose/runtime/CompositionLocalMap;
    .end local v18    # "modifier$iv":Landroidx/compose/ui/Modifier;
    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V

    :cond_5
    invoke-interface {v1}, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;

    move-result-object v0

    if-nez v0, :cond_6

    goto :goto_4

    :cond_6
    new-instance v2, Lcoil/compose/AsyncImageKt$Content$2;

    move-object v4, v2

    move-object/from16 v5, p0

    move-object/from16 v6, p1

    move-object/from16 v7, p2

    move-object/from16 v8, p3

    move-object/from16 v9, p4

    move/from16 v10, p5

    move-object/from16 v11, p6

    move/from16 v12, p8

    invoke-direct/range {v4 .. v12}, Lcoil/compose/AsyncImageKt$Content$2;-><init>(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;I)V

    check-cast v2, Lkotlin/jvm/functions/Function2;

    invoke-interface {v0, v2}, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V

    .line 181
    :goto_4
    return-void
.end method

.method public static final synthetic access$toSizeOrNull-BRTryo0(J)Lcoil/size/Size;
    .locals 1
    .param p0, "$receiver"    # J

    .line 1
    invoke-static {p0, p1}, Lcoil/compose/AsyncImageKt;->toSizeOrNull-BRTryo0(J)Lcoil/size/Size;

    move-result-object v0

    return-object v0
.end method

.method private static final contentDescription(Landroidx/compose/ui/Modifier;Ljava/lang/String;)Landroidx/compose/ui/Modifier;
    .locals 4
    .param p0, "$this$contentDescription"    # Landroidx/compose/ui/Modifier;
    .param p1, "contentDescription"    # Ljava/lang/String;

    .line 225
    if-eqz p1, :cond_0

    .line 226
    new-instance v0, Lcoil/compose/AsyncImageKt$contentDescription$1;

    invoke-direct {v0, p1}, Lcoil/compose/AsyncImageKt$contentDescription$1;-><init>(Ljava/lang/String;)V

    check-cast v0, Lkotlin/jvm/functions/Function1;

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-static {p0, v3, v0, v1, v2}, Landroidx/compose/ui/semantics/SemanticsModifierKt;->semantics$default(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;ILjava/lang/Object;)Landroidx/compose/ui/Modifier;

    move-result-object v0

    return-object v0

    .line 231
    :cond_0
    return-object p0
.end method

.method private static final toSizeOrNull-BRTryo0(J)Lcoil/size/Size;
    .locals 3
    .param p0, "$this$toSizeOrNull_u2dBRTryo0"    # J

    .line 236
    nop

    .line 237
    invoke-static {p0, p1}, Landroidx/compose/ui/unit/Constraints;->isZero-impl(J)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    goto :goto_2

    .line 238
    :cond_0
    new-instance v0, Lcoil/size/Size;

    .line 239
    invoke-static {p0, p1}, Landroidx/compose/ui/unit/Constraints;->getHasBoundedWidth-impl(J)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {p0, p1}, Landroidx/compose/ui/unit/Constraints;->getMaxWidth-impl(J)I

    move-result v1

    invoke-static {v1}, Lcoil/size/-Dimensions;->Dimension(I)Lcoil/size/Dimension$Pixels;

    move-result-object v1

    goto :goto_0

    :cond_1
    sget-object v1, Lcoil/size/Dimension$Undefined;->INSTANCE:Lcoil/size/Dimension$Undefined;

    :goto_0
    check-cast v1, Lcoil/size/Dimension;

    .line 240
    invoke-static {p0, p1}, Landroidx/compose/ui/unit/Constraints;->getHasBoundedHeight-impl(J)Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-static {p0, p1}, Landroidx/compose/ui/unit/Constraints;->getMaxHeight-impl(J)I

    move-result v2

    invoke-static {v2}, Lcoil/size/-Dimensions;->Dimension(I)Lcoil/size/Dimension$Pixels;

    move-result-object v2

    goto :goto_1

    :cond_2
    sget-object v2, Lcoil/size/Dimension$Undefined;->INSTANCE:Lcoil/size/Dimension$Undefined;

    :goto_1
    check-cast v2, Lcoil/size/Dimension;

    .line 238
    invoke-direct {v0, v1, v2}, Lcoil/size/Size;-><init>(Lcoil/size/Dimension;Lcoil/size/Dimension;)V

    .line 242
    :goto_2
    return-object v0
.end method

.method public static final updateRequest(Lcoil/request/ImageRequest;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)Lcoil/request/ImageRequest;
    .locals 9
    .param p0, "request"    # Lcoil/request/ImageRequest;
    .param p1, "contentScale"    # Landroidx/compose/ui/layout/ContentScale;
    .param p2, "$composer"    # Landroidx/compose/runtime/Composer;
    .param p3, "$changed"    # I

    const v0, 0x17fba9d7

    invoke-interface {p2, v0}, Landroidx/compose/runtime/Composer;->startReplaceableGroup(I)V

    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 184
    const/4 v1, -0x1

    const-string v2, "coil.compose.updateRequest (AsyncImage.kt:183)"

    invoke-static {v0, p3, v1, v2}, Landroidx/compose/runtime/ComposerKt;->traceEventStart(IIILjava/lang/String;)V

    .line 185
    :cond_0
    invoke-virtual {p0}, Lcoil/request/ImageRequest;->getDefined()Lcoil/request/DefinedRequestOptions;

    move-result-object v0

    invoke-virtual {v0}, Lcoil/request/DefinedRequestOptions;->getSizeResolver()Lcoil/size/SizeResolver;

    move-result-object v0

    if-nez v0, :cond_3

    .line 186
    sget-object v0, Landroidx/compose/ui/layout/ContentScale;->Companion:Landroidx/compose/ui/layout/ContentScale$Companion;

    invoke-virtual {v0}, Landroidx/compose/ui/layout/ContentScale$Companion;->getNone()Landroidx/compose/ui/layout/FixedScale;

    move-result-object v0

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 187
    sget-object v0, Lcoil/size/Size;->ORIGINAL:Lcoil/size/Size;

    invoke-static {v0}, Lcoil/size/SizeResolvers;->create(Lcoil/size/Size;)Lcoil/size/SizeResolver;

    move-result-object v0

    goto :goto_1

    :cond_1
    nop

    .line 189
    const/4 v0, 0x0

    .local v0, "$changed$iv":I
    const/4 v1, 0x0

    .local v1, "$i$f$remember":I
    const v2, -0x1d58f75c

    invoke-interface {p2, v2}, Landroidx/compose/runtime/Composer;->startReplaceableGroup(I)V

    const-string v2, "CC(remember):Composables.kt#9igjgp"

    invoke-static {p2, v2}, Landroidx/compose/runtime/ComposerKt;->sourceInformation(Landroidx/compose/runtime/Composer;Ljava/lang/String;)V

    .line 272
    const/4 v2, 0x0

    .local v2, "invalid$iv$iv":Z
    move-object v3, p2

    .local v3, "$this$cache$iv$iv":Landroidx/compose/runtime/Composer;
    const/4 v4, 0x0

    .line 273
    .local v4, "$i$f$cache":I
    invoke-interface {v3}, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;

    move-result-object v5

    .local v5, "it$iv$iv":Ljava/lang/Object;
    const/4 v6, 0x0

    .line 274
    .local v6, "$i$a$-let-ComposerKt$cache$1$iv$iv":I
    sget-object v7, Landroidx/compose/runtime/Composer;->Companion:Landroidx/compose/runtime/Composer$Companion;

    invoke-virtual {v7}, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;

    move-result-object v7

    if-ne v5, v7, :cond_2

    .line 275
    const/4 v7, 0x0

    .line 189
    .local v7, "$i$a$-remember-AsyncImageKt$updateRequest$sizeResolver$1":I
    new-instance v8, Lcoil/compose/ConstraintsSizeResolver;

    invoke-direct {v8}, Lcoil/compose/ConstraintsSizeResolver;-><init>()V

    .line 275
    .end local v7    # "$i$a$-remember-AsyncImageKt$updateRequest$sizeResolver$1":I
    move-object v7, v8

    .line 276
    .local v7, "value$iv$iv":Ljava/lang/Object;
    invoke-interface {v3, v7}, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V

    .line 277
    nop

    .end local v7    # "value$iv$iv":Ljava/lang/Object;
    goto :goto_0

    .line 278
    :cond_2
    move-object v7, v5

    .line 274
    :goto_0
    nop

    .line 273
    .end local v5    # "it$iv$iv":Ljava/lang/Object;
    .end local v6    # "$i$a$-let-ComposerKt$cache$1$iv$iv":I
    nop

    .line 272
    .end local v2    # "invalid$iv$iv":Z
    .end local v3    # "$this$cache$iv$iv":Landroidx/compose/runtime/Composer;
    .end local v4    # "$i$f$cache":I
    invoke-interface {p2}, Landroidx/compose/runtime/Composer;->endReplaceableGroup()V

    .end local v0    # "$changed$iv":I
    .end local v1    # "$i$f$remember":I
    move-object v0, v7

    check-cast v0, Lcoil/size/SizeResolver;

    .line 186
    :goto_1
    nop

    .line 191
    .local v0, "sizeResolver":Lcoil/size/SizeResolver;
    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-static {p0, v2, v1, v2}, Lcoil/request/ImageRequest;->newBuilder$default(Lcoil/request/ImageRequest;Landroid/content/Context;ILjava/lang/Object;)Lcoil/request/ImageRequest$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcoil/request/ImageRequest$Builder;->size(Lcoil/size/SizeResolver;)Lcoil/request/ImageRequest$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcoil/request/ImageRequest$Builder;->build()Lcoil/request/ImageRequest;

    move-result-object v0

    .end local v0    # "sizeResolver":Lcoil/size/SizeResolver;
    goto :goto_2

    .line 193
    :cond_3
    move-object v0, p0

    .line 185
    :goto_2
    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-static {}, Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V

    :cond_4
    invoke-interface {p2}, Landroidx/compose/runtime/Composer;->endReplaceableGroup()V

    return-object v0
.end method
