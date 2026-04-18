.class public final Landroidx/media3/exoplayer/ExoPlaybackException;
.super Landroidx/media3/common/PlaybackException;
.source "ExoPlaybackException.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/ExoPlaybackException$Type;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroidx/media3/common/Bundleable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/media3/common/Bundleable$Creator<",
            "Landroidx/media3/exoplayer/ExoPlaybackException;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field private static final FIELD_IS_RECOVERABLE:Ljava/lang/String;

.field private static final FIELD_RENDERER_FORMAT:Ljava/lang/String;

.field private static final FIELD_RENDERER_FORMAT_SUPPORT:Ljava/lang/String;

.field private static final FIELD_RENDERER_INDEX:Ljava/lang/String;

.field private static final FIELD_RENDERER_NAME:Ljava/lang/String;

.field private static final FIELD_TYPE:Ljava/lang/String;

.field public static final TYPE_REMOTE:I = 0x3

.field public static final TYPE_RENDERER:I = 0x1

.field public static final TYPE_SOURCE:I = 0x0

.field public static final TYPE_UNEXPECTED:I = 0x2


# instance fields
.field final isRecoverable:Z

.field public final mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

.field public final rendererFormat:Landroidx/media3/common/Format;

.field public final rendererFormatSupport:I

.field public final rendererIndex:I

.field public final rendererName:Ljava/lang/String;

.field public final type:I


# direct methods
.method public static synthetic $r8$lambda$0EMQpi8Tl4d4KO99NckvC9cFZ2Y(Landroid/os/Bundle;)Landroidx/media3/exoplayer/ExoPlaybackException;
    .locals 1

    new-instance v0, Landroidx/media3/exoplayer/ExoPlaybackException;

    invoke-direct {v0, p0}, Landroidx/media3/exoplayer/ExoPlaybackException;-><init>(Landroid/os/Bundle;)V

    return-object v0
.end method

