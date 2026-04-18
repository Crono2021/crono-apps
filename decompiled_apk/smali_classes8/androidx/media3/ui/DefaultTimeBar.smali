.class public Landroidx/media3/ui/DefaultTimeBar;
.super Landroid/view/View;
.source "DefaultTimeBar.java"

# interfaces
.implements Landroidx/media3/ui/TimeBar;


# static fields
.field private static final ACCESSIBILITY_CLASS_NAME:Ljava/lang/String; = "android.widget.SeekBar"

.field public static final BAR_GRAVITY_BOTTOM:I = 0x1

.field public static final BAR_GRAVITY_CENTER:I = 0x0

.field public static final DEFAULT_AD_MARKER_COLOR:I = -0x4d000100

.field public static final DEFAULT_AD_MARKER_WIDTH_DP:I = 0x4

.field public static final DEFAULT_BAR_HEIGHT_DP:I = 0x4

.field public static final DEFAULT_BUFFERED_COLOR:I = -0x33000001

.field private static final DEFAULT_INCREMENT_COUNT:I = 0x14

.field public static final DEFAULT_PLAYED_AD_MARKER_COLOR:I = 0x33ffff00

.field public static final DEFAULT_PLAYED_COLOR:I = -0x1

.field public static final DEFAULT_SCRUBBER_COLOR:I = -0x1

.field public static final DEFAULT_SCRUBBER_DISABLED_SIZE_DP:I = 0x0

.field public static final DEFAULT_SCRUBBER_DRAGGED_SIZE_DP:I = 0x10

.field public static final DEFAULT_SCRUBBER_ENABLED_SIZE_DP:I = 0xc

.field public static final DEFAULT_TOUCH_TARGET_HEIGHT_DP:I = 0x1a

.field public static final DEFAULT_UNPLAYED_COLOR:I = 0x33ffffff

.field private static final FINE_SCRUB_RATIO:I = 0x3

.field private static final FINE_SCRUB_Y_THRESHOLD_DP:I = -0x32

.field private static final HIDDEN_SCRUBBER_SCALE:F = 0.0f

.field private static final SHOWN_SCRUBBER_SCALE:F = 1.0f

.field private static final STOP_SCRUBBING_TIMEOUT_MS:J = 0x3e8L


# instance fields
.field private adGroupCount:I

.field private adGroupTimesMs:[J

.field private final adMarkerPaint:Landroid/graphics/Paint;

.field private final adMarkerWidth:I

.field private final barGravity:I

.field private final barHeight:I

.field private final bufferedBar:Landroid/graphics/Rect;

.field private final bufferedPaint:Landroid/graphics/Paint;

.field private bufferedPosition:J

.field private final density:F

.field private duration:J

.field private final fineScrubYThreshold:I

.field private final formatBuilder:Ljava/lang/StringBuilder;

.field private final formatter:Ljava/util/Formatter;

.field private keyCountIncrement:I

.field private keyTimeIncrement:J

.field private lastCoarseScrubXPosition:I

.field private lastExclusionRectangle:Landroid/graphics/Rect;

.field private final listeners:Ljava/util/concurrent/CopyOnWriteArraySet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArraySet<",
            "Landroidx/media3/ui/TimeBar$OnScrubListener;",
            ">;"
        }
    .end annotation
.end field

