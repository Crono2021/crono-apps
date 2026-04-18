.class public Landroidx/media3/ui/PlayerView;
.super Landroid/widget/FrameLayout;
.source "PlayerView.java"

# interfaces
.implements Landroidx/media3/common/AdViewProvider;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/ui/PlayerView$FullscreenButtonClickListener;,
        Landroidx/media3/ui/PlayerView$ControllerVisibilityListener;,
        Landroidx/media3/ui/PlayerView$ComponentListener;,
        Landroidx/media3/ui/PlayerView$Api34;,
        Landroidx/media3/ui/PlayerView$ShowBuffering;,
        Landroidx/media3/ui/PlayerView$ArtworkDisplayMode;
    }
.end annotation


# static fields
.field public static final ARTWORK_DISPLAY_MODE_FILL:I = 0x2

.field public static final ARTWORK_DISPLAY_MODE_FIT:I = 0x1

.field public static final ARTWORK_DISPLAY_MODE_OFF:I = 0x0

.field public static final SHOW_BUFFERING_ALWAYS:I = 0x2

.field public static final SHOW_BUFFERING_NEVER:I = 0x0

.field public static final SHOW_BUFFERING_WHEN_PLAYING:I = 0x1

.field private static final SURFACE_TYPE_NONE:I = 0x0

.field private static final SURFACE_TYPE_SPHERICAL_GL_SURFACE_VIEW:I = 0x3

.field private static final SURFACE_TYPE_SURFACE_VIEW:I = 0x1

.field private static final SURFACE_TYPE_TEXTURE_VIEW:I = 0x2

.field private static final SURFACE_TYPE_VIDEO_DECODER_GL_SURFACE_VIEW:I = 0x4


# instance fields
.field private final adOverlayFrameLayout:Landroid/widget/FrameLayout;

.field private artworkDisplayMode:I

.field private final artworkView:Landroid/widget/ImageView;

.field private final bufferingView:Landroid/view/View;

.field private final componentListener:Landroidx/media3/ui/PlayerView$ComponentListener;

.field private final contentFrame:Landroidx/media3/ui/AspectRatioFrameLayout;

.field private final controller:Landroidx/media3/ui/PlayerControlView;

.field private controllerAutoShow:Z

.field private controllerHideDuringAds:Z

.field private controllerHideOnTouch:Z

.field private controllerShowTimeoutMs:I

.field private controllerVisibilityListener:Landroidx/media3/ui/PlayerView$ControllerVisibilityListener;

.field private customErrorMessage:Ljava/lang/CharSequence;

.field private defaultArtwork:Landroid/graphics/drawable/Drawable;

.field private errorMessageProvider:Landroidx/media3/common/ErrorMessageProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/media3/common/ErrorMessageProvider<",
            "-",
            "Landroidx/media3/common/PlaybackException;",
            ">;"
        }
    .end annotation
.end field

.field private final errorMessageView:Landroid/widget/TextView;

.field private fullscreenButtonClickListener:Landroidx/media3/ui/PlayerView$FullscreenButtonClickListener;

.field private isTouching:Z

.field private keepContentOnPlayerReset:Z

.field private legacyControllerVisibilityListener:Landroidx/media3/ui/PlayerControlView$VisibilityListener;

.field private final overlayFrameLayout:Landroid/widget/FrameLayout;

.field private player:Landroidx/media3/common/Player;

.field private showBuffering:I

.field private final shutterView:Landroid/view/View;

.field private final subtitleView:Landroidx/media3/ui/SubtitleView;

.field private final surfaceView:Landroid/view/View;

.field private final surfaceViewIgnoresVideoAspectRatio:Z

.field private textureViewRotation:I

