.class public final Lcom/cineflix/android/ui/player/StreamProxyServer;
.super Lfi/iki/elonen/NanoHTTPD;
.source "StreamProxyServer.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/cineflix/android/ui/player/StreamProxyServer$Companion;,
        Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0008\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"
    }
    d2 = {
        "Lcom/cineflix/android/ui/player/StreamProxyServer;",
        "Lfi/iki/elonen/NanoHTTPD;",
        "engine",
        "Lcom/cineflix/android/TelegramEngine;",
        "fileId",
        "",
        "fileSize",
        "",
        "mimeType",
        "",
        "(Lcom/cineflix/android/TelegramEngine;IJLjava/lang/String;)V",
        "getFileSize",
        "()J",
        "parseRange",
        "Lkotlin/Pair;",
        "rangeHeader",
        "resolveFileSize",
        "serve",
        "Lfi/iki/elonen/NanoHTTPD$Response;",
        "session",
        "Lfi/iki/elonen/NanoHTTPD$IHTTPSession;",
        "Companion",
        "DiskFreeInputStream",
        "app_debug"
    }
    k = 0x1
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final $stable:I

.field public static final Companion:Lcom/cineflix/android/ui/player/StreamProxyServer$Companion;

.field private static final PREFETCH_SIZE:J = 0x200000L

.field private static final TAG:Ljava/lang/String; = "StreamProxy"


# instance fields
.field private final engine:Lcom/cineflix/android/TelegramEngine;

.field private final fileId:I

.field private final fileSize:J

.field private final mimeType:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/cineflix/android/ui/player/StreamProxyServer$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/cineflix/android/ui/player/StreamProxyServer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/cineflix/android/ui/player/StreamProxyServer;->Companion:Lcom/cineflix/android/ui/player/StreamProxyServer$Companion;

    const/16 v0, 0x8

    sput v0, Lcom/cineflix/android/ui/player/StreamProxyServer;->$stable:I

    return-void
.end method

.method public constructor <init>(Lcom/cineflix/android/TelegramEngine;IJLjava/lang/String;)V
    .locals 1
    .param p1, "engine"    # Lcom/cineflix/android/TelegramEngine;
    .param p2, "fileId"    # I
    .param p3, "fileSize"    # J
    .param p5, "mimeType"    # Ljava/lang/String;

    const-string v0, "engine"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "mimeType"

    invoke-static {p5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 29
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lfi/iki/elonen/NanoHTTPD;-><init>(I)V

    .line 25
    iput-object p1, p0, Lcom/cineflix/android/ui/player/StreamProxyServer;->engine:Lcom/cineflix/android/TelegramEngine;

    .line 26
    iput p2, p0, Lcom/cineflix/android/ui/player/StreamProxyServer;->fileId:I

    .line 27
    iput-wide p3, p0, Lcom/cineflix/android/ui/player/StreamProxyServer;->fileSize:J

    .line 28
    iput-object p5, p0, Lcom/cineflix/android/ui/player/StreamProxyServer;->mimeType:Ljava/lang/String;

    .line 24
    return-void
.end method

.method private final parseRange(Ljava/lang/String;)Lkotlin/Pair;
    .locals 8
    .param p1, "rangeHeader"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lkotlin/Pair<",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .line 85
    new-instance v0, Lkotlin/text/Regex;

    const-string v1, "bytes=(\\d+)-(\\d*)"

    invoke-direct {v0, v1}, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V

    move-object v1, p1

    check-cast v1, Ljava/lang/CharSequence;

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x2

    invoke-static {v0, v1, v3, v4, v2}, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex;Ljava/lang/CharSequence;IILjava/lang/Object;)Lkotlin/text/MatchResult;

    move-result-object v0

    .line 86
    .local v0, "match":Lkotlin/text/MatchResult;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_0

    const/4 v2, 0x1

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    if-eqz v1, :cond_0

    invoke-static {v1}, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    goto :goto_0

    :cond_0
    const-wide/16 v1, 0x0

    .line 87
    .local v1, "start":J
    :goto_0
    if-eqz v0, :cond_1

    invoke-interface {v0}, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    if-eqz v3, :cond_1

    invoke-static {v3}, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    goto :goto_1

    :cond_1
    const-wide/16 v3, -0x1

    .line 88
    .local v3, "end":J
    :goto_1
    new-instance v5, Lkotlin/Pair;

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v5
.end method