.field private playedAdGroups:[Z

.field private final playedAdMarkerPaint:Landroid/graphics/Paint;

.field private final playedPaint:Landroid/graphics/Paint;

.field private position:J

.field private final progressBar:Landroid/graphics/Rect;

.field private scrubPosition:J

.field private final scrubberBar:Landroid/graphics/Rect;

.field private final scrubberDisabledSize:I

.field private final scrubberDraggedSize:I

.field private final scrubberDrawable:Landroid/graphics/drawable/Drawable;

.field private final scrubberEnabledSize:I

.field private final scrubberPadding:I

.field private scrubberPaddingDisabled:Z

.field private final scrubberPaint:Landroid/graphics/Paint;

.field private scrubberScale:F

.field private scrubberScalingAnimator:Landroid/animation/ValueAnimator;

.field private scrubbing:Z

.field private final seekBounds:Landroid/graphics/Rect;

.field private final stopScrubbingRunnable:Ljava/lang/Runnable;

.field private final touchPosition:Landroid/graphics/Point;

.field private final touchTargetHeight:I

.field private final unplayedPaint:Landroid/graphics/Paint;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 242
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroidx/media3/ui/DefaultTimeBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 243
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 246
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroidx/media3/ui/DefaultTimeBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 247
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .line 250
    invoke-direct {p0, p1, p2, p3, p2}, Landroidx/media3/ui/DefaultTimeBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/util/AttributeSet;)V

    .line 251
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/util/AttributeSet;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I
    .param p4, "timebarAttrs"    # Landroid/util/AttributeSet;

    .line 258
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v5}, Landroidx/media3/ui/DefaultTimeBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/util/AttributeSet;I)V

    .line 259
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/util/AttributeSet;I)V
    .locals 23
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I
    .param p4, "timebarAttrs"    # Landroid/util/AttributeSet;
    .param p5, "defStyleRes"    # I

    .line 269
    move-object/from16 v1, p0

    move-object/from16 v2, p4

    invoke-direct/range {p0 .. p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 270
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, v1, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    .line 271
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, v1, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    .line 272
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, v1, Landroidx/media3/ui/DefaultTimeBar;->bufferedBar:Landroid/graphics/Rect;

    .line 273
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    .line 274
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, v1, Landroidx/media3/ui/DefaultTimeBar;->playedPaint:Landroid/graphics/Paint;

    .line 275
    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    iput-object v3, v1, Landroidx/media3/ui/DefaultTimeBar;->bufferedPaint:Landroid/graphics/Paint;

    .line 276
    new-instance v4, Landroid/graphics/Paint;

    invoke-direct {v4}, Landroid/graphics/Paint;-><init>()V

    iput-object v4, v1, Landroidx/media3/ui/DefaultTimeBar;->unplayedPaint:Landroid/graphics/Paint;

    .line 277
    new-instance v5, Landroid/graphics/Paint;

    invoke-direct {v5}, Landroid/graphics/Paint;-><init>()V

    iput-object v5, v1, Landroidx/media3/ui/DefaultTimeBar;->adMarkerPaint:Landroid/graphics/Paint;

    .line 278
    new-instance v6, Landroid/graphics/Paint;

    invoke-direct {v6}, Landroid/graphics/Paint;-><init>()V

    iput-object v6, v1, Landroidx/media3/ui/DefaultTimeBar;->playedAdMarkerPaint:Landroid/graphics/Paint;

    .line 279
    new-instance v7, Landroid/graphics/Paint;

    invoke-direct {v7}, Landroid/graphics/Paint;-><init>()V

    iput-object v7, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberPaint:Landroid/graphics/Paint;

    .line 280
    const/4 v8, 0x1

    invoke-virtual {v7, v8}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 281
    new-instance v9, Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-direct {v9}, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V

    iput-object v9, v1, Landroidx/media3/ui/DefaultTimeBar;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    .line 282
    new-instance v9, Landroid/graphics/Point;

    invoke-direct {v9}, Landroid/graphics/Point;-><init>()V

    iput-object v9, v1, Landroidx/media3/ui/DefaultTimeBar;->touchPosition:Landroid/graphics/Point;

    .line 285
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    .line 286
    .local v9, "res":Landroid/content/res/Resources;
    invoke-virtual {v9}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v10

    .line 287
    .local v10, "displayMetrics":Landroid/util/DisplayMetrics;
    iget v11, v10, Landroid/util/DisplayMetrics;->density:F

    iput v11, v1, Landroidx/media3/ui/DefaultTimeBar;->density:F

    .line 288
    const/16 v12, -0x32

    invoke-static {v11, v12}, Landroidx/media3/ui/DefaultTimeBar;->dpToPx(FI)I

    move-result v12

    iput v12, v1, Landroidx/media3/ui/DefaultTimeBar;->fineScrubYThreshold:I

    .line 289
    const/4 v12, 0x4

    invoke-static {v11, v12}, Landroidx/media3/ui/DefaultTimeBar;->dpToPx(FI)I

    move-result v13

    .line 290
    .local v13, "defaultBarHeight":I
    const/16 v14, 0x1a

    invoke-static {v11, v14}, Landroidx/media3/ui/DefaultTimeBar;->dpToPx(FI)I

    move-result v14

    .line 291
    .local v14, "defaultTouchTargetHeight":I
    invoke-static {v11, v12}, Landroidx/media3/ui/DefaultTimeBar;->dpToPx(FI)I

    move-result v12

    .line 292
    .local v12, "defaultAdMarkerWidth":I
    const/16 v15, 0xc

    invoke-static {v11, v15}, Landroidx/media3/ui/DefaultTimeBar;->dpToPx(FI)I

    move-result v15

    .line 293
    .local v15, "defaultScrubberEnabledSize":I
    const/4 v8, 0x0

    move-object/from16 v16, v9

    .end local v9    # "res":Landroid/content/res/Resources;
    .local v16, "res":Landroid/content/res/Resources;
    invoke-static {v11, v8}, Landroidx/media3/ui/DefaultTimeBar;->dpToPx(FI)I

    move-result v9

    .line 294
    .local v9, "defaultScrubberDisabledSize":I
    const/16 v8, 0x10

    invoke-static {v11, v8}, Landroidx/media3/ui/DefaultTimeBar;->dpToPx(FI)I

    move-result v8

    .line 295
    .local v8, "defaultScrubberDraggedSize":I
    if-eqz v2, :cond_1

    .line 296
    nop

    .line 298
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v11

    move-object/from16 v18, v10

    .end local v10    # "displayMetrics":Landroid/util/DisplayMetrics;
    .local v18, "displayMetrics":Landroid/util/DisplayMetrics;
    sget-object v10, Landroidx/media3/ui/R$styleable;->DefaultTimeBar:[I

    .line 299
    move-object/from16 v20, v5

    move-object/from16 v19, v6

    move/from16 v6, p3

    move/from16 v5, p5

    invoke-virtual {v11, v2, v10, v6, v5}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v10

    .line 302
    .local v10, "a":Landroid/content/res/TypedArray;
    :try_start_0
    sget v11, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_scrubber_drawable:I

    invoke-virtual {v10, v11}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v11

    iput-object v11, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberDrawable:Landroid/graphics/drawable/Drawable;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_5

    .line 303
    if-eqz v11, :cond_0

    .line 304
    :try_start_1
    invoke-direct {v1, v11}, Landroidx/media3/ui/DefaultTimeBar;->setDrawableLayoutDirection(Landroid/graphics/drawable/Drawable;)Z

    .line 305
    nop

    .line 306
    invoke-virtual {v11}, Landroid/graphics/drawable/Drawable;->getMinimumHeight()I

    move-result v11

    invoke-static {v11, v14}, Ljava/lang/Math;->max(II)I

    move-result v11
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move v14, v11

    goto :goto_0

    .line 345
    :catchall_0
    move-exception v0

    move/from16 v21, v8

    move/from16 v22, v9

    goto/16 :goto_1

    .line 308
    :cond_0
    :goto_0
    :try_start_2
    sget v11, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_bar_height:I

    .line 309
    invoke-virtual {v10, v11, v13}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v11

    iput v11, v1, Landroidx/media3/ui/DefaultTimeBar;->barHeight:I

    .line 310
    sget v11, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_touch_target_height:I

    .line 311
    invoke-virtual {v10, v11, v14}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v11

    iput v11, v1, Landroidx/media3/ui/DefaultTimeBar;->touchTargetHeight:I

    .line 313
    sget v11, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_bar_gravity:I

    const/4 v2, 0x0

    invoke-virtual {v10, v11, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    iput v2, v1, Landroidx/media3/ui/DefaultTimeBar;->barGravity:I

    .line 314
    sget v2, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_ad_marker_width:I

    .line 315
    invoke-virtual {v10, v2, v12}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    iput v2, v1, Landroidx/media3/ui/DefaultTimeBar;->adMarkerWidth:I

    .line 317
    sget v2, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_scrubber_enabled_size:I

    .line 318
    invoke-virtual {v10, v2, v15}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    iput v2, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberEnabledSize:I

    .line 320
    sget v2, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_scrubber_disabled_size:I

    .line 321
    invoke-virtual {v10, v2, v9}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    iput v2, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberDisabledSize:I

    .line 323
    sget v2, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_scrubber_dragged_size:I

    .line 324
    invoke-virtual {v10, v2, v8}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    iput v2, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberDraggedSize:I

    .line 326
    sget v2, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_played_color:I

    const/4 v11, -0x1

    invoke-virtual {v10, v2, v11}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    .line 327
    .local v2, "playedColor":I
    sget v11, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_scrubber_color:I

    .line 328
    const/4 v5, -0x1

    invoke-virtual {v10, v11, v5}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v5

    .line 329
    .local v5, "scrubberColor":I
    sget v11, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_buffered_color:I

    .line 330
    const v6, -0x33000001    # -1.3421772E8f

    invoke-virtual {v10, v11, v6}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v6

    .line 331
    .local v6, "bufferedColor":I
    sget v11, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_unplayed_color:I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_4

    .line 332
    move/from16 v17, v14

    const v14, 0x33ffffff

    .end local v14    # "defaultTouchTargetHeight":I
    .local v17, "defaultTouchTargetHeight":I
    :try_start_3
    invoke-virtual {v10, v11, v14}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v11

    .line 333
    .local v11, "unplayedColor":I
    sget v14, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_ad_marker_color:I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    .line 334
    move/from16 v21, v8

    const v8, -0x4d000100

    .end local v8    # "defaultScrubberDraggedSize":I
    .local v21, "defaultScrubberDraggedSize":I
    :try_start_4
    invoke-virtual {v10, v14, v8}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v8

    .line 335
    .local v8, "adMarkerColor":I
    sget v14, Landroidx/media3/ui/R$styleable;->DefaultTimeBar_played_ad_marker_color:I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 336
    move/from16 v22, v9

    const v9, 0x33ffff00

    .end local v9    # "defaultScrubberDisabledSize":I
    .local v22, "defaultScrubberDisabledSize":I
    :try_start_5
    invoke-virtual {v10, v14, v9}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v9

    .line 338
    .local v9, "playedAdMarkerColor":I
    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 339
    invoke-virtual {v7, v5}, Landroid/graphics/Paint;->setColor(I)V

    .line 340
    invoke-virtual {v3, v6}, Landroid/graphics/Paint;->setColor(I)V

    .line 341
    invoke-virtual {v4, v11}, Landroid/graphics/Paint;->setColor(I)V

    .line 342
    move-object/from16 v0, v20

    invoke-virtual {v0, v8}, Landroid/graphics/Paint;->setColor(I)V

    .line 343
    move-object/from16 v0, v19

    invoke-virtual {v0, v9}, Landroid/graphics/Paint;->setColor(I)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 345
    .end local v2    # "playedColor":I
    .end local v5    # "scrubberColor":I
    .end local v6    # "bufferedColor":I
    .end local v8    # "adMarkerColor":I
    .end local v9    # "playedAdMarkerColor":I
    .end local v11    # "unplayedColor":I
    invoke-virtual {v10}, Landroid/content/res/TypedArray;->recycle()V

    .line 346
    nop

    .line 347
    .end local v10    # "a":Landroid/content/res/TypedArray;
    move/from16 v14, v17

    move/from16 v8, v21

    move/from16 v6, v22

    goto :goto_2

    .line 345
    .restart local v10    # "a":Landroid/content/res/TypedArray;
    :catchall_1
    move-exception v0

    move/from16 v14, v17

    goto :goto_1

    .end local v22    # "defaultScrubberDisabledSize":I
    .local v9, "defaultScrubberDisabledSize":I
    :catchall_2
    move-exception v0

    move/from16 v22, v9

    move/from16 v14, v17

    .end local v9    # "defaultScrubberDisabledSize":I
    .restart local v22    # "defaultScrubberDisabledSize":I
    goto :goto_1

    .end local v21    # "defaultScrubberDraggedSize":I
    .end local v22    # "defaultScrubberDisabledSize":I
    .local v8, "defaultScrubberDraggedSize":I
    .restart local v9    # "defaultScrubberDisabledSize":I
    :catchall_3
    move-exception v0

    move/from16 v21, v8

    move/from16 v22, v9

    move/from16 v14, v17

    .end local v8    # "defaultScrubberDraggedSize":I
    .end local v9    # "defaultScrubberDisabledSize":I
    .restart local v21    # "defaultScrubberDraggedSize":I
    .restart local v22    # "defaultScrubberDisabledSize":I
    goto :goto_1

    .end local v17    # "defaultTouchTargetHeight":I
    .end local v21    # "defaultScrubberDraggedSize":I
    .end local v22    # "defaultScrubberDisabledSize":I
    .restart local v8    # "defaultScrubberDraggedSize":I
    .restart local v9    # "defaultScrubberDisabledSize":I
    .restart local v14    # "defaultTouchTargetHeight":I
    :catchall_4
    move-exception v0

    move/from16 v21, v8

    move/from16 v22, v9

    move/from16 v17, v14

    .end local v8    # "defaultScrubberDraggedSize":I
    .end local v9    # "defaultScrubberDisabledSize":I
    .end local v14    # "defaultTouchTargetHeight":I
    .restart local v17    # "defaultTouchTargetHeight":I
    .restart local v21    # "defaultScrubberDraggedSize":I
    .restart local v22    # "defaultScrubberDisabledSize":I
    goto :goto_1

    .end local v17    # "defaultTouchTargetHeight":I
    .end local v21    # "defaultScrubberDraggedSize":I
    .end local v22    # "defaultScrubberDisabledSize":I
    .restart local v8    # "defaultScrubberDraggedSize":I
    .restart local v9    # "defaultScrubberDisabledSize":I
    .restart local v14    # "defaultTouchTargetHeight":I
    :catchall_5
    move-exception v0

    move/from16 v21, v8

    move/from16 v22, v9

    .end local v8    # "defaultScrubberDraggedSize":I
    .end local v9    # "defaultScrubberDisabledSize":I
    .restart local v21    # "defaultScrubberDraggedSize":I
    .restart local v22    # "defaultScrubberDisabledSize":I
    :goto_1
    invoke-virtual {v10}, Landroid/content/res/TypedArray;->recycle()V

    .line 346
    throw v0

    .line 348
    .end local v18    # "displayMetrics":Landroid/util/DisplayMetrics;
    .end local v21    # "defaultScrubberDraggedSize":I
    .end local v22    # "defaultScrubberDisabledSize":I
    .restart local v8    # "defaultScrubberDraggedSize":I
    .restart local v9    # "defaultScrubberDisabledSize":I
    .local v10, "displayMetrics":Landroid/util/DisplayMetrics;
    :cond_1
    move-object v2, v5

    move-object v5, v6

    move/from16 v21, v8

    move/from16 v22, v9

    move-object/from16 v18, v10

    .end local v8    # "defaultScrubberDraggedSize":I
    .end local v9    # "defaultScrubberDisabledSize":I
    .end local v10    # "displayMetrics":Landroid/util/DisplayMetrics;
    .restart local v18    # "displayMetrics":Landroid/util/DisplayMetrics;
    .restart local v21    # "defaultScrubberDraggedSize":I
    .restart local v22    # "defaultScrubberDisabledSize":I
    iput v13, v1, Landroidx/media3/ui/DefaultTimeBar;->barHeight:I

    .line 349
    iput v14, v1, Landroidx/media3/ui/DefaultTimeBar;->touchTargetHeight:I

    .line 350
    const/4 v6, 0x0

    iput v6, v1, Landroidx/media3/ui/DefaultTimeBar;->barGravity:I

    .line 351
    iput v12, v1, Landroidx/media3/ui/DefaultTimeBar;->adMarkerWidth:I

    .line 352
    iput v15, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberEnabledSize:I

    .line 353
    move/from16 v6, v22

    .end local v22    # "defaultScrubberDisabledSize":I
    .local v6, "defaultScrubberDisabledSize":I
    iput v6, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberDisabledSize:I

    .line 354
    nop

    .end local v21    # "defaultScrubberDraggedSize":I
    .restart local v8    # "defaultScrubberDraggedSize":I
    iput v8, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberDraggedSize:I

    .line 355
    const/4 v9, -0x1

    invoke-virtual {v0, v9}, Landroid/graphics/Paint;->setColor(I)V

    .line 356
    invoke-virtual {v7, v9}, Landroid/graphics/Paint;->setColor(I)V

    .line 357
    const v0, -0x33000001    # -1.3421772E8f

    invoke-virtual {v3, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 358
    const v0, 0x33ffffff

    invoke-virtual {v4, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 359
    const v0, -0x4d000100

    invoke-virtual {v2, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 360
    const v0, 0x33ffff00

    invoke-virtual {v5, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 361
    const/4 v0, 0x0

    iput-object v0, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberDrawable:Landroid/graphics/drawable/Drawable;

    .line 363
    :goto_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, v1, Landroidx/media3/ui/DefaultTimeBar;->formatBuilder:Ljava/lang/StringBuilder;

    .line 364
    new-instance v2, Ljava/util/Formatter;

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    invoke-direct {v2, v0, v3}, Ljava/util/Formatter;-><init>(Ljava/lang/Appendable;Ljava/util/Locale;)V

    iput-object v2, v1, Landroidx/media3/ui/DefaultTimeBar;->formatter:Ljava/util/Formatter;

    .line 365
    new-instance v0, Landroidx/media3/ui/DefaultTimeBar$$ExternalSyntheticLambda0;

    invoke-direct {v0, v1}, Landroidx/media3/ui/DefaultTimeBar$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/ui/DefaultTimeBar;)V

    iput-object v0, v1, Landroidx/media3/ui/DefaultTimeBar;->stopScrubbingRunnable:Ljava/lang/Runnable;

    .line 366
    iget-object v0, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_2

    .line 367
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getMinimumWidth()I

    move-result v0

    const/4 v2, 0x1

    add-int/2addr v0, v2

    div-int/lit8 v0, v0, 0x2

    iput v0, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberPadding:I

    goto :goto_3

    .line 369
    :cond_2
    const/4 v2, 0x1

    iget v0, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberDisabledSize:I

    iget v3, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberEnabledSize:I

    iget v4, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberDraggedSize:I

    .line 370
    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    invoke-static {v0, v3}, Ljava/lang/Math;->max(II)I

    move-result v0

    add-int/2addr v0, v2

    div-int/lit8 v0, v0, 0x2

    iput v0, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberPadding:I

    .line 373
    :goto_3
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberScale:F

    .line 374
    new-instance v0, Landroid/animation/ValueAnimator;

    invoke-direct {v0}, Landroid/animation/ValueAnimator;-><init>()V

    iput-object v0, v1, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    .line 375
    new-instance v2, Landroidx/media3/ui/DefaultTimeBar$$ExternalSyntheticLambda1;

    invoke-direct {v2, v1}, Landroidx/media3/ui/DefaultTimeBar$$ExternalSyntheticLambda1;-><init>(Landroidx/media3/ui/DefaultTimeBar;)V

    invoke-virtual {v0, v2}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 380
    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v2, v1, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    .line 381
    iput-wide v2, v1, Landroidx/media3/ui/DefaultTimeBar;->keyTimeIncrement:J

    .line 382
    const/16 v0, 0x14

    iput v0, v1, Landroidx/media3/ui/DefaultTimeBar;->keyCountIncrement:I

    .line 383
    const/4 v0, 0x1

    invoke-virtual {v1, v0}, Landroidx/media3/ui/DefaultTimeBar;->setFocusable(Z)V

    .line 384
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/ui/DefaultTimeBar;->getImportantForAccessibility()I

    move-result v2

    if-nez v2, :cond_3

    .line 385
    invoke-virtual {v1, v0}, Landroidx/media3/ui/DefaultTimeBar;->setImportantForAccessibility(I)V

    .line 387
    :cond_3
    return-void
.end method

.method private static dpToPx(FI)I
    .locals 2
    .param p0, "density"    # F
    .param p1, "dps"    # I

    .line 996
    int-to-float v0, p1

    mul-float/2addr v0, p0

    const/high16 v1, 0x3f000000    # 0.5f

    add-float/2addr v0, v1

    float-to-int v0, v0

    return v0
.end method

.method private drawPlayhead(Landroid/graphics/Canvas;)V
    .locals 9
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .line 933
    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-gtz v0, :cond_0

    .line 934
    return-void

    .line 936
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->right:I

    iget-object v1, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->left:I

    iget-object v2, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->right:I

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/Util;->constrainValue(III)I

    move-result v0

    .line 937
    .local v0, "playheadX":I
    iget-object v1, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->centerY()I

    move-result v1

    .line 938
    .local v1, "playheadY":I
    iget-object v2, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberDrawable:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_4

    .line 940
    iget-boolean v2, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubbing:Z

    if-nez v2, :cond_3

    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->isFocused()Z

    move-result v2

    if-eqz v2, :cond_1

    goto :goto_0

    .line 942
    :cond_1
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_2

    iget v2, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberEnabledSize:I

    goto :goto_1

    :cond_2
    iget v2, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberDisabledSize:I

    goto :goto_1

    .line 941
    :cond_3
    :goto_0
    iget v2, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberDraggedSize:I

    .line 942
    :goto_1
    nop

    .line 943
    .local v2, "scrubberSize":I
    int-to-float v3, v2

    iget v4, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScale:F

    mul-float/2addr v3, v4

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    float-to-int v3, v3

    .line 944
    .local v3, "playheadRadius":I
    int-to-float v4, v0

    int-to-float v5, v1

    int-to-float v6, v3

    iget-object v7, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v4, v5, v6, v7}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 945
    .end local v2    # "scrubberSize":I
    .end local v3    # "playheadRadius":I
    goto :goto_2

    .line 946
    :cond_4
    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    int-to-float v2, v2

    iget v3, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScale:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    .line 947
    .local v2, "scrubberDrawableWidth":I
    iget-object v3, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v3

    int-to-float v3, v3

    iget v4, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScale:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    .line 948
    .local v3, "scrubberDrawableHeight":I
    iget-object v4, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberDrawable:Landroid/graphics/drawable/Drawable;

    div-int/lit8 v5, v2, 0x2

    sub-int v5, v0, v5

    div-int/lit8 v6, v3, 0x2

    sub-int v6, v1, v6

    div-int/lit8 v7, v2, 0x2

    add-int/2addr v7, v0

    div-int/lit8 v8, v3, 0x2

    add-int/2addr v8, v1

    invoke-virtual {v4, v5, v6, v7, v8}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 953
    iget-object v4, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v4, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 955
    .end local v2    # "scrubberDrawableWidth":I
    .end local v3    # "scrubberDrawableHeight":I
    :goto_2
    return-void
.end method

.method private drawTimeBar(Landroid/graphics/Canvas;)V
    .locals 25
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .line 894
    move-object/from16 v0, p0

    iget-object v1, v0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v1

    .line 895
    .local v1, "progressBarHeight":I
    iget-object v2, v0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->centerY()I

    move-result v2

    div-int/lit8 v3, v1, 0x2

    sub-int/2addr v2, v3

    .line 896
    .local v2, "barTop":I
    add-int v3, v2, v1

    .line 897
    .local v3, "barBottom":I
    iget-wide v4, v0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    const-wide/16 v6, 0x0

    cmp-long v4, v4, v6

    if-gtz v4, :cond_0

    .line 898
    iget-object v4, v0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->left:I

    int-to-float v6, v4

    int-to-float v7, v2

    iget-object v4, v0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->right:I

    int-to-float v8, v4

    int-to-float v9, v3

    iget-object v10, v0, Landroidx/media3/ui/DefaultTimeBar;->unplayedPaint:Landroid/graphics/Paint;

    move-object/from16 v5, p1

    invoke-virtual/range {v5 .. v10}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 899
    return-void

    .line 901
    :cond_0
    iget-object v4, v0, Landroidx/media3/ui/DefaultTimeBar;->bufferedBar:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->left:I

    .line 902
    .local v4, "bufferedLeft":I
    iget-object v5, v0, Landroidx/media3/ui/DefaultTimeBar;->bufferedBar:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->right:I

    .line 903
    .local v5, "bufferedRight":I
    iget-object v6, v0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->left:I

    invoke-static {v6, v5}, Ljava/lang/Math;->max(II)I

    move-result v6

    iget-object v7, v0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->right:I

    invoke-static {v6, v7}, Ljava/lang/Math;->max(II)I

    move-result v6

    .line 904
    .local v6, "progressLeft":I
    iget-object v7, v0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->right:I

    if-ge v6, v7, :cond_1

    .line 905
    int-to-float v9, v6

    int-to-float v10, v2

    iget-object v7, v0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->right:I

    int-to-float v11, v7

    int-to-float v12, v3

    iget-object v13, v0, Landroidx/media3/ui/DefaultTimeBar;->unplayedPaint:Landroid/graphics/Paint;

    move-object/from16 v8, p1

    invoke-virtual/range {v8 .. v13}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 907
    :cond_1
    iget-object v7, v0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->right:I

    invoke-static {v4, v7}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 908
    if-le v5, v4, :cond_2

    .line 909
    int-to-float v8, v4

    int-to-float v9, v2

    int-to-float v10, v5

    int-to-float v11, v3

    iget-object v12, v0, Landroidx/media3/ui/DefaultTimeBar;->bufferedPaint:Landroid/graphics/Paint;

    move-object/from16 v7, p1

    invoke-virtual/range {v7 .. v12}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 911
    :cond_2
    iget-object v7, v0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    invoke-virtual {v7}, Landroid/graphics/Rect;->width()I

    move-result v7

    if-lez v7, :cond_3

    .line 912
    iget-object v7, v0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->left:I

    int-to-float v9, v7

    int-to-float v10, v2

    iget-object v7, v0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->right:I

    int-to-float v11, v7

    int-to-float v12, v3

    iget-object v13, v0, Landroidx/media3/ui/DefaultTimeBar;->playedPaint:Landroid/graphics/Paint;

    move-object/from16 v8, p1

    invoke-virtual/range {v8 .. v13}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 914
    :cond_3
    iget v7, v0, Landroidx/media3/ui/DefaultTimeBar;->adGroupCount:I

    if-nez v7, :cond_4

    .line 915
    return-void

    .line 917
    :cond_4
    iget-object v7, v0, Landroidx/media3/ui/DefaultTimeBar;->adGroupTimesMs:[J

    invoke-static {v7}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [J

    .line 918
    .local v7, "adGroupTimesMs":[J
    iget-object v8, v0, Landroidx/media3/ui/DefaultTimeBar;->playedAdGroups:[Z

    invoke-static {v8}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, [Z

    .line 919
    .local v8, "playedAdGroups":[Z
    iget v9, v0, Landroidx/media3/ui/DefaultTimeBar;->adMarkerWidth:I

    div-int/lit8 v9, v9, 0x2

    .line 920
    .local v9, "adMarkerOffset":I
    const/4 v10, 0x0

    .local v10, "i":I
    :goto_0
    iget v11, v0, Landroidx/media3/ui/DefaultTimeBar;->adGroupCount:I

    if-ge v10, v11, :cond_6

    .line 921
    aget-wide v12, v7, v10

    const-wide/16 v14, 0x0

    move/from16 v18, v4

    move v11, v5

    .end local v4    # "bufferedLeft":I
    .end local v5    # "bufferedRight":I
    .local v11, "bufferedRight":I
    .local v18, "bufferedLeft":I
    iget-wide v4, v0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    move-wide/from16 v16, v4

    invoke-static/range {v12 .. v17}, Landroidx/media3/common/util/Util;->constrainValue(JJJ)J

    move-result-wide v4

    .line 922
    .local v4, "adGroupTimeMs":J
    iget-object v12, v0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    .line 923
    invoke-virtual {v12}, Landroid/graphics/Rect;->width()I

    move-result v12

    int-to-long v12, v12

    mul-long/2addr v12, v4

    iget-wide v14, v0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    div-long/2addr v12, v14

    long-to-int v12, v12

    sub-int/2addr v12, v9

    .line 924
    .local v12, "markerPositionOffset":I
    iget-object v13, v0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v13, v13, Landroid/graphics/Rect;->left:I

    iget-object v14, v0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    .line 926
    invoke-virtual {v14}, Landroid/graphics/Rect;->width()I

    move-result v14

    iget v15, v0, Landroidx/media3/ui/DefaultTimeBar;->adMarkerWidth:I

    sub-int/2addr v14, v15

    const/4 v15, 0x0

    invoke-static {v15, v12}, Ljava/lang/Math;->max(II)I

    move-result v15

    invoke-static {v14, v15}, Ljava/lang/Math;->min(II)I

    move-result v14

    add-int/2addr v13, v14

    .line 927
    .local v13, "markerLeft":I
    aget-boolean v14, v8, v10

    if-eqz v14, :cond_5

    iget-object v14, v0, Landroidx/media3/ui/DefaultTimeBar;->playedAdMarkerPaint:Landroid/graphics/Paint;

    goto :goto_1

    :cond_5
    iget-object v14, v0, Landroidx/media3/ui/DefaultTimeBar;->adMarkerPaint:Landroid/graphics/Paint;

    :goto_1
    move-object/from16 v24, v14

    .line 928
    .local v24, "paint":Landroid/graphics/Paint;
    int-to-float v14, v13

    int-to-float v15, v2

    move/from16 v16, v1

    .end local v1    # "progressBarHeight":I
    .local v16, "progressBarHeight":I
    iget v1, v0, Landroidx/media3/ui/DefaultTimeBar;->adMarkerWidth:I

    add-int/2addr v1, v13

    int-to-float v1, v1

    int-to-float v0, v3

    move-object/from16 v19, p1

    move/from16 v20, v14

    move/from16 v21, v15

    move/from16 v22, v1

    move/from16 v23, v0

    invoke-virtual/range {v19 .. v24}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 920
    .end local v4    # "adGroupTimeMs":J
    .end local v12    # "markerPositionOffset":I
    .end local v13    # "markerLeft":I
    .end local v24    # "paint":Landroid/graphics/Paint;
    add-int/lit8 v10, v10, 0x1

    move-object/from16 v0, p0

    move v5, v11

    move/from16 v1, v16

    move/from16 v4, v18

    goto :goto_0

    .line 930
    .end local v10    # "i":I
    .end local v11    # "bufferedRight":I
    .end local v16    # "progressBarHeight":I
    .end local v18    # "bufferedLeft":I
    .restart local v1    # "progressBarHeight":I
    .local v4, "bufferedLeft":I
    .restart local v5    # "bufferedRight":I
    :cond_6
    return-void
.end method

.method private getPositionIncrement()J
    .locals 5

    .line 982
    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->keyTimeIncrement:J

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v4, v0, v2

    if-nez v4, :cond_1

    .line 983
    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const-wide/16 v0, 0x0

    goto :goto_0

    :cond_0
    iget v2, p0, Landroidx/media3/ui/DefaultTimeBar;->keyCountIncrement:I

    int-to-long v2, v2

    div-long/2addr v0, v2

    goto :goto_0

    .line 984
    :cond_1
    nop

    .line 982
    :goto_0
    return-wide v0
.end method

.method private getProgressText()Ljava/lang/String;
    .locals 4

    .line 978
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->formatBuilder:Ljava/lang/StringBuilder;

    iget-object v1, p0, Landroidx/media3/ui/DefaultTimeBar;->formatter:Ljava/util/Formatter;

    iget-wide v2, p0, Landroidx/media3/ui/DefaultTimeBar;->position:J

    invoke-static {v0, v1, v2, v3}, Landroidx/media3/common/util/Util;->getStringForTime(Ljava/lang/StringBuilder;Ljava/util/Formatter;J)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getScrubberPosition()J
    .locals 4

    .line 883
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v0

    if-lez v0, :cond_1

    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    goto :goto_0

    .line 886
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v0

    int-to-long v0, v0

    iget-wide v2, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    mul-long/2addr v0, v2

    iget-object v2, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->width()I

    move-result v2

    int-to-long v2, v2

    div-long/2addr v0, v2

    return-wide v0

    .line 884
    :cond_1
    :goto_0
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method private isInSeekBar(FF)Z
    .locals 3
    .param p1, "x"    # F
    .param p2, "y"    # F

    .line 890
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    float-to-int v1, p1

    float-to-int v2, p2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Rect;->contains(II)Z

    move-result v0

    return v0
.end method

.method private positionScrubber(F)V
    .locals 4
    .param p1, "xPosition"    # F

    .line 874
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    float-to-int v1, p1

    iget-object v2, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->left:I

    iget-object v3, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->right:I

    invoke-static {v1, v2, v3}, Landroidx/media3/common/util/Util;->constrainValue(III)I

    move-result v1

    iput v1, v0, Landroid/graphics/Rect;->right:I

    .line 875
    return-void
.end method

.method private static pxToDp(FI)I
    .locals 1
    .param p0, "density"    # F
    .param p1, "px"    # I

    .line 1000
    int-to-float v0, p1

    div-float/2addr v0, p0

    float-to-int v0, v0

    return v0
.end method

.method private resolveRelativeTouchPosition(Landroid/view/MotionEvent;)Landroid/graphics/Point;
    .locals 3
    .param p1, "motionEvent"    # Landroid/view/MotionEvent;

    .line 878
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->touchPosition:Landroid/graphics/Point;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    float-to-int v2, v2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Point;->set(II)V

    .line 879
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->touchPosition:Landroid/graphics/Point;

    return-object v0
.end method

.method private scrubIncrementally(J)Z
    .locals 9
    .param p1, "positionChange"    # J

    .line 840
    iget-wide v4, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    const-wide/16 v0, 0x0

    cmp-long v0, v4, v0

    const/4 v6, 0x0

    if-gtz v0, :cond_0

    .line 841
    return v6

    .line 843
    :cond_0
    iget-boolean v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubbing:Z

    if-eqz v0, :cond_1

    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubPosition:J

    goto :goto_0

    :cond_1
    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->position:J

    :goto_0
    move-wide v7, v0

    .line 844
    .local v7, "previousPosition":J
    add-long v0, v7, p1

    const-wide/16 v2, 0x0

    invoke-static/range {v0 .. v5}, Landroidx/media3/common/util/Util;->constrainValue(JJJ)J

    move-result-wide v0

    .line 845
    .local v0, "scrubPosition":J
    cmp-long v2, v0, v7

    if-nez v2, :cond_2

    .line 846
    return v6

    .line 848
    :cond_2
    iget-boolean v2, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubbing:Z

    if-nez v2, :cond_3

    .line 849
    invoke-direct {p0, v0, v1}, Landroidx/media3/ui/DefaultTimeBar;->startScrubbing(J)V

    goto :goto_1

    .line 851
    :cond_3
    invoke-direct {p0, v0, v1}, Landroidx/media3/ui/DefaultTimeBar;->updateScrubbing(J)V

    .line 853
    :goto_1
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->update()V

    .line 854
    const/4 v2, 0x1

    return v2
.end method

.method private setDrawableLayoutDirection(Landroid/graphics/drawable/Drawable;)Z
    .locals 2
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .line 988
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_0

    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->getLayoutDirection()I

    move-result v0

    invoke-static {p1, v0}, Landroidx/media3/ui/DefaultTimeBar;->setDrawableLayoutDirection(Landroid/graphics/drawable/Drawable;I)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private static setDrawableLayoutDirection(Landroid/graphics/drawable/Drawable;I)Z
    .locals 2
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p1, "layoutDirection"    # I

    .line 992
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_0

    invoke-virtual {p0, p1}, Landroid/graphics/drawable/Drawable;->setLayoutDirection(I)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private setSystemGestureExclusionRectsV29(II)V
    .locals 2
    .param p1, "width"    # I
    .param p2, "height"    # I

    .line 967
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->lastExclusionRectangle:Landroid/graphics/Rect;

    if-eqz v0, :cond_0

    .line 968
    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v0

    if-ne v0, p1, :cond_0

    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->lastExclusionRectangle:Landroid/graphics/Rect;

    .line 969
    invoke-virtual {v0}, Landroid/graphics/Rect;->height()I

    move-result v0

    if-ne v0, p2, :cond_0

    .line 971
    return-void

    .line 973
    :cond_0
    new-instance v0, Landroid/graphics/Rect;

    const/4 v1, 0x0

    invoke-direct {v0, v1, v1, p1, p2}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->lastExclusionRectangle:Landroid/graphics/Rect;

    .line 974
    invoke-static {v0}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->setSystemGestureExclusionRects(Ljava/util/List;)V

    .line 975
    return-void
.end method

.method private startScrubbing(J)V
    .locals 3
    .param p1, "scrubPosition"    # J

    .line 797
    iput-wide p1, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubPosition:J

    .line 798
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubbing:Z

    .line 799
    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->setPressed(Z)V

    .line 800
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    .line 801
    .local v1, "parent":Landroid/view/ViewParent;
    if-eqz v1, :cond_0

    .line 802
    invoke-interface {v1, v0}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 804
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/ui/TimeBar$OnScrubListener;

    .line 805
    .local v2, "listener":Landroidx/media3/ui/TimeBar$OnScrubListener;
    invoke-interface {v2, p0, p1, p2}, Landroidx/media3/ui/TimeBar$OnScrubListener;->onScrubStart(Landroidx/media3/ui/TimeBar;J)V

    .line 806
    .end local v2    # "listener":Landroidx/media3/ui/TimeBar$OnScrubListener;
    goto :goto_0

    .line 807
    :cond_1
    return-void
.end method

.method private stopScrubbing(Z)V
    .locals 5
    .param p1, "canceled"    # Z

    .line 820
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->stopScrubbingRunnable:Ljava/lang/Runnable;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 821
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubbing:Z

    .line 822
    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->setPressed(Z)V

    .line 823
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    .line 824
    .local v1, "parent":Landroid/view/ViewParent;
    if-eqz v1, :cond_0

    .line 825
    invoke-interface {v1, v0}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 827
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate()V

    .line 828
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/ui/TimeBar$OnScrubListener;

    .line 829
    .local v2, "listener":Landroidx/media3/ui/TimeBar$OnScrubListener;
    iget-wide v3, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubPosition:J

    invoke-interface {v2, p0, v3, v4, p1}, Landroidx/media3/ui/TimeBar$OnScrubListener;->onScrubStop(Landroidx/media3/ui/TimeBar;JZ)V

    .line 830
    .end local v2    # "listener":Landroidx/media3/ui/TimeBar$OnScrubListener;
    goto :goto_0

    .line 831
    :cond_1
    return-void
.end method

.method private update()V
    .locals 7

    .line 858
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->bufferedBar:Landroid/graphics/Rect;

    iget-object v1, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 859
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    iget-object v1, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 860
    iget-boolean v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubbing:Z

    if-eqz v0, :cond_0

    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubPosition:J

    goto :goto_0

    :cond_0
    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->position:J

    .line 861
    .local v0, "newScrubberTime":J
    :goto_0
    iget-wide v2, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-lez v2, :cond_1

    .line 862
    iget-object v2, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->width()I

    move-result v2

    int-to-long v2, v2

    iget-wide v4, p0, Landroidx/media3/ui/DefaultTimeBar;->bufferedPosition:J

    mul-long/2addr v2, v4

    iget-wide v4, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    div-long/2addr v2, v4

    long-to-int v2, v2

    .line 863
    .local v2, "bufferedPixelWidth":I
    iget-object v3, p0, Landroidx/media3/ui/DefaultTimeBar;->bufferedBar:Landroid/graphics/Rect;

    iget-object v4, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->left:I

    add-int/2addr v4, v2

    iget-object v5, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->right:I

    invoke-static {v4, v5}, Ljava/lang/Math;->min(II)I

    move-result v4

    iput v4, v3, Landroid/graphics/Rect;->right:I

    .line 864
    iget-object v3, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v3}, Landroid/graphics/Rect;->width()I

    move-result v3

    int-to-long v3, v3

    mul-long/2addr v3, v0

    iget-wide v5, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    div-long/2addr v3, v5

    long-to-int v3, v3

    .line 865
    .local v3, "scrubberPixelPosition":I
    iget-object v4, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    iget-object v5, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->left:I

    add-int/2addr v5, v3

    iget-object v6, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->right:I

    invoke-static {v5, v6}, Ljava/lang/Math;->min(II)I

    move-result v5

    iput v5, v4, Landroid/graphics/Rect;->right:I

    .line 866
    .end local v2    # "bufferedPixelWidth":I
    .end local v3    # "scrubberPixelPosition":I
    goto :goto_1

    .line 867
    :cond_1
    iget-object v2, p0, Landroidx/media3/ui/DefaultTimeBar;->bufferedBar:Landroid/graphics/Rect;

    iget-object v3, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->left:I

    iput v3, v2, Landroid/graphics/Rect;->right:I

    .line 868
    iget-object v2, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberBar:Landroid/graphics/Rect;

    iget-object v3, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->left:I

    iput v3, v2, Landroid/graphics/Rect;->right:I

    .line 870
    :goto_1
    iget-object v2, p0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    invoke-virtual {p0, v2}, Landroidx/media3/ui/DefaultTimeBar;->invalidate(Landroid/graphics/Rect;)V

    .line 871
    return-void
.end method

.method private updateDrawableState()V
    .locals 2

    .line 958
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 959
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberDrawable:Landroid/graphics/drawable/Drawable;

    .line 960
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->getDrawableState()[I

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 961
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate()V

    .line 963
    :cond_0
    return-void
.end method

.method private updateScrubbing(J)V
    .locals 2
    .param p1, "scrubPosition"    # J

    .line 810
    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubPosition:J

    cmp-long v0, v0, p1

    if-nez v0, :cond_0

    .line 811
    return-void

    .line 813
    :cond_0
    iput-wide p1, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubPosition:J

    .line 814
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/ui/TimeBar$OnScrubListener;

    .line 815
    .local v1, "listener":Landroidx/media3/ui/TimeBar$OnScrubListener;
    invoke-interface {v1, p0, p1, p2}, Landroidx/media3/ui/TimeBar$OnScrubListener;->onScrubMove(Landroidx/media3/ui/TimeBar;J)V

    .line 816
    .end local v1    # "listener":Landroidx/media3/ui/TimeBar$OnScrubListener;
    goto :goto_0

    .line 817
    :cond_1
    return-void
.end method


# virtual methods
.method public addListener(Landroidx/media3/ui/TimeBar$OnScrubListener;)V
    .locals 1
    .param p1, "listener"    # Landroidx/media3/ui/TimeBar$OnScrubListener;

    .line 506
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 507
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z

    .line 508
    return-void
.end method

.method protected drawableStateChanged()V
    .locals 0

    .line 683
    invoke-super {p0}, Landroid/view/View;->drawableStateChanged()V

    .line 684
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->updateDrawableState()V

    .line 685
    return-void
.end method

.method public getPreferredUpdateDelay()J
    .locals 5

    .line 562
    iget v0, p0, Landroidx/media3/ui/DefaultTimeBar;->density:F

    iget-object v1, p0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v1

    invoke-static {v0, v1}, Landroidx/media3/ui/DefaultTimeBar;->pxToDp(FI)I

    move-result v0

    .line 563
    .local v0, "timeBarWidthDp":I
    if-eqz v0, :cond_1

    iget-wide v1, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    const-wide/16 v3, 0x0

    cmp-long v3, v1, v3

    if-eqz v3, :cond_1

    const-wide v3, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v3, v1, v3

    if-nez v3, :cond_0

    goto :goto_0

    .line 565
    :cond_0
    int-to-long v3, v0

    div-long/2addr v1, v3

    goto :goto_1

    .line 564
    :cond_1
    :goto_0
    const-wide v1, 0x7fffffffffffffffL

    .line 563
    :goto_1
    return-wide v1
.end method

.method public hideScrubber(J)V
    .locals 4
    .param p1, "hideAnimationDurationMs"    # J

    .line 430
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 431
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    .line 433
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    const/4 v1, 0x2

    new-array v1, v1, [F

    const/4 v2, 0x0

    iget v3, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScale:F

    aput v3, v1, v2

    const/4 v2, 0x1

    const/4 v3, 0x0

    aput v3, v1, v2

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setFloatValues([F)V

    .line 434
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0, p1, p2}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 435
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->start()V

    .line 436
    return-void
.end method

.method public hideScrubber(Z)V
    .locals 1
    .param p1, "disableScrubberPadding"    # Z

    .line 416
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 417
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    .line 419
    :cond_0
    iput-boolean p1, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberPaddingDisabled:Z

    .line 420
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScale:F

    .line 421
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate(Landroid/graphics/Rect;)V

    .line 422
    return-void
.end method

.method public jumpDrawablesToCurrentState()V
    .locals 1

    .line 689
    invoke-super {p0}, Landroid/view/View;->jumpDrawablesToCurrentState()V

    .line 690
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 691
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->jumpToCurrentState()V

    .line 693
    :cond_0
    return-void
.end method

.method synthetic lambda$new$0$androidx-media3-ui-DefaultTimeBar()V
    .locals 1

    .line 365
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->stopScrubbing(Z)V

    return-void
.end method

.method synthetic lambda$new$1$androidx-media3-ui-DefaultTimeBar(Landroid/animation/ValueAnimator;)V
    .locals 1
    .param p1, "animation"    # Landroid/animation/ValueAnimator;

    .line 377
    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    iput v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScale:F

    .line 378
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate(Landroid/graphics/Rect;)V

    .line 379
    return-void
.end method

.method public onDraw(Landroid/graphics/Canvas;)V
    .locals 0
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .line 591
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 592
    invoke-direct {p0, p1}, Landroidx/media3/ui/DefaultTimeBar;->drawTimeBar(Landroid/graphics/Canvas;)V

    .line 593
    invoke-direct {p0, p1}, Landroidx/media3/ui/DefaultTimeBar;->drawPlayhead(Landroid/graphics/Canvas;)V

    .line 594
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 595
    return-void
.end method

.method protected onFocusChanged(ZILandroid/graphics/Rect;)V
    .locals 1
    .param p1, "gainFocus"    # Z
    .param p2, "direction"    # I
    .param p3, "previouslyFocusedRect"    # Landroid/graphics/Rect;

    .line 675
    invoke-super {p0, p1, p2, p3}, Landroid/view/View;->onFocusChanged(ZILandroid/graphics/Rect;)V

    .line 676
    iget-boolean v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubbing:Z

    if-eqz v0, :cond_0

    if-nez p1, :cond_0

    .line 677
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->stopScrubbing(Z)V

    .line 679
    :cond_0
    return-void
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 2
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .line 747
    invoke-super {p0, p1}, Landroid/view/View;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 748
    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityEvent;->getEventType()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 749
    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityEvent;->getText()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->getProgressText()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 751
    :cond_0
    const-string v0, "android.widget.SeekBar"

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 752
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 4
    .param p1, "info"    # Landroid/view/accessibility/AccessibilityNodeInfo;

    .line 756
    invoke-super {p0, p1}, Landroid/view/View;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 757
    const-string v0, "android.widget.SeekBar"

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    .line 758
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->getProgressText()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 759
    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-gtz v0, :cond_0

    .line 760
    return-void

    .line 762
    :cond_0
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_1

    .line 763
    sget-object v0, Landroid/view/accessibility/AccessibilityNodeInfo$AccessibilityAction;->ACTION_SCROLL_FORWARD:Landroid/view/accessibility/AccessibilityNodeInfo$AccessibilityAction;

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(Landroid/view/accessibility/AccessibilityNodeInfo$AccessibilityAction;)V

    .line 764
    sget-object v0, Landroid/view/accessibility/AccessibilityNodeInfo$AccessibilityAction;->ACTION_SCROLL_BACKWARD:Landroid/view/accessibility/AccessibilityNodeInfo$AccessibilityAction;

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(Landroid/view/accessibility/AccessibilityNodeInfo$AccessibilityAction;)V

    goto :goto_0

    .line 766
    :cond_1
    const/16 v0, 0x1000

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    .line 767
    const/16 v0, 0x2000

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    .line 769
    :goto_0
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 6
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 645
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 646
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->getPositionIncrement()J

    move-result-wide v0

    .line 647
    .local v0, "positionIncrement":J
    const/4 v2, 0x1

    sparse-switch p1, :sswitch_data_0

    goto :goto_0

    .line 660
    :sswitch_0
    iget-boolean v3, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubbing:Z

    if-eqz v3, :cond_0

    .line 661
    const/4 v3, 0x0

    invoke-direct {p0, v3}, Landroidx/media3/ui/DefaultTimeBar;->stopScrubbing(Z)V

    .line 662
    return v2

    .line 649
    :sswitch_1
    neg-long v0, v0

    .line 652
    :sswitch_2
    invoke-direct {p0, v0, v1}, Landroidx/media3/ui/DefaultTimeBar;->scrubIncrementally(J)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 653
    iget-object v3, p0, Landroidx/media3/ui/DefaultTimeBar;->stopScrubbingRunnable:Ljava/lang/Runnable;

    invoke-virtual {p0, v3}, Landroidx/media3/ui/DefaultTimeBar;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 654
    iget-object v3, p0, Landroidx/media3/ui/DefaultTimeBar;->stopScrubbingRunnable:Ljava/lang/Runnable;

    const-wide/16 v4, 0x3e8

    invoke-virtual {p0, v3, v4, v5}, Landroidx/media3/ui/DefaultTimeBar;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 655
    return v2

    .line 669
    .end local v0    # "positionIncrement":J
    :cond_0
    :goto_0
    invoke-super {p0, p1, p2}, Landroid/view/View;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0

    nop

    :sswitch_data_0
    .sparse-switch
        0x15 -> :sswitch_1
        0x16 -> :sswitch_2
        0x17 -> :sswitch_0
        0x42 -> :sswitch_0
    .end sparse-switch
.end method

.method protected onLayout(ZIIII)V
    .locals 12
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .line 711
    move-object v0, p0

    sub-int v1, p4, p2

    .line 712
    .local v1, "width":I
    sub-int v2, p5, p3

    .line 713
    .local v2, "height":I
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->getPaddingLeft()I

    move-result v3

    .line 714
    .local v3, "seekLeft":I
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->getPaddingRight()I

    move-result v4

    sub-int v4, v1, v4

    .line 717
    .local v4, "seekRight":I
    iget-boolean v5, v0, Landroidx/media3/ui/DefaultTimeBar;->scrubberPaddingDisabled:Z

    const/4 v6, 0x0

    if-eqz v5, :cond_0

    move v5, v6

    goto :goto_0

    :cond_0
    iget v5, v0, Landroidx/media3/ui/DefaultTimeBar;->scrubberPadding:I

    .line 718
    .local v5, "scrubberPadding":I
    :goto_0
    iget v7, v0, Landroidx/media3/ui/DefaultTimeBar;->barGravity:I

    const/4 v8, 0x1

    if-ne v7, v8, :cond_1

    .line 719
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->getPaddingBottom()I

    move-result v7

    sub-int v7, v2, v7

    iget v8, v0, Landroidx/media3/ui/DefaultTimeBar;->touchTargetHeight:I

    sub-int/2addr v7, v8

    .line 720
    .local v7, "seekBoundsY":I
    nop

    .line 721
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->getPaddingBottom()I

    move-result v8

    sub-int v8, v2, v8

    iget v9, v0, Landroidx/media3/ui/DefaultTimeBar;->barHeight:I

    sub-int/2addr v8, v9

    div-int/lit8 v9, v9, 0x2

    sub-int v9, v5, v9

    invoke-static {v9, v6}, Ljava/lang/Math;->max(II)I

    move-result v6

    sub-int/2addr v8, v6

    .local v8, "progressBarY":I
    goto :goto_1

    .line 723
    .end local v7    # "seekBoundsY":I
    .end local v8    # "progressBarY":I
    :cond_1
    iget v6, v0, Landroidx/media3/ui/DefaultTimeBar;->touchTargetHeight:I

    sub-int v6, v2, v6

    div-int/lit8 v7, v6, 0x2

    .line 724
    .restart local v7    # "seekBoundsY":I
    iget v6, v0, Landroidx/media3/ui/DefaultTimeBar;->barHeight:I

    sub-int v6, v2, v6

    div-int/lit8 v8, v6, 0x2

    .line 726
    .restart local v8    # "progressBarY":I
    :goto_1
    iget-object v6, v0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    iget v9, v0, Landroidx/media3/ui/DefaultTimeBar;->touchTargetHeight:I

    add-int/2addr v9, v7

    invoke-virtual {v6, v3, v7, v4, v9}, Landroid/graphics/Rect;->set(IIII)V

    .line 727
    iget-object v6, v0, Landroidx/media3/ui/DefaultTimeBar;->progressBar:Landroid/graphics/Rect;

    iget-object v9, v0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->left:I

    add-int/2addr v9, v5

    iget-object v10, v0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->right:I

    sub-int/2addr v10, v5

    iget v11, v0, Landroidx/media3/ui/DefaultTimeBar;->barHeight:I

    add-int/2addr v11, v8

    invoke-virtual {v6, v9, v8, v10, v11}, Landroid/graphics/Rect;->set(IIII)V

    .line 732
    sget v6, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v9, 0x1d

    if-lt v6, v9, :cond_2

    .line 733
    invoke-direct {p0, v1, v2}, Landroidx/media3/ui/DefaultTimeBar;->setSystemGestureExclusionRectsV29(II)V

    .line 735
    :cond_2
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->update()V

    .line 736
    return-void
.end method

.method protected onMeasure(II)V
    .locals 4
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .line 697
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v0

    .line 698
    .local v0, "heightMode":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    .line 700
    .local v1, "heightSize":I
    if-nez v0, :cond_0

    .line 701
    iget v2, p0, Landroidx/media3/ui/DefaultTimeBar;->touchTargetHeight:I

    goto :goto_0

    .line 702
    :cond_0
    const/high16 v2, 0x40000000    # 2.0f

    if-ne v0, v2, :cond_1

    .line 703
    move v2, v1

    goto :goto_0

    .line 704
    :cond_1
    iget v2, p0, Landroidx/media3/ui/DefaultTimeBar;->touchTargetHeight:I

    invoke-static {v2, v1}, Ljava/lang/Math;->min(II)I

    move-result v2

    :goto_0
    nop

    .line 705
    .local v2, "height":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v3

    invoke-virtual {p0, v3, v2}, Landroidx/media3/ui/DefaultTimeBar;->setMeasuredDimension(II)V

    .line 706
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->updateDrawableState()V

    .line 707
    return-void
.end method

.method public onRtlPropertiesChanged(I)V
    .locals 1
    .param p1, "layoutDirection"    # I

    .line 740
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    invoke-static {v0, p1}, Landroidx/media3/ui/DefaultTimeBar;->setDrawableLayoutDirection(Landroid/graphics/drawable/Drawable;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 741
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate()V

    .line 743
    :cond_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 8
    .param p1, "event"    # Landroid/view/MotionEvent;

    .line 599
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->isEnabled()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_4

    iget-wide v2, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    const-wide/16 v4, 0x0

    cmp-long v0, v2, v4

    if-gtz v0, :cond_0

    goto :goto_2

    .line 602
    :cond_0
    invoke-direct {p0, p1}, Landroidx/media3/ui/DefaultTimeBar;->resolveRelativeTouchPosition(Landroid/view/MotionEvent;)Landroid/graphics/Point;

    move-result-object v0

    .line 603
    .local v0, "touchPosition":Landroid/graphics/Point;
    iget v2, v0, Landroid/graphics/Point;->x:I

    .line 604
    .local v2, "x":I
    iget v3, v0, Landroid/graphics/Point;->y:I

    .line 605
    .local v3, "y":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    const/4 v5, 0x1

    packed-switch v4, :pswitch_data_0

    goto :goto_1

    .line 616
    :pswitch_0
    iget-boolean v4, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubbing:Z

    if-eqz v4, :cond_3

    .line 617
    iget v1, p0, Landroidx/media3/ui/DefaultTimeBar;->fineScrubYThreshold:I

    if-ge v3, v1, :cond_1

    .line 618
    iget v1, p0, Landroidx/media3/ui/DefaultTimeBar;->lastCoarseScrubXPosition:I

    sub-int v4, v2, v1

    .line 619
    .local v4, "relativeX":I
    div-int/lit8 v6, v4, 0x3

    add-int/2addr v1, v6

    int-to-float v1, v1

    invoke-direct {p0, v1}, Landroidx/media3/ui/DefaultTimeBar;->positionScrubber(F)V

    .line 620
    .end local v4    # "relativeX":I
    goto :goto_0

    .line 621
    :cond_1
    iput v2, p0, Landroidx/media3/ui/DefaultTimeBar;->lastCoarseScrubXPosition:I

    .line 622
    int-to-float v1, v2

    invoke-direct {p0, v1}, Landroidx/media3/ui/DefaultTimeBar;->positionScrubber(F)V

    .line 624
    :goto_0
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->getScrubberPosition()J

    move-result-wide v6

    invoke-direct {p0, v6, v7}, Landroidx/media3/ui/DefaultTimeBar;->updateScrubbing(J)V

    .line 625
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->update()V

    .line 626
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate()V

    .line 627
    return v5

    .line 632
    :pswitch_1
    iget-boolean v4, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubbing:Z

    if-eqz v4, :cond_3

    .line 633
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    const/4 v6, 0x3

    if-ne v4, v6, :cond_2

    move v1, v5

    :cond_2
    invoke-direct {p0, v1}, Landroidx/media3/ui/DefaultTimeBar;->stopScrubbing(Z)V

    .line 634
    return v5

    .line 607
    :pswitch_2
    int-to-float v4, v2

    int-to-float v6, v3

    invoke-direct {p0, v4, v6}, Landroidx/media3/ui/DefaultTimeBar;->isInSeekBar(FF)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 608
    int-to-float v1, v2

    invoke-direct {p0, v1}, Landroidx/media3/ui/DefaultTimeBar;->positionScrubber(F)V

    .line 609
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->getScrubberPosition()J

    move-result-wide v6

    invoke-direct {p0, v6, v7}, Landroidx/media3/ui/DefaultTimeBar;->startScrubbing(J)V

    .line 610
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->update()V

    .line 611
    invoke-virtual {p0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate()V

    .line 612
    return v5

    .line 640
    :cond_3
    :goto_1
    return v1

    .line 600
    .end local v0    # "touchPosition":Landroid/graphics/Point;
    .end local v2    # "x":I
    .end local v3    # "y":I
    :cond_4
    :goto_2
    return v1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public performAccessibilityAction(ILandroid/os/Bundle;)Z
    .locals 6
    .param p1, "action"    # I
    .param p2, "args"    # Landroid/os/Bundle;

    .line 773
    invoke-super {p0, p1, p2}, Landroid/view/View;->performAccessibilityAction(ILandroid/os/Bundle;)Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 774
    return v1

    .line 776
    :cond_0
    iget-wide v2, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    const-wide/16 v4, 0x0

    cmp-long v0, v2, v4

    const/4 v2, 0x0

    if-gtz v0, :cond_1

    .line 777
    return v2

    .line 779
    :cond_1
    const/16 v0, 0x2000

    if-ne p1, v0, :cond_2

    .line 780
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->getPositionIncrement()J

    move-result-wide v3

    neg-long v3, v3

    invoke-direct {p0, v3, v4}, Landroidx/media3/ui/DefaultTimeBar;->scrubIncrementally(J)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 781
    invoke-direct {p0, v2}, Landroidx/media3/ui/DefaultTimeBar;->stopScrubbing(Z)V

    goto :goto_0

    .line 783
    :cond_2
    const/16 v0, 0x1000

    if-ne p1, v0, :cond_4

    .line 784
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->getPositionIncrement()J

    move-result-wide v3

    invoke-direct {p0, v3, v4}, Landroidx/media3/ui/DefaultTimeBar;->scrubIncrementally(J)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 785
    invoke-direct {p0, v2}, Landroidx/media3/ui/DefaultTimeBar;->stopScrubbing(Z)V

    .line 790
    :cond_3
    :goto_0
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->sendAccessibilityEvent(I)V

    .line 791
    return v1

    .line 788
    :cond_4
    return v2
.end method

.method public removeListener(Landroidx/media3/ui/TimeBar$OnScrubListener;)V
    .locals 1
    .param p1, "listener"    # Landroidx/media3/ui/TimeBar$OnScrubListener;

    .line 512
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z

    .line 513
    return-void
.end method

.method public setAdGroupTimesMs([J[ZI)V
    .locals 1
    .param p1, "adGroupTimesMs"    # [J
    .param p2, "playedAdGroups"    # [Z
    .param p3, "adGroupCount"    # I

    .line 571
    if-eqz p3, :cond_1

    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 573
    iput p3, p0, Landroidx/media3/ui/DefaultTimeBar;->adGroupCount:I

    .line 574
    iput-object p1, p0, Landroidx/media3/ui/DefaultTimeBar;->adGroupTimesMs:[J

    .line 575
    iput-object p2, p0, Landroidx/media3/ui/DefaultTimeBar;->playedAdGroups:[Z

    .line 576
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->update()V

    .line 577
    return-void
.end method

.method public setAdMarkerColor(I)V
    .locals 1
    .param p1, "adMarkerColor"    # I

    .line 488
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->adMarkerPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 489
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate(Landroid/graphics/Rect;)V

    .line 490
    return-void
.end method

.method public setBufferedColor(I)V
    .locals 1
    .param p1, "bufferedColor"    # I

    .line 467
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->bufferedPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 468
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate(Landroid/graphics/Rect;)V

    .line 469
    return-void
.end method

.method public setBufferedPosition(J)V
    .locals 2
    .param p1, "bufferedPosition"    # J

    .line 541
    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->bufferedPosition:J

    cmp-long v0, v0, p1

    if-nez v0, :cond_0

    .line 542
    return-void

    .line 544
    :cond_0
    iput-wide p1, p0, Landroidx/media3/ui/DefaultTimeBar;->bufferedPosition:J

    .line 545
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->update()V

    .line 546
    return-void
.end method

.method public setDuration(J)V
    .locals 2
    .param p1, "duration"    # J

    .line 550
    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    cmp-long v0, v0, p1

    if-nez v0, :cond_0

    .line 551
    return-void

    .line 553
    :cond_0
    iput-wide p1, p0, Landroidx/media3/ui/DefaultTimeBar;->duration:J

    .line 554
    iget-boolean v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubbing:Z

    if-eqz v0, :cond_1

    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, p1, v0

    if-nez v0, :cond_1

    .line 555
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->stopScrubbing(Z)V

    .line 557
    :cond_1
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->update()V

    .line 558
    return-void
.end method

.method public setEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .line 583
    invoke-super {p0, p1}, Landroid/view/View;->setEnabled(Z)V

    .line 584
    iget-boolean v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubbing:Z

    if-eqz v0, :cond_0

    if-nez p1, :cond_0

    .line 585
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->stopScrubbing(Z)V

    .line 587
    :cond_0
    return-void
.end method

.method public setKeyCountIncrement(I)V
    .locals 2
    .param p1, "count"    # I

    .line 524
    if-lez p1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 525
    iput p1, p0, Landroidx/media3/ui/DefaultTimeBar;->keyCountIncrement:I

    .line 526
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->keyTimeIncrement:J

    .line 527
    return-void
.end method

.method public setKeyTimeIncrement(J)V
    .locals 2
    .param p1, "time"    # J

    .line 517
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 518
    const/4 v0, -0x1

    iput v0, p0, Landroidx/media3/ui/DefaultTimeBar;->keyCountIncrement:I

    .line 519
    iput-wide p1, p0, Landroidx/media3/ui/DefaultTimeBar;->keyTimeIncrement:J

    .line 520
    return-void
.end method

.method public setPlayedAdMarkerColor(I)V
    .locals 1
    .param p1, "playedAdMarkerColor"    # I

    .line 498
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->playedAdMarkerPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 499
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate(Landroid/graphics/Rect;)V

    .line 500
    return-void
.end method

.method public setPlayedColor(I)V
    .locals 1
    .param p1, "playedColor"    # I

    .line 445
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->playedPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 446
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate(Landroid/graphics/Rect;)V

    .line 447
    return-void
.end method

.method public setPosition(J)V
    .locals 2
    .param p1, "position"    # J

    .line 531
    iget-wide v0, p0, Landroidx/media3/ui/DefaultTimeBar;->position:J

    cmp-long v0, v0, p1

    if-nez v0, :cond_0

    .line 532
    return-void

    .line 534
    :cond_0
    iput-wide p1, p0, Landroidx/media3/ui/DefaultTimeBar;->position:J

    .line 535
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->getProgressText()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 536
    invoke-direct {p0}, Landroidx/media3/ui/DefaultTimeBar;->update()V

    .line 537
    return-void
.end method

.method public setScrubberColor(I)V
    .locals 1
    .param p1, "scrubberColor"    # I

    .line 455
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 456
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate(Landroid/graphics/Rect;)V

    .line 457
    return-void
.end method

.method public setUnplayedColor(I)V
    .locals 1
    .param p1, "unplayedColor"    # I

    .line 478
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->unplayedPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 479
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate(Landroid/graphics/Rect;)V

    .line 480
    return-void
.end method

.method public showScrubber()V
    .locals 1

    .line 391
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 392
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    .line 394
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberPaddingDisabled:Z

    .line 395
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScale:F

    .line 396
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->seekBounds:Landroid/graphics/Rect;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/DefaultTimeBar;->invalidate(Landroid/graphics/Rect;)V

    .line 397
    return-void
.end method

.method public showScrubber(J)V
    .locals 4
    .param p1, "showAnimationDurationMs"    # J

    .line 405
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 406
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    .line 408
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberPaddingDisabled:Z

    .line 409
    iget-object v1, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    const/4 v2, 0x2

    new-array v2, v2, [F

    iget v3, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScale:F

    aput v3, v2, v0

    const/4 v0, 0x1

    const/high16 v3, 0x3f800000    # 1.0f

    aput v3, v2, v0

    invoke-virtual {v1, v2}, Landroid/animation/ValueAnimator;->setFloatValues([F)V

    .line 410
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0, p1, p2}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 411
    iget-object v0, p0, Landroidx/media3/ui/DefaultTimeBar;->scrubberScalingAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->start()V

    .line 412
    return-void
.end method