.field private useController:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 302
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroidx/media3/ui/PlayerView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 303
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 306
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroidx/media3/ui/PlayerView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 307
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 26
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .line 312
    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    invoke-direct/range {p0 .. p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 314
    new-instance v0, Landroidx/media3/ui/PlayerView$ComponentListener;

    invoke-direct {v0, v1}, Landroidx/media3/ui/PlayerView$ComponentListener;-><init>(Landroidx/media3/ui/PlayerView;)V

    iput-object v0, v1, Landroidx/media3/ui/PlayerView;->componentListener:Landroidx/media3/ui/PlayerView$ComponentListener;

    .line 316
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/ui/PlayerView;->isInEditMode()Z

    move-result v4

    const/4 v5, 0x0

    const/4 v6, 0x0

    if-eqz v4, :cond_1

    .line 317
    iput-object v6, v1, Landroidx/media3/ui/PlayerView;->contentFrame:Landroidx/media3/ui/AspectRatioFrameLayout;

    .line 318
    iput-object v6, v1, Landroidx/media3/ui/PlayerView;->shutterView:Landroid/view/View;

    .line 319
    iput-object v6, v1, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    .line 320
    iput-boolean v5, v1, Landroidx/media3/ui/PlayerView;->surfaceViewIgnoresVideoAspectRatio:Z

    .line 321
    iput-object v6, v1, Landroidx/media3/ui/PlayerView;->artworkView:Landroid/widget/ImageView;

    .line 322
    iput-object v6, v1, Landroidx/media3/ui/PlayerView;->subtitleView:Landroidx/media3/ui/SubtitleView;

    .line 323
    iput-object v6, v1, Landroidx/media3/ui/PlayerView;->bufferingView:Landroid/view/View;

    .line 324
    iput-object v6, v1, Landroidx/media3/ui/PlayerView;->errorMessageView:Landroid/widget/TextView;

    .line 325
    iput-object v6, v1, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    .line 326
    iput-object v6, v1, Landroidx/media3/ui/PlayerView;->adOverlayFrameLayout:Landroid/widget/FrameLayout;

    .line 327
    iput-object v6, v1, Landroidx/media3/ui/PlayerView;->overlayFrameLayout:Landroid/widget/FrameLayout;

    .line 328
    new-instance v0, Landroid/widget/ImageView;

    invoke-direct {v0, v2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 329
    .local v0, "logo":Landroid/widget/ImageView;
    sget v4, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v5, 0x17

    if-lt v4, v5, :cond_0

    .line 330
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/ui/PlayerView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-static {v2, v4, v0}, Landroidx/media3/ui/PlayerView;->configureEditModeLogoV23(Landroid/content/Context;Landroid/content/res/Resources;Landroid/widget/ImageView;)V

    goto :goto_0

    .line 332
    :cond_0
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/ui/PlayerView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-static {v2, v4, v0}, Landroidx/media3/ui/PlayerView;->configureEditModeLogo(Landroid/content/Context;Landroid/content/res/Resources;Landroid/widget/ImageView;)V

    .line 334
    :goto_0
    invoke-virtual {v1, v0}, Landroidx/media3/ui/PlayerView;->addView(Landroid/view/View;)V

    .line 335
    return-void

    .line 338
    .end local v0    # "logo":Landroid/widget/ImageView;
    :cond_1
    const/4 v4, 0x0

    .line 339
    .local v4, "shutterColorSet":Z
    const/4 v7, 0x0

    .line 340
    .local v7, "shutterColor":I
    sget v8, Landroidx/media3/ui/R$layout;->exo_player_view:I

    .line 341
    .local v8, "playerLayoutId":I
    const/4 v9, 0x1

    .line 342
    .local v9, "useArtwork":Z
    const/4 v10, 0x1

    .line 343
    .local v10, "artworkDisplayMode":I
    const/4 v11, 0x0

    .line 344
    .local v11, "defaultArtworkId":I
    const/4 v12, 0x1

    .line 345
    .local v12, "useController":Z
    const/4 v13, 0x1

    .line 346
    .local v13, "surfaceType":I
    const/4 v14, 0x0

    .line 347
    .local v14, "resizeMode":I
    const/16 v15, 0x1388

    .line 348
    .local v15, "controllerShowTimeoutMs":I
    const/4 v6, 0x1

    .line 349
    .local v6, "controllerHideOnTouch":Z
    const/4 v5, 0x1

    .line 350
    .local v5, "controllerAutoShow":Z
    move/from16 v17, v4

    .end local v4    # "shutterColorSet":Z
    .local v17, "shutterColorSet":Z
    const/4 v4, 0x1

    .line 351
    .local v4, "controllerHideDuringAds":Z
    const/4 v2, 0x0

    .line 352
    .local v2, "showBuffering":I
    if-eqz v3, :cond_2

    .line 353
    nop

    .line 355
    move-object/from16 v18, v0

    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    move/from16 v19, v4

    .end local v4    # "controllerHideDuringAds":Z
    .local v19, "controllerHideDuringAds":Z
    sget-object v4, Landroidx/media3/ui/R$styleable;->PlayerView:[I

    .line 356
    move/from16 v1, p3

    move/from16 v20, v2

    const/4 v2, 0x0

    .end local v2    # "showBuffering":I
    .local v20, "showBuffering":I
    invoke-virtual {v0, v3, v4, v1, v2}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v4

    .line 359
    .local v4, "a":Landroid/content/res/TypedArray;
    :try_start_0
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_shutter_background_color:I

    invoke-virtual {v4, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_5

    move v2, v0

    .line 360
    .end local v17    # "shutterColorSet":Z
    .local v2, "shutterColorSet":Z
    :try_start_1
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_shutter_background_color:I

    invoke-virtual {v4, v0, v7}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v0

    move v7, v0

    .line 361
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_player_layout_id:I

    invoke-virtual {v4, v0, v8}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v0

    move v8, v0

    .line 362
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_use_artwork:I

    invoke-virtual {v4, v0, v9}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    move v9, v0

    .line 363
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_artwork_display_mode:I

    .line 364
    invoke-virtual {v4, v0, v10}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    move v10, v0

    .line 365
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_default_artwork:I

    .line 366
    invoke-virtual {v4, v0, v11}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v0

    move v11, v0

    .line 367
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_use_controller:I

    invoke-virtual {v4, v0, v12}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    move v12, v0

    .line 368
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_surface_type:I

    invoke-virtual {v4, v0, v13}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    move v13, v0

    .line 369
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_resize_mode:I

    invoke-virtual {v4, v0, v14}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    move v14, v0

    .line 370
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_show_timeout:I

    .line 371
    invoke-virtual {v4, v0, v15}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    move v15, v0

    .line 372
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_hide_on_touch:I

    .line 373
    invoke-virtual {v4, v0, v6}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    move v6, v0

    .line 374
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_auto_show:I

    invoke-virtual {v4, v0, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    move v5, v0

    .line 375
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_show_buffering:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_4

    move/from16 v1, v20

    .end local v20    # "showBuffering":I
    .local v1, "showBuffering":I
    :try_start_2
    invoke-virtual {v4, v0, v1}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_3

    move v1, v0

    .line 376
    :try_start_3
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_keep_content_on_player_reset:I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    move/from16 v17, v1

    move/from16 v20, v2

    move-object/from16 v1, p0

    .end local v1    # "showBuffering":I
    .end local v2    # "shutterColorSet":Z
    .local v17, "showBuffering":I
    .local v20, "shutterColorSet":Z
    :try_start_4
    iget-boolean v2, v1, Landroidx/media3/ui/PlayerView;->keepContentOnPlayerReset:Z

    .line 377
    invoke-virtual {v4, v0, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    iput-boolean v0, v1, Landroidx/media3/ui/PlayerView;->keepContentOnPlayerReset:Z

    .line 379
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerView_hide_during_ads:I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 380
    move/from16 v2, v19

    .end local v19    # "controllerHideDuringAds":Z
    .local v2, "controllerHideDuringAds":Z
    :try_start_5
    invoke-virtual {v4, v0, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 382
    .end local v2    # "controllerHideDuringAds":Z
    .local v0, "controllerHideDuringAds":Z
    invoke-virtual {v4}, Landroid/content/res/TypedArray;->recycle()V

    .line 383
    move/from16 v2, v17

    move/from16 v4, v20

    move/from16 v17, v15

    move v15, v14

    move v14, v13

    move v13, v12

    move v12, v11

    move v11, v10

    move v10, v9

    move v9, v8

    move v8, v7

    move v7, v6

    move v6, v5

    move v5, v0

    goto/16 :goto_2

    .line 382
    .end local v0    # "controllerHideDuringAds":Z
    .restart local v2    # "controllerHideDuringAds":Z
    :catchall_0
    move-exception v0

    move/from16 v19, v17

    goto :goto_1

    .end local v2    # "controllerHideDuringAds":Z
    .restart local v19    # "controllerHideDuringAds":Z
    :catchall_1
    move-exception v0

    move/from16 v2, v19

    move/from16 v19, v17

    .end local v19    # "controllerHideDuringAds":Z
    .restart local v2    # "controllerHideDuringAds":Z
    goto :goto_1

    .end local v17    # "showBuffering":I
    .end local v20    # "shutterColorSet":Z
    .restart local v1    # "showBuffering":I
    .local v2, "shutterColorSet":Z
    .restart local v19    # "controllerHideDuringAds":Z
    :catchall_2
    move-exception v0

    move/from16 v17, v1

    move/from16 v20, v2

    move/from16 v2, v19

    move-object/from16 v1, p0

    move/from16 v19, v17

    .end local v1    # "showBuffering":I
    .end local v19    # "controllerHideDuringAds":Z
    .local v2, "controllerHideDuringAds":Z
    .restart local v17    # "showBuffering":I
    .restart local v20    # "shutterColorSet":Z
    goto :goto_1

    .end local v17    # "showBuffering":I
    .end local v20    # "shutterColorSet":Z
    .restart local v1    # "showBuffering":I
    .local v2, "shutterColorSet":Z
    .restart local v19    # "controllerHideDuringAds":Z
    :catchall_3
    move-exception v0

    move/from16 v20, v2

    move/from16 v2, v19

    move/from16 v19, v1

    move-object/from16 v1, p0

    .end local v1    # "showBuffering":I
    .local v2, "controllerHideDuringAds":Z
    .local v19, "showBuffering":I
    .restart local v20    # "shutterColorSet":Z
    goto :goto_1

    .local v2, "shutterColorSet":Z
    .local v19, "controllerHideDuringAds":Z
    .local v20, "showBuffering":I
    :catchall_4
    move-exception v0

    move-object/from16 v1, p0

    move/from16 v25, v20

    move/from16 v20, v2

    move/from16 v2, v19

    move/from16 v19, v25

    .local v2, "controllerHideDuringAds":Z
    .local v19, "showBuffering":I
    .local v20, "shutterColorSet":Z
    goto :goto_1

    .end local v2    # "controllerHideDuringAds":Z
    .local v17, "shutterColorSet":Z
    .local v19, "controllerHideDuringAds":Z
    .local v20, "showBuffering":I
    :catchall_5
    move-exception v0

    move-object/from16 v1, p0

    move/from16 v2, v19

    move/from16 v19, v20

    move/from16 v20, v17

    .end local v17    # "shutterColorSet":Z
    .restart local v2    # "controllerHideDuringAds":Z
    .local v19, "showBuffering":I
    .local v20, "shutterColorSet":Z
    :goto_1
    invoke-virtual {v4}, Landroid/content/res/TypedArray;->recycle()V

    .line 383
    throw v0

    .line 352
    .end local v19    # "showBuffering":I
    .end local v20    # "shutterColorSet":Z
    .local v2, "showBuffering":I
    .local v4, "controllerHideDuringAds":Z
    .restart local v17    # "shutterColorSet":Z
    :cond_2
    move-object/from16 v18, v0

    move/from16 v19, v2

    move v2, v4

    .end local v4    # "controllerHideDuringAds":Z
    .local v2, "controllerHideDuringAds":Z
    .restart local v19    # "showBuffering":I
    move/from16 v4, v17

    move/from16 v17, v15

    move v15, v14

    move v14, v13

    move v13, v12

    move v12, v11

    move v11, v10

    move v10, v9

    move v9, v8

    move v8, v7

    move v7, v6

    move v6, v5

    move v5, v2

    move/from16 v2, v19

    .line 386
    .end local v19    # "showBuffering":I
    .local v2, "showBuffering":I
    .local v4, "shutterColorSet":Z
    .local v5, "controllerHideDuringAds":Z
    .local v6, "controllerAutoShow":Z
    .local v7, "controllerHideOnTouch":Z
    .local v8, "shutterColor":I
    .local v9, "playerLayoutId":I
    .local v10, "useArtwork":Z
    .local v11, "artworkDisplayMode":I
    .local v12, "defaultArtworkId":I
    .local v13, "useController":Z
    .local v14, "surfaceType":I
    .local v15, "resizeMode":I
    .local v17, "controllerShowTimeoutMs":I
    :goto_2
    invoke-static/range {p1 .. p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    invoke-virtual {v0, v9, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 387
    const/high16 v0, 0x40000

    invoke-virtual {v1, v0}, Landroidx/media3/ui/PlayerView;->setDescendantFocusability(I)V

    .line 390
    sget v0, Landroidx/media3/ui/R$id;->exo_content_frame:I

    invoke-virtual {v1, v0}, Landroidx/media3/ui/PlayerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/media3/ui/AspectRatioFrameLayout;

    iput-object v0, v1, Landroidx/media3/ui/PlayerView;->contentFrame:Landroidx/media3/ui/AspectRatioFrameLayout;

    .line 391
    if-eqz v0, :cond_3

    .line 392
    invoke-static {v0, v15}, Landroidx/media3/ui/PlayerView;->setResizeModeRaw(Landroidx/media3/ui/AspectRatioFrameLayout;I)V

    .line 396
    :cond_3
    move/from16 v19, v9

    .end local v9    # "playerLayoutId":I
    .local v19, "playerLayoutId":I
    sget v9, Landroidx/media3/ui/R$id;->exo_shutter:I

    invoke-virtual {v1, v9}, Landroidx/media3/ui/PlayerView;->findViewById(I)Landroid/view/View;

    move-result-object v9

    iput-object v9, v1, Landroidx/media3/ui/PlayerView;->shutterView:Landroid/view/View;

    .line 397
    if-eqz v9, :cond_4

    if-eqz v4, :cond_4

    .line 398
    invoke-virtual {v9, v8}, Landroid/view/View;->setBackgroundColor(I)V

    .line 402
    :cond_4
    const/4 v9, 0x0

    .line 403
    .local v9, "surfaceViewIgnoresVideoAspectRatio":Z
    move/from16 v20, v4

    .end local v4    # "shutterColorSet":Z
    .restart local v20    # "shutterColorSet":Z
    if-eqz v0, :cond_6

    if-eqz v14, :cond_6

    .line 404
    new-instance v4, Landroid/view/ViewGroup$LayoutParams;

    move/from16 v21, v8

    .end local v8    # "shutterColor":I
    .local v21, "shutterColor":I
    const/4 v8, -0x1

    invoke-direct {v4, v8, v8}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    .line 407
    .local v4, "params":Landroid/view/ViewGroup$LayoutParams;
    packed-switch v14, :pswitch_data_0

    .line 433
    move/from16 v22, v9

    move/from16 v23, v14

    move-object/from16 v9, p1

    .end local v9    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v14    # "surfaceType":I
    .local v22, "surfaceViewIgnoresVideoAspectRatio":Z
    .local v23, "surfaceType":I
    new-instance v8, Landroid/view/SurfaceView;

    invoke-direct {v8, v9}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;)V

    .line 434
    .local v8, "view":Landroid/view/SurfaceView;
    sget v14, Landroidx/media3/common/util/Util;->SDK_INT:I

    move/from16 v24, v15

    .end local v15    # "resizeMode":I
    .local v24, "resizeMode":I
    const/16 v15, 0x22

    if-lt v14, v15, :cond_5

    .line 435
    invoke-static {v8}, Landroidx/media3/ui/PlayerView$Api34;->setSurfaceLifecycleToFollowsAttachment(Landroid/view/SurfaceView;)V

    goto/16 :goto_4

    .line 424
    .end local v8    # "view":Landroid/view/SurfaceView;
    .end local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v23    # "surfaceType":I
    .end local v24    # "resizeMode":I
    .restart local v9    # "surfaceViewIgnoresVideoAspectRatio":Z
    .restart local v14    # "surfaceType":I
    .restart local v15    # "resizeMode":I
    :pswitch_0
    :try_start_6
    const-string v8, "androidx.media3.exoplayer.video.VideoDecoderGLSurfaceView"

    .line 425
    invoke-static {v8}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v8
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1

    .line 426
    .local v8, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    move/from16 v22, v9

    move/from16 v23, v14

    const/4 v9, 0x1

    .end local v9    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v14    # "surfaceType":I
    .restart local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    .restart local v23    # "surfaceType":I
    :try_start_7
    new-array v14, v9, [Ljava/lang/Class;

    const-class v9, Landroid/content/Context;

    const/16 v16, 0x0

    aput-object v9, v14, v16

    invoke-virtual {v8, v14}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v9

    filled-new-array/range {p1 .. p1}, [Ljava/lang/Object;

    move-result-object v14

    invoke-virtual {v9, v14}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/view/View;

    iput-object v9, v1, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_0

    .line 430
    .end local v8    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    move-object/from16 v9, p1

    move/from16 v24, v15

    goto :goto_5

    .line 427
    :catch_0
    move-exception v0

    goto :goto_3

    .end local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v23    # "surfaceType":I
    .restart local v9    # "surfaceViewIgnoresVideoAspectRatio":Z
    .restart local v14    # "surfaceType":I
    :catch_1
    move-exception v0

    move/from16 v22, v9

    move/from16 v23, v14

    .line 428
    .end local v9    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v14    # "surfaceType":I
    .local v0, "e":Ljava/lang/Exception;
    .restart local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    .restart local v23    # "surfaceType":I
    :goto_3
    new-instance v8, Ljava/lang/IllegalStateException;

    const-string v9, "video_decoder_gl_surface_view requires an ExoPlayer dependency"

    invoke-direct {v8, v9, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v8

    .line 413
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v23    # "surfaceType":I
    .restart local v9    # "surfaceViewIgnoresVideoAspectRatio":Z
    .restart local v14    # "surfaceType":I
    :pswitch_1
    move/from16 v22, v9

    move/from16 v23, v14

    .end local v9    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v14    # "surfaceType":I
    .restart local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    .restart local v23    # "surfaceType":I
    :try_start_8
    const-string v8, "androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView"

    .line 414
    invoke-static {v8}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v8

    .line 415
    .restart local v8    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v9, 0x1

    new-array v14, v9, [Ljava/lang/Class;

    const-class v9, Landroid/content/Context;

    const/16 v16, 0x0

    aput-object v9, v14, v16

    invoke-virtual {v8, v14}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v9

    filled-new-array/range {p1 .. p1}, [Ljava/lang/Object;

    move-result-object v14

    invoke-virtual {v9, v14}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/view/View;

    iput-object v9, v1, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_2

    .line 419
    .end local v8    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    nop

    .line 420
    const/4 v8, 0x1

    .line 421
    .end local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    .local v8, "surfaceViewIgnoresVideoAspectRatio":Z
    move-object/from16 v9, p1

    move/from16 v22, v8

    move/from16 v24, v15

    goto :goto_5

    .line 416
    .end local v8    # "surfaceViewIgnoresVideoAspectRatio":Z
    .restart local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    :catch_2
    move-exception v0

    .line 417
    .restart local v0    # "e":Ljava/lang/Exception;
    new-instance v8, Ljava/lang/IllegalStateException;

    const-string v9, "spherical_gl_surface_view requires an ExoPlayer dependency"

    invoke-direct {v8, v9, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v8

    .line 409
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v23    # "surfaceType":I
    .restart local v9    # "surfaceViewIgnoresVideoAspectRatio":Z
    .restart local v14    # "surfaceType":I
    :pswitch_2
    move/from16 v22, v9

    move/from16 v23, v14

    .end local v9    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v14    # "surfaceType":I
    .restart local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    .restart local v23    # "surfaceType":I
    new-instance v8, Landroid/view/TextureView;

    move-object/from16 v9, p1

    invoke-direct {v8, v9}, Landroid/view/TextureView;-><init>(Landroid/content/Context;)V

    iput-object v8, v1, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    .line 410
    move/from16 v24, v15

    goto :goto_5

    .line 437
    .end local v15    # "resizeMode":I
    .local v8, "view":Landroid/view/SurfaceView;
    .restart local v24    # "resizeMode":I
    :cond_5
    :goto_4
    iput-object v8, v1, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    .line 440
    .end local v8    # "view":Landroid/view/SurfaceView;
    :goto_5
    iget-object v8, v1, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    invoke-virtual {v8, v4}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 444
    iget-object v8, v1, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    move-object/from16 v14, v18

    invoke-virtual {v8, v14}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 445
    iget-object v8, v1, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    const/4 v15, 0x0

    invoke-virtual {v8, v15}, Landroid/view/View;->setClickable(Z)V

    .line 446
    iget-object v8, v1, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    invoke-virtual {v0, v8, v15}, Landroidx/media3/ui/AspectRatioFrameLayout;->addView(Landroid/view/View;I)V

    .line 447
    .end local v4    # "params":Landroid/view/ViewGroup$LayoutParams;
    move/from16 v0, v22

    goto :goto_6

    .line 403
    .end local v21    # "shutterColor":I
    .end local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v23    # "surfaceType":I
    .end local v24    # "resizeMode":I
    .local v8, "shutterColor":I
    .restart local v9    # "surfaceViewIgnoresVideoAspectRatio":Z
    .restart local v14    # "surfaceType":I
    .restart local v15    # "resizeMode":I
    :cond_6
    move/from16 v21, v8

    move/from16 v22, v9

    move/from16 v23, v14

    move/from16 v24, v15

    move-object/from16 v14, v18

    move-object/from16 v9, p1

    .line 448
    .end local v8    # "shutterColor":I
    .end local v9    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v14    # "surfaceType":I
    .end local v15    # "resizeMode":I
    .restart local v21    # "shutterColor":I
    .restart local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    .restart local v23    # "surfaceType":I
    .restart local v24    # "resizeMode":I
    const/4 v0, 0x0

    iput-object v0, v1, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    move/from16 v0, v22

    .line 450
    .end local v22    # "surfaceViewIgnoresVideoAspectRatio":Z
    .local v0, "surfaceViewIgnoresVideoAspectRatio":Z
    :goto_6
    iput-boolean v0, v1, Landroidx/media3/ui/PlayerView;->surfaceViewIgnoresVideoAspectRatio:Z

    .line 453
    sget v4, Landroidx/media3/ui/R$id;->exo_ad_overlay:I

    invoke-virtual {v1, v4}, Landroidx/media3/ui/PlayerView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/FrameLayout;

    iput-object v4, v1, Landroidx/media3/ui/PlayerView;->adOverlayFrameLayout:Landroid/widget/FrameLayout;

    .line 456
    sget v4, Landroidx/media3/ui/R$id;->exo_overlay:I

    invoke-virtual {v1, v4}, Landroidx/media3/ui/PlayerView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/FrameLayout;

    iput-object v4, v1, Landroidx/media3/ui/PlayerView;->overlayFrameLayout:Landroid/widget/FrameLayout;

    .line 459
    sget v4, Landroidx/media3/ui/R$id;->exo_artwork:I

    invoke-virtual {v1, v4}, Landroidx/media3/ui/PlayerView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, v1, Landroidx/media3/ui/PlayerView;->artworkView:Landroid/widget/ImageView;

    .line 460
    if-eqz v10, :cond_7

    if-eqz v11, :cond_7

    if-eqz v4, :cond_7

    const/4 v4, 0x1

    goto :goto_7

    :cond_7
    const/4 v4, 0x0

    .line 462
    .local v4, "isArtworkEnabled":Z
    :goto_7
    if-eqz v4, :cond_8

    move v8, v11

    goto :goto_8

    :cond_8
    const/4 v8, 0x0

    :goto_8
    iput v8, v1, Landroidx/media3/ui/PlayerView;->artworkDisplayMode:I

    .line 463
    if-eqz v12, :cond_9

    .line 464
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/ui/PlayerView;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-static {v8, v12}, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    iput-object v8, v1, Landroidx/media3/ui/PlayerView;->defaultArtwork:Landroid/graphics/drawable/Drawable;

    .line 468
    :cond_9
    sget v8, Landroidx/media3/ui/R$id;->exo_subtitles:I

    invoke-virtual {v1, v8}, Landroidx/media3/ui/PlayerView;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroidx/media3/ui/SubtitleView;

    iput-object v8, v1, Landroidx/media3/ui/PlayerView;->subtitleView:Landroidx/media3/ui/SubtitleView;

    .line 469
    if-eqz v8, :cond_a

    .line 470
    invoke-virtual {v8}, Landroidx/media3/ui/SubtitleView;->setUserDefaultStyle()V

    .line 471
    invoke-virtual {v8}, Landroidx/media3/ui/SubtitleView;->setUserDefaultTextSize()V

    .line 475
    :cond_a
    sget v8, Landroidx/media3/ui/R$id;->exo_buffering:I

    invoke-virtual {v1, v8}, Landroidx/media3/ui/PlayerView;->findViewById(I)Landroid/view/View;

    move-result-object v8

    iput-object v8, v1, Landroidx/media3/ui/PlayerView;->bufferingView:Landroid/view/View;

    .line 476
    const/16 v15, 0x8

    if-eqz v8, :cond_b

    .line 477
    invoke-virtual {v8, v15}, Landroid/view/View;->setVisibility(I)V

    .line 479
    :cond_b
    iput v2, v1, Landroidx/media3/ui/PlayerView;->showBuffering:I

    .line 482
    sget v8, Landroidx/media3/ui/R$id;->exo_error_message:I

    invoke-virtual {v1, v8}, Landroidx/media3/ui/PlayerView;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    iput-object v8, v1, Landroidx/media3/ui/PlayerView;->errorMessageView:Landroid/widget/TextView;

    .line 483
    if-eqz v8, :cond_c

    .line 484
    invoke-virtual {v8, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 488
    :cond_c
    sget v8, Landroidx/media3/ui/R$id;->exo_controller:I

    invoke-virtual {v1, v8}, Landroidx/media3/ui/PlayerView;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroidx/media3/ui/PlayerControlView;

    .line 489
    .local v8, "customController":Landroidx/media3/ui/PlayerControlView;
    sget v15, Landroidx/media3/ui/R$id;->exo_controller_placeholder:I

    invoke-virtual {v1, v15}, Landroidx/media3/ui/PlayerView;->findViewById(I)Landroid/view/View;

    move-result-object v15

    .line 490
    .local v15, "controllerPlaceholder":Landroid/view/View;
    if-eqz v8, :cond_d

    .line 491
    iput-object v8, v1, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    move/from16 v18, v0

    move/from16 v22, v2

    move/from16 v16, v4

    goto :goto_9

    .line 492
    :cond_d
    if-eqz v15, :cond_e

    .line 495
    move/from16 v18, v0

    .end local v0    # "surfaceViewIgnoresVideoAspectRatio":Z
    .local v18, "surfaceViewIgnoresVideoAspectRatio":Z
    new-instance v0, Landroidx/media3/ui/PlayerControlView;

    move/from16 v22, v2

    move/from16 v16, v4

    const/4 v2, 0x0

    const/4 v4, 0x0

    .end local v2    # "showBuffering":I
    .end local v4    # "isArtworkEnabled":Z
    .local v16, "isArtworkEnabled":Z
    .local v22, "showBuffering":I
    invoke-direct {v0, v9, v4, v2, v3}, Landroidx/media3/ui/PlayerControlView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/util/AttributeSet;)V

    iput-object v0, v1, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    .line 496
    sget v4, Landroidx/media3/ui/R$id;->exo_controller:I

    invoke-virtual {v0, v4}, Landroidx/media3/ui/PlayerControlView;->setId(I)V

    .line 497
    invoke-virtual {v15}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroidx/media3/ui/PlayerControlView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 498
    invoke-virtual {v15}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v4

    check-cast v4, Landroid/view/ViewGroup;

    .line 499
    .local v4, "parent":Landroid/view/ViewGroup;
    invoke-virtual {v4, v15}, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I

    move-result v2

    .line 500
    .local v2, "controllerIndex":I
    invoke-virtual {v4, v15}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 501
    invoke-virtual {v4, v0, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;I)V

    .line 502
    .end local v2    # "controllerIndex":I
    .end local v4    # "parent":Landroid/view/ViewGroup;
    goto :goto_9

    .line 503
    .end local v16    # "isArtworkEnabled":Z
    .end local v18    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v22    # "showBuffering":I
    .restart local v0    # "surfaceViewIgnoresVideoAspectRatio":Z
    .local v2, "showBuffering":I
    .local v4, "isArtworkEnabled":Z
    :cond_e
    move/from16 v18, v0

    move/from16 v22, v2

    move/from16 v16, v4

    .end local v0    # "surfaceViewIgnoresVideoAspectRatio":Z
    .end local v2    # "showBuffering":I
    .end local v4    # "isArtworkEnabled":Z
    .restart local v16    # "isArtworkEnabled":Z
    .restart local v18    # "surfaceViewIgnoresVideoAspectRatio":Z
    .restart local v22    # "showBuffering":I
    const/4 v0, 0x0

    iput-object v0, v1, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    .line 505
    :goto_9
    iget-object v0, v1, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    if-eqz v0, :cond_f

    move/from16 v2, v17

    goto :goto_a

    :cond_f
    const/4 v2, 0x0

    :goto_a
    iput v2, v1, Landroidx/media3/ui/PlayerView;->controllerShowTimeoutMs:I

    .line 506
    iput-boolean v7, v1, Landroidx/media3/ui/PlayerView;->controllerHideOnTouch:Z

    .line 507
    iput-boolean v6, v1, Landroidx/media3/ui/PlayerView;->controllerAutoShow:Z

    .line 508
    iput-boolean v5, v1, Landroidx/media3/ui/PlayerView;->controllerHideDuringAds:Z

    .line 509
    if-eqz v13, :cond_10

    if-eqz v0, :cond_10

    const/4 v2, 0x1

    goto :goto_b

    :cond_10
    const/4 v2, 0x0

    :goto_b
    iput-boolean v2, v1, Landroidx/media3/ui/PlayerView;->useController:Z

    .line 510
    if-eqz v0, :cond_11

    .line 511
    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView;->hideImmediately()V

    .line 512
    iget-object v0, v1, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, v14}, Landroidx/media3/ui/PlayerControlView;->addVisibilityListener(Landroidx/media3/ui/PlayerControlView$VisibilityListener;)V

    .line 514
    :cond_11
    if-eqz v13, :cond_12

    .line 515
    const/4 v0, 0x1

    invoke-virtual {v1, v0}, Landroidx/media3/ui/PlayerView;->setClickable(Z)V

    .line 517
    :cond_12
    invoke-direct/range {p0 .. p0}, Landroidx/media3/ui/PlayerView;->updateContentDescription()V

    .line 518
    return-void

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method static synthetic access$000(Landroidx/media3/ui/PlayerView;)Landroidx/media3/ui/SubtitleView;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->subtitleView:Landroidx/media3/ui/SubtitleView;

    return-object v0
.end method

.method static synthetic access$100(Landroidx/media3/ui/PlayerView;)Landroidx/media3/common/Player;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    return-object v0
.end method

.method static synthetic access$1000(Landroidx/media3/ui/PlayerView;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    iget v0, p0, Landroidx/media3/ui/PlayerView;->textureViewRotation:I

    return v0
.end method

.method static synthetic access$1100(Landroid/view/TextureView;I)V
    .locals 0
    .param p0, "x0"    # Landroid/view/TextureView;
    .param p1, "x1"    # I

    .line 179
    invoke-static {p0, p1}, Landroidx/media3/ui/PlayerView;->applyTextureViewRotation(Landroid/view/TextureView;I)V

    return-void
.end method

.method static synthetic access$1200(Landroidx/media3/ui/PlayerView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->toggleControllerVisibility()V

    return-void
.end method

.method static synthetic access$1300(Landroidx/media3/ui/PlayerView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateContentDescription()V

    return-void
.end method

.method static synthetic access$1400(Landroidx/media3/ui/PlayerView;)Landroidx/media3/ui/PlayerView$ControllerVisibilityListener;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controllerVisibilityListener:Landroidx/media3/ui/PlayerView$ControllerVisibilityListener;

    return-object v0
.end method

.method static synthetic access$1500(Landroidx/media3/ui/PlayerView;)Landroidx/media3/ui/PlayerView$FullscreenButtonClickListener;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->fullscreenButtonClickListener:Landroidx/media3/ui/PlayerView$FullscreenButtonClickListener;

    return-object v0
.end method

.method static synthetic access$200(Landroidx/media3/ui/PlayerView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateAspectRatio()V

    return-void
.end method

.method static synthetic access$300(Landroidx/media3/ui/PlayerView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->shutterView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$400(Landroidx/media3/ui/PlayerView;Z)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;
    .param p1, "x1"    # Z

    .line 179
    invoke-direct {p0, p1}, Landroidx/media3/ui/PlayerView;->updateForCurrentTrackSelections(Z)V

    return-void
.end method

.method static synthetic access$500(Landroidx/media3/ui/PlayerView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateBuffering()V

    return-void
.end method

.method static synthetic access$600(Landroidx/media3/ui/PlayerView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateErrorMessage()V

    return-void
.end method

.method static synthetic access$700(Landroidx/media3/ui/PlayerView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateControllerVisibility()V

    return-void
.end method

.method static synthetic access$800(Landroidx/media3/ui/PlayerView;)Z
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->isPlayingAd()Z

    move-result v0

    return v0
.end method

.method static synthetic access$900(Landroidx/media3/ui/PlayerView;)Z
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerView;

    .line 179
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerView;->controllerHideDuringAds:Z

    return v0
.end method

.method private static applyTextureViewRotation(Landroid/view/TextureView;I)V
    .locals 9
    .param p0, "textureView"    # Landroid/view/TextureView;
    .param p1, "textureViewRotation"    # I

    .line 1583
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    .line 1584
    .local v0, "transformMatrix":Landroid/graphics/Matrix;
    invoke-virtual {p0}, Landroid/view/TextureView;->getWidth()I

    move-result v1

    int-to-float v1, v1

    .line 1585
    .local v1, "textureViewWidth":F
    invoke-virtual {p0}, Landroid/view/TextureView;->getHeight()I

    move-result v2

    int-to-float v2, v2

    .line 1586
    .local v2, "textureViewHeight":F
    const/4 v3, 0x0

    cmpl-float v4, v1, v3

    if-eqz v4, :cond_0

    cmpl-float v4, v2, v3

    if-eqz v4, :cond_0

    if-eqz p1, :cond_0

    .line 1587
    const/high16 v4, 0x40000000    # 2.0f

    div-float v5, v1, v4

    .line 1588
    .local v5, "pivotX":F
    div-float v4, v2, v4

    .line 1589
    .local v4, "pivotY":F
    int-to-float v6, p1

    invoke-virtual {v0, v6, v5, v4}, Landroid/graphics/Matrix;->postRotate(FFF)Z

    .line 1592
    new-instance v6, Landroid/graphics/RectF;

    invoke-direct {v6, v3, v3, v1, v2}, Landroid/graphics/RectF;-><init>(FFFF)V

    move-object v3, v6

    .line 1593
    .local v3, "originalTextureRect":Landroid/graphics/RectF;
    new-instance v6, Landroid/graphics/RectF;

    invoke-direct {v6}, Landroid/graphics/RectF;-><init>()V

    .line 1594
    .local v6, "rotatedTextureRect":Landroid/graphics/RectF;
    invoke-virtual {v0, v6, v3}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;Landroid/graphics/RectF;)Z

    .line 1595
    nop

    .line 1596
    invoke-virtual {v6}, Landroid/graphics/RectF;->width()F

    move-result v7

    div-float v7, v1, v7

    .line 1597
    invoke-virtual {v6}, Landroid/graphics/RectF;->height()F

    move-result v8

    div-float v8, v2, v8

    .line 1595
    invoke-virtual {v0, v7, v8, v5, v4}, Landroid/graphics/Matrix;->postScale(FFFF)Z

    .line 1601
    .end local v3    # "originalTextureRect":Landroid/graphics/RectF;
    .end local v4    # "pivotY":F
    .end local v5    # "pivotX":F
    .end local v6    # "rotatedTextureRect":Landroid/graphics/RectF;
    :cond_0
    invoke-virtual {p0, v0}, Landroid/view/TextureView;->setTransform(Landroid/graphics/Matrix;)V

    .line 1602
    return-void
.end method

.method private closeShutter()V
    .locals 2

    .line 1476
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->shutterView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 1477
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1479
    :cond_0
    return-void
.end method

.method private static configureEditModeLogo(Landroid/content/Context;Landroid/content/res/Resources;Landroid/widget/ImageView;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resources"    # Landroid/content/res/Resources;
    .param p2, "logo"    # Landroid/widget/ImageView;

    .line 1572
    sget v0, Landroidx/media3/ui/R$drawable;->exo_edit_mode_logo:I

    invoke-static {p0, p1, v0}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1573
    sget v0, Landroidx/media3/ui/R$color;->exo_edit_mode_background_color:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p2, v0}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    .line 1574
    return-void
.end method

.method private static configureEditModeLogoV23(Landroid/content/Context;Landroid/content/res/Resources;Landroid/widget/ImageView;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resources"    # Landroid/content/res/Resources;
    .param p2, "logo"    # Landroid/widget/ImageView;

    .line 1567
    sget v0, Landroidx/media3/ui/R$drawable;->exo_edit_mode_logo:I

    invoke-static {p0, p1, v0}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1568
    sget v0, Landroidx/media3/ui/R$color;->exo_edit_mode_background_color:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/res/Resources;->getColor(ILandroid/content/res/Resources$Theme;)I

    move-result v0

    invoke-virtual {p2, v0}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    .line 1569
    return-void
.end method

.method private hideArtwork()V
    .locals 2

    .line 1469
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->artworkView:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 1470
    const v1, 0x106000d

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 1471
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->artworkView:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1473
    :cond_0
    return-void
.end method

.method private isDpadKey(I)Z
    .locals 1
    .param p1, "keyCode"    # I

    .line 1606
    const/16 v0, 0x13

    if-eq p1, v0, :cond_1

    const/16 v0, 0x10e

    if-eq p1, v0, :cond_1

    const/16 v0, 0x16

    if-eq p1, v0, :cond_1

    const/16 v0, 0x10f

    if-eq p1, v0, :cond_1

    const/16 v0, 0x14

    if-eq p1, v0, :cond_1

    const/16 v0, 0x10d

    if-eq p1, v0, :cond_1

    const/16 v0, 0x15

    if-eq p1, v0, :cond_1

    const/16 v0, 0x10c

    if-eq p1, v0, :cond_1

    const/16 v0, 0x17

    if-ne p1, v0, :cond_0

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

.method private isPlayingAd()Z
    .locals 2

    .line 1386
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    if-eqz v0, :cond_0

    .line 1387
    const/16 v1, 0x10

    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    .line 1388
    invoke-interface {v0}, Landroidx/media3/common/Player;->isPlayingAd()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    .line 1389
    invoke-interface {v0}, Landroidx/media3/common/Player;->getPlayWhenReady()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 1386
    :goto_0
    return v0
.end method

.method private maybeShowController(Z)V
    .locals 2
    .param p1, "isForced"    # Z

    .line 1351
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->isPlayingAd()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Landroidx/media3/ui/PlayerView;->controllerHideDuringAds:Z

    if-eqz v0, :cond_0

    .line 1352
    return-void

    .line 1354
    :cond_0
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->useController()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1355
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    .line 1356
    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView;->isFullyVisible()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView;->getShowTimeoutMs()I

    move-result v0

    if-gtz v0, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    .line 1357
    .local v0, "wasShowingIndefinitely":Z
    :goto_0
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->shouldShowControllerIndefinitely()Z

    move-result v1

    .line 1358
    .local v1, "shouldShowIndefinitely":Z
    if-nez p1, :cond_2

    if-nez v0, :cond_2

    if-eqz v1, :cond_3

    .line 1359
    :cond_2
    invoke-direct {p0, v1}, Landroidx/media3/ui/PlayerView;->showController(Z)V

    .line 1362
    .end local v0    # "wasShowingIndefinitely":Z
    .end local v1    # "shouldShowIndefinitely":Z
    :cond_3
    return-void
.end method

.method private setArtworkFromMediaMetadata(Landroidx/media3/common/Player;)Z
    .locals 4
    .param p1, "player"    # Landroidx/media3/common/Player;
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "artworkView"
        }
    .end annotation

    .line 1433
    const/16 v0, 0x12

    invoke-interface {p1, v0}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 1434
    return v1

    .line 1436
    :cond_0
    invoke-interface {p1}, Landroidx/media3/common/Player;->getMediaMetadata()Landroidx/media3/common/MediaMetadata;

    move-result-object v0

    .line 1437
    .local v0, "mediaMetadata":Landroidx/media3/common/MediaMetadata;
    iget-object v2, v0, Landroidx/media3/common/MediaMetadata;->artworkData:[B

    if-nez v2, :cond_1

    .line 1438
    return v1

    .line 1440
    :cond_1
    iget-object v2, v0, Landroidx/media3/common/MediaMetadata;->artworkData:[B

    iget-object v3, v0, Landroidx/media3/common/MediaMetadata;->artworkData:[B

    array-length v3, v3

    .line 1441
    invoke-static {v2, v1, v3}, Landroid/graphics/BitmapFactory;->decodeByteArray([BII)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 1443
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    new-instance v2, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Landroidx/media3/ui/PlayerView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-direct {v2, v3, v1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-direct {p0, v2}, Landroidx/media3/ui/PlayerView;->setDrawableArtwork(Landroid/graphics/drawable/Drawable;)Z

    move-result v2

    return v2
.end method

.method private setDrawableArtwork(Landroid/graphics/drawable/Drawable;)Z
    .locals 7
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "artworkView"
        }
    .end annotation

    .line 1448
    const/4 v0, 0x0

    if-eqz p1, :cond_1

    .line 1449
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    .line 1450
    .local v1, "drawableWidth":I
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    .line 1451
    .local v2, "drawableHeight":I
    if-lez v1, :cond_1

    if-lez v2, :cond_1

    .line 1452
    int-to-float v3, v1

    int-to-float v4, v2

    div-float/2addr v3, v4

    .line 1453
    .local v3, "artworkLayoutAspectRatio":F
    sget-object v4, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    .line 1454
    .local v4, "scaleStyle":Landroid/widget/ImageView$ScaleType;
    iget v5, p0, Landroidx/media3/ui/PlayerView;->artworkDisplayMode:I

    const/4 v6, 0x2

    if-ne v5, v6, :cond_0

    .line 1455
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerView;->getWidth()I

    move-result v5

    int-to-float v5, v5

    invoke-virtual {p0}, Landroidx/media3/ui/PlayerView;->getHeight()I

    move-result v6

    int-to-float v6, v6

    div-float v3, v5, v6

    .line 1456
    sget-object v4, Landroid/widget/ImageView$ScaleType;->CENTER_CROP:Landroid/widget/ImageView$ScaleType;

    .line 1458
    :cond_0
    iget-object v5, p0, Landroidx/media3/ui/PlayerView;->contentFrame:Landroidx/media3/ui/AspectRatioFrameLayout;

    invoke-virtual {p0, v5, v3}, Landroidx/media3/ui/PlayerView;->onContentAspectRatioChanged(Landroidx/media3/ui/AspectRatioFrameLayout;F)V

    .line 1459
    iget-object v5, p0, Landroidx/media3/ui/PlayerView;->artworkView:Landroid/widget/ImageView;

    invoke-virtual {v5, v4}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 1460
    iget-object v5, p0, Landroidx/media3/ui/PlayerView;->artworkView:Landroid/widget/ImageView;

    invoke-virtual {v5, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1461
    iget-object v5, p0, Landroidx/media3/ui/PlayerView;->artworkView:Landroid/widget/ImageView;

    invoke-virtual {v5, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1462
    const/4 v0, 0x1

    return v0

    .line 1465
    .end local v1    # "drawableWidth":I
    .end local v2    # "drawableHeight":I
    .end local v3    # "artworkLayoutAspectRatio":F
    .end local v4    # "scaleStyle":Landroid/widget/ImageView$ScaleType;
    :cond_1
    return v0
.end method

.method private static setResizeModeRaw(Landroidx/media3/ui/AspectRatioFrameLayout;I)V
    .locals 0
    .param p0, "aspectRatioFrame"    # Landroidx/media3/ui/AspectRatioFrameLayout;
    .param p1, "resizeMode"    # I

    .line 1578
    invoke-virtual {p0, p1}, Landroidx/media3/ui/AspectRatioFrameLayout;->setResizeMode(I)V

    .line 1579
    return-void
.end method

.method private shouldShowControllerIndefinitely()Z
    .locals 4

    .line 1365
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    const/4 v1, 0x1

    if-nez v0, :cond_0

    .line 1366
    return v1

    .line 1368
    :cond_0
    invoke-interface {v0}, Landroidx/media3/common/Player;->getPlaybackState()I

    move-result v0

    .line 1369
    .local v0, "playbackState":I
    iget-boolean v2, p0, Landroidx/media3/ui/PlayerView;->controllerAutoShow:Z

    if-eqz v2, :cond_3

    iget-object v2, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    .line 1370
    const/16 v3, 0x11

    invoke-interface {v2, v3}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    .line 1371
    invoke-interface {v2}, Landroidx/media3/common/Player;->getCurrentTimeline()Landroidx/media3/common/Timeline;

    move-result-object v2

    invoke-virtual {v2}, Landroidx/media3/common/Timeline;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_3

    :cond_1
    if-eq v0, v1, :cond_2

    const/4 v2, 0x4

    if-eq v0, v2, :cond_2

    iget-object v2, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    .line 1374
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/common/Player;

    invoke-interface {v2}, Landroidx/media3/common/Player;->getPlayWhenReady()Z

    move-result v2

    if-nez v2, :cond_3

    :cond_2
    goto :goto_0

    :cond_3
    const/4 v1, 0x0

    .line 1369
    :goto_0
    return v1
.end method

.method private showController(Z)V
    .locals 2
    .param p1, "showIndefinitely"    # Z

    .line 1378
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->useController()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1379
    return-void

    .line 1381
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    if-eqz p1, :cond_1

    const/4 v1, 0x0

    goto :goto_0

    :cond_1
    iget v1, p0, Landroidx/media3/ui/PlayerView;->controllerShowTimeoutMs:I

    :goto_0
    invoke-virtual {v0, v1}, Landroidx/media3/ui/PlayerControlView;->setShowTimeoutMs(I)V

    .line 1382
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView;->show()V

    .line 1383
    return-void
.end method

.method public static switchTargetView(Landroidx/media3/common/Player;Landroidx/media3/ui/PlayerView;Landroidx/media3/ui/PlayerView;)V
    .locals 1
    .param p0, "player"    # Landroidx/media3/common/Player;
    .param p1, "oldPlayerView"    # Landroidx/media3/ui/PlayerView;
    .param p2, "newPlayerView"    # Landroidx/media3/ui/PlayerView;

    .line 530
    if-ne p1, p2, :cond_0

    .line 531
    return-void

    .line 537
    :cond_0
    if-eqz p2, :cond_1

    .line 538
    invoke-virtual {p2, p0}, Landroidx/media3/ui/PlayerView;->setPlayer(Landroidx/media3/common/Player;)V

    .line 540
    :cond_1
    if-eqz p1, :cond_2

    .line 541
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroidx/media3/ui/PlayerView;->setPlayer(Landroidx/media3/common/Player;)V

    .line 543
    :cond_2
    return-void
.end method

.method private toggleControllerVisibility()V
    .locals 1

    .line 1339
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->useController()Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    if-nez v0, :cond_0

    goto :goto_1

    .line 1342
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView;->isFullyVisible()Z

    move-result v0

    if-nez v0, :cond_1

    .line 1343
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroidx/media3/ui/PlayerView;->maybeShowController(Z)V

    goto :goto_0

    .line 1344
    :cond_1
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerView;->controllerHideOnTouch:Z

    if-eqz v0, :cond_2

    .line 1345
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView;->hide()V

    .line 1347
    :cond_2
    :goto_0
    return-void

    .line 1340
    :cond_3
    :goto_1
    return-void
.end method

.method private updateAspectRatio()V
    .locals 8

    .line 1533
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroidx/media3/common/Player;->getVideoSize()Landroidx/media3/common/VideoSize;

    move-result-object v0

    goto :goto_0

    :cond_0
    sget-object v0, Landroidx/media3/common/VideoSize;->UNKNOWN:Landroidx/media3/common/VideoSize;

    .line 1534
    .local v0, "videoSize":Landroidx/media3/common/VideoSize;
    :goto_0
    iget v1, v0, Landroidx/media3/common/VideoSize;->width:I

    .line 1535
    .local v1, "width":I
    iget v2, v0, Landroidx/media3/common/VideoSize;->height:I

    .line 1536
    .local v2, "height":I
    iget v3, v0, Landroidx/media3/common/VideoSize;->unappliedRotationDegrees:I

    .line 1538
    .local v3, "unappliedRotationDegrees":I
    const/4 v4, 0x0

    if-eqz v2, :cond_2

    if-nez v1, :cond_1

    goto :goto_1

    :cond_1
    int-to-float v5, v1

    iget v6, v0, Landroidx/media3/common/VideoSize;->pixelWidthHeightRatio:F

    mul-float/2addr v5, v6

    int-to-float v6, v2

    div-float/2addr v5, v6

    goto :goto_2

    :cond_2
    :goto_1
    move v5, v4

    .line 1540
    .local v5, "videoAspectRatio":F
    :goto_2
    iget-object v6, p0, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    instance-of v7, v6, Landroid/view/TextureView;

    if-eqz v7, :cond_7

    .line 1542
    cmpl-float v7, v5, v4

    if-lez v7, :cond_4

    const/16 v7, 0x5a

    if-eq v3, v7, :cond_3

    const/16 v7, 0x10e

    if-ne v3, v7, :cond_4

    .line 1546
    :cond_3
    const/high16 v7, 0x3f800000    # 1.0f

    div-float/2addr v7, v5

    move v5, v7

    .line 1548
    :cond_4
    iget v7, p0, Landroidx/media3/ui/PlayerView;->textureViewRotation:I

    if-eqz v7, :cond_5

    .line 1549
    iget-object v7, p0, Landroidx/media3/ui/PlayerView;->componentListener:Landroidx/media3/ui/PlayerView$ComponentListener;

    invoke-virtual {v6, v7}, Landroid/view/View;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 1551
    :cond_5
    iput v3, p0, Landroidx/media3/ui/PlayerView;->textureViewRotation:I

    .line 1552
    if-eqz v3, :cond_6

    .line 1555
    iget-object v6, p0, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    iget-object v7, p0, Landroidx/media3/ui/PlayerView;->componentListener:Landroidx/media3/ui/PlayerView$ComponentListener;

    invoke-virtual {v6, v7}, Landroid/view/View;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 1557
    :cond_6
    iget-object v6, p0, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    check-cast v6, Landroid/view/TextureView;

    iget v7, p0, Landroidx/media3/ui/PlayerView;->textureViewRotation:I

    invoke-static {v6, v7}, Landroidx/media3/ui/PlayerView;->applyTextureViewRotation(Landroid/view/TextureView;I)V

    .line 1560
    :cond_7
    iget-object v6, p0, Landroidx/media3/ui/PlayerView;->contentFrame:Landroidx/media3/ui/AspectRatioFrameLayout;

    .line 1561
    iget-boolean v7, p0, Landroidx/media3/ui/PlayerView;->surfaceViewIgnoresVideoAspectRatio:Z

    if-eqz v7, :cond_8

    goto :goto_3

    :cond_8
    move v4, v5

    .line 1560
    :goto_3
    invoke-virtual {p0, v6, v4}, Landroidx/media3/ui/PlayerView;->onContentAspectRatioChanged(Landroidx/media3/ui/AspectRatioFrameLayout;F)V

    .line 1562
    return-void
.end method

.method private updateBuffering()V
    .locals 4

    .line 1482
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->bufferingView:Landroid/view/View;

    if-eqz v0, :cond_3

    .line 1483
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    .line 1485
    invoke-interface {v0}, Landroidx/media3/common/Player;->getPlaybackState()I

    move-result v0

    const/4 v2, 0x2

    if-ne v0, v2, :cond_1

    iget v0, p0, Landroidx/media3/ui/PlayerView;->showBuffering:I

    const/4 v3, 0x1

    if-eq v0, v2, :cond_0

    if-ne v0, v3, :cond_1

    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    .line 1487
    invoke-interface {v0}, Landroidx/media3/common/Player;->getPlayWhenReady()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    goto :goto_0

    :cond_1
    move v3, v1

    :goto_0
    move v0, v3

    .line 1488
    .local v0, "showBufferingSpinner":Z
    iget-object v2, p0, Landroidx/media3/ui/PlayerView;->bufferingView:Landroid/view/View;

    if-eqz v0, :cond_2

    goto :goto_1

    :cond_2
    const/16 v1, 0x8

    :goto_1
    invoke-virtual {v2, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1490
    .end local v0    # "showBufferingSpinner":Z
    :cond_3
    return-void
.end method

.method private updateContentDescription()V
    .locals 3

    .line 1511
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    const/4 v1, 0x0

    if-eqz v0, :cond_3

    iget-boolean v2, p0, Landroidx/media3/ui/PlayerView;->useController:Z

    if-nez v2, :cond_0

    goto :goto_1

    .line 1513
    :cond_0
    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView;->isFullyVisible()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1514
    nop

    .line 1515
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerView;->controllerHideOnTouch:Z

    if-eqz v0, :cond_1

    .line 1516
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Landroidx/media3/ui/R$string;->exo_controls_hide:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 1517
    :cond_1
    nop

    .line 1514
    :goto_0
    invoke-virtual {p0, v1}, Landroidx/media3/ui/PlayerView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 1519
    :cond_2
    nop

    .line 1520
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Landroidx/media3/ui/R$string;->exo_controls_show:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1519
    invoke-virtual {p0, v0}, Landroidx/media3/ui/PlayerView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 1512
    :cond_3
    :goto_1
    invoke-virtual {p0, v1}, Landroidx/media3/ui/PlayerView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1522
    :goto_2
    return-void
.end method

.method private updateControllerVisibility()V
    .locals 1

    .line 1525
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->isPlayingAd()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Landroidx/media3/ui/PlayerView;->controllerHideDuringAds:Z

    if-eqz v0, :cond_0

    .line 1526
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerView;->hideController()V

    goto :goto_0

    .line 1528
    :cond_0
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/ui/PlayerView;->maybeShowController(Z)V

    .line 1530
    :goto_0
    return-void
.end method

.method private updateErrorMessage()V
    .locals 4

    .line 1493
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->errorMessageView:Landroid/widget/TextView;

    if-eqz v0, :cond_3

    .line 1494
    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->customErrorMessage:Ljava/lang/CharSequence;

    const/4 v2, 0x0

    if-eqz v1, :cond_0

    .line 1495
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1496
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->errorMessageView:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1497
    return-void

    .line 1499
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    if-eqz v0, :cond_1

    invoke-interface {v0}, Landroidx/media3/common/Player;->getPlayerError()Landroidx/media3/common/PlaybackException;

    move-result-object v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    .line 1500
    .local v0, "error":Landroidx/media3/common/PlaybackException;
    :goto_0
    if-eqz v0, :cond_2

    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->errorMessageProvider:Landroidx/media3/common/ErrorMessageProvider;

    if-eqz v1, :cond_2

    .line 1501
    invoke-interface {v1, v0}, Landroidx/media3/common/ErrorMessageProvider;->getErrorMessage(Ljava/lang/Throwable;)Landroid/util/Pair;

    move-result-object v1

    iget-object v1, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v1, Ljava/lang/CharSequence;

    .line 1502
    .local v1, "errorMessage":Ljava/lang/CharSequence;
    iget-object v3, p0, Landroidx/media3/ui/PlayerView;->errorMessageView:Landroid/widget/TextView;

    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1503
    iget-object v3, p0, Landroidx/media3/ui/PlayerView;->errorMessageView:Landroid/widget/TextView;

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1504
    .end local v1    # "errorMessage":Ljava/lang/CharSequence;
    goto :goto_1

    .line 1505
    :cond_2
    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->errorMessageView:Landroid/widget/TextView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1508
    .end local v0    # "error":Landroidx/media3/common/PlaybackException;
    :cond_3
    :goto_1
    return-void
.end method

.method private updateForCurrentTrackSelections(Z)V
    .locals 3
    .param p1, "isNewPlayer"    # Z

    .line 1393
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    .line 1394
    .local v0, "player":Landroidx/media3/common/Player;
    if-eqz v0, :cond_5

    .line 1395
    const/16 v1, 0x1e

    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 1396
    invoke-interface {v0}, Landroidx/media3/common/Player;->getCurrentTracks()Landroidx/media3/common/Tracks;

    move-result-object v1

    invoke-virtual {v1}, Landroidx/media3/common/Tracks;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_0

    .line 1404
    :cond_0
    if-eqz p1, :cond_1

    iget-boolean v1, p0, Landroidx/media3/ui/PlayerView;->keepContentOnPlayerReset:Z

    if-nez v1, :cond_1

    .line 1406
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->closeShutter()V

    .line 1409
    :cond_1
    invoke-interface {v0}, Landroidx/media3/common/Player;->getCurrentTracks()Landroidx/media3/common/Tracks;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroidx/media3/common/Tracks;->isTypeSelected(I)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1412
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->hideArtwork()V

    .line 1413
    return-void

    .line 1417
    :cond_2
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->closeShutter()V

    .line 1419
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->useArtwork()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 1420
    invoke-direct {p0, v0}, Landroidx/media3/ui/PlayerView;->setArtworkFromMediaMetadata(Landroidx/media3/common/Player;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1421
    return-void

    .line 1423
    :cond_3
    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->defaultArtwork:Landroid/graphics/drawable/Drawable;

    invoke-direct {p0, v1}, Landroidx/media3/ui/PlayerView;->setDrawableArtwork(Landroid/graphics/drawable/Drawable;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 1424
    return-void

    .line 1428
    :cond_4
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->hideArtwork()V

    .line 1429
    return-void

    .line 1397
    :cond_5
    :goto_0
    iget-boolean v1, p0, Landroidx/media3/ui/PlayerView;->keepContentOnPlayerReset:Z

    if-nez v1, :cond_6

    .line 1398
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->hideArtwork()V

    .line 1399
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->closeShutter()V

    .line 1401
    :cond_6
    return-void
.end method

.method private useArtwork()Z
    .locals 1
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/EnsuresNonNullIf;
        expression = {
            "artworkView"
        }
        result = true
    .end annotation

    .line 1331
    iget v0, p0, Landroidx/media3/ui/PlayerView;->artworkDisplayMode:I

    if-eqz v0, :cond_0

    .line 1332
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->artworkView:Landroid/widget/ImageView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1333
    const/4 v0, 0x1

    return v0

    .line 1335
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method private useController()Z
    .locals 1
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/EnsuresNonNullIf;
        expression = {
            "controller"
        }
        result = true
    .end annotation

    .line 1322
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerView;->useController:Z

    if-eqz v0, :cond_0

    .line 1323
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1324
    const/4 v0, 0x1

    return v0

    .line 1326
    :cond_0
    const/4 v0, 0x0

    return v0
.end method


# virtual methods
.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 810
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    if-eqz v0, :cond_0

    .line 811
    const/16 v1, 0x10

    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    .line 812
    invoke-interface {v0}, Landroidx/media3/common/Player;->isPlayingAd()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 813
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    return v0

    .line 816
    :cond_0
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    invoke-direct {p0, v0}, Landroidx/media3/ui/PlayerView;->isDpadKey(I)Z

    move-result v0

    .line 817
    .local v0, "isDpadKey":Z
    const/4 v1, 0x0

    .line 818
    .local v1, "handled":Z
    const/4 v2, 0x1

    if-eqz v0, :cond_1

    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->useController()Z

    move-result v3

    if-eqz v3, :cond_1

    iget-object v3, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v3}, Landroidx/media3/ui/PlayerControlView;->isFullyVisible()Z

    move-result v3

    if-nez v3, :cond_1

    .line 820
    invoke-direct {p0, v2}, Landroidx/media3/ui/PlayerView;->maybeShowController(Z)V

    .line 821
    const/4 v1, 0x1

    goto :goto_1

    .line 822
    :cond_1
    invoke-virtual {p0, p1}, Landroidx/media3/ui/PlayerView;->dispatchMediaKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v3

    if-nez v3, :cond_3

    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v3

    if-eqz v3, :cond_2

    goto :goto_0

    .line 827
    :cond_2
    if-eqz v0, :cond_4

    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->useController()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 829
    invoke-direct {p0, v2}, Landroidx/media3/ui/PlayerView;->maybeShowController(Z)V

    goto :goto_1

    .line 825
    :cond_3
    :goto_0
    invoke-direct {p0, v2}, Landroidx/media3/ui/PlayerView;->maybeShowController(Z)V

    .line 826
    const/4 v1, 0x1

    .line 831
    :cond_4
    :goto_1
    return v1
.end method

.method public dispatchMediaKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 843
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->useController()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->dispatchMediaKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public getAdOverlayInfos()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroidx/media3/common/AdOverlayInfo;",
            ">;"
        }
    .end annotation

    .line 1304
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 1305
    .local v0, "overlayViews":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/AdOverlayInfo;>;"
    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->overlayFrameLayout:Landroid/widget/FrameLayout;

    if-eqz v1, :cond_0

    .line 1306
    new-instance v1, Landroidx/media3/common/AdOverlayInfo$Builder;

    iget-object v2, p0, Landroidx/media3/ui/PlayerView;->overlayFrameLayout:Landroid/widget/FrameLayout;

    const/4 v3, 0x4

    invoke-direct {v1, v2, v3}, Landroidx/media3/common/AdOverlayInfo$Builder;-><init>(Landroid/view/View;I)V

    .line 1308
    const-string v2, "Transparent overlay does not impact viewability"

    invoke-virtual {v1, v2}, Landroidx/media3/common/AdOverlayInfo$Builder;->setDetailedReason(Ljava/lang/String;)Landroidx/media3/common/AdOverlayInfo$Builder;

    move-result-object v1

    .line 1309
    invoke-virtual {v1}, Landroidx/media3/common/AdOverlayInfo$Builder;->build()Landroidx/media3/common/AdOverlayInfo;

    move-result-object v1

    .line 1306
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1311
    :cond_0
    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    if-eqz v1, :cond_1

    .line 1312
    new-instance v1, Landroidx/media3/common/AdOverlayInfo$Builder;

    iget-object v2, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    const/4 v3, 0x1

    invoke-direct {v1, v2, v3}, Landroidx/media3/common/AdOverlayInfo$Builder;-><init>(Landroid/view/View;I)V

    .line 1313
    invoke-virtual {v1}, Landroidx/media3/common/AdOverlayInfo$Builder;->build()Landroidx/media3/common/AdOverlayInfo;

    move-result-object v1

    .line 1312
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1315
    :cond_1
    invoke-static {v0}, Lcom/google/common/collect/ImmutableList;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableList;

    move-result-object v1

    return-object v1
.end method

.method public getAdViewGroup()Landroid/view/ViewGroup;
    .locals 2

    .line 1298
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->adOverlayFrameLayout:Landroid/widget/FrameLayout;

    const-string v1, "exo_ad_overlay must be present for ad playback"

    invoke-static {v0, v1}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    return-object v0
.end method

.method public getArtworkDisplayMode()I
    .locals 1

    .line 673
    iget v0, p0, Landroidx/media3/ui/PlayerView;->artworkDisplayMode:I

    return v0
.end method

.method public getControllerAutoShow()Z
    .locals 1

    .line 927
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerView;->controllerAutoShow:Z

    return v0
.end method

.method public getControllerHideOnTouch()Z
    .locals 1

    .line 905
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerView;->controllerHideOnTouch:Z

    return v0
.end method

.method public getControllerShowTimeoutMs()I
    .locals 1

    .line 882
    iget v0, p0, Landroidx/media3/ui/PlayerView;->controllerShowTimeoutMs:I

    return v0
.end method

.method public getDefaultArtwork()Landroid/graphics/drawable/Drawable;
    .locals 1

    .line 680
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->defaultArtwork:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getOverlayFrameLayout()Landroid/widget/FrameLayout;
    .locals 1

    .line 1223
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->overlayFrameLayout:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method public getPlayer()Landroidx/media3/common/Player;
    .locals 1

    .line 548
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    return-object v0
.end method

.method public getResizeMode()I
    .locals 1

    .line 638
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->contentFrame:Landroidx/media3/ui/AspectRatioFrameLayout;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 639
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->contentFrame:Landroidx/media3/ui/AspectRatioFrameLayout;

    invoke-virtual {v0}, Landroidx/media3/ui/AspectRatioFrameLayout;->getResizeMode()I

    move-result v0

    return v0
.end method

.method public getSubtitleView()Landroidx/media3/ui/SubtitleView;
    .locals 1

    .line 1235
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->subtitleView:Landroidx/media3/ui/SubtitleView;

    return-object v0
.end method

.method public getUseArtwork()Z
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 648
    iget v0, p0, Landroidx/media3/ui/PlayerView;->artworkDisplayMode:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public getUseController()Z
    .locals 1

    .line 699
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerView;->useController:Z

    return v0
.end method

.method public getVideoSurfaceView()Landroid/view/View;
    .locals 1

    .line 1210
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    return-object v0
.end method

.method public hideController()V
    .locals 1

    .line 867
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    if-eqz v0, :cond_0

    .line 868
    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView;->hide()V

    .line 870
    :cond_0
    return-void
.end method

.method public isControllerFullyVisible()Z
    .locals 1

    .line 849
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView;->isFullyVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method protected onContentAspectRatioChanged(Landroidx/media3/ui/AspectRatioFrameLayout;F)V
    .locals 0
    .param p1, "contentFrame"    # Landroidx/media3/ui/AspectRatioFrameLayout;
    .param p2, "aspectRatio"    # F

    .line 1289
    if-eqz p1, :cond_0

    .line 1290
    invoke-virtual {p1, p2}, Landroidx/media3/ui/AspectRatioFrameLayout;->setAspectRatio(F)V

    .line 1292
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 2

    .line 1274
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    instance-of v1, v0, Landroid/opengl/GLSurfaceView;

    if-eqz v1, :cond_0

    .line 1275
    check-cast v0, Landroid/opengl/GLSurfaceView;

    invoke-virtual {v0}, Landroid/opengl/GLSurfaceView;->onPause()V

    .line 1277
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 2

    .line 1261
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    instance-of v1, v0, Landroid/opengl/GLSurfaceView;

    if-eqz v1, :cond_0

    .line 1262
    check-cast v0, Landroid/opengl/GLSurfaceView;

    invoke-virtual {v0}, Landroid/opengl/GLSurfaceView;->onResume()V

    .line 1264
    :cond_0
    return-void
.end method

.method public onTrackballEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .line 1246
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->useController()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    if-nez v0, :cond_0

    goto :goto_0

    .line 1249
    :cond_0
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroidx/media3/ui/PlayerView;->maybeShowController(Z)V

    .line 1250
    return v0

    .line 1247
    :cond_1
    :goto_0
    const/4 v0, 0x0

    return v0
.end method

.method public performClick()Z
    .locals 1

    .line 1240
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->toggleControllerVisibility()V

    .line 1241
    invoke-super {p0}, Landroid/widget/FrameLayout;->performClick()Z

    move-result v0

    return v0
.end method

.method public setArtworkDisplayMode(I)V
    .locals 2
    .param p1, "artworkDisplayMode"    # I

    .line 663
    const/4 v0, 0x0

    if-eqz p1, :cond_1

    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->artworkView:Landroid/widget/ImageView;

    if-eqz v1, :cond_0

    goto :goto_0

    :cond_0
    move v1, v0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v1, 0x1

    :goto_1
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 664
    iget v1, p0, Landroidx/media3/ui/PlayerView;->artworkDisplayMode:I

    if-eq v1, p1, :cond_2

    .line 665
    iput p1, p0, Landroidx/media3/ui/PlayerView;->artworkDisplayMode:I

    .line 666
    invoke-direct {p0, v0}, Landroidx/media3/ui/PlayerView;->updateForCurrentTrackSelections(Z)V

    .line 668
    :cond_2
    return-void
.end method

.method public setAspectRatioListener(Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioListener;)V
    .locals 1
    .param p1, "listener"    # Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioListener;

    .line 1186
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->contentFrame:Landroidx/media3/ui/AspectRatioFrameLayout;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1187
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->contentFrame:Landroidx/media3/ui/AspectRatioFrameLayout;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/AspectRatioFrameLayout;->setAspectRatioListener(Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioListener;)V

    .line 1188
    return-void
.end method

.method public setControllerAnimationEnabled(Z)V
    .locals 1
    .param p1, "animationEnabled"    # Z

    .line 976
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 977
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->setAnimationEnabled(Z)V

    .line 978
    return-void
.end method

.method public setControllerAutoShow(Z)V
    .locals 0
    .param p1, "controllerAutoShow"    # Z

    .line 939
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerView;->controllerAutoShow:Z

    .line 940
    return-void
.end method

.method public setControllerHideDuringAds(Z)V
    .locals 0
    .param p1, "controllerHideDuringAds"    # Z

    .line 950
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerView;->controllerHideDuringAds:Z

    .line 951
    return-void
.end method

.method public setControllerHideOnTouch(Z)V
    .locals 1
    .param p1, "controllerHideOnTouch"    # Z

    .line 915
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 916
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerView;->controllerHideOnTouch:Z

    .line 917
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateContentDescription()V

    .line 918
    return-void
.end method

.method public setControllerOnFullScreenModeChangedListener(Landroidx/media3/ui/PlayerControlView$OnFullScreenModeChangedListener;)V
    .locals 1
    .param p1, "listener"    # Landroidx/media3/ui/PlayerControlView$OnFullScreenModeChangedListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 1040
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1041
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/ui/PlayerView;->fullscreenButtonClickListener:Landroidx/media3/ui/PlayerView$FullscreenButtonClickListener;

    .line 1042
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->setOnFullScreenModeChangedListener(Landroidx/media3/ui/PlayerControlView$OnFullScreenModeChangedListener;)V

    .line 1043
    return-void
.end method

.method public setControllerShowTimeoutMs(I)V
    .locals 1
    .param p1, "controllerShowTimeoutMs"    # I

    .line 894
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 895
    iput p1, p0, Landroidx/media3/ui/PlayerView;->controllerShowTimeoutMs:I

    .line 896
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView;->isFullyVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 898
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerView;->showController()V

    .line 900
    :cond_0
    return-void
.end method

.method public setControllerVisibilityListener(Landroidx/media3/ui/PlayerControlView$VisibilityListener;)V
    .locals 2
    .param p1, "listener"    # Landroidx/media3/ui/PlayerControlView$VisibilityListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 993
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 994
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->legacyControllerVisibilityListener:Landroidx/media3/ui/PlayerControlView$VisibilityListener;

    if-ne v0, p1, :cond_0

    .line 995
    return-void

    .line 998
    :cond_0
    if-eqz v0, :cond_1

    .line 999
    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v1, v0}, Landroidx/media3/ui/PlayerControlView;->removeVisibilityListener(Landroidx/media3/ui/PlayerControlView$VisibilityListener;)V

    .line 1001
    :cond_1
    iput-object p1, p0, Landroidx/media3/ui/PlayerView;->legacyControllerVisibilityListener:Landroidx/media3/ui/PlayerControlView$VisibilityListener;

    .line 1002
    if-eqz p1, :cond_2

    .line 1003
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->addVisibilityListener(Landroidx/media3/ui/PlayerControlView$VisibilityListener;)V

    .line 1004
    const/4 v0, 0x0

    move-object v1, v0

    check-cast v1, Landroidx/media3/ui/PlayerView$ControllerVisibilityListener;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/PlayerView;->setControllerVisibilityListener(Landroidx/media3/ui/PlayerView$ControllerVisibilityListener;)V

    .line 1006
    :cond_2
    return-void
.end method

.method public setControllerVisibilityListener(Landroidx/media3/ui/PlayerView$ControllerVisibilityListener;)V
    .locals 2
    .param p1, "listener"    # Landroidx/media3/ui/PlayerView$ControllerVisibilityListener;

    .line 964
    iput-object p1, p0, Landroidx/media3/ui/PlayerView;->controllerVisibilityListener:Landroidx/media3/ui/PlayerView$ControllerVisibilityListener;

    .line 965
    if-eqz p1, :cond_0

    .line 966
    const/4 v0, 0x0

    move-object v1, v0

    check-cast v1, Landroidx/media3/ui/PlayerControlView$VisibilityListener;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/PlayerView;->setControllerVisibilityListener(Landroidx/media3/ui/PlayerControlView$VisibilityListener;)V

    .line 968
    :cond_0
    return-void
.end method

.method public setCustomErrorMessage(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/CharSequence;

    .line 803
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->errorMessageView:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 804
    iput-object p1, p0, Landroidx/media3/ui/PlayerView;->customErrorMessage:Ljava/lang/CharSequence;

    .line 805
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateErrorMessage()V

    .line 806
    return-void
.end method

.method public setDefaultArtwork(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "defaultArtwork"    # Landroid/graphics/drawable/Drawable;

    .line 691
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->defaultArtwork:Landroid/graphics/drawable/Drawable;

    if-eq v0, p1, :cond_0

    .line 692
    iput-object p1, p0, Landroidx/media3/ui/PlayerView;->defaultArtwork:Landroid/graphics/drawable/Drawable;

    .line 693
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/ui/PlayerView;->updateForCurrentTrackSelections(Z)V

    .line 695
    :cond_0
    return-void
.end method

.method public setErrorMessageProvider(Landroidx/media3/common/ErrorMessageProvider;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/ErrorMessageProvider<",
            "-",
            "Landroidx/media3/common/PlaybackException;",
            ">;)V"
        }
    .end annotation

    .line 789
    .local p1, "errorMessageProvider":Landroidx/media3/common/ErrorMessageProvider;, "Landroidx/media3/common/ErrorMessageProvider<-Landroidx/media3/common/PlaybackException;>;"
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->errorMessageProvider:Landroidx/media3/common/ErrorMessageProvider;

    if-eq v0, p1, :cond_0

    .line 790
    iput-object p1, p0, Landroidx/media3/ui/PlayerView;->errorMessageProvider:Landroidx/media3/common/ErrorMessageProvider;

    .line 791
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateErrorMessage()V

    .line 793
    :cond_0
    return-void
.end method

.method public setExtraAdGroupMarkers([J[Z)V
    .locals 1
    .param p1, "extraAdGroupTimesMs"    # [J
    .param p2, "extraPlayedAdGroups"    # [Z

    .line 1173
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1174
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/ui/PlayerControlView;->setExtraAdGroupMarkers([J[Z)V

    .line 1175
    return-void
.end method

.method public setFullscreenButtonClickListener(Landroidx/media3/ui/PlayerView$FullscreenButtonClickListener;)V
    .locals 2
    .param p1, "listener"    # Landroidx/media3/ui/PlayerView$FullscreenButtonClickListener;

    .line 1019
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1020
    iput-object p1, p0, Landroidx/media3/ui/PlayerView;->fullscreenButtonClickListener:Landroidx/media3/ui/PlayerView$FullscreenButtonClickListener;

    .line 1021
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->componentListener:Landroidx/media3/ui/PlayerView$ComponentListener;

    invoke-virtual {v0, v1}, Landroidx/media3/ui/PlayerControlView;->setOnFullScreenModeChangedListener(Landroidx/media3/ui/PlayerControlView$OnFullScreenModeChangedListener;)V

    .line 1022
    return-void
.end method

.method public setKeepContentOnPlayerReset(Z)V
    .locals 1
    .param p1, "keepContentOnPlayerReset"    # Z

    .line 760
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerView;->keepContentOnPlayerReset:Z

    if-eq v0, p1, :cond_0

    .line 761
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerView;->keepContentOnPlayerReset:Z

    .line 762
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/ui/PlayerView;->updateForCurrentTrackSelections(Z)V

    .line 764
    :cond_0
    return-void
.end method

.method public setPlayer(Landroidx/media3/common/Player;)V
    .locals 6
    .param p1, "player"    # Landroidx/media3/common/Player;

    .line 565
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-ne v0, v1, :cond_0

    move v0, v2

    goto :goto_0

    :cond_0
    move v0, v3

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 566
    if-eqz p1, :cond_2

    .line 567
    invoke-interface {p1}, Landroidx/media3/common/Player;->getApplicationLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_1

    goto :goto_1

    :cond_1
    move v0, v3

    goto :goto_2

    :cond_2
    :goto_1
    move v0, v2

    .line 566
    :goto_2
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 568
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    if-ne v0, p1, :cond_3

    .line 569
    return-void

    .line 571
    :cond_3
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    .line 572
    .local v0, "oldPlayer":Landroidx/media3/common/Player;
    const/16 v1, 0x1b

    if-eqz v0, :cond_5

    .line 573
    iget-object v4, p0, Landroidx/media3/ui/PlayerView;->componentListener:Landroidx/media3/ui/PlayerView$ComponentListener;

    invoke-interface {v0, v4}, Landroidx/media3/common/Player;->removeListener(Landroidx/media3/common/Player$Listener;)V

    .line 574
    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 575
    iget-object v4, p0, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    instance-of v5, v4, Landroid/view/TextureView;

    if-eqz v5, :cond_4

    .line 576
    check-cast v4, Landroid/view/TextureView;

    invoke-interface {v0, v4}, Landroidx/media3/common/Player;->clearVideoTextureView(Landroid/view/TextureView;)V

    goto :goto_3

    .line 577
    :cond_4
    instance-of v5, v4, Landroid/view/SurfaceView;

    if-eqz v5, :cond_5

    .line 578
    check-cast v4, Landroid/view/SurfaceView;

    invoke-interface {v0, v4}, Landroidx/media3/common/Player;->clearVideoSurfaceView(Landroid/view/SurfaceView;)V

    .line 582
    :cond_5
    :goto_3
    iget-object v4, p0, Landroidx/media3/ui/PlayerView;->subtitleView:Landroidx/media3/ui/SubtitleView;

    if-eqz v4, :cond_6

    .line 583
    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroidx/media3/ui/SubtitleView;->setCues(Ljava/util/List;)V

    .line 585
    :cond_6
    iput-object p1, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    .line 586
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->useController()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 587
    iget-object v4, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v4, p1}, Landroidx/media3/ui/PlayerControlView;->setPlayer(Landroidx/media3/common/Player;)V

    .line 589
    :cond_7
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateBuffering()V

    .line 590
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateErrorMessage()V

    .line 591
    invoke-direct {p0, v2}, Landroidx/media3/ui/PlayerView;->updateForCurrentTrackSelections(Z)V

    .line 592
    if-eqz p1, :cond_d

    .line 593
    invoke-interface {p1, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 594
    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    instance-of v2, v1, Landroid/view/TextureView;

    if-eqz v2, :cond_8

    .line 595
    check-cast v1, Landroid/view/TextureView;

    invoke-interface {p1, v1}, Landroidx/media3/common/Player;->setVideoTextureView(Landroid/view/TextureView;)V

    goto :goto_4

    .line 596
    :cond_8
    instance-of v2, v1, Landroid/view/SurfaceView;

    if-eqz v2, :cond_9

    .line 597
    check-cast v1, Landroid/view/SurfaceView;

    invoke-interface {p1, v1}, Landroidx/media3/common/Player;->setVideoSurfaceView(Landroid/view/SurfaceView;)V

    .line 599
    :cond_9
    :goto_4
    const/16 v1, 0x1e

    invoke-interface {p1, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 600
    invoke-interface {p1}, Landroidx/media3/common/Player;->getCurrentTracks()Landroidx/media3/common/Tracks;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroidx/media3/common/Tracks;->isTypeSupported(I)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 602
    :cond_a
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateAspectRatio()V

    .line 605
    :cond_b
    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->subtitleView:Landroidx/media3/ui/SubtitleView;

    if-eqz v1, :cond_c

    const/16 v1, 0x1c

    invoke-interface {p1, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v1

    if-eqz v1, :cond_c

    .line 606
    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->subtitleView:Landroidx/media3/ui/SubtitleView;

    invoke-interface {p1}, Landroidx/media3/common/Player;->getCurrentCues()Landroidx/media3/common/text/CueGroup;

    move-result-object v2

    iget-object v2, v2, Landroidx/media3/common/text/CueGroup;->cues:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v1, v2}, Landroidx/media3/ui/SubtitleView;->setCues(Ljava/util/List;)V

    .line 608
    :cond_c
    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->componentListener:Landroidx/media3/ui/PlayerView$ComponentListener;

    invoke-interface {p1, v1}, Landroidx/media3/common/Player;->addListener(Landroidx/media3/common/Player$Listener;)V

    .line 609
    invoke-direct {p0, v3}, Landroidx/media3/ui/PlayerView;->maybeShowController(Z)V

    goto :goto_5

    .line 611
    :cond_d
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerView;->hideController()V

    .line 613
    :goto_5
    return-void
.end method

.method public setRepeatToggleModes(I)V
    .locals 1
    .param p1, "repeatToggleModes"    # I

    .line 1096
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1097
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->setRepeatToggleModes(I)V

    .line 1098
    return-void
.end method

.method public setResizeMode(I)V
    .locals 1
    .param p1, "resizeMode"    # I

    .line 631
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->contentFrame:Landroidx/media3/ui/AspectRatioFrameLayout;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 632
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->contentFrame:Landroidx/media3/ui/AspectRatioFrameLayout;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/AspectRatioFrameLayout;->setResizeMode(I)V

    .line 633
    return-void
.end method

.method public setShowBuffering(I)V
    .locals 1
    .param p1, "showBuffering"    # I

    .line 776
    iget v0, p0, Landroidx/media3/ui/PlayerView;->showBuffering:I

    if-eq v0, p1, :cond_0

    .line 777
    iput p1, p0, Landroidx/media3/ui/PlayerView;->showBuffering:I

    .line 778
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateBuffering()V

    .line 780
    :cond_0
    return-void
.end method

.method public setShowFastForwardButton(Z)V
    .locals 1
    .param p1, "showFastForwardButton"    # Z

    .line 1063
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1064
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->setShowFastForwardButton(Z)V

    .line 1065
    return-void
.end method

.method public setShowMultiWindowTimeBar(Z)V
    .locals 1
    .param p1, "showMultiWindowTimeBar"    # Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 1141
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1142
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->setShowMultiWindowTimeBar(Z)V

    .line 1143
    return-void
.end method

.method public setShowNextButton(Z)V
    .locals 1
    .param p1, "showNextButton"    # Z

    .line 1085
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1086
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->setShowNextButton(Z)V

    .line 1087
    return-void
.end method

.method public setShowPlayButtonIfPlaybackIsSuppressed(Z)V
    .locals 1
    .param p1, "showPlayButtonIfSuppressed"    # Z

    .line 1156
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1157
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->setShowPlayButtonIfPlaybackIsSuppressed(Z)V

    .line 1158
    return-void
.end method

.method public setShowPreviousButton(Z)V
    .locals 1
    .param p1, "showPreviousButton"    # Z

    .line 1074
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1075
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->setShowPreviousButton(Z)V

    .line 1076
    return-void
.end method

.method public setShowRewindButton(Z)V
    .locals 1
    .param p1, "showRewindButton"    # Z

    .line 1052
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1053
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->setShowRewindButton(Z)V

    .line 1054
    return-void
.end method

.method public setShowShuffleButton(Z)V
    .locals 1
    .param p1, "showShuffleButton"    # Z

    .line 1107
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1108
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->setShowShuffleButton(Z)V

    .line 1109
    return-void
.end method

.method public setShowSubtitleButton(Z)V
    .locals 1
    .param p1, "showSubtitleButton"    # Z

    .line 1118
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1119
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->setShowSubtitleButton(Z)V

    .line 1120
    return-void
.end method

.method public setShowVrButton(Z)V
    .locals 1
    .param p1, "showVrButton"    # Z

    .line 1129
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1130
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlView;->setShowVrButton(Z)V

    .line 1131
    return-void
.end method

.method public setShutterBackgroundColor(I)V
    .locals 1
    .param p1, "color"    # I

    .line 734
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->shutterView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 735
    invoke-virtual {v0, p1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 737
    :cond_0
    return-void
.end method

.method public setUseArtwork(Z)V
    .locals 1
    .param p1, "useArtwork"    # Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 657
    xor-int/lit8 v0, p1, 0x1

    invoke-virtual {p0, v0}, Landroidx/media3/ui/PlayerView;->setArtworkDisplayMode(I)V

    .line 658
    return-void
.end method

.method public setUseController(Z)V
    .locals 3
    .param p1, "useController"    # Z

    .line 712
    const/4 v0, 0x0

    const/4 v1, 0x1

    if-eqz p1, :cond_1

    iget-object v2, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    if-eqz v2, :cond_0

    goto :goto_0

    :cond_0
    move v2, v0

    goto :goto_1

    :cond_1
    :goto_0
    move v2, v1

    :goto_1
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 713
    if-nez p1, :cond_2

    invoke-virtual {p0}, Landroidx/media3/ui/PlayerView;->hasOnClickListeners()Z

    move-result v2

    if-eqz v2, :cond_3

    :cond_2
    move v0, v1

    :cond_3
    invoke-virtual {p0, v0}, Landroidx/media3/ui/PlayerView;->setClickable(Z)V

    .line 714
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerView;->useController:Z

    if-ne v0, p1, :cond_4

    .line 715
    return-void

    .line 717
    :cond_4
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerView;->useController:Z

    .line 718
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->useController()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 719
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    iget-object v1, p0, Landroidx/media3/ui/PlayerView;->player:Landroidx/media3/common/Player;

    invoke-virtual {v0, v1}, Landroidx/media3/ui/PlayerControlView;->setPlayer(Landroidx/media3/common/Player;)V

    goto :goto_2

    .line 720
    :cond_5
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    if-eqz v0, :cond_6

    .line 721
    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView;->hide()V

    .line 722
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->controller:Landroidx/media3/ui/PlayerControlView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroidx/media3/ui/PlayerControlView;->setPlayer(Landroidx/media3/common/Player;)V

    .line 724
    :cond_6
    :goto_2
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->updateContentDescription()V

    .line 725
    return-void
.end method

.method public setVisibility(I)V
    .locals 2
    .param p1, "visibility"    # I

    .line 617
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 618
    iget-object v0, p0, Landroidx/media3/ui/PlayerView;->surfaceView:Landroid/view/View;

    instance-of v1, v0, Landroid/view/SurfaceView;

    if-eqz v1, :cond_0

    .line 620
    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 622
    :cond_0
    return-void
.end method

.method public showController()V
    .locals 1

    .line 861
    invoke-direct {p0}, Landroidx/media3/ui/PlayerView;->shouldShowControllerIndefinitely()Z

    move-result v0

    invoke-direct {p0, v0}, Landroidx/media3/ui/PlayerView;->showController(Z)V

    .line 862
    return-void
.end method
