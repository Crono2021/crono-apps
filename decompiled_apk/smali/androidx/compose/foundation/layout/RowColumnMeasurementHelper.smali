.class public final Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;
.super Ljava/lang/Object;
.source "RowColumnMeasurementHelper.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nRowColumnMeasurementHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RowColumnMeasurementHelper.kt\nandroidx/compose/foundation/layout/RowColumnMeasurementHelper\n+ 2 RowColumnImpl.kt\nandroidx/compose/foundation/layout/OrientationIndependentConstraints\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,343:1\n322#2:344\n322#2:345\n322#2:346\n321#2:347\n324#2:349\n322#2:350\n321#2:351\n324#2:352\n324#2:353\n323#2:354\n1#3:348\n*S KotlinDebug\n*F\n+ 1 RowColumnMeasurementHelper.kt\nandroidx/compose/foundation/layout/RowColumnMeasurementHelper\n*L\n111#1:344\n143#1:345\n144#1:346\n146#1:347\n181#1:349\n191#1:350\n230#1:351\n232#1:352\n235#1:353\n240#1:354\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012\u00a2\u0006\u0002\u0010\u0014J2\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00132\u0008\u0010-\u001a\u0004\u0018\u00010&2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020+H\u0002J(\u00102\u001a\u0002032\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u0002032\u0006\u00102\u001a\u0002032\u0006\u00106\u001a\u000207H\u0002J0\u00108\u001a\u0002092\u0006\u00106\u001a\u0002072\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020+\u00f8\u0001\u0000\u00a2\u0006\u0004\u0008>\u0010?J&\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020+2\u0006\u0010/\u001a\u000200J\n\u0010\n\u001a\u00020+*\u00020\u0013J\n\u0010F\u001a\u00020+*\u00020\u0013R\u0019\u0010\u0008\u001a\u00020\t\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u000c\u001a\u00020\r\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u001b\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\u0008\"\u0010#R\u0018\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0012X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)\u0082\u0002\u000b\n\u0005\u0008\u00a1\u001e0\u0001\n\u0002\u0008!\u00a8\u0006G"
    }
    d2 = {
        "Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;",
        "",
        "orientation",
        "Landroidx/compose/foundation/layout/LayoutOrientation;",
        "horizontalArrangement",
        "Landroidx/compose/foundation/layout/Arrangement$Horizontal;",
        "verticalArrangement",
        "Landroidx/compose/foundation/layout/Arrangement$Vertical;",
        "arrangementSpacing",
        "Landroidx/compose/ui/unit/Dp;",
        "crossAxisSize",
        "Landroidx/compose/foundation/layout/SizeMode;",
        "crossAxisAlignment",
        "Landroidx/compose/foundation/layout/CrossAxisAlignment;",
        "measurables",
        "",
        "Landroidx/compose/ui/layout/Measurable;",
        "placeables",
        "",
        "Landroidx/compose/ui/layout/Placeable;",
        "(Landroidx/compose/foundation/layout/LayoutOrientation;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;Lkotlin/jvm/internal/DefaultConstructorMarker;)V",
        "getArrangementSpacing-D9Ej5fM",
        "()F",
        "F",
        "getCrossAxisAlignment",
        "()Landroidx/compose/foundation/layout/CrossAxisAlignment;",
        "getCrossAxisSize",
        "()Landroidx/compose/foundation/layout/SizeMode;",
        "getHorizontalArrangement",
        "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;",
        "getMeasurables",
        "()Ljava/util/List;",
        "getOrientation",
        "()Landroidx/compose/foundation/layout/LayoutOrientation;",
        "getPlaceables",
        "()[Landroidx/compose/ui/layout/Placeable;",
        "[Landroidx/compose/ui/layout/Placeable;",
        "rowColumnParentData",
        "Landroidx/compose/foundation/layout/RowColumnParentData;",
        "[Landroidx/compose/foundation/layout/RowColumnParentData;",
        "getVerticalArrangement",
        "()Landroidx/compose/foundation/layout/Arrangement$Vertical;",
        "getCrossAxisPosition",
        "",
        "placeable",
        "parentData",
        "crossAxisLayoutSize",
        "layoutDirection",
        "Landroidx/compose/ui/unit/LayoutDirection;",
        "beforeCrossAxisAlignmentLine",
        "mainAxisPositions",
        "",
        "mainAxisLayoutSize",
        "childrenMainAxisSize",
        "measureScope",
        "Landroidx/compose/ui/layout/MeasureScope;",
        "measureWithoutPlacing",
        "Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;",
        "constraints",
        "Landroidx/compose/ui/unit/Constraints;",
        "startIndex",
        "endIndex",
        "measureWithoutPlacing-_EkL_-Y",
        "(Landroidx/compose/ui/layout/MeasureScope;JII)Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;",
        "placeHelper",
        "",
        "placeableScope",
        "Landroidx/compose/ui/layout/Placeable$PlacementScope;",
        "measureResult",
        "crossAxisOffset",
        "mainAxisSize",
        "foundation-layout_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final $stable:I


# instance fields
.field private final arrangementSpacing:F

.field private final crossAxisAlignment:Landroidx/compose/foundation/layout/CrossAxisAlignment;

.field private final crossAxisSize:Landroidx/compose/foundation/layout/SizeMode;

.field private final horizontalArrangement:Landroidx/compose/foundation/layout/Arrangement$Horizontal;

.field private final measurables:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/compose/ui/layout/Measurable;",
            ">;"
        }
    .end annotation
.end field

.field private final orientation:Landroidx/compose/foundation/layout/LayoutOrientation;