.method private final resolveFileSize()J
    .locals 9

    .line 45
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v2, 0x2710

    add-long/2addr v0, v2

    .line 46
    .local v0, "deadline":J
    :goto_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    cmp-long v2, v2, v0

    const-string v3, "resolveFileSize \u2192 "

    const-string v4, "StreamProxy"

    if-gez v2, :cond_1

    .line 47
    iget-object v2, p0, Lcom/cineflix/android/ui/player/StreamProxyServer;->engine:Lcom/cineflix/android/TelegramEngine;

    iget v5, p0, Lcom/cineflix/android/ui/player/StreamProxyServer;->fileId:I

    invoke-virtual {v2, v5}, Lcom/cineflix/android/TelegramEngine;->getFileStateFlow(I)Lkotlinx/coroutines/flow/StateFlow;

    move-result-object v2

    invoke-interface {v2}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/cineflix/android/TelegramEngine$FileState;

    .line 48
    .local v2, "state":Lcom/cineflix/android/TelegramEngine$FileState;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/cineflix/android/TelegramEngine$FileState;->getExpectedSize()J

    move-result-wide v5

    const-wide/16 v7, 0x0

    cmp-long v5, v5, v7

    if-lez v5, :cond_0

    .line 49
    invoke-virtual {v2}, Lcom/cineflix/android/TelegramEngine$FileState;->getExpectedSize()J

    move-result-wide v5

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, " (from TDLib)"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v4, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 50
    invoke-virtual {v2}, Lcom/cineflix/android/TelegramEngine$FileState;->getExpectedSize()J

    move-result-wide v3

    return-wide v3

    .line 52
    :cond_0
    const-wide/16 v3, 0x64

    invoke-static {v3, v4}, Ljava/lang/Thread;->sleep(J)V

    .end local v2    # "state":Lcom/cineflix/android/TelegramEngine$FileState;
    goto :goto_0

    .line 54
    :cond_1
    iget-wide v5, p0, Lcom/cineflix/android/ui/player/StreamProxyServer;->fileSize:J

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " (fallback from Intent)"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 55
    iget-wide v2, p0, Lcom/cineflix/android/ui/player/StreamProxyServer;->fileSize:J

    return-wide v2
.end method


# virtual methods
.method public final getFileSize()J
    .locals 2

    .line 27
    iget-wide v0, p0, Lcom/cineflix/android/ui/player/StreamProxyServer;->fileSize:J

    return-wide v0
.end method

