.class final Landroidx/media3/extractor/text/ssa/SsaStyle$Format;
.super Ljava/lang/Object;
.source "SsaStyle.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/extractor/text/ssa/SsaStyle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "Format"
.end annotation


# instance fields
.field public final alignmentIndex:I

.field public final boldIndex:I

.field public final borderStyleIndex:I

.field public final fontSizeIndex:I

.field public final italicIndex:I

.field public final length:I

.field public final nameIndex:I

.field public final outlineColorIndex:I

.field public final primaryColorIndex:I

.field public final strikeoutIndex:I

.field public final underlineIndex:I


# direct methods
.method private constructor <init>(IIIIIIIIIII)V
    .locals 0
    .param p1, "nameIndex"    # I
    .param p2, "alignmentIndex"    # I
    .param p3, "primaryColorIndex"    # I
    .param p4, "outlineColorIndex"    # I
    .param p5, "fontSizeIndex"    # I
    .param p6, "boldIndex"    # I
    .param p7, "italicIndex"    # I
    .param p8, "underlineIndex"    # I
    .param p9, "strikeoutIndex"    # I
    .param p10, "borderStyleIndex"    # I
    .param p11, "length"    # I

    .line 342
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 343
    iput p1, p0, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;->nameIndex:I

    .line 344
    iput p2, p0, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;->alignmentIndex:I

    .line 345
    iput p3, p0, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;->primaryColorIndex:I

    .line 346
    iput p4, p0, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;->outlineColorIndex:I

    .line 347
    iput p5, p0, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;->fontSizeIndex:I

    .line 348
    iput p6, p0, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;->boldIndex:I

    .line 349
    iput p7, p0, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;->italicIndex:I

    .line 350
    iput p8, p0, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;->underlineIndex:I

    .line 351
    iput p9, p0, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;->strikeoutIndex:I

    .line 352
    iput p10, p0, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;->borderStyleIndex:I

    .line 353
    iput p11, p0, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;->length:I

    .line 354
    return-void
.end method

