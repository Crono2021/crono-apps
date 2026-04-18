.class public final Landroidx/media3/datasource/RawResourceDataSource;
.super Landroidx/media3/datasource/BaseDataSource;
.source "RawResourceDataSource.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;
    }
.end annotation


# static fields
.field public static final RAW_RESOURCE_SCHEME:Ljava/lang/String; = "rawresource"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field


# instance fields
.field private final applicationContext:Landroid/content/Context;

.field private assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

.field private bytesRemaining:J

.field private dataSpec:Landroidx/media3/datasource/DataSpec;

.field private inputStream:Ljava/io/InputStream;

.field private opened:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 127
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/datasource/BaseDataSource;-><init>(Z)V

    .line 128
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->applicationContext:Landroid/content/Context;

    .line 129
    return-void
.end method

.method public static buildRawResourceUri(I)Landroid/net/Uri;
    .locals 2
    .param p0, "rawResourceId"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 107
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "rawresource:///"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static openAssetFileDescriptor(Landroid/content/Context;Landroidx/media3/datasource/DataSpec;)Landroid/content/res/AssetFileDescriptor;
    .locals 9
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "dataSpec"    # Landroidx/media3/datasource/DataSpec;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;
        }
    .end annotation

    .line 209
    iget-object v0, p1, Landroidx/media3/datasource/DataSpec;->uri:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->normalizeScheme()Landroid/net/Uri;

    move-result-object v0

    .line 212
    .local v0, "normalizedUri":Landroid/net/Uri;
    const-string/jumbo v1, "rawresource"

    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    const/16 v2, 0x3ec

    const/16 v3, 0x7d5

    const/4 v4, 0x0

    if-nez v1, :cond_6

    .line 213
    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    const-string v5, "android.resource"

    invoke-static {v5, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    const/4 v6, 0x1

    if-eqz v1, :cond_0

    .line 214
    invoke-virtual {v0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ne v1, v6, :cond_0

    .line 215
    invoke-virtual {v0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const-string v7, "\\d+"

    invoke-virtual {v1, v7}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    goto/16 :goto_2

    .line 225
    :cond_0
    nop

    .line 226
    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    .line 225
    invoke-static {v5, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 227
    invoke-virtual {v0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 228
    .local v1, "path":Ljava/lang/String;
    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 229
    invoke-virtual {v1, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    .line 232
    :cond_1
    invoke-virtual {v0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 233
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 234
    :cond_2
    invoke-virtual {v0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v2

    :goto_0
    nop

    .line 235
    .local v2, "packageName":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 236
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .local v5, "resources":Landroid/content/res/Resources;
    goto :goto_1

    .line 239
    .end local v5    # "resources":Landroid/content/res/Resources;
    :cond_3
    nop

    .line 240
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    invoke-virtual {v5, v2}, Landroid/content/pm/PackageManager;->getResourcesForApplication(Ljava/lang/String;)Landroid/content/res/Resources;

    move-result-object v5
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 248
    .restart local v5    # "resources":Landroid/content/res/Resources;
    nop

    .line 252
    :goto_1
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ":"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 253
    const-string/jumbo v7, "raw"

    invoke-virtual {v5, v6, v7, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v6

    .line 255
    .local v6, "resourceIdFromName":I
    if-eqz v6, :cond_4

    .line 256
    move v7, v6

    .line 263
    .end local v1    # "path":Ljava/lang/String;
    .end local v2    # "packageName":Ljava/lang/String;
    .end local v6    # "resourceIdFromName":I
    .local v7, "resourceId":I
    goto :goto_3

    .line 258
    .end local v7    # "resourceId":I
    .restart local v1    # "path":Ljava/lang/String;
    .restart local v2    # "packageName":Ljava/lang/String;
    .restart local v6    # "resourceIdFromName":I
    :cond_4
    new-instance v7, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    const-string v8, "Resource not found."

    invoke-direct {v7, v8, v4, v3}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    throw v7

    .line 241
    .end local v5    # "resources":Landroid/content/res/Resources;
    .end local v6    # "resourceIdFromName":I
    :catch_0
    move-exception v4

    .line 242
    .local v4, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    new-instance v5, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    const-string v6, "Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility."

    invoke-direct {v5, v6, v4, v3}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    throw v5

    .line 264
    .end local v1    # "path":Ljava/lang/String;
    .end local v2    # "packageName":Ljava/lang/String;
    .end local v4    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_5
    new-instance v1, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unsupported URI scheme ("

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 266
    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, "). Only "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, " is supported."

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3, v4, v2}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    throw v1

    .line 216
    :cond_6
    :goto_2
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .line 218
    .restart local v5    # "resources":Landroid/content/res/Resources;
    :try_start_1
    invoke-virtual {v0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_2

    move v7, v1

    .line 224
    .restart local v7    # "resourceId":I
    nop

    .line 276
    :goto_3
    :try_start_2
    invoke-virtual {v5, v7}, Landroid/content/res/Resources;->openRawResourceFd(I)Landroid/content/res/AssetFileDescriptor;

    move-result-object v1
    :try_end_2
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_2 .. :try_end_2} :catch_1

    .line 280
    .local v1, "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    nop

    .line 282
    if-eqz v1, :cond_7

    .line 288
    return-object v1

    .line 283
    :cond_7
    new-instance v2, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Resource is compressed: "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/16 v6, 0x7d0

    invoke-direct {v2, v3, v4, v6}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    throw v2

    .line 277
    .end local v1    # "assetFileDescriptor":Landroid/content/res/AssetFileDescriptor;
    :catch_1
    move-exception v1

    .line 278
    .local v1, "e":Landroid/content/res/Resources$NotFoundException;
    new-instance v2, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    invoke-direct {v2, v4, v1, v3}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    throw v2

    .line 219
    .end local v1    # "e":Landroid/content/res/Resources$NotFoundException;
    .end local v7    # "resourceId":I
    :catch_2
    move-exception v1

    .line 220
    .local v1, "e":Ljava/lang/NumberFormatException;
    new-instance v3, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    const-string v6, "Resource identifier must be an integer."

    invoke-direct {v3, v6, v4, v2}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    throw v3
.end method


# virtual methods
.method public close()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;
        }
    .end annotation

    .line 335
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->dataSpec:Landroidx/media3/datasource/DataSpec;

    .line 337
    const/16 v1, 0x7d0

    const/4 v2, 0x0

    :try_start_0
    iget-object v3, p0, Landroidx/media3/datasource/RawResourceDataSource;->inputStream:Ljava/io/InputStream;

    if-eqz v3, :cond_0

    .line 338
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 344
    :cond_0
    iput-object v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->inputStream:Ljava/io/InputStream;

    .line 346
    :try_start_1
    iget-object v3, p0, Landroidx/media3/datasource/RawResourceDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    if-eqz v3, :cond_1

    .line 347
    invoke-virtual {v3}, Landroid/content/res/AssetFileDescriptor;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 353
    :cond_1
    iput-object v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    .line 354
    iget-boolean v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->opened:Z

    if-eqz v0, :cond_2

    .line 355
    iput-boolean v2, p0, Landroidx/media3/datasource/RawResourceDataSource;->opened:Z

    .line 356
    invoke-virtual {p0}, Landroidx/media3/datasource/RawResourceDataSource;->transferEnded()V

    .line 359
    :cond_2
    nop

    .line 360
    return-void

    .line 353
    :catchall_0
    move-exception v1

    goto :goto_0

    .line 349
    :catch_0
    move-exception v3

    .line 350
    .local v3, "e":Ljava/io/IOException;
    :try_start_2
    new-instance v4, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    invoke-direct {v4, v0, v3, v1}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    throw v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 353
    .end local v3    # "e":Ljava/io/IOException;
    :goto_0
    iput-object v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    .line 354
    iget-boolean v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->opened:Z

    if-eqz v0, :cond_3

    .line 355
    iput-boolean v2, p0, Landroidx/media3/datasource/RawResourceDataSource;->opened:Z

    .line 356
    invoke-virtual {p0}, Landroidx/media3/datasource/RawResourceDataSource;->transferEnded()V

    .line 358
    :cond_3
    throw v1

    .line 344
    :catchall_1
    move-exception v3

    goto :goto_1

    .line 340
    :catch_1
    move-exception v3

    .line 341
    .restart local v3    # "e":Ljava/io/IOException;
    :try_start_3
    new-instance v4, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    invoke-direct {v4, v0, v3, v1}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    throw v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 344
    .end local v3    # "e":Ljava/io/IOException;
    :goto_1
    iput-object v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->inputStream:Ljava/io/InputStream;

    .line 346
    :try_start_4
    iget-object v4, p0, Landroidx/media3/datasource/RawResourceDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    if-eqz v4, :cond_4

    .line 347
    invoke-virtual {v4}, Landroid/content/res/AssetFileDescriptor;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 353
    :cond_4
    iput-object v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    .line 354
    iget-boolean v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->opened:Z

    if-eqz v0, :cond_5

    .line 355
    iput-boolean v2, p0, Landroidx/media3/datasource/RawResourceDataSource;->opened:Z

    .line 356
    invoke-virtual {p0}, Landroidx/media3/datasource/RawResourceDataSource;->transferEnded()V

    .line 359
    :cond_5
    throw v3

    .line 353
    :catchall_2
    move-exception v1

    goto :goto_2

    .line 349
    :catch_2
    move-exception v3

    .line 350
    .restart local v3    # "e":Ljava/io/IOException;
    :try_start_5
    new-instance v4, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    invoke-direct {v4, v0, v3, v1}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    throw v4
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 353
    .end local v3    # "e":Ljava/io/IOException;
    :goto_2
    iput-object v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    .line 354
    iget-boolean v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->opened:Z

    if-eqz v0, :cond_6

    .line 355
    iput-boolean v2, p0, Landroidx/media3/datasource/RawResourceDataSource;->opened:Z

    .line 356
    invoke-virtual {p0}, Landroidx/media3/datasource/RawResourceDataSource;->transferEnded()V

    .line 358
    :cond_6
    throw v1
.end method

.method public getUri()Landroid/net/Uri;
    .locals 1

    .line 329
    iget-object v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->dataSpec:Landroidx/media3/datasource/DataSpec;

    if-eqz v0, :cond_0

    iget-object v0, v0, Landroidx/media3/datasource/DataSpec;->uri:Landroid/net/Uri;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public open(Landroidx/media3/datasource/DataSpec;)J
    .locals 20
    .param p1, "dataSpec"    # Landroidx/media3/datasource/DataSpec;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;
        }
    .end annotation

    .line 133
    move-object/from16 v1, p0

    move-object/from16 v2, p1

    iput-object v2, v1, Landroidx/media3/datasource/RawResourceDataSource;->dataSpec:Landroidx/media3/datasource/DataSpec;

    .line 134
    invoke-virtual/range {p0 .. p1}, Landroidx/media3/datasource/RawResourceDataSource;->transferInitializing(Landroidx/media3/datasource/DataSpec;)V

    .line 135
    iget-object v0, v1, Landroidx/media3/datasource/RawResourceDataSource;->applicationContext:Landroid/content/Context;

    invoke-static {v0, v2}, Landroidx/media3/datasource/RawResourceDataSource;->openAssetFileDescriptor(Landroid/content/Context;Landroidx/media3/datasource/DataSpec;)Landroid/content/res/AssetFileDescriptor;

    move-result-object v0

    iput-object v0, v1, Landroidx/media3/datasource/RawResourceDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    .line 137
    invoke-virtual {v0}, Landroid/content/res/AssetFileDescriptor;->getLength()J

    move-result-wide v3

    .line 138
    .local v3, "assetFileDescriptorLength":J
    new-instance v0, Ljava/io/FileInputStream;

    iget-object v5, v1, Landroidx/media3/datasource/RawResourceDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    invoke-virtual {v5}, Landroid/content/res/AssetFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v5

    invoke-direct {v0, v5}, Ljava/io/FileInputStream;-><init>(Ljava/io/FileDescriptor;)V

    move-object v5, v0

    .line 139
    .local v5, "inputStream":Ljava/io/FileInputStream;
    iput-object v5, v1, Landroidx/media3/datasource/RawResourceDataSource;->inputStream:Ljava/io/InputStream;

    .line 148
    const-wide/16 v6, -0x1

    cmp-long v0, v3, v6

    const/16 v8, 0x7d8

    const/4 v9, 0x0

    if-eqz v0, :cond_1

    :try_start_0
    iget-wide v10, v2, Landroidx/media3/datasource/DataSpec;->position:J

    cmp-long v0, v10, v3

    if-gtz v0, :cond_0

    goto :goto_0

    .line 150
    :cond_0
    new-instance v0, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    invoke-direct {v0, v9, v9, v8}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    .end local v3    # "assetFileDescriptorLength":J
    .end local v5    # "inputStream":Ljava/io/FileInputStream;
    .end local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    throw v0

    .line 155
    .restart local v3    # "assetFileDescriptorLength":J
    .restart local v5    # "inputStream":Ljava/io/FileInputStream;
    .restart local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    :cond_1
    :goto_0
    iget-object v0, v1, Landroidx/media3/datasource/RawResourceDataSource;->assetFileDescriptor:Landroid/content/res/AssetFileDescriptor;

    invoke-virtual {v0}, Landroid/content/res/AssetFileDescriptor;->getStartOffset()J

    move-result-wide v10

    .line 156
    .local v10, "assetFileDescriptorOffset":J
    iget-wide v12, v2, Landroidx/media3/datasource/DataSpec;->position:J

    add-long/2addr v12, v10

    .line 157
    invoke-virtual {v5, v12, v13}, Ljava/io/FileInputStream;->skip(J)J

    move-result-wide v12

    sub-long/2addr v12, v10

    .line 159
    .local v12, "skipped":J
    iget-wide v14, v2, Landroidx/media3/datasource/DataSpec;->position:J

    cmp-long v0, v12, v14

    if-nez v0, :cond_9

    .line 167
    cmp-long v0, v3, v6

    const-wide/16 v14, 0x0

    if-nez v0, :cond_4

    .line 170
    invoke-virtual {v5}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v0

    .line 171
    .local v0, "channel":Ljava/nio/channels/FileChannel;
    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v16

    cmp-long v16, v16, v14

    if-nez v16, :cond_2

    .line 172
    iput-wide v6, v1, Landroidx/media3/datasource/RawResourceDataSource;->bytesRemaining:J

    goto :goto_1

    .line 174
    :cond_2
    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v16

    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->position()J

    move-result-wide v18

    sub-long v6, v16, v18

    iput-wide v6, v1, Landroidx/media3/datasource/RawResourceDataSource;->bytesRemaining:J

    .line 175
    cmp-long v6, v6, v14

    if-ltz v6, :cond_3

    .line 183
    .end local v0    # "channel":Ljava/nio/channels/FileChannel;
    :goto_1
    goto :goto_2

    .line 177
    .restart local v0    # "channel":Ljava/nio/channels/FileChannel;
    :cond_3
    new-instance v6, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    invoke-direct {v6, v9, v9, v8}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    .end local v3    # "assetFileDescriptorLength":J
    .end local v5    # "inputStream":Ljava/io/FileInputStream;
    .end local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    throw v6

    .line 184
    .end local v0    # "channel":Ljava/nio/channels/FileChannel;
    .restart local v3    # "assetFileDescriptorLength":J
    .restart local v5    # "inputStream":Ljava/io/FileInputStream;
    .restart local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    :cond_4
    sub-long v6, v3, v12

    iput-wide v6, v1, Landroidx/media3/datasource/RawResourceDataSource;->bytesRemaining:J
    :try_end_0
    .catch Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 185
    cmp-long v0, v6, v14

    if-ltz v0, :cond_8

    .line 194
    .end local v10    # "assetFileDescriptorOffset":J
    .end local v12    # "skipped":J
    :goto_2
    nop

    .line 196
    iget-wide v6, v2, Landroidx/media3/datasource/DataSpec;->length:J

    const-wide/16 v8, -0x1

    cmp-long v0, v6, v8

    if-eqz v0, :cond_6

    .line 197
    nop

    .line 198
    iget-wide v6, v1, Landroidx/media3/datasource/RawResourceDataSource;->bytesRemaining:J

    cmp-long v0, v6, v8

    if-nez v0, :cond_5

    iget-wide v6, v2, Landroidx/media3/datasource/DataSpec;->length:J

    goto :goto_3

    :cond_5
    iget-wide v8, v2, Landroidx/media3/datasource/DataSpec;->length:J

    invoke-static {v6, v7, v8, v9}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v6

    :goto_3
    iput-wide v6, v1, Landroidx/media3/datasource/RawResourceDataSource;->bytesRemaining:J

    .line 200
    :cond_6
    const/4 v0, 0x1

    iput-boolean v0, v1, Landroidx/media3/datasource/RawResourceDataSource;->opened:Z

    .line 201
    invoke-virtual/range {p0 .. p1}, Landroidx/media3/datasource/RawResourceDataSource;->transferStarted(Landroidx/media3/datasource/DataSpec;)V

    .line 202
    iget-wide v6, v2, Landroidx/media3/datasource/DataSpec;->length:J

    const-wide/16 v8, -0x1

    cmp-long v0, v6, v8

    if-eqz v0, :cond_7

    iget-wide v6, v2, Landroidx/media3/datasource/DataSpec;->length:J

    goto :goto_4

    :cond_7
    iget-wide v6, v1, Landroidx/media3/datasource/RawResourceDataSource;->bytesRemaining:J

    :goto_4
    return-wide v6

    .line 186
    .restart local v10    # "assetFileDescriptorOffset":J
    .restart local v12    # "skipped":J
    :cond_8
    :try_start_1
    new-instance v0, Landroidx/media3/datasource/DataSourceException;

    invoke-direct {v0, v8}, Landroidx/media3/datasource/DataSourceException;-><init>(I)V

    .end local v3    # "assetFileDescriptorLength":J
    .end local v5    # "inputStream":Ljava/io/FileInputStream;
    .end local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    throw v0

    .line 162
    .restart local v3    # "assetFileDescriptorLength":J
    .restart local v5    # "inputStream":Ljava/io/FileInputStream;
    .restart local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    :cond_9
    new-instance v0, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    invoke-direct {v0, v9, v9, v8}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    .end local v3    # "assetFileDescriptorLength":J
    .end local v5    # "inputStream":Ljava/io/FileInputStream;
    .end local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    throw v0
    :try_end_1
    .catch Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 191
    .end local v10    # "assetFileDescriptorOffset":J
    .end local v12    # "skipped":J
    .restart local v3    # "assetFileDescriptorLength":J
    .restart local v5    # "inputStream":Ljava/io/FileInputStream;
    .restart local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    :catch_0
    move-exception v0

    .line 192
    .local v0, "e":Ljava/io/IOException;
    new-instance v6, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    const/16 v7, 0x7d0

    invoke-direct {v6, v9, v0, v7}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    throw v6

    .line 189
    .end local v0    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .line 190
    .local v0, "e":Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;
    throw v0
.end method

.method public read([BII)I
    .locals 9
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;
        }
    .end annotation

    .line 293
    if-nez p3, :cond_0

    .line 294
    const/4 v0, 0x0

    return v0

    .line 295
    :cond_0
    iget-wide v0, p0, Landroidx/media3/datasource/RawResourceDataSource;->bytesRemaining:J

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    const/4 v3, -0x1

    if-nez v2, :cond_1

    .line 296
    return v3

    .line 302
    :cond_1
    const-wide/16 v4, -0x1

    cmp-long v2, v0, v4

    const/16 v6, 0x7d0

    if-nez v2, :cond_2

    move v0, p3

    goto :goto_0

    :cond_2
    int-to-long v7, p3

    :try_start_0
    invoke-static {v0, v1, v7, v8}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    long-to-int v0, v0

    .line 303
    .local v0, "bytesToRead":I
    :goto_0
    iget-object v1, p0, Landroidx/media3/datasource/RawResourceDataSource;->inputStream:Ljava/io/InputStream;

    invoke-static {v1}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/io/InputStream;

    invoke-virtual {v1, p1, p2, v0}, Ljava/io/InputStream;->read([BII)I

    move-result v1
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move v0, v1

    .line 307
    .local v0, "bytesRead":I
    nop

    .line 309
    if-ne v0, v3, :cond_4

    .line 310
    iget-wide v1, p0, Landroidx/media3/datasource/RawResourceDataSource;->bytesRemaining:J

    cmp-long v1, v1, v4

    if-nez v1, :cond_3

    .line 317
    return v3

    .line 312
    :cond_3
    new-instance v1, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    new-instance v2, Ljava/io/EOFException;

    invoke-direct {v2}, Ljava/io/EOFException;-><init>()V

    const-string v3, "End of stream reached having not read sufficient data."

    invoke-direct {v1, v3, v2, v6}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    throw v1

    .line 319
    :cond_4
    iget-wide v1, p0, Landroidx/media3/datasource/RawResourceDataSource;->bytesRemaining:J

    cmp-long v3, v1, v4

    if-eqz v3, :cond_5

    .line 320
    int-to-long v3, v0

    sub-long/2addr v1, v3

    iput-wide v1, p0, Landroidx/media3/datasource/RawResourceDataSource;->bytesRemaining:J

    .line 322
    :cond_5
    invoke-virtual {p0, v0}, Landroidx/media3/datasource/RawResourceDataSource;->bytesTransferred(I)V

    .line 323
    return v0

    .line 304
    .end local v0    # "bytesRead":I
    :catch_0
    move-exception v0

    .line 305
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;

    const/4 v2, 0x0

    invoke-direct {v1, v2, v0, v6}, Landroidx/media3/datasource/RawResourceDataSource$RawResourceDataSourceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;I)V

    throw v1
.end method
