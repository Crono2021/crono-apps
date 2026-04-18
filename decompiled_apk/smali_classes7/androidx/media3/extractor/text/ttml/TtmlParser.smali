.class public final Landroidx/media3/extractor/text/ttml/TtmlParser;
.super Ljava/lang/Object;
.source "TtmlParser.java"

# interfaces
.implements Landroidx/media3/extractor/text/SubtitleParser;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;,
        Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    }
.end annotation


# static fields
.field private static final ATTR_BEGIN:Ljava/lang/String; = "begin"

.field private static final ATTR_DURATION:Ljava/lang/String; = "dur"

.field private static final ATTR_END:Ljava/lang/String; = "end"

.field private static final ATTR_IMAGE:Ljava/lang/String; = "backgroundImage"

.field private static final ATTR_REGION:Ljava/lang/String; = "region"

.field private static final ATTR_STYLE:Ljava/lang/String; = "style"

.field private static final CELL_RESOLUTION:Ljava/util/regex/Pattern;

.field private static final CLOCK_TIME:Ljava/util/regex/Pattern;

.field public static final CUE_REPLACEMENT_BEHAVIOR:I = 0x1

.field private static final DEFAULT_CELL_ROWS:I = 0xf

.field private static final DEFAULT_FRAME_AND_TICK_RATE:Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;

.field private static final DEFAULT_FRAME_RATE:I = 0x1e

.field private static final FONT_SIZE:Ljava/util/regex/Pattern;

.field private static final OFFSET_TIME:Ljava/util/regex/Pattern;

.field static final PERCENTAGE_COORDINATES:Ljava/util/regex/Pattern;

.field private static final PIXEL_COORDINATES:Ljava/util/regex/Pattern;

.field static final SIGNED_PERCENTAGE:Ljava/util/regex/Pattern;

.field private static final TAG:Ljava/lang/String; = "TtmlParser"

.field private static final TTP:Ljava/lang/String; = "http://www.w3.org/ns/ttml#parameter"


# instance fields
.field private final xmlParserFactory:Lorg/xmlpull/v1/XmlPullParserFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 99
    nop

    .line 100
    const-string v0, "^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/text/ttml/TtmlParser;->CLOCK_TIME:Ljava/util/regex/Pattern;

    .line 103
    nop

    .line 104
    const-string v0, "^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/text/ttml/TtmlParser;->OFFSET_TIME:Ljava/util/regex/Pattern;

    .line 105
    const-string v0, "^(([0-9]*.)?[0-9]+)(px|em|%)$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/text/ttml/TtmlParser;->FONT_SIZE:Ljava/util/regex/Pattern;

    .line 106
    const-string v0, "^([-+]?\\d+\\.?\\d*?)%$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/text/ttml/TtmlParser;->SIGNED_PERCENTAGE:Ljava/util/regex/Pattern;

    .line 107
    nop

    .line 108
    const-string v0, "^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/text/ttml/TtmlParser;->PERCENTAGE_COORDINATES:Ljava/util/regex/Pattern;

    .line 109
    nop

    .line 110
    const-string v0, "^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/text/ttml/TtmlParser;->PIXEL_COORDINATES:Ljava/util/regex/Pattern;

    .line 111
    const-string v0, "^(\\d+) (\\d+)$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/text/ttml/TtmlParser;->CELL_RESOLUTION:Ljava/util/regex/Pattern;

    .line 115
    new-instance v0, Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;

    const/high16 v1, 0x41f00000    # 30.0f

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2, v2}, Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;-><init>(FII)V

    sput-object v0, Landroidx/media3/extractor/text/ttml/TtmlParser;->DEFAULT_FRAME_AND_TICK_RATE:Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .line 121
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 123
    :try_start_0
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/text/ttml/TtmlParser;->xmlParserFactory:Lorg/xmlpull/v1/XmlPullParserFactory;

    .line 124
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lorg/xmlpull/v1/XmlPullParserFactory;->setNamespaceAware(Z)V
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0

    .line 127
    nop

    .line 128
    return-void

    .line 125
    :catch_0
    move-exception v0

    .line 126
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Couldn\'t create XmlPullParserFactory instance"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private static createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;
    .locals 1
    .param p0, "style"    # Landroidx/media3/extractor/text/ttml/TtmlStyle;

    .line 638
    if-nez p0, :cond_0

    new-instance v0, Landroidx/media3/extractor/text/ttml/TtmlStyle;

    invoke-direct {v0}, Landroidx/media3/extractor/text/ttml/TtmlStyle;-><init>()V

    goto :goto_0

    :cond_0
    move-object v0, p0

    :goto_0
    return-object v0
.end method

.method private static isSupportedTag(Ljava/lang/String;)Z
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;

    .line 733
    const-string/jumbo v0, "tt"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 734
    const-string v0, "head"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 735
    const-string v0, "body"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 736
    const-string v0, "div"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 737
    const-string/jumbo v0, "p"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 738
    const-string/jumbo v0, "span"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 739
    const-string v0, "br"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 740
    const-string/jumbo v0, "style"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 741
    const-string/jumbo v0, "styling"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 742
    const-string v0, "layout"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 743
    const-string/jumbo v0, "region"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 744
    const-string/jumbo v0, "metadata"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 745
    const-string v0, "image"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 746
    const-string v0, "data"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 747
    const-string v0, "information"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    .line 733
    :goto_1
    return v0
.end method

