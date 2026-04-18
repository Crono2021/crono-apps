.class final Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;
.super Lkotlin/jvm/internal/Lambda;
.source "SingletonSubcomposeAsyncImage.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcoil/compose/SingletonSubcomposeAsyncImageKt;->SubcomposeAsyncImage-ylYTKUw(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function2<",
        "Landroidx/compose/runtime/Composer;",
        "Ljava/lang/Integer;",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    k = 0x3
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic $$changed:I

.field final synthetic $$changed1:I

.field final synthetic $$default:I

.field final synthetic $alignment:Landroidx/compose/ui/Alignment;

.field final synthetic $alpha:F

.field final synthetic $colorFilter:Landroidx/compose/ui/graphics/ColorFilter;

.field final synthetic $contentDescription:Ljava/lang/String;

.field final synthetic $contentScale:Landroidx/compose/ui/layout/ContentScale;

.field final synthetic $error:Lkotlin/jvm/functions/Function4;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/functions/Function4<",
            "Lcoil/compose/SubcomposeAsyncImageScope;",
            "Lcoil/compose/AsyncImagePainter$State$Error;",
            "Landroidx/compose/runtime/Composer;",
            "Ljava/lang/Integer;",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic $filterQuality:I

.field final synthetic $loading:Lkotlin/jvm/functions/Function4;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/functions/Function4<",
            "Lcoil/compose/SubcomposeAsyncImageScope;",
            "Lcoil/compose/AsyncImagePainter$State$Loading;",
            "Landroidx/compose/runtime/Composer;",
            "Ljava/lang/Integer;",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic $model:Ljava/lang/Object;

.field final synthetic $modifier:Landroidx/compose/ui/Modifier;

.field final synthetic $onError:Lkotlin/jvm/functions/Function1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/functions/Function1<",
            "Lcoil/compose/AsyncImagePainter$State$Error;",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic $onLoading:Lkotlin/jvm/functions/Function1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/functions/Function1<",
            "Lcoil/compose/AsyncImagePainter$State$Loading;",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/functions/Function1<",
            "Lcoil/compose/AsyncImagePainter$State$Success;",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic $success:Lkotlin/jvm/functions/Function4;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/functions/Function4<",
            "Lcoil/compose/SubcomposeAsyncImageScope;",
            "Lcoil/compose/AsyncImagePainter$State$Success;",
            "Landroidx/compose/runtime/Composer;",
            "Ljava/lang/Integer;",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IIII)V
    .locals 16
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Ljava/lang/String;",
            "Landroidx/compose/ui/Modifier;",
            "Lkotlin/jvm/functions/Function4<",
            "-",
            "Lcoil/compose/SubcomposeAsyncImageScope;",
            "-",
            "Lcoil/compose/AsyncImagePainter$State$Loading;",
            "-",
            "Landroidx/compose/runtime/Composer;",
            "-",
            "Ljava/lang/Integer;",
            "Lkotlin/Unit;",
            ">;",
            "Lkotlin/jvm/functions/Function4<",
            "-",
            "Lcoil/compose/SubcomposeAsyncImageScope;",
            "-",
            "Lcoil/compose/AsyncImagePainter$State$Success;",
            "-",
            "Landroidx/compose/runtime/Composer;",
            "-",
            "Ljava/lang/Integer;",
            "Lkotlin/Unit;",
            ">;",
            "Lkotlin/jvm/functions/Function4<",
            "-",
            "Lcoil/compose/SubcomposeAsyncImageScope;",
            "-",
            "Lcoil/compose/AsyncImagePainter$State$Error;",
            "-",
            "Landroidx/compose/runtime/Composer;",
            "-",
            "Ljava/lang/Integer;",
            "Lkotlin/Unit;",
            ">;",
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
            "IIII)V"
        }
    .end annotation

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    iput-object v1, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$model:Ljava/lang/Object;

    move-object/from16 v2, p2

    iput-object v2, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$contentDescription:Ljava/lang/String;

    move-object/from16 v3, p3

    iput-object v3, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$modifier:Landroidx/compose/ui/Modifier;

    move-object/from16 v4, p4

    iput-object v4, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$loading:Lkotlin/jvm/functions/Function4;

    move-object/from16 v5, p5

    iput-object v5, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$success:Lkotlin/jvm/functions/Function4;

    move-object/from16 v6, p6

    iput-object v6, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$error:Lkotlin/jvm/functions/Function4;

    move-object/from16 v7, p7

    iput-object v7, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$onLoading:Lkotlin/jvm/functions/Function1;

    move-object/from16 v8, p8

    iput-object v8, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$onSuccess:Lkotlin/jvm/functions/Function1;

    move-object/from16 v9, p9

    iput-object v9, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$onError:Lkotlin/jvm/functions/Function1;

    move-object/from16 v10, p10

    iput-object v10, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$alignment:Landroidx/compose/ui/Alignment;

    move-object/from16 v11, p11

    iput-object v11, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$contentScale:Landroidx/compose/ui/layout/ContentScale;

    move/from16 v12, p12

    iput v12, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$alpha:F

    move-object/from16 v13, p13

    iput-object v13, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$colorFilter:Landroidx/compose/ui/graphics/ColorFilter;

    move/from16 v14, p14

    iput v14, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$filterQuality:I

    move/from16 v15, p15

    iput v15, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$$changed:I

    move/from16 v1, p16

    iput v1, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$$changed1:I

    move/from16 v1, p17

    iput v1, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$$default:I

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    move-object v0, p1

    check-cast v0, Landroidx/compose/runtime/Composer;

    move-object v1, p2

    check-cast v1, Ljava/lang/Number;

    invoke-virtual {v1}, Ljava/lang/Number;->intValue()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->invoke(Landroidx/compose/runtime/Composer;I)V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke(Landroidx/compose/runtime/Composer;I)V
    .locals 20

    move-object/from16 v0, p0

    move-object/from16 v15, p1

    iget-object v1, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$model:Ljava/lang/Object;

    iget-object v2, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$contentDescription:Ljava/lang/String;

    iget-object v3, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$modifier:Landroidx/compose/ui/Modifier;

    iget-object v4, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$loading:Lkotlin/jvm/functions/Function4;

    iget-object v5, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$success:Lkotlin/jvm/functions/Function4;

    iget-object v6, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$error:Lkotlin/jvm/functions/Function4;

    iget-object v7, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$onLoading:Lkotlin/jvm/functions/Function1;

    iget-object v8, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$onSuccess:Lkotlin/jvm/functions/Function1;

    iget-object v9, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$onError:Lkotlin/jvm/functions/Function1;

    iget-object v10, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$alignment:Landroidx/compose/ui/Alignment;

    iget-object v11, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$contentScale:Landroidx/compose/ui/layout/ContentScale;

    iget v12, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$alpha:F

    iget-object v13, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$colorFilter:Landroidx/compose/ui/graphics/ColorFilter;

    iget v14, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$filterQuality:I

    move-object/from16 v19, v1

    iget v1, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$$changed:I

    or-int/lit8 v1, v1, 0x1

    invoke-static {v1}, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I

    move-result v16

    iget v1, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$$changed1:I

    invoke-static {v1}, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I

    move-result v17

    iget v1, v0, Lcoil/compose/SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1;->$$default:I

    move/from16 v18, v1

    move-object/from16 v1, v19

    invoke-static/range {v1 .. v18}, Lcoil/compose/SingletonSubcomposeAsyncImageKt;->SubcomposeAsyncImage-ylYTKUw(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V

    return-void
.end method
