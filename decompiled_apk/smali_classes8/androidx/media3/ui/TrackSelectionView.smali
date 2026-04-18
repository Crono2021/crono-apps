.class public Landroidx/media3/ui/TrackSelectionView;
.super Landroid/widget/LinearLayout;
.source "TrackSelectionView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/ui/TrackSelectionView$ComponentListener;,
        Landroidx/media3/ui/TrackSelectionView$TrackSelectionListener;,
        Landroidx/media3/ui/TrackSelectionView$TrackInfo;
    }
.end annotation


# instance fields
.field private allowAdaptiveSelections:Z

.field private allowMultipleOverrides:Z

.field private final componentListener:Landroidx/media3/ui/TrackSelectionView$ComponentListener;

.field private final defaultView:Landroid/widget/CheckedTextView;

.field private final disableView:Landroid/widget/CheckedTextView;

.field private final inflater:Landroid/view/LayoutInflater;

.field private isDisabled:Z

.field private listener:Landroidx/media3/ui/TrackSelectionView$TrackSelectionListener;

.field private final overrides:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Landroidx/media3/common/TrackGroup;",
            "Landroidx/media3/common/TrackSelectionOverride;",
            ">;"
        }
    .end annotation
.end field

.field private final selectableItemBackgroundResourceId:I

.field private final trackGroups:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/common/Tracks$Group;",
            ">;"
        }
    .end annotation
.end field

.field private trackInfoComparator:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator<",
            "Landroidx/media3/ui/TrackSelectionView$TrackInfo;",
            ">;"
        }
    .end annotation
.end field

.field private trackNameProvider:Landroidx/media3/ui/TrackNameProvider;