.method public static fromFormatLine(Ljava/lang/String;)Landroidx/media3/extractor/text/ssa/SsaStyle$Format;
    .locals 25
    .param p0, "styleFormatLine"    # Ljava/lang/String;

    .line 363
    const/4 v0, -0x1

    .line 364
    .local v0, "nameIndex":I
    const/4 v1, -0x1

    .line 365
    .local v1, "alignmentIndex":I
    const/4 v2, -0x1

    .line 366
    .local v2, "primaryColorIndex":I
    const/4 v3, -0x1

    .line 367
    .local v3, "outlineColorIndex":I
    const/4 v4, -0x1

    .line 368
    .local v4, "fontSizeIndex":I
    const/4 v5, -0x1

    .line 369
    .local v5, "boldIndex":I
    const/4 v6, -0x1

    .line 370
    .local v6, "italicIndex":I
    const/4 v7, -0x1

    .line 371
    .local v7, "underlineIndex":I
    const/4 v8, -0x1

    .line 372
    .local v8, "strikeoutIndex":I
    const/4 v9, -0x1

    .line 373
    .local v9, "borderStyleIndex":I
    nop

    .line 374
    const-string v10, "Format:"

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v10

    move-object/from16 v11, p0

    invoke-virtual {v11, v10}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v10

    const-string v12, ","

    invoke-static {v10, v12}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v10

    .line 375
    .local v10, "keys":[Ljava/lang/String;
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_0
    array-length v13, v10

    const/4 v14, -0x1

    if-ge v12, v13, :cond_1

    .line 376
    aget-object v13, v10, v12

    invoke-virtual {v13}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Lcom/google/common/base/Ascii;->toLowerCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/String;->hashCode()I

    move-result v15

    sparse-switch v15, :sswitch_data_0

    :cond_0
    goto/16 :goto_1

    :sswitch_0
    const-string/jumbo v15, "outlinecolour"

    invoke-virtual {v13, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_0

    const/4 v14, 0x3

    goto :goto_1

    :sswitch_1
    const-string v15, "alignment"

    invoke-virtual {v13, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_0

    const/4 v14, 0x1

    goto :goto_1

    :sswitch_2
    const-string v15, "borderstyle"

    invoke-virtual {v13, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_0

    const/16 v14, 0x9

    goto :goto_1

    :sswitch_3
    const-string v15, "fontsize"

    invoke-virtual {v13, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_0

    const/4 v14, 0x4

    goto :goto_1

    :sswitch_4
    const-string/jumbo v15, "name"

    invoke-virtual {v13, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_0

    const/4 v14, 0x0

    goto :goto_1

    :sswitch_5
    const-string v15, "bold"

    invoke-virtual {v13, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_0

    const/4 v14, 0x5

    goto :goto_1

    :sswitch_6
    const-string/jumbo v15, "primarycolour"

    invoke-virtual {v13, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_0

    const/4 v14, 0x2

    goto :goto_1

    :sswitch_7
    const-string/jumbo v15, "strikeout"

    invoke-virtual {v13, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_0

    const/16 v14, 0x8

    goto :goto_1

    :sswitch_8
    const-string/jumbo v15, "underline"

    invoke-virtual {v13, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_0

    const/4 v14, 0x7

    goto :goto_1

    :sswitch_9
    const-string v15, "italic"

    invoke-virtual {v13, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_0

    const/4 v14, 0x6

    :goto_1
    packed-switch v14, :pswitch_data_0

    goto :goto_2

    .line 405
    :pswitch_0
    move v9, v12

    goto :goto_2

    .line 402
    :pswitch_1
    move v8, v12

    .line 403
    goto :goto_2

    .line 399
    :pswitch_2
    move v7, v12

    .line 400
    goto :goto_2

    .line 396
    :pswitch_3
    move v6, v12

    .line 397
    goto :goto_2

    .line 393
    :pswitch_4
    move v5, v12

    .line 394
    goto :goto_2

    .line 390
    :pswitch_5
    move v4, v12

    .line 391
    goto :goto_2

    .line 387
    :pswitch_6
    move v3, v12

    .line 388
    goto :goto_2

    .line 384
    :pswitch_7
    move v2, v12

    .line 385
    goto :goto_2

    .line 381
    :pswitch_8
    move v1, v12

    .line 382
    goto :goto_2

    .line 378
    :pswitch_9
    move v0, v12

    .line 379
    nop

    .line 375
    :goto_2
    add-int/lit8 v12, v12, 0x1

    goto/16 :goto_0

    .line 409
    .end local v12    # "i":I
    :cond_1
    if-eq v0, v14, :cond_2

    .line 410
    new-instance v12, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;

    array-length v15, v10

    move-object v13, v12

    move v14, v0

    move/from16 v24, v15

    move v15, v1

    move/from16 v16, v2

    move/from16 v17, v3

    move/from16 v18, v4

    move/from16 v19, v5

    move/from16 v20, v6

    move/from16 v21, v7

    move/from16 v22, v8

    move/from16 v23, v9

    invoke-direct/range {v13 .. v24}, Landroidx/media3/extractor/text/ssa/SsaStyle$Format;-><init>(IIIIIIIIIII)V

    goto :goto_3

    .line 422
    :cond_2
    const/4 v12, 0x0

    .line 409
    :goto_3
    return-object v12

    nop

    :sswitch_data_0
    .sparse-switch
        -0x4642c5d0 -> :sswitch_9
        -0x3d363934 -> :sswitch_8
        -0xb7325a4 -> :sswitch_7
        -0x43a3db2 -> :sswitch_6
        0x2e3a85 -> :sswitch_5
        0x337a8b -> :sswitch_4
        0x15d92cd0 -> :sswitch_3
        0x2dbc6505 -> :sswitch_2
        0x695fa1e3 -> :sswitch_1
        0x76840c8e -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
