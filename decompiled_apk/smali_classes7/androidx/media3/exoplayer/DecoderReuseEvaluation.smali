.class public final Landroidx/media3/exoplayer/DecoderReuseEvaluation;
.super Ljava/lang/Object;
.source "DecoderReuseEvaluation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/DecoderReuseEvaluation$DecoderDiscardReasons;,
        Landroidx/media3/exoplayer/DecoderReuseEvaluation$DecoderReuseResult;
    }
.end annotation


# static fields
.field public static final DISCARD_REASON_APP_OVERRIDE:I = 0x4

.field public static final DISCARD_REASON_AUDIO_BYPASS_POSSIBLE:I = 0x8000

.field public static final DISCARD_REASON_AUDIO_CHANNEL_COUNT_CHANGED:I = 0x1000

.field public static final DISCARD_REASON_AUDIO_ENCODING_CHANGED:I = 0x4000

.field public static final DISCARD_REASON_AUDIO_SAMPLE_RATE_CHANGED:I = 0x2000

.field public static final DISCARD_REASON_DRM_SESSION_CHANGED:I = 0x80

.field public static final DISCARD_REASON_INITIALIZATION_DATA_CHANGED:I = 0x20

.field public static final DISCARD_REASON_MAX_INPUT_SIZE_EXCEEDED:I = 0x40

.field public static final DISCARD_REASON_MIME_TYPE_CHANGED:I = 0x8

.field public static final DISCARD_REASON_OPERATING_RATE_CHANGED:I = 0x10

.field public static final DISCARD_REASON_REUSE_NOT_IMPLEMENTED:I = 0x1

.field public static final DISCARD_REASON_VIDEO_COLOR_INFO_CHANGED:I = 0x800

.field public static final DISCARD_REASON_VIDEO_MAX_RESOLUTION_EXCEEDED:I = 0x100

.field public static final DISCARD_REASON_VIDEO_RESOLUTION_CHANGED:I = 0x200

.field public static final DISCARD_REASON_VIDEO_ROTATION_CHANGED:I = 0x400

.field public static final DISCARD_REASON_WORKAROUND:I = 0x2

.field public static final REUSE_RESULT_NO:I = 0x0

.field public static final REUSE_RESULT_YES_WITHOUT_RECONFIGURATION:I = 0x3

.field public static final REUSE_RESULT_YES_WITH_FLUSH:I = 0x1

.field public static final REUSE_RESULT_YES_WITH_RECONFIGURATION:I = 0x2


# instance fields
.field public final decoderName:Ljava/lang/String;

.field public final discardReasons:I

.field public final newFormat:Landroidx/media3/common/Format;

.field public final oldFormat:Landroidx/media3/common/Format;

.field public final result:I


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroidx/media3/common/Format;Landroidx/media3/common/Format;II)V
    .locals 1
    .param p1, "decoderName"    # Ljava/lang/String;
    .param p2, "oldFormat"    # Landroidx/media3/common/Format;
    .param p3, "newFormat"    # Landroidx/media3/common/Format;
    .param p4, "result"    # I
    .param p5, "discardReasons"    # I

    .line 171
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 172
    if-eqz p4, :cond_1

    if-nez p5, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 173
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotEmpty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->decoderName:Ljava/lang/String;

    .line 174
    invoke-static {p2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/Format;

    iput-object v0, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->oldFormat:Landroidx/media3/common/Format;

    .line 175
    invoke-static {p3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/Format;

    iput-object v0, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->newFormat:Landroidx/media3/common/Format;

    .line 176
    iput p4, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->result:I

    .line 177
    iput p5, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->discardReasons:I

    .line 178
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .line 182
    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    .line 183
    return v0

    .line 185
    :cond_0
    const/4 v1, 0x0

    if-eqz p1, :cond_3

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_1

    goto :goto_1

    .line 188
    :cond_1
    move-object v2, p1

    check-cast v2, Landroidx/media3/exoplayer/DecoderReuseEvaluation;

    .line 189
    .local v2, "other":Landroidx/media3/exoplayer/DecoderReuseEvaluation;
    iget v3, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->result:I

    iget v4, v2, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->result:I

    if-ne v3, v4, :cond_2

    iget v3, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->discardReasons:I

    iget v4, v2, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->discardReasons:I

    if-ne v3, v4, :cond_2

    iget-object v3, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->decoderName:Ljava/lang/String;

    iget-object v4, v2, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->decoderName:Ljava/lang/String;

    .line 191
    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->oldFormat:Landroidx/media3/common/Format;

    iget-object v4, v2, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->oldFormat:Landroidx/media3/common/Format;

    .line 192
    invoke-virtual {v3, v4}, Landroidx/media3/common/Format;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->newFormat:Landroidx/media3/common/Format;

    iget-object v4, v2, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->newFormat:Landroidx/media3/common/Format;

    .line 193
    invoke-virtual {v3, v4}, Landroidx/media3/common/Format;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    goto :goto_0

    :cond_2
    move v0, v1

    .line 189
    :goto_0
    return v0

    .line 186
    .end local v2    # "other":Landroidx/media3/exoplayer/DecoderReuseEvaluation;
    :cond_3
    :goto_1
    return v1
.end method

.method public hashCode()I
    .locals 3

    .line 198
    const/16 v0, 0x11

    .line 199
    .local v0, "hashCode":I
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->result:I

    add-int/2addr v1, v2

    .line 200
    .end local v0    # "hashCode":I
    .local v1, "hashCode":I
    mul-int/lit8 v0, v1, 0x1f

    iget v2, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->discardReasons:I

    add-int/2addr v0, v2

    .line 201
    .end local v1    # "hashCode":I
    .restart local v0    # "hashCode":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->decoderName:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    add-int/2addr v1, v2

    .line 202
    .end local v0    # "hashCode":I
    .restart local v1    # "hashCode":I
    mul-int/lit8 v0, v1, 0x1f

    iget-object v2, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->oldFormat:Landroidx/media3/common/Format;

    invoke-virtual {v2}, Landroidx/media3/common/Format;->hashCode()I

    move-result v2

    add-int/2addr v0, v2

    .line 203
    .end local v1    # "hashCode":I
    .restart local v0    # "hashCode":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Landroidx/media3/exoplayer/DecoderReuseEvaluation;->newFormat:Landroidx/media3/common/Format;

    invoke-virtual {v2}, Landroidx/media3/common/Format;->hashCode()I

    move-result v2

    add-int/2addr v1, v2

    .line 204
    .end local v0    # "hashCode":I
    .restart local v1    # "hashCode":I
    return v1
.end method