.field private trackViews:[[Landroid/widget/CheckedTextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 103
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroidx/media3/ui/TrackSelectionView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 104
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 108
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroidx/media3/ui/TrackSelectionView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 109
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .line 115
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 116
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroidx/media3/ui/TrackSelectionView;->setOrientation(I)V

    .line 118
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Landroidx/media3/ui/TrackSelectionView;->setSaveFromParentEnabled(Z)V

    .line 120
    nop

    .line 122
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v2

    const v3, 0x101030e

    filled-new-array {v3}, [I

    move-result-object v3

    .line 123
    invoke-virtual {v2, v3}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v2

    .line 124
    .local v2, "attributeArray":Landroid/content/res/TypedArray;
    invoke-virtual {v2, v1, v1}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    iput v3, p0, Landroidx/media3/ui/TrackSelectionView;->selectableItemBackgroundResourceId:I

    .line 125
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    .line 127
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    iput-object v4, p0, Landroidx/media3/ui/TrackSelectionView;->inflater:Landroid/view/LayoutInflater;

    .line 128
    new-instance v5, Landroidx/media3/ui/TrackSelectionView$ComponentListener;

    const/4 v6, 0x0

    invoke-direct {v5, p0, v6}, Landroidx/media3/ui/TrackSelectionView$ComponentListener;-><init>(Landroidx/media3/ui/TrackSelectionView;Landroidx/media3/ui/TrackSelectionView$1;)V

    iput-object v5, p0, Landroidx/media3/ui/TrackSelectionView;->componentListener:Landroidx/media3/ui/TrackSelectionView$ComponentListener;

    .line 129
    new-instance v6, Landroidx/media3/ui/DefaultTrackNameProvider;

    invoke-virtual {p0}, Landroidx/media3/ui/TrackSelectionView;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-direct {v6, v7}, Landroidx/media3/ui/DefaultTrackNameProvider;-><init>(Landroid/content/res/Resources;)V

    iput-object v6, p0, Landroidx/media3/ui/TrackSelectionView;->trackNameProvider:Landroidx/media3/ui/TrackNameProvider;

    .line 130
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, p0, Landroidx/media3/ui/TrackSelectionView;->trackGroups:Ljava/util/List;

    .line 131
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    iput-object v6, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    .line 134
    nop

    .line 136
    const v6, 0x109000f

    invoke-virtual {v4, v6, p0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/CheckedTextView;

    iput-object v7, p0, Landroidx/media3/ui/TrackSelectionView;->disableView:Landroid/widget/CheckedTextView;

    .line 137
    invoke-virtual {v7, v3}, Landroid/widget/CheckedTextView;->setBackgroundResource(I)V

    .line 138
    sget v8, Landroidx/media3/ui/R$string;->exo_track_selection_none:I

    invoke-virtual {v7, v8}, Landroid/widget/CheckedTextView;->setText(I)V

    .line 139
    invoke-virtual {v7, v1}, Landroid/widget/CheckedTextView;->setEnabled(Z)V

    .line 140
    invoke-virtual {v7, v0}, Landroid/widget/CheckedTextView;->setFocusable(Z)V

    .line 141
    invoke-virtual {v7, v5}, Landroid/widget/CheckedTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    const/16 v8, 0x8

    invoke-virtual {v7, v8}, Landroid/widget/CheckedTextView;->setVisibility(I)V

    .line 143
    invoke-virtual {p0, v7}, Landroidx/media3/ui/TrackSelectionView;->addView(Landroid/view/View;)V

    .line 145
    sget v7, Landroidx/media3/ui/R$layout;->exo_list_divider:I

    invoke-virtual {v4, v7, p0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v7

    invoke-virtual {p0, v7}, Landroidx/media3/ui/TrackSelectionView;->addView(Landroid/view/View;)V

    .line 147
    nop

    .line 149
    invoke-virtual {v4, v6, p0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/CheckedTextView;

    iput-object v4, p0, Landroidx/media3/ui/TrackSelectionView;->defaultView:Landroid/widget/CheckedTextView;

    .line 150
    invoke-virtual {v4, v3}, Landroid/widget/CheckedTextView;->setBackgroundResource(I)V

    .line 151
    sget v3, Landroidx/media3/ui/R$string;->exo_track_selection_auto:I

    invoke-virtual {v4, v3}, Landroid/widget/CheckedTextView;->setText(I)V

    .line 152
    invoke-virtual {v4, v1}, Landroid/widget/CheckedTextView;->setEnabled(Z)V

    .line 153
    invoke-virtual {v4, v0}, Landroid/widget/CheckedTextView;->setFocusable(Z)V

    .line 154
    invoke-virtual {v4, v5}, Landroid/widget/CheckedTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 155
    invoke-virtual {p0, v4}, Landroidx/media3/ui/TrackSelectionView;->addView(Landroid/view/View;)V

    .line 156
    return-void
.end method

.method static synthetic access$100(Landroidx/media3/ui/TrackSelectionView;Landroid/view/View;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/TrackSelectionView;
    .param p1, "x1"    # Landroid/view/View;

    .line 43
    invoke-direct {p0, p1}, Landroidx/media3/ui/TrackSelectionView;->onClick(Landroid/view/View;)V

    return-void
.end method

.method public static filterOverrides(Ljava/util/Map;Ljava/util/List;Z)Ljava/util/Map;
    .locals 5
    .param p2, "allowMultipleOverrides"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "Landroidx/media3/common/TrackGroup;",
            "Landroidx/media3/common/TrackSelectionOverride;",
            ">;",
            "Ljava/util/List<",
            "Landroidx/media3/common/Tracks$Group;",
            ">;Z)",
            "Ljava/util/Map<",
            "Landroidx/media3/common/TrackGroup;",
            "Landroidx/media3/common/TrackSelectionOverride;",
            ">;"
        }
    .end annotation

    .line 72
    .local p0, "overrides":Ljava/util/Map;, "Ljava/util/Map<Landroidx/media3/common/TrackGroup;Landroidx/media3/common/TrackSelectionOverride;>;"
    .local p1, "trackGroups":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/Tracks$Group;>;"
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 73
    .local v0, "filteredOverrides":Ljava/util/HashMap;, "Ljava/util/HashMap<Landroidx/media3/common/TrackGroup;Landroidx/media3/common/TrackSelectionOverride;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_2

    .line 74
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/common/Tracks$Group;

    .line 75
    .local v2, "trackGroup":Landroidx/media3/common/Tracks$Group;
    invoke-virtual {v2}, Landroidx/media3/common/Tracks$Group;->getMediaTrackGroup()Landroidx/media3/common/TrackGroup;

    move-result-object v3

    invoke-interface {p0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/common/TrackSelectionOverride;

    .line 76
    .local v3, "override":Landroidx/media3/common/TrackSelectionOverride;
    if-eqz v3, :cond_1

    if-nez p2, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 77
    :cond_0
    iget-object v4, v3, Landroidx/media3/common/TrackSelectionOverride;->mediaTrackGroup:Landroidx/media3/common/TrackGroup;

    invoke-virtual {v0, v4, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    .end local v2    # "trackGroup":Landroidx/media3/common/Tracks$Group;
    .end local v3    # "override":Landroidx/media3/common/TrackSelectionOverride;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 80
    .end local v1    # "i":I
    :cond_2
    return-object v0
.end method

.method static synthetic lambda$init$0(Ljava/util/Comparator;Landroidx/media3/ui/TrackSelectionView$TrackInfo;Landroidx/media3/ui/TrackSelectionView$TrackInfo;)I
    .locals 2
    .param p0, "trackFormatComparator"    # Ljava/util/Comparator;
    .param p1, "o1"    # Landroidx/media3/ui/TrackSelectionView$TrackInfo;
    .param p2, "o2"    # Landroidx/media3/ui/TrackSelectionView$TrackInfo;

    .line 238
    invoke-virtual {p1}, Landroidx/media3/ui/TrackSelectionView$TrackInfo;->getFormat()Landroidx/media3/common/Format;

    move-result-object v0

    invoke-virtual {p2}, Landroidx/media3/ui/TrackSelectionView$TrackInfo;->getFormat()Landroidx/media3/common/Format;

    move-result-object v1

    invoke-interface {p0, v0, v1}, Ljava/util/Comparator;->compare(Ljava/lang/Object;Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method private onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .line 337
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->disableView:Landroid/widget/CheckedTextView;

    if-ne p1, v0, :cond_0

    .line 338
    invoke-direct {p0}, Landroidx/media3/ui/TrackSelectionView;->onDisableViewClicked()V

    goto :goto_0

    .line 339
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->defaultView:Landroid/widget/CheckedTextView;

    if-ne p1, v0, :cond_1

    .line 340
    invoke-direct {p0}, Landroidx/media3/ui/TrackSelectionView;->onDefaultViewClicked()V

    goto :goto_0

    .line 342
    :cond_1
    invoke-direct {p0, p1}, Landroidx/media3/ui/TrackSelectionView;->onTrackViewClicked(Landroid/view/View;)V

    .line 344
    :goto_0
    invoke-direct {p0}, Landroidx/media3/ui/TrackSelectionView;->updateViewStates()V

    .line 345
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->listener:Landroidx/media3/ui/TrackSelectionView$TrackSelectionListener;

    if-eqz v0, :cond_2

    .line 346
    invoke-virtual {p0}, Landroidx/media3/ui/TrackSelectionView;->getIsDisabled()Z

    move-result v1

    invoke-virtual {p0}, Landroidx/media3/ui/TrackSelectionView;->getOverrides()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroidx/media3/ui/TrackSelectionView$TrackSelectionListener;->onTrackSelectionChanged(ZLjava/util/Map;)V

    .line 348
    :cond_2
    return-void
.end method

.method private onDefaultViewClicked()V
    .locals 1

    .line 356
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/TrackSelectionView;->isDisabled:Z

    .line 357
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 358
    return-void
.end method

.method private onDisableViewClicked()V
    .locals 1

    .line 351
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/ui/TrackSelectionView;->isDisabled:Z

    .line 352
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 353
    return-void
.end method

.method private onTrackViewClicked(Landroid/view/View;)V
    .locals 11
    .param p1, "view"    # Landroid/view/View;

    .line 361
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/TrackSelectionView;->isDisabled:Z

    .line 362
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/ui/TrackSelectionView$TrackInfo;

    .line 363
    .local v1, "trackInfo":Landroidx/media3/ui/TrackSelectionView$TrackInfo;
    iget-object v2, v1, Landroidx/media3/ui/TrackSelectionView$TrackInfo;->trackGroup:Landroidx/media3/common/Tracks$Group;

    invoke-virtual {v2}, Landroidx/media3/common/Tracks$Group;->getMediaTrackGroup()Landroidx/media3/common/TrackGroup;

    move-result-object v2

    .line 364
    .local v2, "mediaTrackGroup":Landroidx/media3/common/TrackGroup;
    iget v3, v1, Landroidx/media3/ui/TrackSelectionView$TrackInfo;->trackIndex:I

    .line 365
    .local v3, "trackIndex":I
    iget-object v4, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    invoke-interface {v4, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/common/TrackSelectionOverride;

    .line 366
    .local v4, "override":Landroidx/media3/common/TrackSelectionOverride;
    if-nez v4, :cond_1

    .line 368
    iget-boolean v0, p0, Landroidx/media3/ui/TrackSelectionView;->allowMultipleOverrides:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 370
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 372
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    new-instance v5, Landroidx/media3/common/TrackSelectionOverride;

    .line 374
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v6}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v6

    invoke-direct {v5, v2, v6}, Landroidx/media3/common/TrackSelectionOverride;-><init>(Landroidx/media3/common/TrackGroup;Ljava/util/List;)V

    .line 372
    invoke-interface {v0, v2, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 377
    :cond_1
    new-instance v5, Ljava/util/ArrayList;

    iget-object v6, v4, Landroidx/media3/common/TrackSelectionOverride;->trackIndices:Lcom/google/common/collect/ImmutableList;

    invoke-direct {v5, v6}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 378
    .local v5, "trackIndices":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    move-object v6, p1

    check-cast v6, Landroid/widget/CheckedTextView;

    invoke-virtual {v6}, Landroid/widget/CheckedTextView;->isChecked()Z

    move-result v6

    .line 379
    .local v6, "isCurrentlySelected":Z
    iget-object v7, v1, Landroidx/media3/ui/TrackSelectionView$TrackInfo;->trackGroup:Landroidx/media3/common/Tracks$Group;

    invoke-direct {p0, v7}, Landroidx/media3/ui/TrackSelectionView;->shouldEnableAdaptiveSelection(Landroidx/media3/common/Tracks$Group;)Z

    move-result v7

    .line 380
    .local v7, "isAdaptiveAllowed":Z
    if-nez v7, :cond_2

    invoke-direct {p0}, Landroidx/media3/ui/TrackSelectionView;->shouldEnableMultiGroupSelection()Z

    move-result v8

    if-eqz v8, :cond_3

    :cond_2
    const/4 v0, 0x1

    .line 381
    .local v0, "isUsingCheckBox":Z
    :cond_3
    if-eqz v6, :cond_5

    if-eqz v0, :cond_5

    .line 383
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 384
    invoke-virtual {v5}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_4

    .line 386
    iget-object v8, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    invoke-interface {v8, v2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 388
    :cond_4
    iget-object v8, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    new-instance v9, Landroidx/media3/common/TrackSelectionOverride;

    invoke-direct {v9, v2, v5}, Landroidx/media3/common/TrackSelectionOverride;-><init>(Landroidx/media3/common/TrackGroup;Ljava/util/List;)V

    invoke-interface {v8, v2, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 390
    :cond_5
    if-nez v6, :cond_7

    .line 391
    if-eqz v7, :cond_6

    .line 393
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 394
    iget-object v8, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    new-instance v9, Landroidx/media3/common/TrackSelectionOverride;

    invoke-direct {v9, v2, v5}, Landroidx/media3/common/TrackSelectionOverride;-><init>(Landroidx/media3/common/TrackGroup;Ljava/util/List;)V

    invoke-interface {v8, v2, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 397
    :cond_6
    iget-object v8, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    new-instance v9, Landroidx/media3/common/TrackSelectionOverride;

    .line 399
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-static {v10}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v10

    invoke-direct {v9, v2, v10}, Landroidx/media3/common/TrackSelectionOverride;-><init>(Landroidx/media3/common/TrackGroup;Ljava/util/List;)V

    .line 397
    invoke-interface {v8, v2, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 403
    .end local v0    # "isUsingCheckBox":Z
    .end local v5    # "trackIndices":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    .end local v6    # "isCurrentlySelected":Z
    .end local v7    # "isAdaptiveAllowed":Z
    :cond_7
    :goto_0
    return-void
.end method

.method private shouldEnableAdaptiveSelection(Landroidx/media3/common/Tracks$Group;)Z
    .locals 1
    .param p1, "trackGroup"    # Landroidx/media3/common/Tracks$Group;

    .line 406
    iget-boolean v0, p0, Landroidx/media3/ui/TrackSelectionView;->allowAdaptiveSelections:Z

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Landroidx/media3/common/Tracks$Group;->isAdaptiveSupported()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private shouldEnableMultiGroupSelection()Z
    .locals 2

    .line 410
    iget-boolean v0, p0, Landroidx/media3/ui/TrackSelectionView;->allowMultipleOverrides:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->trackGroups:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return v1
.end method

.method private updateViewStates()V
    .locals 8

    .line 320
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->disableView:Landroid/widget/CheckedTextView;

    iget-boolean v1, p0, Landroidx/media3/ui/TrackSelectionView;->isDisabled:Z

    invoke-virtual {v0, v1}, Landroid/widget/CheckedTextView;->setChecked(Z)V

    .line 321
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->defaultView:Landroid/widget/CheckedTextView;

    iget-boolean v1, p0, Landroidx/media3/ui/TrackSelectionView;->isDisabled:Z

    const/4 v2, 0x0

    if-nez v1, :cond_0

    iget-object v1, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    move v1, v2

    :goto_0
    invoke-virtual {v0, v1}, Landroid/widget/CheckedTextView;->setChecked(Z)V

    .line 322
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    iget-object v1, p0, Landroidx/media3/ui/TrackSelectionView;->trackViews:[[Landroid/widget/CheckedTextView;

    array-length v1, v1

    if-ge v0, v1, :cond_3

    .line 324
    iget-object v1, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    iget-object v3, p0, Landroidx/media3/ui/TrackSelectionView;->trackGroups:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/common/Tracks$Group;

    invoke-virtual {v3}, Landroidx/media3/common/Tracks$Group;->getMediaTrackGroup()Landroidx/media3/common/TrackGroup;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/common/TrackSelectionOverride;

    .line 325
    .local v1, "override":Landroidx/media3/common/TrackSelectionOverride;
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_2
    iget-object v4, p0, Landroidx/media3/ui/TrackSelectionView;->trackViews:[[Landroid/widget/CheckedTextView;

    aget-object v4, v4, v0

    array-length v5, v4

    if-ge v3, v5, :cond_2

    .line 326
    if-eqz v1, :cond_1

    .line 327
    aget-object v4, v4, v3

    invoke-virtual {v4}, Landroid/widget/CheckedTextView;->getTag()Ljava/lang/Object;

    move-result-object v4

    invoke-static {v4}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/ui/TrackSelectionView$TrackInfo;

    .line 328
    .local v4, "trackInfo":Landroidx/media3/ui/TrackSelectionView$TrackInfo;
    iget-object v5, p0, Landroidx/media3/ui/TrackSelectionView;->trackViews:[[Landroid/widget/CheckedTextView;

    aget-object v5, v5, v0

    aget-object v5, v5, v3

    iget-object v6, v1, Landroidx/media3/common/TrackSelectionOverride;->trackIndices:Lcom/google/common/collect/ImmutableList;

    iget v7, v4, Landroidx/media3/ui/TrackSelectionView$TrackInfo;->trackIndex:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/google/common/collect/ImmutableList;->contains(Ljava/lang/Object;)Z

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/CheckedTextView;->setChecked(Z)V

    .line 329
    .end local v4    # "trackInfo":Landroidx/media3/ui/TrackSelectionView$TrackInfo;
    goto :goto_3

    .line 330
    :cond_1
    aget-object v4, v4, v3

    invoke-virtual {v4, v2}, Landroid/widget/CheckedTextView;->setChecked(Z)V

    .line 325
    :goto_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 322
    .end local v1    # "override":Landroidx/media3/common/TrackSelectionOverride;
    .end local v3    # "j":I
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 334
    .end local v0    # "i":I
    :cond_3
    return-void
.end method

.method private updateViews()V
    .locals 12

    .line 262
    invoke-virtual {p0}, Landroidx/media3/ui/TrackSelectionView;->getChildCount()I

    move-result v0

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    .local v0, "i":I
    :goto_0
    const/4 v2, 0x3

    if-lt v0, v2, :cond_0

    .line 263
    invoke-virtual {p0, v0}, Landroidx/media3/ui/TrackSelectionView;->removeViewAt(I)V

    .line 262
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 266
    .end local v0    # "i":I
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->trackGroups:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    const/4 v2, 0x0

    if-eqz v0, :cond_1

    .line 268
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->disableView:Landroid/widget/CheckedTextView;

    invoke-virtual {v0, v2}, Landroid/widget/CheckedTextView;->setEnabled(Z)V

    .line 269
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->defaultView:Landroid/widget/CheckedTextView;

    invoke-virtual {v0, v2}, Landroid/widget/CheckedTextView;->setEnabled(Z)V

    .line 270
    return-void

    .line 272
    :cond_1
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->disableView:Landroid/widget/CheckedTextView;

    invoke-virtual {v0, v1}, Landroid/widget/CheckedTextView;->setEnabled(Z)V

    .line 273
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->defaultView:Landroid/widget/CheckedTextView;

    invoke-virtual {v0, v1}, Landroid/widget/CheckedTextView;->setEnabled(Z)V

    .line 276
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->trackGroups:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    new-array v0, v0, [[Landroid/widget/CheckedTextView;

    iput-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->trackViews:[[Landroid/widget/CheckedTextView;

    .line 277
    invoke-direct {p0}, Landroidx/media3/ui/TrackSelectionView;->shouldEnableMultiGroupSelection()Z

    move-result v0

    .line 278
    .local v0, "enableMultipleChoiceForMultipleOverrides":Z
    const/4 v3, 0x0

    .local v3, "trackGroupIndex":I
    :goto_1
    iget-object v4, p0, Landroidx/media3/ui/TrackSelectionView;->trackGroups:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-ge v3, v4, :cond_9

    .line 279
    iget-object v4, p0, Landroidx/media3/ui/TrackSelectionView;->trackGroups:Ljava/util/List;

    invoke-interface {v4, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/common/Tracks$Group;

    .line 280
    .local v4, "trackGroup":Landroidx/media3/common/Tracks$Group;
    invoke-direct {p0, v4}, Landroidx/media3/ui/TrackSelectionView;->shouldEnableAdaptiveSelection(Landroidx/media3/common/Tracks$Group;)Z

    move-result v5

    .line 281
    .local v5, "enableMultipleChoiceForAdaptiveSelections":Z
    iget-object v6, p0, Landroidx/media3/ui/TrackSelectionView;->trackViews:[[Landroid/widget/CheckedTextView;

    iget v7, v4, Landroidx/media3/common/Tracks$Group;->length:I

    new-array v7, v7, [Landroid/widget/CheckedTextView;

    aput-object v7, v6, v3

    .line 283
    iget v6, v4, Landroidx/media3/common/Tracks$Group;->length:I

    new-array v6, v6, [Landroidx/media3/ui/TrackSelectionView$TrackInfo;

    .line 284
    .local v6, "trackInfos":[Landroidx/media3/ui/TrackSelectionView$TrackInfo;
    const/4 v7, 0x0

    .local v7, "trackIndex":I
    :goto_2
    iget v8, v4, Landroidx/media3/common/Tracks$Group;->length:I

    if-ge v7, v8, :cond_2

    .line 285
    new-instance v8, Landroidx/media3/ui/TrackSelectionView$TrackInfo;

    invoke-direct {v8, v4, v7}, Landroidx/media3/ui/TrackSelectionView$TrackInfo;-><init>(Landroidx/media3/common/Tracks$Group;I)V

    aput-object v8, v6, v7

    .line 284
    add-int/lit8 v7, v7, 0x1

    goto :goto_2

    .line 287
    .end local v7    # "trackIndex":I
    :cond_2
    iget-object v7, p0, Landroidx/media3/ui/TrackSelectionView;->trackInfoComparator:Ljava/util/Comparator;

    if-eqz v7, :cond_3

    .line 288
    invoke-static {v6, v7}, Ljava/util/Arrays;->sort([Ljava/lang/Object;Ljava/util/Comparator;)V

    .line 291
    :cond_3
    const/4 v7, 0x0

    .restart local v7    # "trackIndex":I
    :goto_3
    array-length v8, v6

    if-ge v7, v8, :cond_8

    .line 292
    if-nez v7, :cond_4

    .line 293
    iget-object v8, p0, Landroidx/media3/ui/TrackSelectionView;->inflater:Landroid/view/LayoutInflater;

    sget v9, Landroidx/media3/ui/R$layout;->exo_list_divider:I

    invoke-virtual {v8, v9, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v8

    invoke-virtual {p0, v8}, Landroidx/media3/ui/TrackSelectionView;->addView(Landroid/view/View;)V

    .line 296
    :cond_4
    if-nez v5, :cond_6

    if-eqz v0, :cond_5

    goto :goto_4

    .line 298
    :cond_5
    const v8, 0x109000f

    goto :goto_5

    .line 297
    :cond_6
    :goto_4
    const v8, 0x1090010

    .line 298
    :goto_5
    nop

    .line 299
    .local v8, "trackViewLayoutId":I
    iget-object v9, p0, Landroidx/media3/ui/TrackSelectionView;->inflater:Landroid/view/LayoutInflater;

    .line 300
    invoke-virtual {v9, v8, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/CheckedTextView;

    .line 301
    .local v9, "trackView":Landroid/widget/CheckedTextView;
    iget v10, p0, Landroidx/media3/ui/TrackSelectionView;->selectableItemBackgroundResourceId:I

    invoke-virtual {v9, v10}, Landroid/widget/CheckedTextView;->setBackgroundResource(I)V

    .line 302
    iget-object v10, p0, Landroidx/media3/ui/TrackSelectionView;->trackNameProvider:Landroidx/media3/ui/TrackNameProvider;

    aget-object v11, v6, v7

    invoke-virtual {v11}, Landroidx/media3/ui/TrackSelectionView$TrackInfo;->getFormat()Landroidx/media3/common/Format;

    move-result-object v11

    invoke-interface {v10, v11}, Landroidx/media3/ui/TrackNameProvider;->getTrackName(Landroidx/media3/common/Format;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/widget/CheckedTextView;->setText(Ljava/lang/CharSequence;)V

    .line 303
    aget-object v10, v6, v7

    invoke-virtual {v9, v10}, Landroid/widget/CheckedTextView;->setTag(Ljava/lang/Object;)V

    .line 304
    invoke-virtual {v4, v7}, Landroidx/media3/common/Tracks$Group;->isTrackSupported(I)Z

    move-result v10

    if-eqz v10, :cond_7

    .line 305
    invoke-virtual {v9, v1}, Landroid/widget/CheckedTextView;->setFocusable(Z)V

    .line 306
    iget-object v10, p0, Landroidx/media3/ui/TrackSelectionView;->componentListener:Landroidx/media3/ui/TrackSelectionView$ComponentListener;

    invoke-virtual {v9, v10}, Landroid/widget/CheckedTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_6

    .line 308
    :cond_7
    invoke-virtual {v9, v2}, Landroid/widget/CheckedTextView;->setFocusable(Z)V

    .line 309
    invoke-virtual {v9, v2}, Landroid/widget/CheckedTextView;->setEnabled(Z)V

    .line 311
    :goto_6
    iget-object v10, p0, Landroidx/media3/ui/TrackSelectionView;->trackViews:[[Landroid/widget/CheckedTextView;

    aget-object v10, v10, v3

    aput-object v9, v10, v7

    .line 312
    invoke-virtual {p0, v9}, Landroidx/media3/ui/TrackSelectionView;->addView(Landroid/view/View;)V

    .line 291
    .end local v8    # "trackViewLayoutId":I
    .end local v9    # "trackView":Landroid/widget/CheckedTextView;
    add-int/lit8 v7, v7, 0x1

    goto :goto_3

    .line 278
    .end local v4    # "trackGroup":Landroidx/media3/common/Tracks$Group;
    .end local v5    # "enableMultipleChoiceForAdaptiveSelections":Z
    .end local v6    # "trackInfos":[Landroidx/media3/ui/TrackSelectionView$TrackInfo;
    .end local v7    # "trackIndex":I
    :cond_8
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_1

    .line 316
    .end local v3    # "trackGroupIndex":I
    :cond_9
    invoke-direct {p0}, Landroidx/media3/ui/TrackSelectionView;->updateViewStates()V

    .line 317
    return-void
.end method


# virtual methods
.method public getIsDisabled()Z
    .locals 1

    .line 250
    iget-boolean v0, p0, Landroidx/media3/ui/TrackSelectionView;->isDisabled:Z

    return v0
.end method

.method public getOverrides()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Landroidx/media3/common/TrackGroup;",
            "Landroidx/media3/common/TrackSelectionOverride;",
            ">;"
        }
    .end annotation

    .line 255
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    return-object v0
.end method

.method public init(Ljava/util/List;ZLjava/util/Map;Ljava/util/Comparator;Landroidx/media3/ui/TrackSelectionView$TrackSelectionListener;)V
    .locals 2
    .param p2, "isDisabled"    # Z
    .param p5, "listener"    # Landroidx/media3/ui/TrackSelectionView$TrackSelectionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroidx/media3/common/Tracks$Group;",
            ">;Z",
            "Ljava/util/Map<",
            "Landroidx/media3/common/TrackGroup;",
            "Landroidx/media3/common/TrackSelectionOverride;",
            ">;",
            "Ljava/util/Comparator<",
            "Landroidx/media3/common/Format;",
            ">;",
            "Landroidx/media3/ui/TrackSelectionView$TrackSelectionListener;",
            ")V"
        }
    .end annotation

    .line 234
    .local p1, "trackGroups":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/Tracks$Group;>;"
    .local p3, "overrides":Ljava/util/Map;, "Ljava/util/Map<Landroidx/media3/common/TrackGroup;Landroidx/media3/common/TrackSelectionOverride;>;"
    .local p4, "trackFormatComparator":Ljava/util/Comparator;, "Ljava/util/Comparator<Landroidx/media3/common/Format;>;"
    iput-boolean p2, p0, Landroidx/media3/ui/TrackSelectionView;->isDisabled:Z

    .line 235
    nop

    .line 236
    if-nez p4, :cond_0

    .line 237
    const/4 v0, 0x0

    goto :goto_0

    .line 238
    :cond_0
    new-instance v0, Landroidx/media3/ui/TrackSelectionView$$ExternalSyntheticLambda0;

    invoke-direct {v0, p4}, Landroidx/media3/ui/TrackSelectionView$$ExternalSyntheticLambda0;-><init>(Ljava/util/Comparator;)V

    :goto_0
    iput-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->trackInfoComparator:Ljava/util/Comparator;

    .line 239
    iput-object p5, p0, Landroidx/media3/ui/TrackSelectionView;->listener:Landroidx/media3/ui/TrackSelectionView$TrackSelectionListener;

    .line 241
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->trackGroups:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 242
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->trackGroups:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 243
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 244
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    iget-boolean v1, p0, Landroidx/media3/ui/TrackSelectionView;->allowMultipleOverrides:Z

    invoke-static {p3, p1, v1}, Landroidx/media3/ui/TrackSelectionView;->filterOverrides(Ljava/util/Map;Ljava/util/List;Z)Ljava/util/Map;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 245
    invoke-direct {p0}, Landroidx/media3/ui/TrackSelectionView;->updateViews()V

    .line 246
    return-void
.end method

.method public setAllowAdaptiveSelections(Z)V
    .locals 1
    .param p1, "allowAdaptiveSelections"    # Z

    .line 168
    iget-boolean v0, p0, Landroidx/media3/ui/TrackSelectionView;->allowAdaptiveSelections:Z

    if-eq v0, p1, :cond_0

    .line 169
    iput-boolean p1, p0, Landroidx/media3/ui/TrackSelectionView;->allowAdaptiveSelections:Z

    .line 170
    invoke-direct {p0}, Landroidx/media3/ui/TrackSelectionView;->updateViews()V

    .line 172
    :cond_0
    return-void
.end method

.method public setAllowMultipleOverrides(Z)V
    .locals 3
    .param p1, "allowMultipleOverrides"    # Z

    .line 181
    iget-boolean v0, p0, Landroidx/media3/ui/TrackSelectionView;->allowMultipleOverrides:Z

    if-eq v0, p1, :cond_1

    .line 182
    iput-boolean p1, p0, Landroidx/media3/ui/TrackSelectionView;->allowMultipleOverrides:Z

    .line 183
    if-nez p1, :cond_0

    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_0

    .line 185
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    iget-object v1, p0, Landroidx/media3/ui/TrackSelectionView;->trackGroups:Ljava/util/List;

    .line 186
    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroidx/media3/ui/TrackSelectionView;->filterOverrides(Ljava/util/Map;Ljava/util/List;Z)Ljava/util/Map;

    move-result-object v0

    .line 187
    .local v0, "filteredOverrides":Ljava/util/Map;, "Ljava/util/Map<Landroidx/media3/common/TrackGroup;Landroidx/media3/common/TrackSelectionOverride;>;"
    iget-object v1, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->clear()V

    .line 188
    iget-object v1, p0, Landroidx/media3/ui/TrackSelectionView;->overrides:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 190
    .end local v0    # "filteredOverrides":Ljava/util/Map;, "Ljava/util/Map<Landroidx/media3/common/TrackGroup;Landroidx/media3/common/TrackSelectionOverride;>;"
    :cond_0
    invoke-direct {p0}, Landroidx/media3/ui/TrackSelectionView;->updateViews()V

    .line 192
    :cond_1
    return-void
.end method

.method public setShowDisableOption(Z)V
    .locals 2
    .param p1, "showDisableOption"    # Z

    .line 200
    iget-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->disableView:Landroid/widget/CheckedTextView;

    if-eqz p1, :cond_0

    const/4 v1, 0x0

    goto :goto_0

    :cond_0
    const/16 v1, 0x8

    :goto_0
    invoke-virtual {v0, v1}, Landroid/widget/CheckedTextView;->setVisibility(I)V

    .line 201
    return-void
.end method

.method public setTrackNameProvider(Landroidx/media3/ui/TrackNameProvider;)V
    .locals 1
    .param p1, "trackNameProvider"    # Landroidx/media3/ui/TrackNameProvider;

    .line 210
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/ui/TrackNameProvider;

    iput-object v0, p0, Landroidx/media3/ui/TrackSelectionView;->trackNameProvider:Landroidx/media3/ui/TrackNameProvider;

    .line 211
    invoke-direct {p0}, Landroidx/media3/ui/TrackSelectionView;->updateViews()V

    .line 212
    return-void
.end method
