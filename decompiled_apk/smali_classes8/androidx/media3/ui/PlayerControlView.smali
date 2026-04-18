.class public Landroidx/media3/ui/PlayerControlView;
.super Landroid/widget/FrameLayout;
.source "PlayerControlView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;,
        Landroidx/media3/ui/PlayerControlView$AudioTrackSelectionAdapter;,
        Landroidx/media3/ui/PlayerControlView$PlaybackSpeedAdapter;,
        Landroidx/media3/ui/PlayerControlView$SettingsAdapter;,
        Landroidx/media3/ui/PlayerControlView$ComponentListener;,
        Landroidx/media3/ui/PlayerControlView$ProgressUpdateListener;,
        Landroidx/media3/ui/PlayerControlView$OnFullScreenModeChangedListener;,
        Landroidx/media3/ui/PlayerControlView$VisibilityListener;,
        Landroidx/media3/ui/PlayerControlView$TrackInformation;,
        Landroidx/media3/ui/PlayerControlView$SubSettingViewHolder;,
        Landroidx/media3/ui/PlayerControlView$TrackSelectionAdapter;,
        Landroidx/media3/ui/PlayerControlView$SettingViewHolder;
    }
.end annotation


# static fields
.field public static final DEFAULT_REPEAT_TOGGLE_MODES:I = 0x0

.field public static final DEFAULT_SHOW_TIMEOUT_MS:I = 0x1388

.field public static final DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS:I = 0xc8

.field private static final MAX_UPDATE_INTERVAL_MS:I = 0x3e8

.field public static final MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR:I = 0x64

