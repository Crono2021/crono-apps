.class final Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;
.super Ljava/lang/Object;
.source "Cea608Decoder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/extractor/text/cea/Cea608Decoder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "CueBuilder"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;
    }
.end annotation


# static fields
.field private static final BASE_ROW:I = 0xf

.field private static final SCREEN_CHARWIDTH:I = 0x20


# instance fields
.field private captionMode:I

.field private captionRowCount:I

.field private final captionStringBuilder:Ljava/lang/StringBuilder;

.field private final cueStyles:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;",
            ">;"
        }
    .end annotation
.end field

.field private indent:I

.field private final rolledUpCaptions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroid/text/SpannableString;",
            ">;"
        }
    .end annotation
.end field

.field private row:I

.field private tabOffset:I


# direct methods
.method public constructor <init>(II)V
    .locals 1
    .param p1, "captionMode"    # I
    .param p2, "captionRowCount"    # I

    .line 900
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 901
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->cueStyles:Ljava/util/List;

    .line 902
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->rolledUpCaptions:Ljava/util/List;

    .line 903
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionStringBuilder:Ljava/lang/StringBuilder;

    .line 904
    invoke-virtual {p0, p1}, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->reset(I)V

    .line 905
    iput p2, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionRowCount:I

    .line 906
    return-void
.end method

.method static synthetic access$002(Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;I)I
    .locals 0
    .param p0, "x0"    # Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;
    .param p1, "x1"    # I

    .line 883
    iput p1, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->tabOffset:I

    return p1
.end method

