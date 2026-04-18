.class public Landroidx/media3/exoplayer/DefaultRenderersFactory;
.super Ljava/lang/Object;
.source "DefaultRenderersFactory.java"

# interfaces
.implements Landroidx/media3/exoplayer/RenderersFactory;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/DefaultRenderersFactory$ExtensionRendererMode;
    }
.end annotation


# static fields
.field public static final DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS:J = 0x1388L

.field public static final EXTENSION_RENDERER_MODE_OFF:I = 0x0

.field public static final EXTENSION_RENDERER_MODE_ON:I = 0x1

.field public static final EXTENSION_RENDERER_MODE_PREFER:I = 0x2

.field public static final MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:I = 0x32

.field private static final TAG:Ljava/lang/String; = "DefaultRenderersFactory"


# instance fields
.field private allowedVideoJoiningTimeMs:J

.field private final codecAdapterFactory:Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;

.field private final context:Landroid/content/Context;

.field private enableAudioTrackPlaybackParams:Z

.field private enableDecoderFallback:Z

.field private enableFloatOutput:Z

.field private extensionRendererMode:I

.field private mediaCodecSelector:Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .line 113
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 114
    iput-object p1, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->context:Landroid/content/Context;

    .line 115
    new-instance v0, Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;

    invoke-direct {v0, p1}, Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->codecAdapterFactory:Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;

    .line 116
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->extensionRendererMode:I

    .line 117
    const-wide/16 v0, 0x1388

    iput-wide v0, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->allowedVideoJoiningTimeMs:J

    .line 118
    sget-object v0, Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;->DEFAULT:Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;

    iput-object v0, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->mediaCodecSelector:Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;

    .line 119
    return-void
.end method


