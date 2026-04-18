.class public final Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;
.super Ljava/lang/Object;
.source "HttpMediaDrmCallback.java"

# interfaces
.implements Landroidx/media3/exoplayer/drm/MediaDrmCallback;


# static fields
.field private static final MAX_MANUAL_REDIRECTS:I = 0x5


# instance fields
.field private final dataSourceFactory:Landroidx/media3/datasource/DataSource$Factory;

.field private final defaultLicenseUrl:Ljava/lang/String;

.field private final forceDefaultLicenseUrl:Z

.field private final keyRequestProperties:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroidx/media3/datasource/DataSource$Factory;)V
    .locals 1
    .param p1, "defaultLicenseUrl"    # Ljava/lang/String;
    .param p2, "dataSourceFactory"    # Landroidx/media3/datasource/DataSource$Factory;

    .line 61
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p2}, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;-><init>(Ljava/lang/String;ZLandroidx/media3/datasource/DataSource$Factory;)V

    .line 62
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZLandroidx/media3/datasource/DataSource$Factory;)V
    .locals 1
    .param p1, "defaultLicenseUrl"    # Ljava/lang/String;
    .param p2, "forceDefaultLicenseUrl"    # Z
    .param p3, "dataSourceFactory"    # Landroidx/media3/datasource/DataSource$Factory;

    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 80
    if-eqz p2, :cond_1

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 81
    iput-object p3, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->dataSourceFactory:Landroidx/media3/datasource/DataSource$Factory;

    .line 82
    iput-object p1, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->defaultLicenseUrl:Ljava/lang/String;

    .line 83
    iput-boolean p2, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->forceDefaultLicenseUrl:Z

    .line 84
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->keyRequestProperties:Ljava/util/Map;

    .line 85
    return-void
.end method

