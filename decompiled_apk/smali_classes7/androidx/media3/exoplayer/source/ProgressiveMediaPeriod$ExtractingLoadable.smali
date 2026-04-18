.class final Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;
.super Ljava/lang/Object;
.source "ProgressiveMediaPeriod.java"

# interfaces
.implements Landroidx/media3/exoplayer/upstream/Loader$Loadable;
.implements Landroidx/media3/exoplayer/source/IcyDataSource$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "ExtractingLoadable"
.end annotation


# instance fields
.field private final dataSource:Landroidx/media3/datasource/StatsDataSource;

.field private dataSpec:Landroidx/media3/datasource/DataSpec;

.field private final extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

.field private icyTrackOutput:Landroidx/media3/extractor/TrackOutput;

.field private volatile loadCanceled:Z

.field private final loadCondition:Landroidx/media3/common/util/ConditionVariable;

.field private final loadTaskId:J

.field private pendingExtractorSeek:Z

.field private final positionHolder:Landroidx/media3/extractor/PositionHolder;

.field private final progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

.field private seekTimeUs:J

.field private seenIcyMetadata:Z

.field final synthetic this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

.field private final uri:Landroid/net/Uri;


# direct methods
.method public constructor <init>(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;Landroid/net/Uri;Landroidx/media3/datasource/DataSource;Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/common/util/ConditionVariable;)V
    .locals 2
    .param p1, "this$0"    # Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "dataSource"    # Landroidx/media3/datasource/DataSource;
    .param p4, "progressiveMediaExtractor"    # Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;
    .param p5, "extractorOutput"    # Landroidx/media3/extractor/ExtractorOutput;
    .param p6, "loadCondition"    # Landroidx/media3/common/util/ConditionVariable;

    .line 1003
    iput-object p1, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1004
    iput-object p2, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->uri:Landroid/net/Uri;

    .line 1005
    new-instance v0, Landroidx/media3/datasource/StatsDataSource;

    invoke-direct {v0, p3}, Landroidx/media3/datasource/StatsDataSource;-><init>(Landroidx/media3/datasource/DataSource;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    .line 1006
    iput-object p4, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

    .line 1007
    iput-object p5, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    .line 1008
    iput-object p6, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->loadCondition:Landroidx/media3/common/util/ConditionVariable;

    .line 1009
    new-instance v0, Landroidx/media3/extractor/PositionHolder;

    invoke-direct {v0}, Landroidx/media3/extractor/PositionHolder;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->positionHolder:Landroidx/media3/extractor/PositionHolder;

    .line 1010
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->pendingExtractorSeek:Z

    .line 1011
    invoke-static {}, Landroidx/media3/exoplayer/source/LoadEventInfo;->getNewId()J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->loadTaskId:J

    .line 1012
    const-wide/16 v0, 0x0

    invoke-direct {p0, v0, v1}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->buildDataSpec(J)Landroidx/media3/datasource/DataSpec;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSpec:Landroidx/media3/datasource/DataSpec;

    .line 1013
    return-void
.end method

.method static synthetic access$100(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;)Landroidx/media3/datasource/StatsDataSource;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;

    .line 979
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    return-object v0
.end method

.method static synthetic access$200(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;)J
    .locals 2
    .param p0, "x0"    # Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;

    .line 979
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->loadTaskId:J

    return-wide v0
.end method

.method static synthetic access$300(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;)Landroidx/media3/datasource/DataSpec;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;

    .line 979
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSpec:Landroidx/media3/datasource/DataSpec;

    return-object v0
.end method

.method static synthetic access$400(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;)J
    .locals 2
    .param p0, "x0"    # Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;

    .line 979
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->seekTimeUs:J

    return-wide v0
.end method

.method static synthetic access$600(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;JJ)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;
    .param p1, "x1"    # J
    .param p3, "x2"    # J

    .line 979
    invoke-direct {p0, p1, p2, p3, p4}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->setLoadPosition(JJ)V

    return-void
.end method

.method private buildDataSpec(J)Landroidx/media3/datasource/DataSpec;
    .locals 2
    .param p1, "position"    # J

    .line 1108
    new-instance v0, Landroidx/media3/datasource/DataSpec$Builder;

    invoke-direct {v0}, Landroidx/media3/datasource/DataSpec$Builder;-><init>()V

    iget-object v1, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->uri:Landroid/net/Uri;

    .line 1109
    invoke-virtual {v0, v1}, Landroidx/media3/datasource/DataSpec$Builder;->setUri(Landroid/net/Uri;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v0

    .line 1110
    invoke-virtual {v0, p1, p2}, Landroidx/media3/datasource/DataSpec$Builder;->setPosition(J)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v0

    iget-object v1, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    .line 1111
    invoke-static {v1}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$1500(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/media3/datasource/DataSpec$Builder;->setKey(Ljava/lang/String;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v0

    .line 1112
    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Landroidx/media3/datasource/DataSpec$Builder;->setFlags(I)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v0

    .line 1114
    invoke-static {}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$1400()Ljava/util/Map;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/media3/datasource/DataSpec$Builder;->setHttpRequestHeaders(Ljava/util/Map;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v0

    .line 1115
    invoke-virtual {v0}, Landroidx/media3/datasource/DataSpec$Builder;->build()Landroidx/media3/datasource/DataSpec;

    move-result-object v0

    .line 1108
    return-object v0
.end method

.method private setLoadPosition(JJ)V
    .locals 1
    .param p1, "position"    # J
    .param p3, "timeUs"    # J

    .line 1119
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->positionHolder:Landroidx/media3/extractor/PositionHolder;

    iput-wide p1, v0, Landroidx/media3/extractor/PositionHolder;->position:J

    .line 1120
    iput-wide p3, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->seekTimeUs:J

    .line 1121
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->pendingExtractorSeek:Z

    .line 1122
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->seenIcyMetadata:Z

    .line 1123
    return-void
.end method


# virtual methods
.method public cancelLoad()V
    .locals 1

    .line 1019
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->loadCanceled:Z

    .line 1020
    return-void
.end method

.method public load()V
    .locals 20
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1024
    move-object/from16 v1, p0

    const/4 v0, 0x0

    move v2, v0

    .line 1025
    .local v2, "result":I
    :goto_0
    if-nez v2, :cond_d

    iget-boolean v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->loadCanceled:Z

    if-nez v0, :cond_d

    .line 1027
    const/4 v3, 0x1

    const-wide/16 v4, -0x1

    :try_start_0
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->positionHolder:Landroidx/media3/extractor/PositionHolder;

    iget-wide v6, v0, Landroidx/media3/extractor/PositionHolder;->position:J

    .line 1028
    .local v6, "position":J
    invoke-direct {v1, v6, v7}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->buildDataSpec(J)Landroidx/media3/datasource/DataSpec;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSpec:Landroidx/media3/datasource/DataSpec;

    .line 1029
    iget-object v8, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    invoke-virtual {v8, v0}, Landroidx/media3/datasource/StatsDataSource;->open(Landroidx/media3/datasource/DataSpec;)J

    move-result-wide v8

    .line 1030
    .local v8, "length":J
    iget-boolean v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->loadCanceled:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_2

    .line 1075
    if-ne v2, v3, :cond_0

    .line 1076
    const/4 v0, 0x0

    move v2, v0

    .end local v2    # "result":I
    .local v0, "result":I
    goto :goto_1

    .line 1077
    .end local v0    # "result":I
    .restart local v2    # "result":I
    :cond_0
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;->getCurrentInputPosition()J

    move-result-wide v10

    cmp-long v0, v10, v4

    if-eqz v0, :cond_1

    .line 1078
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->positionHolder:Landroidx/media3/extractor/PositionHolder;

    iget-object v3, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

    invoke-interface {v3}, Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;->getCurrentInputPosition()J

    move-result-wide v3

    iput-wide v3, v0, Landroidx/media3/extractor/PositionHolder;->position:J

    .line 1080
    :cond_1
    :goto_1
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    invoke-static {v0}, Landroidx/media3/datasource/DataSourceUtil;->closeQuietly(Landroidx/media3/datasource/DataSource;)V

    .line 1031
    goto/16 :goto_7

    .line 1033
    :cond_2
    cmp-long v0, v8, v4

    if-eqz v0, :cond_3

    .line 1034
    add-long/2addr v8, v6

    .line 1035
    :try_start_1
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    invoke-static {v0}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$700(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;)V

    move-wide/from16 v17, v8

    goto :goto_2

    .line 1033
    :cond_3
    move-wide/from16 v17, v8

    .line 1037
    .end local v8    # "length":J
    .local v17, "length":J
    :goto_2
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    iget-object v8, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    invoke-virtual {v8}, Landroidx/media3/datasource/StatsDataSource;->getResponseHeaders()Ljava/util/Map;

    move-result-object v8

    invoke-static {v8}, Landroidx/media3/extractor/metadata/icy/IcyHeaders;->parse(Ljava/util/Map;)Landroidx/media3/extractor/metadata/icy/IcyHeaders;

    move-result-object v8

    invoke-static {v0, v8}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$802(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;Landroidx/media3/extractor/metadata/icy/IcyHeaders;)Landroidx/media3/extractor/metadata/icy/IcyHeaders;

    .line 1038
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    .line 1039
    .local v0, "extractorDataSource":Landroidx/media3/datasource/DataSource;
    iget-object v8, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    invoke-static {v8}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$800(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;)Landroidx/media3/extractor/metadata/icy/IcyHeaders;

    move-result-object v8

    if-eqz v8, :cond_4

    iget-object v8, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    invoke-static {v8}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$800(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;)Landroidx/media3/extractor/metadata/icy/IcyHeaders;

    move-result-object v8

    iget v8, v8, Landroidx/media3/extractor/metadata/icy/IcyHeaders;->metadataInterval:I

    const/4 v9, -0x1

    if-eq v8, v9, :cond_4

    .line 1040
    new-instance v8, Landroidx/media3/exoplayer/source/IcyDataSource;

    iget-object v9, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    iget-object v10, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    invoke-static {v10}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$800(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;)Landroidx/media3/extractor/metadata/icy/IcyHeaders;

    move-result-object v10

    iget v10, v10, Landroidx/media3/extractor/metadata/icy/IcyHeaders;->metadataInterval:I

    invoke-direct {v8, v9, v10, v1}, Landroidx/media3/exoplayer/source/IcyDataSource;-><init>(Landroidx/media3/datasource/DataSource;ILandroidx/media3/exoplayer/source/IcyDataSource$Listener;)V

    move-object v0, v8

    .line 1041
    iget-object v8, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    invoke-virtual {v8}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->icyTrack()Landroidx/media3/extractor/TrackOutput;

    move-result-object v8

    iput-object v8, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->icyTrackOutput:Landroidx/media3/extractor/TrackOutput;

    .line 1042
    invoke-static {}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$900()Landroidx/media3/common/Format;

    move-result-object v9

    invoke-interface {v8, v9}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    move-object/from16 v19, v0

    goto :goto_3

    .line 1044
    :cond_4
    move-object/from16 v19, v0

    .end local v0    # "extractorDataSource":Landroidx/media3/datasource/DataSource;
    .local v19, "extractorDataSource":Landroidx/media3/datasource/DataSource;
    :goto_3
    iget-object v8, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

    iget-object v10, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->uri:Landroid/net/Uri;

    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    .line 1047
    invoke-virtual {v0}, Landroidx/media3/datasource/StatsDataSource;->getResponseHeaders()Ljava/util/Map;

    move-result-object v11

    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    .line 1044
    move-object/from16 v9, v19

    move-wide v12, v6

    move-wide/from16 v14, v17

    move-object/from16 v16, v0

    invoke-interface/range {v8 .. v16}, Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;->init(Landroidx/media3/common/DataReader;Landroid/net/Uri;Ljava/util/Map;JJLandroidx/media3/extractor/ExtractorOutput;)V

    .line 1052
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    invoke-static {v0}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$800(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;)Landroidx/media3/extractor/metadata/icy/IcyHeaders;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 1053
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;->disableSeekingOnMp3Streams()V

    .line 1056
    :cond_5
    iget-boolean v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->pendingExtractorSeek:Z

    if-eqz v0, :cond_6

    .line 1057
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

    iget-wide v8, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->seekTimeUs:J

    invoke-interface {v0, v6, v7, v8, v9}, Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;->seek(JJ)V

    .line 1058
    const/4 v0, 0x0

    iput-boolean v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->pendingExtractorSeek:Z

    .line 1060
    :cond_6
    :goto_4
    if-nez v2, :cond_8

    iget-boolean v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->loadCanceled:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v0, :cond_8

    .line 1062
    :try_start_2
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->loadCondition:Landroidx/media3/common/util/ConditionVariable;

    invoke-virtual {v0}, Landroidx/media3/common/util/ConditionVariable;->block()V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1065
    nop

    .line 1066
    :try_start_3
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

    iget-object v8, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->positionHolder:Landroidx/media3/extractor/PositionHolder;

    invoke-interface {v0, v8}, Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;->read(Landroidx/media3/extractor/PositionHolder;)I

    move-result v0

    move v2, v0

    .line 1067
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;->getCurrentInputPosition()J

    move-result-wide v8

    .line 1068
    .local v8, "currentInputPosition":J
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    invoke-static {v0}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$1000(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;)J

    move-result-wide v10

    add-long/2addr v10, v6

    cmp-long v0, v8, v10

    if-lez v0, :cond_7

    .line 1069
    move-wide v6, v8

    .line 1070
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->loadCondition:Landroidx/media3/common/util/ConditionVariable;

    invoke-virtual {v0}, Landroidx/media3/common/util/ConditionVariable;->close()Z

    .line 1071
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    invoke-static {v0}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$1200(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;)Landroid/os/Handler;

    move-result-object v0

    iget-object v10, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    invoke-static {v10}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$1100(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;)Ljava/lang/Runnable;

    move-result-object v10

    invoke-virtual {v0, v10}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1073
    .end local v8    # "currentInputPosition":J
    :cond_7
    goto :goto_4

    .line 1063
    :catch_0
    move-exception v0

    .line 1064
    .local v0, "e":Ljava/lang/InterruptedException;
    new-instance v8, Ljava/io/InterruptedIOException;

    invoke-direct {v8}, Ljava/io/InterruptedIOException;-><init>()V

    .end local v2    # "result":I
    throw v8
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1075
    .end local v0    # "e":Ljava/lang/InterruptedException;
    .end local v6    # "position":J
    .end local v17    # "length":J
    .end local v19    # "extractorDataSource":Landroidx/media3/datasource/DataSource;
    .restart local v2    # "result":I
    :cond_8
    if-ne v2, v3, :cond_9

    .line 1076
    const/4 v0, 0x0

    move v2, v0

    .end local v2    # "result":I
    .local v0, "result":I
    goto :goto_5

    .line 1077
    .end local v0    # "result":I
    .restart local v2    # "result":I
    :cond_9
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;->getCurrentInputPosition()J

    move-result-wide v6

    cmp-long v0, v6, v4

    if-eqz v0, :cond_a

    .line 1078
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->positionHolder:Landroidx/media3/extractor/PositionHolder;

    iget-object v3, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

    invoke-interface {v3}, Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;->getCurrentInputPosition()J

    move-result-wide v3

    iput-wide v3, v0, Landroidx/media3/extractor/PositionHolder;->position:J

    .line 1080
    :cond_a
    :goto_5
    iget-object v0, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    invoke-static {v0}, Landroidx/media3/datasource/DataSourceUtil;->closeQuietly(Landroidx/media3/datasource/DataSource;)V

    .line 1081
    goto/16 :goto_0

    .line 1075
    :catchall_0
    move-exception v0

    if-eq v2, v3, :cond_b

    .line 1077
    iget-object v3, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

    invoke-interface {v3}, Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;->getCurrentInputPosition()J

    move-result-wide v6

    cmp-long v3, v6, v4

    if-eqz v3, :cond_c

    .line 1078
    iget-object v3, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->positionHolder:Landroidx/media3/extractor/PositionHolder;

    iget-object v4, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->progressiveMediaExtractor:Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;

    invoke-interface {v4}, Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;->getCurrentInputPosition()J

    move-result-wide v4

    iput-wide v4, v3, Landroidx/media3/extractor/PositionHolder;->position:J

    goto :goto_6

    .line 1076
    :cond_b
    const/4 v2, 0x0

    .line 1080
    :cond_c
    :goto_6
    iget-object v3, v1, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    invoke-static {v3}, Landroidx/media3/datasource/DataSourceUtil;->closeQuietly(Landroidx/media3/datasource/DataSource;)V

    .line 1081
    throw v0

    .line 1083
    :cond_d
    :goto_7
    return-void
.end method

.method public onIcyMetadata(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 11
    .param p1, "metadata"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 1092
    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->seenIcyMetadata:Z

    const/4 v1, 0x1

    if-nez v0, :cond_0

    .line 1093
    iget-wide v2, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->seekTimeUs:J

    move-wide v5, v2

    goto :goto_0

    .line 1094
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->this$0:Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;

    invoke-static {v0, v1}, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;->access$1300(Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod;Z)J

    move-result-wide v2

    iget-wide v4, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->seekTimeUs:J

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    move-wide v5, v2

    :goto_0
    nop

    .line 1095
    .local v5, "timeUs":J
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v0

    .line 1096
    .local v0, "length":I
    iget-object v2, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->icyTrackOutput:Landroidx/media3/extractor/TrackOutput;

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/extractor/TrackOutput;

    .line 1097
    .local v2, "icyTrackOutput":Landroidx/media3/extractor/TrackOutput;
    invoke-interface {v2, p1, v0}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 1098
    const/4 v7, 0x1

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object v4, v2

    move v8, v0

    invoke-interface/range {v4 .. v10}, Landroidx/media3/extractor/TrackOutput;->sampleMetadata(JIIILandroidx/media3/extractor/TrackOutput$CryptoData;)V

    .line 1100
    iput-boolean v1, p0, Landroidx/media3/exoplayer/source/ProgressiveMediaPeriod$ExtractingLoadable;->seenIcyMetadata:Z

    .line 1101
    return-void
.end method