.method static constructor <clinit>()V
    .locals 1

    .line 413
    new-instance v0, Landroidx/media3/exoplayer/ExoPlaybackException$$ExternalSyntheticLambda0;

    invoke-direct {v0}, Landroidx/media3/exoplayer/ExoPlaybackException$$ExternalSyntheticLambda0;-><init>()V

    sput-object v0, Landroidx/media3/exoplayer/ExoPlaybackException;->CREATOR:Landroidx/media3/common/Bundleable$Creator;

    .line 421
    const/16 v0, 0x3e9

    invoke-static {v0}, Landroidx/media3/common/util/Util;->intToStringMaxRadix(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_TYPE:Ljava/lang/String;

    .line 422
    nop

    .line 423
    const/16 v0, 0x3ea

    invoke-static {v0}, Landroidx/media3/common/util/Util;->intToStringMaxRadix(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_RENDERER_NAME:Ljava/lang/String;

    .line 424
    nop

    .line 425
    const/16 v0, 0x3eb

    invoke-static {v0}, Landroidx/media3/common/util/Util;->intToStringMaxRadix(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_RENDERER_INDEX:Ljava/lang/String;

    .line 426
    nop

    .line 427
    const/16 v0, 0x3ec

    invoke-static {v0}, Landroidx/media3/common/util/Util;->intToStringMaxRadix(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_RENDERER_FORMAT:Ljava/lang/String;

    .line 428
    nop

    .line 429
    const/16 v0, 0x3ed

    invoke-static {v0}, Landroidx/media3/common/util/Util;->intToStringMaxRadix(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_RENDERER_FORMAT_SUPPORT:Ljava/lang/String;

    .line 430
    nop

    .line 431
    const/16 v0, 0x3ee

    invoke-static {v0}, Landroidx/media3/common/util/Util;->intToStringMaxRadix(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_IS_RECOVERABLE:Ljava/lang/String;

    .line 430
    return-void
.end method

.method private constructor <init>(ILjava/lang/Throwable;I)V
    .locals 10
    .param p1, "type"    # I
    .param p2, "cause"    # Ljava/lang/Throwable;
    .param p3, "errorCode"    # I

    .line 215
    const/4 v3, 0x0

    const/4 v5, 0x0

    const/4 v6, -0x1

    const/4 v7, 0x0

    const/4 v8, 0x4

    const/4 v9, 0x0

    move-object v0, p0

    move v1, p1

    move-object v2, p2

    move v4, p3

    invoke-direct/range {v0 .. v9}, Landroidx/media3/exoplayer/ExoPlaybackException;-><init>(ILjava/lang/Throwable;Ljava/lang/String;ILjava/lang/String;ILandroidx/media3/common/Format;IZ)V

    .line 225
    return-void
.end method

.method private constructor <init>(ILjava/lang/Throwable;Ljava/lang/String;ILjava/lang/String;ILandroidx/media3/common/Format;IZ)V
    .locals 14
    .param p1, "type"    # I
    .param p2, "cause"    # Ljava/lang/Throwable;
    .param p3, "customMessage"    # Ljava/lang/String;
    .param p4, "errorCode"    # I
    .param p5, "rendererName"    # Ljava/lang/String;
    .param p6, "rendererIndex"    # I
    .param p7, "rendererFormat"    # Landroidx/media3/common/Format;
    .param p8, "rendererFormatSupport"    # I
    .param p9, "isRecoverable"    # Z

    .line 237
    nop

    .line 238
    move v0, p1

    move-object/from16 v1, p3

    move-object/from16 v2, p5

    move/from16 v3, p6

    move-object/from16 v4, p7

    move/from16 v5, p8

    invoke-static/range {v0 .. v5}, Landroidx/media3/exoplayer/ExoPlaybackException;->deriveMessage(ILjava/lang/String;Ljava/lang/String;ILandroidx/media3/common/Format;I)Ljava/lang/String;

    move-result-object v2

    const/4 v10, 0x0

    .line 253
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v11

    .line 237
    move-object v1, p0

    move-object/from16 v3, p2

    move/from16 v4, p4

    move v5, p1

    move-object/from16 v6, p5

    move/from16 v7, p6

    move-object/from16 v8, p7

    move/from16 v9, p8

    move/from16 v13, p9

    invoke-direct/range {v1 .. v13}, Landroidx/media3/exoplayer/ExoPlaybackException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;IILjava/lang/String;ILandroidx/media3/common/Format;ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;JZ)V

    .line 255
    return-void
.end method

.method private constructor <init>(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "bundle"    # Landroid/os/Bundle;

    .line 258
    invoke-direct {p0, p1}, Landroidx/media3/common/PlaybackException;-><init>(Landroid/os/Bundle;)V

    .line 259
    sget-object v0, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_TYPE:Ljava/lang/String;

    const/4 v1, 0x2

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->type:I

    .line 260
    sget-object v0, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_RENDERER_NAME:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererName:Ljava/lang/String;

    .line 261
    sget-object v0, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_RENDERER_INDEX:Ljava/lang/String;

    const/4 v1, -0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererIndex:I

    .line 262
    sget-object v0, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_RENDERER_FORMAT:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 263
    .local v0, "rendererFormatBundle":Landroid/os/Bundle;
    const/4 v1, 0x0

    if-nez v0, :cond_0

    move-object v2, v1

    goto :goto_0

    :cond_0
    invoke-static {v0}, Landroidx/media3/common/Format;->fromBundle(Landroid/os/Bundle;)Landroidx/media3/common/Format;

    move-result-object v2

    :goto_0
    iput-object v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererFormat:Landroidx/media3/common/Format;

    .line 264
    sget-object v2, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_RENDERER_FORMAT_SUPPORT:Ljava/lang/String;

    .line 265
    const/4 v3, 0x4

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererFormatSupport:I

    .line 266
    sget-object v2, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_IS_RECOVERABLE:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->isRecoverable:Z

    .line 267
    iput-object v1, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 268
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;IILjava/lang/String;ILandroidx/media3/common/Format;ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;JZ)V
    .locals 9
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "cause"    # Ljava/lang/Throwable;
    .param p3, "errorCode"    # I
    .param p4, "type"    # I
    .param p5, "rendererName"    # Ljava/lang/String;
    .param p6, "rendererIndex"    # I
    .param p7, "rendererFormat"    # Landroidx/media3/common/Format;
    .param p8, "rendererFormatSupport"    # I
    .param p9, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p10, "timestampMs"    # J
    .param p12, "isRecoverable"    # Z

    .line 282
    move-object v6, p0

    move v7, p4

    move/from16 v8, p12

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-wide/from16 v4, p10

    invoke-direct/range {v0 .. v5}, Landroidx/media3/common/PlaybackException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;IJ)V

    .line 283
    const/4 v0, 0x0

    const/4 v1, 0x1

    if-eqz v8, :cond_1

    if-ne v7, v1, :cond_0

    goto :goto_0

    :cond_0
    move v2, v0

    goto :goto_1

    :cond_1
    :goto_0
    move v2, v1

    :goto_1
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 284
    if-nez p2, :cond_2

    const/4 v2, 0x3

    if-ne v7, v2, :cond_3

    :cond_2
    move v0, v1

    :cond_3
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 285
    iput v7, v6, Landroidx/media3/exoplayer/ExoPlaybackException;->type:I

    .line 286
    move-object v0, p5

    iput-object v0, v6, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererName:Ljava/lang/String;

    .line 287
    move v1, p6

    iput v1, v6, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererIndex:I

    .line 288
    move-object/from16 v2, p7

    iput-object v2, v6, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererFormat:Landroidx/media3/common/Format;

    .line 289
    move/from16 v3, p8

    iput v3, v6, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererFormatSupport:I

    .line 290
    move-object/from16 v4, p9

    iput-object v4, v6, Landroidx/media3/exoplayer/ExoPlaybackException;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 291
    iput-boolean v8, v6, Landroidx/media3/exoplayer/ExoPlaybackException;->isRecoverable:Z

    .line 292
    return-void
.end method

.method public static createForRemote(Ljava/lang/String;)Landroidx/media3/exoplayer/ExoPlaybackException;
    .locals 11
    .param p0, "message"    # Ljava/lang/String;

    .line 202
    new-instance v10, Landroidx/media3/exoplayer/ExoPlaybackException;

    const/4 v1, 0x3

    const/4 v2, 0x0

    const/16 v4, 0x3e9

    const/4 v5, 0x0

    const/4 v6, -0x1

    const/4 v7, 0x0

    const/4 v8, 0x4

    const/4 v9, 0x0

    move-object v0, v10

    move-object v3, p0

    invoke-direct/range {v0 .. v9}, Landroidx/media3/exoplayer/ExoPlaybackException;-><init>(ILjava/lang/Throwable;Ljava/lang/String;ILjava/lang/String;ILandroidx/media3/common/Format;IZ)V

    return-object v10
.end method

.method public static createForRenderer(Ljava/lang/Throwable;Ljava/lang/String;ILandroidx/media3/common/Format;IZI)Landroidx/media3/exoplayer/ExoPlaybackException;
    .locals 11
    .param p0, "cause"    # Ljava/lang/Throwable;
    .param p1, "rendererName"    # Ljava/lang/String;
    .param p2, "rendererIndex"    # I
    .param p3, "rendererFormat"    # Landroidx/media3/common/Format;
    .param p4, "rendererFormatSupport"    # I
    .param p5, "isRecoverable"    # Z
    .param p6, "errorCode"    # I

    .line 159
    new-instance v10, Landroidx/media3/exoplayer/ExoPlaybackException;

    const/4 v1, 0x1

    const/4 v3, 0x0

    .line 167
    if-nez p3, :cond_0

    const/4 v0, 0x4

    move v8, v0

    goto :goto_0

    :cond_0
    move v8, p4

    :goto_0
    move-object v0, v10

    move-object v2, p0

    move/from16 v4, p6

    move-object v5, p1

    move v6, p2

    move-object v7, p3

    move/from16 v9, p5

    invoke-direct/range {v0 .. v9}, Landroidx/media3/exoplayer/ExoPlaybackException;-><init>(ILjava/lang/Throwable;Ljava/lang/String;ILjava/lang/String;ILandroidx/media3/common/Format;IZ)V

    .line 159
    return-object v10
.end method

.method public static createForSource(Ljava/io/IOException;I)Landroidx/media3/exoplayer/ExoPlaybackException;
    .locals 2
    .param p0, "cause"    # Ljava/io/IOException;
    .param p1, "errorCode"    # I

    .line 131
    new-instance v0, Landroidx/media3/exoplayer/ExoPlaybackException;

    const/4 v1, 0x0

    invoke-direct {v0, v1, p0, p1}, Landroidx/media3/exoplayer/ExoPlaybackException;-><init>(ILjava/lang/Throwable;I)V

    return-object v0
.end method

.method public static createForUnexpected(Ljava/lang/RuntimeException;)Landroidx/media3/exoplayer/ExoPlaybackException;
    .locals 1
    .param p0, "cause"    # Ljava/lang/RuntimeException;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 178
    const/16 v0, 0x3e8

    invoke-static {p0, v0}, Landroidx/media3/exoplayer/ExoPlaybackException;->createForUnexpected(Ljava/lang/RuntimeException;I)Landroidx/media3/exoplayer/ExoPlaybackException;

    move-result-object v0

    return-object v0
.end method

.method public static createForUnexpected(Ljava/lang/RuntimeException;I)Landroidx/media3/exoplayer/ExoPlaybackException;
    .locals 2
    .param p0, "cause"    # Ljava/lang/RuntimeException;
    .param p1, "errorCode"    # I

    .line 191
    new-instance v0, Landroidx/media3/exoplayer/ExoPlaybackException;

    const/4 v1, 0x2

    invoke-direct {v0, v1, p0, p1}, Landroidx/media3/exoplayer/ExoPlaybackException;-><init>(ILjava/lang/Throwable;I)V

    return-object v0
.end method

.method private static deriveMessage(ILjava/lang/String;Ljava/lang/String;ILandroidx/media3/common/Format;I)Ljava/lang/String;
    .locals 3
    .param p0, "type"    # I
    .param p1, "customMessage"    # Ljava/lang/String;
    .param p2, "rendererName"    # Ljava/lang/String;
    .param p3, "rendererIndex"    # I
    .param p4, "rendererFormat"    # Landroidx/media3/common/Format;
    .param p5, "rendererFormatSupport"    # I

    .line 374
    packed-switch p0, :pswitch_data_0

    .line 394
    :pswitch_0
    const-string v0, "Unexpected runtime error"

    .local v0, "message":Ljava/lang/String;
    goto :goto_0

    .line 390
    .end local v0    # "message":Ljava/lang/String;
    :pswitch_1
    const-string v0, "Remote error"

    .line 391
    .restart local v0    # "message":Ljava/lang/String;
    goto :goto_0

    .line 379
    .end local v0    # "message":Ljava/lang/String;
    :pswitch_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " error, index="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", format="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", format_supported="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 387
    invoke-static {p5}, Landroidx/media3/common/util/Util;->getFormatSupportString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 388
    .restart local v0    # "message":Ljava/lang/String;
    goto :goto_0

    .line 376
    .end local v0    # "message":Ljava/lang/String;
    :pswitch_3
    const-string v0, "Source error"

    .line 377
    .restart local v0    # "message":Ljava/lang/String;
    nop

    .line 397
    :goto_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 398
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 400
    :cond_0
    return-object v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static fromBundle(Landroid/os/Bundle;)Landroidx/media3/exoplayer/ExoPlaybackException;
    .locals 1
    .param p0, "bundle"    # Landroid/os/Bundle;

    .line 418
    new-instance v0, Landroidx/media3/exoplayer/ExoPlaybackException;

    invoke-direct {v0, p0}, Landroidx/media3/exoplayer/ExoPlaybackException;-><init>(Landroid/os/Bundle;)V

    return-object v0
.end method


# virtual methods
.method copyWithMediaPeriodId(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/ExoPlaybackException;
    .locals 14
    .param p1, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 352
    new-instance v13, Landroidx/media3/exoplayer/ExoPlaybackException;

    .line 353
    invoke-virtual {p0}, Landroidx/media3/exoplayer/ExoPlaybackException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Ljava/lang/String;

    .line 354
    invoke-virtual {p0}, Landroidx/media3/exoplayer/ExoPlaybackException;->getCause()Ljava/lang/Throwable;

    move-result-object v2

    iget v3, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->errorCode:I

    iget v4, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->type:I

    iget-object v5, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererName:Ljava/lang/String;

    iget v6, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererIndex:I

    iget-object v7, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererFormat:Landroidx/media3/common/Format;

    iget v8, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererFormatSupport:I

    iget-wide v10, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->timestampMs:J

    iget-boolean v12, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->isRecoverable:Z

    move-object v0, v13

    move-object v9, p1

    invoke-direct/range {v0 .. v12}, Landroidx/media3/exoplayer/ExoPlaybackException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;IILjava/lang/String;ILandroidx/media3/common/Format;ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;JZ)V

    .line 352
    return-object v13
.end method

.method public errorInfoEquals(Landroidx/media3/common/PlaybackException;)Z
    .locals 4
    .param p1, "that"    # Landroidx/media3/common/PlaybackException;

    .line 329
    invoke-super {p0, p1}, Landroidx/media3/common/PlaybackException;->errorInfoEquals(Landroidx/media3/common/PlaybackException;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 330
    return v1

    .line 334
    :cond_0
    invoke-static {p1}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/ExoPlaybackException;

    .line 335
    .local v0, "other":Landroidx/media3/exoplayer/ExoPlaybackException;
    iget v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->type:I

    iget v3, v0, Landroidx/media3/exoplayer/ExoPlaybackException;->type:I

    if-ne v2, v3, :cond_1

    iget-object v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererName:Ljava/lang/String;

    iget-object v3, v0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererName:Ljava/lang/String;

    .line 336
    invoke-static {v2, v3}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    iget v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererIndex:I

    iget v3, v0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererIndex:I

    if-ne v2, v3, :cond_1

    iget-object v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererFormat:Landroidx/media3/common/Format;

    iget-object v3, v0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererFormat:Landroidx/media3/common/Format;

    .line 338
    invoke-static {v2, v3}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    iget v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererFormatSupport:I

    iget v3, v0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererFormatSupport:I

    if-ne v2, v3, :cond_1

    iget-object v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-object v3, v0, Landroidx/media3/exoplayer/ExoPlaybackException;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 340
    invoke-static {v2, v3}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    iget-boolean v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->isRecoverable:Z

    iget-boolean v3, v0, Landroidx/media3/exoplayer/ExoPlaybackException;->isRecoverable:Z

    if-ne v2, v3, :cond_1

    const/4 v1, 0x1

    goto :goto_0

    :cond_1
    nop

    .line 335
    :goto_0
    return v1
.end method

.method public getRendererException()Ljava/lang/Exception;
    .locals 2

    .line 312
    iget v0, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->type:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 313
    invoke-virtual {p0}, Landroidx/media3/exoplayer/ExoPlaybackException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Exception;

    return-object v0
.end method

.method public getSourceException()Ljava/io/IOException;
    .locals 1

    .line 301
    iget v0, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->type:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 302
    invoke-virtual {p0}, Landroidx/media3/exoplayer/ExoPlaybackException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/io/IOException;

    return-object v0
.end method

.method public getUnexpectedException()Ljava/lang/RuntimeException;
    .locals 2

    .line 323
    iget v0, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->type:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 324
    invoke-virtual {p0}, Landroidx/media3/exoplayer/ExoPlaybackException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/RuntimeException;

    return-object v0
.end method

.method public toBundle()Landroid/os/Bundle;
    .locals 3

    .line 442
    invoke-super {p0}, Landroidx/media3/common/PlaybackException;->toBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 443
    .local v0, "bundle":Landroid/os/Bundle;
    sget-object v1, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_TYPE:Ljava/lang/String;

    iget v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->type:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 444
    sget-object v1, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_RENDERER_NAME:Ljava/lang/String;

    iget-object v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererName:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 445
    sget-object v1, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_RENDERER_INDEX:Ljava/lang/String;

    iget v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererIndex:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 446
    iget-object v1, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererFormat:Landroidx/media3/common/Format;

    if-eqz v1, :cond_0

    .line 447
    sget-object v2, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_RENDERER_FORMAT:Ljava/lang/String;

    invoke-virtual {v1}, Landroidx/media3/common/Format;->toBundle()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 449
    :cond_0
    sget-object v1, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_RENDERER_FORMAT_SUPPORT:Ljava/lang/String;

    iget v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->rendererFormatSupport:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 450
    sget-object v1, Landroidx/media3/exoplayer/ExoPlaybackException;->FIELD_IS_RECOVERABLE:Ljava/lang/String;

    iget-boolean v2, p0, Landroidx/media3/exoplayer/ExoPlaybackException;->isRecoverable:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 451
    return-object v0
.end method
