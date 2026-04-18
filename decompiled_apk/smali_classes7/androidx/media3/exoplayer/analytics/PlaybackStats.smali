.class public final Landroidx/media3/exoplayer/analytics/PlaybackStats;
.super Ljava/lang/Object;
.source "PlaybackStats.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndPlaybackState;,
        Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndException;,
        Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndFormat;
    }
.end annotation


# static fields
.field public static final EMPTY:Landroidx/media3/exoplayer/analytics/PlaybackStats;

.field public static final PLAYBACK_STATE_ABANDONED:I = 0xf

.field public static final PLAYBACK_STATE_BUFFERING:I = 0x6

.field static final PLAYBACK_STATE_COUNT:I = 0x10

.field public static final PLAYBACK_STATE_ENDED:I = 0xb

.field public static final PLAYBACK_STATE_FAILED:I = 0xd

.field public static final PLAYBACK_STATE_INTERRUPTED_BY_AD:I = 0xe

.field public static final PLAYBACK_STATE_JOINING_BACKGROUND:I = 0x1

.field public static final PLAYBACK_STATE_JOINING_FOREGROUND:I = 0x2

.field public static final PLAYBACK_STATE_NOT_STARTED:I = 0x0

.field public static final PLAYBACK_STATE_PAUSED:I = 0x4

.field public static final PLAYBACK_STATE_PAUSED_BUFFERING:I = 0x7

.field public static final PLAYBACK_STATE_PLAYING:I = 0x3

.field public static final PLAYBACK_STATE_SEEKING:I = 0x5

.field public static final PLAYBACK_STATE_STOPPED:I = 0xc

.field public static final PLAYBACK_STATE_SUPPRESSED:I = 0x9

.field public static final PLAYBACK_STATE_SUPPRESSED_BUFFERING:I = 0xa


# instance fields
.field public final abandonedBeforeReadyCount:I

.field public final adPlaybackCount:I

.field public final audioFormatHistory:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndFormat;",
            ">;"
        }
    .end annotation
.end field

.field public final backgroundJoiningCount:I

.field public final endedCount:I

.field public final fatalErrorCount:I

.field public final fatalErrorHistory:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndException;",
            ">;"
        }
    .end annotation
.end field

.field public final fatalErrorPlaybackCount:I

.field public final firstReportedTimeMs:J

.field public final foregroundPlaybackCount:I

.field public final initialAudioFormatBitrateCount:I

.field public final initialVideoFormatBitrateCount:I

.field public final initialVideoFormatHeightCount:I

.field public final maxRebufferTimeMs:J

.field public final mediaTimeHistory:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "[J>;"
        }
    .end annotation
.end field

.field public final nonFatalErrorCount:I

.field public final nonFatalErrorHistory:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndException;",
            ">;"
        }
    .end annotation
.end field

.field public final playbackCount:I

.field private final playbackStateDurationsMs:[J

.field public final playbackStateHistory:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndPlaybackState;",
            ">;"
        }
    .end annotation
.end field

.field public final totalAudioFormatBitrateTimeProduct:J

.field public final totalAudioFormatTimeMs:J

.field public final totalAudioUnderruns:J

.field public final totalBandwidthBytes:J

.field public final totalBandwidthTimeMs:J

.field public final totalDroppedFrames:J

.field public final totalInitialAudioFormatBitrate:J

.field public final totalInitialVideoFormatBitrate:J

.field public final totalInitialVideoFormatHeight:I

.field public final totalPauseBufferCount:I

.field public final totalPauseCount:I

.field public final totalRebufferCount:I

.field public final totalSeekCount:I

.field public final totalValidJoinTimeMs:J

.field public final totalVideoFormatBitrateTimeMs:J

.field public final totalVideoFormatBitrateTimeProduct:J

.field public final totalVideoFormatHeightTimeMs:J

.field public final totalVideoFormatHeightTimeProduct:J

.field public final validJoinTimeCount:I

