.class final Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;
.super Ljava/lang/Object;
.source "HttpEngineDataSource.java"

# interfaces
.implements Landroid/net/http/UrlRequest$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/datasource/HttpEngineDataSource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "UrlRequestCallback"
.end annotation


# instance fields
.field private volatile isClosed:Z

.field final synthetic this$0:Landroidx/media3/datasource/HttpEngineDataSource;


# direct methods
.method private constructor <init>(Landroidx/media3/datasource/HttpEngineDataSource;)V
    .locals 0

    .line 1008
    iput-object p1, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1010
    const/4 p1, 0x0

    iput-boolean p1, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->isClosed:Z

    return-void
.end method

.method synthetic constructor <init>(Landroidx/media3/datasource/HttpEngineDataSource;Landroidx/media3/datasource/HttpEngineDataSource$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/media3/datasource/HttpEngineDataSource;
    .param p2, "x1"    # Landroidx/media3/datasource/HttpEngineDataSource$1;

    .line 1008
    invoke-direct {p0, p1}, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;-><init>(Landroidx/media3/datasource/HttpEngineDataSource;)V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 1

    .line 1013
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->isClosed:Z

    .line 1014
    return-void
.end method

.method public declared-synchronized onCanceled(Landroid/net/http/UrlRequest;Landroid/net/http/UrlResponseInfo;)V
    .locals 0
    .param p1, "request"    # Landroid/net/http/UrlRequest;
    .param p2, "info"    # Landroid/net/http/UrlResponseInfo;

    monitor-enter p0

    .line 1146
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized onFailed(Landroid/net/http/UrlRequest;Landroid/net/http/UrlResponseInfo;Landroid/net/http/HttpException;)V
    .locals 2
    .param p1, "request"    # Landroid/net/http/UrlRequest;
    .param p2, "info"    # Landroid/net/http/UrlResponseInfo;
    .param p3, "error"    # Landroid/net/http/HttpException;

    monitor-enter p0

    .line 1130
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->isClosed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 1131
    monitor-exit p0

    return-void

    .line 1133
    :cond_0
    :try_start_1
    instance-of v0, p3, Landroid/net/http/NetworkException;

    if-eqz v0, :cond_1

    move-object v0, p3

    check-cast v0, Landroid/net/http/NetworkException;

    .line 1134
    invoke-virtual {v0}, Landroid/net/http/NetworkException;->getErrorCode()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 1136
    iget-object v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    new-instance v1, Ljava/net/UnknownHostException;

    invoke-direct {v1}, Ljava/net/UnknownHostException;-><init>()V

    invoke-static {v0, v1}, Landroidx/media3/datasource/HttpEngineDataSource;->access$202(Landroidx/media3/datasource/HttpEngineDataSource;Ljava/io/IOException;)Ljava/io/IOException;

    goto :goto_0

    .line 1138
    .end local p0    # "this":Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;
    :cond_1
    iget-object v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v0, p3}, Landroidx/media3/datasource/HttpEngineDataSource;->access$202(Landroidx/media3/datasource/HttpEngineDataSource;Ljava/io/IOException;)Ljava/io/IOException;

    .line 1140
    :goto_0
    iget-object v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v0}, Landroidx/media3/datasource/HttpEngineDataSource;->access$300(Landroidx/media3/datasource/HttpEngineDataSource;)Landroidx/media3/common/util/ConditionVariable;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/common/util/ConditionVariable;->open()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1141
    monitor-exit p0

    return-void

    .line 1129
    .end local p1    # "request":Landroid/net/http/UrlRequest;
    .end local p2    # "info":Landroid/net/http/UrlResponseInfo;
    .end local p3    # "error":Landroid/net/http/HttpException;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized onReadCompleted(Landroid/net/http/UrlRequest;Landroid/net/http/UrlResponseInfo;Ljava/nio/ByteBuffer;)V
    .locals 1
    .param p1, "request"    # Landroid/net/http/UrlRequest;
    .param p2, "info"    # Landroid/net/http/UrlResponseInfo;
    .param p3, "buffer"    # Ljava/nio/ByteBuffer;

    monitor-enter p0

    .line 1112
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->isClosed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 1113
    monitor-exit p0

    return-void

    .line 1115
    :cond_0
    :try_start_1
    iget-object v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v0}, Landroidx/media3/datasource/HttpEngineDataSource;->access$300(Landroidx/media3/datasource/HttpEngineDataSource;)Landroidx/media3/common/util/ConditionVariable;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/common/util/ConditionVariable;->open()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1116
    monitor-exit p0

    return-void

    .line 1111
    .end local p0    # "this":Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;
    .end local p1    # "request":Landroid/net/http/UrlRequest;
    .end local p2    # "info":Landroid/net/http/UrlResponseInfo;
    .end local p3    # "buffer":Ljava/nio/ByteBuffer;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized onRedirectReceived(Landroid/net/http/UrlRequest;Landroid/net/http/UrlResponseInfo;Ljava/lang/String;)V
    .locals 11
    .param p1, "request"    # Landroid/net/http/UrlRequest;
    .param p2, "info"    # Landroid/net/http/UrlResponseInfo;
    .param p3, "newLocationUrl"    # Ljava/lang/String;

    monitor-enter p0

    .line 1019
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->isClosed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 1020
    monitor-exit p0

    return-void

    .line 1022
    :cond_0
    :try_start_1
    iget-object v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v0}, Landroidx/media3/datasource/HttpEngineDataSource;->access$100(Landroidx/media3/datasource/HttpEngineDataSource;)Landroidx/media3/datasource/DataSpec;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/datasource/DataSpec;

    .line 1023
    .local v0, "dataSpec":Landroidx/media3/datasource/DataSpec;
    invoke-virtual {p2}, Landroid/net/http/UrlResponseInfo;->getHttpStatusCode()I

    move-result v1

    move v8, v1

    .line 1024
    .local v8, "responseCode":I
    iget v1, v0, Landroidx/media3/datasource/DataSpec;->httpMethod:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_2

    .line 1027
    const/16 v1, 0x133

    if-eq v8, v1, :cond_1

    const/16 v1, 0x134

    if-ne v8, v1, :cond_2

    .line 1028
    :cond_1
    iget-object v9, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    new-instance v10, Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException;

    .line 1031
    invoke-virtual {p2}, Landroid/net/http/UrlResponseInfo;->getHttpStatusText()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    .line 1033
    invoke-virtual {p2}, Landroid/net/http/UrlResponseInfo;->getHeaders()Landroid/net/http/HeaderBlock;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/http/HeaderBlock;->getAsMap()Ljava/util/Map;

    move-result-object v5

    sget-object v7, Landroidx/media3/common/util/Util;->EMPTY_BYTE_ARRAY:[B

    move-object v1, v10

    move v2, v8

    move-object v6, v0

    invoke-direct/range {v1 .. v7}, Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException;-><init>(ILjava/lang/String;Ljava/io/IOException;Ljava/util/Map;Landroidx/media3/datasource/DataSpec;[B)V

    .line 1028
    invoke-static {v9, v10}, Landroidx/media3/datasource/HttpEngineDataSource;->access$202(Landroidx/media3/datasource/HttpEngineDataSource;Ljava/io/IOException;)Ljava/io/IOException;

    .line 1036
    iget-object v1, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v1}, Landroidx/media3/datasource/HttpEngineDataSource;->access$300(Landroidx/media3/datasource/HttpEngineDataSource;)Landroidx/media3/common/util/ConditionVariable;

    move-result-object v1

    invoke-virtual {v1}, Landroidx/media3/common/util/ConditionVariable;->open()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1037
    monitor-exit p0

    return-void

    .line 1040
    .end local p0    # "this":Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;
    :cond_2
    :try_start_2
    iget-object v1, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v1}, Landroidx/media3/datasource/HttpEngineDataSource;->access$400(Landroidx/media3/datasource/HttpEngineDataSource;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1041
    iget-object v1, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v1}, Landroidx/media3/datasource/HttpEngineDataSource;->access$500(Landroidx/media3/datasource/HttpEngineDataSource;)V

    .line 1044
    :cond_3
    iget-object v1, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    .line 1045
    invoke-static {v1}, Landroidx/media3/datasource/HttpEngineDataSource;->access$600(Landroidx/media3/datasource/HttpEngineDataSource;)Z

    move-result v1

    const/4 v3, 0x1

    if-eqz v1, :cond_4

    iget v1, v0, Landroidx/media3/datasource/DataSpec;->httpMethod:I

    if-ne v1, v2, :cond_4

    const/16 v1, 0x12e

    if-ne v8, v1, :cond_4

    move v1, v3

    goto :goto_0

    :cond_4
    const/4 v1, 0x0

    .line 1051
    .local v1, "shouldKeepPost":Z
    :goto_0
    if-nez v1, :cond_5

    iget-object v4, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v4}, Landroidx/media3/datasource/HttpEngineDataSource;->access$700(Landroidx/media3/datasource/HttpEngineDataSource;)Z

    move-result v4

    if-nez v4, :cond_5

    .line 1052
    invoke-virtual {p1}, Landroid/net/http/UrlRequest;->followRedirect()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1053
    monitor-exit p0

    return-void

    .line 1057
    :cond_5
    nop

    .line 1058
    :try_start_3
    invoke-virtual {p2}, Landroid/net/http/UrlResponseInfo;->getHeaders()Landroid/net/http/HeaderBlock;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/http/HeaderBlock;->getAsMap()Ljava/util/Map;

    move-result-object v4

    const-string v5, "Set-Cookie"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Landroidx/media3/datasource/HttpEngineDataSource;->access$800(Ljava/util/List;)Ljava/lang/String;

    move-result-object v4

    .line 1059
    .local v4, "cookieHeadersValue":Ljava/lang/String;
    if-nez v1, :cond_6

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 1060
    invoke-virtual {p1}, Landroid/net/http/UrlRequest;->followRedirect()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1061
    monitor-exit p0

    return-void

    .line 1064
    :cond_6
    :try_start_4
    invoke-virtual {p1}, Landroid/net/http/UrlRequest;->cancel()V

    .line 1066
    if-nez v1, :cond_7

    iget v5, v0, Landroidx/media3/datasource/DataSpec;->httpMethod:I

    if-ne v5, v2, :cond_7

    .line 1069
    nop

    .line 1071
    invoke-virtual {v0}, Landroidx/media3/datasource/DataSpec;->buildUpon()Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v2

    .line 1072
    invoke-virtual {v2, p3}, Landroidx/media3/datasource/DataSpec$Builder;->setUri(Ljava/lang/String;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v2

    .line 1073
    invoke-virtual {v2, v3}, Landroidx/media3/datasource/DataSpec$Builder;->setHttpMethod(I)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v2

    .line 1074
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroidx/media3/datasource/DataSpec$Builder;->setHttpBody([B)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v2

    .line 1075
    invoke-virtual {v2}, Landroidx/media3/datasource/DataSpec$Builder;->build()Landroidx/media3/datasource/DataSpec;

    move-result-object v2

    .local v2, "redirectUrlDataSpec":Landroidx/media3/datasource/DataSpec;
    goto :goto_1

    .line 1077
    .end local v2    # "redirectUrlDataSpec":Landroidx/media3/datasource/DataSpec;
    :cond_7
    invoke-static {p3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroidx/media3/datasource/DataSpec;->withUri(Landroid/net/Uri;)Landroidx/media3/datasource/DataSpec;

    move-result-object v2

    .line 1079
    .restart local v2    # "redirectUrlDataSpec":Landroidx/media3/datasource/DataSpec;
    :goto_1
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_8

    .line 1080
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 1081
    .local v3, "requestHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v5, v0, Landroidx/media3/datasource/DataSpec;->httpRequestHeaders:Ljava/util/Map;

    invoke-interface {v3, v5}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 1082
    const-string v5, "Cookie"

    invoke-interface {v3, v5, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1083
    nop

    .line 1084
    invoke-virtual {v2}, Landroidx/media3/datasource/DataSpec;->buildUpon()Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v5

    invoke-virtual {v5, v3}, Landroidx/media3/datasource/DataSpec$Builder;->setHttpRequestHeaders(Ljava/util/Map;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v5

    invoke-virtual {v5}, Landroidx/media3/datasource/DataSpec$Builder;->build()Landroidx/media3/datasource/DataSpec;

    move-result-object v5
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-object v2, v5

    .line 1088
    .end local v3    # "requestHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_8
    :try_start_5
    iget-object v3, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v3, v2}, Landroidx/media3/datasource/HttpEngineDataSource;->access$900(Landroidx/media3/datasource/HttpEngineDataSource;Landroidx/media3/datasource/DataSpec;)Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestWrapper;

    move-result-object v3
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 1092
    .local v3, "redirectUrlRequestWrapper":Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestWrapper;
    nop

    .line 1093
    :try_start_6
    iget-object v5, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v5}, Landroidx/media3/datasource/HttpEngineDataSource;->access$1000(Landroidx/media3/datasource/HttpEngineDataSource;)Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestWrapper;

    move-result-object v5

    if-eqz v5, :cond_9

    .line 1094
    iget-object v5, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v5}, Landroidx/media3/datasource/HttpEngineDataSource;->access$1000(Landroidx/media3/datasource/HttpEngineDataSource;)Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestWrapper;

    move-result-object v5

    invoke-virtual {v5}, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestWrapper;->close()V

    .line 1096
    :cond_9
    iget-object v5, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v5, v3}, Landroidx/media3/datasource/HttpEngineDataSource;->access$1002(Landroidx/media3/datasource/HttpEngineDataSource;Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestWrapper;)Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestWrapper;

    .line 1097
    iget-object v5, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v5}, Landroidx/media3/datasource/HttpEngineDataSource;->access$1000(Landroidx/media3/datasource/HttpEngineDataSource;)Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestWrapper;

    move-result-object v5

    invoke-virtual {v5}, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestWrapper;->start()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 1098
    monitor-exit p0

    return-void

    .line 1089
    .end local v3    # "redirectUrlRequestWrapper":Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestWrapper;
    :catch_0
    move-exception v3

    .line 1090
    .local v3, "e":Ljava/io/IOException;
    :try_start_7
    iget-object v5, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v5, v3}, Landroidx/media3/datasource/HttpEngineDataSource;->access$202(Landroidx/media3/datasource/HttpEngineDataSource;Ljava/io/IOException;)Ljava/io/IOException;
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 1091
    monitor-exit p0

    return-void

    .line 1018
    .end local v0    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    .end local v1    # "shouldKeepPost":Z
    .end local v2    # "redirectUrlDataSpec":Landroidx/media3/datasource/DataSpec;
    .end local v3    # "e":Ljava/io/IOException;
    .end local v4    # "cookieHeadersValue":Ljava/lang/String;
    .end local v8    # "responseCode":I
    .end local p1    # "request":Landroid/net/http/UrlRequest;
    .end local p2    # "info":Landroid/net/http/UrlResponseInfo;
    .end local p3    # "newLocationUrl":Ljava/lang/String;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized onResponseStarted(Landroid/net/http/UrlRequest;Landroid/net/http/UrlResponseInfo;)V
    .locals 1
    .param p1, "request"    # Landroid/net/http/UrlRequest;
    .param p2, "info"    # Landroid/net/http/UrlResponseInfo;

    monitor-enter p0

    .line 1102
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->isClosed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 1103
    monitor-exit p0

    return-void

    .line 1105
    :cond_0
    :try_start_1
    iget-object v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v0, p2}, Landroidx/media3/datasource/HttpEngineDataSource;->access$1102(Landroidx/media3/datasource/HttpEngineDataSource;Landroid/net/http/UrlResponseInfo;)Landroid/net/http/UrlResponseInfo;

    .line 1106
    iget-object v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v0}, Landroidx/media3/datasource/HttpEngineDataSource;->access$300(Landroidx/media3/datasource/HttpEngineDataSource;)Landroidx/media3/common/util/ConditionVariable;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/common/util/ConditionVariable;->open()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1107
    monitor-exit p0

    return-void

    .line 1101
    .end local p0    # "this":Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;
    .end local p1    # "request":Landroid/net/http/UrlRequest;
    .end local p2    # "info":Landroid/net/http/UrlResponseInfo;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized onSucceeded(Landroid/net/http/UrlRequest;Landroid/net/http/UrlResponseInfo;)V
    .locals 2
    .param p1, "request"    # Landroid/net/http/UrlRequest;
    .param p2, "info"    # Landroid/net/http/UrlResponseInfo;

    monitor-enter p0

    .line 1120
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->isClosed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 1121
    monitor-exit p0

    return-void

    .line 1123
    :cond_0
    :try_start_1
    iget-object v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Landroidx/media3/datasource/HttpEngineDataSource;->access$1202(Landroidx/media3/datasource/HttpEngineDataSource;Z)Z

    .line 1124
    iget-object v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;->this$0:Landroidx/media3/datasource/HttpEngineDataSource;

    invoke-static {v0}, Landroidx/media3/datasource/HttpEngineDataSource;->access$300(Landroidx/media3/datasource/HttpEngineDataSource;)Landroidx/media3/common/util/ConditionVariable;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/common/util/ConditionVariable;->open()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1125
    monitor-exit p0

    return-void

    .line 1119
    .end local p0    # "this":Landroidx/media3/datasource/HttpEngineDataSource$UrlRequestCallback;
    .end local p1    # "request":Landroid/net/http/UrlRequest;
    .end local p2    # "info":Landroid/net/http/UrlResponseInfo;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method
