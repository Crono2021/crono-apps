.class public final Landroidx/media3/datasource/HttpEngineDataSource$Factory;
.super Ljava/lang/Object;
.source "HttpEngineDataSource.java"

# interfaces
.implements Landroidx/media3/datasource/HttpDataSource$Factory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/datasource/HttpEngineDataSource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Factory"
.end annotation


# instance fields
.field private connectTimeoutMs:I

.field private contentTypePredicate:Lcom/google/common/base/Predicate;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/base/Predicate<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final defaultRequestProperties:Landroidx/media3/datasource/HttpDataSource$RequestProperties;

.field private final executor:Ljava/util/concurrent/Executor;

.field private handleSetCookieRequests:Z

.field private final httpEngine:Landroid/net/http/HttpEngine;

.field private keepPostFor302Redirects:Z

.field private readTimeoutMs:I

.field private requestPriority:I

.field private resetTimeoutOnRedirects:Z

.field private transferListener:Landroidx/media3/datasource/TransferListener;

.field private userAgent:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/net/http/HttpEngine;Ljava/util/concurrent/Executor;)V
    .locals 1
    .param p1, "httpEngine"    # Landroid/net/http/HttpEngine;
    .param p2, "executor"    # Ljava/util/concurrent/Executor;

    .line 104
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 105
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/http/HttpEngine;

    iput-object v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->httpEngine:Landroid/net/http/HttpEngine;

    .line 106
    iput-object p2, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->executor:Ljava/util/concurrent/Executor;

    .line 107
    new-instance v0, Landroidx/media3/datasource/HttpDataSource$RequestProperties;

    invoke-direct {v0}, Landroidx/media3/datasource/HttpDataSource$RequestProperties;-><init>()V

    iput-object v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->defaultRequestProperties:Landroidx/media3/datasource/HttpDataSource$RequestProperties;

    .line 108
    const/4 v0, 0x3

    iput v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->requestPriority:I

    .line 109
    const/16 v0, 0x1f40

    iput v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->connectTimeoutMs:I

    .line 110
    iput v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->readTimeoutMs:I

    .line 111
    return-void
.end method


# virtual methods
.method public bridge synthetic createDataSource()Landroidx/media3/datasource/DataSource;
    .locals 1

    .line 78
    invoke-virtual {p0}, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->createDataSource()Landroidx/media3/datasource/HttpDataSource;

    move-result-object v0

    return-object v0
.end method

.method public createDataSource()Landroidx/media3/datasource/HttpDataSource;
    .locals 13

    .line 265
    new-instance v12, Landroidx/media3/datasource/HttpEngineDataSource;

    iget-object v1, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->httpEngine:Landroid/net/http/HttpEngine;

    iget-object v2, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->executor:Ljava/util/concurrent/Executor;

    iget v3, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->requestPriority:I

    iget v4, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->connectTimeoutMs:I

    iget v5, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->readTimeoutMs:I

    iget-boolean v6, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->resetTimeoutOnRedirects:Z

    iget-boolean v7, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->handleSetCookieRequests:Z

    iget-object v8, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->userAgent:Ljava/lang/String;

    iget-object v9, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->defaultRequestProperties:Landroidx/media3/datasource/HttpDataSource$RequestProperties;

    iget-object v10, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->contentTypePredicate:Lcom/google/common/base/Predicate;

    iget-boolean v11, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->keepPostFor302Redirects:Z

    move-object v0, v12

    invoke-direct/range {v0 .. v11}, Landroidx/media3/datasource/HttpEngineDataSource;-><init>(Landroid/net/http/HttpEngine;Ljava/util/concurrent/Executor;IIIZZLjava/lang/String;Landroidx/media3/datasource/HttpDataSource$RequestProperties;Lcom/google/common/base/Predicate;Z)V

    .line 278
    .local v0, "dataSource":Landroidx/media3/datasource/HttpEngineDataSource;
    iget-object v1, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->transferListener:Landroidx/media3/datasource/TransferListener;

    if-eqz v1, :cond_0

    .line 279
    invoke-virtual {v0, v1}, Landroidx/media3/datasource/HttpEngineDataSource;->addTransferListener(Landroidx/media3/datasource/TransferListener;)V

    .line 281
    :cond_0
    return-object v0
.end method