.method private static executePost(Landroidx/media3/datasource/DataSource$Factory;Ljava/lang/String;[BLjava/util/Map;)[B
    .locals 11
    .param p0, "dataSourceFactory"    # Landroidx/media3/datasource/DataSource$Factory;
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "httpBody"    # [B
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/datasource/DataSource$Factory;",
            "Ljava/lang/String;",
            "[B",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)[B"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/drm/MediaDrmCallbackException;
        }
    .end annotation

    .line 170
    .local p3, "requestProperties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Landroidx/media3/datasource/StatsDataSource;

    invoke-interface {p0}, Landroidx/media3/datasource/DataSource$Factory;->createDataSource()Landroidx/media3/datasource/DataSource;

    move-result-object v1

    invoke-direct {v0, v1}, Landroidx/media3/datasource/StatsDataSource;-><init>(Landroidx/media3/datasource/DataSource;)V

    .line 171
    .local v0, "dataSource":Landroidx/media3/datasource/StatsDataSource;
    const/4 v1, 0x0

    .line 172
    .local v1, "manualRedirectCount":I
    new-instance v2, Landroidx/media3/datasource/DataSpec$Builder;

    invoke-direct {v2}, Landroidx/media3/datasource/DataSpec$Builder;-><init>()V

    .line 174
    invoke-virtual {v2, p1}, Landroidx/media3/datasource/DataSpec$Builder;->setUri(Ljava/lang/String;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v2

    .line 175
    invoke-virtual {v2, p3}, Landroidx/media3/datasource/DataSpec$Builder;->setHttpRequestHeaders(Ljava/util/Map;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v2

    .line 176
    const/4 v3, 0x2

    invoke-virtual {v2, v3}, Landroidx/media3/datasource/DataSpec$Builder;->setHttpMethod(I)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v2

    .line 177
    invoke-virtual {v2, p2}, Landroidx/media3/datasource/DataSpec$Builder;->setHttpBody([B)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v2

    .line 178
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroidx/media3/datasource/DataSpec$Builder;->setFlags(I)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v2

    .line 179
    invoke-virtual {v2}, Landroidx/media3/datasource/DataSpec$Builder;->build()Landroidx/media3/datasource/DataSpec;

    move-result-object v2

    .line 180
    .local v2, "dataSpec":Landroidx/media3/datasource/DataSpec;
    move-object v4, v2

    .line 183
    .local v4, "originalDataSpec":Landroidx/media3/datasource/DataSpec;
    :goto_0
    :try_start_0
    new-instance v3, Landroidx/media3/datasource/DataSourceInputStream;

    invoke-direct {v3, v0, v2}, Landroidx/media3/datasource/DataSourceInputStream;-><init>(Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSpec;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 185
    .local v3, "inputStream":Landroidx/media3/datasource/DataSourceInputStream;
    :try_start_1
    invoke-static {v3}, Landroidx/media3/common/util/Util;->toByteArray(Ljava/io/InputStream;)[B

    move-result-object v5
    :try_end_1
    .catch Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 194
    :try_start_2
    invoke-static {v3}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .line 185
    return-object v5

    .line 194
    :catchall_0
    move-exception v5

    goto :goto_1

    .line 186
    :catch_0
    move-exception v5

    .line 187
    .local v5, "e":Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException;
    :try_start_3
    invoke-static {v5, v1}, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->getRedirectUrl(Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException;I)Ljava/lang/String;

    move-result-object v6

    .line 188
    .local v6, "redirectUrl":Ljava/lang/String;
    if-eqz v6, :cond_0

    .line 191
    add-int/lit8 v1, v1, 0x1

    .line 192
    invoke-virtual {v2}, Landroidx/media3/datasource/DataSpec;->buildUpon()Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v7

    invoke-virtual {v7, v6}, Landroidx/media3/datasource/DataSpec$Builder;->setUri(Ljava/lang/String;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v7

    invoke-virtual {v7}, Landroidx/media3/datasource/DataSpec$Builder;->build()Landroidx/media3/datasource/DataSpec;

    move-result-object v7
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-object v2, v7

    .line 194
    .end local v5    # "e":Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException;
    .end local v6    # "redirectUrl":Ljava/lang/String;
    :try_start_4
    invoke-static {v3}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    .line 195
    nop

    .line 196
    .end local v3    # "inputStream":Landroidx/media3/datasource/DataSourceInputStream;
    goto :goto_0

    .line 189
    .restart local v3    # "inputStream":Landroidx/media3/datasource/DataSourceInputStream;
    .restart local v5    # "e":Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException;
    .restart local v6    # "redirectUrl":Ljava/lang/String;
    :cond_0
    nop

    .end local v0    # "dataSource":Landroidx/media3/datasource/StatsDataSource;
    .end local v1    # "manualRedirectCount":I
    .end local v2    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    .end local v3    # "inputStream":Landroidx/media3/datasource/DataSourceInputStream;
    .end local v4    # "originalDataSpec":Landroidx/media3/datasource/DataSpec;
    .end local p0    # "dataSourceFactory":Landroidx/media3/datasource/DataSource$Factory;
    .end local p1    # "url":Ljava/lang/String;
    .end local p2    # "httpBody":[B
    .end local p3    # "requestProperties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_5
    throw v5
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 194
    .end local v5    # "e":Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException;
    .end local v6    # "redirectUrl":Ljava/lang/String;
    .restart local v0    # "dataSource":Landroidx/media3/datasource/StatsDataSource;
    .restart local v1    # "manualRedirectCount":I
    .restart local v2    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    .restart local v3    # "inputStream":Landroidx/media3/datasource/DataSourceInputStream;
    .restart local v4    # "originalDataSpec":Landroidx/media3/datasource/DataSpec;
    .restart local p0    # "dataSourceFactory":Landroidx/media3/datasource/DataSource$Factory;
    .restart local p1    # "url":Ljava/lang/String;
    .restart local p2    # "httpBody":[B
    .restart local p3    # "requestProperties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_1
    :try_start_6
    invoke-static {v3}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 195
    nop

    .end local v0    # "dataSource":Landroidx/media3/datasource/StatsDataSource;
    .end local v1    # "manualRedirectCount":I
    .end local v2    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    .end local v4    # "originalDataSpec":Landroidx/media3/datasource/DataSpec;
    .end local p0    # "dataSourceFactory":Landroidx/media3/datasource/DataSource$Factory;
    .end local p1    # "url":Ljava/lang/String;
    .end local p2    # "httpBody":[B
    .end local p3    # "requestProperties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    throw v5
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1

    .line 197
    .end local v3    # "inputStream":Landroidx/media3/datasource/DataSourceInputStream;
    .restart local v0    # "dataSource":Landroidx/media3/datasource/StatsDataSource;
    .restart local v1    # "manualRedirectCount":I
    .restart local v2    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    .restart local v4    # "originalDataSpec":Landroidx/media3/datasource/DataSpec;
    .restart local p0    # "dataSourceFactory":Landroidx/media3/datasource/DataSource$Factory;
    .restart local p1    # "url":Ljava/lang/String;
    .restart local p2    # "httpBody":[B
    .restart local p3    # "requestProperties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_1
    move-exception v3

    move-object v9, v3

    .line 198
    .local v9, "e":Ljava/lang/Exception;
    new-instance v10, Landroidx/media3/exoplayer/drm/MediaDrmCallbackException;

    .line 200
    invoke-virtual {v0}, Landroidx/media3/datasource/StatsDataSource;->getLastOpenedUri()Landroid/net/Uri;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    move-object v5, v3

    check-cast v5, Landroid/net/Uri;

    .line 201
    invoke-virtual {v0}, Landroidx/media3/datasource/StatsDataSource;->getResponseHeaders()Ljava/util/Map;

    move-result-object v6

    .line 202
    invoke-virtual {v0}, Landroidx/media3/datasource/StatsDataSource;->getBytesRead()J

    move-result-wide v7

    move-object v3, v10

    invoke-direct/range {v3 .. v9}, Landroidx/media3/exoplayer/drm/MediaDrmCallbackException;-><init>(Landroidx/media3/datasource/DataSpec;Landroid/net/Uri;Ljava/util/Map;JLjava/lang/Throwable;)V

    throw v10
.end method

.method private static getRedirectUrl(Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException;I)Ljava/lang/String;
    .locals 6
    .param p0, "exception"    # Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException;
    .param p1, "manualRedirectCount"    # I

    .line 212
    iget v0, p0, Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException;->responseCode:I

    const/16 v1, 0x133

    const/4 v2, 0x0

    if-eq v0, v1, :cond_0

    iget v0, p0, Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException;->responseCode:I

    const/16 v1, 0x134

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x5

    if-ge p1, v0, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    move v0, v2

    .line 215
    .local v0, "manuallyRedirect":Z
    :goto_0
    const/4 v1, 0x0

    if-nez v0, :cond_2

    .line 216
    return-object v1

    .line 218
    :cond_2
    iget-object v3, p0, Landroidx/media3/datasource/HttpDataSource$InvalidResponseCodeException;->headerFields:Ljava/util/Map;

    .line 219
    .local v3, "headerFields":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    if-eqz v3, :cond_3

    .line 220
    const-string v4, "Location"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 221
    .local v4, "locationHeaders":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v4, :cond_3

    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_3

    .line 222
    invoke-interface {v4, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    return-object v1

    .line 225
    .end local v4    # "locationHeaders":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_3
    return-object v1
.end method


# virtual methods
.method public clearAllKeyRequestProperties()V
    .locals 2

    .line 115
    iget-object v0, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->keyRequestProperties:Ljava/util/Map;

    monitor-enter v0

    .line 116
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->keyRequestProperties:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->clear()V

    .line 117
    monitor-exit v0

    .line 118
    return-void

    .line 117
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public clearKeyRequestProperty(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .line 107
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 108
    iget-object v0, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->keyRequestProperties:Ljava/util/Map;

    monitor-enter v0

    .line 109
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->keyRequestProperties:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 110
    monitor-exit v0

    .line 111
    return-void

    .line 110
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public executeKeyRequest(Ljava/util/UUID;Landroidx/media3/exoplayer/drm/ExoMediaDrm$KeyRequest;)[B
    .locals 12
    .param p1, "uuid"    # Ljava/util/UUID;
    .param p2, "request"    # Landroidx/media3/exoplayer/drm/ExoMediaDrm$KeyRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/drm/MediaDrmCallbackException;
        }
    .end annotation

    .line 134
    invoke-virtual {p2}, Landroidx/media3/exoplayer/drm/ExoMediaDrm$KeyRequest;->getLicenseServerUrl()Ljava/lang/String;

    move-result-object v0

    .line 135
    .local v0, "url":Ljava/lang/String;
    iget-boolean v1, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->forceDefaultLicenseUrl:Z

    if-nez v1, :cond_0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 136
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->defaultLicenseUrl:Ljava/lang/String;

    .line 138
    :cond_1
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_5

    .line 146
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 149
    .local v1, "requestProperties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v2, Landroidx/media3/common/C;->PLAYREADY_UUID:Ljava/util/UUID;

    invoke-virtual {v2, p1}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 150
    const-string/jumbo v2, "text/xml"

    goto :goto_0

    .line 151
    :cond_2
    sget-object v2, Landroidx/media3/common/C;->CLEARKEY_UUID:Ljava/util/UUID;

    invoke-virtual {v2, p1}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    const-string v2, "application/json"

    goto :goto_0

    :cond_3
    const-string v2, "application/octet-stream"

    :goto_0
    nop

    .line 152
    .local v2, "contentType":Ljava/lang/String;
    const-string v3, "Content-Type"

    invoke-interface {v1, v3, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 153
    sget-object v3, Landroidx/media3/common/C;->PLAYREADY_UUID:Ljava/util/UUID;

    invoke-virtual {v3, p1}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 154
    const-string v3, "SOAPAction"

    const-string v4, "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense"

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 158
    :cond_4
    iget-object v3, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->keyRequestProperties:Ljava/util/Map;

    monitor-enter v3

    .line 159
    :try_start_0
    iget-object v4, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->keyRequestProperties:Ljava/util/Map;

    invoke-interface {v1, v4}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 160
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 161
    iget-object v3, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->dataSourceFactory:Landroidx/media3/datasource/DataSource$Factory;

    invoke-virtual {p2}, Landroidx/media3/exoplayer/drm/ExoMediaDrm$KeyRequest;->getData()[B

    move-result-object v4

    invoke-static {v3, v0, v4, v1}, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->executePost(Landroidx/media3/datasource/DataSource$Factory;Ljava/lang/String;[BLjava/util/Map;)[B

    move-result-object v3

    return-object v3

    .line 160
    :catchall_0
    move-exception v4

    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v4

    .line 139
    .end local v1    # "requestProperties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "contentType":Ljava/lang/String;
    :cond_5
    new-instance v1, Landroidx/media3/exoplayer/drm/MediaDrmCallbackException;

    new-instance v2, Landroidx/media3/datasource/DataSpec$Builder;

    invoke-direct {v2}, Landroidx/media3/datasource/DataSpec$Builder;-><init>()V

    sget-object v3, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    .line 140
    invoke-virtual {v2, v3}, Landroidx/media3/datasource/DataSpec$Builder;->setUri(Landroid/net/Uri;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v2

    invoke-virtual {v2}, Landroidx/media3/datasource/DataSpec$Builder;->build()Landroidx/media3/datasource/DataSpec;

    move-result-object v6

    sget-object v7, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    .line 142
    invoke-static {}, Lcom/google/common/collect/ImmutableMap;->of()Lcom/google/common/collect/ImmutableMap;

    move-result-object v8

    const-wide/16 v9, 0x0

    new-instance v11, Ljava/lang/IllegalStateException;

    const-string v2, "No license URL"

    invoke-direct {v11, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    move-object v5, v1

    invoke-direct/range {v5 .. v11}, Landroidx/media3/exoplayer/drm/MediaDrmCallbackException;-><init>(Landroidx/media3/datasource/DataSpec;Landroid/net/Uri;Ljava/util/Map;JLjava/lang/Throwable;)V

    throw v1
.end method

.method public executeProvisionRequest(Ljava/util/UUID;Landroidx/media3/exoplayer/drm/ExoMediaDrm$ProvisionRequest;)[B
    .locals 4
    .param p1, "uuid"    # Ljava/util/UUID;
    .param p2, "request"    # Landroidx/media3/exoplayer/drm/ExoMediaDrm$ProvisionRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/drm/MediaDrmCallbackException;
        }
    .end annotation

    .line 123
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 124
    invoke-virtual {p2}, Landroidx/media3/exoplayer/drm/ExoMediaDrm$ProvisionRequest;->getDefaultUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&signedRequest="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p2}, Landroidx/media3/exoplayer/drm/ExoMediaDrm$ProvisionRequest;->getData()[B

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Util;->fromUtf8Bytes([B)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 125
    .local v0, "url":Ljava/lang/String;
    iget-object v1, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->dataSourceFactory:Landroidx/media3/datasource/DataSource$Factory;

    .line 129
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v2

    .line 125
    const/4 v3, 0x0

    invoke-static {v1, v0, v3, v2}, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->executePost(Landroidx/media3/datasource/DataSource$Factory;Ljava/lang/String;[BLjava/util/Map;)[B

    move-result-object v1

    return-object v1
.end method

.method public setKeyRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .line 94
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 95
    invoke-static {p2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    iget-object v0, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->keyRequestProperties:Ljava/util/Map;

    monitor-enter v0

    .line 97
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/drm/HttpMediaDrmCallback;->keyRequestProperties:Ljava/util/Map;

    invoke-interface {v1, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    monitor-exit v0

    .line 99
    return-void

    .line 98
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method