# virtual methods
.method protected buildAudioRenderers(Landroid/content/Context;ILandroidx/media3/exoplayer/mediacodec/MediaCodecSelector;ZLandroidx/media3/exoplayer/audio/AudioSink;Landroid/os/Handler;Landroidx/media3/exoplayer/audio/AudioRendererEventListener;Ljava/util/ArrayList;)V
    .locals 16
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "extensionRendererMode"    # I
    .param p3, "mediaCodecSelector"    # Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;
    .param p4, "enableDecoderFallback"    # Z
    .param p5, "audioSink"    # Landroidx/media3/exoplayer/audio/AudioSink;
    .param p6, "eventHandler"    # Landroid/os/Handler;
    .param p7, "eventListener"    # Landroidx/media3/exoplayer/audio/AudioRendererEventListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;",
            "Z",
            "Landroidx/media3/exoplayer/audio/AudioSink;",
            "Landroid/os/Handler;",
            "Landroidx/media3/exoplayer/audio/AudioRendererEventListener;",
            "Ljava/util/ArrayList<",
            "Landroidx/media3/exoplayer/Renderer;",
            ">;)V"
        }
    .end annotation

    .line 461
    .local p8, "out":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/Renderer;>;"
    move/from16 v1, p2

    move-object/from16 v10, p5

    move-object/from16 v11, p6

    move-object/from16 v12, p7

    move-object/from16 v13, p8

    const-string v14, "DefaultRenderersFactory"

    new-instance v0, Landroidx/media3/exoplayer/audio/MediaCodecAudioRenderer;

    .line 464
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/exoplayer/DefaultRenderersFactory;->getCodecAdapterFactory()Landroidx/media3/exoplayer/mediacodec/MediaCodecAdapter$Factory;

    move-result-object v4

    move-object v2, v0

    move-object/from16 v3, p1

    move-object/from16 v5, p3

    move/from16 v6, p4

    move-object/from16 v7, p6

    move-object/from16 v8, p7

    move-object/from16 v9, p5

    invoke-direct/range {v2 .. v9}, Landroidx/media3/exoplayer/audio/MediaCodecAudioRenderer;-><init>(Landroid/content/Context;Landroidx/media3/exoplayer/mediacodec/MediaCodecAdapter$Factory;Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;ZLandroid/os/Handler;Landroidx/media3/exoplayer/audio/AudioRendererEventListener;Landroidx/media3/exoplayer/audio/AudioSink;)V

    .line 470
    .local v2, "audioRenderer":Landroidx/media3/exoplayer/audio/MediaCodecAudioRenderer;
    invoke-virtual {v13, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 472
    if-nez v1, :cond_0

    .line 473
    return-void

    .line 475
    :cond_0
    invoke-virtual/range {p8 .. p8}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 476
    .local v0, "extensionRendererIndex":I
    const/4 v3, 0x2

    if-ne v1, v3, :cond_1

    .line 477
    add-int/lit8 v0, v0, -0x1

    move v4, v0

    goto :goto_0

    .line 476
    :cond_1
    move v4, v0

    .line 482
    .end local v0    # "extensionRendererIndex":I
    .local v4, "extensionRendererIndex":I
    :goto_0
    const/4 v5, 0x0

    const/4 v6, 0x1

    :try_start_0
    const-string v0, "androidx.media3.decoder.midi.MidiRenderer"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 483
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-array v7, v6, [Ljava/lang/Class;

    const-class v8, Landroid/content/Context;

    aput-object v8, v7, v5

    invoke-virtual {v0, v7}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v7

    .line 484
    .local v7, "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    filled-new-array/range {p1 .. p1}, [Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroidx/media3/exoplayer/Renderer;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 485
    .local v8, "renderer":Landroidx/media3/exoplayer/Renderer;
    add-int/lit8 v9, v4, 0x1

    .end local v4    # "extensionRendererIndex":I
    .local v9, "extensionRendererIndex":I
    :try_start_1
    invoke-virtual {v13, v4, v8}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 486
    const-string v4, "Loaded MidiRenderer."

    invoke-static {v14, v4}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 492
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v7    # "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    .end local v8    # "renderer":Landroidx/media3/exoplayer/Renderer;
    goto :goto_3

    .line 489
    :catch_0
    move-exception v0

    move v4, v9

    goto :goto_1

    .line 487
    :catch_1
    move-exception v0

    move v4, v9

    goto :goto_2

    .line 489
    .end local v9    # "extensionRendererIndex":I
    .restart local v4    # "extensionRendererIndex":I
    :catch_2
    move-exception v0

    .line 491
    .local v0, "e":Ljava/lang/Exception;
    :goto_1
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v5, "Error instantiating MIDI extension"

    invoke-direct {v3, v5, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 487
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_3
    move-exception v0

    .line 492
    :goto_2
    move v9, v4

    .line 496
    .end local v4    # "extensionRendererIndex":I
    .restart local v9    # "extensionRendererIndex":I
    :goto_3
    const/4 v4, 0x3

    :try_start_2
    const-string v0, "androidx.media3.decoder.opus.LibopusAudioRenderer"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 497
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-array v7, v4, [Ljava/lang/Class;

    const-class v8, Landroid/os/Handler;

    aput-object v8, v7, v5

    const-class v8, Landroidx/media3/exoplayer/audio/AudioRendererEventListener;

    aput-object v8, v7, v6

    const-class v8, Landroidx/media3/exoplayer/audio/AudioSink;

    aput-object v8, v7, v3

    .line 498
    invoke-virtual {v0, v7}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v7

    .line 502
    .restart local v7    # "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    filled-new-array {v11, v12, v10}, [Ljava/lang/Object;

    move-result-object v8

    .line 503
    invoke-virtual {v7, v8}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroidx/media3/exoplayer/Renderer;
    :try_end_2
    .catch Ljava/lang/ClassNotFoundException; {:try_start_2 .. :try_end_2} :catch_7
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_6

    .line 504
    .restart local v8    # "renderer":Landroidx/media3/exoplayer/Renderer;
    add-int/lit8 v15, v9, 0x1

    .end local v9    # "extensionRendererIndex":I
    .local v15, "extensionRendererIndex":I
    :try_start_3
    invoke-virtual {v13, v9, v8}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 505
    const-string v9, "Loaded LibopusAudioRenderer."

    invoke-static {v14, v9}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/ClassNotFoundException; {:try_start_3 .. :try_end_3} :catch_5
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_4

    .line 511
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v7    # "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    .end local v8    # "renderer":Landroidx/media3/exoplayer/Renderer;
    goto :goto_6

    .line 508
    :catch_4
    move-exception v0

    move v9, v15

    goto :goto_4

    .line 506
    :catch_5
    move-exception v0

    move v9, v15

    goto :goto_5

    .line 508
    .end local v15    # "extensionRendererIndex":I
    .restart local v9    # "extensionRendererIndex":I
    :catch_6
    move-exception v0

    .line 510
    .local v0, "e":Ljava/lang/Exception;
    :goto_4
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Error instantiating Opus extension"

    invoke-direct {v3, v4, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 506
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_7
    move-exception v0

    .line 511
    :goto_5
    move v15, v9

    .line 515
    .end local v9    # "extensionRendererIndex":I
    .restart local v15    # "extensionRendererIndex":I
    :goto_6
    :try_start_4
    const-string v0, "androidx.media3.decoder.flac.LibflacAudioRenderer"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 516
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-array v7, v4, [Ljava/lang/Class;

    const-class v8, Landroid/os/Handler;

    aput-object v8, v7, v5

    const-class v8, Landroidx/media3/exoplayer/audio/AudioRendererEventListener;

    aput-object v8, v7, v6

    const-class v8, Landroidx/media3/exoplayer/audio/AudioSink;

    aput-object v8, v7, v3

    .line 517
    invoke-virtual {v0, v7}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v7

    .line 521
    .restart local v7    # "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    filled-new-array {v11, v12, v10}, [Ljava/lang/Object;

    move-result-object v8

    .line 522
    invoke-virtual {v7, v8}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroidx/media3/exoplayer/Renderer;
    :try_end_4
    .catch Ljava/lang/ClassNotFoundException; {:try_start_4 .. :try_end_4} :catch_b
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_a

    .line 523
    .restart local v8    # "renderer":Landroidx/media3/exoplayer/Renderer;
    add-int/lit8 v9, v15, 0x1

    .end local v15    # "extensionRendererIndex":I
    .restart local v9    # "extensionRendererIndex":I
    :try_start_5
    invoke-virtual {v13, v15, v8}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 524
    const-string v15, "Loaded LibflacAudioRenderer."

    invoke-static {v14, v15}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/ClassNotFoundException; {:try_start_5 .. :try_end_5} :catch_9
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_8

    .line 530
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v7    # "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    .end local v8    # "renderer":Landroidx/media3/exoplayer/Renderer;
    goto :goto_9

    .line 527
    :catch_8
    move-exception v0

    move v15, v9

    goto :goto_7

    .line 525
    :catch_9
    move-exception v0

    move v15, v9

    goto :goto_8

    .line 527
    .end local v9    # "extensionRendererIndex":I
    .restart local v15    # "extensionRendererIndex":I
    :catch_a
    move-exception v0

    .line 529
    .local v0, "e":Ljava/lang/Exception;
    :goto_7
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Error instantiating FLAC extension"

    invoke-direct {v3, v4, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 525
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_b
    move-exception v0

    .line 530
    :goto_8
    move v9, v15

    .line 534
    .end local v15    # "extensionRendererIndex":I
    .restart local v9    # "extensionRendererIndex":I
    :goto_9
    :try_start_6
    const-string v0, "androidx.media3.decoder.ffmpeg.FfmpegAudioRenderer"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 535
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-array v4, v4, [Ljava/lang/Class;

    const-class v7, Landroid/os/Handler;

    aput-object v7, v4, v5

    const-class v5, Landroidx/media3/exoplayer/audio/AudioRendererEventListener;

    aput-object v5, v4, v6

    const-class v5, Landroidx/media3/exoplayer/audio/AudioSink;

    aput-object v5, v4, v3

    .line 536
    invoke-virtual {v0, v4}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v3

    .line 540
    .local v3, "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    filled-new-array {v11, v12, v10}, [Ljava/lang/Object;

    move-result-object v4

    .line 541
    invoke-virtual {v3, v4}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/exoplayer/Renderer;
    :try_end_6
    .catch Ljava/lang/ClassNotFoundException; {:try_start_6 .. :try_end_6} :catch_f
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_e

    .line 542
    .local v4, "renderer":Landroidx/media3/exoplayer/Renderer;
    add-int/lit8 v5, v9, 0x1

    .end local v9    # "extensionRendererIndex":I
    .local v5, "extensionRendererIndex":I
    :try_start_7
    invoke-virtual {v13, v9, v4}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 543
    const-string v6, "Loaded FfmpegAudioRenderer."

    invoke-static {v14, v6}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_7
    .catch Ljava/lang/ClassNotFoundException; {:try_start_7 .. :try_end_7} :catch_d
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_c

    .line 549
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v3    # "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    .end local v4    # "renderer":Landroidx/media3/exoplayer/Renderer;
    goto :goto_c

    .line 546
    :catch_c
    move-exception v0

    move v9, v5

    goto :goto_a

    .line 544
    :catch_d
    move-exception v0

    move v9, v5

    goto :goto_b

    .line 546
    .end local v5    # "extensionRendererIndex":I
    .restart local v9    # "extensionRendererIndex":I
    :catch_e
    move-exception v0

    .line 548
    .local v0, "e":Ljava/lang/Exception;
    :goto_a
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Error instantiating FFmpeg extension"

    invoke-direct {v3, v4, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 544
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_f
    move-exception v0

    .line 549
    :goto_b
    move v5, v9

    .line 550
    .end local v9    # "extensionRendererIndex":I
    .restart local v5    # "extensionRendererIndex":I
    :goto_c
    return-void
.end method

.method protected buildAudioSink(Landroid/content/Context;ZZ)Landroidx/media3/exoplayer/audio/AudioSink;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "enableFloatOutput"    # Z
    .param p3, "enableAudioTrackPlaybackParams"    # Z

    .line 642
    new-instance v0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$Builder;

    invoke-direct {v0, p1}, Landroidx/media3/exoplayer/audio/DefaultAudioSink$Builder;-><init>(Landroid/content/Context;)V

    .line 643
    invoke-virtual {v0, p2}, Landroidx/media3/exoplayer/audio/DefaultAudioSink$Builder;->setEnableFloatOutput(Z)Landroidx/media3/exoplayer/audio/DefaultAudioSink$Builder;

    move-result-object v0

    .line 644
    invoke-virtual {v0, p3}, Landroidx/media3/exoplayer/audio/DefaultAudioSink$Builder;->setEnableAudioTrackPlaybackParams(Z)Landroidx/media3/exoplayer/audio/DefaultAudioSink$Builder;

    move-result-object v0

    .line 645
    invoke-virtual {v0}, Landroidx/media3/exoplayer/audio/DefaultAudioSink$Builder;->build()Landroidx/media3/exoplayer/audio/DefaultAudioSink;

    move-result-object v0

    .line 642
    return-object v0
.end method

.method protected buildCameraMotionRenderers(Landroid/content/Context;ILjava/util/ArrayList;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "extensionRendererMode"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/util/ArrayList<",
            "Landroidx/media3/exoplayer/Renderer;",
            ">;)V"
        }
    .end annotation

    .line 597
    .local p3, "out":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/Renderer;>;"
    new-instance v0, Landroidx/media3/exoplayer/video/spherical/CameraMotionRenderer;

    invoke-direct {v0}, Landroidx/media3/exoplayer/video/spherical/CameraMotionRenderer;-><init>()V

    invoke-virtual {p3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 598
    return-void
.end method

.method protected buildImageRenderers(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroidx/media3/exoplayer/Renderer;",
            ">;)V"
        }
    .end annotation

    .line 609
    .local p1, "out":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/Renderer;>;"
    new-instance v0, Landroidx/media3/exoplayer/image/ImageRenderer;

    sget-object v1, Landroidx/media3/exoplayer/image/ImageDecoder$Factory;->DEFAULT:Landroidx/media3/exoplayer/image/ImageDecoder$Factory;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroidx/media3/exoplayer/image/ImageRenderer;-><init>(Landroidx/media3/exoplayer/image/ImageDecoder$Factory;Landroidx/media3/exoplayer/image/ImageOutput;)V

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 610
    return-void
.end method

.method protected buildMetadataRenderers(Landroid/content/Context;Landroidx/media3/exoplayer/metadata/MetadataOutput;Landroid/os/Looper;ILjava/util/ArrayList;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "output"    # Landroidx/media3/exoplayer/metadata/MetadataOutput;
    .param p3, "outputLooper"    # Landroid/os/Looper;
    .param p4, "extensionRendererMode"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroidx/media3/exoplayer/metadata/MetadataOutput;",
            "Landroid/os/Looper;",
            "I",
            "Ljava/util/ArrayList<",
            "Landroidx/media3/exoplayer/Renderer;",
            ">;)V"
        }
    .end annotation

    .line 585
    .local p5, "out":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/Renderer;>;"
    new-instance v0, Landroidx/media3/exoplayer/metadata/MetadataRenderer;

    invoke-direct {v0, p2, p3}, Landroidx/media3/exoplayer/metadata/MetadataRenderer;-><init>(Landroidx/media3/exoplayer/metadata/MetadataOutput;Landroid/os/Looper;)V

    invoke-virtual {p5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 586
    return-void
.end method

.method protected buildMiscellaneousRenderers(Landroid/content/Context;Landroid/os/Handler;ILjava/util/ArrayList;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "eventHandler"    # Landroid/os/Handler;
    .param p3, "extensionRendererMode"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/os/Handler;",
            "I",
            "Ljava/util/ArrayList<",
            "Landroidx/media3/exoplayer/Renderer;",
            ">;)V"
        }
    .end annotation

    .line 626
    .local p4, "out":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/Renderer;>;"
    return-void
.end method

.method protected buildTextRenderers(Landroid/content/Context;Landroidx/media3/exoplayer/text/TextOutput;Landroid/os/Looper;ILjava/util/ArrayList;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "output"    # Landroidx/media3/exoplayer/text/TextOutput;
    .param p3, "outputLooper"    # Landroid/os/Looper;
    .param p4, "extensionRendererMode"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroidx/media3/exoplayer/text/TextOutput;",
            "Landroid/os/Looper;",
            "I",
            "Ljava/util/ArrayList<",
            "Landroidx/media3/exoplayer/Renderer;",
            ">;)V"
        }
    .end annotation

    .line 567
    .local p5, "out":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/Renderer;>;"
    new-instance v0, Landroidx/media3/exoplayer/text/TextRenderer;

    invoke-direct {v0, p2, p3}, Landroidx/media3/exoplayer/text/TextRenderer;-><init>(Landroidx/media3/exoplayer/text/TextOutput;Landroid/os/Looper;)V

    invoke-virtual {p5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 568
    return-void
.end method

.method protected buildVideoRenderers(Landroid/content/Context;ILandroidx/media3/exoplayer/mediacodec/MediaCodecSelector;ZLandroid/os/Handler;Landroidx/media3/exoplayer/video/VideoRendererEventListener;JLjava/util/ArrayList;)V
    .locals 15
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "extensionRendererMode"    # I
    .param p3, "mediaCodecSelector"    # Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;
    .param p4, "enableDecoderFallback"    # Z
    .param p5, "eventHandler"    # Landroid/os/Handler;
    .param p6, "eventListener"    # Landroidx/media3/exoplayer/video/VideoRendererEventListener;
    .param p7, "allowedVideoJoiningTimeMs"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;",
            "Z",
            "Landroid/os/Handler;",
            "Landroidx/media3/exoplayer/video/VideoRendererEventListener;",
            "J",
            "Ljava/util/ArrayList<",
            "Landroidx/media3/exoplayer/Renderer;",
            ">;)V"
        }
    .end annotation

    .line 341
    .local p9, "out":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/Renderer;>;"
    move/from16 v1, p2

    move-object/from16 v12, p9

    const-string v13, "DefaultRenderersFactory"

    new-instance v0, Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;

    .line 344
    invoke-virtual {p0}, Landroidx/media3/exoplayer/DefaultRenderersFactory;->getCodecAdapterFactory()Landroidx/media3/exoplayer/mediacodec/MediaCodecAdapter$Factory;

    move-result-object v4

    const/16 v11, 0x32

    move-object v2, v0

    move-object/from16 v3, p1

    move-object/from16 v5, p3

    move-wide/from16 v6, p7

    move/from16 v8, p4

    move-object/from16 v9, p5

    move-object/from16 v10, p6

    invoke-direct/range {v2 .. v11}, Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;-><init>(Landroid/content/Context;Landroidx/media3/exoplayer/mediacodec/MediaCodecAdapter$Factory;Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;JZLandroid/os/Handler;Landroidx/media3/exoplayer/video/VideoRendererEventListener;I)V

    .line 351
    .local v2, "videoRenderer":Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;
    invoke-virtual {v12, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 353
    if-nez v1, :cond_0

    .line 354
    return-void

    .line 356
    :cond_0
    invoke-virtual/range {p9 .. p9}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 357
    .local v0, "extensionRendererIndex":I
    const/4 v3, 0x2

    if-ne v1, v3, :cond_1

    .line 358
    add-int/lit8 v0, v0, -0x1

    move v4, v0

    goto :goto_0

    .line 357
    :cond_1
    move v4, v0

    .line 363
    .end local v0    # "extensionRendererIndex":I
    .local v4, "extensionRendererIndex":I
    :goto_0
    const/16 v5, 0x32

    const/4 v6, 0x3

    const/4 v7, 0x0

    const/4 v8, 0x4

    const/4 v9, 0x1

    :try_start_0
    const-string v0, "androidx.media3.decoder.vp9.LibvpxVideoRenderer"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 364
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-array v10, v8, [Ljava/lang/Class;

    sget-object v11, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    aput-object v11, v10, v7

    const-class v11, Landroid/os/Handler;

    aput-object v11, v10, v9

    const-class v11, Landroidx/media3/exoplayer/video/VideoRendererEventListener;

    aput-object v11, v10, v3

    sget-object v11, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v11, v10, v6

    .line 365
    invoke-virtual {v0, v10}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v10

    .line 370
    .local v10, "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    new-array v11, v8, [Ljava/lang/Object;

    .line 373
    invoke-static/range {p7 .. p8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v14

    aput-object v14, v11, v7

    aput-object p5, v11, v9

    aput-object p6, v11, v3

    .line 376
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v14

    aput-object v14, v11, v6

    .line 372
    invoke-virtual {v10, v11}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroidx/media3/exoplayer/Renderer;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 377
    .local v11, "renderer":Landroidx/media3/exoplayer/Renderer;
    add-int/lit8 v14, v4, 0x1

    .end local v4    # "extensionRendererIndex":I
    .local v14, "extensionRendererIndex":I
    :try_start_1
    invoke-virtual {v12, v4, v11}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 378
    const-string v4, "Loaded LibvpxVideoRenderer."

    invoke-static {v13, v4}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 384
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v10    # "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    .end local v11    # "renderer":Landroidx/media3/exoplayer/Renderer;
    goto :goto_3

    .line 381
    :catch_0
    move-exception v0

    move v4, v14

    goto :goto_1

    .line 379
    :catch_1
    move-exception v0

    move v4, v14

    goto :goto_2

    .line 381
    .end local v14    # "extensionRendererIndex":I
    .restart local v4    # "extensionRendererIndex":I
    :catch_2
    move-exception v0

    .line 383
    .local v0, "e":Ljava/lang/Exception;
    :goto_1
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v5, "Error instantiating VP9 extension"

    invoke-direct {v3, v5, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 379
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_3
    move-exception v0

    .line 384
    :goto_2
    move v14, v4

    .line 388
    .end local v4    # "extensionRendererIndex":I
    .restart local v14    # "extensionRendererIndex":I
    :goto_3
    :try_start_2
    const-string v0, "androidx.media3.decoder.av1.Libgav1VideoRenderer"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 389
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-array v4, v8, [Ljava/lang/Class;

    sget-object v10, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    aput-object v10, v4, v7

    const-class v10, Landroid/os/Handler;

    aput-object v10, v4, v9

    const-class v10, Landroidx/media3/exoplayer/video/VideoRendererEventListener;

    aput-object v10, v4, v3

    sget-object v10, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v10, v4, v6

    .line 390
    invoke-virtual {v0, v4}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v4

    .line 395
    .local v4, "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    new-array v10, v8, [Ljava/lang/Object;

    .line 398
    invoke-static/range {p7 .. p8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    aput-object v11, v10, v7

    aput-object p5, v10, v9

    aput-object p6, v10, v3

    .line 401
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v10, v6

    .line 397
    invoke-virtual {v4, v10}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroidx/media3/exoplayer/Renderer;
    :try_end_2
    .catch Ljava/lang/ClassNotFoundException; {:try_start_2 .. :try_end_2} :catch_7
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_6

    .line 402
    .local v10, "renderer":Landroidx/media3/exoplayer/Renderer;
    add-int/lit8 v11, v14, 0x1

    .end local v14    # "extensionRendererIndex":I
    .local v11, "extensionRendererIndex":I
    :try_start_3
    invoke-virtual {v12, v14, v10}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 403
    const-string v14, "Loaded Libgav1VideoRenderer."

    invoke-static {v13, v14}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/ClassNotFoundException; {:try_start_3 .. :try_end_3} :catch_5
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_4

    .line 409
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v4    # "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    .end local v10    # "renderer":Landroidx/media3/exoplayer/Renderer;
    goto :goto_6

    .line 406
    :catch_4
    move-exception v0

    move v14, v11

    goto :goto_4

    .line 404
    :catch_5
    move-exception v0

    move v14, v11

    goto :goto_5

    .line 406
    .end local v11    # "extensionRendererIndex":I
    .restart local v14    # "extensionRendererIndex":I
    :catch_6
    move-exception v0

    .line 408
    .local v0, "e":Ljava/lang/Exception;
    :goto_4
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Error instantiating AV1 extension"

    invoke-direct {v3, v4, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 404
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_7
    move-exception v0

    .line 409
    :goto_5
    move v11, v14

    .line 413
    .end local v14    # "extensionRendererIndex":I
    .restart local v11    # "extensionRendererIndex":I
    :goto_6
    :try_start_4
    const-string v0, "androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer"

    .line 414
    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 415
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-array v4, v8, [Ljava/lang/Class;

    sget-object v10, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    aput-object v10, v4, v7

    const-class v10, Landroid/os/Handler;

    aput-object v10, v4, v9

    const-class v10, Landroidx/media3/exoplayer/video/VideoRendererEventListener;

    aput-object v10, v4, v3

    sget-object v10, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v10, v4, v6

    .line 416
    invoke-virtual {v0, v4}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v4

    .line 421
    .restart local v4    # "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    new-array v8, v8, [Ljava/lang/Object;

    .line 424
    invoke-static/range {p7 .. p8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    aput-object v10, v8, v7

    aput-object p5, v8, v9

    aput-object p6, v8, v3

    .line 427
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v8, v6

    .line 423
    invoke-virtual {v4, v8}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/exoplayer/Renderer;
    :try_end_4
    .catch Ljava/lang/ClassNotFoundException; {:try_start_4 .. :try_end_4} :catch_b
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_a

    .line 428
    .local v3, "renderer":Landroidx/media3/exoplayer/Renderer;
    add-int/lit8 v5, v11, 0x1

    .end local v11    # "extensionRendererIndex":I
    .local v5, "extensionRendererIndex":I
    :try_start_5
    invoke-virtual {v12, v11, v3}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 429
    const-string v6, "Loaded FfmpegVideoRenderer."

    invoke-static {v13, v6}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/ClassNotFoundException; {:try_start_5 .. :try_end_5} :catch_9
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_8

    .line 435
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v3    # "renderer":Landroidx/media3/exoplayer/Renderer;
    .end local v4    # "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    goto :goto_9

    .line 432
    :catch_8
    move-exception v0

    move v11, v5

    goto :goto_7

    .line 430
    :catch_9
    move-exception v0

    move v11, v5

    goto :goto_8

    .line 432
    .end local v5    # "extensionRendererIndex":I
    .restart local v11    # "extensionRendererIndex":I
    :catch_a
    move-exception v0

    .line 434
    .local v0, "e":Ljava/lang/Exception;
    :goto_7
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Error instantiating FFmpeg extension"

    invoke-direct {v3, v4, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 430
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_b
    move-exception v0

    .line 435
    :goto_8
    move v5, v11

    .line 436
    .end local v11    # "extensionRendererIndex":I
    .restart local v5    # "extensionRendererIndex":I
    :goto_9
    return-void
.end method

.method public createRenderers(Landroid/os/Handler;Landroidx/media3/exoplayer/video/VideoRendererEventListener;Landroidx/media3/exoplayer/audio/AudioRendererEventListener;Landroidx/media3/exoplayer/text/TextOutput;Landroidx/media3/exoplayer/metadata/MetadataOutput;)[Landroidx/media3/exoplayer/Renderer;
    .locals 12
    .param p1, "eventHandler"    # Landroid/os/Handler;
    .param p2, "videoRendererEventListener"    # Landroidx/media3/exoplayer/video/VideoRendererEventListener;
    .param p3, "audioRendererEventListener"    # Landroidx/media3/exoplayer/audio/AudioRendererEventListener;
    .param p4, "textRendererOutput"    # Landroidx/media3/exoplayer/text/TextOutput;
    .param p5, "metadataRendererOutput"    # Landroidx/media3/exoplayer/metadata/MetadataOutput;

    .line 275
    move-object v10, p0

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    move-object v11, v0

    .line 276
    .local v11, "renderersList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/Renderer;>;"
    iget-object v1, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->context:Landroid/content/Context;

    iget v2, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->extensionRendererMode:I

    iget-object v3, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->mediaCodecSelector:Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;

    iget-boolean v4, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->enableDecoderFallback:Z

    iget-wide v7, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->allowedVideoJoiningTimeMs:J

    move-object v0, p0

    move-object v5, p1

    move-object v6, p2

    move-object v9, v11

    invoke-virtual/range {v0 .. v9}, Landroidx/media3/exoplayer/DefaultRenderersFactory;->buildVideoRenderers(Landroid/content/Context;ILandroidx/media3/exoplayer/mediacodec/MediaCodecSelector;ZLandroid/os/Handler;Landroidx/media3/exoplayer/video/VideoRendererEventListener;JLjava/util/ArrayList;)V

    .line 286
    iget-object v0, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->context:Landroid/content/Context;

    iget-boolean v1, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->enableFloatOutput:Z

    iget-boolean v2, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->enableAudioTrackPlaybackParams:Z

    .line 287
    invoke-virtual {p0, v0, v1, v2}, Landroidx/media3/exoplayer/DefaultRenderersFactory;->buildAudioSink(Landroid/content/Context;ZZ)Landroidx/media3/exoplayer/audio/AudioSink;

    move-result-object v9

    .line 288
    .local v9, "audioSink":Landroidx/media3/exoplayer/audio/AudioSink;
    if-eqz v9, :cond_0

    .line 289
    iget-object v1, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->context:Landroid/content/Context;

    iget v2, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->extensionRendererMode:I

    iget-object v3, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->mediaCodecSelector:Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;

    iget-boolean v4, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->enableDecoderFallback:Z

    move-object v0, p0

    move-object v5, v9

    move-object v6, p1

    move-object v7, p3

    move-object v8, v11

    invoke-virtual/range {v0 .. v8}, Landroidx/media3/exoplayer/DefaultRenderersFactory;->buildAudioRenderers(Landroid/content/Context;ILandroidx/media3/exoplayer/mediacodec/MediaCodecSelector;ZLandroidx/media3/exoplayer/audio/AudioSink;Landroid/os/Handler;Landroidx/media3/exoplayer/audio/AudioRendererEventListener;Ljava/util/ArrayList;)V

    .line 299
    :cond_0
    iget-object v1, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->context:Landroid/content/Context;

    .line 302
    invoke-virtual {p1}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v3

    iget v4, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->extensionRendererMode:I

    .line 299
    move-object v0, p0

    move-object/from16 v2, p4

    move-object v5, v11

    invoke-virtual/range {v0 .. v5}, Landroidx/media3/exoplayer/DefaultRenderersFactory;->buildTextRenderers(Landroid/content/Context;Landroidx/media3/exoplayer/text/TextOutput;Landroid/os/Looper;ILjava/util/ArrayList;)V

    .line 305
    iget-object v1, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->context:Landroid/content/Context;

    .line 308
    invoke-virtual {p1}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v3

    iget v4, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->extensionRendererMode:I

    .line 305
    move-object/from16 v2, p5

    invoke-virtual/range {v0 .. v5}, Landroidx/media3/exoplayer/DefaultRenderersFactory;->buildMetadataRenderers(Landroid/content/Context;Landroidx/media3/exoplayer/metadata/MetadataOutput;Landroid/os/Looper;ILjava/util/ArrayList;)V

    .line 311
    iget-object v0, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->context:Landroid/content/Context;

    iget v1, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->extensionRendererMode:I

    invoke-virtual {p0, v0, v1, v11}, Landroidx/media3/exoplayer/DefaultRenderersFactory;->buildCameraMotionRenderers(Landroid/content/Context;ILjava/util/ArrayList;)V

    .line 312
    invoke-virtual {p0, v11}, Landroidx/media3/exoplayer/DefaultRenderersFactory;->buildImageRenderers(Ljava/util/ArrayList;)V

    .line 313
    iget-object v0, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->context:Landroid/content/Context;

    iget v1, v10, Landroidx/media3/exoplayer/DefaultRenderersFactory;->extensionRendererMode:I

    move-object v2, p1

    invoke-virtual {p0, v0, p1, v1, v11}, Landroidx/media3/exoplayer/DefaultRenderersFactory;->buildMiscellaneousRenderers(Landroid/content/Context;Landroid/os/Handler;ILjava/util/ArrayList;)V

    .line 314
    const/4 v0, 0x0

    new-array v0, v0, [Landroidx/media3/exoplayer/Renderer;

    invoke-virtual {v11, v0}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroidx/media3/exoplayer/Renderer;

    return-object v0
.end method

.method public final experimentalSetMediaCodecAsyncCryptoFlagEnabled(Z)Landroidx/media3/exoplayer/DefaultRenderersFactory;
    .locals 1
    .param p1, "enableAsyncCryptoFlag"    # Z

    .line 176
    iget-object v0, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->codecAdapterFactory:Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;->experimentalSetAsyncCryptoFlagEnabled(Z)Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;

    .line 177
    return-object p0
.end method

.method public final forceDisableMediaCodecAsynchronousQueueing()Landroidx/media3/exoplayer/DefaultRenderersFactory;
    .locals 1

    .line 162
    iget-object v0, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->codecAdapterFactory:Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;->forceDisableAsynchronous()Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;

    .line 163
    return-object p0
.end method

.method public final forceEnableMediaCodecAsynchronousQueueing()Landroidx/media3/exoplayer/DefaultRenderersFactory;
    .locals 1

    .line 149
    iget-object v0, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->codecAdapterFactory:Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;->forceEnableAsynchronous()Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;

    .line 150
    return-object p0
.end method

.method protected getCodecAdapterFactory()Landroidx/media3/exoplayer/mediacodec/MediaCodecAdapter$Factory;
    .locals 1

    .line 653
    iget-object v0, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->codecAdapterFactory:Landroidx/media3/exoplayer/mediacodec/DefaultMediaCodecAdapterFactory;

    return-object v0
.end method

.method public final setAllowedVideoJoiningTimeMs(J)Landroidx/media3/exoplayer/DefaultRenderersFactory;
    .locals 0
    .param p1, "allowedVideoJoiningTimeMs"    # J

    .line 264
    iput-wide p1, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->allowedVideoJoiningTimeMs:J

    .line 265
    return-object p0
.end method

.method public final setEnableAudioFloatOutput(Z)Landroidx/media3/exoplayer/DefaultRenderersFactory;
    .locals 0
    .param p1, "enableFloatOutput"    # Z

    .line 222
    iput-boolean p1, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->enableFloatOutput:Z

    .line 223
    return-object p0
.end method

.method public final setEnableAudioTrackPlaybackParams(Z)Landroidx/media3/exoplayer/DefaultRenderersFactory;
    .locals 0
    .param p1, "enableAudioTrackPlaybackParams"    # Z

    .line 247
    iput-boolean p1, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->enableAudioTrackPlaybackParams:Z

    .line 248
    return-object p0
.end method

.method public final setEnableDecoderFallback(Z)Landroidx/media3/exoplayer/DefaultRenderersFactory;
    .locals 0
    .param p1, "enableDecoderFallback"    # Z

    .line 190
    iput-boolean p1, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->enableDecoderFallback:Z

    .line 191
    return-object p0
.end method

.method public final setExtensionRendererMode(I)Landroidx/media3/exoplayer/DefaultRenderersFactory;
    .locals 0
    .param p1, "extensionRendererMode"    # I

    .line 134
    iput p1, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->extensionRendererMode:I

    .line 135
    return-object p0
.end method

.method public final setMediaCodecSelector(Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;)Landroidx/media3/exoplayer/DefaultRenderersFactory;
    .locals 0
    .param p1, "mediaCodecSelector"    # Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;

    .line 205
    iput-object p1, p0, Landroidx/media3/exoplayer/DefaultRenderersFactory;->mediaCodecSelector:Landroidx/media3/exoplayer/mediacodec/MediaCodecSelector;

    .line 206
    return-object p0
.end method