.field public final videoFormatHistory:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndFormat;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 249
    const/4 v0, 0x0

    new-array v0, v0, [Landroidx/media3/exoplayer/analytics/PlaybackStats;

    invoke-static {v0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->merge([Landroidx/media3/exoplayer/analytics/PlaybackStats;)Landroidx/media3/exoplayer/analytics/PlaybackStats;

    move-result-object v0

    sput-object v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->EMPTY:Landroidx/media3/exoplayer/analytics/PlaybackStats;

    return-void
.end method

.method constructor <init>(I[JLjava/util/List;Ljava/util/List;JIIIIJIIIIIJILjava/util/List;Ljava/util/List;JJJJJJIIIJIJJJJJIIILjava/util/List;Ljava/util/List;)V
    .locals 16
    .param p1, "playbackCount"    # I
    .param p2, "playbackStateDurationsMs"    # [J
    .param p5, "firstReportedTimeMs"    # J
    .param p7, "foregroundPlaybackCount"    # I
    .param p8, "abandonedBeforeReadyCount"    # I
    .param p9, "endedCount"    # I
    .param p10, "backgroundJoiningCount"    # I
    .param p11, "totalValidJoinTimeMs"    # J
    .param p13, "validJoinTimeCount"    # I
    .param p14, "totalPauseCount"    # I
    .param p15, "totalPauseBufferCount"    # I
    .param p16, "totalSeekCount"    # I
    .param p17, "totalRebufferCount"    # I
    .param p18, "maxRebufferTimeMs"    # J
    .param p20, "adPlaybackCount"    # I
    .param p23, "totalVideoFormatHeightTimeMs"    # J
    .param p25, "totalVideoFormatHeightTimeProduct"    # J
    .param p27, "totalVideoFormatBitrateTimeMs"    # J
    .param p29, "totalVideoFormatBitrateTimeProduct"    # J
    .param p31, "totalAudioFormatTimeMs"    # J
    .param p33, "totalAudioFormatBitrateTimeProduct"    # J
    .param p35, "initialVideoFormatHeightCount"    # I
    .param p36, "initialVideoFormatBitrateCount"    # I
    .param p37, "totalInitialVideoFormatHeight"    # I
    .param p38, "totalInitialVideoFormatBitrate"    # J
    .param p40, "initialAudioFormatBitrateCount"    # I
    .param p41, "totalInitialAudioFormatBitrate"    # J
    .param p43, "totalBandwidthTimeMs"    # J
    .param p45, "totalBandwidthBytes"    # J
    .param p47, "totalDroppedFrames"    # J
    .param p49, "totalAudioUnderruns"    # J
    .param p51, "fatalErrorPlaybackCount"    # I
    .param p52, "fatalErrorCount"    # I
    .param p53, "nonFatalErrorCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I[J",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndPlaybackState;",
            ">;",
            "Ljava/util/List<",
            "[J>;JIIIIJIIIIIJI",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndFormat;",
            ">;",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndFormat;",
            ">;JJJJJJIIIJIJJJJJIII",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndException;",
            ">;",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndException;",
            ">;)V"
        }
    .end annotation

    .line 634
    .local p3, "playbackStateHistory":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndPlaybackState;>;"
    .local p4, "mediaTimeHistory":Ljava/util/List;, "Ljava/util/List<[J>;"
    .local p21, "videoFormatHistory":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndFormat;>;"
    .local p22, "audioFormatHistory":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndFormat;>;"
    .local p54, "fatalErrorHistory":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndException;>;"
    .local p55, "nonFatalErrorHistory":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndException;>;"
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 635
    move/from16 v1, p1

    iput v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->playbackCount:I

    .line 636
    move-object/from16 v2, p2

    iput-object v2, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->playbackStateDurationsMs:[J

    .line 637
    invoke-static/range {p3 .. p3}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    iput-object v3, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->playbackStateHistory:Ljava/util/List;

    .line 638
    invoke-static/range {p4 .. p4}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    iput-object v3, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->mediaTimeHistory:Ljava/util/List;

    .line 639
    move-wide/from16 v3, p5

    iput-wide v3, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->firstReportedTimeMs:J

    .line 640
    move/from16 v5, p7

    iput v5, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    .line 641
    move/from16 v6, p8

    iput v6, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->abandonedBeforeReadyCount:I

    .line 642
    move/from16 v7, p9

    iput v7, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->endedCount:I

    .line 643
    move/from16 v8, p10

    iput v8, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->backgroundJoiningCount:I

    .line 644
    move-wide/from16 v9, p11

    iput-wide v9, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalValidJoinTimeMs:J

    .line 645
    move/from16 v11, p13

    iput v11, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->validJoinTimeCount:I

    .line 646
    move/from16 v12, p14

    iput v12, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalPauseCount:I

    .line 647
    move/from16 v13, p15

    iput v13, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalPauseBufferCount:I

    .line 648
    move/from16 v14, p16

    iput v14, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalSeekCount:I

    .line 649
    move/from16 v15, p17

    iput v15, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalRebufferCount:I

    .line 650
    move-wide/from16 v1, p18

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->maxRebufferTimeMs:J

    .line 651
    move/from16 v1, p20

    iput v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->adPlaybackCount:I

    .line 652
    invoke-static/range {p21 .. p21}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->videoFormatHistory:Ljava/util/List;

    .line 653
    invoke-static/range {p22 .. p22}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->audioFormatHistory:Ljava/util/List;

    .line 654
    move-wide/from16 v1, p23

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalVideoFormatHeightTimeMs:J

    .line 655
    move-wide/from16 v1, p25

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalVideoFormatHeightTimeProduct:J

    .line 656
    move-wide/from16 v1, p27

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalVideoFormatBitrateTimeMs:J

    .line 657
    move-wide/from16 v1, p29

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalVideoFormatBitrateTimeProduct:J

    .line 658
    move-wide/from16 v1, p31

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalAudioFormatTimeMs:J

    .line 659
    move-wide/from16 v1, p33

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalAudioFormatBitrateTimeProduct:J

    .line 660
    move/from16 v1, p35

    iput v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->initialVideoFormatHeightCount:I

    .line 661
    move/from16 v2, p36

    iput v2, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->initialVideoFormatBitrateCount:I

    .line 662
    move/from16 v1, p37

    iput v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalInitialVideoFormatHeight:I

    .line 663
    move-wide/from16 v1, p38

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalInitialVideoFormatBitrate:J

    .line 664
    move/from16 v1, p40

    iput v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->initialAudioFormatBitrateCount:I

    .line 665
    move-wide/from16 v1, p41

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalInitialAudioFormatBitrate:J

    .line 666
    move-wide/from16 v1, p43

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalBandwidthTimeMs:J

    .line 667
    move-wide/from16 v1, p45

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalBandwidthBytes:J

    .line 668
    move-wide/from16 v1, p47

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalDroppedFrames:J

    .line 669
    move-wide/from16 v1, p49

    iput-wide v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalAudioUnderruns:J

    .line 670
    move/from16 v1, p51

    iput v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->fatalErrorPlaybackCount:I

    .line 671
    move/from16 v2, p52

    iput v2, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->fatalErrorCount:I

    .line 672
    move/from16 v1, p53

    iput v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->nonFatalErrorCount:I

    .line 673
    invoke-static/range {p54 .. p54}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    iput-object v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->fatalErrorHistory:Ljava/util/List;

    .line 674
    invoke-static/range {p55 .. p55}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    iput-object v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->nonFatalErrorHistory:Ljava/util/List;

    .line 675
    return-void
.end method

.method public static varargs merge([Landroidx/media3/exoplayer/analytics/PlaybackStats;)Landroidx/media3/exoplayer/analytics/PlaybackStats;
    .locals 106
    .param p0, "playbackStats"    # [Landroidx/media3/exoplayer/analytics/PlaybackStats;

    .line 261
    move-object/from16 v0, p0

    const/4 v1, 0x0

    .line 262
    .local v1, "playbackCount":I
    const/16 v2, 0x10

    new-array v14, v2, [J

    .line 263
    .local v14, "playbackStateDurationsMs":[J
    const-wide v3, -0x7fffffffffffffffL    # -4.9E-324

    .line 264
    .local v3, "firstReportedTimeMs":J
    const/4 v5, 0x0

    .line 265
    .local v5, "foregroundPlaybackCount":I
    const/4 v6, 0x0

    .line 266
    .local v6, "abandonedBeforeReadyCount":I
    const/4 v7, 0x0

    .line 267
    .local v7, "endedCount":I
    const/4 v8, 0x0

    .line 268
    .local v8, "backgroundJoiningCount":I
    const-wide v9, -0x7fffffffffffffffL    # -4.9E-324

    .line 269
    .local v9, "totalValidJoinTimeMs":J
    const/4 v11, 0x0

    .line 270
    .local v11, "validJoinTimeCount":I
    const/4 v12, 0x0

    .line 271
    .local v12, "totalPauseCount":I
    const/4 v13, 0x0

    .line 272
    .local v13, "totalPauseBufferCount":I
    const/4 v15, 0x0

    .line 273
    .local v15, "totalSeekCount":I
    const/16 v16, 0x0

    .line 274
    .local v16, "totalRebufferCount":I
    const-wide v17, -0x7fffffffffffffffL    # -4.9E-324

    .line 275
    .local v17, "maxRebufferTimeMs":J
    const/16 v19, 0x0

    .line 276
    .local v19, "adPlaybackCount":I
    const-wide/16 v20, 0x0

    .line 277
    .local v20, "totalVideoFormatHeightTimeMs":J
    const-wide/16 v22, 0x0

    .line 278
    .local v22, "totalVideoFormatHeightTimeProduct":J
    const-wide/16 v24, 0x0

    .line 279
    .local v24, "totalVideoFormatBitrateTimeMs":J
    const-wide/16 v26, 0x0

    .line 280
    .local v26, "totalVideoFormatBitrateTimeProduct":J
    const-wide/16 v28, 0x0

    .line 281
    .local v28, "totalAudioFormatTimeMs":J
    const-wide/16 v30, 0x0

    .line 282
    .local v30, "totalAudioFormatBitrateTimeProduct":J
    const/16 v32, 0x0

    .line 283
    .local v32, "initialVideoFormatHeightCount":I
    const/16 v33, 0x0

    .line 284
    .local v33, "initialVideoFormatBitrateCount":I
    const/16 v34, -0x1

    .line 285
    .local v34, "totalInitialVideoFormatHeight":I
    const-wide/16 v35, -0x1

    .line 286
    .local v35, "totalInitialVideoFormatBitrate":J
    const/16 v37, 0x0

    .line 287
    .local v37, "initialAudioFormatBitrateCount":I
    const-wide/16 v38, -0x1

    .line 288
    .local v38, "totalInitialAudioFormatBitrate":J
    const-wide/16 v40, 0x0

    .line 289
    .local v40, "totalBandwidthTimeMs":J
    const-wide/16 v42, 0x0

    .line 290
    .local v42, "totalBandwidthBytes":J
    const-wide/16 v44, 0x0

    .line 291
    .local v44, "totalDroppedFrames":J
    const-wide/16 v46, 0x0

    .line 292
    .local v46, "totalAudioUnderruns":J
    const/16 v48, 0x0

    .line 293
    .local v48, "fatalErrorPlaybackCount":I
    const/16 v49, 0x0

    .line 294
    .local v49, "fatalErrorCount":I
    const/16 v50, 0x0

    .line 295
    .local v50, "nonFatalErrorCount":I
    array-length v2, v0

    const/16 v52, 0x0

    move/from16 v59, v5

    move/from16 v60, v6

    move/from16 v61, v7

    move/from16 v62, v8

    move-wide/from16 v63, v9

    move/from16 v65, v11

    move/from16 v66, v12

    move/from16 v67, v13

    move/from16 v68, v15

    move/from16 v69, v16

    move-wide/from16 v10, v17

    move/from16 v70, v19

    move-wide/from16 v71, v20

    move-wide/from16 v73, v22

    move-wide/from16 v75, v24

    move-wide/from16 v77, v26

    move-wide/from16 v79, v28

    move-wide/from16 v81, v30

    move/from16 v83, v32

    move/from16 v84, v33

    move/from16 v15, v34

    move-wide/from16 v85, v35

    move/from16 v87, v37

    move-wide/from16 v88, v38

    move-wide/from16 v90, v40

    move-wide/from16 v92, v42

    move-wide/from16 v94, v44

    move-wide/from16 v96, v46

    move/from16 v98, v48

    move/from16 v99, v49

    move/from16 v100, v50

    move-wide v12, v3

    move/from16 v3, v52

    .end local v3    # "firstReportedTimeMs":J
    .end local v5    # "foregroundPlaybackCount":I
    .end local v6    # "abandonedBeforeReadyCount":I
    .end local v7    # "endedCount":I
    .end local v8    # "backgroundJoiningCount":I
    .end local v9    # "totalValidJoinTimeMs":J
    .end local v11    # "validJoinTimeCount":I
    .end local v13    # "totalPauseBufferCount":I
    .end local v16    # "totalRebufferCount":I
    .end local v17    # "maxRebufferTimeMs":J
    .end local v19    # "adPlaybackCount":I
    .end local v20    # "totalVideoFormatHeightTimeMs":J
    .end local v22    # "totalVideoFormatHeightTimeProduct":J
    .end local v24    # "totalVideoFormatBitrateTimeMs":J
    .end local v26    # "totalVideoFormatBitrateTimeProduct":J
    .end local v28    # "totalAudioFormatTimeMs":J
    .end local v30    # "totalAudioFormatBitrateTimeProduct":J
    .end local v32    # "initialVideoFormatHeightCount":I
    .end local v33    # "initialVideoFormatBitrateCount":I
    .end local v34    # "totalInitialVideoFormatHeight":I
    .end local v35    # "totalInitialVideoFormatBitrate":J
    .end local v37    # "initialAudioFormatBitrateCount":I
    .end local v38    # "totalInitialAudioFormatBitrate":J
    .end local v40    # "totalBandwidthTimeMs":J
    .end local v42    # "totalBandwidthBytes":J
    .end local v44    # "totalDroppedFrames":J
    .end local v46    # "totalAudioUnderruns":J
    .end local v48    # "fatalErrorPlaybackCount":I
    .end local v49    # "fatalErrorCount":I
    .end local v50    # "nonFatalErrorCount":I
    .local v10, "maxRebufferTimeMs":J
    .local v12, "firstReportedTimeMs":J
    .local v15, "totalInitialVideoFormatHeight":I
    .local v59, "foregroundPlaybackCount":I
    .local v60, "abandonedBeforeReadyCount":I
    .local v61, "endedCount":I
    .local v62, "backgroundJoiningCount":I
    .local v63, "totalValidJoinTimeMs":J
    .local v65, "validJoinTimeCount":I
    .local v66, "totalPauseCount":I
    .local v67, "totalPauseBufferCount":I
    .local v68, "totalSeekCount":I
    .local v69, "totalRebufferCount":I
    .local v70, "adPlaybackCount":I
    .local v71, "totalVideoFormatHeightTimeMs":J
    .local v73, "totalVideoFormatHeightTimeProduct":J
    .local v75, "totalVideoFormatBitrateTimeMs":J
    .local v77, "totalVideoFormatBitrateTimeProduct":J
    .local v79, "totalAudioFormatTimeMs":J
    .local v81, "totalAudioFormatBitrateTimeProduct":J
    .local v83, "initialVideoFormatHeightCount":I
    .local v84, "initialVideoFormatBitrateCount":I
    .local v85, "totalInitialVideoFormatBitrate":J
    .local v87, "initialAudioFormatBitrateCount":I
    .local v88, "totalInitialAudioFormatBitrate":J
    .local v90, "totalBandwidthTimeMs":J
    .local v92, "totalBandwidthBytes":J
    .local v94, "totalDroppedFrames":J
    .local v96, "totalAudioUnderruns":J
    .local v98, "fatalErrorPlaybackCount":I
    .local v99, "fatalErrorCount":I
    .local v100, "nonFatalErrorCount":I
    :goto_0
    if-ge v3, v2, :cond_d

    aget-object v4, v0, v3

    .line 296
    .local v4, "stats":Landroidx/media3/exoplayer/analytics/PlaybackStats;
    iget v5, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->playbackCount:I

    add-int/2addr v1, v5

    .line 297
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_1
    const/16 v6, 0x10

    if-ge v5, v6, :cond_0

    .line 298
    aget-wide v7, v14, v5

    iget-object v9, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->playbackStateDurationsMs:[J

    aget-wide v16, v9, v5

    add-long v7, v7, v16

    aput-wide v7, v14, v5

    .line 297
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 300
    .end local v5    # "i":I
    :cond_0
    const-wide v7, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v5, v12, v7

    if-nez v5, :cond_1

    .line 301
    iget-wide v12, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->firstReportedTimeMs:J

    move v5, v1

    goto :goto_2

    .line 302
    :cond_1
    move v5, v1

    .end local v1    # "playbackCount":I
    .local v5, "playbackCount":I
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->firstReportedTimeMs:J

    cmp-long v9, v0, v7

    if-eqz v9, :cond_2

    .line 303
    invoke-static {v12, v13, v0, v1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    move-wide v12, v0

    .line 305
    :cond_2
    :goto_2
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    add-int v59, v59, v0

    .line 306
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->abandonedBeforeReadyCount:I

    add-int v60, v60, v0

    .line 307
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->endedCount:I

    add-int v61, v61, v0

    .line 308
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->backgroundJoiningCount:I

    add-int v62, v62, v0

    .line 309
    cmp-long v0, v63, v7

    if-nez v0, :cond_3

    .line 310
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalValidJoinTimeMs:J

    move-wide/from16 v63, v0

    .end local v63    # "totalValidJoinTimeMs":J
    .local v0, "totalValidJoinTimeMs":J
    goto :goto_3

    .line 311
    .end local v0    # "totalValidJoinTimeMs":J
    .restart local v63    # "totalValidJoinTimeMs":J
    :cond_3
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalValidJoinTimeMs:J

    cmp-long v9, v0, v7

    if-eqz v9, :cond_4

    .line 312
    add-long v63, v63, v0

    .line 314
    :cond_4
    :goto_3
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->validJoinTimeCount:I

    add-int v65, v65, v0

    .line 315
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalPauseCount:I

    add-int v66, v66, v0

    .line 316
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalPauseBufferCount:I

    add-int v67, v67, v0

    .line 317
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalSeekCount:I

    add-int v68, v68, v0

    .line 318
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalRebufferCount:I

    add-int v69, v69, v0

    .line 319
    cmp-long v0, v10, v7

    if-nez v0, :cond_5

    .line 320
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->maxRebufferTimeMs:J

    move-wide v10, v0

    .end local v10    # "maxRebufferTimeMs":J
    .local v0, "maxRebufferTimeMs":J
    goto :goto_4

    .line 321
    .end local v0    # "maxRebufferTimeMs":J
    .restart local v10    # "maxRebufferTimeMs":J
    :cond_5
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->maxRebufferTimeMs:J

    cmp-long v7, v0, v7

    if-eqz v7, :cond_6

    .line 322
    invoke-static {v10, v11, v0, v1}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    move-wide v10, v0

    .line 324
    :cond_6
    :goto_4
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->adPlaybackCount:I

    add-int v70, v70, v0

    .line 325
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalVideoFormatHeightTimeMs:J

    add-long v71, v71, v0

    .line 326
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalVideoFormatHeightTimeProduct:J

    add-long v73, v73, v0

    .line 327
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalVideoFormatBitrateTimeMs:J

    add-long v75, v75, v0

    .line 328
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalVideoFormatBitrateTimeProduct:J

    add-long v77, v77, v0

    .line 329
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalAudioFormatTimeMs:J

    add-long v79, v79, v0

    .line 330
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalAudioFormatBitrateTimeProduct:J

    add-long v81, v81, v0

    .line 331
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->initialVideoFormatHeightCount:I

    add-int v83, v83, v0

    .line 332
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->initialVideoFormatBitrateCount:I

    add-int v84, v84, v0

    .line 333
    const/4 v0, -0x1

    if-ne v15, v0, :cond_7

    .line 334
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalInitialVideoFormatHeight:I

    move v15, v0

    .end local v15    # "totalInitialVideoFormatHeight":I
    .local v0, "totalInitialVideoFormatHeight":I
    goto :goto_5

    .line 335
    .end local v0    # "totalInitialVideoFormatHeight":I
    .restart local v15    # "totalInitialVideoFormatHeight":I
    :cond_7
    iget v1, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalInitialVideoFormatHeight:I

    if-eq v1, v0, :cond_8

    .line 336
    add-int/2addr v15, v1

    .line 338
    :cond_8
    :goto_5
    const-wide/16 v0, -0x1

    cmp-long v7, v85, v0

    if-nez v7, :cond_9

    .line 339
    iget-wide v7, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalInitialVideoFormatBitrate:J

    move-wide/from16 v85, v7

    .end local v85    # "totalInitialVideoFormatBitrate":J
    .local v7, "totalInitialVideoFormatBitrate":J
    goto :goto_6

    .line 340
    .end local v7    # "totalInitialVideoFormatBitrate":J
    .restart local v85    # "totalInitialVideoFormatBitrate":J
    :cond_9
    iget-wide v7, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalInitialVideoFormatBitrate:J

    cmp-long v9, v7, v0

    if-eqz v9, :cond_a

    .line 341
    add-long v85, v85, v7

    .line 343
    :cond_a
    :goto_6
    iget v7, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->initialAudioFormatBitrateCount:I

    add-int v87, v87, v7

    .line 344
    cmp-long v7, v88, v0

    if-nez v7, :cond_b

    .line 345
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalInitialAudioFormatBitrate:J

    move-wide/from16 v88, v0

    .end local v88    # "totalInitialAudioFormatBitrate":J
    .local v0, "totalInitialAudioFormatBitrate":J
    goto :goto_7

    .line 346
    .end local v0    # "totalInitialAudioFormatBitrate":J
    .restart local v88    # "totalInitialAudioFormatBitrate":J
    :cond_b
    iget-wide v7, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalInitialAudioFormatBitrate:J

    cmp-long v0, v7, v0

    if-eqz v0, :cond_c

    .line 347
    add-long v88, v88, v7

    .line 349
    :cond_c
    :goto_7
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalBandwidthTimeMs:J

    add-long v90, v90, v0

    .line 350
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalBandwidthBytes:J

    add-long v92, v92, v0

    .line 351
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalDroppedFrames:J

    add-long v94, v94, v0

    .line 352
    iget-wide v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalAudioUnderruns:J

    add-long v96, v96, v0

    .line 353
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->fatalErrorPlaybackCount:I

    add-int v98, v98, v0

    .line 354
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->fatalErrorCount:I

    add-int v99, v99, v0

    .line 355
    iget v0, v4, Landroidx/media3/exoplayer/analytics/PlaybackStats;->nonFatalErrorCount:I

    add-int v100, v100, v0

    .line 295
    .end local v4    # "stats":Landroidx/media3/exoplayer/analytics/PlaybackStats;
    add-int/lit8 v3, v3, 0x1

    move-object/from16 v0, p0

    move v1, v5

    goto/16 :goto_0

    .line 357
    .end local v5    # "playbackCount":I
    .restart local v1    # "playbackCount":I
    :cond_d
    new-instance v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;

    move-object v3, v0

    .line 360
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v6

    .line 361
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v7

    .line 375
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v24

    .line 376
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v25

    .line 396
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v57

    .line 397
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v58

    move v4, v1

    move-object v5, v14

    move-wide v8, v12

    move-wide/from16 v101, v10

    .end local v10    # "maxRebufferTimeMs":J
    .local v101, "maxRebufferTimeMs":J
    move/from16 v10, v59

    move/from16 v11, v60

    move-wide/from16 v103, v12

    .end local v12    # "firstReportedTimeMs":J
    .local v103, "firstReportedTimeMs":J
    move/from16 v12, v61

    move/from16 v13, v62

    move-object v2, v14

    move/from16 v105, v15

    .end local v14    # "playbackStateDurationsMs":[J
    .end local v15    # "totalInitialVideoFormatHeight":I
    .local v2, "playbackStateDurationsMs":[J
    .local v105, "totalInitialVideoFormatHeight":I
    move-wide/from16 v14, v63

    move/from16 v16, v65

    move/from16 v17, v66

    move/from16 v18, v67

    move/from16 v19, v68

    move/from16 v20, v69

    move-wide/from16 v21, v101

    move/from16 v23, v70

    move-wide/from16 v26, v71

    move-wide/from16 v28, v73

    move-wide/from16 v30, v75

    move-wide/from16 v32, v77

    move-wide/from16 v34, v79

    move-wide/from16 v36, v81

    move/from16 v38, v83

    move/from16 v39, v84

    move/from16 v40, v105

    move-wide/from16 v41, v85

    move/from16 v43, v87

    move-wide/from16 v44, v88

    move-wide/from16 v46, v90

    move-wide/from16 v48, v92

    move-wide/from16 v50, v94

    move-wide/from16 v52, v96

    move/from16 v54, v98

    move/from16 v55, v99

    move/from16 v56, v100

    invoke-direct/range {v3 .. v58}, Landroidx/media3/exoplayer/analytics/PlaybackStats;-><init>(I[JLjava/util/List;Ljava/util/List;JIIIIJIIIIIJILjava/util/List;Ljava/util/List;JJJJJJIIIJIJJJJJIIILjava/util/List;Ljava/util/List;)V

    .line 357
    return-object v0
.end method


# virtual methods
.method public getAbandonedBeforeReadyRatio()F
    .locals 3

    .line 906
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->abandonedBeforeReadyCount:I

    iget v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->playbackCount:I

    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    sub-int/2addr v1, v2

    sub-int/2addr v0, v1

    .line 908
    .local v0, "foregroundAbandonedBeforeReady":I
    if-nez v2, :cond_0

    .line 909
    const/4 v1, 0x0

    goto :goto_0

    .line 910
    :cond_0
    int-to-float v1, v0

    int-to-float v2, v2

    div-float/2addr v1, v2

    .line 908
    :goto_0
    return v1
.end method

.method public getAudioUnderrunRate()F
    .locals 4

    .line 1101
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPlayTimeMs()J

    move-result-wide v0

    .line 1102
    .local v0, "playTimeMs":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    goto :goto_0

    :cond_0
    iget-wide v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalAudioUnderruns:J

    long-to-float v2, v2

    const/high16 v3, 0x447a0000    # 1000.0f

    mul-float/2addr v2, v3

    long-to-float v3, v0

    div-float/2addr v2, v3

    :goto_0
    return v2
.end method

.method public getDroppedFramesRate()F
    .locals 4

    .line 1092
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPlayTimeMs()J

    move-result-wide v0

    .line 1093
    .local v0, "playTimeMs":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    goto :goto_0

    :cond_0
    iget-wide v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalDroppedFrames:J

    long-to-float v2, v2

    const/high16 v3, 0x447a0000    # 1000.0f

    mul-float/2addr v2, v3

    long-to-float v3, v0

    div-float/2addr v2, v3

    :goto_0
    return v2
.end method

.method public getEndedRatio()F
    .locals 2

    .line 918
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    iget v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->endedCount:I

    int-to-float v1, v1

    int-to-float v0, v0

    div-float v0, v1, v0

    :goto_0
    return v0
.end method

.method public getFatalErrorRate()F
    .locals 4

    .line 1120
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPlayTimeMs()J

    move-result-wide v0

    .line 1121
    .local v0, "playTimeMs":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    goto :goto_0

    :cond_0
    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->fatalErrorCount:I

    int-to-float v2, v2

    const/high16 v3, 0x447a0000    # 1000.0f

    mul-float/2addr v2, v3

    long-to-float v3, v0

    div-float/2addr v2, v3

    :goto_0
    return v2
.end method

.method public getFatalErrorRatio()F
    .locals 2

    .line 1110
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    .line 1111
    const/4 v0, 0x0

    goto :goto_0

    .line 1112
    :cond_0
    iget v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->fatalErrorPlaybackCount:I

    int-to-float v1, v1

    int-to-float v0, v0

    div-float v0, v1, v0

    .line 1110
    :goto_0
    return v0
.end method

.method public getJoinTimeRatio()F
    .locals 4

    .line 973
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPlayAndWaitTimeMs()J

    move-result-wide v0

    .line 974
    .local v0, "playAndWaitTimeMs":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalJoinTimeMs()J

    move-result-wide v2

    long-to-float v2, v2

    long-to-float v3, v0

    div-float/2addr v2, v3

    :goto_0
    return v2
.end method

.method public getMeanAudioFormatBitrate()I
    .locals 4

    .line 1072
    iget-wide v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalAudioFormatTimeMs:J

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    .line 1073
    const/4 v0, -0x1

    goto :goto_0

    .line 1074
    :cond_0
    iget-wide v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalAudioFormatBitrateTimeProduct:J

    div-long/2addr v2, v0

    long-to-int v0, v2

    .line 1072
    :goto_0
    return v0
.end method

.method public getMeanBandwidth()I
    .locals 6

    .line 1082
    iget-wide v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalBandwidthTimeMs:J

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    .line 1083
    const/4 v0, -0x1

    goto :goto_0

    .line 1084
    :cond_0
    iget-wide v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalBandwidthBytes:J

    const-wide/16 v4, 0x1f40

    mul-long/2addr v2, v4

    div-long/2addr v2, v0

    long-to-int v0, v2

    .line 1082
    :goto_0
    return v0
.end method

.method public getMeanElapsedTimeMs()J
    .locals 4

    .line 898
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->playbackCount:I

    if-nez v0, :cond_0

    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalElapsedTimeMs()J

    move-result-wide v0

    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->playbackCount:I

    int-to-long v2, v2

    div-long/2addr v0, v2

    :goto_0
    return-wide v0
.end method

.method public getMeanInitialAudioFormatBitrate()I
    .locals 5

    .line 1039
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->initialAudioFormatBitrateCount:I

    if-nez v0, :cond_0

    .line 1040
    const/4 v0, -0x1

    goto :goto_0

    .line 1041
    :cond_0
    iget-wide v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalInitialAudioFormatBitrate:J

    int-to-long v3, v0

    div-long/2addr v1, v3

    long-to-int v0, v1

    .line 1039
    :goto_0
    return v0
.end method

.method public getMeanInitialVideoFormatBitrate()I
    .locals 5

    .line 1029
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->initialVideoFormatBitrateCount:I

    if-nez v0, :cond_0

    .line 1030
    const/4 v0, -0x1

    goto :goto_0

    .line 1031
    :cond_0
    iget-wide v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalInitialVideoFormatBitrate:J

    int-to-long v3, v0

    div-long/2addr v1, v3

    long-to-int v0, v1

    .line 1029
    :goto_0
    return v0
.end method

.method public getMeanInitialVideoFormatHeight()I
    .locals 2

    .line 1019
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->initialVideoFormatHeightCount:I

    if-nez v0, :cond_0

    .line 1020
    const/4 v0, -0x1

    goto :goto_0

    .line 1021
    :cond_0
    iget v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalInitialVideoFormatHeight:I

    div-int v0, v1, v0

    .line 1019
    :goto_0
    return v0
.end method

.method public getMeanJoinTimeMs()J
    .locals 5

    .line 746
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->validJoinTimeCount:I

    if-nez v0, :cond_0

    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    goto :goto_0

    :cond_0
    iget-wide v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalValidJoinTimeMs:J

    int-to-long v3, v0

    div-long v0, v1, v3

    :goto_0
    return-wide v0
.end method

.method public getMeanNonFatalErrorCount()F
    .locals 2

    .line 1137
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    iget v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->nonFatalErrorCount:I

    int-to-float v1, v1

    int-to-float v0, v0

    div-float v0, v1, v0

    :goto_0
    return v0
.end method

.method public getMeanPauseBufferCount()F
    .locals 2

    .line 934
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    .line 935
    const/4 v0, 0x0

    goto :goto_0

    .line 936
    :cond_0
    iget v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalPauseBufferCount:I

    int-to-float v1, v1

    int-to-float v0, v0

    div-float v0, v1, v0

    .line 934
    :goto_0
    return v0
.end method

.method public getMeanPauseCount()F
    .locals 2

    .line 926
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    iget v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalPauseCount:I

    int-to-float v1, v1

    int-to-float v0, v0

    div-float v0, v1, v0

    :goto_0
    return v0
.end method

.method public getMeanPausedTimeMs()J
    .locals 4

    .line 784
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    .line 785
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    goto :goto_0

    .line 786
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPausedTimeMs()J

    move-result-wide v0

    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    int-to-long v2, v2

    div-long/2addr v0, v2

    .line 784
    :goto_0
    return-wide v0
.end method

.method public getMeanPlayAndWaitTimeMs()J
    .locals 4

    .line 879
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    .line 880
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    goto :goto_0

    .line 881
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPlayAndWaitTimeMs()J

    move-result-wide v0

    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    int-to-long v2, v2

    div-long/2addr v0, v2

    .line 879
    :goto_0
    return-wide v0
.end method

.method public getMeanPlayTimeMs()J
    .locals 4

    .line 768
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    .line 769
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    goto :goto_0

    .line 770
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPlayTimeMs()J

    move-result-wide v0

    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    int-to-long v2, v2

    div-long/2addr v0, v2

    .line 768
    :goto_0
    return-wide v0
.end method

.method public getMeanRebufferCount()F
    .locals 2

    .line 953
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    iget v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalRebufferCount:I

    int-to-float v1, v1

    int-to-float v0, v0

    div-float v0, v1, v0

    :goto_0
    return v0
.end method

.method public getMeanRebufferTimeMs()J
    .locals 4

    .line 803
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    .line 804
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    goto :goto_0

    .line 805
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalRebufferTimeMs()J

    move-result-wide v0

    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    int-to-long v2, v2

    div-long/2addr v0, v2

    .line 803
    :goto_0
    return-wide v0
.end method

.method public getMeanSeekCount()F
    .locals 2

    .line 945
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    iget v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalSeekCount:I

    int-to-float v1, v1

    int-to-float v0, v0

    div-float v0, v1, v0

    :goto_0
    return v0
.end method

.method public getMeanSeekTimeMs()J
    .locals 4

    .line 833
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    .line 834
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    goto :goto_0

    .line 835
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalSeekTimeMs()J

    move-result-wide v0

    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    int-to-long v2, v2

    div-long/2addr v0, v2

    .line 833
    :goto_0
    return-wide v0
.end method

.method public getMeanSingleRebufferTimeMs()J
    .locals 4

    .line 813
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalRebufferCount:I

    if-nez v0, :cond_0

    .line 814
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    goto :goto_0

    .line 817
    :cond_0
    nop

    .line 815
    const/4 v0, 0x6

    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getPlaybackStateDurationMs(I)J

    move-result-wide v0

    .line 816
    const/4 v2, 0x7

    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getPlaybackStateDurationMs(I)J

    move-result-wide v2

    add-long/2addr v0, v2

    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalRebufferCount:I

    int-to-long v2, v2

    div-long/2addr v0, v2

    .line 813
    :goto_0
    return-wide v0
.end method

.method public getMeanSingleSeekTimeMs()J
    .locals 4

    .line 843
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalSeekCount:I

    if-nez v0, :cond_0

    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalSeekTimeMs()J

    move-result-wide v0

    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalSeekCount:I

    int-to-long v2, v2

    div-long/2addr v0, v2

    :goto_0
    return-wide v0
.end method

.method public getMeanTimeBetweenFatalErrors()F
    .locals 2

    .line 1129
    const/high16 v0, 0x3f800000    # 1.0f

    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getFatalErrorRate()F

    move-result v1

    div-float/2addr v0, v1

    return v0
.end method

.method public getMeanTimeBetweenNonFatalErrors()F
    .locals 2

    .line 1154
    const/high16 v0, 0x3f800000    # 1.0f

    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getNonFatalErrorRate()F

    move-result v1

    div-float/2addr v0, v1

    return v0
.end method

.method public getMeanTimeBetweenRebuffers()F
    .locals 2

    .line 1011
    const/high16 v0, 0x3f800000    # 1.0f

    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getRebufferRate()F

    move-result v1

    div-float/2addr v0, v1

    return v0
.end method

.method public getMeanVideoFormatBitrate()I
    .locals 4

    .line 1061
    iget-wide v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalVideoFormatBitrateTimeMs:J

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    .line 1062
    const/4 v0, -0x1

    goto :goto_0

    .line 1063
    :cond_0
    iget-wide v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalVideoFormatBitrateTimeProduct:J

    div-long/2addr v2, v0

    long-to-int v0, v2

    .line 1061
    :goto_0
    return v0
.end method

.method public getMeanVideoFormatHeight()I
    .locals 4

    .line 1050
    iget-wide v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalVideoFormatHeightTimeMs:J

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    .line 1051
    const/4 v0, -0x1

    goto :goto_0

    .line 1052
    :cond_0
    iget-wide v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalVideoFormatHeightTimeProduct:J

    div-long/2addr v2, v0

    long-to-int v0, v2

    .line 1050
    :goto_0
    return v0
.end method

.method public getMeanWaitTimeMs()J
    .locals 4

    .line 864
    iget v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    if-nez v0, :cond_0

    .line 865
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    goto :goto_0

    .line 866
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalWaitTimeMs()J

    move-result-wide v0

    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->foregroundPlaybackCount:I

    int-to-long v2, v2

    div-long/2addr v0, v2

    .line 864
    :goto_0
    return-wide v0
.end method

.method public getMediaTimeMsAtRealtimeMs(J)J
    .locals 16
    .param p1, "realtimeMs"    # J

    .line 714
    move-object/from16 v0, p0

    iget-object v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->mediaTimeHistory:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 715
    const-wide v1, -0x7fffffffffffffffL    # -4.9E-324

    return-wide v1

    .line 717
    :cond_0
    const/4 v1, 0x0

    .line 718
    .local v1, "nextIndex":I
    :goto_0
    iget-object v2, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->mediaTimeHistory:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    const/4 v3, 0x0

    if-ge v1, v2, :cond_1

    iget-object v2, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->mediaTimeHistory:Ljava/util/List;

    .line 719
    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [J

    aget-wide v4, v2, v3

    cmp-long v2, v4, p1

    if-gtz v2, :cond_1

    .line 720
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 722
    :cond_1
    const/4 v2, 0x1

    if-nez v1, :cond_2

    .line 723
    iget-object v4, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->mediaTimeHistory:Ljava/util/List;

    invoke-interface {v4, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [J

    aget-wide v2, v3, v2

    return-wide v2

    .line 725
    :cond_2
    iget-object v4, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->mediaTimeHistory:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-ne v1, v4, :cond_3

    .line 726
    iget-object v3, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->mediaTimeHistory:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v4

    sub-int/2addr v4, v2

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [J

    aget-wide v2, v3, v2

    return-wide v2

    .line 728
    :cond_3
    iget-object v4, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->mediaTimeHistory:Ljava/util/List;

    add-int/lit8 v5, v1, -0x1

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [J

    aget-wide v5, v4, v3

    .line 729
    .local v5, "prevRealtimeMs":J
    iget-object v4, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->mediaTimeHistory:Ljava/util/List;

    add-int/lit8 v7, v1, -0x1

    invoke-interface {v4, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [J

    aget-wide v7, v4, v2

    .line 730
    .local v7, "prevMediaTimeMs":J
    iget-object v4, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->mediaTimeHistory:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [J

    aget-wide v3, v4, v3

    .line 731
    .local v3, "nextRealtimeMs":J
    iget-object v9, v0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->mediaTimeHistory:Ljava/util/List;

    invoke-interface {v9, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, [J

    aget-wide v10, v9, v2

    .line 732
    .local v10, "nextMediaTimeMs":J
    sub-long v12, v3, v5

    .line 733
    .local v12, "realtimeDurationMs":J
    const-wide/16 v14, 0x0

    cmp-long v2, v12, v14

    if-nez v2, :cond_4

    .line 734
    return-wide v7

    .line 736
    :cond_4
    sub-long v14, p1, v5

    long-to-float v2, v14

    long-to-float v9, v12

    div-float/2addr v2, v9

    .line 737
    .local v2, "fraction":F
    sub-long v14, v10, v7

    long-to-float v9, v14

    mul-float/2addr v9, v2

    float-to-long v14, v9

    add-long/2addr v14, v7

    return-wide v14
.end method

.method public getNonFatalErrorRate()F
    .locals 4

    .line 1145
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPlayTimeMs()J

    move-result-wide v0

    .line 1146
    .local v0, "playTimeMs":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    goto :goto_0

    :cond_0
    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->nonFatalErrorCount:I

    int-to-float v2, v2

    const/high16 v3, 0x447a0000    # 1000.0f

    mul-float/2addr v2, v3

    long-to-float v3, v0

    div-float/2addr v2, v3

    :goto_0
    return v2
.end method

.method public getPlaybackStateAtTime(J)I
    .locals 5
    .param p1, "realtimeMs"    # J

    .line 695
    const/4 v0, 0x0

    .line 696
    .local v0, "state":I
    iget-object v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->playbackStateHistory:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndPlaybackState;

    .line 697
    .local v2, "timeAndState":Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndPlaybackState;
    iget-object v3, v2, Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndPlaybackState;->eventTime:Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;

    iget-wide v3, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->realtimeMs:J

    cmp-long v3, v3, p1

    if-lez v3, :cond_0

    .line 698
    goto :goto_1

    .line 700
    :cond_0
    iget v0, v2, Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndPlaybackState;->playbackState:I

    .line 701
    .end local v2    # "timeAndState":Landroidx/media3/exoplayer/analytics/PlaybackStats$EventTimeAndPlaybackState;
    goto :goto_0

    .line 702
    :cond_1
    :goto_1
    return v0
.end method

.method public getPlaybackStateDurationMs(I)J
    .locals 3
    .param p1, "playbackState"    # I

    .line 684
    iget-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->playbackStateDurationsMs:[J

    aget-wide v1, v0, p1

    return-wide v1
.end method

.method public getRebufferRate()F
    .locals 4

    .line 1002
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPlayTimeMs()J

    move-result-wide v0

    .line 1003
    .local v0, "playTimeMs":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    goto :goto_0

    :cond_0
    iget v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->totalRebufferCount:I

    int-to-float v2, v2

    const/high16 v3, 0x447a0000    # 1000.0f

    mul-float/2addr v2, v3

    long-to-float v3, v0

    div-float/2addr v2, v3

    :goto_0
    return v2
.end method

.method public getRebufferTimeRatio()F
    .locals 4

    .line 983
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPlayAndWaitTimeMs()J

    move-result-wide v0

    .line 984
    .local v0, "playAndWaitTimeMs":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalRebufferTimeMs()J

    move-result-wide v2

    long-to-float v2, v2

    long-to-float v3, v0

    div-float/2addr v2, v3

    :goto_0
    return v2
.end method

.method public getSeekTimeRatio()F
    .locals 4

    .line 993
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPlayAndWaitTimeMs()J

    move-result-wide v0

    .line 994
    .local v0, "playAndWaitTimeMs":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalSeekTimeMs()J

    move-result-wide v2

    long-to-float v2, v2

    long-to-float v3, v0

    div-float/2addr v2, v3

    :goto_0
    return v2
.end method

.method public getTotalElapsedTimeMs()J
    .locals 6

    .line 886
    const-wide/16 v0, 0x0

    .line 887
    .local v0, "totalTimeMs":J
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    const/16 v3, 0x10

    if-ge v2, v3, :cond_0

    .line 888
    iget-object v3, p0, Landroidx/media3/exoplayer/analytics/PlaybackStats;->playbackStateDurationsMs:[J

    aget-wide v4, v3, v2

    add-long/2addr v0, v4

    .line 887
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 890
    .end local v2    # "i":I
    :cond_0
    return-wide v0
.end method

.method public getTotalJoinTimeMs()J
    .locals 2

    .line 755
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getPlaybackStateDurationMs(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getTotalPausedTimeMs()J
    .locals 4

    .line 775
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getPlaybackStateDurationMs(I)J

    move-result-wide v0

    .line 776
    const/4 v2, 0x7

    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getPlaybackStateDurationMs(I)J

    move-result-wide v2

    add-long/2addr v0, v2

    .line 775
    return-wide v0
.end method

.method public getTotalPlayAndWaitTimeMs()J
    .locals 4

    .line 871
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPlayTimeMs()J

    move-result-wide v0

    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalWaitTimeMs()J

    move-result-wide v2

    add-long/2addr v0, v2

    return-wide v0
.end method

.method public getTotalPlayTimeMs()J
    .locals 2

    .line 760
    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getPlaybackStateDurationMs(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getTotalRebufferTimeMs()J
    .locals 2

    .line 794
    const/4 v0, 0x6

    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getPlaybackStateDurationMs(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getTotalSeekTimeMs()J
    .locals 2

    .line 825
    const/4 v0, 0x5

    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getPlaybackStateDurationMs(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getTotalWaitTimeMs()J
    .locals 4

    .line 852
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getPlaybackStateDurationMs(I)J

    move-result-wide v0

    .line 853
    const/4 v2, 0x6

    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getPlaybackStateDurationMs(I)J

    move-result-wide v2

    add-long/2addr v0, v2

    .line 854
    const/4 v2, 0x5

    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getPlaybackStateDurationMs(I)J

    move-result-wide v2

    add-long/2addr v0, v2

    .line 852
    return-wide v0
.end method

.method public getWaitTimeRatio()F
    .locals 4

    .line 963
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalPlayAndWaitTimeMs()J

    move-result-wide v0

    .line 964
    .local v0, "playAndWaitTimeMs":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->getTotalWaitTimeMs()J

    move-result-wide v2

    long-to-float v2, v2

    long-to-float v3, v0

    div-float/2addr v2, v3

    :goto_0
    return v2
.end method