.method public setConnectionTimeoutMs(I)Landroidx/media3/datasource/HttpEngineDataSource$Factory;
    .locals 0
    .param p1, "connectTimeoutMs"    # I

    .line 166
    iput p1, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->connectTimeoutMs:I

    .line 167
    return-object p0
.end method

.method public setContentTypePredicate(Lcom/google/common/base/Predicate;)Landroidx/media3/datasource/HttpEngineDataSource$Factory;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/common/base/Predicate<",
            "Ljava/lang/String;",
            ">;)",
            "Landroidx/media3/datasource/HttpEngineDataSource$Factory;"
        }
    .end annotation

    .line 230
    .local p1, "contentTypePredicate":Lcom/google/common/base/Predicate;, "Lcom/google/common/base/Predicate<Ljava/lang/String;>;"
    iput-object p1, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->contentTypePredicate:Lcom/google/common/base/Predicate;

    .line 231
    return-object p0
.end method

.method public bridge synthetic setDefaultRequestProperties(Ljava/util/Map;)Landroidx/media3/datasource/HttpDataSource$Factory;
    .locals 0

    .line 78
    invoke-virtual {p0, p1}, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->setDefaultRequestProperties(Ljava/util/Map;)Landroidx/media3/datasource/HttpEngineDataSource$Factory;

    move-result-object p1

    return-object p1
.end method

.method public final setDefaultRequestProperties(Ljava/util/Map;)Landroidx/media3/datasource/HttpEngineDataSource$Factory;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Landroidx/media3/datasource/HttpEngineDataSource$Factory;"
        }
    .end annotation

    .line 117
    .local p1, "defaultRequestProperties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->defaultRequestProperties:Landroidx/media3/datasource/HttpDataSource$RequestProperties;

    invoke-virtual {v0, p1}, Landroidx/media3/datasource/HttpDataSource$RequestProperties;->clearAndSet(Ljava/util/Map;)V

    .line 118
    return-object p0
.end method

.method public setHandleSetCookieRequests(Z)Landroidx/media3/datasource/HttpEngineDataSource$Factory;
    .locals 0
    .param p1, "handleSetCookieRequests"    # Z

    .line 198
    iput-boolean p1, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->handleSetCookieRequests:Z

    .line 199
    return-object p0
.end method

.method public setKeepPostFor302Redirects(Z)Landroidx/media3/datasource/HttpEngineDataSource$Factory;
    .locals 0
    .param p1, "keepPostFor302Redirects"    # Z

    .line 241
    iput-boolean p1, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->keepPostFor302Redirects:Z

    .line 242
    return-object p0
.end method

.method public setReadTimeoutMs(I)Landroidx/media3/datasource/HttpEngineDataSource$Factory;
    .locals 0
    .param p1, "readTimeoutMs"    # I

    .line 213
    iput p1, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->readTimeoutMs:I

    .line 214
    return-object p0
.end method

.method public setRequestPriority(I)Landroidx/media3/datasource/HttpEngineDataSource$Factory;
    .locals 0
    .param p1, "requestPriority"    # I

    .line 151
    iput p1, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->requestPriority:I

    .line 152
    return-object p0
.end method

.method public setResetTimeoutOnRedirects(Z)Landroidx/media3/datasource/HttpEngineDataSource$Factory;
    .locals 0
    .param p1, "resetTimeoutOnRedirects"    # Z

    .line 181
    iput-boolean p1, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->resetTimeoutOnRedirects:Z

    .line 182
    return-object p0
.end method

.method public setTransferListener(Landroidx/media3/datasource/TransferListener;)Landroidx/media3/datasource/HttpEngineDataSource$Factory;
    .locals 0
    .param p1, "transferListener"    # Landroidx/media3/datasource/TransferListener;

    .line 258
    iput-object p1, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->transferListener:Landroidx/media3/datasource/TransferListener;

    .line 259
    return-object p0
.end method

.method public setUserAgent(Ljava/lang/String;)Landroidx/media3/datasource/HttpEngineDataSource$Factory;
    .locals 0
    .param p1, "userAgent"    # Ljava/lang/String;

    .line 134
    iput-object p1, p0, Landroidx/media3/datasource/HttpEngineDataSource$Factory;->userAgent:Ljava/lang/String;

    .line 135
    return-object p0
.end method