.method private static parseAlignment(Ljava/lang/String;)Landroid/text/Layout$Alignment;
    .locals 2
    .param p0, "alignment"    # Ljava/lang/String;

    .line 643
    invoke-static {p0}, Lcom/google/common/base/Ascii;->toLowerCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    :cond_0
    goto :goto_0

    :sswitch_0
    const-string/jumbo v1, "start"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_1

    :sswitch_1
    const-string/jumbo v1, "right"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x2

    goto :goto_1

    :sswitch_2
    const-string v1, "left"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    goto :goto_1

    :sswitch_3
    const-string v1, "end"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x3

    goto :goto_1

    :sswitch_4
    const-string v1, "center"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x4

    goto :goto_1

    :goto_0
    const/4 v0, -0x1

    :goto_1
    packed-switch v0, :pswitch_data_0

    .line 653
    const/4 v0, 0x0

    return-object v0

    .line 651
    :pswitch_0
    sget-object v0, Landroid/text/Layout$Alignment;->ALIGN_CENTER:Landroid/text/Layout$Alignment;

    return-object v0

    .line 649
    :pswitch_1
    sget-object v0, Landroid/text/Layout$Alignment;->ALIGN_OPPOSITE:Landroid/text/Layout$Alignment;

    return-object v0

    .line 646
    :pswitch_2
    sget-object v0, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    return-object v0

    nop

    :sswitch_data_0
    .sparse-switch
        -0x514d33ab -> :sswitch_4
        0x188db -> :sswitch_3
        0x32a007 -> :sswitch_2
        0x677c21c -> :sswitch_1
        0x68ac462 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_2
        :pswitch_1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static parseCellRows(Lorg/xmlpull/v1/XmlPullParser;I)I
    .locals 9
    .param p0, "xmlParser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p1, "defaultValue"    # I

    .line 251
    const-string v0, "http://www.w3.org/ns/ttml#parameter"

    const-string v1, "cellResolution"

    invoke-interface {p0, v0, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 252
    .local v0, "cellResolution":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 253
    return p1

    .line 256
    :cond_0
    sget-object v1, Landroidx/media3/extractor/text/ttml/TtmlParser;->CELL_RESOLUTION:Ljava/util/regex/Pattern;

    invoke-virtual {v1, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 257
    .local v1, "cellResolutionMatcher":Ljava/util/regex/Matcher;
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->matches()Z

    move-result v2

    const-string v3, "Ignoring malformed cell resolution: "

    const-string v4, "TtmlParser"

    if-nez v2, :cond_1

    .line 258
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 259
    return p1

    .line 262
    :cond_1
    const/4 v2, 0x1

    :try_start_0
    invoke-virtual {v1, v2}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    .line 263
    .local v5, "columns":I
    const/4 v6, 0x2

    invoke-virtual {v1, v6}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    .line 264
    .local v6, "rows":I
    if-eqz v5, :cond_2

    if-eqz v6, :cond_2

    goto :goto_0

    :cond_2
    const/4 v2, 0x0

    :goto_0
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Invalid cell resolution "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v2, v7}, Landroidx/media3/common/util/Assertions;->checkArgument(ZLjava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 265
    return v6

    .line 266
    .end local v5    # "columns":I
    .end local v6    # "rows":I
    :catch_0
    move-exception v2

    .line 267
    .local v2, "e":Ljava/lang/NumberFormatException;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v4, v3}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 268
    return p1
.end method

.method private static parseFontSize(Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlStyle;)V
    .locals 8
    .param p0, "expression"    # Ljava/lang/String;
    .param p1, "out"    # Landroidx/media3/extractor/text/ttml/TtmlStyle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/extractor/text/SubtitleDecoderException;
        }
    .end annotation

    .line 752
    const-string v0, "\\s+"

    invoke-static {p0, v0}, Landroidx/media3/common/util/Util;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 754
    .local v0, "expressions":[Ljava/lang/String;
    array-length v1, v0

    const/4 v2, 0x2

    const/4 v3, 0x1

    if-ne v1, v3, :cond_0

    .line 755
    sget-object v1, Landroidx/media3/extractor/text/ttml/TtmlParser;->FONT_SIZE:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .local v1, "matcher":Ljava/util/regex/Matcher;
    goto :goto_0

    .line 756
    .end local v1    # "matcher":Ljava/util/regex/Matcher;
    :cond_0
    array-length v1, v0

    if-ne v1, v2, :cond_3

    .line 757
    sget-object v1, Landroidx/media3/extractor/text/ttml/TtmlParser;->FONT_SIZE:Ljava/util/regex/Pattern;

    aget-object v4, v0, v3

    invoke-virtual {v1, v4}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 758
    .restart local v1    # "matcher":Ljava/util/regex/Matcher;
    const-string v4, "TtmlParser"

    const-string v5, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first."

    invoke-static {v4, v5}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 767
    :goto_0
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->matches()Z

    move-result v4

    const-string v5, "\'."

    if-eqz v4, :cond_2

    .line 768
    const/4 v4, 0x3

    invoke-virtual {v1, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 769
    .local v6, "unit":Ljava/lang/String;
    invoke-virtual {v6}, Ljava/lang/String;->hashCode()I

    move-result v7

    sparse-switch v7, :sswitch_data_0

    :cond_1
    goto :goto_1

    :sswitch_0
    const-string/jumbo v7, "px"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    const/4 v7, 0x0

    goto :goto_2

    :sswitch_1
    const-string v7, "em"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    move v7, v3

    goto :goto_2

    :sswitch_2
    const-string v7, "%"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    move v7, v2

    goto :goto_2

    :goto_1
    const/4 v7, -0x1

    :goto_2
    packed-switch v7, :pswitch_data_0

    .line 780
    new-instance v2, Landroidx/media3/extractor/text/SubtitleDecoderException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Invalid unit for fontSize: \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Landroidx/media3/extractor/text/SubtitleDecoderException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 777
    :pswitch_0
    invoke-virtual {p1, v4}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setFontSizeUnit(I)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    .line 778
    goto :goto_3

    .line 774
    :pswitch_1
    invoke-virtual {p1, v2}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setFontSizeUnit(I)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    .line 775
    goto :goto_3

    .line 771
    :pswitch_2
    invoke-virtual {p1, v3}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setFontSizeUnit(I)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    .line 772
    nop

    .line 782
    :goto_3
    invoke-virtual {v1, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v2

    invoke-virtual {p1, v2}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setFontSize(F)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    .line 783
    .end local v6    # "unit":Ljava/lang/String;
    nop

    .line 786
    return-void

    .line 784
    :cond_2
    new-instance v2, Landroidx/media3/extractor/text/SubtitleDecoderException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Invalid expression for fontSize: \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Landroidx/media3/extractor/text/SubtitleDecoderException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 763
    .end local v1    # "matcher":Ljava/util/regex/Matcher;
    :cond_3
    new-instance v1, Landroidx/media3/extractor/text/SubtitleDecoderException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid number of entries for fontSize: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    array-length v3, v0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Landroidx/media3/extractor/text/SubtitleDecoderException;-><init>(Ljava/lang/String;)V

    throw v1

    nop

    :sswitch_data_0
    .sparse-switch
        0x25 -> :sswitch_2
        0xca8 -> :sswitch_1
        0xe08 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static parseFrameAndTickRates(Lorg/xmlpull/v1/XmlPullParser;)Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .locals 10
    .param p0, "xmlParser"    # Lorg/xmlpull/v1/XmlPullParser;

    .line 220
    const/16 v0, 0x1e

    .line 221
    .local v0, "frameRate":I
    const-string v1, "frameRate"

    const-string v2, "http://www.w3.org/ns/ttml#parameter"

    invoke-interface {p0, v2, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 222
    .local v1, "frameRateString":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 223
    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 226
    :cond_0
    const/high16 v3, 0x3f800000    # 1.0f

    .line 227
    .local v3, "frameRateMultiplier":F
    const-string v4, "frameRateMultiplier"

    invoke-interface {p0, v2, v4}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 228
    .local v4, "frameRateMultiplierString":Ljava/lang/String;
    if-eqz v4, :cond_2

    .line 229
    const-string v5, " "

    invoke-static {v4, v5}, Landroidx/media3/common/util/Util;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 230
    .local v5, "parts":[Ljava/lang/String;
    array-length v6, v5

    const/4 v7, 0x2

    const/4 v8, 0x1

    const/4 v9, 0x0

    if-ne v6, v7, :cond_1

    move v6, v8

    goto :goto_0

    :cond_1
    move v6, v9

    :goto_0
    const-string v7, "frameRateMultiplier doesn\'t have 2 parts"

    invoke-static {v6, v7}, Landroidx/media3/common/util/Assertions;->checkArgument(ZLjava/lang/Object;)V

    .line 231
    aget-object v6, v5, v9

    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    int-to-float v6, v6

    .line 232
    .local v6, "numerator":F
    aget-object v7, v5, v8

    invoke-static {v7}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v7

    int-to-float v7, v7

    .line 233
    .local v7, "denominator":F
    div-float v3, v6, v7

    .line 236
    .end local v5    # "parts":[Ljava/lang/String;
    .end local v6    # "numerator":F
    .end local v7    # "denominator":F
    :cond_2
    sget-object v5, Landroidx/media3/extractor/text/ttml/TtmlParser;->DEFAULT_FRAME_AND_TICK_RATE:Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;

    iget v6, v5, Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;->subFrameRate:I

    .line 237
    .local v6, "subFrameRate":I
    const-string/jumbo v7, "subFrameRate"

    invoke-interface {p0, v2, v7}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 238
    .local v7, "subFrameRateString":Ljava/lang/String;
    if-eqz v7, :cond_3

    .line 239
    invoke-static {v7}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    .line 242
    :cond_3
    iget v5, v5, Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;->tickRate:I

    .line 243
    .local v5, "tickRate":I
    const-string/jumbo v8, "tickRate"

    invoke-interface {p0, v2, v8}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 244
    .local v2, "tickRateString":Ljava/lang/String;
    if-eqz v2, :cond_4

    .line 245
    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    .line 247
    :cond_4
    new-instance v8, Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;

    int-to-float v9, v0

    mul-float/2addr v9, v3

    invoke-direct {v8, v9, v6, v5}, Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;-><init>(FII)V

    return-object v8
.end method

.method private static parseHeader(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;ILandroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;
    .locals 7
    .param p0, "xmlParser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p2, "cellRows"    # I
    .param p3, "ttsExtent"    # Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/xmlpull/v1/XmlPullParser;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/media3/extractor/text/ttml/TtmlStyle;",
            ">;I",
            "Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/media3/extractor/text/ttml/TtmlRegion;",
            ">;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/media3/extractor/text/ttml/TtmlStyle;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .line 304
    .local p1, "globalStyles":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlStyle;>;"
    .local p4, "globalRegions":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlRegion;>;"
    .local p5, "imageMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    nop

    :cond_0
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 305
    const-string/jumbo v0, "style"

    invoke-static {p0, v0}, Landroidx/media3/common/util/XmlPullParserUtil;->isStartTag(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 306
    invoke-static {p0, v0}, Landroidx/media3/common/util/XmlPullParserUtil;->getAttributeValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 307
    .local v0, "parentStyleId":Ljava/lang/String;
    new-instance v1, Landroidx/media3/extractor/text/ttml/TtmlStyle;

    invoke-direct {v1}, Landroidx/media3/extractor/text/ttml/TtmlStyle;-><init>()V

    invoke-static {p0, v1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseStyleAttributes(Lorg/xmlpull/v1/XmlPullParser;Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v1

    .line 308
    .local v1, "style":Landroidx/media3/extractor/text/ttml/TtmlStyle;
    if-eqz v0, :cond_1

    .line 309
    invoke-static {v0}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseStyleIds(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    array-length v3, v2

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v3, :cond_1

    aget-object v5, v2, v4

    .line 310
    .local v5, "id":Ljava/lang/String;
    invoke-interface {p1, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/extractor/text/ttml/TtmlStyle;

    invoke-virtual {v1, v6}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->chain(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    .line 309
    .end local v5    # "id":Ljava/lang/String;
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 313
    :cond_1
    invoke-virtual {v1}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->getId()Ljava/lang/String;

    move-result-object v2

    .line 314
    .local v2, "styleId":Ljava/lang/String;
    if-eqz v2, :cond_2

    .line 315
    invoke-interface {p1, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 317
    .end local v0    # "parentStyleId":Ljava/lang/String;
    .end local v1    # "style":Landroidx/media3/extractor/text/ttml/TtmlStyle;
    .end local v2    # "styleId":Ljava/lang/String;
    :cond_2
    goto :goto_2

    :cond_3
    const-string/jumbo v0, "region"

    invoke-static {p0, v0}, Landroidx/media3/common/util/XmlPullParserUtil;->isStartTag(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 318
    invoke-static {p0, p2, p3}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseRegionAttributes(Lorg/xmlpull/v1/XmlPullParser;ILandroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;)Landroidx/media3/extractor/text/ttml/TtmlRegion;

    move-result-object v0

    .line 319
    .local v0, "ttmlRegion":Landroidx/media3/extractor/text/ttml/TtmlRegion;
    if-eqz v0, :cond_5

    .line 320
    iget-object v1, v0, Landroidx/media3/extractor/text/ttml/TtmlRegion;->id:Ljava/lang/String;

    invoke-interface {p4, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 322
    .end local v0    # "ttmlRegion":Landroidx/media3/extractor/text/ttml/TtmlRegion;
    :cond_4
    const-string/jumbo v0, "metadata"

    invoke-static {p0, v0}, Landroidx/media3/common/util/XmlPullParserUtil;->isStartTag(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 323
    invoke-static {p0, p5}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseMetadata(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;)V

    goto :goto_2

    .line 322
    :cond_5
    :goto_1
    nop

    .line 325
    :goto_2
    const-string v0, "head"

    invoke-static {p0, v0}, Landroidx/media3/common/util/XmlPullParserUtil;->isEndTag(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 326
    return-object p1
.end method

.method private static parseMetadata(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;)V
    .locals 2
    .param p0, "xmlParser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/xmlpull/v1/XmlPullParser;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .line 332
    .local p1, "imageMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    nop

    :cond_0
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 333
    const-string v0, "image"

    invoke-static {p0, v0}, Landroidx/media3/common/util/XmlPullParserUtil;->isStartTag(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 334
    const-string v0, "id"

    invoke-static {p0, v0}, Landroidx/media3/common/util/XmlPullParserUtil;->getAttributeValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 335
    .local v0, "id":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 336
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v1

    .line 337
    .local v1, "encodedBitmapData":Ljava/lang/String;
    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 340
    .end local v0    # "id":Ljava/lang/String;
    .end local v1    # "encodedBitmapData":Ljava/lang/String;
    :cond_1
    const-string/jumbo v0, "metadata"

    invoke-static {p0, v0}, Landroidx/media3/common/util/XmlPullParserUtil;->isEndTag(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 341
    return-void
.end method

.method private static parseNode(Lorg/xmlpull/v1/XmlPullParser;Landroidx/media3/extractor/text/ttml/TtmlNode;Ljava/util/Map;Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;)Landroidx/media3/extractor/text/ttml/TtmlNode;
    .locals 24
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p1, "parent"    # Landroidx/media3/extractor/text/ttml/TtmlNode;
    .param p3, "frameAndTickRate"    # Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/xmlpull/v1/XmlPullParser;",
            "Landroidx/media3/extractor/text/ttml/TtmlNode;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/media3/extractor/text/ttml/TtmlRegion;",
            ">;",
            "Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;",
            ")",
            "Landroidx/media3/extractor/text/ttml/TtmlNode;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/extractor/text/SubtitleDecoderException;
        }
    .end annotation

    .line 663
    .local p2, "regionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlRegion;>;"
    move-object/from16 v0, p0

    move-object/from16 v11, p1

    move-object/from16 v12, p3

    const-wide v1, -0x7fffffffffffffffL    # -4.9E-324

    .line 664
    .local v1, "duration":J
    const-wide v3, -0x7fffffffffffffffL    # -4.9E-324

    .line 665
    .local v3, "startTime":J
    const-wide v5, -0x7fffffffffffffffL    # -4.9E-324

    .line 666
    .local v5, "endTime":J
    const-string v7, ""

    .line 667
    .local v7, "regionId":Ljava/lang/String;
    const/4 v8, 0x0

    .line 668
    .local v8, "imageId":Ljava/lang/String;
    const/4 v9, 0x0

    .line 669
    .local v9, "styleIds":[Ljava/lang/String;
    invoke-interface/range {p0 .. p0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v13

    .line 670
    .local v13, "attributeCount":I
    const/4 v10, 0x0

    invoke-static {v0, v10}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseStyleAttributes(Lorg/xmlpull/v1/XmlPullParser;Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v14

    .line 671
    .local v14, "style":Landroidx/media3/extractor/text/ttml/TtmlStyle;
    const/4 v10, 0x0

    move-wide v15, v1

    move-object/from16 v17, v7

    move-object/from16 v18, v8

    move-object/from16 v19, v9

    .end local v1    # "duration":J
    .end local v7    # "regionId":Ljava/lang/String;
    .end local v8    # "imageId":Ljava/lang/String;
    .end local v9    # "styleIds":[Ljava/lang/String;
    .local v10, "i":I
    .local v15, "duration":J
    .local v17, "regionId":Ljava/lang/String;
    .local v18, "imageId":Ljava/lang/String;
    .local v19, "styleIds":[Ljava/lang/String;
    :goto_0
    if-ge v10, v13, :cond_3

    .line 672
    invoke-interface {v0, v10}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v1

    .line 673
    .local v1, "attr":Ljava/lang/String;
    invoke-interface {v0, v10}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v2

    .line 674
    .local v2, "value":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v7

    const/4 v8, 0x1

    sparse-switch v7, :sswitch_data_0

    :cond_0
    goto :goto_1

    :sswitch_0
    const-string v7, "backgroundImage"

    invoke-virtual {v1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    const/4 v7, 0x5

    goto :goto_2

    :sswitch_1
    const-string/jumbo v7, "style"

    invoke-virtual {v1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    const/4 v7, 0x3

    goto :goto_2

    :sswitch_2
    const-string v7, "begin"

    invoke-virtual {v1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    const/4 v7, 0x0

    goto :goto_2

    :sswitch_3
    const-string v7, "end"

    invoke-virtual {v1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    move v7, v8

    goto :goto_2

    :sswitch_4
    const-string v7, "dur"

    invoke-virtual {v1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    const/4 v7, 0x2

    goto :goto_2

    :sswitch_5
    const-string/jumbo v7, "region"

    invoke-virtual {v1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    const/4 v7, 0x4

    goto :goto_2

    :goto_1
    const/4 v7, -0x1

    :goto_2
    packed-switch v7, :pswitch_data_0

    move-object/from16 v9, p2

    goto :goto_3

    .line 701
    :pswitch_0
    const-string v7, "#"

    invoke-virtual {v2, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 702
    invoke-virtual {v2, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v7

    move-object/from16 v9, p2

    move-object/from16 v18, v7

    .end local v18    # "imageId":Ljava/lang/String;
    .local v7, "imageId":Ljava/lang/String;
    goto :goto_3

    .line 701
    .end local v7    # "imageId":Ljava/lang/String;
    .restart local v18    # "imageId":Ljava/lang/String;
    :cond_1
    move-object/from16 v9, p2

    goto :goto_3

    .line 692
    :pswitch_1
    move-object/from16 v9, p2

    invoke-interface {v9, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 695
    move-object v7, v2

    move-object/from16 v17, v7

    .end local v17    # "regionId":Ljava/lang/String;
    .local v7, "regionId":Ljava/lang/String;
    goto :goto_3

    .line 686
    .end local v7    # "regionId":Ljava/lang/String;
    .restart local v17    # "regionId":Ljava/lang/String;
    :pswitch_2
    move-object/from16 v9, p2

    invoke-static {v2}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseStyleIds(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    .line 687
    .local v7, "ids":[Ljava/lang/String;
    array-length v8, v7

    if-lez v8, :cond_2

    .line 688
    move-object v8, v7

    move-object/from16 v19, v8

    .end local v19    # "styleIds":[Ljava/lang/String;
    .local v8, "styleIds":[Ljava/lang/String;
    goto :goto_3

    .line 682
    .end local v7    # "ids":[Ljava/lang/String;
    .end local v8    # "styleIds":[Ljava/lang/String;
    .restart local v19    # "styleIds":[Ljava/lang/String;
    :pswitch_3
    move-object/from16 v9, p2

    invoke-static {v2, v12}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseTimeExpression(Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;)J

    move-result-wide v7

    .line 683
    .end local v15    # "duration":J
    .local v7, "duration":J
    move-wide v15, v7

    goto :goto_3

    .line 679
    .end local v7    # "duration":J
    .restart local v15    # "duration":J
    :pswitch_4
    move-object/from16 v9, p2

    invoke-static {v2, v12}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseTimeExpression(Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;)J

    move-result-wide v5

    .line 680
    goto :goto_3

    .line 676
    :pswitch_5
    move-object/from16 v9, p2

    invoke-static {v2, v12}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseTimeExpression(Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;)J

    move-result-wide v3

    .line 677
    nop

    .line 671
    .end local v1    # "attr":Ljava/lang/String;
    .end local v2    # "value":Ljava/lang/String;
    :cond_2
    :goto_3
    add-int/lit8 v10, v10, 0x1

    goto/16 :goto_0

    :cond_3
    move-object/from16 v9, p2

    .line 710
    .end local v10    # "i":I
    const-wide v1, -0x7fffffffffffffffL    # -4.9E-324

    if-eqz v11, :cond_6

    iget-wide v7, v11, Landroidx/media3/extractor/text/ttml/TtmlNode;->startTimeUs:J

    cmp-long v7, v7, v1

    if-eqz v7, :cond_6

    .line 711
    cmp-long v7, v3, v1

    if-eqz v7, :cond_4

    .line 712
    iget-wide v7, v11, Landroidx/media3/extractor/text/ttml/TtmlNode;->startTimeUs:J

    add-long/2addr v3, v7

    .line 714
    :cond_4
    cmp-long v7, v5, v1

    if-eqz v7, :cond_5

    .line 715
    iget-wide v7, v11, Landroidx/media3/extractor/text/ttml/TtmlNode;->startTimeUs:J

    add-long/2addr v5, v7

    move-wide/from16 v20, v3

    goto :goto_4

    .line 714
    :cond_5
    move-wide/from16 v20, v3

    goto :goto_4

    .line 718
    :cond_6
    move-wide/from16 v20, v3

    .end local v3    # "startTime":J
    .local v20, "startTime":J
    :goto_4
    cmp-long v3, v5, v1

    if-nez v3, :cond_8

    .line 719
    cmp-long v3, v15, v1

    if-eqz v3, :cond_7

    .line 721
    add-long v5, v20, v15

    move-wide/from16 v22, v5

    goto :goto_5

    .line 722
    :cond_7
    if-eqz v11, :cond_8

    iget-wide v3, v11, Landroidx/media3/extractor/text/ttml/TtmlNode;->endTimeUs:J

    cmp-long v1, v3, v1

    if-eqz v1, :cond_8

    .line 724
    iget-wide v5, v11, Landroidx/media3/extractor/text/ttml/TtmlNode;->endTimeUs:J

    move-wide/from16 v22, v5

    goto :goto_5

    .line 728
    :cond_8
    move-wide/from16 v22, v5

    .end local v5    # "endTime":J
    .local v22, "endTime":J
    :goto_5
    nop

    .line 729
    invoke-interface/range {p0 .. p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 728
    move-wide/from16 v2, v20

    move-wide/from16 v4, v22

    move-object v6, v14

    move-object/from16 v7, v19

    move-object/from16 v8, v17

    move-object/from16 v9, v18

    move-object/from16 v10, p1

    invoke-static/range {v1 .. v10}, Landroidx/media3/extractor/text/ttml/TtmlNode;->buildNode(Ljava/lang/String;JJLandroidx/media3/extractor/text/ttml/TtmlStyle;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlNode;)Landroidx/media3/extractor/text/ttml/TtmlNode;

    move-result-object v1

    return-object v1

    nop

    :sswitch_data_0
    .sparse-switch
        -0x37b7d90c -> :sswitch_5
        0x18601 -> :sswitch_4
        0x188db -> :sswitch_3
        0x59478a9 -> :sswitch_2
        0x68b1db1 -> :sswitch_1
        0x4d0b70cd -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static parseRegionAttributes(Lorg/xmlpull/v1/XmlPullParser;ILandroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;)Landroidx/media3/extractor/text/ttml/TtmlRegion;
    .locals 26
    .param p0, "xmlParser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p1, "cellRows"    # I
    .param p2, "ttsExtent"    # Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;

    .line 354
    move-object/from16 v1, p0

    move-object/from16 v2, p2

    const-string v0, "id"

    invoke-static {v1, v0}, Landroidx/media3/common/util/XmlPullParserUtil;->getAttributeValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 355
    .local v14, "regionId":Ljava/lang/String;
    const/4 v3, 0x0

    if-nez v14, :cond_0

    .line 356
    return-object v3

    .line 363
    :cond_0
    const-string/jumbo v0, "origin"

    invoke-static {v1, v0}, Landroidx/media3/common/util/XmlPullParserUtil;->getAttributeValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 364
    .local v15, "regionOrigin":Ljava/lang/String;
    const-string v4, "TtmlParser"

    if-eqz v15, :cond_c

    .line 365
    sget-object v0, Landroidx/media3/extractor/text/ttml/TtmlParser;->PERCENTAGE_COORDINATES:Ljava/util/regex/Pattern;

    invoke-virtual {v0, v15}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v5

    .line 366
    .local v5, "originPercentageMatcher":Ljava/util/regex/Matcher;
    sget-object v6, Landroidx/media3/extractor/text/ttml/TtmlParser;->PIXEL_COORDINATES:Ljava/util/regex/Pattern;

    invoke-virtual {v6, v15}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v7

    .line 367
    .local v7, "originPixelMatcher":Ljava/util/regex/Matcher;
    invoke-virtual {v5}, Ljava/util/regex/Matcher;->matches()Z

    move-result v8

    const-string v9, "Ignoring region with malformed origin: "

    const-string v10, "Ignoring region with missing tts:extent: "

    const/high16 v11, 0x42c80000    # 100.0f

    const/4 v12, 0x2

    const/4 v13, 0x1

    if-eqz v8, :cond_1

    .line 369
    nop

    .line 370
    :try_start_0
    invoke-virtual {v5, v13}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v8

    div-float/2addr v8, v11

    .line 371
    .local v8, "position":F
    invoke-virtual {v5, v12}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v16 .. v16}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/lang/String;

    invoke-static/range {v16 .. v16}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v9
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    div-float/2addr v9, v11

    .line 375
    .local v9, "line":F
    move/from16 v19, v8

    goto :goto_0

    .line 372
    .end local v8    # "position":F
    .end local v9    # "line":F
    :catch_0
    move-exception v0

    .line 373
    .local v0, "e":Ljava/lang/NumberFormatException;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 374
    return-object v3

    .line 376
    .end local v0    # "e":Ljava/lang/NumberFormatException;
    :cond_1
    invoke-virtual {v7}, Ljava/util/regex/Matcher;->matches()Z

    move-result v8

    if-eqz v8, :cond_b

    .line 377
    if-nez v2, :cond_2

    .line 378
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 379
    return-object v3

    .line 382
    :cond_2
    :try_start_1
    invoke-virtual {v7, v13}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    .line 383
    .local v8, "width":I
    invoke-virtual {v7, v12}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v16 .. v16}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/lang/String;

    invoke-static/range {v16 .. v16}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v16

    move/from16 v17, v16

    .line 385
    .local v17, "height":I
    int-to-float v3, v8

    iget v12, v2, Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;->width:I

    int-to-float v12, v12

    div-float/2addr v3, v12

    .line 386
    .local v3, "position":F
    move/from16 v12, v17

    .end local v17    # "height":I
    .local v12, "height":I
    int-to-float v11, v12

    iget v9, v2, Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;->height:I
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_3

    int-to-float v9, v9

    div-float v9, v11, v9

    .line 390
    .end local v8    # "width":I
    .end local v12    # "height":I
    .restart local v9    # "line":F
    move/from16 v19, v3

    .line 395
    .end local v3    # "position":F
    .end local v5    # "originPercentageMatcher":Ljava/util/regex/Matcher;
    .end local v7    # "originPixelMatcher":Ljava/util/regex/Matcher;
    .local v19, "position":F
    :goto_0
    nop

    .line 408
    const-string v3, "extent"

    invoke-static {v1, v3}, Landroidx/media3/common/util/XmlPullParserUtil;->getAttributeValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 409
    .local v12, "regionExtent":Ljava/lang/String;
    if-eqz v12, :cond_a

    .line 410
    invoke-virtual {v0, v12}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v3

    .line 411
    .local v3, "extentPercentageMatcher":Ljava/util/regex/Matcher;
    invoke-virtual {v6, v12}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v5

    .line 412
    .local v5, "extentPixelMatcher":Ljava/util/regex/Matcher;
    invoke-virtual {v3}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    const-string v6, "Ignoring region with malformed extent: "

    if-eqz v0, :cond_3

    .line 414
    nop

    .line 415
    :try_start_2
    invoke-virtual {v3, v13}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v0

    const/high16 v7, 0x42c80000    # 100.0f

    div-float/2addr v0, v7

    .line 416
    .local v0, "width":F
    nop

    .line 417
    const/4 v7, 0x2

    invoke-virtual {v3, v7}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v4
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_1

    const/high16 v6, 0x42c80000    # 100.0f

    div-float/2addr v4, v6

    .line 421
    .local v4, "height":F
    move/from16 v16, v4

    const/4 v7, 0x2

    goto :goto_1

    .line 418
    .end local v0    # "width":F
    .end local v4    # "height":F
    :catch_1
    move-exception v0

    .line 419
    .local v0, "e":Ljava/lang/NumberFormatException;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 420
    const/4 v4, 0x0

    return-object v4

    .line 422
    .end local v0    # "e":Ljava/lang/NumberFormatException;
    :cond_3
    invoke-virtual {v5}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 423
    if-nez v2, :cond_4

    .line 424
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 425
    const/4 v4, 0x0

    return-object v4

    .line 428
    :cond_4
    :try_start_3
    invoke-virtual {v5, v13}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 429
    .local v0, "extentWidth":I
    const/4 v7, 0x2

    invoke-virtual {v5, v7}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    .line 431
    .local v8, "extentHeight":I
    int-to-float v10, v0

    iget v11, v2, Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;->width:I

    int-to-float v11, v11

    div-float/2addr v10, v11

    .line 432
    .local v10, "width":F
    int-to-float v11, v8

    iget v4, v2, Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;->height:I
    :try_end_3
    .catch Ljava/lang/NumberFormatException; {:try_start_3 .. :try_end_3} :catch_2

    int-to-float v4, v4

    div-float v4, v11, v4

    .line 436
    .end local v0    # "extentWidth":I
    .end local v8    # "extentHeight":I
    .restart local v4    # "height":F
    move/from16 v16, v4

    move v0, v10

    .line 441
    .end local v3    # "extentPercentageMatcher":Ljava/util/regex/Matcher;
    .end local v4    # "height":F
    .end local v5    # "extentPixelMatcher":Ljava/util/regex/Matcher;
    .end local v10    # "width":F
    .local v0, "width":F
    .local v16, "height":F
    :goto_1
    nop

    .line 451
    const/4 v3, 0x0

    .line 453
    .local v3, "lineAnchor":I
    nop

    .line 454
    const-string v4, "displayAlign"

    invoke-static {v1, v4}, Landroidx/media3/common/util/XmlPullParserUtil;->getAttributeValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 455
    .local v17, "displayAlign":Ljava/lang/String;
    const/4 v4, 0x0

    const/4 v5, -0x1

    if-eqz v17, :cond_6

    .line 456
    invoke-static/range {v17 .. v17}, Lcom/google/common/base/Ascii;->toLowerCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->hashCode()I

    move-result v8

    sparse-switch v8, :sswitch_data_0

    :cond_5
    goto :goto_2

    :sswitch_0
    const-string v8, "after"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    move v6, v13

    goto :goto_3

    :sswitch_1
    const-string v8, "center"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    move v6, v4

    goto :goto_3

    :goto_2
    move v6, v5

    :goto_3
    packed-switch v6, :pswitch_data_0

    goto :goto_4

    .line 462
    :pswitch_0
    const/4 v3, 0x2

    .line 463
    add-float v9, v9, v16

    .line 464
    move/from16 v18, v3

    move/from16 v20, v9

    goto :goto_5

    .line 458
    :pswitch_1
    const/4 v3, 0x1

    .line 459
    const/high16 v6, 0x40000000    # 2.0f

    div-float v6, v16, v6

    add-float/2addr v9, v6

    .line 460
    move/from16 v18, v3

    move/from16 v20, v9

    goto :goto_5

    .line 471
    :cond_6
    :goto_4
    move/from16 v18, v3

    move/from16 v20, v9

    .end local v3    # "lineAnchor":I
    .end local v9    # "line":F
    .local v18, "lineAnchor":I
    .local v20, "line":F
    :goto_5
    const/high16 v3, 0x3f800000    # 1.0f

    move/from16 v11, p1

    int-to-float v6, v11

    div-float v21, v3, v6

    .line 473
    .local v21, "regionTextHeight":F
    const/high16 v3, -0x80000000

    .line 475
    .local v3, "verticalType":I
    nop

    .line 476
    const-string/jumbo v6, "writingMode"

    invoke-static {v1, v6}, Landroidx/media3/common/util/XmlPullParserUtil;->getAttributeValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 477
    .local v22, "writingDirection":Ljava/lang/String;
    if-eqz v22, :cond_8

    .line 478
    invoke-static/range {v22 .. v22}, Lcom/google/common/base/Ascii;->toLowerCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->hashCode()I

    move-result v8

    sparse-switch v8, :sswitch_data_1

    :cond_7
    goto :goto_6

    :sswitch_2
    const-string/jumbo v4, "tbrl"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    move v13, v7

    goto :goto_7

    :sswitch_3
    const-string/jumbo v4, "tblr"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    goto :goto_7

    :sswitch_4
    const-string/jumbo v7, "tb"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_7

    move v13, v4

    goto :goto_7

    :goto_6
    move v13, v5

    :goto_7
    packed-switch v13, :pswitch_data_1

    goto :goto_8

    .line 485
    :pswitch_2
    const/4 v3, 0x1

    .line 486
    move/from16 v23, v3

    goto :goto_9

    .line 482
    :pswitch_3
    const/4 v3, 0x2

    .line 483
    move/from16 v23, v3

    goto :goto_9

    .line 492
    :cond_8
    :goto_8
    move/from16 v23, v3

    .end local v3    # "verticalType":I
    .local v23, "verticalType":I
    :goto_9
    new-instance v24, Landroidx/media3/extractor/text/ttml/TtmlRegion;

    const/4 v7, 0x0

    const/4 v13, 0x1

    move-object/from16 v3, v24

    move-object v4, v14

    move/from16 v5, v19

    move/from16 v6, v20

    move/from16 v8, v18

    move v9, v0

    move/from16 v10, v16

    move v11, v13

    move-object/from16 v25, v12

    .end local v12    # "regionExtent":Ljava/lang/String;
    .local v25, "regionExtent":Ljava/lang/String;
    move/from16 v12, v21

    move/from16 v13, v23

    invoke-direct/range {v3 .. v13}, Landroidx/media3/extractor/text/ttml/TtmlRegion;-><init>(Ljava/lang/String;FFIIFFIFI)V

    return-object v24

    .line 433
    .end local v0    # "width":F
    .end local v16    # "height":F
    .end local v17    # "displayAlign":Ljava/lang/String;
    .end local v18    # "lineAnchor":I
    .end local v20    # "line":F
    .end local v21    # "regionTextHeight":F
    .end local v22    # "writingDirection":Ljava/lang/String;
    .end local v23    # "verticalType":I
    .end local v25    # "regionExtent":Ljava/lang/String;
    .local v3, "extentPercentageMatcher":Ljava/util/regex/Matcher;
    .restart local v5    # "extentPixelMatcher":Ljava/util/regex/Matcher;
    .restart local v9    # "line":F
    .restart local v12    # "regionExtent":Ljava/lang/String;
    :catch_2
    move-exception v0

    move-object/from16 v25, v12

    .line 434
    .end local v12    # "regionExtent":Ljava/lang/String;
    .local v0, "e":Ljava/lang/NumberFormatException;
    .restart local v25    # "regionExtent":Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 435
    const/4 v6, 0x0

    return-object v6

    .line 438
    .end local v0    # "e":Ljava/lang/NumberFormatException;
    .end local v25    # "regionExtent":Ljava/lang/String;
    .restart local v12    # "regionExtent":Ljava/lang/String;
    :cond_9
    const/4 v6, 0x0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Ignoring region with unsupported extent: "

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 439
    return-object v6

    .line 442
    .end local v3    # "extentPercentageMatcher":Ljava/util/regex/Matcher;
    .end local v5    # "extentPixelMatcher":Ljava/util/regex/Matcher;
    :cond_a
    const/4 v6, 0x0

    const-string v0, "Ignoring region without an extent"

    invoke-static {v4, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 443
    return-object v6

    .line 387
    .end local v9    # "line":F
    .end local v12    # "regionExtent":Ljava/lang/String;
    .end local v19    # "position":F
    .local v5, "originPercentageMatcher":Ljava/util/regex/Matcher;
    .restart local v7    # "originPixelMatcher":Ljava/util/regex/Matcher;
    :catch_3
    move-exception v0

    .line 388
    .restart local v0    # "e":Ljava/lang/NumberFormatException;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v4, v3}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 389
    const/4 v3, 0x0

    return-object v3

    .line 392
    .end local v0    # "e":Ljava/lang/NumberFormatException;
    :cond_b
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Ignoring region with unsupported origin: "

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 393
    return-object v3

    .line 396
    .end local v5    # "originPercentageMatcher":Ljava/util/regex/Matcher;
    .end local v7    # "originPixelMatcher":Ljava/util/regex/Matcher;
    :cond_c
    const-string v0, "Ignoring region without an origin"

    invoke-static {v4, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 397
    return-object v3

    nop

    :sswitch_data_0
    .sparse-switch
        -0x514d33ab -> :sswitch_1
        0x58705dc -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch

    :sswitch_data_1
    .sparse-switch
        0xe6e -> :sswitch_4
        0x363874 -> :sswitch_3
        0x363928 -> :sswitch_2
    .end sparse-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_3
        :pswitch_3
        :pswitch_2
    .end packed-switch
.end method

.method private static parseShear(Ljava/lang/String;)F
    .locals 6
    .param p0, "expression"    # Ljava/lang/String;

    .line 793
    sget-object v0, Landroidx/media3/extractor/text/ttml/TtmlParser;->SIGNED_PERCENTAGE:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 794
    .local v0, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v1

    const v2, 0x7f7fffff    # Float.MAX_VALUE

    const-string v3, "TtmlParser"

    if-nez v1, :cond_0

    .line 795
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Invalid value for shear: "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 796
    return v2

    .line 799
    :cond_0
    const/4 v1, 0x1

    :try_start_0
    invoke-virtual {v0, v1}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 800
    .local v1, "percentage":Ljava/lang/String;
    invoke-static {v1}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v4

    .line 804
    .local v4, "value":F
    const/high16 v5, -0x3d380000    # -100.0f

    invoke-static {v5, v4}, Ljava/lang/Math;->max(FF)F

    move-result v5

    move v4, v5

    .line 805
    const/high16 v5, 0x42c80000    # 100.0f

    invoke-static {v5, v4}, Ljava/lang/Math;->min(FF)F

    move-result v2
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 806
    .end local v4    # "value":F
    .local v2, "value":F
    return v2

    .line 807
    .end local v1    # "percentage":Ljava/lang/String;
    .end local v2    # "value":F
    :catch_0
    move-exception v1

    .line 808
    .local v1, "e":Ljava/lang/NumberFormatException;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to parse shear: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v1}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 809
    return v2
.end method

.method private static parseStyleAttributes(Lorg/xmlpull/v1/XmlPullParser;Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;
    .locals 12
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p1, "style"    # Landroidx/media3/extractor/text/ttml/TtmlStyle;

    .line 512
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v0

    .line 513
    .local v0, "attributeCount":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_6

    .line 514
    invoke-interface {p0, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v2

    .line 515
    .local v2, "attributeValue":Ljava/lang/String;
    invoke-interface {p0, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v4

    const/4 v5, 0x5

    const/4 v6, 0x4

    const/4 v7, 0x3

    const/4 v8, 0x2

    const/4 v9, -0x1

    const/4 v10, 0x0

    const/4 v11, 0x1

    sparse-switch v4, :sswitch_data_0

    :cond_0
    goto/16 :goto_1

    :sswitch_0
    const-string/jumbo v4, "multiRowAlign"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/16 v3, 0x8

    goto/16 :goto_2

    :sswitch_1
    const-string v4, "backgroundColor"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    move v3, v11

    goto/16 :goto_2

    :sswitch_2
    const-string/jumbo v4, "rubyPosition"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/16 v3, 0xb

    goto/16 :goto_2

    :sswitch_3
    const-string/jumbo v4, "textEmphasis"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/16 v3, 0xd

    goto/16 :goto_2

    :sswitch_4
    const-string v4, "fontSize"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    move v3, v6

    goto/16 :goto_2

    :sswitch_5
    const-string/jumbo v4, "textCombine"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/16 v3, 0x9

    goto/16 :goto_2

    :sswitch_6
    const-string/jumbo v4, "shear"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/16 v3, 0xe

    goto :goto_2

    :sswitch_7
    const-string v4, "color"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    move v3, v8

    goto :goto_2

    :sswitch_8
    const-string/jumbo v4, "ruby"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/16 v3, 0xa

    goto :goto_2

    :sswitch_9
    const-string v4, "id"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    move v3, v10

    goto :goto_2

    :sswitch_a
    const-string v4, "fontWeight"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    move v3, v5

    goto :goto_2

    :sswitch_b
    const-string/jumbo v4, "textDecoration"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/16 v3, 0xc

    goto :goto_2

    :sswitch_c
    const-string/jumbo v4, "textAlign"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 v3, 0x7

    goto :goto_2

    :sswitch_d
    const-string v4, "fontFamily"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    move v3, v7

    goto :goto_2

    :sswitch_e
    const-string v4, "fontStyle"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 v3, 0x6

    goto :goto_2

    :goto_1
    move v3, v9

    :goto_2
    const-string v4, "TtmlParser"

    packed-switch v3, :pswitch_data_0

    goto/16 :goto_d

    .line 627
    :pswitch_0
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-static {v2}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseShear(Ljava/lang/String;)F

    move-result v4

    invoke-virtual {v3, v4}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setShearPercentage(F)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 628
    goto/16 :goto_d

    .line 624
    :pswitch_1
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-static {v2}, Landroidx/media3/extractor/text/ttml/TextEmphasis;->parse(Ljava/lang/String;)Landroidx/media3/extractor/text/ttml/TextEmphasis;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setTextEmphasis(Landroidx/media3/extractor/text/ttml/TextEmphasis;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 625
    goto/16 :goto_d

    .line 608
    :pswitch_2
    invoke-static {v2}, Lcom/google/common/base/Ascii;->toLowerCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v4

    sparse-switch v4, :sswitch_data_1

    :cond_1
    goto :goto_3

    :sswitch_f
    const-string v4, "linethrough"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    move v7, v10

    goto :goto_4

    :sswitch_10
    const-string/jumbo v4, "nolinethrough"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    move v7, v11

    goto :goto_4

    :sswitch_11
    const-string/jumbo v4, "underline"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    move v7, v8

    goto :goto_4

    :sswitch_12
    const-string/jumbo v4, "nounderline"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    goto :goto_4

    :goto_3
    move v7, v9

    :goto_4
    packed-switch v7, :pswitch_data_1

    goto :goto_5

    .line 619
    :pswitch_3
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v10}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setUnderline(Z)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    goto :goto_5

    .line 616
    :pswitch_4
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v11}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setUnderline(Z)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 617
    goto :goto_5

    .line 613
    :pswitch_5
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v10}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setLinethrough(Z)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 614
    goto :goto_5

    .line 610
    :pswitch_6
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v11}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setLinethrough(Z)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 611
    nop

    .line 622
    :goto_5
    goto/16 :goto_d

    .line 595
    :pswitch_7
    invoke-static {v2}, Lcom/google/common/base/Ascii;->toLowerCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v4

    sparse-switch v4, :sswitch_data_2

    :cond_2
    goto :goto_6

    :sswitch_13
    const-string v4, "after"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    move v9, v11

    goto :goto_6

    :sswitch_14
    const-string v4, "before"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    move v9, v10

    :goto_6
    packed-switch v9, :pswitch_data_2

    goto :goto_7

    .line 600
    :pswitch_8
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v8}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setRubyPosition(I)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 601
    goto :goto_7

    .line 597
    :pswitch_9
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v11}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setRubyPosition(I)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 598
    nop

    .line 606
    :goto_7
    goto/16 :goto_d

    .line 574
    :pswitch_a
    invoke-static {v2}, Lcom/google/common/base/Ascii;->toLowerCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v4

    sparse-switch v4, :sswitch_data_3

    :cond_3
    goto :goto_8

    :sswitch_15
    const-string/jumbo v4, "text"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    move v5, v7

    goto :goto_9

    :sswitch_16
    const-string v4, "base"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    move v5, v11

    goto :goto_9

    :sswitch_17
    const-string/jumbo v4, "textContainer"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    move v5, v6

    goto :goto_9

    :sswitch_18
    const-string v4, "delimiter"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    goto :goto_9

    :sswitch_19
    const-string v4, "container"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    move v5, v10

    goto :goto_9

    :sswitch_1a
    const-string v4, "baseContainer"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    move v5, v8

    goto :goto_9

    :goto_8
    move v5, v9

    :goto_9
    packed-switch v5, :pswitch_data_3

    goto :goto_a

    .line 587
    :pswitch_b
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setRubyType(I)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 588
    goto :goto_a

    .line 584
    :pswitch_c
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setRubyType(I)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 585
    goto :goto_a

    .line 580
    :pswitch_d
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v8}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setRubyType(I)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 581
    goto :goto_a

    .line 576
    :pswitch_e
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v11}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setRubyType(I)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 577
    nop

    .line 593
    :goto_a
    goto/16 :goto_d

    .line 561
    :pswitch_f
    invoke-static {v2}, Lcom/google/common/base/Ascii;->toLowerCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v4

    sparse-switch v4, :sswitch_data_4

    :cond_4
    goto :goto_b

    :sswitch_1b
    const-string/jumbo v4, "none"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    move v9, v10

    goto :goto_b

    :sswitch_1c
    const-string v4, "all"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    move v9, v11

    :goto_b
    packed-switch v9, :pswitch_data_4

    goto :goto_c

    .line 566
    :pswitch_10
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v11}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setTextCombine(Z)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 567
    goto :goto_c

    .line 563
    :pswitch_11
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v10}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setTextCombine(Z)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 564
    nop

    .line 572
    :goto_c
    goto/16 :goto_d

    .line 558
    :pswitch_12
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-static {v2}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseAlignment(Ljava/lang/String;)Landroid/text/Layout$Alignment;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setMultiRowAlign(Landroid/text/Layout$Alignment;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 559
    goto/16 :goto_d

    .line 555
    :pswitch_13
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-static {v2}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseAlignment(Ljava/lang/String;)Landroid/text/Layout$Alignment;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setTextAlign(Landroid/text/Layout$Alignment;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 556
    goto/16 :goto_d

    .line 552
    :pswitch_14
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    const-string v4, "italic"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    invoke-virtual {v3, v4}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setItalic(Z)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 553
    goto/16 :goto_d

    .line 549
    :pswitch_15
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    const-string v4, "bold"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    invoke-virtual {v3, v4}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setBold(Z)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 550
    goto/16 :goto_d

    .line 542
    :pswitch_16
    :try_start_0
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    move-object p1, v3

    .line 543
    invoke-static {v2, p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseFontSize(Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlStyle;)V
    :try_end_0
    .catch Landroidx/media3/extractor/text/SubtitleDecoderException; {:try_start_0 .. :try_end_0} :catch_0

    .line 546
    goto/16 :goto_d

    .line 544
    :catch_0
    move-exception v3

    .line 545
    .local v3, "e":Landroidx/media3/extractor/text/SubtitleDecoderException;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Failed parsing fontSize value: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 547
    .end local v3    # "e":Landroidx/media3/extractor/text/SubtitleDecoderException;
    goto :goto_d

    .line 538
    :pswitch_17
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setFontFamily(Ljava/lang/String;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 539
    goto :goto_d

    .line 530
    :pswitch_18
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 532
    :try_start_1
    invoke-static {v2}, Landroidx/media3/common/util/ColorParser;->parseTtmlColor(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {p1, v3}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setFontColor(I)Landroidx/media3/extractor/text/ttml/TtmlStyle;
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1

    .line 535
    goto :goto_d

    .line 533
    :catch_1
    move-exception v3

    .line 534
    .local v3, "e":Ljava/lang/IllegalArgumentException;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Failed parsing color value: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 536
    .end local v3    # "e":Ljava/lang/IllegalArgumentException;
    goto :goto_d

    .line 522
    :pswitch_19
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 524
    :try_start_2
    invoke-static {v2}, Landroidx/media3/common/util/ColorParser;->parseTtmlColor(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {p1, v3}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setBackgroundColor(I)Landroidx/media3/extractor/text/ttml/TtmlStyle;
    :try_end_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_2

    .line 527
    goto :goto_d

    .line 525
    :catch_2
    move-exception v3

    .line 526
    .restart local v3    # "e":Ljava/lang/IllegalArgumentException;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Failed parsing background value: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 528
    .end local v3    # "e":Ljava/lang/IllegalArgumentException;
    goto :goto_d

    .line 517
    :pswitch_1a
    const-string/jumbo v3, "style"

    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 518
    invoke-static {p1}, Landroidx/media3/extractor/text/ttml/TtmlParser;->createIfNull(Landroidx/media3/extractor/text/ttml/TtmlStyle;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroidx/media3/extractor/text/ttml/TtmlStyle;->setId(Ljava/lang/String;)Landroidx/media3/extractor/text/ttml/TtmlStyle;

    move-result-object p1

    .line 513
    .end local v2    # "attributeValue":Ljava/lang/String;
    :cond_5
    :goto_d
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_0

    .line 634
    .end local v1    # "i":I
    :cond_6
    return-object p1

    nop

    :sswitch_data_0
    .sparse-switch
        -0x5c71855e -> :sswitch_e
        -0x48ff636d -> :sswitch_d
        -0x3f826a28 -> :sswitch_c
        -0x3468fa43 -> :sswitch_b
        -0x2bc67c59 -> :sswitch_a
        0xd1b -> :sswitch_9
        0x3595da -> :sswitch_8
        0x5a72f63 -> :sswitch_7
        0x6855ce1 -> :sswitch_6
        0x6909352 -> :sswitch_5
        0x15caa0f0 -> :sswitch_4
        0x36e741c9 -> :sswitch_3
        0x42841923 -> :sswitch_2
        0x4cb7f6d5 -> :sswitch_1
        0x6899f5a4 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_f
        :pswitch_a
        :pswitch_7
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch

    :sswitch_data_1
    .sparse-switch
        -0x57195dd5 -> :sswitch_12
        -0x3d363934 -> :sswitch_11
        0x36723ff0 -> :sswitch_10
        0x641ec051 -> :sswitch_f
    .end sparse-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
    .end packed-switch

    :sswitch_data_2
    .sparse-switch
        -0x5305c081 -> :sswitch_14
        0x58705dc -> :sswitch_13
    .end sparse-switch

    :pswitch_data_2
    .packed-switch 0x0
        :pswitch_9
        :pswitch_8
    .end packed-switch

    :sswitch_data_3
    .sparse-switch
        -0x24de7f50 -> :sswitch_1a
        -0x187eb37f -> :sswitch_19
        -0xeee99f9 -> :sswitch_18
        -0x81c562c -> :sswitch_17
        0x2e06d1 -> :sswitch_16
        0x36452d -> :sswitch_15
    .end sparse-switch

    :pswitch_data_3
    .packed-switch 0x0
        :pswitch_e
        :pswitch_d
        :pswitch_d
        :pswitch_c
        :pswitch_c
        :pswitch_b
    .end packed-switch

    :sswitch_data_4
    .sparse-switch
        0x179a1 -> :sswitch_1c
        0x33af38 -> :sswitch_1b
    .end sparse-switch

    :pswitch_data_4
    .packed-switch 0x0
        :pswitch_11
        :pswitch_10
    .end packed-switch
.end method

.method private static parseStyleIds(Ljava/lang/String;)[Ljava/lang/String;
    .locals 1
    .param p0, "parentStyleIds"    # Ljava/lang/String;

    .line 506
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    .line 507
    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    goto :goto_0

    :cond_0
    const-string v0, "\\s+"

    invoke-static {p0, v0}, Landroidx/media3/common/util/Util;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0
.end method

.method private static parseTimeExpression(Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;)J
    .locals 16
    .param p0, "time"    # Ljava/lang/String;
    .param p1, "frameAndTickRate"    # Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/extractor/text/SubtitleDecoderException;
        }
    .end annotation

    .line 826
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    sget-object v2, Landroidx/media3/extractor/text/ttml/TtmlParser;->CLOCK_TIME:Ljava/util/regex/Pattern;

    invoke-virtual {v2, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 827
    .local v2, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->matches()Z

    move-result v3

    const/4 v6, 0x5

    const/4 v7, 0x4

    const/4 v8, 0x3

    const/4 v9, 0x2

    const/4 v10, 0x1

    if-eqz v3, :cond_3

    .line 828
    invoke-virtual {v2, v10}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 829
    .local v3, "hours":Ljava/lang/String;
    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v10

    const-wide/16 v12, 0xe10

    mul-long/2addr v10, v12

    long-to-double v10, v10

    .line 830
    .local v10, "durationSeconds":D
    invoke-virtual {v2, v9}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 831
    .local v9, "minutes":Ljava/lang/String;
    invoke-static {v9}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v12

    const-wide/16 v14, 0x3c

    mul-long/2addr v12, v14

    long-to-double v12, v12

    add-double/2addr v10, v12

    .line 832
    invoke-virtual {v2, v8}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 833
    .local v8, "seconds":Ljava/lang/String;
    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v12

    long-to-double v12, v12

    add-double/2addr v10, v12

    .line 834
    invoke-virtual {v2, v7}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v7

    .line 835
    .local v7, "fraction":Ljava/lang/String;
    const-wide/16 v12, 0x0

    if-eqz v7, :cond_0

    invoke-static {v7}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v14

    goto :goto_0

    :cond_0
    move-wide v14, v12

    :goto_0
    add-double/2addr v10, v14

    .line 836
    invoke-virtual {v2, v6}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v6

    .line 837
    .local v6, "frames":Ljava/lang/String;
    nop

    .line 838
    if-eqz v6, :cond_1

    invoke-static {v6}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v14

    long-to-float v14, v14

    iget v15, v1, Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;->effectiveFrameRate:F

    div-float/2addr v14, v15

    float-to-double v14, v14

    goto :goto_1

    :cond_1
    move-wide v14, v12

    :goto_1
    add-double/2addr v10, v14

    .line 839
    const/4 v14, 0x6

    invoke-virtual {v2, v14}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v14

    .line 840
    .local v14, "subframes":Ljava/lang/String;
    nop

    .line 841
    if-eqz v14, :cond_2

    .line 844
    nop

    .line 842
    invoke-static {v14}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v12

    long-to-double v12, v12

    iget v15, v1, Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;->subFrameRate:I

    int-to-double v4, v15

    div-double/2addr v12, v4

    iget v4, v1, Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;->effectiveFrameRate:F

    float-to-double v4, v4

    div-double/2addr v12, v4

    goto :goto_2

    .line 845
    :cond_2
    nop

    :goto_2
    add-double/2addr v10, v12

    .line 846
    const-wide v4, 0x412e848000000000L    # 1000000.0

    mul-double/2addr v4, v10

    double-to-long v4, v4

    return-wide v4

    .line 848
    .end local v3    # "hours":Ljava/lang/String;
    .end local v6    # "frames":Ljava/lang/String;
    .end local v7    # "fraction":Ljava/lang/String;
    .end local v8    # "seconds":Ljava/lang/String;
    .end local v9    # "minutes":Ljava/lang/String;
    .end local v10    # "durationSeconds":D
    .end local v14    # "subframes":Ljava/lang/String;
    :cond_3
    sget-object v3, Landroidx/media3/extractor/text/ttml/TtmlParser;->OFFSET_TIME:Ljava/util/regex/Pattern;

    invoke-virtual {v3, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 849
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->matches()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 850
    invoke-virtual {v2, v10}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 851
    .local v3, "timeValue":Ljava/lang/String;
    invoke-static {v3}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    .line 852
    .local v4, "offsetSeconds":D
    invoke-virtual {v2, v9}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 853
    .local v11, "unit":Ljava/lang/String;
    invoke-virtual {v11}, Ljava/lang/String;->hashCode()I

    move-result v12

    sparse-switch v12, :sswitch_data_0

    :cond_4
    goto :goto_3

    :sswitch_0
    const-string/jumbo v6, "ms"

    invoke-virtual {v11, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    move v6, v8

    goto :goto_4

    :sswitch_1
    const-string/jumbo v7, "t"

    invoke-virtual {v11, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    goto :goto_4

    :sswitch_2
    const-string/jumbo v6, "s"

    invoke-virtual {v11, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    move v6, v9

    goto :goto_4

    :sswitch_3
    const-string v6, "m"

    invoke-virtual {v11, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    move v6, v10

    goto :goto_4

    :sswitch_4
    const-string v6, "h"

    invoke-virtual {v11, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    const/4 v6, 0x0

    goto :goto_4

    :sswitch_5
    const-string v6, "f"

    invoke-virtual {v11, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    move v6, v7

    goto :goto_4

    :goto_3
    const/4 v6, -0x1

    :goto_4
    packed-switch v6, :pswitch_data_0

    goto :goto_5

    .line 870
    :pswitch_0
    iget v6, v1, Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;->tickRate:I

    int-to-double v6, v6

    div-double/2addr v4, v6

    goto :goto_5

    .line 867
    :pswitch_1
    iget v6, v1, Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;->effectiveFrameRate:F

    float-to-double v6, v6

    div-double/2addr v4, v6

    .line 868
    goto :goto_5

    .line 864
    :pswitch_2
    const-wide v6, 0x408f400000000000L    # 1000.0

    div-double/2addr v4, v6

    .line 865
    goto :goto_5

    .line 862
    :pswitch_3
    goto :goto_5

    .line 858
    :pswitch_4
    const-wide/high16 v6, 0x404e000000000000L    # 60.0

    mul-double/2addr v4, v6

    .line 859
    goto :goto_5

    .line 855
    :pswitch_5
    const-wide v6, 0x40ac200000000000L    # 3600.0

    mul-double/2addr v4, v6

    .line 856
    nop

    .line 873
    :goto_5
    const-wide v6, 0x412e848000000000L    # 1000000.0

    mul-double/2addr v6, v4

    double-to-long v6, v6

    return-wide v6

    .line 875
    .end local v3    # "timeValue":Ljava/lang/String;
    .end local v4    # "offsetSeconds":D
    .end local v11    # "unit":Ljava/lang/String;
    :cond_5
    new-instance v3, Landroidx/media3/extractor/text/SubtitleDecoderException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Malformed time expression: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Landroidx/media3/extractor/text/SubtitleDecoderException;-><init>(Ljava/lang/String;)V

    throw v3

    :sswitch_data_0
    .sparse-switch
        0x66 -> :sswitch_5
        0x68 -> :sswitch_4
        0x6d -> :sswitch_3
        0x73 -> :sswitch_2
        0x74 -> :sswitch_1
        0xda6 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static parseTtsExtent(Lorg/xmlpull/v1/XmlPullParser;)Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    .locals 7
    .param p0, "xmlParser"    # Lorg/xmlpull/v1/XmlPullParser;

    .line 275
    const-string v0, "extent"

    invoke-static {p0, v0}, Landroidx/media3/common/util/XmlPullParserUtil;->getAttributeValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 276
    .local v0, "ttsExtent":Ljava/lang/String;
    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 277
    return-object v1

    .line 280
    :cond_0
    sget-object v2, Landroidx/media3/extractor/text/ttml/TtmlParser;->PIXEL_COORDINATES:Ljava/util/regex/Pattern;

    invoke-virtual {v2, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 281
    .local v2, "extentMatcher":Ljava/util/regex/Matcher;
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->matches()Z

    move-result v3

    const-string v4, "TtmlParser"

    if-nez v3, :cond_1

    .line 282
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Ignoring non-pixel tts extent: "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v4, v3}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 283
    return-object v1

    .line 286
    :cond_1
    const/4 v3, 0x1

    :try_start_0
    invoke-virtual {v2, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    .line 287
    .local v3, "width":I
    const/4 v5, 0x2

    invoke-virtual {v2, v5}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    .line 288
    .local v5, "height":I
    new-instance v6, Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;

    invoke-direct {v6, v3, v5}, Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;-><init>(II)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v6

    .line 289
    .end local v3    # "width":I
    .end local v5    # "height":I
    :catch_0
    move-exception v3

    .line 290
    .local v3, "e":Ljava/lang/NumberFormatException;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Ignoring malformed tts extent: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 291
    return-object v1
.end method


# virtual methods
.method public getCueReplacementBehavior()I
    .locals 1

    .line 132
    const/4 v0, 0x1

    return v0
.end method

.method public parse([BIILandroidx/media3/extractor/text/SubtitleParser$OutputOptions;Landroidx/media3/common/util/Consumer;)V
    .locals 1
    .param p1, "data"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .param p4, "outputOptions"    # Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([BII",
            "Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;",
            "Landroidx/media3/common/util/Consumer<",
            "Landroidx/media3/extractor/text/CuesWithTiming;",
            ">;)V"
        }
    .end annotation

    .line 142
    .local p5, "output":Landroidx/media3/common/util/Consumer;, "Landroidx/media3/common/util/Consumer<Landroidx/media3/extractor/text/CuesWithTiming;>;"
    invoke-virtual {p0, p1, p2, p3}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseToLegacySubtitle([BII)Landroidx/media3/extractor/text/Subtitle;

    move-result-object v0

    .line 143
    .local v0, "subtitle":Landroidx/media3/extractor/text/Subtitle;
    invoke-static {v0, p4, p5}, Landroidx/media3/extractor/text/LegacySubtitleUtil;->toCuesWithTiming(Landroidx/media3/extractor/text/Subtitle;Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;Landroidx/media3/common/util/Consumer;)V

    .line 144
    return-void
.end method

.method public parseToLegacySubtitle([BII)Landroidx/media3/extractor/text/Subtitle;
    .locals 21
    .param p1, "data"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I

    .line 149
    const-string v0, ""

    move-object/from16 v1, p0

    :try_start_0
    iget-object v2, v1, Landroidx/media3/extractor/text/ttml/TtmlParser;->xmlParserFactory:Lorg/xmlpull/v1/XmlPullParserFactory;

    invoke-virtual {v2}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    .line 150
    .local v2, "xmlParser":Lorg/xmlpull/v1/XmlPullParser;
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    move-object v9, v3

    .line 151
    .local v9, "globalStyles":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlStyle;>;"
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    move-object v10, v3

    .line 152
    .local v10, "regionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlRegion;>;"
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    move-object v11, v3

    .line 153
    .local v11, "imageMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v3, Landroidx/media3/extractor/text/ttml/TtmlRegion;

    invoke-direct {v3, v0}, Landroidx/media3/extractor/text/ttml/TtmlRegion;-><init>(Ljava/lang/String;)V

    invoke-interface {v10, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 154
    new-instance v0, Ljava/io/ByteArrayInputStream;

    move-object/from16 v12, p1

    move/from16 v13, p2

    move/from16 v14, p3

    invoke-direct {v0, v12, v13, v14}, Ljava/io/ByteArrayInputStream;-><init>([BII)V

    move-object v15, v0

    .line 155
    .local v15, "inputStream":Ljava/io/ByteArrayInputStream;
    const/4 v0, 0x0

    invoke-interface {v2, v15, v0}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 156
    const/4 v0, 0x0

    .line 157
    .local v0, "ttmlSubtitle":Landroidx/media3/extractor/text/ttml/TtmlSubtitle;
    new-instance v3, Ljava/util/ArrayDeque;

    invoke-direct {v3}, Ljava/util/ArrayDeque;-><init>()V

    move-object v8, v3

    .line 158
    .local v8, "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    const/4 v3, 0x0

    .line 159
    .local v3, "unsupportedNodeDepth":I
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v4

    .line 160
    .local v4, "eventType":I
    sget-object v5, Landroidx/media3/extractor/text/ttml/TtmlParser;->DEFAULT_FRAME_AND_TICK_RATE:Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;

    .line 161
    .local v5, "frameAndTickRate":Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    const/16 v6, 0xf

    .line 162
    .local v6, "cellRows":I
    const/4 v7, 0x0

    move-object/from16 v16, v0

    move/from16 v17, v3

    move-object v0, v7

    move v7, v4

    .line 163
    .end local v3    # "unsupportedNodeDepth":I
    .end local v4    # "eventType":I
    .local v0, "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    .local v7, "eventType":I
    .local v16, "ttmlSubtitle":Landroidx/media3/extractor/text/ttml/TtmlSubtitle;
    .local v17, "unsupportedNodeDepth":I
    :goto_0
    const/4 v3, 0x1

    if-eq v7, v3, :cond_b

    .line 164
    invoke-virtual {v8}, Ljava/util/ArrayDeque;->peek()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/extractor/text/ttml/TtmlNode;

    move-object v4, v3

    .line 165
    .local v4, "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    const/4 v3, 0x2

    if-nez v17, :cond_8

    .line 166
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v19
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-object/from16 v20, v19

    .line 167
    .local v20, "name":Ljava/lang/String;
    move-object/from16 v19, v0

    .end local v0    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    .local v19, "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    const-string/jumbo v0, "tt"

    if-ne v7, v3, :cond_4

    .line 168
    move-object/from16 v3, v20

    .end local v20    # "name":Ljava/lang/String;
    .local v3, "name":Ljava/lang/String;
    :try_start_1
    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 169
    invoke-static {v2}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseFrameAndTickRates(Lorg/xmlpull/v1/XmlPullParser;)Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;

    move-result-object v0

    move-object v5, v0

    .line 170
    const/16 v0, 0xf

    invoke-static {v2, v0}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseCellRows(Lorg/xmlpull/v1/XmlPullParser;I)I

    move-result v0

    move v6, v0

    .line 171
    invoke-static {v2}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseTtsExtent(Lorg/xmlpull/v1/XmlPullParser;)Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;

    move-result-object v0

    move-object/from16 v19, v0

    move/from16 v18, v6

    move-object v6, v5

    .end local v19    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    .restart local v0    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    goto :goto_1

    .line 168
    .end local v0    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    .restart local v19    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    :cond_0
    move/from16 v18, v6

    move-object v6, v5

    .line 173
    .end local v5    # "frameAndTickRate":Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .local v6, "frameAndTickRate":Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .local v18, "cellRows":I
    :goto_1
    invoke-static {v3}, Landroidx/media3/extractor/text/ttml/TtmlParser;->isSupportedTag(Ljava/lang/String;)Z

    move-result v0
    :try_end_1
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    const-string v5, "TtmlParser"

    if-nez v0, :cond_1

    .line 174
    :try_start_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Ignoring unsupported tag: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v5, v0}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    add-int/lit8 v17, v17, 0x1

    move-object v1, v4

    move-object v5, v6

    move v13, v7

    move-object v14, v8

    move/from16 v6, v18

    move-object/from16 v0, v19

    goto/16 :goto_4

    .line 176
    :cond_1
    const-string v0, "head"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 177
    move-object v1, v3

    .end local v3    # "name":Ljava/lang/String;
    .local v1, "name":Ljava/lang/String;
    move-object v3, v2

    move-object v5, v4

    .end local v4    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .local v5, "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    move-object v4, v9

    move-object/from16 v20, v1

    move-object v1, v5

    .end local v5    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .local v1, "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .restart local v20    # "name":Ljava/lang/String;
    move/from16 v5, v18

    move-object v12, v6

    .end local v6    # "frameAndTickRate":Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .local v12, "frameAndTickRate":Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    move-object/from16 v6, v19

    move v13, v7

    .end local v7    # "eventType":I
    .local v13, "eventType":I
    move-object v7, v10

    move-object v14, v8

    .end local v8    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .local v14, "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    move-object v8, v11

    invoke-static/range {v3 .. v8}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseHeader(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;ILandroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;
    :try_end_2
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_2

    .line 180
    .end local v1    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .end local v12    # "frameAndTickRate":Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .end local v13    # "eventType":I
    .end local v14    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .end local v20    # "name":Ljava/lang/String;
    .restart local v3    # "name":Ljava/lang/String;
    .restart local v4    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .restart local v6    # "frameAndTickRate":Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .restart local v7    # "eventType":I
    .restart local v8    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    :cond_2
    move-object/from16 v20, v3

    move-object v1, v4

    move-object v12, v6

    move v13, v7

    move-object v14, v8

    .end local v3    # "name":Ljava/lang/String;
    .end local v4    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .end local v6    # "frameAndTickRate":Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .end local v7    # "eventType":I
    .end local v8    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .restart local v1    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .restart local v12    # "frameAndTickRate":Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .restart local v13    # "eventType":I
    .restart local v14    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .restart local v20    # "name":Ljava/lang/String;
    :try_start_3
    invoke-static {v2, v1, v10, v12}, Landroidx/media3/extractor/text/ttml/TtmlParser;->parseNode(Lorg/xmlpull/v1/XmlPullParser;Landroidx/media3/extractor/text/ttml/TtmlNode;Ljava/util/Map;Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;)Landroidx/media3/extractor/text/ttml/TtmlNode;

    move-result-object v0

    .line 181
    .local v0, "node":Landroidx/media3/extractor/text/ttml/TtmlNode;
    invoke-virtual {v14, v0}, Ljava/util/ArrayDeque;->push(Ljava/lang/Object;)V

    .line 182
    if-eqz v1, :cond_3

    .line 183
    invoke-virtual {v1, v0}, Landroidx/media3/extractor/text/ttml/TtmlNode;->addChild(Landroidx/media3/extractor/text/ttml/TtmlNode;)V
    :try_end_3
    .catch Landroidx/media3/extractor/text/SubtitleDecoderException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    .line 189
    .end local v0    # "node":Landroidx/media3/extractor/text/ttml/TtmlNode;
    :cond_3
    nop

    .line 201
    .end local v20    # "name":Ljava/lang/String;
    :goto_2
    move-object v5, v12

    move/from16 v6, v18

    move-object/from16 v0, v19

    goto :goto_4

    .line 185
    .restart local v20    # "name":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 186
    .local v0, "e":Landroidx/media3/extractor/text/SubtitleDecoderException;
    :try_start_4
    const-string v3, "Suppressing parser error"

    invoke-static {v5, v3, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 188
    nop

    .end local v0    # "e":Landroidx/media3/extractor/text/SubtitleDecoderException;
    add-int/lit8 v17, v17, 0x1

    .line 189
    move-object v5, v12

    move/from16 v6, v18

    move-object/from16 v0, v19

    goto :goto_4

    .line 191
    .end local v1    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .end local v12    # "frameAndTickRate":Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .end local v13    # "eventType":I
    .end local v14    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .end local v18    # "cellRows":I
    .restart local v4    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .local v5, "frameAndTickRate":Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .local v6, "cellRows":I
    .restart local v7    # "eventType":I
    .restart local v8    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    :cond_4
    move-object v1, v4

    move v13, v7

    move-object v14, v8

    .end local v4    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .end local v7    # "eventType":I
    .end local v8    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .restart local v1    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .restart local v13    # "eventType":I
    .restart local v14    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    const/4 v3, 0x4

    if-ne v13, v3, :cond_5

    .line 192
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/text/ttml/TtmlNode;

    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/extractor/text/ttml/TtmlNode;->buildTextNode(Ljava/lang/String;)Landroidx/media3/extractor/text/ttml/TtmlNode;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroidx/media3/extractor/text/ttml/TtmlNode;->addChild(Landroidx/media3/extractor/text/ttml/TtmlNode;)V

    goto :goto_3

    .line 193
    :cond_5
    const/4 v3, 0x3

    if-ne v13, v3, :cond_7

    .line 194
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 195
    new-instance v0, Landroidx/media3/extractor/text/ttml/TtmlSubtitle;

    .line 197
    invoke-virtual {v14}, Ljava/util/ArrayDeque;->peek()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/extractor/text/ttml/TtmlNode;

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/extractor/text/ttml/TtmlNode;

    invoke-direct {v0, v3, v9, v10, v11}, Landroidx/media3/extractor/text/ttml/TtmlSubtitle;-><init>(Landroidx/media3/extractor/text/ttml/TtmlNode;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V

    move-object/from16 v16, v0

    .line 199
    :cond_6
    invoke-virtual {v14}, Ljava/util/ArrayDeque;->pop()Ljava/lang/Object;

    move-object/from16 v0, v19

    goto :goto_4

    .line 201
    .end local v20    # "name":Ljava/lang/String;
    :cond_7
    :goto_3
    move-object/from16 v0, v19

    .end local v19    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    .local v0, "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    :goto_4
    goto :goto_5

    .line 202
    .end local v1    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .end local v13    # "eventType":I
    .end local v14    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .restart local v4    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .restart local v7    # "eventType":I
    .restart local v8    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    :cond_8
    move-object/from16 v19, v0

    move-object v1, v4

    move v13, v7

    move-object v14, v8

    .end local v0    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    .end local v4    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .end local v7    # "eventType":I
    .end local v8    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .restart local v1    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .restart local v13    # "eventType":I
    .restart local v14    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .restart local v19    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    if-ne v13, v3, :cond_9

    .line 203
    add-int/lit8 v17, v17, 0x1

    move-object/from16 v0, v19

    goto :goto_5

    .line 204
    :cond_9
    const/4 v0, 0x3

    if-ne v13, v0, :cond_a

    .line 205
    add-int/lit8 v17, v17, -0x1

    move-object/from16 v0, v19

    goto :goto_5

    .line 204
    :cond_a
    move-object/from16 v0, v19

    .line 208
    .end local v19    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    .restart local v0    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    :goto_5
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 209
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v3

    move v7, v3

    .line 210
    .end local v1    # "parent":Landroidx/media3/extractor/text/ttml/TtmlNode;
    .end local v13    # "eventType":I
    .restart local v7    # "eventType":I
    move-object/from16 v1, p0

    move-object/from16 v12, p1

    move/from16 v13, p2

    move-object v8, v14

    move/from16 v14, p3

    goto/16 :goto_0

    .line 211
    .end local v14    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .restart local v8    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    :cond_b
    move-object/from16 v19, v0

    move v13, v7

    move-object v14, v8

    .end local v0    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    .end local v7    # "eventType":I
    .end local v8    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .restart local v13    # "eventType":I
    .restart local v14    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .restart local v19    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    invoke-static/range {v16 .. v16}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/text/Subtitle;
    :try_end_4
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    return-object v0

    .line 214
    .end local v2    # "xmlParser":Lorg/xmlpull/v1/XmlPullParser;
    .end local v5    # "frameAndTickRate":Landroidx/media3/extractor/text/ttml/TtmlParser$FrameAndTickRate;
    .end local v6    # "cellRows":I
    .end local v9    # "globalStyles":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlStyle;>;"
    .end local v10    # "regionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroidx/media3/extractor/text/ttml/TtmlRegion;>;"
    .end local v11    # "imageMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v13    # "eventType":I
    .end local v14    # "nodeStack":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/extractor/text/ttml/TtmlNode;>;"
    .end local v15    # "inputStream":Ljava/io/ByteArrayInputStream;
    .end local v16    # "ttmlSubtitle":Landroidx/media3/extractor/text/ttml/TtmlSubtitle;
    .end local v17    # "unsupportedNodeDepth":I
    .end local v19    # "ttsExtent":Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
    :catch_1
    move-exception v0

    .line 215
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Unexpected error when reading input."

    invoke-direct {v1, v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 212
    .end local v0    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v0

    .line 213
    .local v0, "xppe":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Unable to decode source"

    invoke-direct {v1, v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method
