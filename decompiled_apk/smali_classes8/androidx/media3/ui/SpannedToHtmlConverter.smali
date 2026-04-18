.class final Landroidx/media3/ui/SpannedToHtmlConverter;
.super Ljava/lang/Object;
.source "SpannedToHtmlConverter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;,
        Landroidx/media3/ui/SpannedToHtmlConverter$Transition;,
        Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;
    }
.end annotation


# static fields
.field private static final NEWLINE_PATTERN:Ljava/util/regex/Pattern;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 58
    const-string v0, "(&#13;)?&#10;"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/media3/ui/SpannedToHtmlConverter;->NEWLINE_PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static convert(Ljava/lang/CharSequence;F)Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    .locals 13
    .param p0, "text"    # Ljava/lang/CharSequence;
    .param p1, "displayDensity"    # F

    .line 83
    const/4 v0, 0x0

    if-nez p0, :cond_0

    .line 84
    new-instance v1, Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;

    const-string v2, ""

    invoke-static {}, Lcom/google/common/collect/ImmutableMap;->of()Lcom/google/common/collect/ImmutableMap;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;-><init>(Ljava/lang/String;Ljava/util/Map;Landroidx/media3/ui/SpannedToHtmlConverter$1;)V

    return-object v1

    .line 86
    :cond_0
    instance-of v1, p0, Landroid/text/Spanned;

    if-nez v1, :cond_1

    .line 87
    new-instance v1, Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;

    invoke-static {p0}, Landroidx/media3/ui/SpannedToHtmlConverter;->escapeHtml(Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/google/common/collect/ImmutableMap;->of()Lcom/google/common/collect/ImmutableMap;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;-><init>(Ljava/lang/String;Ljava/util/Map;Landroidx/media3/ui/SpannedToHtmlConverter$1;)V

    return-object v1

    .line 89
    :cond_1
    move-object v1, p0

    check-cast v1, Landroid/text/Spanned;

    .line 92
    .local v1, "spanned":Landroid/text/Spanned;
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 94
    .local v2, "backgroundColors":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Integer;>;"
    invoke-interface {v1}, Landroid/text/Spanned;->length()I

    move-result v3

    const-class v4, Landroid/text/style/BackgroundColorSpan;

    const/4 v5, 0x0

    invoke-interface {v1, v5, v3, v4}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Landroid/text/style/BackgroundColorSpan;

    array-length v4, v3

    :goto_0
    if-ge v5, v4, :cond_2

    aget-object v6, v3, v5

    .line 95
    .local v6, "backgroundColorSpan":Landroid/text/style/BackgroundColorSpan;
    invoke-virtual {v6}, Landroid/text/style/BackgroundColorSpan;->getBackgroundColor()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-interface {v2, v7}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 94
    .end local v6    # "backgroundColorSpan":Landroid/text/style/BackgroundColorSpan;
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 97
    :cond_2
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 98
    .local v3, "cssRuleSets":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    .line 99
    .local v5, "backgroundColor":I
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "bg_"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 100
    invoke-static {v6}, Landroidx/media3/ui/HtmlUtils;->cssAllClassDescendantsSelector(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 101
    invoke-static {v5}, Landroidx/media3/ui/HtmlUtils;->toCssRgba(I)Ljava/lang/String;

    move-result-object v7

    filled-new-array {v7}, [Ljava/lang/Object;

    move-result-object v7

    const-string v8, "background-color:%s;"

    invoke-static {v8, v7}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 99
    invoke-virtual {v3, v6, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    .end local v5    # "backgroundColor":I
    goto :goto_1

    .line 104
    :cond_3
    invoke-static {v1, p1}, Landroidx/media3/ui/SpannedToHtmlConverter;->findSpanTransitions(Landroid/text/Spanned;F)Landroid/util/SparseArray;

    move-result-object v4

    .line 105
    .local v4, "spanTransitions":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroidx/media3/ui/SpannedToHtmlConverter$Transition;>;"
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-interface {v1}, Landroid/text/Spanned;->length()I

    move-result v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 106
    .local v5, "html":Ljava/lang/StringBuilder;
    const/4 v6, 0x0

    .line 107
    .local v6, "previousTransition":I
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_2
    invoke-virtual {v4}, Landroid/util/SparseArray;->size()I

    move-result v8

    if-ge v7, v8, :cond_6

    .line 108
    invoke-virtual {v4, v7}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v8

    .line 109
    .local v8, "index":I
    invoke-interface {v1, v6, v8}, Landroid/text/Spanned;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v9

    invoke-static {v9}, Landroidx/media3/ui/SpannedToHtmlConverter;->escapeHtml(Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 111
    invoke-virtual {v4, v8}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroidx/media3/ui/SpannedToHtmlConverter$Transition;

    .line 112
    .local v9, "transition":Landroidx/media3/ui/SpannedToHtmlConverter$Transition;
    invoke-static {v9}, Landroidx/media3/ui/SpannedToHtmlConverter$Transition;->access$100(Landroidx/media3/ui/SpannedToHtmlConverter$Transition;)Ljava/util/List;

    move-result-object v10

    invoke-static {}, Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;->access$200()Ljava/util/Comparator;

    move-result-object v11

    invoke-static {v10, v11}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 113
    invoke-static {v9}, Landroidx/media3/ui/SpannedToHtmlConverter$Transition;->access$100(Landroidx/media3/ui/SpannedToHtmlConverter$Transition;)Ljava/util/List;

    move-result-object v10

    invoke-interface {v10}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :goto_3
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_4

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;

    .line 114
    .local v11, "spanInfo":Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;
    iget-object v12, v11, Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;->closingTag:Ljava/lang/String;

    invoke-virtual {v5, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 115
    .end local v11    # "spanInfo":Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;
    goto :goto_3

    .line 116
    :cond_4
    invoke-static {v9}, Landroidx/media3/ui/SpannedToHtmlConverter$Transition;->access$300(Landroidx/media3/ui/SpannedToHtmlConverter$Transition;)Ljava/util/List;

    move-result-object v10

    invoke-static {}, Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;->access$400()Ljava/util/Comparator;

    move-result-object v11

    invoke-static {v10, v11}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 117
    invoke-static {v9}, Landroidx/media3/ui/SpannedToHtmlConverter$Transition;->access$300(Landroidx/media3/ui/SpannedToHtmlConverter$Transition;)Ljava/util/List;

    move-result-object v10

    invoke-interface {v10}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :goto_4
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_5

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;

    .line 118
    .restart local v11    # "spanInfo":Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;
    iget-object v12, v11, Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;->openingTag:Ljava/lang/String;

    invoke-virtual {v5, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 119
    .end local v11    # "spanInfo":Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;
    goto :goto_4

    .line 120
    :cond_5
    move v6, v8

    .line 107
    .end local v8    # "index":I
    .end local v9    # "transition":Landroidx/media3/ui/SpannedToHtmlConverter$Transition;
    add-int/lit8 v7, v7, 0x1

    goto :goto_2

    .line 123
    .end local v7    # "i":I
    :cond_6
    invoke-interface {v1}, Landroid/text/Spanned;->length()I

    move-result v7

    invoke-interface {v1, v6, v7}, Landroid/text/Spanned;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-static {v7}, Landroidx/media3/ui/SpannedToHtmlConverter;->escapeHtml(Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 125
    new-instance v7, Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8, v3, v0}, Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;-><init>(Ljava/lang/String;Ljava/util/Map;Landroidx/media3/ui/SpannedToHtmlConverter$1;)V

    return-object v7
.end method

.method private static escapeHtml(Ljava/lang/CharSequence;)Ljava/lang/String;
    .locals 3
    .param p0, "text"    # Ljava/lang/CharSequence;

    .line 302
    invoke-static {p0}, Landroid/text/Html;->escapeHtml(Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 303
    .local v0, "escaped":Ljava/lang/String;
    sget-object v1, Landroidx/media3/ui/SpannedToHtmlConverter;->NEWLINE_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v1, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    const-string v2, "<br>"

    invoke-virtual {v1, v2}, Ljava/util/regex/Matcher;->replaceAll(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private static findSpanTransitions(Landroid/text/Spanned;F)Landroid/util/SparseArray;
    .locals 18
    .param p0, "spanned"    # Landroid/text/Spanned;
    .param p1, "displayDensity"    # F
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/text/Spanned;",
            "F)",
            "Landroid/util/SparseArray<",
            "Landroidx/media3/ui/SpannedToHtmlConverter$Transition;",
            ">;"
        }
    .end annotation

    .line 130
    move-object/from16 v0, p0

    new-instance v1, Landroid/util/SparseArray;

    invoke-direct {v1}, Landroid/util/SparseArray;-><init>()V

    .line 132
    .local v1, "spanTransitions":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroidx/media3/ui/SpannedToHtmlConverter$Transition;>;"
    invoke-interface/range {p0 .. p0}, Landroid/text/Spanned;->length()I

    move-result v2

    const-class v3, Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-interface {v0, v4, v2, v3}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v2

    array-length v3, v2

    :goto_0
    if-ge v4, v3, :cond_1

    aget-object v5, v2, v4

    .line 133
    .local v5, "span":Ljava/lang/Object;
    move/from16 v6, p1

    invoke-static {v5, v6}, Landroidx/media3/ui/SpannedToHtmlConverter;->getOpeningTag(Ljava/lang/Object;F)Ljava/lang/String;

    move-result-object v13

    .line 134
    .local v13, "openingTag":Ljava/lang/String;
    invoke-static {v5}, Landroidx/media3/ui/SpannedToHtmlConverter;->getClosingTag(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v14

    .line 135
    .local v14, "closingTag":Ljava/lang/String;
    invoke-interface {v0, v5}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v15

    .line 136
    .local v15, "spanStart":I
    invoke-interface {v0, v5}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v12

    .line 137
    .local v12, "spanEnd":I
    if-eqz v13, :cond_0

    .line 138
    invoke-static {v14}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 139
    new-instance v16, Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;

    const/16 v17, 0x0

    move-object/from16 v7, v16

    move v8, v15

    move v9, v12

    move-object v10, v13

    move-object v11, v14

    move v0, v12

    .end local v12    # "spanEnd":I
    .local v0, "spanEnd":I
    move-object/from16 v12, v17

    invoke-direct/range {v7 .. v12}, Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;-><init>(IILjava/lang/String;Ljava/lang/String;Landroidx/media3/ui/SpannedToHtmlConverter$1;)V

    .line 140
    .local v7, "spanInfo":Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;
    invoke-static {v1, v15}, Landroidx/media3/ui/SpannedToHtmlConverter;->getOrCreate(Landroid/util/SparseArray;I)Landroidx/media3/ui/SpannedToHtmlConverter$Transition;

    move-result-object v8

    invoke-static {v8}, Landroidx/media3/ui/SpannedToHtmlConverter$Transition;->access$300(Landroidx/media3/ui/SpannedToHtmlConverter$Transition;)Ljava/util/List;

    move-result-object v8

    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 141
    invoke-static {v1, v0}, Landroidx/media3/ui/SpannedToHtmlConverter;->getOrCreate(Landroid/util/SparseArray;I)Landroidx/media3/ui/SpannedToHtmlConverter$Transition;

    move-result-object v8

    invoke-static {v8}, Landroidx/media3/ui/SpannedToHtmlConverter$Transition;->access$100(Landroidx/media3/ui/SpannedToHtmlConverter$Transition;)Ljava/util/List;

    move-result-object v8

    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 137
    .end local v0    # "spanEnd":I
    .end local v7    # "spanInfo":Landroidx/media3/ui/SpannedToHtmlConverter$SpanInfo;
    .restart local v12    # "spanEnd":I
    :cond_0
    move v0, v12

    .line 132
    .end local v5    # "span":Ljava/lang/Object;
    .end local v12    # "spanEnd":I
    .end local v13    # "openingTag":Ljava/lang/String;
    .end local v14    # "closingTag":Ljava/lang/String;
    .end local v15    # "spanStart":I
    :goto_1
    add-int/lit8 v4, v4, 0x1

    move-object/from16 v0, p0

    goto :goto_0

    .line 145
    :cond_1
    move/from16 v6, p1

    return-object v1
.end method

.method private static getClosingTag(Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p0, "span"    # Ljava/lang/Object;

    .line 217
    instance-of v0, p0, Landroid/text/style/StrikethroughSpan;

    const-string v1, "</span>"

    if-nez v0, :cond_6

    instance-of v0, p0, Landroid/text/style/ForegroundColorSpan;

    if-nez v0, :cond_6

    instance-of v0, p0, Landroid/text/style/BackgroundColorSpan;

    if-nez v0, :cond_6

    instance-of v0, p0, Landroidx/media3/common/text/HorizontalTextInVerticalContextSpan;

    if-nez v0, :cond_6

    instance-of v0, p0, Landroid/text/style/AbsoluteSizeSpan;

    if-nez v0, :cond_6

    instance-of v0, p0, Landroid/text/style/RelativeSizeSpan;

    if-nez v0, :cond_6

    instance-of v0, p0, Landroidx/media3/common/text/TextEmphasisSpan;

    if-eqz v0, :cond_0

    goto :goto_2

    .line 225
    :cond_0
    instance-of v0, p0, Landroid/text/style/TypefaceSpan;

    const/4 v2, 0x0

    if-eqz v0, :cond_2

    .line 226
    move-object v0, p0

    check-cast v0, Landroid/text/style/TypefaceSpan;

    invoke-virtual {v0}, Landroid/text/style/TypefaceSpan;->getFamily()Ljava/lang/String;

    move-result-object v0

    .line 227
    .local v0, "fontFamily":Ljava/lang/String;
    if-eqz v0, :cond_1

    goto :goto_0

    :cond_1
    move-object v1, v2

    :goto_0
    return-object v1

    .line 228
    .end local v0    # "fontFamily":Ljava/lang/String;
    :cond_2
    instance-of v0, p0, Landroid/text/style/StyleSpan;

    if-eqz v0, :cond_3

    .line 229
    move-object v0, p0

    check-cast v0, Landroid/text/style/StyleSpan;

    invoke-virtual {v0}, Landroid/text/style/StyleSpan;->getStyle()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 235
    goto :goto_1

    :pswitch_0
    const-string v0, "</i></b>"

    return-object v0

    .line 233
    :pswitch_1
    const-string v0, "</i>"

    return-object v0

    .line 231
    :pswitch_2
    const-string v0, "</b>"

    return-object v0

    .line 237
    :cond_3
    instance-of v0, p0, Landroidx/media3/common/text/RubySpan;

    if-eqz v0, :cond_4

    .line 238
    move-object v0, p0

    check-cast v0, Landroidx/media3/common/text/RubySpan;

    .line 239
    .local v0, "rubySpan":Landroidx/media3/common/text/RubySpan;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "<rt>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, v0, Landroidx/media3/common/text/RubySpan;->rubyText:Ljava/lang/String;

    invoke-static {v2}, Landroidx/media3/ui/SpannedToHtmlConverter;->escapeHtml(Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "</rt></ruby>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 240
    .end local v0    # "rubySpan":Landroidx/media3/common/text/RubySpan;
    :cond_4
    instance-of v0, p0, Landroid/text/style/UnderlineSpan;

    if-eqz v0, :cond_5

    .line 241
    const-string v0, "</u>"

    return-object v0

    .line 243
    :cond_5
    :goto_1
    return-object v2

    .line 224
    :cond_6
    :goto_2
    return-object v1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static getOpeningTag(Ljava/lang/Object;F)Ljava/lang/String;
    .locals 5
    .param p0, "span"    # Ljava/lang/Object;
    .param p1, "displayDensity"    # F

    .line 150
    instance-of v0, p0, Landroid/text/style/StrikethroughSpan;

    if-eqz v0, :cond_0

    .line 151
    const-string v0, "<span style=\'text-decoration:line-through;\'>"

    return-object v0

    .line 152
    :cond_0
    instance-of v0, p0, Landroid/text/style/ForegroundColorSpan;

    if-eqz v0, :cond_1

    .line 153
    move-object v0, p0

    check-cast v0, Landroid/text/style/ForegroundColorSpan;

    .line 154
    .local v0, "colorSpan":Landroid/text/style/ForegroundColorSpan;
    nop

    .line 155
    invoke-virtual {v0}, Landroid/text/style/ForegroundColorSpan;->getForegroundColor()I

    move-result v1

    invoke-static {v1}, Landroidx/media3/ui/HtmlUtils;->toCssRgba(I)Ljava/lang/String;

    move-result-object v1

    filled-new-array {v1}, [Ljava/lang/Object;

    move-result-object v1

    .line 154
    const-string v2, "<span style=\'color:%s;\'>"

    invoke-static {v2, v1}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 156
    .end local v0    # "colorSpan":Landroid/text/style/ForegroundColorSpan;
    :cond_1
    instance-of v0, p0, Landroid/text/style/BackgroundColorSpan;

    if-eqz v0, :cond_2

    .line 157
    move-object v0, p0

    check-cast v0, Landroid/text/style/BackgroundColorSpan;

    .line 158
    .local v0, "colorSpan":Landroid/text/style/BackgroundColorSpan;
    invoke-virtual {v0}, Landroid/text/style/BackgroundColorSpan;->getBackgroundColor()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    filled-new-array {v1}, [Ljava/lang/Object;

    move-result-object v1

    const-string v2, "<span class=\'bg_%s\'>"

    invoke-static {v2, v1}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 159
    .end local v0    # "colorSpan":Landroid/text/style/BackgroundColorSpan;
    :cond_2
    instance-of v0, p0, Landroidx/media3/common/text/HorizontalTextInVerticalContextSpan;

    if-eqz v0, :cond_3

    .line 160
    const-string v0, "<span style=\'text-combine-upright:all;\'>"

    return-object v0

    .line 161
    :cond_3
    instance-of v0, p0, Landroid/text/style/AbsoluteSizeSpan;

    if-eqz v0, :cond_5

    .line 162
    move-object v0, p0

    check-cast v0, Landroid/text/style/AbsoluteSizeSpan;

    .line 164
    .local v0, "absoluteSizeSpan":Landroid/text/style/AbsoluteSizeSpan;
    invoke-virtual {v0}, Landroid/text/style/AbsoluteSizeSpan;->getDip()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 165
    invoke-virtual {v0}, Landroid/text/style/AbsoluteSizeSpan;->getSize()I

    move-result v1

    int-to-float v1, v1

    goto :goto_0

    .line 166
    :cond_4
    invoke-virtual {v0}, Landroid/text/style/AbsoluteSizeSpan;->getSize()I

    move-result v1

    int-to-float v1, v1

    div-float/2addr v1, p1

    :goto_0
    nop

    .line 167
    .local v1, "sizeCssPx":F
    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    filled-new-array {v2}, [Ljava/lang/Object;

    move-result-object v2

    const-string v3, "<span style=\'font-size:%.2fpx;\'>"

    invoke-static {v3, v2}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 168
    .end local v0    # "absoluteSizeSpan":Landroid/text/style/AbsoluteSizeSpan;
    .end local v1    # "sizeCssPx":F
    :cond_5
    instance-of v0, p0, Landroid/text/style/RelativeSizeSpan;

    if-eqz v0, :cond_6

    .line 169
    move-object v0, p0

    check-cast v0, Landroid/text/style/RelativeSizeSpan;

    .line 170
    invoke-virtual {v0}, Landroid/text/style/RelativeSizeSpan;->getSizeChange()F

    move-result v0

    const/high16 v1, 0x42c80000    # 100.0f

    mul-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    filled-new-array {v0}, [Ljava/lang/Object;

    move-result-object v0

    .line 169
    const-string v1, "<span style=\'font-size:%.2f%%;\'>"

    invoke-static {v1, v0}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 171
    :cond_6
    instance-of v0, p0, Landroid/text/style/TypefaceSpan;

    const/4 v1, 0x0

    if-eqz v0, :cond_8

    .line 172
    move-object v0, p0

    check-cast v0, Landroid/text/style/TypefaceSpan;

    invoke-virtual {v0}, Landroid/text/style/TypefaceSpan;->getFamily()Ljava/lang/String;

    move-result-object v0

    .line 173
    .local v0, "fontFamily":Ljava/lang/String;
    if-eqz v0, :cond_7

    .line 174
    const-string v1, "<span style=\'font-family:\"%s\";\'>"

    filled-new-array {v0}, [Ljava/lang/Object;

    move-result-object v2

    invoke-static {v1, v2}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 175
    :cond_7
    nop

    .line 173
    :goto_1
    return-object v1

    .line 176
    .end local v0    # "fontFamily":Ljava/lang/String;
    :cond_8
    instance-of v0, p0, Landroid/text/style/StyleSpan;

    if-eqz v0, :cond_9

    .line 177
    move-object v0, p0

    check-cast v0, Landroid/text/style/StyleSpan;

    invoke-virtual {v0}, Landroid/text/style/StyleSpan;->getStyle()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 185
    return-object v1

    .line 183
    :pswitch_0
    const-string v0, "<b><i>"

    return-object v0

    .line 181
    :pswitch_1
    const-string v0, "<i>"

    return-object v0

    .line 179
    :pswitch_2
    const-string v0, "<b>"

    return-object v0

    .line 187
    :cond_9
    instance-of v0, p0, Landroidx/media3/common/text/RubySpan;

    if-eqz v0, :cond_a

    .line 188
    move-object v0, p0

    check-cast v0, Landroidx/media3/common/text/RubySpan;

    .line 189
    .local v0, "rubySpan":Landroidx/media3/common/text/RubySpan;
    iget v2, v0, Landroidx/media3/common/text/RubySpan;->position:I

    packed-switch v2, :pswitch_data_1

    .line 197
    :pswitch_3
    return-object v1

    .line 193
    :pswitch_4
    const-string v1, "<ruby style=\'ruby-position:under;\'>"

    return-object v1

    .line 191
    :pswitch_5
    const-string v1, "<ruby style=\'ruby-position:over;\'>"

    return-object v1

    .line 195
    :pswitch_6
    const-string v1, "<ruby style=\'ruby-position:unset;\'>"

    return-object v1

    .line 199
    .end local v0    # "rubySpan":Landroidx/media3/common/text/RubySpan;
    :cond_a
    instance-of v0, p0, Landroid/text/style/UnderlineSpan;

    if-eqz v0, :cond_b

    .line 200
    const-string v0, "<u>"

    return-object v0

    .line 201
    :cond_b
    instance-of v0, p0, Landroidx/media3/common/text/TextEmphasisSpan;

    if-eqz v0, :cond_c

    .line 202
    move-object v0, p0

    check-cast v0, Landroidx/media3/common/text/TextEmphasisSpan;

    .line 203
    .local v0, "textEmphasisSpan":Landroidx/media3/common/text/TextEmphasisSpan;
    iget v1, v0, Landroidx/media3/common/text/TextEmphasisSpan;->markShape:I

    iget v2, v0, Landroidx/media3/common/text/TextEmphasisSpan;->markFill:I

    invoke-static {v1, v2}, Landroidx/media3/ui/SpannedToHtmlConverter;->getTextEmphasisStyle(II)Ljava/lang/String;

    move-result-object v1

    .line 204
    .local v1, "style":Ljava/lang/String;
    iget v2, v0, Landroidx/media3/common/text/TextEmphasisSpan;->position:I

    invoke-static {v2}, Landroidx/media3/ui/SpannedToHtmlConverter;->getTextEmphasisPosition(I)Ljava/lang/String;

    move-result-object v2

    .line 205
    .local v2, "position":Ljava/lang/String;
    const-string v3, "<span style=\'-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;\'>"

    filled-new-array {v1, v2}, [Ljava/lang/Object;

    move-result-object v4

    invoke-static {v3, v4}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 211
    .end local v0    # "textEmphasisSpan":Landroidx/media3/common/text/TextEmphasisSpan;
    .end local v1    # "style":Ljava/lang/String;
    .end local v2    # "position":Ljava/lang/String;
    :cond_c
    return-object v1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch

    :pswitch_data_1
    .packed-switch -0x1
        :pswitch_6
        :pswitch_3
        :pswitch_5
        :pswitch_4
    .end packed-switch
.end method

.method private static getOrCreate(Landroid/util/SparseArray;I)Landroidx/media3/ui/SpannedToHtmlConverter$Transition;
    .locals 2
    .param p1, "key"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/SparseArray<",
            "Landroidx/media3/ui/SpannedToHtmlConverter$Transition;",
            ">;I)",
            "Landroidx/media3/ui/SpannedToHtmlConverter$Transition;"
        }
    .end annotation

    .line 293
    .local p0, "transitions":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroidx/media3/ui/SpannedToHtmlConverter$Transition;>;"
    invoke-virtual {p0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/ui/SpannedToHtmlConverter$Transition;

    .line 294
    .local v0, "transition":Landroidx/media3/ui/SpannedToHtmlConverter$Transition;
    if-nez v0, :cond_0

    .line 295
    new-instance v1, Landroidx/media3/ui/SpannedToHtmlConverter$Transition;

    invoke-direct {v1}, Landroidx/media3/ui/SpannedToHtmlConverter$Transition;-><init>()V

    move-object v0, v1

    .line 296
    invoke-virtual {p0, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 298
    :cond_0
    return-object v0
.end method

.method private static getTextEmphasisPosition(I)Ljava/lang/String;
    .locals 1
    .param p0, "position"    # I

    .line 282
    packed-switch p0, :pswitch_data_0

    .line 288
    const-string v0, "over right"

    return-object v0

    .line 284
    :pswitch_0
    const-string v0, "under left"

    return-object v0

    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method private static getTextEmphasisStyle(II)Ljava/lang/String;
    .locals 2
    .param p0, "shape"    # I
    .param p1, "fill"    # I

    .line 248
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 249
    .local v0, "builder":Ljava/lang/StringBuilder;
    packed-switch p1, :pswitch_data_0

    goto :goto_0

    .line 254
    :pswitch_0
    const-string v1, "open "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 255
    goto :goto_0

    .line 251
    :pswitch_1
    const-string v1, "filled "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 252
    nop

    .line 261
    :goto_0
    packed-switch p0, :pswitch_data_1

    .line 275
    const-string v1, "unset"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 269
    :pswitch_2
    const-string v1, "sesame"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 270
    goto :goto_1

    .line 266
    :pswitch_3
    const-string v1, "dot"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 267
    goto :goto_1

    .line 263
    :pswitch_4
    const-string v1, "circle"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 264
    goto :goto_1

    .line 272
    :pswitch_5
    const-string v1, "none"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 273
    nop

    .line 278
    :goto_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
    .end packed-switch
.end method