.method static synthetic access$100(Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;

    .line 883
    iget v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->row:I

    return v0
.end method

.method static synthetic access$102(Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;I)I
    .locals 0
    .param p0, "x0"    # Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;
    .param p1, "x1"    # I

    .line 883
    iput p1, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->row:I

    return p1
.end method

.method static synthetic access$202(Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;I)I
    .locals 0
    .param p0, "x0"    # Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;
    .param p1, "x1"    # I

    .line 883
    iput p1, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->indent:I

    return p1
.end method

.method private buildCurrentLine()Landroid/text/SpannableString;
    .locals 16

    .line 1052
    move-object/from16 v0, p0

    new-instance v1, Landroid/text/SpannableStringBuilder;

    iget-object v2, v0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionStringBuilder:Ljava/lang/StringBuilder;

    invoke-direct {v1, v2}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 1053
    .local v1, "builder":Landroid/text/SpannableStringBuilder;
    invoke-virtual {v1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    .line 1055
    .local v2, "length":I
    const/4 v3, -0x1

    .line 1056
    .local v3, "underlineStartPosition":I
    const/4 v4, -0x1

    .line 1057
    .local v4, "italicStartPosition":I
    const/4 v5, 0x0

    .line 1058
    .local v5, "colorStartPosition":I
    const/4 v6, -0x1

    .line 1060
    .local v6, "color":I
    const/4 v7, 0x0

    .line 1061
    .local v7, "nextItalic":Z
    const/4 v8, -0x1

    .line 1063
    .local v8, "nextColor":I
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_0
    iget-object v10, v0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->cueStyles:Ljava/util/List;

    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v10

    if-ge v9, v10, :cond_a

    .line 1064
    iget-object v10, v0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->cueStyles:Ljava/util/List;

    invoke-interface {v10, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;

    .line 1065
    .local v10, "cueStyle":Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;
    iget-boolean v12, v10, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;->underline:Z

    .line 1066
    .local v12, "underline":Z
    iget v13, v10, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;->style:I

    .line 1067
    .local v13, "style":I
    const/16 v14, 0x8

    if-eq v13, v14, :cond_2

    .line 1069
    const/4 v14, 0x7

    if-ne v13, v14, :cond_0

    const/4 v15, 0x1

    goto :goto_1

    :cond_0
    const/4 v15, 0x0

    :goto_1
    move v7, v15

    .line 1071
    if-ne v13, v14, :cond_1

    move v14, v8

    goto :goto_2

    :cond_1
    invoke-static {}, Landroidx/media3/extractor/text/cea/Cea608Decoder;->access$300()[I

    move-result-object v14

    aget v14, v14, v13

    :goto_2
    move v8, v14

    .line 1074
    :cond_2
    iget v14, v10, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;->start:I

    .line 1075
    .local v14, "position":I
    add-int/lit8 v15, v9, 0x1

    iget-object v11, v0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->cueStyles:Ljava/util/List;

    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v11

    if-ge v15, v11, :cond_3

    iget-object v11, v0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->cueStyles:Ljava/util/List;

    add-int/lit8 v15, v9, 0x1

    invoke-interface {v11, v15}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;

    iget v11, v11, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;->start:I

    goto :goto_3

    :cond_3
    move v11, v2

    .line 1076
    .local v11, "nextPosition":I
    :goto_3
    if-ne v14, v11, :cond_4

    .line 1078
    goto :goto_6

    .line 1082
    :cond_4
    const/4 v15, -0x1

    if-eq v3, v15, :cond_5

    if-nez v12, :cond_5

    .line 1083
    invoke-static {v1, v3, v14}, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->setUnderlineSpan(Landroid/text/SpannableStringBuilder;II)V

    .line 1084
    const/4 v3, -0x1

    goto :goto_4

    .line 1085
    :cond_5
    const/4 v15, -0x1

    if-ne v3, v15, :cond_6

    if-eqz v12, :cond_6

    .line 1086
    move v3, v14

    .line 1089
    :cond_6
    :goto_4
    const/4 v15, -0x1

    if-eq v4, v15, :cond_7

    if-nez v7, :cond_7

    .line 1090
    invoke-static {v1, v4, v14}, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->setItalicSpan(Landroid/text/SpannableStringBuilder;II)V

    .line 1091
    const/4 v4, -0x1

    goto :goto_5

    .line 1092
    :cond_7
    const/4 v15, -0x1

    if-ne v4, v15, :cond_8

    if-eqz v7, :cond_8

    .line 1093
    move v4, v14

    .line 1096
    :cond_8
    :goto_5
    if-eq v8, v6, :cond_9

    .line 1097
    invoke-static {v1, v5, v14, v6}, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->setColorSpan(Landroid/text/SpannableStringBuilder;III)V

    .line 1098
    move v6, v8

    .line 1099
    move v5, v14

    .line 1063
    .end local v10    # "cueStyle":Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;
    .end local v11    # "nextPosition":I
    .end local v12    # "underline":Z
    .end local v13    # "style":I
    .end local v14    # "position":I
    :cond_9
    :goto_6
    add-int/lit8 v9, v9, 0x1

    goto :goto_0

    .line 1104
    .end local v9    # "i":I
    :cond_a
    const/4 v9, -0x1

    if-eq v3, v9, :cond_b

    if-eq v3, v2, :cond_b

    .line 1105
    invoke-static {v1, v3, v2}, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->setUnderlineSpan(Landroid/text/SpannableStringBuilder;II)V

    .line 1107
    :cond_b
    if-eq v4, v9, :cond_c

    if-eq v4, v2, :cond_c

    .line 1108
    invoke-static {v1, v4, v2}, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->setItalicSpan(Landroid/text/SpannableStringBuilder;II)V

    .line 1110
    :cond_c
    if-eq v5, v2, :cond_d

    .line 1111
    invoke-static {v1, v5, v2, v6}, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->setColorSpan(Landroid/text/SpannableStringBuilder;III)V

    .line 1114
    :cond_d
    new-instance v9, Landroid/text/SpannableString;

    invoke-direct {v9, v1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    return-object v9
.end method

.method private static setColorSpan(Landroid/text/SpannableStringBuilder;III)V
    .locals 2
    .param p0, "builder"    # Landroid/text/SpannableStringBuilder;
    .param p1, "start"    # I
    .param p2, "end"    # I
    .param p3, "color"    # I

    .line 1127
    const/4 v0, -0x1

    if-ne p3, v0, :cond_0

    .line 1129
    return-void

    .line 1131
    :cond_0
    new-instance v0, Landroid/text/style/ForegroundColorSpan;

    invoke-direct {v0, p3}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    const/16 v1, 0x21

    invoke-virtual {p0, v0, p1, p2, v1}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 1132
    return-void
.end method

.method private static setItalicSpan(Landroid/text/SpannableStringBuilder;II)V
    .locals 2
    .param p0, "builder"    # Landroid/text/SpannableStringBuilder;
    .param p1, "start"    # I
    .param p2, "end"    # I

    .line 1122
    new-instance v0, Landroid/text/style/StyleSpan;

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Landroid/text/style/StyleSpan;-><init>(I)V

    const/16 v1, 0x21

    invoke-virtual {p0, v0, p1, p2, v1}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 1123
    return-void
.end method

.method private static setUnderlineSpan(Landroid/text/SpannableStringBuilder;II)V
    .locals 2
    .param p0, "builder"    # Landroid/text/SpannableStringBuilder;
    .param p1, "start"    # I
    .param p2, "end"    # I

    .line 1118
    new-instance v0, Landroid/text/style/UnderlineSpan;

    invoke-direct {v0}, Landroid/text/style/UnderlineSpan;-><init>()V

    const/16 v1, 0x21

    invoke-virtual {p0, v0, p1, p2, v1}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 1119
    return-void
.end method


# virtual methods
.method public append(C)V
    .locals 2
    .param p1, "text"    # C

    .line 955
    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionStringBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    const/16 v1, 0x20

    if-ge v0, v1, :cond_0

    .line 956
    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionStringBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 958
    :cond_0
    return-void
.end method

.method public backspace()V
    .locals 4

    .line 937
    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionStringBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    .line 938
    .local v0, "length":I
    if-lez v0, :cond_0

    .line 939
    iget-object v1, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionStringBuilder:Ljava/lang/StringBuilder;

    add-int/lit8 v2, v0, -0x1

    invoke-virtual {v1, v2, v0}, Ljava/lang/StringBuilder;->delete(II)Ljava/lang/StringBuilder;

    .line 941
    iget-object v1, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->cueStyles:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_0

    .line 942
    iget-object v2, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->cueStyles:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;

    .line 943
    .local v2, "style":Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;
    iget v3, v2, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;->start:I

    if-ne v3, v0, :cond_0

    .line 944
    iget v3, v2, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;->start:I

    add-int/lit8 v3, v3, -0x1

    iput v3, v2, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;->start:I

    .line 941
    .end local v2    # "style":Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 951
    .end local v1    # "i":I
    :cond_0
    return-void
.end method

.method public build(I)Landroidx/media3/common/text/Cue;
    .locals 10
    .param p1, "forcedPositionAnchor"    # I

    .line 972
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 974
    .local v0, "cueString":Landroid/text/SpannableStringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->rolledUpCaptions:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 975
    iget-object v2, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->rolledUpCaptions:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/CharSequence;

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 976
    const/16 v2, 0xa

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    .line 974
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 979
    .end local v1    # "i":I
    :cond_0
    invoke-direct {p0}, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->buildCurrentLine()Landroid/text/SpannableString;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 981
    invoke-virtual {v0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 983
    const/4 v1, 0x0

    return-object v1

    .line 988
    :cond_1
    iget v1, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->indent:I

    iget v2, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->tabOffset:I

    add-int/2addr v1, v2

    .line 990
    .local v1, "startPadding":I
    rsub-int/lit8 v2, v1, 0x20

    invoke-virtual {v0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v3

    sub-int/2addr v2, v3

    .line 991
    .local v2, "endPadding":I
    sub-int v3, v1, v2

    .line 992
    .local v3, "startEndPaddingDelta":I
    const/high16 v4, -0x80000000

    if-eq p1, v4, :cond_2

    .line 993
    move v4, p1

    .local v4, "positionAnchor":I
    goto :goto_1

    .line 994
    .end local v4    # "positionAnchor":I
    :cond_2
    iget v4, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionMode:I

    const/4 v5, 0x2

    if-ne v4, v5, :cond_4

    .line 995
    invoke-static {v3}, Ljava/lang/Math;->abs(I)I

    move-result v4

    const/4 v6, 0x3

    if-lt v4, v6, :cond_3

    if-gez v2, :cond_4

    .line 999
    :cond_3
    const/4 v4, 0x1

    .restart local v4    # "positionAnchor":I
    goto :goto_1

    .line 1000
    .end local v4    # "positionAnchor":I
    :cond_4
    iget v4, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionMode:I

    if-ne v4, v5, :cond_5

    if-lez v3, :cond_5

    .line 1002
    const/4 v4, 0x2

    .restart local v4    # "positionAnchor":I
    goto :goto_1

    .line 1005
    .end local v4    # "positionAnchor":I
    :cond_5
    const/4 v4, 0x0

    .line 1009
    .restart local v4    # "positionAnchor":I
    :goto_1
    const v5, 0x3dcccccd    # 0.1f

    const v6, 0x3f4ccccd    # 0.8f

    const/high16 v7, 0x42000000    # 32.0f

    packed-switch v4, :pswitch_data_0

    .line 1020
    int-to-float v8, v1

    div-float/2addr v8, v7

    .line 1022
    .local v8, "position":F
    mul-float/2addr v6, v8

    add-float/2addr v6, v5

    .end local v8    # "position":F
    .local v6, "position":F
    goto :goto_2

    .line 1014
    .end local v6    # "position":F
    :pswitch_0
    rsub-int/lit8 v8, v2, 0x20

    int-to-float v8, v8

    div-float/2addr v8, v7

    .line 1016
    .restart local v8    # "position":F
    mul-float/2addr v6, v8

    add-float/2addr v6, v5

    .line 1017
    .end local v8    # "position":F
    .restart local v6    # "position":F
    goto :goto_2

    .line 1011
    .end local v6    # "position":F
    :pswitch_1
    const/high16 v6, 0x3f000000    # 0.5f

    .line 1012
    .restart local v6    # "position":F
    nop

    .line 1028
    :goto_2
    iget v5, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->row:I

    const/4 v7, 0x7

    const/4 v8, 0x1

    if-le v5, v7, :cond_6

    .line 1029
    add-int/lit8 v5, v5, -0xf

    .line 1032
    .local v5, "line":I
    add-int/lit8 v5, v5, -0x2

    goto :goto_3

    .line 1039
    .end local v5    # "line":I
    :cond_6
    iget v7, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionMode:I

    if-ne v7, v8, :cond_7

    iget v7, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionRowCount:I

    sub-int/2addr v7, v8

    sub-int/2addr v5, v7

    .line 1042
    .restart local v5    # "line":I
    :cond_7
    :goto_3
    new-instance v7, Landroidx/media3/common/text/Cue$Builder;

    invoke-direct {v7}, Landroidx/media3/common/text/Cue$Builder;-><init>()V

    .line 1043
    invoke-virtual {v7, v0}, Landroidx/media3/common/text/Cue$Builder;->setText(Ljava/lang/CharSequence;)Landroidx/media3/common/text/Cue$Builder;

    move-result-object v7

    sget-object v9, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    .line 1044
    invoke-virtual {v7, v9}, Landroidx/media3/common/text/Cue$Builder;->setTextAlignment(Landroid/text/Layout$Alignment;)Landroidx/media3/common/text/Cue$Builder;

    move-result-object v7

    int-to-float v9, v5

    .line 1045
    invoke-virtual {v7, v9, v8}, Landroidx/media3/common/text/Cue$Builder;->setLine(FI)Landroidx/media3/common/text/Cue$Builder;

    move-result-object v7

    .line 1046
    invoke-virtual {v7, v6}, Landroidx/media3/common/text/Cue$Builder;->setPosition(F)Landroidx/media3/common/text/Cue$Builder;

    move-result-object v7

    .line 1047
    invoke-virtual {v7, v4}, Landroidx/media3/common/text/Cue$Builder;->setPositionAnchor(I)Landroidx/media3/common/text/Cue$Builder;

    move-result-object v7

    .line 1048
    invoke-virtual {v7}, Landroidx/media3/common/text/Cue$Builder;->build()Landroidx/media3/common/text/Cue;

    move-result-object v7

    .line 1042
    return-object v7

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public isEmpty()Z
    .locals 1

    .line 919
    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->cueStyles:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->rolledUpCaptions:Ljava/util/List;

    .line 920
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionStringBuilder:Ljava/lang/StringBuilder;

    .line 921
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 919
    :goto_0
    return v0
.end method

.method public reset(I)V
    .locals 2
    .param p1, "captionMode"    # I

    .line 909
    iput p1, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionMode:I

    .line 910
    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->cueStyles:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 911
    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->rolledUpCaptions:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 912
    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionStringBuilder:Ljava/lang/StringBuilder;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 913
    const/16 v0, 0xf

    iput v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->row:I

    .line 914
    iput v1, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->indent:I

    .line 915
    iput v1, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->tabOffset:I

    .line 916
    return-void
.end method

.method public rollUp()V
    .locals 3

    .line 961
    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->rolledUpCaptions:Ljava/util/List;

    invoke-direct {p0}, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->buildCurrentLine()Landroid/text/SpannableString;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 962
    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionStringBuilder:Ljava/lang/StringBuilder;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 963
    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->cueStyles:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 964
    iget v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionRowCount:I

    iget v2, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->row:I

    invoke-static {v0, v2}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 965
    .local v0, "numRows":I
    :goto_0
    iget-object v2, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->rolledUpCaptions:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v2, v0, :cond_0

    .line 966
    iget-object v2, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->rolledUpCaptions:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    goto :goto_0

    .line 968
    :cond_0
    return-void
.end method

.method public setCaptionMode(I)V
    .locals 0
    .param p1, "captionMode"    # I

    .line 925
    iput p1, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionMode:I

    .line 926
    return-void
.end method

.method public setCaptionRowCount(I)V
    .locals 0
    .param p1, "captionRowCount"    # I

    .line 929
    iput p1, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionRowCount:I

    .line 930
    return-void
.end method

.method public setStyle(IZ)V
    .locals 3
    .param p1, "style"    # I
    .param p2, "underline"    # Z

    .line 933
    iget-object v0, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->cueStyles:Ljava/util/List;

    new-instance v1, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;

    iget-object v2, p0, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder;->captionStringBuilder:Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    invoke-direct {v1, p1, p2, v2}, Landroidx/media3/extractor/text/cea/Cea608Decoder$CueBuilder$CueStyle;-><init>(IZI)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 934
    return-void
.end method
