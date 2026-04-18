.class final Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;
.super Ljava/lang/Object;
.source "TtmlParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/extractor/text/ttml/TtmlParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "TtsExtent"
.end annotation


# instance fields
.field final height:I

.field final width:I


# direct methods
.method constructor <init>(II)V
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I

    .line 895
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 896
    iput p1, p0, Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;->width:I

    .line 897
    iput p2, p0, Landroidx/media3/extractor/text/ttml/TtmlParser$TtsExtent;->height:I

    .line 898
    return-void
.end method