.field private final placeables:[Landroidx/compose/ui/layout/Placeable;

.field private final rowColumnParentData:[Landroidx/compose/foundation/layout/RowColumnParentData;

.field private final verticalArrangement:Landroidx/compose/foundation/layout/Arrangement$Vertical;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0x8

    sput v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->$stable:I

    return-void
.end method

.method private constructor <init>(Landroidx/compose/foundation/layout/LayoutOrientation;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;)V
    .locals 4
    .param p1, "orientation"    # Landroidx/compose/foundation/layout/LayoutOrientation;
    .param p2, "horizontalArrangement"    # Landroidx/compose/foundation/layout/Arrangement$Horizontal;
    .param p3, "verticalArrangement"    # Landroidx/compose/foundation/layout/Arrangement$Vertical;
    .param p4, "arrangementSpacing"    # F
    .param p5, "crossAxisSize"    # Landroidx/compose/foundation/layout/SizeMode;
    .param p6, "crossAxisAlignment"    # Landroidx/compose/foundation/layout/CrossAxisAlignment;
    .param p7, "measurables"    # Ljava/util/List;
    .param p8, "placeables"    # [Landroidx/compose/ui/layout/Placeable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/compose/foundation/layout/LayoutOrientation;",
            "Landroidx/compose/foundation/layout/Arrangement$Horizontal;",
            "Landroidx/compose/foundation/layout/Arrangement$Vertical;",
            "F",
            "Landroidx/compose/foundation/layout/SizeMode;",
            "Landroidx/compose/foundation/layout/CrossAxisAlignment;",
            "Ljava/util/List<",
            "+",
            "Landroidx/compose/ui/layout/Measurable;",
            ">;[",
            "Landroidx/compose/ui/layout/Placeable;",
            ")V"
        }
    .end annotation

    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p1, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->orientation:Landroidx/compose/foundation/layout/LayoutOrientation;

    .line 50
    iput-object p2, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->horizontalArrangement:Landroidx/compose/foundation/layout/Arrangement$Horizontal;

    .line 51
    iput-object p3, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->verticalArrangement:Landroidx/compose/foundation/layout/Arrangement$Vertical;

    .line 52
    iput p4, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->arrangementSpacing:F

    .line 53
    iput-object p5, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->crossAxisSize:Landroidx/compose/foundation/layout/SizeMode;

    .line 54
    iput-object p6, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->crossAxisAlignment:Landroidx/compose/foundation/layout/CrossAxisAlignment;

    .line 55
    iput-object p7, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->measurables:Ljava/util/List;

    .line 56
    iput-object p8, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->placeables:[Landroidx/compose/ui/layout/Placeable;

    .line 59
    invoke-interface {p7}, Ljava/util/List;->size()I

    move-result v0

    new-array v1, v0, [Landroidx/compose/foundation/layout/RowColumnParentData;

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_0

    .line 60
    iget-object v3, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->measurables:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/compose/ui/layout/IntrinsicMeasurable;

    invoke-static {v3}, Landroidx/compose/foundation/layout/RowColumnImplKt;->getRowColumnParentData(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Landroidx/compose/foundation/layout/RowColumnParentData;

    move-result-object v3

    aput-object v3, v1, v2

    add-int/lit8 v2, v2, 0x1

    .line 59
    goto :goto_0

    :cond_0
    iput-object v1, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->rowColumnParentData:[Landroidx/compose/foundation/layout/RowColumnParentData;

    .line 48
    return-void
.end method

.method public synthetic constructor <init>(Landroidx/compose/foundation/layout/LayoutOrientation;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    invoke-direct/range {p0 .. p8}, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;-><init>(Landroidx/compose/foundation/layout/LayoutOrientation;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;)V

    return-void
.end method

.method private final getCrossAxisPosition(Landroidx/compose/ui/layout/Placeable;Landroidx/compose/foundation/layout/RowColumnParentData;ILandroidx/compose/ui/unit/LayoutDirection;I)I
    .locals 4
    .param p1, "placeable"    # Landroidx/compose/ui/layout/Placeable;
    .param p2, "parentData"    # Landroidx/compose/foundation/layout/RowColumnParentData;
    .param p3, "crossAxisLayoutSize"    # I
    .param p4, "layoutDirection"    # Landroidx/compose/ui/unit/LayoutDirection;
    .param p5, "beforeCrossAxisAlignmentLine"    # I

    .line 298
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Landroidx/compose/foundation/layout/RowColumnParentData;->getCrossAxisAlignment()Landroidx/compose/foundation/layout/CrossAxisAlignment;

    move-result-object v0

    if-nez v0, :cond_1

    :cond_0
    iget-object v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->crossAxisAlignment:Landroidx/compose/foundation/layout/CrossAxisAlignment;

    .line 299
    .local v0, "childCrossAlignment":Landroidx/compose/foundation/layout/CrossAxisAlignment;
    :cond_1
    nop

    .line 300
    invoke-virtual {p0, p1}, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->crossAxisSize(Landroidx/compose/ui/layout/Placeable;)I

    move-result v1

    sub-int v1, p3, v1

    .line 301
    iget-object v2, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->orientation:Landroidx/compose/foundation/layout/LayoutOrientation;

    sget-object v3, Landroidx/compose/foundation/layout/LayoutOrientation;->Horizontal:Landroidx/compose/foundation/layout/LayoutOrientation;

    if-ne v2, v3, :cond_2

    .line 302
    sget-object v2, Landroidx/compose/ui/unit/LayoutDirection;->Ltr:Landroidx/compose/ui/unit/LayoutDirection;

    goto :goto_0

    .line 304
    :cond_2
    move-object v2, p4

    .line 306
    :goto_0
    nop

    .line 307
    nop

    .line 299
    invoke-virtual {v0, v1, v2, p1, p5}, Landroidx/compose/foundation/layout/CrossAxisAlignment;->align$foundation_layout_release(ILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/layout/Placeable;I)I

    move-result v1

    return v1
.end method

.method private final mainAxisPositions(I[I[ILandroidx/compose/ui/layout/MeasureScope;)[I
    .locals 8
    .param p1, "mainAxisLayoutSize"    # I
    .param p2, "childrenMainAxisSize"    # [I
    .param p3, "mainAxisPositions"    # [I
    .param p4, "measureScope"    # Landroidx/compose/ui/layout/MeasureScope;

    .line 270
    iget-object v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->orientation:Landroidx/compose/foundation/layout/LayoutOrientation;

    sget-object v1, Landroidx/compose/foundation/layout/LayoutOrientation;->Vertical:Landroidx/compose/foundation/layout/LayoutOrientation;

    if-ne v0, v1, :cond_1

    .line 271
    iget-object v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->verticalArrangement:Landroidx/compose/foundation/layout/Arrangement$Vertical;

    if-eqz v0, :cond_0

    .local v0, "$this$mainAxisPositions_u24lambda_u246":Landroidx/compose/foundation/layout/Arrangement$Vertical;
    const/4 v1, 0x0

    .line 272
    .local v1, "$i$a$-with-RowColumnMeasurementHelper$mainAxisPositions$2":I
    move-object v2, p4

    check-cast v2, Landroidx/compose/ui/unit/Density;

    .line 273
    nop

    .line 274
    nop

    .line 275
    nop

    .line 272
    invoke-interface {v0, v2, p1, p2, p3}, Landroidx/compose/foundation/layout/Arrangement$Vertical;->arrange(Landroidx/compose/ui/unit/Density;I[I[I)V

    .line 277
    nop

    .line 271
    .end local v0    # "$this$mainAxisPositions_u24lambda_u246":Landroidx/compose/foundation/layout/Arrangement$Vertical;
    .end local v1    # "$i$a$-with-RowColumnMeasurementHelper$mainAxisPositions$2":I
    goto :goto_0

    .line 348
    :cond_0
    const/4 v0, 0x0

    .line 271
    .local v0, "$i$a$-requireNotNull-RowColumnMeasurementHelper$mainAxisPositions$1":I
    nop

    .end local v0    # "$i$a$-requireNotNull-RowColumnMeasurementHelper$mainAxisPositions$1":I
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "null verticalArrangement in Column"

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 279
    :cond_1
    iget-object v2, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->horizontalArrangement:Landroidx/compose/foundation/layout/Arrangement$Horizontal;

    if-eqz v2, :cond_2

    .local v2, "$this$mainAxisPositions_u24lambda_u248":Landroidx/compose/foundation/layout/Arrangement$Horizontal;
    const/4 v0, 0x0

    .line 280
    .local v0, "$i$a$-with-RowColumnMeasurementHelper$mainAxisPositions$4":I
    move-object v3, p4

    check-cast v3, Landroidx/compose/ui/unit/Density;

    .line 281
    nop

    .line 282
    nop

    .line 283
    invoke-interface {p4}, Landroidx/compose/ui/layout/MeasureScope;->getLayoutDirection()Landroidx/compose/ui/unit/LayoutDirection;

    move-result-object v6

    .line 284
    nop

    .line 280
    move v4, p1

    move-object v5, p2

    move-object v7, p3

    invoke-interface/range {v2 .. v7}, Landroidx/compose/foundation/layout/Arrangement$Horizontal;->arrange(Landroidx/compose/ui/unit/Density;I[ILandroidx/compose/ui/unit/LayoutDirection;[I)V

    .line 286
    nop

    .line 279
    .end local v0    # "$i$a$-with-RowColumnMeasurementHelper$mainAxisPositions$4":I
    .end local v2    # "$this$mainAxisPositions_u24lambda_u248":Landroidx/compose/foundation/layout/Arrangement$Horizontal;
    nop

    .line 288
    :goto_0
    return-object p3

    .line 348
    :cond_2
    const/4 v0, 0x0

    .line 279
    .local v0, "$i$a$-requireNotNull-RowColumnMeasurementHelper$mainAxisPositions$3":I
    nop

    .end local v0    # "$i$a$-requireNotNull-RowColumnMeasurementHelper$mainAxisPositions$3":I
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "null horizontalArrangement in Row"

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public final crossAxisSize(Landroidx/compose/ui/layout/Placeable;)I
    .locals 2
    .param p1, "$this$crossAxisSize"    # Landroidx/compose/ui/layout/Placeable;

    .line 67
    iget-object v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->orientation:Landroidx/compose/foundation/layout/LayoutOrientation;

    sget-object v1, Landroidx/compose/foundation/layout/LayoutOrientation;->Horizontal:Landroidx/compose/foundation/layout/LayoutOrientation;

    if-ne v0, v1, :cond_0

    invoke-virtual {p1}, Landroidx/compose/ui/layout/Placeable;->getHeight()I

    move-result v0

    goto :goto_0

    :cond_0
    invoke-virtual {p1}, Landroidx/compose/ui/layout/Placeable;->getWidth()I

    move-result v0

    :goto_0
    return v0
.end method

.method public final getArrangementSpacing-D9Ej5fM()F
    .locals 1

    .line 52
    iget v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->arrangementSpacing:F

    return v0
.end method

.method public final getCrossAxisAlignment()Landroidx/compose/foundation/layout/CrossAxisAlignment;
    .locals 1

    .line 54
    iget-object v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->crossAxisAlignment:Landroidx/compose/foundation/layout/CrossAxisAlignment;

    return-object v0
.end method

.method public final getCrossAxisSize()Landroidx/compose/foundation/layout/SizeMode;
    .locals 1

    .line 53
    iget-object v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->crossAxisSize:Landroidx/compose/foundation/layout/SizeMode;

    return-object v0
.end method

.method public final getHorizontalArrangement()Landroidx/compose/foundation/layout/Arrangement$Horizontal;
    .locals 1

    .line 50
    iget-object v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->horizontalArrangement:Landroidx/compose/foundation/layout/Arrangement$Horizontal;

    return-object v0
.end method

.method public final getMeasurables()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroidx/compose/ui/layout/Measurable;",
            ">;"
        }
    .end annotation

    .line 55
    iget-object v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->measurables:Ljava/util/List;

    return-object v0
.end method

.method public final getOrientation()Landroidx/compose/foundation/layout/LayoutOrientation;
    .locals 1

    .line 49
    iget-object v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->orientation:Landroidx/compose/foundation/layout/LayoutOrientation;

    return-object v0
.end method

.method public final getPlaceables()[Landroidx/compose/ui/layout/Placeable;
    .locals 1

    .line 56
    iget-object v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->placeables:[Landroidx/compose/ui/layout/Placeable;

    return-object v0
.end method

.method public final getVerticalArrangement()Landroidx/compose/foundation/layout/Arrangement$Vertical;
    .locals 1

    .line 51
    iget-object v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->verticalArrangement:Landroidx/compose/foundation/layout/Arrangement$Vertical;

    return-object v0
.end method

.method public final mainAxisSize(Landroidx/compose/ui/layout/Placeable;)I
    .locals 2
    .param p1, "$this$mainAxisSize"    # Landroidx/compose/ui/layout/Placeable;

    .line 64
    iget-object v0, p0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->orientation:Landroidx/compose/foundation/layout/LayoutOrientation;

    sget-object v1, Landroidx/compose/foundation/layout/LayoutOrientation;->Horizontal:Landroidx/compose/foundation/layout/LayoutOrientation;

    if-ne v0, v1, :cond_0

    invoke-virtual {p1}, Landroidx/compose/ui/layout/Placeable;->getWidth()I

    move-result v0

    goto :goto_0

    :cond_0
    invoke-virtual {p1}, Landroidx/compose/ui/layout/Placeable;->getHeight()I

    move-result v0

    :goto_0
    return v0
.end method

.method public final measureWithoutPlacing-_EkL_-Y(Landroidx/compose/ui/layout/MeasureScope;JII)Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;
    .locals 42
    .param p1, "measureScope"    # Landroidx/compose/ui/layout/MeasureScope;
    .param p2, "constraints"    # J
    .param p4, "startIndex"    # I
    .param p5, "endIndex"    # I

    .line 87
    move-object/from16 v0, p0

    move/from16 v8, p5

    iget-object v1, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->orientation:Landroidx/compose/foundation/layout/LayoutOrientation;

    move-wide/from16 v9, p2

    invoke-static {v9, v10, v1}, Landroidx/compose/foundation/layout/OrientationIndependentConstraints;->constructor-impl(JLandroidx/compose/foundation/layout/LayoutOrientation;)J

    move-result-wide v19

    .line 88
    .local v19, "constraints":J
    move-object/from16 v1, p1

    .local v1, "$this$measureWithoutPlacing__EkL__Y_u24lambda_u240":Landroidx/compose/ui/layout/MeasureScope;
    const/4 v2, 0x0

    .line 89
    .local v2, "$i$a$-with-RowColumnMeasurementHelper$measureWithoutPlacing$arrangementSpacingPx$1":I
    iget v3, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->arrangementSpacing:F

    invoke-interface {v1, v3}, Landroidx/compose/ui/layout/MeasureScope;->roundToPx-0680j_4(F)I

    move-result v3

    int-to-long v1, v3

    .line 88
    .end local v1    # "$this$measureWithoutPlacing__EkL__Y_u24lambda_u240":Landroidx/compose/ui/layout/MeasureScope;
    .end local v2    # "$i$a$-with-RowColumnMeasurementHelper$measureWithoutPlacing$arrangementSpacingPx$1":I
    move-wide v6, v1

    .line 92
    .local v6, "arrangementSpacingPx":J
    const/4 v1, 0x0

    .line 93
    .local v1, "totalWeight":F
    const-wide/16 v2, 0x0

    .line 94
    .local v2, "fixedSpace":J
    const/4 v4, 0x0

    .line 95
    .local v4, "crossAxisSpace":I
    const/4 v5, 0x0

    .line 97
    .local v5, "weightChildrenCount":I
    const/4 v11, 0x0

    .line 98
    .local v11, "anyAlignBy":Z
    sub-int v15, v8, p4

    .line 101
    .local v15, "subSize":I
    const/4 v12, 0x0

    .line 102
    .local v12, "spaceAfterLastNoWeight":I
    move/from16 v13, p4

    move/from16 v21, v1

    move/from16 v22, v5

    move v1, v11

    move v5, v12

    move v14, v13

    .end local v11    # "anyAlignBy":Z
    .end local v12    # "spaceAfterLastNoWeight":I
    .local v1, "anyAlignBy":Z
    .local v5, "spaceAfterLastNoWeight":I
    .local v14, "i":I
    .local v21, "totalWeight":F
    .local v22, "weightChildrenCount":I
    :goto_0
    const v13, 0x7fffffff

    const/16 v16, 0x0

    const/16 v23, 0x1

    move/from16 v17, v15

    .end local v15    # "subSize":I
    .local v17, "subSize":I
    if-ge v14, v8, :cond_5

    .line 103
    iget-object v15, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->measurables:Ljava/util/List;

    invoke-interface {v15, v14}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroidx/compose/ui/layout/Measurable;

    .line 104
    .local v15, "child":Landroidx/compose/ui/layout/Measurable;
    iget-object v11, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->rowColumnParentData:[Landroidx/compose/foundation/layout/RowColumnParentData;

    aget-object v26, v11, v14

    .line 105
    .local v26, "parentData":Landroidx/compose/foundation/layout/RowColumnParentData;
    invoke-static/range {v26 .. v26}, Landroidx/compose/foundation/layout/RowColumnImplKt;->getWeight(Landroidx/compose/foundation/layout/RowColumnParentData;)F

    move-result v27

    .line 107
    .local v27, "weight":F
    cmpl-float v11, v27, v16

    if-lez v11, :cond_0

    .line 108
    add-float v21, v21, v27

    add-int/lit8 v22, v22, 0x1

    .line 109
    move/from16 v32, v14

    move/from16 v33, v17

    goto/16 :goto_4

    .line 111
    :cond_0
    const/4 v11, 0x0

    .line 344
    .local v11, "$i$f$getMainAxisMax-impl":I
    invoke-static/range {v19 .. v20}, Landroidx/compose/ui/unit/Constraints;->getMaxWidth-impl(J)I

    move-result v11

    .line 111
    .end local v11    # "$i$f$getMainAxisMax-impl":I
    nop

    .line 112
    .local v11, "mainAxisMax":I
    iget-object v12, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->placeables:[Landroidx/compose/ui/layout/Placeable;

    aget-object v12, v12, v14

    if-nez v12, :cond_2

    .line 114
    nop

    .line 115
    const/16 v16, 0x0

    .line 116
    if-ne v11, v13, :cond_1

    .line 117
    move/from16 v24, v13

    const-wide/16 v9, 0x0

    goto :goto_1

    .line 119
    :cond_1
    int-to-long v12, v11

    sub-long/2addr v12, v2

    const-wide/16 v9, 0x0

    invoke-static {v12, v13, v9, v10}, Lkotlin/ranges/RangesKt;->coerceAtLeast(JJ)J

    move-result-wide v12

    long-to-int v12, v12

    move/from16 v24, v12

    .line 121
    :goto_1
    const/16 v25, 0x0

    .line 114
    const/16 v28, 0x0

    const/16 v29, 0x8

    const/16 v30, 0x0

    move/from16 v31, v5

    move-wide/from16 v40, v9

    move v10, v4

    move-wide/from16 v4, v40

    move v9, v11

    .end local v4    # "crossAxisSpace":I
    .end local v5    # "spaceAfterLastNoWeight":I
    .end local v11    # "mainAxisMax":I
    .local v9, "mainAxisMax":I
    .local v10, "crossAxisSpace":I
    .local v31, "spaceAfterLastNoWeight":I
    move-wide/from16 v11, v19

    move/from16 v13, v16

    move/from16 v32, v14

    .end local v14    # "i":I
    .local v32, "i":I
    move/from16 v14, v24

    move-object v4, v15

    move/from16 v33, v17

    .end local v15    # "child":Landroidx/compose/ui/layout/Measurable;
    .end local v17    # "subSize":I
    .local v4, "child":Landroidx/compose/ui/layout/Measurable;
    .local v33, "subSize":I
    move/from16 v15, v25

    move/from16 v16, v28

    move/from16 v17, v29

    move-object/from16 v18, v30

    invoke-static/range {v11 .. v18}, Landroidx/compose/foundation/layout/OrientationIndependentConstraints;->copy-yUG9Ft0$default(JIIIIILjava/lang/Object;)J

    move-result-wide v11

    .line 122
    iget-object v5, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->orientation:Landroidx/compose/foundation/layout/LayoutOrientation;

    invoke-static {v11, v12, v5}, Landroidx/compose/foundation/layout/OrientationIndependentConstraints;->toBoxConstraints-OenEA2s(JLandroidx/compose/foundation/layout/LayoutOrientation;)J

    move-result-wide v11

    .line 112
    invoke-interface {v4, v11, v12}, Landroidx/compose/ui/layout/Measurable;->measure-BRTryo0(J)Landroidx/compose/ui/layout/Placeable;

    move-result-object v12

    goto :goto_2

    .end local v9    # "mainAxisMax":I
    .end local v10    # "crossAxisSpace":I
    .end local v31    # "spaceAfterLastNoWeight":I
    .end local v32    # "i":I
    .end local v33    # "subSize":I
    .local v4, "crossAxisSpace":I
    .restart local v5    # "spaceAfterLastNoWeight":I
    .restart local v11    # "mainAxisMax":I
    .restart local v14    # "i":I
    .restart local v15    # "child":Landroidx/compose/ui/layout/Measurable;
    .restart local v17    # "subSize":I
    :cond_2
    move v10, v4

    move/from16 v31, v5

    move v9, v11

    move/from16 v32, v14

    move-object v4, v15

    move/from16 v33, v17

    .end local v5    # "spaceAfterLastNoWeight":I
    .end local v11    # "mainAxisMax":I
    .end local v14    # "i":I
    .end local v15    # "child":Landroidx/compose/ui/layout/Measurable;
    .end local v17    # "subSize":I
    .local v4, "child":Landroidx/compose/ui/layout/Measurable;
    .restart local v9    # "mainAxisMax":I
    .restart local v10    # "crossAxisSpace":I
    .restart local v31    # "spaceAfterLastNoWeight":I
    .restart local v32    # "i":I
    .restart local v33    # "subSize":I
    :goto_2
    move-object v5, v12

    .line 124
    .local v5, "placeable":Landroidx/compose/ui/layout/Placeable;
    nop

    .line 125
    long-to-int v11, v6

    .line 126
    int-to-long v12, v9

    sub-long/2addr v12, v2

    invoke-virtual {v0, v5}, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->mainAxisSize(Landroidx/compose/ui/layout/Placeable;)I

    move-result v14

    int-to-long v14, v14

    sub-long/2addr v12, v14

    .line 127
    const-wide/16 v14, 0x0

    invoke-static {v12, v13, v14, v15}, Lkotlin/ranges/RangesKt;->coerceAtLeast(JJ)J

    move-result-wide v12

    long-to-int v12, v12

    invoke-static {v11, v12}, Ljava/lang/Math;->min(II)I

    move-result v11

    .line 124
    nop

    .line 129
    .end local v31    # "spaceAfterLastNoWeight":I
    .local v11, "spaceAfterLastNoWeight":I
    invoke-virtual {v0, v5}, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->mainAxisSize(Landroidx/compose/ui/layout/Placeable;)I

    move-result v12

    add-int/2addr v12, v11

    int-to-long v12, v12

    add-long/2addr v2, v12

    .line 130
    invoke-virtual {v0, v5}, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->crossAxisSize(Landroidx/compose/ui/layout/Placeable;)I

    move-result v12

    invoke-static {v10, v12}, Ljava/lang/Math;->max(II)I

    move-result v10

    .line 131
    if-nez v1, :cond_4

    invoke-static/range {v26 .. v26}, Landroidx/compose/foundation/layout/RowColumnImplKt;->isRelative(Landroidx/compose/foundation/layout/RowColumnParentData;)Z

    move-result v12

    if-eqz v12, :cond_3

    goto :goto_3

    :cond_3
    const/16 v23, 0x0

    :cond_4
    :goto_3
    move/from16 v1, v23

    .line 132
    iget-object v12, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->placeables:[Landroidx/compose/ui/layout/Placeable;

    aput-object v5, v12, v32

    move v4, v10

    move v5, v11

    .line 102
    .end local v9    # "mainAxisMax":I
    .end local v10    # "crossAxisSpace":I
    .end local v11    # "spaceAfterLastNoWeight":I
    .end local v26    # "parentData":Landroidx/compose/foundation/layout/RowColumnParentData;
    .end local v27    # "weight":F
    .local v4, "crossAxisSpace":I
    .local v5, "spaceAfterLastNoWeight":I
    :goto_4
    add-int/lit8 v14, v32, 0x1

    move-wide/from16 v9, p2

    move/from16 v15, v33

    .end local v32    # "i":I
    .restart local v14    # "i":I
    goto/16 :goto_0

    .end local v33    # "subSize":I
    .restart local v17    # "subSize":I
    :cond_5
    move v10, v4

    move/from16 v31, v5

    move/from16 v32, v14

    move/from16 v33, v17

    .line 136
    .end local v4    # "crossAxisSpace":I
    .end local v5    # "spaceAfterLastNoWeight":I
    .end local v14    # "i":I
    .end local v17    # "subSize":I
    .restart local v10    # "crossAxisSpace":I
    .restart local v31    # "spaceAfterLastNoWeight":I
    .restart local v33    # "subSize":I
    const/4 v4, 0x0

    .line 137
    .local v4, "weightedSpace":I
    if-nez v22, :cond_6

    .line 139
    move/from16 v12, v31

    .end local v31    # "spaceAfterLastNoWeight":I
    .restart local v12    # "spaceAfterLastNoWeight":I
    int-to-long v14, v12

    sub-long/2addr v2, v14

    move v8, v1

    move v11, v4

    move-wide/from16 v17, v6

    move v13, v10

    move-wide v9, v2

    goto/16 :goto_e

    .line 143
    .end local v12    # "spaceAfterLastNoWeight":I
    .restart local v31    # "spaceAfterLastNoWeight":I
    :cond_6
    move/from16 v12, v31

    .end local v31    # "spaceAfterLastNoWeight":I
    .restart local v12    # "spaceAfterLastNoWeight":I
    cmpl-float v5, v21, v16

    if-lez v5, :cond_7

    const/4 v5, 0x0

    .line 345
    .local v5, "$i$f$getMainAxisMax-impl":I
    invoke-static/range {v19 .. v20}, Landroidx/compose/ui/unit/Constraints;->getMaxWidth-impl(J)I

    move-result v5

    .line 143
    .end local v5    # "$i$f$getMainAxisMax-impl":I
    if-eq v5, v13, :cond_7

    .line 144
    const/4 v5, 0x0

    .line 346
    .restart local v5    # "$i$f$getMainAxisMax-impl":I
    invoke-static/range {v19 .. v20}, Landroidx/compose/ui/unit/Constraints;->getMaxWidth-impl(J)I

    move-result v5

    .end local v5    # "$i$f$getMainAxisMax-impl":I
    goto :goto_5

    .line 146
    :cond_7
    const/4 v5, 0x0

    .line 347
    .local v5, "$i$f$getMainAxisMin-impl":I
    invoke-static/range {v19 .. v20}, Landroidx/compose/ui/unit/Constraints;->getMinWidth-impl(J)I

    move-result v9

    move v5, v9

    .line 143
    .end local v5    # "$i$f$getMainAxisMin-impl":I
    :goto_5
    nop

    .line 142
    nop

    .line 148
    .local v5, "targetSpace":I
    add-int/lit8 v9, v22, -0x1

    int-to-long v14, v9

    mul-long/2addr v14, v6

    .line 150
    .local v14, "arrangementSpacingTotal":J
    move-wide/from16 v17, v6

    .end local v6    # "arrangementSpacingPx":J
    .local v17, "arrangementSpacingPx":J
    int-to-long v6, v5

    sub-long/2addr v6, v2

    sub-long/2addr v6, v14

    move-wide/from16 v24, v14

    const-wide/16 v13, 0x0

    .end local v14    # "arrangementSpacingTotal":J
    .local v24, "arrangementSpacingTotal":J
    invoke-static {v6, v7, v13, v14}, Lkotlin/ranges/RangesKt;->coerceAtLeast(JJ)J

    move-result-wide v6

    .line 149
    nop

    .line 152
    .local v6, "remainingToTarget":J
    cmpl-float v11, v21, v16

    if-lez v11, :cond_8

    long-to-float v11, v6

    div-float v11, v11, v21

    goto :goto_6

    :cond_8
    move/from16 v11, v16

    .line 153
    .local v11, "weightUnitSpace":F
    :goto_6
    invoke-static/range {p4 .. p5}, Lkotlin/ranges/RangesKt;->until(II)Lkotlin/ranges/IntRange;

    move-result-object v13

    check-cast v13, Ljava/lang/Iterable;

    invoke-interface {v13}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v13

    const/4 v15, 0x0

    :goto_7
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_9

    move-object v14, v13

    check-cast v14, Lkotlin/collections/IntIterator;

    invoke-virtual {v14}, Lkotlin/collections/IntIterator;->nextInt()I

    move-result v14

    .local v14, "it":I
    const/16 v26, 0x0

    .line 154
    .local v26, "$i$a$-sumOfInt-RowColumnMeasurementHelper$measureWithoutPlacing$remainder$1":I
    iget-object v9, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->rowColumnParentData:[Landroidx/compose/foundation/layout/RowColumnParentData;

    aget-object v9, v9, v14

    invoke-static {v9}, Landroidx/compose/foundation/layout/RowColumnImplKt;->getWeight(Landroidx/compose/foundation/layout/RowColumnParentData;)F

    move-result v9

    mul-float/2addr v9, v11

    invoke-static {v9}, Lkotlin/math/MathKt;->roundToInt(F)I

    move-result v9

    .line 153
    .end local v14    # "it":I
    .end local v26    # "$i$a$-sumOfInt-RowColumnMeasurementHelper$measureWithoutPlacing$remainder$1":I
    add-int/2addr v15, v9

    goto :goto_7

    :cond_9
    int-to-long v13, v15

    sub-long v13, v6, v13

    .line 157
    .local v13, "remainder":J
    move/from16 v9, p4

    move-wide v14, v13

    move v13, v9

    .local v13, "i":I
    .local v14, "remainder":J
    :goto_8
    if-ge v13, v8, :cond_10

    .line 158
    iget-object v9, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->placeables:[Landroidx/compose/ui/layout/Placeable;

    aget-object v9, v9, v13

    if-nez v9, :cond_f

    .line 159
    iget-object v9, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->measurables:Ljava/util/List;

    invoke-interface {v9, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroidx/compose/ui/layout/Measurable;

    .line 160
    .local v9, "child":Landroidx/compose/ui/layout/Measurable;
    move/from16 v26, v5

    .end local v5    # "targetSpace":I
    .local v26, "targetSpace":I
    iget-object v5, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->rowColumnParentData:[Landroidx/compose/foundation/layout/RowColumnParentData;

    aget-object v5, v5, v13

    .line 161
    .local v5, "parentData":Landroidx/compose/foundation/layout/RowColumnParentData;
    invoke-static {v5}, Landroidx/compose/foundation/layout/RowColumnImplKt;->getWeight(Landroidx/compose/foundation/layout/RowColumnParentData;)F

    move-result v28

    .line 162
    .local v28, "weight":F
    cmpl-float v29, v28, v16

    if-lez v29, :cond_a

    move/from16 v29, v23

    goto :goto_9

    :cond_a
    const/16 v29, 0x0

    :goto_9
    if-eqz v29, :cond_e

    .line 166
    move-wide/from16 v29, v6

    .end local v6    # "remainingToTarget":J
    .local v29, "remainingToTarget":J
    invoke-static {v14, v15}, Lkotlin/math/MathKt;->getSign(J)I

    move-result v6

    .line 167
    .local v6, "remainderUnit":I
    int-to-long v7, v6

    sub-long/2addr v14, v7

    .line 168
    nop

    .line 169
    nop

    .line 170
    mul-float v7, v11, v28

    invoke-static {v7}, Lkotlin/math/MathKt;->roundToInt(F)I

    move-result v7

    add-int/2addr v7, v6

    const/4 v8, 0x0

    invoke-static {v8, v7}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 168
    nop

    .line 172
    .local v7, "childMainAxisSize":I
    nop

    .line 174
    invoke-static {v5}, Landroidx/compose/foundation/layout/RowColumnImplKt;->getFill(Landroidx/compose/foundation/layout/RowColumnParentData;)Z

    move-result v31

    if-eqz v31, :cond_b

    const v8, 0x7fffffff

    if-eq v7, v8, :cond_b

    .line 175
    move-object v8, v9

    .end local v9    # "child":Landroidx/compose/ui/layout/Measurable;
    .local v8, "child":Landroidx/compose/ui/layout/Measurable;
    move v9, v7

    goto :goto_a

    .line 174
    .end local v8    # "child":Landroidx/compose/ui/layout/Measurable;
    .restart local v9    # "child":Landroidx/compose/ui/layout/Measurable;
    :cond_b
    move-object v8, v9

    .line 177
    .end local v9    # "child":Landroidx/compose/ui/layout/Measurable;
    .restart local v8    # "child":Landroidx/compose/ui/layout/Measurable;
    const/4 v9, 0x0

    .line 179
    :goto_a
    nop

    .line 180
    nop

    .line 181
    const/16 v31, 0x0

    .line 349
    .local v31, "$i$f$getCrossAxisMax-impl":I
    move/from16 v32, v6

    .end local v6    # "remainderUnit":I
    .local v32, "remainderUnit":I
    invoke-static/range {v19 .. v20}, Landroidx/compose/ui/unit/Constraints;->getMaxHeight-impl(J)I

    move-result v6

    .line 173
    .end local v31    # "$i$f$getCrossAxisMax-impl":I
    move/from16 v31, v11

    move-wide/from16 v34, v14

    const/4 v11, 0x0

    .end local v11    # "weightUnitSpace":F
    .end local v14    # "remainder":J
    .local v31, "weightUnitSpace":F
    .local v34, "remainder":J
    invoke-static {v9, v7, v11, v6}, Landroidx/compose/foundation/layout/OrientationIndependentConstraints;->constructor-impl(IIII)J

    move-result-wide v14

    .line 182
    iget-object v6, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->orientation:Landroidx/compose/foundation/layout/LayoutOrientation;

    invoke-static {v14, v15, v6}, Landroidx/compose/foundation/layout/OrientationIndependentConstraints;->toBoxConstraints-OenEA2s(JLandroidx/compose/foundation/layout/LayoutOrientation;)J

    move-result-wide v14

    .line 172
    invoke-interface {v8, v14, v15}, Landroidx/compose/ui/layout/Measurable;->measure-BRTryo0(J)Landroidx/compose/ui/layout/Placeable;

    move-result-object v6

    .line 184
    .local v6, "placeable":Landroidx/compose/ui/layout/Placeable;
    invoke-virtual {v0, v6}, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->mainAxisSize(Landroidx/compose/ui/layout/Placeable;)I

    move-result v9

    add-int/2addr v4, v9

    .line 185
    invoke-virtual {v0, v6}, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->crossAxisSize(Landroidx/compose/ui/layout/Placeable;)I

    move-result v9

    invoke-static {v10, v9}, Ljava/lang/Math;->max(II)I

    move-result v10

    .line 186
    if-nez v1, :cond_d

    invoke-static {v5}, Landroidx/compose/foundation/layout/RowColumnImplKt;->isRelative(Landroidx/compose/foundation/layout/RowColumnParentData;)Z

    move-result v9

    if-eqz v9, :cond_c

    goto :goto_b

    :cond_c
    const/4 v15, 0x0

    goto :goto_c

    :cond_d
    :goto_b
    move/from16 v15, v23

    :goto_c
    move v1, v15

    .line 187
    iget-object v9, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->placeables:[Landroidx/compose/ui/layout/Placeable;

    aput-object v6, v9, v13

    move-wide/from16 v14, v34

    goto :goto_d

    .line 348
    .end local v7    # "childMainAxisSize":I
    .end local v8    # "child":Landroidx/compose/ui/layout/Measurable;
    .end local v29    # "remainingToTarget":J
    .end local v31    # "weightUnitSpace":F
    .end local v32    # "remainderUnit":I
    .end local v34    # "remainder":J
    .local v6, "remainingToTarget":J
    .restart local v9    # "child":Landroidx/compose/ui/layout/Measurable;
    .restart local v11    # "weightUnitSpace":F
    .restart local v14    # "remainder":J
    :cond_e
    move-wide/from16 v29, v6

    .end local v6    # "remainingToTarget":J
    .restart local v29    # "remainingToTarget":J
    const/4 v6, 0x0

    .line 162
    .local v6, "$i$a$-check-RowColumnMeasurementHelper$measureWithoutPlacing$1":I
    nop

    .end local v6    # "$i$a$-check-RowColumnMeasurementHelper$measureWithoutPlacing$1":I
    new-instance v6, Ljava/lang/IllegalStateException;

    const-string v7, "All weights <= 0 should have placeables"

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 158
    .end local v9    # "child":Landroidx/compose/ui/layout/Measurable;
    .end local v26    # "targetSpace":I
    .end local v28    # "weight":F
    .end local v29    # "remainingToTarget":J
    .local v5, "targetSpace":I
    .local v6, "remainingToTarget":J
    :cond_f
    move/from16 v26, v5

    move-wide/from16 v29, v6

    move/from16 v31, v11

    .line 157
    .end local v5    # "targetSpace":I
    .end local v6    # "remainingToTarget":J
    .end local v11    # "weightUnitSpace":F
    .restart local v26    # "targetSpace":I
    .restart local v29    # "remainingToTarget":J
    .restart local v31    # "weightUnitSpace":F
    :goto_d
    add-int/lit8 v13, v13, 0x1

    move/from16 v8, p5

    move/from16 v5, v26

    move-wide/from16 v6, v29

    move/from16 v11, v31

    goto/16 :goto_8

    .end local v26    # "targetSpace":I
    .end local v29    # "remainingToTarget":J
    .end local v31    # "weightUnitSpace":F
    .restart local v5    # "targetSpace":I
    .restart local v6    # "remainingToTarget":J
    .restart local v11    # "weightUnitSpace":F
    :cond_10
    move/from16 v26, v5

    move-wide/from16 v29, v6

    move/from16 v31, v11

    .line 192
    .end local v5    # "targetSpace":I
    .end local v6    # "remainingToTarget":J
    .end local v11    # "weightUnitSpace":F
    .end local v13    # "i":I
    .restart local v26    # "targetSpace":I
    .restart local v29    # "remainingToTarget":J
    .restart local v31    # "weightUnitSpace":F
    nop

    .line 190
    int-to-long v5, v4

    add-long v34, v5, v24

    .line 191
    const-wide/16 v36, 0x0

    const/4 v5, 0x0

    .line 350
    .local v5, "$i$f$getMainAxisMax-impl":I
    invoke-static/range {v19 .. v20}, Landroidx/compose/ui/unit/Constraints;->getMaxWidth-impl(J)I

    move-result v5

    .end local v5    # "$i$f$getMainAxisMax-impl":I
    int-to-long v5, v5

    .line 191
    sub-long v38, v5, v2

    invoke-static/range {v34 .. v39}, Lkotlin/ranges/RangesKt;->coerceIn(JJJ)J

    move-result-wide v5

    .line 192
    long-to-int v5, v5

    .line 190
    move v4, v5

    move v8, v1

    move v11, v4

    move v13, v10

    move-wide v9, v2

    .line 195
    .end local v1    # "anyAlignBy":Z
    .end local v2    # "fixedSpace":J
    .end local v4    # "weightedSpace":I
    .end local v10    # "crossAxisSpace":I
    .end local v14    # "remainder":J
    .end local v24    # "arrangementSpacingTotal":J
    .end local v26    # "targetSpace":I
    .end local v29    # "remainingToTarget":J
    .end local v31    # "weightUnitSpace":F
    .local v8, "anyAlignBy":Z
    .local v9, "fixedSpace":J
    .local v11, "weightedSpace":I
    .local v13, "crossAxisSpace":I
    :goto_e
    const/4 v1, 0x0

    .line 196
    .local v1, "beforeCrossAxisAlignmentLine":I
    const/4 v2, 0x0

    .line 197
    .local v2, "afterCrossAxisAlignmentLine":I
    if-eqz v8, :cond_16

    .line 198
    move/from16 v3, p4

    .local v3, "i":I
    :goto_f
    move/from16 v14, p5

    if-ge v3, v14, :cond_15

    .line 199
    iget-object v4, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->placeables:[Landroidx/compose/ui/layout/Placeable;

    aget-object v4, v4, v3

    invoke-static {v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 200
    .local v4, "placeable":Landroidx/compose/ui/layout/Placeable;
    iget-object v5, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->rowColumnParentData:[Landroidx/compose/foundation/layout/RowColumnParentData;

    aget-object v5, v5, v3

    .line 202
    .local v5, "parentData":Landroidx/compose/foundation/layout/RowColumnParentData;
    nop

    .line 201
    invoke-static {v5}, Landroidx/compose/foundation/layout/RowColumnImplKt;->getCrossAxisAlignment(Landroidx/compose/foundation/layout/RowColumnParentData;)Landroidx/compose/foundation/layout/CrossAxisAlignment;

    move-result-object v6

    .line 202
    if-eqz v6, :cond_11

    .line 201
    nop

    .line 202
    invoke-virtual {v6, v4}, Landroidx/compose/foundation/layout/CrossAxisAlignment;->calculateAlignmentLinePosition$foundation_layout_release(Landroidx/compose/ui/layout/Placeable;)Ljava/lang/Integer;

    move-result-object v6

    goto :goto_10

    :cond_11
    const/4 v6, 0x0

    .line 201
    :goto_10
    nop

    .line 203
    .local v6, "alignmentLinePosition":Ljava/lang/Integer;
    if-eqz v6, :cond_14

    .line 204
    nop

    .line 206
    move-object v7, v6

    check-cast v7, Ljava/lang/Number;

    invoke-virtual {v7}, Ljava/lang/Number;->intValue()I

    move-result v15

    .local v15, "it":I
    const/4 v7, 0x0

    .line 207
    .local v7, "$i$a$-let-RowColumnMeasurementHelper$measureWithoutPlacing$2":I
    move-object/from16 v16, v5

    .end local v5    # "parentData":Landroidx/compose/foundation/layout/RowColumnParentData;
    .local v16, "parentData":Landroidx/compose/foundation/layout/RowColumnParentData;
    const/high16 v5, -0x80000000

    if-eq v15, v5, :cond_12

    goto :goto_11

    :cond_12
    const/4 v15, 0x0

    .line 206
    .end local v7    # "$i$a$-let-RowColumnMeasurementHelper$measureWithoutPlacing$2":I
    .end local v15    # "it":I
    :goto_11
    nop

    .line 204
    invoke-static {v1, v15}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 210
    nop

    .line 212
    invoke-virtual {v0, v4}, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->crossAxisSize(Landroidx/compose/ui/layout/Placeable;)I

    move-result v7

    .line 214
    move-object v15, v6

    check-cast v15, Ljava/lang/Number;

    invoke-virtual {v15}, Ljava/lang/Number;->intValue()I

    move-result v15

    .restart local v15    # "it":I
    const/16 v23, 0x0

    .line 215
    .local v23, "$i$a$-let-RowColumnMeasurementHelper$measureWithoutPlacing$3":I
    if-eq v15, v5, :cond_13

    .line 216
    move v5, v15

    goto :goto_12

    .line 218
    :cond_13
    invoke-virtual {v0, v4}, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->crossAxisSize(Landroidx/compose/ui/layout/Placeable;)I

    move-result v5

    .line 215
    :goto_12
    nop

    .line 214
    .end local v15    # "it":I
    .end local v23    # "$i$a$-let-RowColumnMeasurementHelper$measureWithoutPlacing$3":I
    nop

    .line 212
    sub-int/2addr v7, v5

    .line 210
    invoke-static {v2, v7}, Ljava/lang/Math;->max(II)I

    move-result v2

    goto :goto_13

    .line 203
    .end local v16    # "parentData":Landroidx/compose/foundation/layout/RowColumnParentData;
    .restart local v5    # "parentData":Landroidx/compose/foundation/layout/RowColumnParentData;
    :cond_14
    move-object/from16 v16, v5

    .line 198
    .end local v4    # "placeable":Landroidx/compose/ui/layout/Placeable;
    .end local v5    # "parentData":Landroidx/compose/foundation/layout/RowColumnParentData;
    .end local v6    # "alignmentLinePosition":Ljava/lang/Integer;
    :goto_13
    add-int/lit8 v3, v3, 0x1

    goto :goto_f

    :cond_15
    move v15, v1

    move/from16 v16, v2

    goto :goto_14

    .line 197
    .end local v3    # "i":I
    :cond_16
    move/from16 v14, p5

    move v15, v1

    move/from16 v16, v2

    .line 229
    .end local v1    # "beforeCrossAxisAlignmentLine":I
    .end local v2    # "afterCrossAxisAlignmentLine":I
    .local v15, "beforeCrossAxisAlignmentLine":I
    .local v16, "afterCrossAxisAlignmentLine":I
    :goto_14
    int-to-long v1, v11

    add-long/2addr v1, v9

    const-wide/16 v3, 0x0

    invoke-static {v1, v2, v3, v4}, Lkotlin/ranges/RangesKt;->coerceAtLeast(JJ)J

    move-result-wide v1

    long-to-int v1, v1

    .line 230
    const/4 v2, 0x0

    .line 351
    .local v2, "$i$f$getMainAxisMin-impl":I
    invoke-static/range {v19 .. v20}, Landroidx/compose/ui/unit/Constraints;->getMinWidth-impl(J)I

    move-result v2

    .line 228
    .end local v2    # "$i$f$getMainAxisMin-impl":I
    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 232
    .local v7, "mainAxisLayoutSize":I
    const/4 v1, 0x0

    .line 352
    .local v1, "$i$f$getCrossAxisMax-impl":I
    invoke-static/range {v19 .. v20}, Landroidx/compose/ui/unit/Constraints;->getMaxHeight-impl(J)I

    move-result v1

    .line 232
    .end local v1    # "$i$f$getCrossAxisMax-impl":I
    const v2, 0x7fffffff

    if-eq v1, v2, :cond_17

    .line 233
    iget-object v1, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->crossAxisSize:Landroidx/compose/foundation/layout/SizeMode;

    sget-object v2, Landroidx/compose/foundation/layout/SizeMode;->Expand:Landroidx/compose/foundation/layout/SizeMode;

    if-ne v1, v2, :cond_17

    .line 235
    const/4 v1, 0x0

    .line 353
    .restart local v1    # "$i$f$getCrossAxisMax-impl":I
    invoke-static/range {v19 .. v20}, Landroidx/compose/ui/unit/Constraints;->getMaxHeight-impl(J)I

    move-result v1

    move v2, v1

    .end local v1    # "$i$f$getCrossAxisMax-impl":I
    goto :goto_15

    .line 240
    :cond_17
    const/4 v1, 0x0

    .line 354
    .local v1, "$i$f$getCrossAxisMin-impl":I
    invoke-static/range {v19 .. v20}, Landroidx/compose/ui/unit/Constraints;->getMinHeight-impl(J)I

    move-result v1

    .line 241
    .end local v1    # "$i$f$getCrossAxisMin-impl":I
    add-int v2, v15, v16

    .line 239
    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 237
    invoke-static {v13, v1}, Ljava/lang/Math;->max(II)I

    move-result v1

    move v2, v1

    .line 232
    :goto_15
    nop

    .line 245
    .local v2, "crossAxisLayoutSize":I
    move/from16 v6, v33

    .end local v33    # "subSize":I
    .local v6, "subSize":I
    new-array v1, v6, [I

    const/4 v3, 0x0

    :goto_16
    if-ge v3, v6, :cond_18

    const/4 v4, 0x0

    aput v4, v1, v3

    add-int/lit8 v3, v3, 0x1

    goto :goto_16

    :cond_18
    const/4 v4, 0x0

    move-object v5, v1

    .line 246
    .local v5, "mainAxisPositions":[I
    new-array v1, v6, [I

    :goto_17
    if-ge v4, v6, :cond_19

    .line 247
    iget-object v3, v0, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->placeables:[Landroidx/compose/ui/layout/Placeable;

    add-int v23, v4, p4

    aget-object v3, v3, v23

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v0, v3}, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->mainAxisSize(Landroidx/compose/ui/layout/Placeable;)I

    move-result v3

    aput v3, v1, v4

    add-int/lit8 v4, v4, 0x1

    .line 246
    goto :goto_17

    :cond_19
    move-object v4, v1

    .line 255
    .local v4, "childrenMainAxisSize":[I
    nop

    .line 256
    nop

    .line 257
    nop

    .line 258
    nop

    .line 259
    nop

    .line 260
    nop

    .line 256
    move-object/from16 v3, p1

    invoke-direct {v0, v7, v4, v5, v3}, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->mainAxisPositions(I[I[ILandroidx/compose/ui/layout/MeasureScope;)[I

    move-result-object v23

    .line 250
    new-instance v24, Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;

    .line 252
    nop

    .line 251
    nop

    .line 253
    nop

    .line 254
    nop

    .line 255
    nop

    .line 256
    nop

    .line 250
    move-object/from16 v1, v24

    move v3, v7

    move-object/from16 v25, v4

    .end local v4    # "childrenMainAxisSize":[I
    .local v25, "childrenMainAxisSize":[I
    move/from16 v4, p4

    move-object/from16 v26, v5

    .end local v5    # "mainAxisPositions":[I
    .local v26, "mainAxisPositions":[I
    move/from16 v5, p5

    move/from16 v27, v6

    .end local v6    # "subSize":I
    .local v27, "subSize":I
    move v6, v15

    move/from16 v28, v7

    .end local v7    # "mainAxisLayoutSize":I
    .local v28, "mainAxisLayoutSize":I
    move-object/from16 v7, v23

    invoke-direct/range {v1 .. v7}, Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;-><init>(IIIII[I)V

    return-object v24
.end method

.method public final placeHelper(Landroidx/compose/ui/layout/Placeable$PlacementScope;Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;ILandroidx/compose/ui/unit/LayoutDirection;)V
    .locals 24
    .param p1, "placeableScope"    # Landroidx/compose/ui/layout/Placeable$PlacementScope;
    .param p2, "measureResult"    # Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;
    .param p3, "crossAxisOffset"    # I
    .param p4, "layoutDirection"    # Landroidx/compose/ui/unit/LayoutDirection;

    .line 316
    move-object/from16 v6, p0

    move-object/from16 v14, p1

    .local v14, "$this$placeHelper_u24lambda_u249":Landroidx/compose/ui/layout/Placeable$PlacementScope;
    const/16 v21, 0x0

    .line 317
    .local v21, "$i$a$-with-RowColumnMeasurementHelper$placeHelper$1":I
    invoke-virtual/range {p2 .. p2}, Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;->getStartIndex()I

    move-result v0

    .local v0, "i":I
    invoke-virtual/range {p2 .. p2}, Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;->getEndIndex()I

    move-result v13

    move v12, v0

    .end local v0    # "i":I
    .local v12, "i":I
    :goto_0
    if-ge v12, v13, :cond_2

    .line 318
    iget-object v0, v6, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->placeables:[Landroidx/compose/ui/layout/Placeable;

    aget-object v22, v0, v12

    .line 319
    .local v22, "placeable":Landroidx/compose/ui/layout/Placeable;
    invoke-static/range {v22 .. v22}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 320
    invoke-virtual/range {p2 .. p2}, Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;->getMainAxisPositions()[I

    move-result-object v23

    .line 321
    .local v23, "mainAxisPositions":[I
    nop

    .line 322
    nop

    .line 323
    iget-object v0, v6, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->measurables:Ljava/util/List;

    invoke-interface {v0, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/compose/ui/layout/Measurable;

    invoke-interface {v0}, Landroidx/compose/ui/layout/Measurable;->getParentData()Ljava/lang/Object;

    move-result-object v0

    instance-of v1, v0, Landroidx/compose/foundation/layout/RowColumnParentData;

    if-eqz v1, :cond_0

    check-cast v0, Landroidx/compose/foundation/layout/RowColumnParentData;

    goto :goto_1

    :cond_0
    const/4 v0, 0x0

    :goto_1
    move-object v2, v0

    .line 324
    invoke-virtual/range {p2 .. p2}, Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;->getCrossAxisSize()I

    move-result v3

    .line 325
    nop

    .line 326
    invoke-virtual/range {p2 .. p2}, Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;->getBeforeCrossAxisAlignmentLine()I

    move-result v5

    .line 321
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    move-object/from16 v4, p4

    invoke-direct/range {v0 .. v5}, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->getCrossAxisPosition(Landroidx/compose/ui/layout/Placeable;Landroidx/compose/foundation/layout/RowColumnParentData;ILandroidx/compose/ui/unit/LayoutDirection;I)I

    move-result v0

    .line 327
    nop

    .line 321
    add-int v0, v0, p3

    .line 328
    .local v0, "crossAxisPosition":I
    iget-object v1, v6, Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;->orientation:Landroidx/compose/foundation/layout/LayoutOrientation;

    sget-object v2, Landroidx/compose/foundation/layout/LayoutOrientation;->Horizontal:Landroidx/compose/foundation/layout/LayoutOrientation;

    if-ne v1, v2, :cond_1

    .line 329
    nop

    .line 330
    invoke-virtual/range {p2 .. p2}, Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;->getStartIndex()I

    move-result v1

    sub-int v1, v12, v1

    aget v16, v23, v1

    .line 331
    nop

    .line 329
    const/16 v18, 0x0

    const/16 v19, 0x4

    const/16 v20, 0x0

    move-object/from16 v15, v22

    move/from16 v17, v0

    invoke-static/range {v14 .. v20}, Landroidx/compose/ui/layout/Placeable$PlacementScope;->place$default(Landroidx/compose/ui/layout/Placeable$PlacementScope;Landroidx/compose/ui/layout/Placeable;IIFILjava/lang/Object;)V

    move v3, v12

    move v1, v13

    goto :goto_2

    .line 334
    :cond_1
    nop

    .line 335
    nop

    .line 336
    invoke-virtual/range {p2 .. p2}, Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;->getStartIndex()I

    move-result v1

    sub-int v1, v12, v1

    aget v10, v23, v1

    .line 334
    const/4 v11, 0x0

    const/4 v1, 0x4

    const/4 v2, 0x0

    move-object v7, v14

    move-object/from16 v8, v22

    move v9, v0

    move v3, v12

    .end local v12    # "i":I
    .local v3, "i":I
    move v12, v1

    move v1, v13

    move-object v13, v2

    invoke-static/range {v7 .. v13}, Landroidx/compose/ui/layout/Placeable$PlacementScope;->place$default(Landroidx/compose/ui/layout/Placeable$PlacementScope;Landroidx/compose/ui/layout/Placeable;IIFILjava/lang/Object;)V

    .line 317
    .end local v0    # "crossAxisPosition":I
    .end local v22    # "placeable":Landroidx/compose/ui/layout/Placeable;
    .end local v23    # "mainAxisPositions":[I
    :goto_2
    add-int/lit8 v12, v3, 0x1

    move v13, v1

    .end local v3    # "i":I
    .restart local v12    # "i":I
    goto :goto_0

    .line 340
    .end local v12    # "i":I
    :cond_2
    nop

    .line 316
    .end local v14    # "$this$placeHelper_u24lambda_u249":Landroidx/compose/ui/layout/Placeable$PlacementScope;
    .end local v21    # "$i$a$-with-RowColumnMeasurementHelper$placeHelper$1":I
    nop

    .line 341
    return-void
.end method
