.class public final Landroidx/media3/datasource/ContentDataSource;
.super Landroidx/media3/datasource/BaseDataSource;
.source "ContentDataSource.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;
    }
.end annotation


# instance fields
.field private assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

.field private bytesRemaining:J

.field private inputStream:Ljava/io/FileInputStream;

.field private opened:Z

.field private final resolver:Landroid/content/ContentResolver;

.field private uri:Landroid/net/Uri;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 70
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/datasource/BaseDataSource;-><init>(Z)V

    .line 71
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/datasource/ContentDataSource;->resolver:Landroid/content/ContentResolver;

    .line 72
    return-void
.end method


# virtual methods
.method public close()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;
        }
    .end annotation

    .line 205
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/datasource/ContentDataSource;->uri:Landroid/net/Uri;

    .line 207
    const/16 v1, 0x7d0

    const/4 v2, 0x0

    :try_start_0
    iget-object v3, p0, Landroidx/media3/datasource/ContentDataSource;->inputStream:Ljava/io/FileInputStream;

    if-eqz v3, :cond_0

    .line 208
    invoke-virtual {v3}, Ljava/io/FileInputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 213
    :cond_0
    iput-object v0, p0, Landroidx/media3/datasource/ContentDataSource;->inputStream:Ljava/io/FileInputStream;

    .line 215
    :try_start_1
    iget-object v3, p0, Landroidx/media3/datasource/ContentDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    if-eqz v3, :cond_1

    .line 216
    invoke-virtual {v3}, Landroid/content/res/AssetFileDescriptor;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 221
    :cond_1
    iput-object v0, p0, Landroidx/media3/datasource/ContentDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    .line 222
    iget-boolean v0, p0, Landroidx/media3/datasource/ContentDataSource;->opened:Z

    if-eqz v0, :cond_2

    .line 223
    iput-boolean v2, p0, Landroidx/media3/datasource/ContentDataSource;->opened:Z

    .line 224
    invoke-virtual {p0}, Landroidx/media3/datasource/ContentDataSource;->transferEnded()V

    .line 227
    :cond_2
    nop

    .line 228
    return-void

    .line 221
    :catchall_0
    move-exception v1

    goto :goto_0

    .line 218
    :catch_0
    move-exception v3

    .line 219
    .local v3, "e":Ljava/io/IOException;
    :try_start_2
    new-instance v4, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;

    invoke-direct {v4, v3, v1}, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;-><init>(Ljava/io/IOException;I)V

    throw v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 221
    .end local v3    # "e":Ljava/io/IOException;
    :goto_0
    iput-object v0, p0, Landroidx/media3/datasource/ContentDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    .line 222
    iget-boolean v0, p0, Landroidx/media3/datasource/ContentDataSource;->opened:Z

    if-eqz v0, :cond_3

    .line 223
    iput-boolean v2, p0, Landroidx/media3/datasource/ContentDataSource;->opened:Z

    .line 224
    invoke-virtual {p0}, Landroidx/media3/datasource/ContentDataSource;->transferEnded()V

    .line 226
    :cond_3
    throw v1

    .line 213
    :catchall_1
    move-exception v3

    goto :goto_1

    .line 210
    :catch_1
    move-exception v3

    .line 211
    .restart local v3    # "e":Ljava/io/IOException;
    :try_start_3
    new-instance v4, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;

    invoke-direct {v4, v3, v1}, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;-><init>(Ljava/io/IOException;I)V

    throw v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 213
    .end local v3    # "e":Ljava/io/IOException;
    :goto_1
    iput-object v0, p0, Landroidx/media3/datasource/ContentDataSource;->inputStream:Ljava/io/FileInputStream;

    .line 215
    :try_start_4
    iget-object v4, p0, Landroidx/media3/datasource/ContentDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    if-eqz v4, :cond_4

    .line 216
    invoke-virtual {v4}, Landroid/content/res/AssetFileDescriptor;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 221
    :cond_4
    iput-object v0, p0, Landroidx/media3/datasource/ContentDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    .line 222
    iget-boolean v0, p0, Landroidx/media3/datasource/ContentDataSource;->opened:Z

    if-eqz v0, :cond_5

    .line 223
    iput-boolean v2, p0, Landroidx/media3/datasource/ContentDataSource;->opened:Z

    .line 224
    invoke-virtual {p0}, Landroidx/media3/datasource/ContentDataSource;->transferEnded()V

    .line 227
    :cond_5
    throw v3

    .line 221
    :catchall_2
    move-exception v1

    goto :goto_2

    .line 218
    :catch_2
    move-exception v3

    .line 219
    .restart local v3    # "e":Ljava/io/IOException;
    :try_start_5
    new-instance v4, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;

    invoke-direct {v4, v3, v1}, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;-><init>(Ljava/io/IOException;I)V

    throw v4
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 221
    .end local v3    # "e":Ljava/io/IOException;
    :goto_2
    iput-object v0, p0, Landroidx/media3/datasource/ContentDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    .line 222
    iget-boolean v0, p0, Landroidx/media3/datasource/ContentDataSource;->opened:Z

    if-eqz v0, :cond_6

    .line 223
    iput-boolean v2, p0, Landroidx/media3/datasource/ContentDataSource;->opened:Z

    .line 224
    invoke-virtual {p0}, Landroidx/media3/datasource/ContentDataSource;->transferEnded()V

    .line 226
    :cond_6
    throw v1