.field private static final PLAYBACK_SPEEDS:[F

.field private static final SETTINGS_AUDIO_TRACK_SELECTION_POSITION:I = 0x1

.field private static final SETTINGS_PLAYBACK_SPEED_POSITION:I


# instance fields
.field private adGroupTimesMs:[J

.field private final audioTrackButton:Landroid/view/View;

.field private final audioTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$AudioTrackSelectionAdapter;

.field private final buttonAlphaDisabled:F

.field private final buttonAlphaEnabled:F

.field private final componentListener:Landroidx/media3/ui/PlayerControlView$ComponentListener;

.field private final controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

.field private currentWindowOffset:J

.field private final durationView:Landroid/widget/TextView;

.field private extraAdGroupTimesMs:[J

.field private extraPlayedAdGroups:[Z

.field private final fastForwardButton:Landroid/view/View;

.field private final fastForwardButtonTextView:Landroid/widget/TextView;

.field private final formatBuilder:Ljava/lang/StringBuilder;

.field private final formatter:Ljava/util/Formatter;

.field private final fullScreenButton:Landroid/widget/ImageView;

.field private final fullScreenEnterContentDescription:Ljava/lang/String;

.field private final fullScreenEnterDrawable:Landroid/graphics/drawable/Drawable;

.field private final fullScreenExitContentDescription:Ljava/lang/String;

.field private final fullScreenExitDrawable:Landroid/graphics/drawable/Drawable;

.field private isAttachedToWindow:Z

.field private isFullScreen:Z

.field private final minimalFullScreenButton:Landroid/widget/ImageView;

.field private multiWindowTimeBar:Z

.field private needToHideBars:Z

.field private final nextButton:Landroid/view/View;

.field private onFullScreenModeChangedListener:Landroidx/media3/ui/PlayerControlView$OnFullScreenModeChangedListener;

.field private final period:Landroidx/media3/common/Timeline$Period;

.field private final playPauseButton:Landroid/view/View;

.field private final playbackSpeedAdapter:Landroidx/media3/ui/PlayerControlView$PlaybackSpeedAdapter;

.field private final playbackSpeedButton:Landroid/view/View;

.field private playedAdGroups:[Z

.field private player:Landroidx/media3/common/Player;

.field private final positionView:Landroid/widget/TextView;

.field private final previousButton:Landroid/view/View;

.field private progressUpdateListener:Landroidx/media3/ui/PlayerControlView$ProgressUpdateListener;

.field private final repeatAllButtonContentDescription:Ljava/lang/String;

.field private final repeatAllButtonDrawable:Landroid/graphics/drawable/Drawable;

.field private final repeatOffButtonContentDescription:Ljava/lang/String;

.field private final repeatOffButtonDrawable:Landroid/graphics/drawable/Drawable;

.field private final repeatOneButtonContentDescription:Ljava/lang/String;

.field private final repeatOneButtonDrawable:Landroid/graphics/drawable/Drawable;

.field private final repeatToggleButton:Landroid/widget/ImageView;

.field private repeatToggleModes:I

.field private final resources:Landroid/content/res/Resources;

.field private final rewindButton:Landroid/view/View;

.field private final rewindButtonTextView:Landroid/widget/TextView;

.field private scrubbing:Z

.field private final settingsAdapter:Landroidx/media3/ui/PlayerControlView$SettingsAdapter;

.field private final settingsButton:Landroid/view/View;

.field private final settingsView:Landroidx/recyclerview/widget/RecyclerView;

.field private final settingsWindow:Landroid/widget/PopupWindow;

.field private final settingsWindowMargin:I

.field private showMultiWindowTimeBar:Z

.field private showPlayButtonIfSuppressed:Z

.field private showTimeoutMs:I

.field private final shuffleButton:Landroid/widget/ImageView;

.field private final shuffleOffButtonDrawable:Landroid/graphics/drawable/Drawable;

.field private final shuffleOffContentDescription:Ljava/lang/String;

.field private final shuffleOnButtonDrawable:Landroid/graphics/drawable/Drawable;

.field private final shuffleOnContentDescription:Ljava/lang/String;

.field private final subtitleButton:Landroid/widget/ImageView;

.field private final subtitleOffButtonDrawable:Landroid/graphics/drawable/Drawable;

.field private final subtitleOffContentDescription:Ljava/lang/String;

.field private final subtitleOnButtonDrawable:Landroid/graphics/drawable/Drawable;

.field private final subtitleOnContentDescription:Ljava/lang/String;

.field private final textTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;

.field private final timeBar:Landroidx/media3/ui/TimeBar;

.field private timeBarMinUpdateIntervalMs:I

.field private final trackNameProvider:Landroidx/media3/ui/TrackNameProvider;

.field private final updateProgressAction:Ljava/lang/Runnable;

.field private final visibilityListeners:Ljava/util/concurrent/CopyOnWriteArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArrayList<",
            "Landroidx/media3/ui/PlayerControlView$VisibilityListener;",
            ">;"
        }
    .end annotation
.end field

.field private final vrButton:Landroid/view/View;

.field private final window:Landroidx/media3/common/Timeline$Window;


# direct methods
.method public static synthetic $r8$lambda$ZXGKgwFyRGfHd0iIfUsKUre8R7s(Landroidx/media3/ui/PlayerControlView;Landroid/view/View;)V
    .locals 0

    invoke-direct {p0, p1}, Landroidx/media3/ui/PlayerControlView;->onFullScreenButtonClicked(Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$dAkA028viszAmqhGna3ibYVChGw(Landroidx/media3/ui/PlayerControlView;Landroid/view/View;IIIIIIII)V
    .locals 0

    invoke-direct/range {p0 .. p9}, Landroidx/media3/ui/PlayerControlView;->onLayoutChange(Landroid/view/View;IIIIIIII)V

    return-void
.end method

.method public static synthetic $r8$lambda$wuaoRbI3ZEpzcYEepD24k7bEp54(Landroidx/media3/ui/PlayerControlView;)V
    .locals 0

    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateProgress()V

    return-void
.end method

.method static constructor <clinit>()V
    .locals 1

    .line 196
    const-string v0, "media3.ui"

    invoke-static {v0}, Landroidx/media3/common/MediaLibraryInfo;->registerModule(Ljava/lang/String;)V

    .line 262
    const/4 v0, 0x7

    new-array v0, v0, [F

    fill-array-data v0, :array_0

    sput-object v0, Landroidx/media3/ui/PlayerControlView;->PLAYBACK_SPEEDS:[F

    return-void

    :array_0
    .array-data 4
        0x3e800000    # 0.25f
        0x3f000000    # 0.5f
        0x3f400000    # 0.75f
        0x3f800000    # 1.0f
        0x3fa00000    # 1.25f
        0x3fc00000    # 1.5f
        0x40000000    # 2.0f
    .end array-data
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 356
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroidx/media3/ui/PlayerControlView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 357
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 360
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroidx/media3/ui/PlayerControlView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 361
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .line 364
    invoke-direct {p0, p1, p2, p3, p2}, Landroidx/media3/ui/PlayerControlView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/util/AttributeSet;)V

    .line 365
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/util/AttributeSet;)V
    .locals 36
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I
    .param p4, "playbackAttrs"    # Landroid/util/AttributeSet;

    .line 381
    move-object/from16 v1, p0

    move-object/from16 v8, p1

    move-object/from16 v9, p4

    invoke-direct/range {p0 .. p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 382
    sget v2, Landroidx/media3/ui/R$layout;->exo_player_control_view:I

    .line 383
    .local v2, "controllerLayoutId":I
    const/4 v0, 0x1

    iput-boolean v0, v1, Landroidx/media3/ui/PlayerControlView;->showPlayButtonIfSuppressed:Z

    .line 384
    const/16 v3, 0x1388

    iput v3, v1, Landroidx/media3/ui/PlayerControlView;->showTimeoutMs:I

    .line 385
    const/4 v10, 0x0

    iput v10, v1, Landroidx/media3/ui/PlayerControlView;->repeatToggleModes:I

    .line 386
    const/16 v3, 0xc8

    iput v3, v1, Landroidx/media3/ui/PlayerControlView;->timeBarMinUpdateIntervalMs:I

    .line 387
    const/4 v3, 0x1

    .line 388
    .local v3, "showRewindButton":Z
    const/4 v4, 0x1

    .line 389
    .local v4, "showFastForwardButton":Z
    const/4 v5, 0x1

    .line 390
    .local v5, "showPreviousButton":Z
    const/4 v6, 0x1

    .line 391
    .local v6, "showNextButton":Z
    const/4 v7, 0x0

    .line 392
    .local v7, "showShuffleButton":Z
    const/4 v11, 0x0

    .line 393
    .local v11, "showSubtitleButton":Z
    const/4 v12, 0x1

    .line 394
    .local v12, "animationEnabled":Z
    const/4 v13, 0x0

    .line 396
    .local v13, "showVrButton":Z
    if-eqz v9, :cond_0

    .line 397
    nop

    .line 399
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v14

    sget-object v15, Landroidx/media3/ui/R$styleable;->PlayerControlView:[I

    .line 400
    move/from16 v8, p3

    invoke-virtual {v14, v9, v15, v8, v10}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v14

    .line 403
    .local v14, "a":Landroid/content/res/TypedArray;
    :try_start_0
    sget v15, Landroidx/media3/ui/R$styleable;->PlayerControlView_controller_layout_id:I

    .line 404
    invoke-virtual {v14, v15, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v15

    move v2, v15

    .line 405
    sget v15, Landroidx/media3/ui/R$styleable;->PlayerControlView_show_timeout:I

    iget v0, v1, Landroidx/media3/ui/PlayerControlView;->showTimeoutMs:I

    invoke-virtual {v14, v15, v0}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    iput v0, v1, Landroidx/media3/ui/PlayerControlView;->showTimeoutMs:I

    .line 406
    iget v0, v1, Landroidx/media3/ui/PlayerControlView;->repeatToggleModes:I

    invoke-static {v14, v0}, Landroidx/media3/ui/PlayerControlView;->getRepeatToggleModes(Landroid/content/res/TypedArray;I)I

    move-result v0

    iput v0, v1, Landroidx/media3/ui/PlayerControlView;->repeatToggleModes:I

    .line 407
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerControlView_show_rewind_button:I

    .line 408
    invoke-virtual {v14, v0, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    move v3, v0

    .line 409
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerControlView_show_fastforward_button:I

    .line 410
    invoke-virtual {v14, v0, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    move v4, v0

    .line 412
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerControlView_show_previous_button:I

    .line 413
    invoke-virtual {v14, v0, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    move v5, v0

    .line 414
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerControlView_show_next_button:I

    .line 415
    invoke-virtual {v14, v0, v6}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    move v6, v0

    .line 416
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerControlView_show_shuffle_button:I

    .line 417
    invoke-virtual {v14, v0, v7}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    move v7, v0

    .line 418
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerControlView_show_subtitle_button:I

    .line 419
    invoke-virtual {v14, v0, v11}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    move v11, v0

    .line 420
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerControlView_show_vr_button:I

    invoke-virtual {v14, v0, v13}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    move v13, v0

    .line 421
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerControlView_time_bar_min_update_interval:I

    iget v15, v1, Landroidx/media3/ui/PlayerControlView;->timeBarMinUpdateIntervalMs:I

    .line 422
    invoke-virtual {v14, v0, v15}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    .line 421
    invoke-virtual {v1, v0}, Landroidx/media3/ui/PlayerControlView;->setTimeBarMinUpdateInterval(I)V

    .line 425
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerControlView_animation_enabled:I

    .line 426
    invoke-virtual {v14, v0, v12}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move v12, v0

    .line 428
    invoke-virtual {v14}, Landroid/content/res/TypedArray;->recycle()V

    .line 429
    move v0, v2

    move v14, v6

    move v15, v7

    move v7, v11

    move v6, v12

    move v11, v3

    move v12, v4

    move/from16 v35, v13

    move v13, v5

    move/from16 v5, v35

    goto :goto_0

    .line 428
    :catchall_0
    move-exception v0

    invoke-virtual {v14}, Landroid/content/res/TypedArray;->recycle()V

    .line 429
    throw v0

    .line 396
    .end local v14    # "a":Landroid/content/res/TypedArray;
    :cond_0
    move/from16 v8, p3

    move v0, v2

    move v14, v6

    move v15, v7

    move v7, v11

    move v6, v12

    move v11, v3

    move v12, v4

    move/from16 v35, v13

    move v13, v5

    move/from16 v5, v35

    .line 432
    .end local v2    # "controllerLayoutId":I
    .end local v3    # "showRewindButton":Z
    .end local v4    # "showFastForwardButton":Z
    .local v0, "controllerLayoutId":I
    .local v5, "showVrButton":Z
    .local v6, "animationEnabled":Z
    .local v7, "showSubtitleButton":Z
    .local v11, "showRewindButton":Z
    .local v12, "showFastForwardButton":Z
    .local v13, "showPreviousButton":Z
    .local v14, "showNextButton":Z
    .local v15, "showShuffleButton":Z
    :goto_0
    invoke-static/range {p1 .. p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 433
    const/high16 v2, 0x40000

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->setDescendantFocusability(I)V

    .line 435
    new-instance v4, Landroidx/media3/ui/PlayerControlView$ComponentListener;

    const/4 v3, 0x0

    invoke-direct {v4, v1, v3}, Landroidx/media3/ui/PlayerControlView$ComponentListener;-><init>(Landroidx/media3/ui/PlayerControlView;Landroidx/media3/ui/PlayerControlView$1;)V

    iput-object v4, v1, Landroidx/media3/ui/PlayerControlView;->componentListener:Landroidx/media3/ui/PlayerControlView$ComponentListener;

    .line 436
    new-instance v2, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v2}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->visibilityListeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    .line 437
    new-instance v2, Landroidx/media3/common/Timeline$Period;

    invoke-direct {v2}, Landroidx/media3/common/Timeline$Period;-><init>()V

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->period:Landroidx/media3/common/Timeline$Period;

    .line 438
    new-instance v2, Landroidx/media3/common/Timeline$Window;

    invoke-direct {v2}, Landroidx/media3/common/Timeline$Window;-><init>()V

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->window:Landroidx/media3/common/Timeline$Window;

    .line 439
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->formatBuilder:Ljava/lang/StringBuilder;

    .line 440
    new-instance v3, Ljava/util/Formatter;

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v10

    invoke-direct {v3, v2, v10}, Ljava/util/Formatter;-><init>(Ljava/lang/Appendable;Ljava/util/Locale;)V

    iput-object v3, v1, Landroidx/media3/ui/PlayerControlView;->formatter:Ljava/util/Formatter;

    .line 441
    const/4 v2, 0x0

    new-array v3, v2, [J

    iput-object v3, v1, Landroidx/media3/ui/PlayerControlView;->adGroupTimesMs:[J

    .line 442
    new-array v3, v2, [Z

    iput-object v3, v1, Landroidx/media3/ui/PlayerControlView;->playedAdGroups:[Z

    .line 443
    new-array v3, v2, [J

    iput-object v3, v1, Landroidx/media3/ui/PlayerControlView;->extraAdGroupTimesMs:[J

    .line 444
    new-array v3, v2, [Z

    iput-object v3, v1, Landroidx/media3/ui/PlayerControlView;->extraPlayedAdGroups:[Z

    .line 445
    new-instance v2, Landroidx/media3/ui/PlayerControlView$$ExternalSyntheticLambda0;

    invoke-direct {v2, v1}, Landroidx/media3/ui/PlayerControlView$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/ui/PlayerControlView;)V

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->updateProgressAction:Ljava/lang/Runnable;

    .line 447
    sget v2, Landroidx/media3/ui/R$id;->exo_duration:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->durationView:Landroid/widget/TextView;

    .line 448
    sget v2, Landroidx/media3/ui/R$id;->exo_position:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->positionView:Landroid/widget/TextView;

    .line 450
    sget v2, Landroidx/media3/ui/R$id;->exo_subtitle:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    move-object v10, v2

    check-cast v10, Landroid/widget/ImageView;

    iput-object v10, v1, Landroidx/media3/ui/PlayerControlView;->subtitleButton:Landroid/widget/ImageView;

    .line 451
    if-eqz v10, :cond_1

    .line 452
    invoke-virtual {v10, v4}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 455
    :cond_1
    sget v2, Landroidx/media3/ui/R$id;->exo_fullscreen:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->fullScreenButton:Landroid/widget/ImageView;

    .line 456
    new-instance v3, Landroidx/media3/ui/PlayerControlView$$ExternalSyntheticLambda1;

    invoke-direct {v3, v1}, Landroidx/media3/ui/PlayerControlView$$ExternalSyntheticLambda1;-><init>(Landroidx/media3/ui/PlayerControlView;)V

    invoke-static {v2, v3}, Landroidx/media3/ui/PlayerControlView;->initializeFullScreenButton(Landroid/view/View;Landroid/view/View$OnClickListener;)V

    .line 457
    sget v2, Landroidx/media3/ui/R$id;->exo_minimal_fullscreen:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->minimalFullScreenButton:Landroid/widget/ImageView;

    .line 458
    new-instance v3, Landroidx/media3/ui/PlayerControlView$$ExternalSyntheticLambda1;

    invoke-direct {v3, v1}, Landroidx/media3/ui/PlayerControlView$$ExternalSyntheticLambda1;-><init>(Landroidx/media3/ui/PlayerControlView;)V

    invoke-static {v2, v3}, Landroidx/media3/ui/PlayerControlView;->initializeFullScreenButton(Landroid/view/View;Landroid/view/View$OnClickListener;)V

    .line 460
    sget v2, Landroidx/media3/ui/R$id;->exo_settings:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->settingsButton:Landroid/view/View;

    .line 461
    if-eqz v2, :cond_2

    .line 462
    invoke-virtual {v2, v4}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 465
    :cond_2
    sget v2, Landroidx/media3/ui/R$id;->exo_playback_speed:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->playbackSpeedButton:Landroid/view/View;

    .line 466
    if-eqz v2, :cond_3

    .line 467
    invoke-virtual {v2, v4}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 470
    :cond_3
    sget v2, Landroidx/media3/ui/R$id;->exo_audio_track:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->audioTrackButton:Landroid/view/View;

    .line 471
    if-eqz v2, :cond_4

    .line 472
    invoke-virtual {v2, v4}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 475
    :cond_4
    sget v2, Landroidx/media3/ui/R$id;->exo_progress:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    move-object v3, v2

    check-cast v3, Landroidx/media3/ui/TimeBar;

    .line 476
    .local v3, "customTimeBar":Landroidx/media3/ui/TimeBar;
    sget v2, Landroidx/media3/ui/R$id;->exo_progress_placeholder:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 477
    .local v2, "timeBarPlaceholder":Landroid/view/View;
    if-eqz v3, :cond_5

    .line 478
    iput-object v3, v1, Landroidx/media3/ui/PlayerControlView;->timeBar:Landroidx/media3/ui/TimeBar;

    move/from16 v24, v0

    move-object/from16 v17, v3

    move-object v0, v4

    move/from16 v25, v5

    move/from16 v26, v6

    move v8, v7

    move-object v4, v2

    const/4 v2, 0x0

    goto :goto_1

    .line 479
    :cond_5
    if-eqz v2, :cond_6

    .line 482
    new-instance v19, Landroidx/media3/ui/DefaultTimeBar;

    const/16 v20, 0x0

    const/16 v21, 0x0

    sget v22, Landroidx/media3/ui/R$style;->ExoStyledControls_TimeBar:I

    move-object/from16 v23, v2

    .end local v2    # "timeBarPlaceholder":Landroid/view/View;
    .local v23, "timeBarPlaceholder":Landroid/view/View;
    move-object/from16 v2, v19

    move-object/from16 v17, v3

    .end local v3    # "customTimeBar":Landroidx/media3/ui/TimeBar;
    .local v17, "customTimeBar":Landroidx/media3/ui/TimeBar;
    move-object/from16 v3, p1

    move/from16 v24, v0

    move-object v0, v4

    .end local v0    # "controllerLayoutId":I
    .local v24, "controllerLayoutId":I
    move-object/from16 v4, v20

    move/from16 v25, v5

    .end local v5    # "showVrButton":Z
    .local v25, "showVrButton":Z
    move/from16 v5, v21

    move/from16 v26, v6

    .end local v6    # "animationEnabled":Z
    .local v26, "animationEnabled":Z
    move-object/from16 v6, p4

    move v8, v7

    .end local v7    # "showSubtitleButton":Z
    .local v8, "showSubtitleButton":Z
    move/from16 v7, v22

    invoke-direct/range {v2 .. v7}, Landroidx/media3/ui/DefaultTimeBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/util/AttributeSet;I)V

    .line 484
    .local v2, "defaultTimeBar":Landroidx/media3/ui/DefaultTimeBar;
    sget v3, Landroidx/media3/ui/R$id;->exo_progress:I

    invoke-virtual {v2, v3}, Landroidx/media3/ui/DefaultTimeBar;->setId(I)V

    .line 485
    invoke-virtual/range {v23 .. v23}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroidx/media3/ui/DefaultTimeBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 486
    invoke-virtual/range {v23 .. v23}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    .line 487
    .local v3, "parent":Landroid/view/ViewGroup;
    move-object/from16 v4, v23

    .end local v23    # "timeBarPlaceholder":Landroid/view/View;
    .local v4, "timeBarPlaceholder":Landroid/view/View;
    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I

    move-result v5

    .line 488
    .local v5, "timeBarIndex":I
    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 489
    invoke-virtual {v3, v2, v5}, Landroid/view/ViewGroup;->addView(Landroid/view/View;I)V

    .line 490
    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->timeBar:Landroidx/media3/ui/TimeBar;

    .line 491
    .end local v2    # "defaultTimeBar":Landroidx/media3/ui/DefaultTimeBar;
    .end local v3    # "parent":Landroid/view/ViewGroup;
    .end local v5    # "timeBarIndex":I
    const/4 v2, 0x0

    goto :goto_1

    .line 492
    .end local v4    # "timeBarPlaceholder":Landroid/view/View;
    .end local v8    # "showSubtitleButton":Z
    .end local v17    # "customTimeBar":Landroidx/media3/ui/TimeBar;
    .end local v24    # "controllerLayoutId":I
    .end local v25    # "showVrButton":Z
    .end local v26    # "animationEnabled":Z
    .restart local v0    # "controllerLayoutId":I
    .local v2, "timeBarPlaceholder":Landroid/view/View;
    .local v3, "customTimeBar":Landroidx/media3/ui/TimeBar;
    .local v5, "showVrButton":Z
    .restart local v6    # "animationEnabled":Z
    .restart local v7    # "showSubtitleButton":Z
    :cond_6
    move/from16 v24, v0

    move-object/from16 v17, v3

    move-object v0, v4

    move/from16 v25, v5

    move/from16 v26, v6

    move v8, v7

    move-object v4, v2

    .end local v0    # "controllerLayoutId":I
    .end local v2    # "timeBarPlaceholder":Landroid/view/View;
    .end local v3    # "customTimeBar":Landroidx/media3/ui/TimeBar;
    .end local v5    # "showVrButton":Z
    .end local v6    # "animationEnabled":Z
    .end local v7    # "showSubtitleButton":Z
    .restart local v4    # "timeBarPlaceholder":Landroid/view/View;
    .restart local v8    # "showSubtitleButton":Z
    .restart local v17    # "customTimeBar":Landroidx/media3/ui/TimeBar;
    .restart local v24    # "controllerLayoutId":I
    .restart local v25    # "showVrButton":Z
    .restart local v26    # "animationEnabled":Z
    const/4 v2, 0x0

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->timeBar:Landroidx/media3/ui/TimeBar;

    .line 494
    :goto_1
    iget-object v3, v1, Landroidx/media3/ui/PlayerControlView;->timeBar:Landroidx/media3/ui/TimeBar;

    if-eqz v3, :cond_7

    .line 495
    invoke-interface {v3, v0}, Landroidx/media3/ui/TimeBar;->addListener(Landroidx/media3/ui/TimeBar$OnScrubListener;)V

    .line 498
    :cond_7
    sget v3, Landroidx/media3/ui/R$id;->exo_play_pause:I

    invoke-virtual {v1, v3}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    iput-object v3, v1, Landroidx/media3/ui/PlayerControlView;->playPauseButton:Landroid/view/View;

    .line 499
    if-eqz v3, :cond_8

    .line 500
    invoke-virtual {v3, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 502
    :cond_8
    sget v3, Landroidx/media3/ui/R$id;->exo_prev:I

    invoke-virtual {v1, v3}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    iput-object v3, v1, Landroidx/media3/ui/PlayerControlView;->previousButton:Landroid/view/View;

    .line 503
    if-eqz v3, :cond_9

    .line 504
    invoke-virtual {v3, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 506
    :cond_9
    sget v5, Landroidx/media3/ui/R$id;->exo_next:I

    invoke-virtual {v1, v5}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v5

    iput-object v5, v1, Landroidx/media3/ui/PlayerControlView;->nextButton:Landroid/view/View;

    .line 507
    if-eqz v5, :cond_a

    .line 508
    invoke-virtual {v5, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 510
    :cond_a
    sget v6, Landroidx/media3/ui/R$font;->roboto_medium_numbers:I

    move-object/from16 v7, p1

    invoke-static {v7, v6}, Landroidx/core/content/res/ResourcesCompat;->getFont(Landroid/content/Context;I)Landroid/graphics/Typeface;

    move-result-object v6

    .line 511
    .local v6, "typeface":Landroid/graphics/Typeface;
    sget v2, Landroidx/media3/ui/R$id;->exo_rew:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 512
    .local v2, "rewButton":Landroid/view/View;
    if-nez v2, :cond_b

    move-object/from16 v23, v4

    .end local v4    # "timeBarPlaceholder":Landroid/view/View;
    .restart local v23    # "timeBarPlaceholder":Landroid/view/View;
    sget v4, Landroidx/media3/ui/R$id;->exo_rew_with_amount:I

    invoke-virtual {v1, v4}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    goto :goto_2

    .end local v23    # "timeBarPlaceholder":Landroid/view/View;
    .restart local v4    # "timeBarPlaceholder":Landroid/view/View;
    :cond_b
    move-object/from16 v23, v4

    .end local v4    # "timeBarPlaceholder":Landroid/view/View;
    .restart local v23    # "timeBarPlaceholder":Landroid/view/View;
    const/4 v4, 0x0

    :goto_2
    iput-object v4, v1, Landroidx/media3/ui/PlayerControlView;->rewindButtonTextView:Landroid/widget/TextView;

    .line 513
    if-eqz v4, :cond_c

    .line 514
    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 516
    :cond_c
    if-nez v2, :cond_d

    goto :goto_3

    :cond_d
    move-object v4, v2

    :goto_3
    iput-object v4, v1, Landroidx/media3/ui/PlayerControlView;->rewindButton:Landroid/view/View;

    .line 517
    if-eqz v4, :cond_e

    .line 518
    invoke-virtual {v4, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 520
    :cond_e
    move-object/from16 v19, v2

    .end local v2    # "rewButton":Landroid/view/View;
    .local v19, "rewButton":Landroid/view/View;
    sget v2, Landroidx/media3/ui/R$id;->exo_ffwd:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 521
    .local v2, "ffwdButton":Landroid/view/View;
    if-nez v2, :cond_f

    sget v9, Landroidx/media3/ui/R$id;->exo_ffwd_with_amount:I

    invoke-virtual {v1, v9}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    goto :goto_4

    :cond_f
    const/4 v9, 0x0

    :goto_4
    iput-object v9, v1, Landroidx/media3/ui/PlayerControlView;->fastForwardButtonTextView:Landroid/widget/TextView;

    .line 522
    if-eqz v9, :cond_10

    .line 523
    invoke-virtual {v9, v6}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 525
    :cond_10
    if-nez v2, :cond_11

    goto :goto_5

    :cond_11
    move-object v9, v2

    :goto_5
    iput-object v9, v1, Landroidx/media3/ui/PlayerControlView;->fastForwardButton:Landroid/view/View;

    .line 526
    if-eqz v9, :cond_12

    .line 527
    invoke-virtual {v9, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 529
    :cond_12
    move-object/from16 v20, v2

    .end local v2    # "ffwdButton":Landroid/view/View;
    .local v20, "ffwdButton":Landroid/view/View;
    sget v2, Landroidx/media3/ui/R$id;->exo_repeat_toggle:I

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    .line 530
    if-eqz v2, :cond_13

    .line 531
    invoke-virtual {v2, v0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 533
    :cond_13
    move-object/from16 v21, v6

    .end local v6    # "typeface":Landroid/graphics/Typeface;
    .local v21, "typeface":Landroid/graphics/Typeface;
    sget v6, Landroidx/media3/ui/R$id;->exo_shuffle:I

    invoke-virtual {v1, v6}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ImageView;

    iput-object v6, v1, Landroidx/media3/ui/PlayerControlView;->shuffleButton:Landroid/widget/ImageView;

    .line 534
    if-eqz v6, :cond_14

    .line 535
    invoke-virtual {v6, v0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 538
    :cond_14
    move-object/from16 v22, v2

    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    iput-object v2, v1, Landroidx/media3/ui/PlayerControlView;->resources:Landroid/content/res/Resources;

    .line 539
    move/from16 v27, v8

    .end local v8    # "showSubtitleButton":Z
    .local v27, "showSubtitleButton":Z
    sget v8, Landroidx/media3/ui/R$integer;->exo_media_button_opacity_percentage_enabled:I

    .line 540
    invoke-virtual {v2, v8}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v8

    int-to-float v8, v8

    const/high16 v28, 0x42c80000    # 100.0f

    div-float v8, v8, v28

    iput v8, v1, Landroidx/media3/ui/PlayerControlView;->buttonAlphaEnabled:F

    .line 541
    sget v8, Landroidx/media3/ui/R$integer;->exo_media_button_opacity_percentage_disabled:I

    .line 542
    invoke-virtual {v2, v8}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v8

    int-to-float v8, v8

    div-float v8, v8, v28

    iput v8, v1, Landroidx/media3/ui/PlayerControlView;->buttonAlphaDisabled:F

    .line 544
    sget v8, Landroidx/media3/ui/R$id;->exo_vr:I

    invoke-virtual {v1, v8}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v8

    iput-object v8, v1, Landroidx/media3/ui/PlayerControlView;->vrButton:Landroid/view/View;

    .line 545
    if-eqz v8, :cond_15

    .line 546
    move-object/from16 v28, v10

    const/4 v10, 0x0

    invoke-direct {v1, v10, v8}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    goto :goto_6

    .line 545
    :cond_15
    move-object/from16 v28, v10

    .line 549
    :goto_6
    new-instance v10, Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-direct {v10, v1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;-><init>(Landroidx/media3/ui/PlayerControlView;)V

    iput-object v10, v1, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    .line 550
    move-object/from16 v29, v8

    move/from16 v8, v26

    .end local v26    # "animationEnabled":Z
    .local v8, "animationEnabled":Z
    invoke-virtual {v10, v8}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setAnimationEnabled(Z)V

    .line 552
    nop

    .end local v8    # "animationEnabled":Z
    .restart local v26    # "animationEnabled":Z
    const/4 v8, 0x2

    move-object/from16 v30, v6

    new-array v6, v8, [Ljava/lang/String;

    .line 553
    .local v6, "settingTexts":[Ljava/lang/String;
    new-array v8, v8, [Landroid/graphics/drawable/Drawable;

    .line 554
    .local v8, "settingIcons":[Landroid/graphics/drawable/Drawable;
    move/from16 v31, v15

    .end local v15    # "showShuffleButton":Z
    .local v31, "showShuffleButton":Z
    sget v15, Landroidx/media3/ui/R$string;->exo_controls_playback_speed:I

    .line 555
    invoke-virtual {v2, v15}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v15

    const/16 v18, 0x0

    aput-object v15, v6, v18

    .line 556
    sget v15, Landroidx/media3/ui/R$drawable;->exo_styled_controls_speed:I

    .line 557
    invoke-static {v7, v2, v15}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v15

    aput-object v15, v8, v18

    .line 558
    sget v15, Landroidx/media3/ui/R$string;->exo_track_selection_title_audio:I

    .line 559
    invoke-virtual {v2, v15}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v15

    const/16 v16, 0x1

    aput-object v15, v6, v16

    .line 560
    sget v15, Landroidx/media3/ui/R$drawable;->exo_styled_controls_audiotrack:I

    .line 561
    invoke-static {v7, v2, v15}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v15

    aput-object v15, v8, v16

    .line 562
    new-instance v15, Landroidx/media3/ui/PlayerControlView$SettingsAdapter;

    invoke-direct {v15, v1, v6, v8}, Landroidx/media3/ui/PlayerControlView$SettingsAdapter;-><init>(Landroidx/media3/ui/PlayerControlView;[Ljava/lang/String;[Landroid/graphics/drawable/Drawable;)V

    iput-object v15, v1, Landroidx/media3/ui/PlayerControlView;->settingsAdapter:Landroidx/media3/ui/PlayerControlView$SettingsAdapter;

    .line 563
    move-object/from16 v32, v6

    .end local v6    # "settingTexts":[Ljava/lang/String;
    .local v32, "settingTexts":[Ljava/lang/String;
    sget v6, Landroidx/media3/ui/R$dimen;->exo_settings_offset:I

    invoke-virtual {v2, v6}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v6

    iput v6, v1, Landroidx/media3/ui/PlayerControlView;->settingsWindowMargin:I

    .line 564
    nop

    .line 566
    invoke-static/range {p1 .. p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v6

    move-object/from16 v33, v8

    .end local v8    # "settingIcons":[Landroid/graphics/drawable/Drawable;
    .local v33, "settingIcons":[Landroid/graphics/drawable/Drawable;
    sget v8, Landroidx/media3/ui/R$layout;->exo_styled_settings_list:I

    .line 567
    move-object/from16 v34, v5

    const/4 v5, 0x0

    invoke-virtual {v6, v8, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroidx/recyclerview/widget/RecyclerView;

    iput-object v6, v1, Landroidx/media3/ui/PlayerControlView;->settingsView:Landroidx/recyclerview/widget/RecyclerView;

    .line 568
    invoke-virtual {v6, v15}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    .line 569
    new-instance v5, Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-virtual/range {p0 .. p0}, Landroidx/media3/ui/PlayerControlView;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-direct {v5, v8}, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v6, v5}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V

    .line 570
    new-instance v5, Landroid/widget/PopupWindow;

    const/4 v8, -0x2

    const/4 v15, 0x1

    invoke-direct {v5, v6, v8, v8, v15}, Landroid/widget/PopupWindow;-><init>(Landroid/view/View;IIZ)V

    iput-object v5, v1, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    .line 572
    sget v6, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v8, 0x17

    if-ge v6, v8, :cond_16

    .line 575
    new-instance v6, Landroid/graphics/drawable/ColorDrawable;

    const/4 v8, 0x0

    invoke-direct {v6, v8}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_7

    .line 572
    :cond_16
    const/4 v8, 0x0

    .line 577
    :goto_7
    invoke-virtual {v5, v0}, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V

    .line 578
    const/4 v0, 0x1

    iput-boolean v0, v1, Landroidx/media3/ui/PlayerControlView;->needToHideBars:Z

    .line 580
    new-instance v0, Landroidx/media3/ui/DefaultTrackNameProvider;

    invoke-virtual/range {p0 .. p0}, Landroidx/media3/ui/PlayerControlView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-direct {v0, v5}, Landroidx/media3/ui/DefaultTrackNameProvider;-><init>(Landroid/content/res/Resources;)V

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->trackNameProvider:Landroidx/media3/ui/TrackNameProvider;

    .line 581
    sget v0, Landroidx/media3/ui/R$drawable;->exo_styled_controls_subtitle_on:I

    .line 582
    invoke-static {v7, v2, v0}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->subtitleOnButtonDrawable:Landroid/graphics/drawable/Drawable;

    .line 583
    sget v0, Landroidx/media3/ui/R$drawable;->exo_styled_controls_subtitle_off:I

    .line 584
    invoke-static {v7, v2, v0}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->subtitleOffButtonDrawable:Landroid/graphics/drawable/Drawable;

    .line 585
    sget v0, Landroidx/media3/ui/R$string;->exo_controls_cc_enabled_description:I

    .line 586
    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->subtitleOnContentDescription:Ljava/lang/String;

    .line 587
    sget v0, Landroidx/media3/ui/R$string;->exo_controls_cc_disabled_description:I

    .line 588
    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->subtitleOffContentDescription:Ljava/lang/String;

    .line 589
    new-instance v0, Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;

    const/4 v5, 0x0

    invoke-direct {v0, v1, v5}, Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;-><init>(Landroidx/media3/ui/PlayerControlView;Landroidx/media3/ui/PlayerControlView$1;)V

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->textTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;

    .line 590
    new-instance v0, Landroidx/media3/ui/PlayerControlView$AudioTrackSelectionAdapter;

    invoke-direct {v0, v1, v5}, Landroidx/media3/ui/PlayerControlView$AudioTrackSelectionAdapter;-><init>(Landroidx/media3/ui/PlayerControlView;Landroidx/media3/ui/PlayerControlView$1;)V

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->audioTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$AudioTrackSelectionAdapter;

    .line 591
    new-instance v0, Landroidx/media3/ui/PlayerControlView$PlaybackSpeedAdapter;

    sget v5, Landroidx/media3/ui/R$array;->exo_controls_playback_speeds:I

    .line 593
    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v5

    sget-object v6, Landroidx/media3/ui/PlayerControlView;->PLAYBACK_SPEEDS:[F

    invoke-direct {v0, v1, v5, v6}, Landroidx/media3/ui/PlayerControlView$PlaybackSpeedAdapter;-><init>(Landroidx/media3/ui/PlayerControlView;[Ljava/lang/String;[F)V

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->playbackSpeedAdapter:Landroidx/media3/ui/PlayerControlView$PlaybackSpeedAdapter;

    .line 595
    sget v0, Landroidx/media3/ui/R$drawable;->exo_styled_controls_fullscreen_exit:I

    .line 596
    invoke-static {v7, v2, v0}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->fullScreenExitDrawable:Landroid/graphics/drawable/Drawable;

    .line 597
    sget v0, Landroidx/media3/ui/R$drawable;->exo_styled_controls_fullscreen_enter:I

    .line 598
    invoke-static {v7, v2, v0}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->fullScreenEnterDrawable:Landroid/graphics/drawable/Drawable;

    .line 599
    sget v0, Landroidx/media3/ui/R$drawable;->exo_styled_controls_repeat_off:I

    .line 600
    invoke-static {v7, v2, v0}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->repeatOffButtonDrawable:Landroid/graphics/drawable/Drawable;

    .line 601
    sget v0, Landroidx/media3/ui/R$drawable;->exo_styled_controls_repeat_one:I

    .line 602
    invoke-static {v7, v2, v0}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->repeatOneButtonDrawable:Landroid/graphics/drawable/Drawable;

    .line 603
    sget v0, Landroidx/media3/ui/R$drawable;->exo_styled_controls_repeat_all:I

    .line 604
    invoke-static {v7, v2, v0}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->repeatAllButtonDrawable:Landroid/graphics/drawable/Drawable;

    .line 605
    sget v0, Landroidx/media3/ui/R$drawable;->exo_styled_controls_shuffle_on:I

    .line 606
    invoke-static {v7, v2, v0}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->shuffleOnButtonDrawable:Landroid/graphics/drawable/Drawable;

    .line 607
    sget v0, Landroidx/media3/ui/R$drawable;->exo_styled_controls_shuffle_off:I

    .line 608
    invoke-static {v7, v2, v0}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->shuffleOffButtonDrawable:Landroid/graphics/drawable/Drawable;

    .line 609
    sget v0, Landroidx/media3/ui/R$string;->exo_controls_fullscreen_exit_description:I

    .line 610
    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->fullScreenExitContentDescription:Ljava/lang/String;

    .line 611
    sget v0, Landroidx/media3/ui/R$string;->exo_controls_fullscreen_enter_description:I

    .line 612
    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->fullScreenEnterContentDescription:Ljava/lang/String;

    .line 613
    sget v0, Landroidx/media3/ui/R$string;->exo_controls_repeat_off_description:I

    .line 614
    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->repeatOffButtonContentDescription:Ljava/lang/String;

    .line 615
    sget v0, Landroidx/media3/ui/R$string;->exo_controls_repeat_one_description:I

    .line 616
    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->repeatOneButtonContentDescription:Ljava/lang/String;

    .line 617
    sget v0, Landroidx/media3/ui/R$string;->exo_controls_repeat_all_description:I

    .line 618
    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->repeatAllButtonContentDescription:Ljava/lang/String;

    .line 619
    sget v0, Landroidx/media3/ui/R$string;->exo_controls_shuffle_on_description:I

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->shuffleOnContentDescription:Ljava/lang/String;

    .line 620
    sget v0, Landroidx/media3/ui/R$string;->exo_controls_shuffle_off_description:I

    .line 621
    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/ui/PlayerControlView;->shuffleOffContentDescription:Ljava/lang/String;

    .line 624
    sget v0, Landroidx/media3/ui/R$id;->exo_bottom_bar:I

    invoke-virtual {v1, v0}, Landroidx/media3/ui/PlayerControlView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 625
    .local v0, "bottomBar":Landroid/view/ViewGroup;
    const/4 v2, 0x1

    invoke-virtual {v10, v0, v2}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 626
    invoke-virtual {v10, v9, v12}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 627
    invoke-virtual {v10, v4, v11}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 628
    invoke-virtual {v10, v3, v13}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 629
    move-object/from16 v3, v34

    invoke-virtual {v10, v3, v14}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 630
    move-object/from16 v6, v30

    move/from16 v3, v31

    .end local v31    # "showShuffleButton":Z
    .local v3, "showShuffleButton":Z
    invoke-virtual {v10, v6, v3}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 631
    move/from16 v5, v27

    move-object/from16 v4, v28

    .end local v27    # "showSubtitleButton":Z
    .local v5, "showSubtitleButton":Z
    invoke-virtual {v10, v4, v5}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 632
    move/from16 v6, v25

    move-object/from16 v4, v29

    .end local v25    # "showVrButton":Z
    .local v6, "showVrButton":Z
    invoke-virtual {v10, v4, v6}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 633
    iget v4, v1, Landroidx/media3/ui/PlayerControlView;->repeatToggleModes:I

    if-eqz v4, :cond_17

    goto :goto_8

    :cond_17
    move v2, v8

    :goto_8
    move-object/from16 v4, v22

    invoke-virtual {v10, v4, v2}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 635
    new-instance v2, Landroidx/media3/ui/PlayerControlView$$ExternalSyntheticLambda2;

    invoke-direct {v2, v1}, Landroidx/media3/ui/PlayerControlView$$ExternalSyntheticLambda2;-><init>(Landroidx/media3/ui/PlayerControlView;)V

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 636
    return-void
.end method

.method static synthetic access$1000(Landroidx/media3/ui/PlayerControlView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateTrackLists()V

    return-void
.end method

.method static synthetic access$1102(Landroidx/media3/ui/PlayerControlView;Z)Z
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;
    .param p1, "x1"    # Z

    .line 193
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerControlView;->scrubbing:Z

    return p1
.end method

.method static synthetic access$1200(Landroidx/media3/ui/PlayerControlView;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->positionView:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$1300(Landroidx/media3/ui/PlayerControlView;)Ljava/lang/StringBuilder;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->formatBuilder:Ljava/lang/StringBuilder;

    return-object v0
.end method

.method static synthetic access$1400(Landroidx/media3/ui/PlayerControlView;)Ljava/util/Formatter;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->formatter:Ljava/util/Formatter;

    return-object v0
.end method

.method static synthetic access$1500(Landroidx/media3/ui/PlayerControlView;)Landroidx/media3/ui/PlayerControlViewLayoutManager;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    return-object v0
.end method

.method static synthetic access$1600(Landroidx/media3/ui/PlayerControlView;)Landroidx/media3/common/Player;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    return-object v0
.end method

.method static synthetic access$1700(Landroidx/media3/ui/PlayerControlView;Landroidx/media3/common/Player;J)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;
    .param p1, "x1"    # Landroidx/media3/common/Player;
    .param p2, "x2"    # J

    .line 193
    invoke-direct {p0, p1, p2, p3}, Landroidx/media3/ui/PlayerControlView;->seekToTimeBarPosition(Landroidx/media3/common/Player;J)V

    return-void
.end method

.method static synthetic access$1800(Landroidx/media3/ui/PlayerControlView;)Z
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->needToHideBars:Z

    return v0
.end method

.method static synthetic access$1900(Landroidx/media3/ui/PlayerControlView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->nextButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$2000(Landroidx/media3/ui/PlayerControlView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->previousButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$2100(Landroidx/media3/ui/PlayerControlView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->fastForwardButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$2200(Landroidx/media3/ui/PlayerControlView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->rewindButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$2300(Landroidx/media3/ui/PlayerControlView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->playPauseButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$2400(Landroidx/media3/ui/PlayerControlView;)Z
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->showPlayButtonIfSuppressed:Z

    return v0
.end method

.method static synthetic access$2500(Landroidx/media3/ui/PlayerControlView;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$2600(Landroidx/media3/ui/PlayerControlView;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget v0, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleModes:I

    return v0
.end method

.method static synthetic access$2700(Landroidx/media3/ui/PlayerControlView;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->shuffleButton:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$2800(Landroidx/media3/ui/PlayerControlView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->settingsButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$2900(Landroidx/media3/ui/PlayerControlView;)Landroidx/media3/ui/PlayerControlView$SettingsAdapter;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->settingsAdapter:Landroidx/media3/ui/PlayerControlView$SettingsAdapter;

    return-object v0
.end method

.method static synthetic access$300(Landroidx/media3/ui/PlayerControlView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updatePlayPauseButton()V

    return-void
.end method

.method static synthetic access$3000(Landroidx/media3/ui/PlayerControlView;Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;
    .param p1, "x1"    # Landroidx/recyclerview/widget/RecyclerView$Adapter;
    .param p2, "x2"    # Landroid/view/View;

    .line 193
    invoke-direct {p0, p1, p2}, Landroidx/media3/ui/PlayerControlView;->displaySettingsWindow(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$3100(Landroidx/media3/ui/PlayerControlView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->playbackSpeedButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$3200(Landroidx/media3/ui/PlayerControlView;)Landroidx/media3/ui/PlayerControlView$PlaybackSpeedAdapter;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->playbackSpeedAdapter:Landroidx/media3/ui/PlayerControlView$PlaybackSpeedAdapter;

    return-object v0
.end method

.method static synthetic access$3300(Landroidx/media3/ui/PlayerControlView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->audioTrackButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$3400(Landroidx/media3/ui/PlayerControlView;)Landroidx/media3/ui/PlayerControlView$AudioTrackSelectionAdapter;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->audioTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$AudioTrackSelectionAdapter;

    return-object v0
.end method

.method static synthetic access$3500(Landroidx/media3/ui/PlayerControlView;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->subtitleButton:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$3600(Landroidx/media3/ui/PlayerControlView;)Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->textTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;

    return-object v0
.end method

.method static synthetic access$400(Landroidx/media3/ui/PlayerControlView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateProgress()V

    return-void
.end method

.method static synthetic access$4000(Landroidx/media3/ui/PlayerControlView;I)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;
    .param p1, "x1"    # I

    .line 193
    invoke-direct {p0, p1}, Landroidx/media3/ui/PlayerControlView;->onSettingViewClicked(I)V

    return-void
.end method

.method static synthetic access$4100(Landroidx/media3/ui/PlayerControlView;F)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;
    .param p1, "x1"    # F

    .line 193
    invoke-direct {p0, p1}, Landroidx/media3/ui/PlayerControlView;->setPlaybackSpeed(F)V

    return-void
.end method

.method static synthetic access$4200(Landroidx/media3/ui/PlayerControlView;)Landroid/widget/PopupWindow;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    return-object v0
.end method

.method static synthetic access$4300(Landroidx/media3/ui/PlayerControlView;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->subtitleOnButtonDrawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method static synthetic access$4400(Landroidx/media3/ui/PlayerControlView;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->subtitleOffButtonDrawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method static synthetic access$4500(Landroidx/media3/ui/PlayerControlView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->subtitleOnContentDescription:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$4600(Landroidx/media3/ui/PlayerControlView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->subtitleOffContentDescription:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Landroidx/media3/ui/PlayerControlView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateRepeatModeButton()V

    return-void
.end method

.method static synthetic access$600(Landroidx/media3/ui/PlayerControlView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateShuffleButton()V

    return-void
.end method

.method static synthetic access$700(Landroidx/media3/ui/PlayerControlView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateNavigation()V

    return-void
.end method

.method static synthetic access$800(Landroidx/media3/ui/PlayerControlView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateTimeline()V

    return-void
.end method

.method static synthetic access$900(Landroidx/media3/ui/PlayerControlView;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerControlView;

    .line 193
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updatePlaybackSpeedList()V

    return-void
.end method

.method private static canShowMultiWindowTimeBar(Landroidx/media3/common/Player;Landroidx/media3/common/Timeline$Window;)Z
    .locals 9
    .param p0, "player"    # Landroidx/media3/common/Player;
    .param p1, "window"    # Landroidx/media3/common/Timeline$Window;

    .line 1583
    const/16 v0, 0x11

    invoke-interface {p0, v0}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 1584
    return v1

    .line 1586
    :cond_0
    invoke-interface {p0}, Landroidx/media3/common/Player;->getCurrentTimeline()Landroidx/media3/common/Timeline;

    move-result-object v0

    .line 1587
    .local v0, "timeline":Landroidx/media3/common/Timeline;
    invoke-virtual {v0}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v2

    .line 1588
    .local v2, "windowCount":I
    const/4 v3, 0x1

    if-le v2, v3, :cond_4

    const/16 v4, 0x64

    if-le v2, v4, :cond_1

    goto :goto_1

    .line 1591
    :cond_1
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v2, :cond_3

    .line 1592
    invoke-virtual {v0, v4, p1}, Landroidx/media3/common/Timeline;->getWindow(ILandroidx/media3/common/Timeline$Window;)Landroidx/media3/common/Timeline$Window;

    move-result-object v5

    iget-wide v5, v5, Landroidx/media3/common/Timeline$Window;->durationUs:J

    const-wide v7, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v5, v5, v7

    if-nez v5, :cond_2

    .line 1593
    return v1

    .line 1591
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 1596
    .end local v4    # "i":I
    :cond_3
    return v3

    .line 1589
    :cond_4
    :goto_1
    return v1
.end method

.method private displaySettingsWindow(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;)V
    .locals 3
    .param p2, "anchorView"    # Landroid/view/View;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/recyclerview/widget/RecyclerView$Adapter<",
            "*>;",
            "Landroid/view/View;",
            ")V"
        }
    .end annotation

    .line 1351
    .local p1, "adapter":Landroidx/recyclerview/widget/RecyclerView$Adapter;, "Landroidx/recyclerview/widget/RecyclerView$Adapter<*>;"
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->settingsView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    .line 1353
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateSettingsWindowSize()V

    .line 1355
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->needToHideBars:Z

    .line 1356
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 1357
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->needToHideBars:Z

    .line 1359
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->getWidth()I

    move-result v0

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v1}, Landroid/widget/PopupWindow;->getWidth()I

    move-result v1

    sub-int/2addr v0, v1

    iget v1, p0, Landroidx/media3/ui/PlayerControlView;->settingsWindowMargin:I

    sub-int/2addr v0, v1

    .line 1360
    .local v0, "xoff":I
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v1}, Landroid/widget/PopupWindow;->getHeight()I

    move-result v1

    neg-int v1, v1

    iget v2, p0, Landroidx/media3/ui/PlayerControlView;->settingsWindowMargin:I

    sub-int/2addr v1, v2

    .line 1362
    .local v1, "yoff":I
    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2, p2, v0, v1}, Landroid/widget/PopupWindow;->showAsDropDown(Landroid/view/View;II)V

    .line 1363
    return-void
.end method

.method private gatherSupportedTrackInfosOfType(Landroidx/media3/common/Tracks;I)Lcom/google/common/collect/ImmutableList;
    .locals 8
    .param p1, "tracks"    # Landroidx/media3/common/Tracks;
    .param p2, "trackType"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/Tracks;",
            "I)",
            "Lcom/google/common/collect/ImmutableList<",
            "Landroidx/media3/ui/PlayerControlView$TrackInformation;",
            ">;"
        }
    .end annotation

    .line 1175
    new-instance v0, Lcom/google/common/collect/ImmutableList$Builder;

    invoke-direct {v0}, Lcom/google/common/collect/ImmutableList$Builder;-><init>()V

    .line 1176
    .local v0, "trackInfos":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Landroidx/media3/ui/PlayerControlView$TrackInformation;>;"
    invoke-virtual {p1}, Landroidx/media3/common/Tracks;->getGroups()Lcom/google/common/collect/ImmutableList;

    move-result-object v1

    .line 1177
    .local v1, "trackGroups":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/Tracks$Group;>;"
    const/4 v2, 0x0

    .local v2, "trackGroupIndex":I
    :goto_0
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_4

    .line 1178
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/common/Tracks$Group;

    .line 1179
    .local v3, "trackGroup":Landroidx/media3/common/Tracks$Group;
    invoke-virtual {v3}, Landroidx/media3/common/Tracks$Group;->getType()I

    move-result v4

    if-eq v4, p2, :cond_0

    .line 1180
    goto :goto_3

    .line 1182
    :cond_0
    const/4 v4, 0x0

    .local v4, "trackIndex":I
    :goto_1
    iget v5, v3, Landroidx/media3/common/Tracks$Group;->length:I

    if-ge v4, v5, :cond_3

    .line 1183
    invoke-virtual {v3, v4}, Landroidx/media3/common/Tracks$Group;->isTrackSupported(I)Z

    move-result v5

    if-nez v5, :cond_1

    .line 1184
    goto :goto_2

    .line 1186
    :cond_1
    invoke-virtual {v3, v4}, Landroidx/media3/common/Tracks$Group;->getTrackFormat(I)Landroidx/media3/common/Format;

    move-result-object v5

    .line 1187
    .local v5, "trackFormat":Landroidx/media3/common/Format;
    iget v6, v5, Landroidx/media3/common/Format;->selectionFlags:I

    and-int/lit8 v6, v6, 0x2

    if-eqz v6, :cond_2

    .line 1188
    goto :goto_2

    .line 1190
    :cond_2
    iget-object v6, p0, Landroidx/media3/ui/PlayerControlView;->trackNameProvider:Landroidx/media3/ui/TrackNameProvider;

    invoke-interface {v6, v5}, Landroidx/media3/ui/TrackNameProvider;->getTrackName(Landroidx/media3/common/Format;)Ljava/lang/String;

    move-result-object v6

    .line 1191
    .local v6, "trackName":Ljava/lang/String;
    new-instance v7, Landroidx/media3/ui/PlayerControlView$TrackInformation;

    invoke-direct {v7, p1, v2, v4, v6}, Landroidx/media3/ui/PlayerControlView$TrackInformation;-><init>(Landroidx/media3/common/Tracks;IILjava/lang/String;)V

    invoke-virtual {v0, v7}, Lcom/google/common/collect/ImmutableList$Builder;->add(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;

    .line 1182
    .end local v5    # "trackFormat":Landroidx/media3/common/Format;
    .end local v6    # "trackName":Ljava/lang/String;
    :goto_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 1177
    .end local v3    # "trackGroup":Landroidx/media3/common/Tracks$Group;
    .end local v4    # "trackIndex":I
    :cond_3
    :goto_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1194
    .end local v2    # "trackGroupIndex":I
    :cond_4
    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableList$Builder;->build()Lcom/google/common/collect/ImmutableList;

    move-result-object v2

    return-object v2
.end method

.method private static getRepeatToggleModes(Landroid/content/res/TypedArray;I)I
    .locals 1
    .param p0, "a"    # Landroid/content/res/TypedArray;
    .param p1, "defaultValue"    # I

    .line 1622
    sget v0, Landroidx/media3/ui/R$styleable;->PlayerControlView_repeat_toggle_modes:I

    invoke-virtual {p0, v0, p1}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    return v0
.end method

.method private initTrackSelectionAdapter()V
    .locals 3

    .line 1157
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->textTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;->clear()V

    .line 1158
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->audioTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$AudioTrackSelectionAdapter;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView$AudioTrackSelectionAdapter;->clear()V

    .line 1159
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    if-eqz v0, :cond_2

    .line 1160
    const/16 v1, 0x1e

    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    .line 1161
    const/16 v1, 0x1d

    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_1

    .line 1164
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    invoke-interface {v0}, Landroidx/media3/common/Player;->getCurrentTracks()Landroidx/media3/common/Tracks;

    move-result-object v0

    .line 1165
    .local v0, "tracks":Landroidx/media3/common/Tracks;
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->audioTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$AudioTrackSelectionAdapter;

    const/4 v2, 0x1

    invoke-direct {p0, v0, v2}, Landroidx/media3/ui/PlayerControlView;->gatherSupportedTrackInfosOfType(Landroidx/media3/common/Tracks;I)Lcom/google/common/collect/ImmutableList;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView$AudioTrackSelectionAdapter;->init(Ljava/util/List;)V

    .line 1166
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->subtitleButton:Landroid/widget/ImageView;

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->getShowButton(Landroid/view/View;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1167
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->textTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;

    const/4 v2, 0x3

    invoke-direct {p0, v0, v2}, Landroidx/media3/ui/PlayerControlView;->gatherSupportedTrackInfosOfType(Landroidx/media3/common/Tracks;I)Lcom/google/common/collect/ImmutableList;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;->init(Ljava/util/List;)V

    goto :goto_0

    .line 1169
    :cond_1
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->textTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;

    invoke-static {}, Lcom/google/common/collect/ImmutableList;->of()Lcom/google/common/collect/ImmutableList;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;->init(Ljava/util/List;)V

    .line 1171
    :goto_0
    return-void

    .line 1162
    .end local v0    # "tracks":Landroidx/media3/common/Tracks;
    :cond_2
    :goto_1
    return-void
.end method

.method private static initializeFullScreenButton(Landroid/view/View;Landroid/view/View$OnClickListener;)V
    .locals 1
    .param p0, "fullScreenButton"    # Landroid/view/View;
    .param p1, "listener"    # Landroid/view/View$OnClickListener;

    .line 1600
    if-nez p0, :cond_0

    .line 1601
    return-void

    .line 1603
    :cond_0
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V

    .line 1604
    invoke-virtual {p0, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1605
    return-void
.end method

.method private static isHandledMediaKey(I)Z
    .locals 1
    .param p0, "keyCode"    # I

    .line 1565
    const/16 v0, 0x5a

    if-eq p0, v0, :cond_1

    const/16 v0, 0x59

    if-eq p0, v0, :cond_1

    const/16 v0, 0x55

    if-eq p0, v0, :cond_1

    const/16 v0, 0x4f

    if-eq p0, v0, :cond_1

    const/16 v0, 0x7e

    if-eq p0, v0, :cond_1

    const/16 v0, 0x7f

    if-eq p0, v0, :cond_1

    const/16 v0, 0x57

    if-eq p0, v0, :cond_1

    const/16 v0, 0x58

    if-ne p0, v0, :cond_0

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

.method private onFullScreenButtonClicked(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .line 1414
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->onFullScreenModeChangedListener:Landroidx/media3/ui/PlayerControlView$OnFullScreenModeChangedListener;

    if-nez v0, :cond_0

    .line 1415
    return-void

    .line 1418
    :cond_0
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->isFullScreen:Z

    xor-int/lit8 v0, v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->isFullScreen:Z

    .line 1419
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->fullScreenButton:Landroid/widget/ImageView;

    invoke-direct {p0, v1, v0}, Landroidx/media3/ui/PlayerControlView;->updateFullScreenButtonForState(Landroid/widget/ImageView;Z)V

    .line 1420
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->minimalFullScreenButton:Landroid/widget/ImageView;

    iget-boolean v1, p0, Landroidx/media3/ui/PlayerControlView;->isFullScreen:Z

    invoke-direct {p0, v0, v1}, Landroidx/media3/ui/PlayerControlView;->updateFullScreenButtonForState(Landroid/widget/ImageView;Z)V

    .line 1421
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->onFullScreenModeChangedListener:Landroidx/media3/ui/PlayerControlView$OnFullScreenModeChangedListener;

    if-eqz v0, :cond_1

    .line 1422
    iget-boolean v1, p0, Landroidx/media3/ui/PlayerControlView;->isFullScreen:Z

    invoke-interface {v0, v1}, Landroidx/media3/ui/PlayerControlView$OnFullScreenModeChangedListener;->onFullScreenModeChanged(Z)V

    .line 1424
    :cond_1
    return-void
.end method

.method private onLayoutChange(Landroid/view/View;IIIIIIII)V
    .locals 13
    .param p1, "v"    # Landroid/view/View;
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I
    .param p6, "oldLeft"    # I
    .param p7, "oldTop"    # I
    .param p8, "oldRight"    # I
    .param p9, "oldBottom"    # I

    .line 1543
    move-object v0, p0

    sub-int v1, p4, p2

    .line 1544
    .local v1, "width":I
    sub-int v2, p5, p3

    .line 1545
    .local v2, "height":I
    sub-int v3, p8, p6

    .line 1546
    .local v3, "oldWidth":I
    sub-int v4, p9, p7

    .line 1548
    .local v4, "oldHeight":I
    if-ne v1, v3, :cond_0

    if-eq v2, v4, :cond_1

    :cond_0
    iget-object v5, v0, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v5}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 1549
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateSettingsWindowSize()V

    .line 1550
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->getWidth()I

    move-result v5

    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v6}, Landroid/widget/PopupWindow;->getWidth()I

    move-result v6

    sub-int/2addr v5, v6

    iget v6, v0, Landroidx/media3/ui/PlayerControlView;->settingsWindowMargin:I

    sub-int/2addr v5, v6

    .line 1551
    .local v5, "xOffset":I
    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v6}, Landroid/widget/PopupWindow;->getHeight()I

    move-result v6

    neg-int v6, v6

    iget v7, v0, Landroidx/media3/ui/PlayerControlView;->settingsWindowMargin:I

    sub-int/2addr v6, v7

    .line 1552
    .local v6, "yOffset":I
    iget-object v7, v0, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    const/4 v11, -0x1

    const/4 v12, -0x1

    move-object v8, p1

    move v9, v5

    move v10, v6

    invoke-virtual/range {v7 .. v12}, Landroid/widget/PopupWindow;->update(Landroid/view/View;IIII)V

    .line 1554
    .end local v5    # "xOffset":I
    .end local v6    # "yOffset":I
    :cond_1
    return-void
.end method

.method private onSettingViewClicked(I)V
    .locals 2
    .param p1, "position"    # I

    .line 1441
    if-nez p1, :cond_0

    .line 1442
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->playbackSpeedAdapter:Landroidx/media3/ui/PlayerControlView$PlaybackSpeedAdapter;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->settingsButton:Landroid/view/View;

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    invoke-direct {p0, v0, v1}, Landroidx/media3/ui/PlayerControlView;->displaySettingsWindow(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;)V

    goto :goto_0

    .line 1443
    :cond_0
    const/4 v0, 0x1

    if-ne p1, v0, :cond_1

    .line 1444
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->audioTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$AudioTrackSelectionAdapter;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->settingsButton:Landroid/view/View;

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    invoke-direct {p0, v0, v1}, Landroidx/media3/ui/PlayerControlView;->displaySettingsWindow(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;)V

    goto :goto_0

    .line 1446
    :cond_1
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 1448
    :goto_0
    return-void
.end method

.method private seekToTimeBarPosition(Landroidx/media3/common/Player;J)V
    .locals 6
    .param p1, "player"    # Landroidx/media3/common/Player;
    .param p2, "positionMs"    # J

    .line 1387
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->multiWindowTimeBar:Z

    if-eqz v0, :cond_2

    .line 1388
    const/16 v0, 0x11

    invoke-interface {p1, v0}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1389
    const/16 v0, 0xa

    invoke-interface {p1, v0}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1390
    invoke-interface {p1}, Landroidx/media3/common/Player;->getCurrentTimeline()Landroidx/media3/common/Timeline;

    move-result-object v0

    .line 1391
    .local v0, "timeline":Landroidx/media3/common/Timeline;
    invoke-virtual {v0}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v1

    .line 1392
    .local v1, "windowCount":I
    const/4 v2, 0x0

    .line 1394
    .local v2, "windowIndex":I
    :goto_0
    iget-object v3, p0, Landroidx/media3/ui/PlayerControlView;->window:Landroidx/media3/common/Timeline$Window;

    invoke-virtual {v0, v2, v3}, Landroidx/media3/common/Timeline;->getWindow(ILandroidx/media3/common/Timeline$Window;)Landroidx/media3/common/Timeline$Window;

    move-result-object v3

    invoke-virtual {v3}, Landroidx/media3/common/Timeline$Window;->getDurationMs()J

    move-result-wide v3

    .line 1395
    .local v3, "windowDurationMs":J
    cmp-long v5, p2, v3

    if-gez v5, :cond_0

    .line 1396
    goto :goto_1

    .line 1397
    :cond_0
    add-int/lit8 v5, v1, -0x1

    if-ne v2, v5, :cond_1

    .line 1399
    move-wide p2, v3

    .line 1400
    nop

    .line 1405
    .end local v3    # "windowDurationMs":J
    :goto_1
    invoke-interface {p1, v2, p2, p3}, Landroidx/media3/common/Player;->seekTo(IJ)V

    .line 1406
    .end local v0    # "timeline":Landroidx/media3/common/Timeline;
    .end local v1    # "windowCount":I
    .end local v2    # "windowIndex":I
    goto :goto_2

    .line 1402
    .restart local v0    # "timeline":Landroidx/media3/common/Timeline;
    .restart local v1    # "windowCount":I
    .restart local v2    # "windowIndex":I
    .restart local v3    # "windowDurationMs":J
    :cond_1
    sub-long/2addr p2, v3

    .line 1403
    nop

    .end local v3    # "windowDurationMs":J
    add-int/lit8 v2, v2, 0x1

    .line 1404
    goto :goto_0

    .line 1407
    .end local v0    # "timeline":Landroidx/media3/common/Timeline;
    .end local v1    # "windowCount":I
    .end local v2    # "windowIndex":I
    :cond_2
    const/4 v0, 0x5

    invoke-interface {p1, v0}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1408
    invoke-interface {p1, p2, p3}, Landroidx/media3/common/Player;->seekTo(J)V

    .line 1410
    :cond_3
    :goto_2
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateProgress()V

    .line 1411
    return-void
.end method

.method private setPlaybackSpeed(F)V
    .locals 2
    .param p1, "speed"    # F

    .line 1366
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    if-eqz v0, :cond_1

    const/16 v1, 0xd

    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_0

    .line 1369
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    invoke-interface {v0}, Landroidx/media3/common/Player;->getPlaybackParameters()Landroidx/media3/common/PlaybackParameters;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroidx/media3/common/PlaybackParameters;->withSpeed(F)Landroidx/media3/common/PlaybackParameters;

    move-result-object v1

    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->setPlaybackParameters(Landroidx/media3/common/PlaybackParameters;)V

    .line 1370
    return-void

    .line 1367
    :cond_1
    :goto_0
    return-void
.end method

.method private shouldEnablePlayPauseButton()Z
    .locals 3

    .line 1557
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    if-eqz v0, :cond_1

    .line 1558
    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    .line 1559
    const/16 v2, 0x11

    invoke-interface {v0, v2}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    .line 1560
    invoke-interface {v0}, Landroidx/media3/common/Player;->getCurrentTimeline()Landroidx/media3/common/Timeline;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/common/Timeline;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    goto :goto_0

    :cond_1
    const/4 v1, 0x0

    .line 1557
    :goto_0
    return v1
.end method

.method private updateButton(ZLandroid/view/View;)V
    .locals 1
    .param p1, "enabled"    # Z
    .param p2, "view"    # Landroid/view/View;

    .line 1379
    if-nez p2, :cond_0

    .line 1380
    return-void

    .line 1382
    :cond_0
    invoke-virtual {p2, p1}, Landroid/view/View;->setEnabled(Z)V

    .line 1383
    if-eqz p1, :cond_1

    iget v0, p0, Landroidx/media3/ui/PlayerControlView;->buttonAlphaEnabled:F

    goto :goto_0

    :cond_1
    iget v0, p0, Landroidx/media3/ui/PlayerControlView;->buttonAlphaDisabled:F

    :goto_0
    invoke-virtual {p2, v0}, Landroid/view/View;->setAlpha(F)V

    .line 1384
    return-void
.end method

.method private updateFastForwardButton()V
    .locals 7

    .line 1076
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroidx/media3/common/Player;->getSeekForwardIncrement()J

    move-result-wide v0

    goto :goto_0

    :cond_0
    const-wide/16 v0, 0x3a98

    .line 1077
    .local v0, "fastForwardMs":J
    :goto_0
    const-wide/16 v2, 0x3e8

    div-long v2, v0, v2

    long-to-int v2, v2

    .line 1078
    .local v2, "fastForwardSec":I
    iget-object v3, p0, Landroidx/media3/ui/PlayerControlView;->fastForwardButtonTextView:Landroid/widget/TextView;

    if-eqz v3, :cond_1

    .line 1079
    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1081
    :cond_1
    iget-object v3, p0, Landroidx/media3/ui/PlayerControlView;->fastForwardButton:Landroid/view/View;

    if-eqz v3, :cond_2

    .line 1082
    iget-object v4, p0, Landroidx/media3/ui/PlayerControlView;->resources:Landroid/content/res/Resources;

    sget v5, Landroidx/media3/ui/R$plurals;->exo_controls_fastforward_by_amount_description:I

    .line 1086
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    filled-new-array {v6}, [Ljava/lang/Object;

    move-result-object v6

    .line 1083
    invoke-virtual {v4, v5, v2, v6}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 1082
    invoke-virtual {v3, v4}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1088
    :cond_2
    return-void
.end method

.method private updateFullScreenButtonForState(Landroid/widget/ImageView;Z)V
    .locals 1
    .param p1, "fullScreenButton"    # Landroid/widget/ImageView;
    .param p2, "isFullScreen"    # Z

    .line 1428
    if-nez p1, :cond_0

    .line 1429
    return-void

    .line 1431
    :cond_0
    if-eqz p2, :cond_1

    .line 1432
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->fullScreenExitDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1433
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->fullScreenExitContentDescription:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 1435
    :cond_1
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->fullScreenEnterDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1436
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->fullScreenEnterContentDescription:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1438
    :goto_0
    return-void
.end method

.method private static updateFullScreenButtonVisibility(Landroid/view/View;Z)V
    .locals 1
    .param p0, "fullScreenButton"    # Landroid/view/View;
    .param p1, "visible"    # Z

    .line 1609
    if-nez p0, :cond_0

    .line 1610
    return-void

    .line 1612
    :cond_0
    if-eqz p1, :cond_1

    .line 1613
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 1615
    :cond_1
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V

    .line 1617
    :goto_0
    return-void
.end method

.method private updateNavigation()V
    .locals 7

    .line 1023
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_6

    iget-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->isAttachedToWindow:Z

    if-nez v0, :cond_0

    goto :goto_1

    .line 1027
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    .line 1028
    .local v0, "player":Landroidx/media3/common/Player;
    const/4 v1, 0x0

    .line 1029
    .local v1, "enableSeeking":Z
    const/4 v2, 0x0

    .line 1030
    .local v2, "enablePrevious":Z
    const/4 v3, 0x0

    .line 1031
    .local v3, "enableRewind":Z
    const/4 v4, 0x0

    .line 1032
    .local v4, "enableFastForward":Z
    const/4 v5, 0x0

    .line 1033
    .local v5, "enableNext":Z
    if-eqz v0, :cond_2

    .line 1035
    iget-boolean v6, p0, Landroidx/media3/ui/PlayerControlView;->showMultiWindowTimeBar:Z

    if-eqz v6, :cond_1

    iget-object v6, p0, Landroidx/media3/ui/PlayerControlView;->window:Landroidx/media3/common/Timeline$Window;

    invoke-static {v0, v6}, Landroidx/media3/ui/PlayerControlView;->canShowMultiWindowTimeBar(Landroidx/media3/common/Player;Landroidx/media3/common/Timeline$Window;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1036
    const/16 v6, 0xa

    invoke-interface {v0, v6}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v6

    goto :goto_0

    .line 1037
    :cond_1
    const/4 v6, 0x5

    invoke-interface {v0, v6}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v6

    :goto_0
    move v1, v6

    .line 1038
    const/4 v6, 0x7

    invoke-interface {v0, v6}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v2

    .line 1039
    const/16 v6, 0xb

    invoke-interface {v0, v6}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v3

    .line 1040
    const/16 v6, 0xc

    invoke-interface {v0, v6}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v4

    .line 1041
    const/16 v6, 0x9

    invoke-interface {v0, v6}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v5

    .line 1044
    :cond_2
    if-eqz v3, :cond_3

    .line 1045
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateRewindButton()V

    .line 1047
    :cond_3
    if-eqz v4, :cond_4

    .line 1048
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateFastForwardButton()V

    .line 1051
    :cond_4
    iget-object v6, p0, Landroidx/media3/ui/PlayerControlView;->previousButton:Landroid/view/View;

    invoke-direct {p0, v2, v6}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 1052
    iget-object v6, p0, Landroidx/media3/ui/PlayerControlView;->rewindButton:Landroid/view/View;

    invoke-direct {p0, v3, v6}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 1053
    iget-object v6, p0, Landroidx/media3/ui/PlayerControlView;->fastForwardButton:Landroid/view/View;

    invoke-direct {p0, v4, v6}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 1054
    iget-object v6, p0, Landroidx/media3/ui/PlayerControlView;->nextButton:Landroid/view/View;

    invoke-direct {p0, v5, v6}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 1055
    iget-object v6, p0, Landroidx/media3/ui/PlayerControlView;->timeBar:Landroidx/media3/ui/TimeBar;

    if-eqz v6, :cond_5

    .line 1056
    invoke-interface {v6, v1}, Landroidx/media3/ui/TimeBar;->setEnabled(Z)V

    .line 1058
    :cond_5
    return-void

    .line 1024
    .end local v0    # "player":Landroidx/media3/common/Player;
    .end local v1    # "enableSeeking":Z
    .end local v2    # "enablePrevious":Z
    .end local v3    # "enableRewind":Z
    .end local v4    # "enableFastForward":Z
    .end local v5    # "enableNext":Z
    :cond_6
    :goto_1
    return-void
.end method

.method private updatePlayPauseButton()V
    .locals 6

    .line 998
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_4

    iget-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->isAttachedToWindow:Z

    if-nez v0, :cond_0

    goto :goto_2

    .line 1001
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->playPauseButton:Landroid/view/View;

    if-eqz v0, :cond_3

    .line 1002
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    iget-boolean v1, p0, Landroidx/media3/ui/PlayerControlView;->showPlayButtonIfSuppressed:Z

    invoke-static {v0, v1}, Landroidx/media3/common/util/Util;->shouldShowPlayButton(Landroidx/media3/common/Player;Z)Z

    move-result v0

    .line 1005
    .local v0, "shouldShowPlayButton":Z
    if-eqz v0, :cond_1

    .line 1006
    sget v1, Landroidx/media3/ui/R$drawable;->exo_styled_controls_play:I

    goto :goto_0

    .line 1007
    :cond_1
    sget v1, Landroidx/media3/ui/R$drawable;->exo_styled_controls_pause:I

    :goto_0
    nop

    .line 1010
    .local v1, "drawableRes":I
    if-eqz v0, :cond_2

    .line 1011
    sget v2, Landroidx/media3/ui/R$string;->exo_controls_play_description:I

    goto :goto_1

    .line 1012
    :cond_2
    sget v2, Landroidx/media3/ui/R$string;->exo_controls_pause_description:I

    :goto_1
    nop

    .line 1013
    .local v2, "stringRes":I
    iget-object v3, p0, Landroidx/media3/ui/PlayerControlView;->playPauseButton:Landroid/view/View;

    check-cast v3, Landroid/widget/ImageView;

    .line 1014
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->getContext()Landroid/content/Context;

    move-result-object v4

    iget-object v5, p0, Landroidx/media3/ui/PlayerControlView;->resources:Landroid/content/res/Resources;

    invoke-static {v4, v5, v1}, Landroidx/media3/common/util/Util;->getDrawable(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1015
    iget-object v3, p0, Landroidx/media3/ui/PlayerControlView;->playPauseButton:Landroid/view/View;

    iget-object v4, p0, Landroidx/media3/ui/PlayerControlView;->resources:Landroid/content/res/Resources;

    invoke-virtual {v4, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1017
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->shouldEnablePlayPauseButton()Z

    move-result v3

    .line 1018
    .local v3, "enablePlayPause":Z
    iget-object v4, p0, Landroidx/media3/ui/PlayerControlView;->playPauseButton:Landroid/view/View;

    invoke-direct {p0, v3, v4}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 1020
    .end local v0    # "shouldShowPlayButton":Z
    .end local v1    # "drawableRes":I
    .end local v2    # "stringRes":I
    .end local v3    # "enablePlayPause":Z
    :cond_3
    return-void

    .line 999
    :cond_4
    :goto_2
    return-void
.end method

.method private updatePlaybackSpeedList()V
    .locals 3

    .line 1323
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    if-nez v0, :cond_0

    .line 1324
    return-void

    .line 1326
    :cond_0
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->playbackSpeedAdapter:Landroidx/media3/ui/PlayerControlView$PlaybackSpeedAdapter;

    invoke-interface {v0}, Landroidx/media3/common/Player;->getPlaybackParameters()Landroidx/media3/common/PlaybackParameters;

    move-result-object v0

    iget v0, v0, Landroidx/media3/common/PlaybackParameters;->speed:F

    invoke-virtual {v1, v0}, Landroidx/media3/ui/PlayerControlView$PlaybackSpeedAdapter;->updateSelectedIndex(F)V

    .line 1327
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->settingsAdapter:Landroidx/media3/ui/PlayerControlView$SettingsAdapter;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->playbackSpeedAdapter:Landroidx/media3/ui/PlayerControlView$PlaybackSpeedAdapter;

    .line 1328
    invoke-virtual {v1}, Landroidx/media3/ui/PlayerControlView$PlaybackSpeedAdapter;->getSelectedText()Ljava/lang/String;

    move-result-object v1

    .line 1327
    const/4 v2, 0x0

    invoke-virtual {v0, v2, v1}, Landroidx/media3/ui/PlayerControlView$SettingsAdapter;->setSubTextAtPosition(ILjava/lang/String;)V

    .line 1329
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateSettingsButton()V

    .line 1330
    return-void
.end method

.method private updateProgress()V
    .locals 20

    .line 1277
    move-object/from16 v0, p0

    invoke-virtual/range {p0 .. p0}, Landroidx/media3/ui/PlayerControlView;->isVisible()Z

    move-result v1

    if-eqz v1, :cond_a

    iget-boolean v1, v0, Landroidx/media3/ui/PlayerControlView;->isAttachedToWindow:Z

    if-nez v1, :cond_0

    goto/16 :goto_4

    .line 1280
    :cond_0
    iget-object v1, v0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    .line 1281
    .local v1, "player":Landroidx/media3/common/Player;
    const-wide/16 v2, 0x0

    .line 1282
    .local v2, "position":J
    const-wide/16 v4, 0x0

    .line 1283
    .local v4, "bufferedPosition":J
    if-eqz v1, :cond_1

    const/16 v6, 0x10

    invoke-interface {v1, v6}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1284
    iget-wide v6, v0, Landroidx/media3/ui/PlayerControlView;->currentWindowOffset:J

    invoke-interface {v1}, Landroidx/media3/common/Player;->getContentPosition()J

    move-result-wide v8

    add-long v2, v6, v8

    .line 1285
    iget-wide v6, v0, Landroidx/media3/ui/PlayerControlView;->currentWindowOffset:J

    invoke-interface {v1}, Landroidx/media3/common/Player;->getContentBufferedPosition()J

    move-result-wide v8

    add-long v4, v6, v8

    .line 1287
    :cond_1
    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->positionView:Landroid/widget/TextView;

    if-eqz v6, :cond_2

    iget-boolean v7, v0, Landroidx/media3/ui/PlayerControlView;->scrubbing:Z

    if-nez v7, :cond_2

    .line 1288
    iget-object v7, v0, Landroidx/media3/ui/PlayerControlView;->formatBuilder:Ljava/lang/StringBuilder;

    iget-object v8, v0, Landroidx/media3/ui/PlayerControlView;->formatter:Ljava/util/Formatter;

    invoke-static {v7, v8, v2, v3}, Landroidx/media3/common/util/Util;->getStringForTime(Ljava/lang/StringBuilder;Ljava/util/Formatter;J)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1290
    :cond_2
    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->timeBar:Landroidx/media3/ui/TimeBar;

    if-eqz v6, :cond_3

    .line 1291
    invoke-interface {v6, v2, v3}, Landroidx/media3/ui/TimeBar;->setPosition(J)V

    .line 1292
    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->timeBar:Landroidx/media3/ui/TimeBar;

    invoke-interface {v6, v4, v5}, Landroidx/media3/ui/TimeBar;->setBufferedPosition(J)V

    .line 1294
    :cond_3
    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->progressUpdateListener:Landroidx/media3/ui/PlayerControlView$ProgressUpdateListener;

    if-eqz v6, :cond_4

    .line 1295
    invoke-interface {v6, v2, v3, v4, v5}, Landroidx/media3/ui/PlayerControlView$ProgressUpdateListener;->onProgressUpdate(JJ)V

    .line 1299
    :cond_4
    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->updateProgressAction:Ljava/lang/Runnable;

    invoke-virtual {v0, v6}, Landroidx/media3/ui/PlayerControlView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1300
    const/4 v6, 0x1

    if-nez v1, :cond_5

    move v7, v6

    goto :goto_0

    :cond_5
    invoke-interface {v1}, Landroidx/media3/common/Player;->getPlaybackState()I

    move-result v7

    .line 1301
    .local v7, "playbackState":I
    :goto_0
    const-wide/16 v8, 0x3e8

    if-eqz v1, :cond_8

    invoke-interface {v1}, Landroidx/media3/common/Player;->isPlaying()Z

    move-result v10

    if-eqz v10, :cond_8

    .line 1303
    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->timeBar:Landroidx/media3/ui/TimeBar;

    if-eqz v6, :cond_6

    invoke-interface {v6}, Landroidx/media3/ui/TimeBar;->getPreferredUpdateDelay()J

    move-result-wide v10

    goto :goto_1

    :cond_6
    move-wide v10, v8

    .line 1306
    .local v10, "mediaTimeDelayMs":J
    :goto_1
    rem-long v12, v2, v8

    sub-long v12, v8, v12

    .line 1307
    .local v12, "mediaTimeUntilNextFullSecondMs":J
    invoke-static {v10, v11, v12, v13}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v10

    .line 1310
    invoke-interface {v1}, Landroidx/media3/common/Player;->getPlaybackParameters()Landroidx/media3/common/PlaybackParameters;

    move-result-object v6

    iget v6, v6, Landroidx/media3/common/PlaybackParameters;->speed:F

    .line 1312
    .local v6, "playbackSpeed":F
    const/4 v14, 0x0

    cmpl-float v14, v6, v14

    if-lez v14, :cond_7

    long-to-float v8, v10

    div-float/2addr v8, v6

    float-to-long v8, v8

    :cond_7
    move-wide v14, v8

    .line 1315
    .local v14, "delayMs":J
    iget v8, v0, Landroidx/media3/ui/PlayerControlView;->timeBarMinUpdateIntervalMs:I

    int-to-long v8, v8

    const-wide/16 v18, 0x3e8

    move-wide/from16 v16, v8

    invoke-static/range {v14 .. v19}, Landroidx/media3/common/util/Util;->constrainValue(JJJ)J

    move-result-wide v8

    .line 1316
    .end local v14    # "delayMs":J
    .local v8, "delayMs":J
    iget-object v14, v0, Landroidx/media3/ui/PlayerControlView;->updateProgressAction:Ljava/lang/Runnable;

    invoke-virtual {v0, v14, v8, v9}, Landroidx/media3/ui/PlayerControlView;->postDelayed(Ljava/lang/Runnable;J)Z

    .end local v6    # "playbackSpeed":F
    .end local v8    # "delayMs":J
    .end local v10    # "mediaTimeDelayMs":J
    .end local v12    # "mediaTimeUntilNextFullSecondMs":J
    goto :goto_2

    .line 1317
    :cond_8
    const/4 v10, 0x4

    if-eq v7, v10, :cond_9

    if-eq v7, v6, :cond_9

    .line 1318
    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->updateProgressAction:Ljava/lang/Runnable;

    invoke-virtual {v0, v6, v8, v9}, Landroidx/media3/ui/PlayerControlView;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_3

    .line 1317
    :cond_9
    :goto_2
    nop

    .line 1320
    :goto_3
    return-void

    .line 1278
    .end local v1    # "player":Landroidx/media3/common/Player;
    .end local v2    # "position":J
    .end local v4    # "bufferedPosition":J
    .end local v7    # "playbackState":I
    :cond_a
    :goto_4
    return-void
.end method

.method private updateRepeatModeButton()V
    .locals 3

    .line 1091
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_4

    iget-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->isAttachedToWindow:Z

    if-eqz v0, :cond_4

    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    if-nez v0, :cond_0

    goto :goto_2

    .line 1095
    :cond_0
    iget v1, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleModes:I

    const/4 v2, 0x0

    if-nez v1, :cond_1

    .line 1096
    invoke-direct {p0, v2, v0}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 1097
    return-void

    .line 1100
    :cond_1
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    .line 1101
    .local v0, "player":Landroidx/media3/common/Player;
    if-eqz v0, :cond_3

    const/16 v1, 0xf

    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v1

    if-nez v1, :cond_2

    goto :goto_1

    .line 1108
    :cond_2
    const/4 v1, 0x1

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    invoke-direct {p0, v1, v2}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 1109
    invoke-interface {v0}, Landroidx/media3/common/Player;->getRepeatMode()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 1119
    :pswitch_0
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->repeatAllButtonDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1120
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->repeatAllButtonContentDescription:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1121
    goto :goto_0

    .line 1115
    :pswitch_1
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->repeatOneButtonDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1116
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->repeatOneButtonContentDescription:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1117
    goto :goto_0

    .line 1111
    :pswitch_2
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->repeatOffButtonDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1112
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->repeatOffButtonContentDescription:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1113
    nop

    .line 1125
    :goto_0
    return-void

    .line 1102
    :cond_3
    :goto_1
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    invoke-direct {p0, v2, v1}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 1103
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->repeatOffButtonDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1104
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->repeatOffButtonContentDescription:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1105
    return-void

    .line 1092
    .end local v0    # "player":Landroidx/media3/common/Player;
    :cond_4
    :goto_2
    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private updateRewindButton()V
    .locals 7

    .line 1062
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroidx/media3/common/Player;->getSeekBackIncrement()J

    move-result-wide v0

    goto :goto_0

    :cond_0
    const-wide/16 v0, 0x1388

    .line 1063
    .local v0, "rewindMs":J
    :goto_0
    const-wide/16 v2, 0x3e8

    div-long v2, v0, v2

    long-to-int v2, v2

    .line 1064
    .local v2, "rewindSec":I
    iget-object v3, p0, Landroidx/media3/ui/PlayerControlView;->rewindButtonTextView:Landroid/widget/TextView;

    if-eqz v3, :cond_1

    .line 1065
    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1067
    :cond_1
    iget-object v3, p0, Landroidx/media3/ui/PlayerControlView;->rewindButton:Landroid/view/View;

    if-eqz v3, :cond_2

    .line 1068
    iget-object v4, p0, Landroidx/media3/ui/PlayerControlView;->resources:Landroid/content/res/Resources;

    sget v5, Landroidx/media3/ui/R$plurals;->exo_controls_rewind_by_amount_description:I

    .line 1070
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    filled-new-array {v6}, [Ljava/lang/Object;

    move-result-object v6

    .line 1069
    invoke-virtual {v4, v5, v2, v6}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 1068
    invoke-virtual {v3, v4}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1072
    :cond_2
    return-void
.end method

.method private updateSettingsButton()V
    .locals 2

    .line 1333
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->settingsAdapter:Landroidx/media3/ui/PlayerControlView$SettingsAdapter;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView$SettingsAdapter;->hasSettingsToShow()Z

    move-result v0

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->settingsButton:Landroid/view/View;

    invoke-direct {p0, v0, v1}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 1334
    return-void
.end method

.method private updateSettingsWindowSize()V
    .locals 7

    .line 1337
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->settingsView:Landroidx/recyclerview/widget/RecyclerView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, v1}, Landroidx/recyclerview/widget/RecyclerView;->measure(II)V

    .line 1339
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->getWidth()I

    move-result v0

    iget v1, p0, Landroidx/media3/ui/PlayerControlView;->settingsWindowMargin:I

    mul-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    .line 1340
    .local v0, "maxWidth":I
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->settingsView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v1}, Landroidx/recyclerview/widget/RecyclerView;->getMeasuredWidth()I

    move-result v1

    .line 1341
    .local v1, "itemWidth":I
    invoke-static {v1, v0}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 1342
    .local v2, "width":I
    iget-object v3, p0, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v3, v2}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 1344
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->getHeight()I

    move-result v3

    iget v4, p0, Landroidx/media3/ui/PlayerControlView;->settingsWindowMargin:I

    mul-int/lit8 v4, v4, 0x2

    sub-int/2addr v3, v4

    .line 1345
    .local v3, "maxHeight":I
    iget-object v4, p0, Landroidx/media3/ui/PlayerControlView;->settingsView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v4}, Landroidx/recyclerview/widget/RecyclerView;->getMeasuredHeight()I

    move-result v4

    .line 1346
    .local v4, "totalHeight":I
    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 1347
    .local v5, "height":I
    iget-object v6, p0, Landroidx/media3/ui/PlayerControlView;->settingsWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v6, v5}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 1348
    return-void
.end method

.method private updateShuffleButton()V
    .locals 3

    .line 1128
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_6

    iget-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->isAttachedToWindow:Z

    if-eqz v0, :cond_6

    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->shuffleButton:Landroid/widget/ImageView;

    if-nez v0, :cond_0

    goto :goto_4

    .line 1132
    :cond_0
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    .line 1133
    .local v1, "player":Landroidx/media3/common/Player;
    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-virtual {v2, v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->getShowButton(Landroid/view/View;)Z

    move-result v0

    const/4 v2, 0x0

    if-nez v0, :cond_1

    .line 1134
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->shuffleButton:Landroid/widget/ImageView;

    invoke-direct {p0, v2, v0}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    goto :goto_3

    .line 1135
    :cond_1
    if-eqz v1, :cond_5

    const/16 v0, 0xe

    invoke-interface {v1, v0}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-nez v0, :cond_2

    goto :goto_2

    .line 1140
    :cond_2
    const/4 v0, 0x1

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->shuffleButton:Landroid/widget/ImageView;

    invoke-direct {p0, v0, v2}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 1141
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->shuffleButton:Landroid/widget/ImageView;

    .line 1142
    invoke-interface {v1}, Landroidx/media3/common/Player;->getShuffleModeEnabled()Z

    move-result v2

    if-eqz v2, :cond_3

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->shuffleOnButtonDrawable:Landroid/graphics/drawable/Drawable;

    goto :goto_0

    :cond_3
    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->shuffleOffButtonDrawable:Landroid/graphics/drawable/Drawable;

    .line 1141
    :goto_0
    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1143
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->shuffleButton:Landroid/widget/ImageView;

    .line 1144
    invoke-interface {v1}, Landroidx/media3/common/Player;->getShuffleModeEnabled()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1145
    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->shuffleOnContentDescription:Ljava/lang/String;

    goto :goto_1

    .line 1146
    :cond_4
    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->shuffleOffContentDescription:Ljava/lang/String;

    .line 1143
    :goto_1
    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_3

    .line 1136
    :cond_5
    :goto_2
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->shuffleButton:Landroid/widget/ImageView;

    invoke-direct {p0, v2, v0}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 1137
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->shuffleButton:Landroid/widget/ImageView;

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->shuffleOffButtonDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1138
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->shuffleButton:Landroid/widget/ImageView;

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlView;->shuffleOffContentDescription:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1148
    :goto_3
    return-void

    .line 1129
    .end local v1    # "player":Landroidx/media3/common/Player;
    :cond_6
    :goto_4
    return-void
.end method

.method private updateTimeline()V
    .locals 27

    .line 1198
    move-object/from16 v0, p0

    iget-object v1, v0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    .line 1199
    .local v1, "player":Landroidx/media3/common/Player;
    if-nez v1, :cond_0

    .line 1200
    return-void

    .line 1202
    :cond_0
    iget-boolean v2, v0, Landroidx/media3/ui/PlayerControlView;->showMultiWindowTimeBar:Z

    const/4 v4, 0x1

    if-eqz v2, :cond_1

    iget-object v2, v0, Landroidx/media3/ui/PlayerControlView;->window:Landroidx/media3/common/Timeline$Window;

    invoke-static {v1, v2}, Landroidx/media3/ui/PlayerControlView;->canShowMultiWindowTimeBar(Landroidx/media3/common/Player;Landroidx/media3/common/Timeline$Window;)Z

    move-result v2

    if-eqz v2, :cond_1

    move v2, v4

    goto :goto_0

    :cond_1
    const/4 v2, 0x0

    :goto_0
    iput-boolean v2, v0, Landroidx/media3/ui/PlayerControlView;->multiWindowTimeBar:Z

    .line 1203
    const-wide/16 v5, 0x0

    iput-wide v5, v0, Landroidx/media3/ui/PlayerControlView;->currentWindowOffset:J

    .line 1204
    const-wide/16 v7, 0x0

    .line 1205
    .local v7, "durationUs":J
    const/4 v2, 0x0

    .line 1207
    .local v2, "adGroupCount":I
    const/16 v9, 0x11

    invoke-interface {v1, v9}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 1208
    invoke-interface {v1}, Landroidx/media3/common/Player;->getCurrentTimeline()Landroidx/media3/common/Timeline;

    move-result-object v9

    goto :goto_1

    .line 1209
    :cond_2
    sget-object v9, Landroidx/media3/common/Timeline;->EMPTY:Landroidx/media3/common/Timeline;

    :goto_1
    nop

    .line 1210
    .local v9, "timeline":Landroidx/media3/common/Timeline;
    invoke-virtual {v9}, Landroidx/media3/common/Timeline;->isEmpty()Z

    move-result v10

    const-wide v11, -0x7fffffffffffffffL    # -4.9E-324

    if-nez v10, :cond_10

    .line 1211
    invoke-interface {v1}, Landroidx/media3/common/Player;->getCurrentMediaItemIndex()I

    move-result v10

    .line 1212
    .local v10, "currentWindowIndex":I
    iget-boolean v13, v0, Landroidx/media3/ui/PlayerControlView;->multiWindowTimeBar:Z

    if-eqz v13, :cond_3

    const/4 v14, 0x0

    goto :goto_2

    :cond_3
    move v14, v10

    .line 1213
    .local v14, "firstWindowIndex":I
    :goto_2
    if-eqz v13, :cond_4

    invoke-virtual {v9}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v13

    sub-int/2addr v13, v4

    goto :goto_3

    :cond_4
    move v13, v10

    .line 1214
    .local v13, "lastWindowIndex":I
    :goto_3
    move v15, v14

    .local v15, "i":I
    :goto_4
    if-gt v15, v13, :cond_e

    .line 1215
    if-ne v15, v10, :cond_5

    .line 1216
    invoke-static {v7, v8}, Landroidx/media3/common/util/Util;->usToMs(J)J

    move-result-wide v5

    iput-wide v5, v0, Landroidx/media3/ui/PlayerControlView;->currentWindowOffset:J

    .line 1218
    :cond_5
    iget-object v5, v0, Landroidx/media3/ui/PlayerControlView;->window:Landroidx/media3/common/Timeline$Window;

    invoke-virtual {v9, v15, v5}, Landroidx/media3/common/Timeline;->getWindow(ILandroidx/media3/common/Timeline$Window;)Landroidx/media3/common/Timeline$Window;

    .line 1219
    iget-object v5, v0, Landroidx/media3/ui/PlayerControlView;->window:Landroidx/media3/common/Timeline$Window;

    iget-wide v5, v5, Landroidx/media3/common/Timeline$Window;->durationUs:J

    cmp-long v5, v5, v11

    if-nez v5, :cond_6

    .line 1220
    iget-boolean v5, v0, Landroidx/media3/ui/PlayerControlView;->multiWindowTimeBar:Z

    xor-int/2addr v4, v5

    invoke-static {v4}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 1221
    move-object/from16 v22, v9

    goto/16 :goto_a

    .line 1223
    :cond_6
    iget-object v5, v0, Landroidx/media3/ui/PlayerControlView;->window:Landroidx/media3/common/Timeline$Window;

    iget v5, v5, Landroidx/media3/common/Timeline$Window;->firstPeriodIndex:I

    .local v5, "j":I
    :goto_5
    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->window:Landroidx/media3/common/Timeline$Window;

    iget v6, v6, Landroidx/media3/common/Timeline$Window;->lastPeriodIndex:I

    if-gt v5, v6, :cond_d

    .line 1224
    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v9, v5, v6}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    .line 1225
    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v6}, Landroidx/media3/common/Timeline$Period;->getRemovedAdGroupCount()I

    move-result v6

    .line 1226
    .local v6, "removedGroups":I
    iget-object v4, v0, Landroidx/media3/ui/PlayerControlView;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v4}, Landroidx/media3/common/Timeline$Period;->getAdGroupCount()I

    move-result v4

    .line 1227
    .local v4, "totalGroups":I
    move/from16 v18, v6

    move/from16 v3, v18

    .local v3, "adGroupIndex":I
    :goto_6
    if-ge v3, v4, :cond_c

    .line 1228
    iget-object v11, v0, Landroidx/media3/ui/PlayerControlView;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v11, v3}, Landroidx/media3/common/Timeline$Period;->getAdGroupTimeUs(I)J

    move-result-wide v11

    .line 1229
    .local v11, "adGroupTimeInPeriodUs":J
    const-wide/high16 v21, -0x8000000000000000L

    cmp-long v21, v11, v21

    if-nez v21, :cond_8

    .line 1230
    move/from16 v21, v4

    .end local v4    # "totalGroups":I
    .local v21, "totalGroups":I
    iget-object v4, v0, Landroidx/media3/ui/PlayerControlView;->period:Landroidx/media3/common/Timeline$Period;

    move-object/from16 v22, v9

    move/from16 v23, v10

    .end local v9    # "timeline":Landroidx/media3/common/Timeline;
    .end local v10    # "currentWindowIndex":I
    .local v22, "timeline":Landroidx/media3/common/Timeline;
    .local v23, "currentWindowIndex":I
    iget-wide v9, v4, Landroidx/media3/common/Timeline$Period;->durationUs:J

    const-wide v19, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v4, v9, v19

    if-nez v4, :cond_7

    .line 1232
    move/from16 v24, v6

    const-wide/16 v16, 0x0

    goto :goto_9

    .line 1234
    :cond_7
    iget-object v4, v0, Landroidx/media3/ui/PlayerControlView;->period:Landroidx/media3/common/Timeline$Period;

    iget-wide v11, v4, Landroidx/media3/common/Timeline$Period;->durationUs:J

    goto :goto_7

    .line 1229
    .end local v21    # "totalGroups":I
    .end local v22    # "timeline":Landroidx/media3/common/Timeline;
    .end local v23    # "currentWindowIndex":I
    .restart local v4    # "totalGroups":I
    .restart local v9    # "timeline":Landroidx/media3/common/Timeline;
    .restart local v10    # "currentWindowIndex":I
    :cond_8
    move/from16 v21, v4

    move-object/from16 v22, v9

    move/from16 v23, v10

    .line 1236
    .end local v4    # "totalGroups":I
    .end local v9    # "timeline":Landroidx/media3/common/Timeline;
    .end local v10    # "currentWindowIndex":I
    .restart local v21    # "totalGroups":I
    .restart local v22    # "timeline":Landroidx/media3/common/Timeline;
    .restart local v23    # "currentWindowIndex":I
    :goto_7
    iget-object v4, v0, Landroidx/media3/ui/PlayerControlView;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v4}, Landroidx/media3/common/Timeline$Period;->getPositionInWindowUs()J

    move-result-wide v9

    add-long/2addr v9, v11

    .line 1237
    .local v9, "adGroupTimeInWindowUs":J
    const-wide/16 v16, 0x0

    cmp-long v4, v9, v16

    if-ltz v4, :cond_b

    .line 1238
    iget-object v4, v0, Landroidx/media3/ui/PlayerControlView;->adGroupTimesMs:[J

    move/from16 v24, v6

    .end local v6    # "removedGroups":I
    .local v24, "removedGroups":I
    array-length v6, v4

    if-ne v2, v6, :cond_a

    .line 1239
    array-length v6, v4

    if-nez v6, :cond_9

    const/4 v6, 0x1

    goto :goto_8

    :cond_9
    array-length v6, v4

    mul-int/lit8 v6, v6, 0x2

    .line 1240
    .local v6, "newLength":I
    :goto_8
    invoke-static {v4, v6}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v4

    iput-object v4, v0, Landroidx/media3/ui/PlayerControlView;->adGroupTimesMs:[J

    .line 1241
    iget-object v4, v0, Landroidx/media3/ui/PlayerControlView;->playedAdGroups:[Z

    invoke-static {v4, v6}, Ljava/util/Arrays;->copyOf([ZI)[Z

    move-result-object v4

    iput-object v4, v0, Landroidx/media3/ui/PlayerControlView;->playedAdGroups:[Z

    .line 1243
    .end local v6    # "newLength":I
    :cond_a
    iget-object v4, v0, Landroidx/media3/ui/PlayerControlView;->adGroupTimesMs:[J

    add-long v25, v7, v9

    invoke-static/range {v25 .. v26}, Landroidx/media3/common/util/Util;->usToMs(J)J

    move-result-wide v25

    aput-wide v25, v4, v2

    .line 1244
    iget-object v4, v0, Landroidx/media3/ui/PlayerControlView;->playedAdGroups:[Z

    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v6, v3}, Landroidx/media3/common/Timeline$Period;->hasPlayedAdGroup(I)Z

    move-result v6

    aput-boolean v6, v4, v2

    .line 1245
    add-int/lit8 v2, v2, 0x1

    goto :goto_9

    .line 1237
    .end local v24    # "removedGroups":I
    .local v6, "removedGroups":I
    :cond_b
    move/from16 v24, v6

    .line 1227
    .end local v6    # "removedGroups":I
    .end local v9    # "adGroupTimeInWindowUs":J
    .end local v11    # "adGroupTimeInPeriodUs":J
    .restart local v24    # "removedGroups":I
    :goto_9
    add-int/lit8 v3, v3, 0x1

    move/from16 v4, v21

    move-object/from16 v9, v22

    move/from16 v10, v23

    move/from16 v6, v24

    const-wide v11, -0x7fffffffffffffffL    # -4.9E-324

    goto/16 :goto_6

    .end local v21    # "totalGroups":I
    .end local v22    # "timeline":Landroidx/media3/common/Timeline;
    .end local v23    # "currentWindowIndex":I
    .end local v24    # "removedGroups":I
    .restart local v4    # "totalGroups":I
    .restart local v6    # "removedGroups":I
    .local v9, "timeline":Landroidx/media3/common/Timeline;
    .restart local v10    # "currentWindowIndex":I
    :cond_c
    move/from16 v21, v4

    move/from16 v24, v6

    move-object/from16 v22, v9

    move/from16 v23, v10

    const-wide/16 v16, 0x0

    .line 1223
    .end local v3    # "adGroupIndex":I
    .end local v4    # "totalGroups":I
    .end local v6    # "removedGroups":I
    .end local v9    # "timeline":Landroidx/media3/common/Timeline;
    .end local v10    # "currentWindowIndex":I
    .restart local v22    # "timeline":Landroidx/media3/common/Timeline;
    .restart local v23    # "currentWindowIndex":I
    add-int/lit8 v5, v5, 0x1

    const/4 v4, 0x1

    const-wide v11, -0x7fffffffffffffffL    # -4.9E-324

    goto/16 :goto_5

    .end local v22    # "timeline":Landroidx/media3/common/Timeline;
    .end local v23    # "currentWindowIndex":I
    .restart local v9    # "timeline":Landroidx/media3/common/Timeline;
    .restart local v10    # "currentWindowIndex":I
    :cond_d
    move-object/from16 v22, v9

    move/from16 v23, v10

    const-wide/16 v16, 0x0

    .line 1249
    .end local v5    # "j":I
    .end local v9    # "timeline":Landroidx/media3/common/Timeline;
    .end local v10    # "currentWindowIndex":I
    .restart local v22    # "timeline":Landroidx/media3/common/Timeline;
    .restart local v23    # "currentWindowIndex":I
    iget-object v3, v0, Landroidx/media3/ui/PlayerControlView;->window:Landroidx/media3/common/Timeline$Window;

    iget-wide v3, v3, Landroidx/media3/common/Timeline$Window;->durationUs:J

    add-long/2addr v7, v3

    .line 1214
    add-int/lit8 v15, v15, 0x1

    move-wide/from16 v5, v16

    const/4 v4, 0x1

    const-wide v11, -0x7fffffffffffffffL    # -4.9E-324

    goto/16 :goto_4

    .end local v22    # "timeline":Landroidx/media3/common/Timeline;
    .end local v23    # "currentWindowIndex":I
    .restart local v9    # "timeline":Landroidx/media3/common/Timeline;
    .restart local v10    # "currentWindowIndex":I
    :cond_e
    move-object/from16 v22, v9

    move/from16 v23, v10

    .line 1251
    .end local v9    # "timeline":Landroidx/media3/common/Timeline;
    .end local v10    # "currentWindowIndex":I
    .end local v13    # "lastWindowIndex":I
    .end local v14    # "firstWindowIndex":I
    .end local v15    # "i":I
    .restart local v22    # "timeline":Landroidx/media3/common/Timeline;
    :cond_f
    :goto_a
    goto :goto_b

    .end local v22    # "timeline":Landroidx/media3/common/Timeline;
    .restart local v9    # "timeline":Landroidx/media3/common/Timeline;
    :cond_10
    move-object/from16 v22, v9

    .end local v9    # "timeline":Landroidx/media3/common/Timeline;
    .restart local v22    # "timeline":Landroidx/media3/common/Timeline;
    const/16 v3, 0x10

    invoke-interface {v1, v3}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v3

    if-eqz v3, :cond_f

    .line 1252
    invoke-interface {v1}, Landroidx/media3/common/Player;->getContentDuration()J

    move-result-wide v3

    .line 1253
    .local v3, "playerDurationMs":J
    const-wide v5, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v5, v3, v5

    if-eqz v5, :cond_11

    .line 1254
    invoke-static {v3, v4}, Landroidx/media3/common/util/Util;->msToUs(J)J

    move-result-wide v7

    .line 1257
    .end local v3    # "playerDurationMs":J
    :cond_11
    :goto_b
    invoke-static {v7, v8}, Landroidx/media3/common/util/Util;->usToMs(J)J

    move-result-wide v3

    .line 1258
    .local v3, "durationMs":J
    iget-object v5, v0, Landroidx/media3/ui/PlayerControlView;->durationView:Landroid/widget/TextView;

    if-eqz v5, :cond_12

    .line 1259
    iget-object v6, v0, Landroidx/media3/ui/PlayerControlView;->formatBuilder:Ljava/lang/StringBuilder;

    iget-object v9, v0, Landroidx/media3/ui/PlayerControlView;->formatter:Ljava/util/Formatter;

    invoke-static {v6, v9, v3, v4}, Landroidx/media3/common/util/Util;->getStringForTime(Ljava/lang/StringBuilder;Ljava/util/Formatter;J)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1261
    :cond_12
    iget-object v5, v0, Landroidx/media3/ui/PlayerControlView;->timeBar:Landroidx/media3/ui/TimeBar;

    if-eqz v5, :cond_14

    .line 1262
    invoke-interface {v5, v3, v4}, Landroidx/media3/ui/TimeBar;->setDuration(J)V

    .line 1263
    iget-object v5, v0, Landroidx/media3/ui/PlayerControlView;->extraAdGroupTimesMs:[J

    array-length v5, v5

    .line 1264
    .local v5, "extraAdGroupCount":I
    add-int v6, v2, v5

    .line 1265
    .local v6, "totalAdGroupCount":I
    iget-object v9, v0, Landroidx/media3/ui/PlayerControlView;->adGroupTimesMs:[J

    array-length v10, v9

    if-le v6, v10, :cond_13

    .line 1266
    invoke-static {v9, v6}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v9

    iput-object v9, v0, Landroidx/media3/ui/PlayerControlView;->adGroupTimesMs:[J

    .line 1267
    iget-object v9, v0, Landroidx/media3/ui/PlayerControlView;->playedAdGroups:[Z

    invoke-static {v9, v6}, Ljava/util/Arrays;->copyOf([ZI)[Z

    move-result-object v9

    iput-object v9, v0, Landroidx/media3/ui/PlayerControlView;->playedAdGroups:[Z

    .line 1269
    :cond_13
    iget-object v9, v0, Landroidx/media3/ui/PlayerControlView;->extraAdGroupTimesMs:[J

    iget-object v10, v0, Landroidx/media3/ui/PlayerControlView;->adGroupTimesMs:[J

    const/4 v11, 0x0

    invoke-static {v9, v11, v10, v2, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1270
    iget-object v9, v0, Landroidx/media3/ui/PlayerControlView;->extraPlayedAdGroups:[Z

    iget-object v10, v0, Landroidx/media3/ui/PlayerControlView;->playedAdGroups:[Z

    invoke-static {v9, v11, v10, v2, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1271
    iget-object v9, v0, Landroidx/media3/ui/PlayerControlView;->timeBar:Landroidx/media3/ui/TimeBar;

    iget-object v10, v0, Landroidx/media3/ui/PlayerControlView;->adGroupTimesMs:[J

    iget-object v11, v0, Landroidx/media3/ui/PlayerControlView;->playedAdGroups:[Z

    invoke-interface {v9, v10, v11, v6}, Landroidx/media3/ui/TimeBar;->setAdGroupTimesMs([J[ZI)V

    .line 1273
    .end local v5    # "extraAdGroupCount":I
    .end local v6    # "totalAdGroupCount":I
    :cond_14
    invoke-direct/range {p0 .. p0}, Landroidx/media3/ui/PlayerControlView;->updateProgress()V

    .line 1274
    return-void
.end method

.method private updateTrackLists()V
    .locals 2

    .line 1151
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->initTrackSelectionAdapter()V

    .line 1152
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->textTrackSelectionAdapter:Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlView$TextTrackSelectionAdapter;->getItemCount()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->subtitleButton:Landroid/widget/ImageView;

    invoke-direct {p0, v0, v1}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 1153
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateSettingsButton()V

    .line 1154
    return-void
.end method


# virtual methods
.method public addVisibilityListener(Landroidx/media3/ui/PlayerControlView$VisibilityListener;)V
    .locals 1
    .param p1, "listener"    # Landroidx/media3/ui/PlayerControlView$VisibilityListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 728
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 729
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->visibilityListeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z

    .line 730
    return-void
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 1472
    invoke-virtual {p0, p1}, Landroidx/media3/ui/PlayerControlView;->dispatchMediaKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

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

.method public dispatchMediaKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 1483
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    .line 1484
    .local v0, "keyCode":I
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    .line 1485
    .local v1, "player":Landroidx/media3/common/Player;
    if-eqz v1, :cond_4

    invoke-static {v0}, Landroidx/media3/ui/PlayerControlView;->isHandledMediaKey(I)Z

    move-result v2

    if-nez v2, :cond_0

    goto :goto_1

    .line 1488
    :cond_0
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_3

    .line 1489
    const/16 v2, 0x5a

    if-ne v0, v2, :cond_1

    .line 1490
    invoke-interface {v1}, Landroidx/media3/common/Player;->getPlaybackState()I

    move-result v2

    const/4 v3, 0x4

    if-eq v2, v3, :cond_3

    .line 1491
    const/16 v2, 0xc

    invoke-interface {v1, v2}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 1492
    invoke-interface {v1}, Landroidx/media3/common/Player;->seekForward()V

    goto :goto_0

    .line 1494
    :cond_1
    const/16 v2, 0x59

    if-ne v0, v2, :cond_2

    .line 1495
    const/16 v2, 0xb

    invoke-interface {v1, v2}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1496
    invoke-interface {v1}, Landroidx/media3/common/Player;->seekBack()V

    goto :goto_0

    .line 1497
    :cond_2
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v2

    if-nez v2, :cond_3

    .line 1498
    sparse-switch v0, :sswitch_data_0

    goto :goto_0

    .line 1507
    :sswitch_0
    invoke-static {v1}, Landroidx/media3/common/util/Util;->handlePauseButtonAction(Landroidx/media3/common/Player;)Z

    .line 1508
    goto :goto_0

    .line 1504
    :sswitch_1
    invoke-static {v1}, Landroidx/media3/common/util/Util;->handlePlayButtonAction(Landroidx/media3/common/Player;)Z

    .line 1505
    goto :goto_0

    .line 1515
    :sswitch_2
    const/4 v2, 0x7

    invoke-interface {v1, v2}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 1516
    invoke-interface {v1}, Landroidx/media3/common/Player;->seekToPrevious()V

    goto :goto_0

    .line 1510
    :sswitch_3
    const/16 v2, 0x9

    invoke-interface {v1, v2}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 1511
    invoke-interface {v1}, Landroidx/media3/common/Player;->seekToNext()V

    goto :goto_0

    .line 1501
    :sswitch_4
    iget-boolean v2, p0, Landroidx/media3/ui/PlayerControlView;->showPlayButtonIfSuppressed:Z

    invoke-static {v1, v2}, Landroidx/media3/common/util/Util;->handlePlayPauseButtonAction(Landroidx/media3/common/Player;Z)Z

    .line 1502
    nop

    .line 1524
    :cond_3
    :goto_0
    const/4 v2, 0x1

    return v2

    .line 1486
    :cond_4
    :goto_1
    const/4 v2, 0x0

    return v2

    nop

    :sswitch_data_0
    .sparse-switch
        0x4f -> :sswitch_4
        0x55 -> :sswitch_4
        0x57 -> :sswitch_3
        0x58 -> :sswitch_2
        0x7e -> :sswitch_1
        0x7f -> :sswitch_0
    .end sparse-switch
.end method

.method public getPlayer()Landroidx/media3/common/Player;
    .locals 1

    .line 644
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    return-object v0
.end method

.method public getRepeatToggleModes()I
    .locals 1

    .line 824
    iget v0, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleModes:I

    return v0
.end method

.method public getShowShuffleButton()Z
    .locals 2

    .line 854
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->shuffleButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->getShowButton(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public getShowSubtitleButton()Z
    .locals 2

    .line 869
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->subtitleButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->getShowButton(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public getShowTimeoutMs()I
    .locals 1

    .line 801
    iget v0, p0, Landroidx/media3/ui/PlayerControlView;->showTimeoutMs:I

    return v0
.end method

.method public getShowVrButton()Z
    .locals 2

    .line 883
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->vrButton:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->getShowButton(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public hide()V
    .locals 1

    .line 962
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->hide()V

    .line 963
    return-void
.end method

.method public hideImmediately()V
    .locals 1

    .line 967
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->hideImmediately()V

    .line 968
    return-void
.end method

.method public isAnimationEnabled()Z
    .locals 1

    .line 918
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->isAnimationEnabled()Z

    move-result v0

    return v0
.end method

.method public isFullyVisible()Z
    .locals 1

    .line 972
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->isFullyVisible()Z

    move-result v0

    return v0
.end method

.method public isVisible()Z
    .locals 1

    .line 977
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method notifyOnVisibilityChange()V
    .locals 3

    .line 982
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->visibilityListeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/ui/PlayerControlView$VisibilityListener;

    .line 983
    .local v1, "visibilityListener":Landroidx/media3/ui/PlayerControlView$VisibilityListener;
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->getVisibility()I

    move-result v2

    invoke-interface {v1, v2}, Landroidx/media3/ui/PlayerControlView$VisibilityListener;->onVisibilityChange(I)V

    .line 984
    .end local v1    # "visibilityListener":Landroidx/media3/ui/PlayerControlView$VisibilityListener;
    goto :goto_0

    .line 985
    :cond_0
    return-void
.end method

.method public onAttachedToWindow()V
    .locals 1

    .line 1452
    invoke-super {p0}, Landroid/widget/FrameLayout;->onAttachedToWindow()V

    .line 1453
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->onAttachedToWindow()V

    .line 1454
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->isAttachedToWindow:Z

    .line 1455
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->isFullyVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1456
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->resetHideCallbacks()V

    .line 1458
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->updateAll()V

    .line 1459
    return-void
.end method

.method public onDetachedFromWindow()V
    .locals 1

    .line 1463
    invoke-super {p0}, Landroid/widget/FrameLayout;->onDetachedFromWindow()V

    .line 1464
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->onDetachedFromWindow()V

    .line 1465
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/PlayerControlView;->isAttachedToWindow:Z

    .line 1466
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->updateProgressAction:Ljava/lang/Runnable;

    invoke-virtual {p0, v0}, Landroidx/media3/ui/PlayerControlView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1467
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->removeHideCallbacks()V

    .line 1468
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 6
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .line 1529
    invoke-super/range {p0 .. p5}, Landroid/widget/FrameLayout;->onLayout(ZIIII)V

    .line 1530
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->onLayout(ZIIII)V

    .line 1531
    return-void
.end method

.method public removeVisibilityListener(Landroidx/media3/ui/PlayerControlView$VisibilityListener;)V
    .locals 1
    .param p1, "listener"    # Landroidx/media3/ui/PlayerControlView$VisibilityListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 741
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->visibilityListeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    .line 742
    return-void
.end method

.method requestPlayPauseFocus()V
    .locals 1

    .line 1373
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->playPauseButton:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 1374
    invoke-virtual {v0}, Landroid/view/View;->requestFocus()Z

    .line 1376
    :cond_0
    return-void
.end method

.method public setAnimationEnabled(Z)V
    .locals 1
    .param p1, "animationEnabled"    # Z

    .line 913
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-virtual {v0, p1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setAnimationEnabled(Z)V

    .line 914
    return-void
.end method

.method public setExtraAdGroupMarkers([J[Z)V
    .locals 3
    .param p1, "extraAdGroupTimesMs"    # [J
    .param p2, "extraPlayedAdGroups"    # [Z

    .line 707
    const/4 v0, 0x0

    if-nez p1, :cond_0

    .line 708
    new-array v1, v0, [J

    iput-object v1, p0, Landroidx/media3/ui/PlayerControlView;->extraAdGroupTimesMs:[J

    .line 709
    new-array v0, v0, [Z

    iput-object v0, p0, Landroidx/media3/ui/PlayerControlView;->extraPlayedAdGroups:[Z

    goto :goto_0

    .line 711
    :cond_0
    invoke-static {p2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    move-object p2, v1

    check-cast p2, [Z

    .line 712
    array-length v1, p1

    array-length v2, p2

    if-ne v1, v2, :cond_1

    const/4 v0, 0x1

    :cond_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 713
    iput-object p1, p0, Landroidx/media3/ui/PlayerControlView;->extraAdGroupTimesMs:[J

    .line 714
    iput-object p2, p0, Landroidx/media3/ui/PlayerControlView;->extraPlayedAdGroups:[Z

    .line 716
    :goto_0
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateTimeline()V

    .line 717
    return-void
.end method

.method public setOnFullScreenModeChangedListener(Landroidx/media3/ui/PlayerControlView$OnFullScreenModeChangedListener;)V
    .locals 4
    .param p1, "listener"    # Landroidx/media3/ui/PlayerControlView$OnFullScreenModeChangedListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 947
    iput-object p1, p0, Landroidx/media3/ui/PlayerControlView;->onFullScreenModeChangedListener:Landroidx/media3/ui/PlayerControlView$OnFullScreenModeChangedListener;

    .line 948
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->fullScreenButton:Landroid/widget/ImageView;

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz p1, :cond_0

    move v3, v1

    goto :goto_0

    :cond_0
    move v3, v2

    :goto_0
    invoke-static {v0, v3}, Landroidx/media3/ui/PlayerControlView;->updateFullScreenButtonVisibility(Landroid/view/View;Z)V

    .line 949
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->minimalFullScreenButton:Landroid/widget/ImageView;

    if-eqz p1, :cond_1

    goto :goto_1

    :cond_1
    move v1, v2

    :goto_1
    invoke-static {v0, v1}, Landroidx/media3/ui/PlayerControlView;->updateFullScreenButtonVisibility(Landroid/view/View;Z)V

    .line 950
    return-void
.end method

.method public setPlayer(Landroidx/media3/common/Player;)V
    .locals 4
    .param p1, "player"    # Landroidx/media3/common/Player;

    .line 655
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

    .line 656
    if-eqz p1, :cond_2

    .line 657
    invoke-interface {p1}, Landroidx/media3/common/Player;->getApplicationLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_1

    goto :goto_1

    :cond_1
    move v2, v3

    goto :goto_2

    :cond_2
    :goto_1
    nop

    .line 656
    :goto_2
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 658
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    if-ne v0, p1, :cond_3

    .line 659
    return-void

    .line 661
    :cond_3
    if-eqz v0, :cond_4

    .line 662
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->componentListener:Landroidx/media3/ui/PlayerControlView$ComponentListener;

    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->removeListener(Landroidx/media3/common/Player$Listener;)V

    .line 664
    :cond_4
    iput-object p1, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    .line 665
    if-eqz p1, :cond_5

    .line 666
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->componentListener:Landroidx/media3/ui/PlayerControlView$ComponentListener;

    invoke-interface {p1, v0}, Landroidx/media3/common/Player;->addListener(Landroidx/media3/common/Player$Listener;)V

    .line 668
    :cond_5
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->updateAll()V

    .line 669
    return-void
.end method

.method public setProgressUpdateListener(Landroidx/media3/ui/PlayerControlView$ProgressUpdateListener;)V
    .locals 0
    .param p1, "listener"    # Landroidx/media3/ui/PlayerControlView$ProgressUpdateListener;

    .line 750
    iput-object p1, p0, Landroidx/media3/ui/PlayerControlView;->progressUpdateListener:Landroidx/media3/ui/PlayerControlView$ProgressUpdateListener;

    .line 751
    return-void
.end method

.method public setRepeatToggleModes(I)V
    .locals 5
    .param p1, "repeatToggleModes"    # I

    .line 833
    iput p1, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleModes:I

    .line 834
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_2

    const/16 v3, 0xf

    invoke-interface {v0, v3}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 835
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    invoke-interface {v0}, Landroidx/media3/common/Player;->getRepeatMode()I

    move-result v0

    .line 836
    .local v0, "currentMode":I
    if-nez p1, :cond_0

    if-eqz v0, :cond_0

    .line 838
    iget-object v3, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    invoke-interface {v3, v1}, Landroidx/media3/common/Player;->setRepeatMode(I)V

    goto :goto_0

    .line 839
    :cond_0
    const/4 v3, 0x2

    if-ne p1, v2, :cond_1

    if-ne v0, v3, :cond_1

    .line 841
    iget-object v3, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    invoke-interface {v3, v2}, Landroidx/media3/common/Player;->setRepeatMode(I)V

    goto :goto_0

    .line 842
    :cond_1
    if-ne p1, v3, :cond_2

    if-ne v0, v2, :cond_2

    .line 844
    iget-object v4, p0, Landroidx/media3/ui/PlayerControlView;->player:Landroidx/media3/common/Player;

    invoke-interface {v4, v3}, Landroidx/media3/common/Player;->setRepeatMode(I)V

    .line 847
    .end local v0    # "currentMode":I
    :cond_2
    :goto_0
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iget-object v3, p0, Landroidx/media3/ui/PlayerControlView;->repeatToggleButton:Landroid/widget/ImageView;

    if-eqz p1, :cond_3

    move v1, v2

    :cond_3
    invoke-virtual {v0, v3, v1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 849
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateRepeatModeButton()V

    .line 850
    return-void
.end method

.method public setShowFastForwardButton(Z)V
    .locals 2
    .param p1, "showFastForwardButton"    # Z

    .line 769
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->fastForwardButton:Landroid/view/View;

    invoke-virtual {v0, v1, p1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 770
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateNavigation()V

    .line 771
    return-void
.end method

.method public setShowMultiWindowTimeBar(Z)V
    .locals 0
    .param p1, "showMultiWindowTimeBar"    # Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 677
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerControlView;->showMultiWindowTimeBar:Z

    .line 678
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateTimeline()V

    .line 679
    return-void
.end method

.method public setShowNextButton(Z)V
    .locals 2
    .param p1, "showNextButton"    # Z

    .line 789
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->nextButton:Landroid/view/View;

    invoke-virtual {v0, v1, p1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 790
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateNavigation()V

    .line 791
    return-void
.end method

.method public setShowPlayButtonIfPlaybackIsSuppressed(Z)V
    .locals 0
    .param p1, "showPlayButtonIfSuppressed"    # Z

    .line 691
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerControlView;->showPlayButtonIfSuppressed:Z

    .line 692
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updatePlayPauseButton()V

    .line 693
    return-void
.end method

.method public setShowPreviousButton(Z)V
    .locals 2
    .param p1, "showPreviousButton"    # Z

    .line 779
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->previousButton:Landroid/view/View;

    invoke-virtual {v0, v1, p1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 780
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateNavigation()V

    .line 781
    return-void
.end method

.method public setShowRewindButton(Z)V
    .locals 2
    .param p1, "showRewindButton"    # Z

    .line 759
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->rewindButton:Landroid/view/View;

    invoke-virtual {v0, v1, p1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 760
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateNavigation()V

    .line 761
    return-void
.end method

.method public setShowShuffleButton(Z)V
    .locals 2
    .param p1, "showShuffleButton"    # Z

    .line 863
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->shuffleButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v1, p1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 864
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateShuffleButton()V

    .line 865
    return-void
.end method

.method public setShowSubtitleButton(Z)V
    .locals 2
    .param p1, "showSubtitleButton"    # Z

    .line 878
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->subtitleButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v1, p1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 879
    return-void
.end method

.method public setShowTimeoutMs(I)V
    .locals 1
    .param p1, "showTimeoutMs"    # I

    .line 812
    iput p1, p0, Landroidx/media3/ui/PlayerControlView;->showTimeoutMs:I

    .line 813
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerControlView;->isFullyVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 814
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->resetHideCallbacks()V

    .line 816
    :cond_0
    return-void
.end method

.method public setShowVrButton(Z)V
    .locals 2
    .param p1, "showVrButton"    # Z

    .line 892
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->vrButton:Landroid/view/View;

    invoke-virtual {v0, v1, p1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->setShowButton(Landroid/view/View;Z)V

    .line 893
    return-void
.end method

.method public setTimeBarMinUpdateInterval(I)V
    .locals 2
    .param p1, "minUpdateIntervalMs"    # I

    .line 933
    nop

    .line 934
    const/16 v0, 0x10

    const/16 v1, 0x3e8

    invoke-static {p1, v0, v1}, Landroidx/media3/common/util/Util;->constrainValue(III)I

    move-result v0

    iput v0, p0, Landroidx/media3/ui/PlayerControlView;->timeBarMinUpdateIntervalMs:I

    .line 935
    return-void
.end method

.method public setVrButtonListener(Landroid/view/View$OnClickListener;)V
    .locals 2
    .param p1, "onClickListener"    # Landroid/view/View$OnClickListener;

    .line 901
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->vrButton:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 902
    invoke-virtual {v0, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 903
    if-eqz p1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iget-object v1, p0, Landroidx/media3/ui/PlayerControlView;->vrButton:Landroid/view/View;

    invoke-direct {p0, v0, v1}, Landroidx/media3/ui/PlayerControlView;->updateButton(ZLandroid/view/View;)V

    .line 905
    :cond_1
    return-void
.end method

.method public show()V
    .locals 1

    .line 957
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlView;->controlViewLayoutManager:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->show()V

    .line 958
    return-void
.end method

.method updateAll()V
    .locals 0

    .line 988
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updatePlayPauseButton()V

    .line 989
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateNavigation()V

    .line 990
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateRepeatModeButton()V

    .line 991
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateShuffleButton()V

    .line 992
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateTrackLists()V

    .line 993
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updatePlaybackSpeedList()V

    .line 994
    invoke-direct {p0}, Landroidx/media3/ui/PlayerControlView;->updateTimeline()V

    .line 995
    return-void
.end method