.method public serve(Lfi/iki/elonen/NanoHTTPD$IHTTPSession;)Lfi/iki/elonen/NanoHTTPD$Response;
    .locals 23
    .param p1, "session"    # Lfi/iki/elonen/NanoHTTPD$IHTTPSession;

    move-object/from16 v0, p0

    const-string v1, "session"

    move-object/from16 v2, p1

    invoke-static {v2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 59
    invoke-interface/range {p1 .. p1}, Lfi/iki/elonen/NanoHTTPD$IHTTPSession;->getUri()Ljava/lang/String;

    move-result-object v1

    invoke-interface/range {p1 .. p1}, Lfi/iki/elonen/NanoHTTPD$IHTTPSession;->getHeaders()Ljava/util/Map;

    move-result-object v3

    const-string v4, "range"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "serve() URI="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, " Range="

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v3, "StreamProxy"

    invoke-static {v3, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 61
    invoke-direct/range {p0 .. p0}, Lcom/cineflix/android/ui/player/StreamProxyServer;->resolveFileSize()J

    move-result-wide v14

    .line 64
    .local v14, "actualFileSize":J
    invoke-interface/range {p1 .. p1}, Lfi/iki/elonen/NanoHTTPD$IHTTPSession;->getHeaders()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    if-nez v1, :cond_0

    const-string v1, "bytes=0-"

    .line 65
    .local v1, "rangeHeader":Ljava/lang/String;
    :cond_0
    invoke-direct {v0, v1}, Lcom/cineflix/android/ui/player/StreamProxyServer;->parseRange(Ljava/lang/String;)Lkotlin/Pair;

    move-result-object v4

    invoke-virtual {v4}, Lkotlin/Pair;->component1()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->longValue()J

    move-result-wide v12

    .local v12, "start":J
    invoke-virtual {v4}, Lkotlin/Pair;->component2()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Number;

    invoke-virtual {v4}, Ljava/lang/Number;->longValue()J

    move-result-wide v16

    .line 66
    .local v16, "endRequested":J
    const-wide/16 v4, 0x0

    cmp-long v4, v16, v4

    const-wide/16 v5, 0x1

    if-ltz v4, :cond_2

    cmp-long v4, v16, v14

    if-ltz v4, :cond_1

    goto :goto_0

    :cond_1
    move-wide/from16 v7, v16

    goto :goto_1

    :cond_2
    :goto_0
    sub-long v7, v14, v5

    :goto_1
    move-wide v10, v7

    .line 67
    .local v10, "end":J
    sub-long v7, v10, v12

    add-long v8, v7, v5

    .line 69
    .local v8, "length":J
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Serving bytes "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v12, v13}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v7, "-"

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v10, v11}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " ("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " bytes) of "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v14, v15}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " total"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 71
    new-instance v3, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;

    iget-object v6, v0, Lcom/cineflix/android/ui/player/StreamProxyServer;->engine:Lcom/cineflix/android/TelegramEngine;

    iget v4, v0, Lcom/cineflix/android/ui/player/StreamProxyServer;->fileId:I

    move-object v5, v3

    move-object/from16 v18, v1

    move-object v1, v7

    .end local v1    # "rangeHeader":Ljava/lang/String;
    .local v18, "rangeHeader":Ljava/lang/String;
    move v7, v4

    move-wide/from16 v19, v8

    .end local v8    # "length":J
    .local v19, "length":J
    move-wide v8, v12

    move-wide/from16 v21, v10

    .end local v10    # "end":J
    .local v21, "end":J
    move-wide/from16 v10, v19

    move-object v4, v1

    move-wide v1, v12

    .end local v12    # "start":J
    .local v1, "start":J
    move-wide v12, v14

    invoke-direct/range {v5 .. v13}, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;-><init>(Lcom/cineflix/android/TelegramEngine;IJJJ)V

    .line 74
    .local v3, "inputStream":Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;
    sget-object v5, Lfi/iki/elonen/NanoHTTPD$Response$Status;->PARTIAL_CONTENT:Lfi/iki/elonen/NanoHTTPD$Response$Status;

    check-cast v5, Lfi/iki/elonen/NanoHTTPD$Response$IStatus;

    .line 75
    iget-object v6, v0, Lcom/cineflix/android/ui/player/StreamProxyServer;->mimeType:Ljava/lang/String;

    .line 76
    move-object v7, v3

    check-cast v7, Ljava/io/InputStream;

    .line 77
    nop

    .line 73
    move-wide/from16 v8, v19

    .end local v19    # "length":J
    .restart local v8    # "length":J
    invoke-static {v5, v6, v7, v8, v9}, Lfi/iki/elonen/NanoHTTPD;->newFixedLengthResponse(Lfi/iki/elonen/NanoHTTPD$Response$IStatus;Ljava/lang/String;Ljava/io/InputStream;J)Lfi/iki/elonen/NanoHTTPD$Response;

    move-result-object v5

    .line 79
    .local v5, "response":Lfi/iki/elonen/NanoHTTPD$Response;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "bytes "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-wide/from16 v6, v21

    .end local v21    # "end":J
    .local v6, "end":J
    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v10, "/"

    invoke-virtual {v4, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v14, v15}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v10, "Content-Range"

    invoke-virtual {v5, v10, v4}, Lfi/iki/elonen/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    const-string v4, "Accept-Ranges"

    const-string v10, "bytes"

    invoke-virtual {v5, v4, v10}, Lfi/iki/elonen/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    invoke-static {v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    return-object v5
.end method