.end method

.method public getUri()Landroid/net/Uri;
    .locals 1

    .line 199
    iget-object v0, p0, Landroidx/media3/datasource/ContentDataSource;->uri:Landroid/net/Uri;

    return-object v0
.end method

.method public open(Landroidx/media3/datasource/DataSpec;)J
    .locals 23
    .param p1, "dataSpec"    # Landroidx/media3/datasource/DataSpec;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;
        }
    .end annotation

    .line 78
    move-object/from16 v1, p0

    move-object/from16 v2, p1

    :try_start_0
    iget-object v0, v2, Landroidx/media3/datasource/DataSpec;->uri:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->normalizeScheme()Landroid/net/Uri;

    move-result-object v0

    .line 79
    .local v0, "uri":Landroid/net/Uri;
    iput-object v0, v1, Landroidx/media3/datasource/ContentDataSource;->uri:Landroid/net/Uri;

    .line 81
    invoke-virtual/range {p0 .. p1}, Landroidx/media3/datasource/ContentDataSource;->transferInitializing(Landroidx/media3/datasource/DataSpec;)V

    .line 84
    const-string v4, "content"

    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    const/4 v5, 0x1

    if-eqz v4, :cond_0

    .line 85
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 87
    .local v4, "providerOptions":Landroid/os/Bundle;
    const-string v6, "android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT"

    invoke-virtual {v4, v6, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 88
    iget-object v6, v1, Landroidx/media3/datasource/ContentDataSource;->resolver:Landroid/content/ContentResolver;

    const-string v7, "*/*"

    .line 89
    invoke-virtual {v6, v0, v7, v4}, Landroid/content/ContentResolver;->openTypedAssetFileDescriptor(Landroid/net/Uri;Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/res/AssetFileDescriptor;

    move-result-object v6

    move-object v4, v6

    .line 90
    .local v4, "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    goto :goto_0

    .line 93
    .end local v4    # "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    :cond_0
    iget-object v4, v1, Landroidx/media3/datasource/ContentDataSource;->resolver:Landroid/content/ContentResolver;

    const-string/jumbo v6, "r"

    invoke-virtual {v4, v0, v6}, Landroid/content/ContentResolver;->openAssetFileDescriptor(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;

    move-result-object v4

    .line 95
    .restart local v4    # "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    :goto_0
    iput-object v4, v1, Landroidx/media3/datasource/ContentDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    .line 96
    if-eqz v4, :cond_b

    .line 103
    invoke-virtual {v4}, Landroid/content/res/AssetFileDescriptor;->getLength()J

    move-result-wide v6

    .line 104
    .local v6, "assetFileDescriptorLength":J
    new-instance v8, Ljava/io/FileInputStream;

    invoke-virtual {v4}, Landroid/content/res/AssetFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/io/FileInputStream;-><init>(Ljava/io/FileDescriptor;)V

    .line 105
    .local v8, "inputStream":Ljava/io/FileInputStream;
    iput-object v8, v1, Landroidx/media3/datasource/ContentDataSource;->inputStream:Ljava/io/FileInputStream;

    .line 113
    const-wide/16 v9, -0x1

    cmp-long v11, v6, v9

    const/16 v12, 0x7d8

    const/4 v13, 0x0

    if-eqz v11, :cond_2

    iget-wide v14, v2, Landroidx/media3/datasource/DataSpec;->position:J

    cmp-long v11, v14, v6

    if-gtz v11, :cond_1

    goto :goto_1

    .line 115
    :cond_1
    new-instance v5, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;

    invoke-direct {v5, v13, v12}, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;-><init>(Ljava/io/IOException;I)V

    .end local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    throw v5

    .line 118
    .restart local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    :cond_2
    :goto_1
    invoke-virtual {v4}, Landroid/content/res/AssetFileDescriptor;->getStartOffset()J

    move-result-wide v14

    .line 119
    .local v14, "assetFileDescriptorOffset":J
    move-object/from16 v16, v4

    .end local v4    # "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    .local v16, "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    iget-wide v3, v2, Landroidx/media3/datasource/DataSpec;->position:J

    add-long/2addr v3, v14

    .line 120
    invoke-virtual {v8, v3, v4}, Ljava/io/FileInputStream;->skip(J)J

    move-result-wide v3

    sub-long/2addr v3, v14

    .line 122
    .local v3, "skipped":J
    iget-wide v11, v2, Landroidx/media3/datasource/DataSpec;->position:J

    cmp-long v11, v3, v11

    if-nez v11, :cond_a

    .line 128
    cmp-long v11, v6, v9

    const-wide/16 v17, 0x0

    if-nez v11, :cond_5

    .line 131
    invoke-virtual {v8}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v11

    .line 132
    .local v11, "channel":Ljava/nio/channels/FileChannel;
    invoke-virtual {v11}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v19

    .line 133
    .local v19, "channelSize":J
    cmp-long v12, v19, v17

    if-nez v12, :cond_3

    .line 134
    iput-wide v9, v1, Landroidx/media3/datasource/ContentDataSource;->bytesRemaining:J

    goto :goto_2

    .line 136
    :cond_3
    invoke-virtual {v11}, Ljava/nio/channels/FileChannel;->position()J

    move-result-wide v21

    sub-long v9, v19, v21

    iput-wide v9, v1, Landroidx/media3/datasource/ContentDataSource;->bytesRemaining:J

    .line 137
    cmp-long v9, v9, v17

    if-ltz v9, :cond_4

    .line 143
    .end local v11    # "channel":Ljava/nio/channels/FileChannel;
    .end local v19    # "channelSize":J
    :goto_2
    goto :goto_3

    .line 139
    .restart local v11    # "channel":Ljava/nio/channels/FileChannel;
    .restart local v19    # "channelSize":J
    :cond_4
    new-instance v5, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;

    const/16 v9, 0x7d8

    invoke-direct {v5, v13, v9}, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;-><init>(Ljava/io/IOException;I)V

    .end local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    throw v5

    .line 144
    .end local v11    # "channel":Ljava/nio/channels/FileChannel;
    .end local v19    # "channelSize":J
    .restart local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    :cond_5
    sub-long v9, v6, v3

    iput-wide v9, v1, Landroidx/media3/datasource/ContentDataSource;->bytesRemaining:J
    :try_end_0
    .catch Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 145
    cmp-long v9, v9, v17

    if-ltz v9, :cond_9

    .line 158
    .end local v0    # "uri":Landroid/net/Uri;
    .end local v3    # "skipped":J
    .end local v6    # "assetFileDescriptorLength":J
    .end local v8    # "inputStream":Ljava/io/FileInputStream;
    .end local v14    # "assetFileDescriptorOffset":J
    .end local v16    # "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    :goto_3
    nop

    .line 160
    iget-wide v3, v2, Landroidx/media3/datasource/DataSpec;->length:J

    const-wide/16 v6, -0x1

    cmp-long v0, v3, v6

    if-eqz v0, :cond_7

    .line 161
    nop

    .line 162
    iget-wide v3, v1, Landroidx/media3/datasource/ContentDataSource;->bytesRemaining:J

    cmp-long v0, v3, v6

    if-nez v0, :cond_6

    iget-wide v3, v2, Landroidx/media3/datasource/DataSpec;->length:J

    goto :goto_4

    :cond_6
    iget-wide v6, v2, Landroidx/media3/datasource/DataSpec;->length:J

    invoke-static {v3, v4, v6, v7}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v3

    :goto_4
    iput-wide v3, v1, Landroidx/media3/datasource/ContentDataSource;->bytesRemaining:J

    .line 164
    :cond_7
    iput-boolean v5, v1, Landroidx/media3/datasource/ContentDataSource;->opened:Z

    .line 165
    invoke-virtual/range {p0 .. p1}, Landroidx/media3/datasource/ContentDataSource;->transferStarted(Landroidx/media3/datasource/DataSpec;)V

    .line 166
    iget-wide v3, v2, Landroidx/media3/datasource/DataSpec;->length:J

    const-wide/16 v5, -0x1

    cmp-long v0, v3, v5

    if-eqz v0, :cond_8

    iget-wide v3, v2, Landroidx/media3/datasource/DataSpec;->length:J

    goto :goto_5

    :cond_8
    iget-wide v3, v1, Landroidx/media3/datasource/ContentDataSource;->bytesRemaining:J

    :goto_5
    return-wide v3

    .line 146
    .restart local v0    # "uri":Landroid/net/Uri;
    .restart local v3    # "skipped":J
    .restart local v6    # "assetFileDescriptorLength":J
    .restart local v8    # "inputStream":Ljava/io/FileInputStream;
    .restart local v14    # "assetFileDescriptorOffset":J
    .restart local v16    # "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    :cond_9
    :try_start_1
    new-instance v5, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;

    const/16 v9, 0x7d8

    invoke-direct {v5, v13, v9}, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;-><init>(Ljava/io/IOException;I)V

    .end local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    throw v5

    .line 125
    .restart local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    :cond_a
    new-instance v5, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;

    const/16 v9, 0x7d8

    invoke-direct {v5, v13, v9}, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;-><init>(Ljava/io/IOException;I)V

    .end local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    throw v5

    .line 98
    .end local v3    # "skipped":J
    .end local v6    # "assetFileDescriptorLength":J
    .end local v8    # "inputStream":Ljava/io/FileInputStream;
    .end local v14    # "assetFileDescriptorOffset":J
    .end local v16    # "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    .restart local v4    # "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    .restart local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    :cond_b
    move-object/from16 v16, v4

    .end local v4    # "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    .restart local v16    # "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    new-instance v3, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;

    new-instance v4, Ljava/io/IOException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Could not open file descriptor for: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    const/16 v5, 0x7d0

    :try_start_2
    invoke-direct {v3, v4, v5}, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;-><init>(Ljava/io/IOException;I)V

    .end local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    throw v3
    :try_end_2
    .catch Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 152
    .end local v0    # "uri":Landroid/net/Uri;
    .end local v16    # "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    .restart local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    :catch_0
    move-exception v0

    goto :goto_6

    :catch_1
    move-exception v0

    const/16 v5, 0x7d0

    .line 153
    .local v0, "e":Ljava/io/IOException;
    :goto_6
    new-instance v3, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;

    .line 155
    instance-of v4, v0, Ljava/io/FileNotFoundException;

    if-eqz v4, :cond_c

    .line 156
    const/16 v4, 0x7d5

    goto :goto_7

    .line 157
    :cond_c
    move v4, v5

    :goto_7
    invoke-direct {v3, v0, v4}, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;-><init>(Ljava/io/IOException;I)V

    throw v3

    .line 150
    .end local v0    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v0

    .line 151
    .local v0, "e":Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;
    throw v0
.end method

.method public read([BII)I
    .locals 8
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;
        }
    .end annotation

    .line 171
    if-nez p3, :cond_0

    .line 172
    const/4 v0, 0x0

    return v0

    .line 173
    :cond_0
    iget-wide v0, p0, Landroidx/media3/datasource/ContentDataSource;->bytesRemaining:J

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    const/4 v3, -0x1

    if-nez v2, :cond_1

    .line 174
    return v3

    .line 180
    :cond_1
    const-wide/16 v4, -0x1

    cmp-long v2, v0, v4

    if-nez v2, :cond_2

    move v0, p3

    goto :goto_0

    :cond_2
    int-to-long v6, p3

    :try_start_0
    invoke-static {v0, v1, v6, v7}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    long-to-int v0, v0

    .line 181
    .local v0, "bytesToRead":I
    :goto_0
    iget-object v1, p0, Landroidx/media3/datasource/ContentDataSource;->inputStream:Ljava/io/FileInputStream;

    invoke-static {v1}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/io/FileInputStream;

    invoke-virtual {v1, p1, p2, v0}, Ljava/io/FileInputStream;->read([BII)I

    move-result v1
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move v0, v1

    .line 184
    .local v0, "bytesRead":I
    nop

    .line 186
    if-ne v0, v3, :cond_3

    .line 187
    return v3

    .line 189
    :cond_3
    iget-wide v1, p0, Landroidx/media3/datasource/ContentDataSource;->bytesRemaining:J

    cmp-long v3, v1, v4

    if-eqz v3, :cond_4

    .line 190
    int-to-long v3, v0

    sub-long/2addr v1, v3

    iput-wide v1, p0, Landroidx/media3/datasource/ContentDataSource;->bytesRemaining:J

    .line 192
    :cond_4
    invoke-virtual {p0, v0}, Landroidx/media3/datasource/ContentDataSource;->bytesTransferred(I)V

    .line 193
    return v0

    .line 182
    .end local v0    # "bytesRead":I
    :catch_0
    move-exception v0

    .line 183
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;

    const/16 v2, 0x7d0

    invoke-direct {v1, v0, v2}, Landroidx/media3/datasource/ContentDataSource$ContentDataSourceException;-><init>(Ljava/io/IOException;I)V

    throw v1
.end method
