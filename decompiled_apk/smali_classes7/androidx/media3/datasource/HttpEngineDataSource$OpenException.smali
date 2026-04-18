.class public final Landroidx/media3/datasource/HttpEngineDataSource$OpenException;
.super Landroidx/media3/datasource/HttpDataSource$HttpDataSourceException;
.source "HttpEngineDataSource.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/datasource/HttpEngineDataSource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "OpenException"
.end annotation


# instance fields
.field public final httpEngineConnectionStatus:I


# direct methods
.method public constructor <init>(Landroidx/media3/datasource/DataSpec;II)V
    .locals 1
    .param p1, "dataSpec"    # Landroidx/media3/datasource/DataSpec;
    .param p2, "errorCode"    # I
    .param p3, "httpEngineConnectionStatus"    # I

    .line 317
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Landroidx/media3/datasource/HttpDataSource$HttpDataSourceException;-><init>(Landroidx/media3/datasource/DataSpec;II)V

    .line 318
    iput p3, p0, Landroidx/media3/datasource/HttpEngineDataSource$OpenException;->httpEngineConnectionStatus:I

    .line 319
    return-void
.end method

.method public constructor <init>(Ljava/io/IOException;Landroidx/media3/datasource/DataSpec;II)V
    .locals 1
    .param p1, "cause"    # Ljava/io/IOException;
    .param p2, "dataSpec"    # Landroidx/media3/datasource/DataSpec;
    .param p3, "errorCode"    # I
    .param p4, "httpEngineConnectionStatus"    # I

    .line 300
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, p3, v0}, Landroidx/media3/datasource/HttpDataSource$HttpDataSourceException;-><init>(Ljava/io/IOException;Landroidx/media3/datasource/DataSpec;II)V

    .line 301
    iput p4, p0, Landroidx/media3/datasource/HttpEngineDataSource$OpenException;->httpEngineConnectionStatus:I

    .line 302
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Landroidx/media3/datasource/DataSpec;II)V
    .locals 1
    .param p1, "errorMessage"    # Ljava/lang/String;
    .param p2, "dataSpec"    # Landroidx/media3/datasource/DataSpec;
    .param p3, "errorCode"    # I
    .param p4, "httpEngineConnectionStatus"    # I

    .line 309
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, p3, v0}, Landroidx/media3/datasource/HttpDataSource$HttpDataSourceException;-><init>(Ljava/lang/String;Landroidx/media3/datasource/DataSpec;II)V

    .line 310
    iput p4, p0, Landroidx/media3/datasource/HttpEngineDataSource$OpenException;->httpEngineConnectionStatus:I

    .line 311
    return-void
.end method
