.class public final Lcom/cineflix/android/AndroidBridge;
.super Ljava/lang/Object;
.source "AndroidBridge.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAndroidBridge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidBridge.kt\ncom/cineflix/android/AndroidBridge\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,322:1\n1#2:323\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0008J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0006\u0010\u0014\u001a\u00020\u000eJ \u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0007J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0007J\u0008\u0010\u001b\u001a\u00020\u000eH\u0007J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0010H\u0007J8\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0007J\u0008\u0010%\u001a\u00020\u000eH\u0007J\u0016\u0010&\u001a\u00020\u000e2\u000c\u0010\'\u001a\u0008\u0012\u0004\u0012\u00020\u000e0(H\u0002J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010H\u0007J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u0010H\u0002J\u0018\u0010/\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0007J\u0010\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u0010H\u0007J\u0010\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u0010H\u0007J\u001e\u00104\u001a\u00020\u00102\u000c\u00105\u001a\u0008\u0012\u0004\u0012\u000207062\u0006\u0010\u001f\u001a\u000208H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00069"
    }
    d2 = {
        "Lcom/cineflix/android/AndroidBridge;",
        "",
        "context",
        "Landroid/content/Context;",
        "webView",
        "Landroid/webkit/WebView;",
        "engine",
        "Lcom/cineflix/android/TelegramEngine;",
        "(Landroid/content/Context;Landroid/webkit/WebView;Lcom/cineflix/android/TelegramEngine;)V",
        "lastBotResponse",
        "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
        "scope",
        "Lkotlinx/coroutines/CoroutineScope;",
        "callback",
        "",
        "queryId",
        "",
        "success",
        "",
        "payload",
        "cleanup",
        "clickInlineButton",
        "msgIdStr",
        "buttonIndex",
        "getVideoMessages",
        "limitStr",
        "minIdStr",
        "logOut",
        "loginWithPhone",
        "phone",
        "playVideo",
        "chatId",
        "msgId",
        "fileId",
        "fileSize",
        "mimeType",
        "title",
        "requestAuthState",
        "runOnUiThread",
        "block",
        "Lkotlin/Function0;",
        "searchMovieByPayload",
        "searchTitle",
        "sendAuthError",
        "msg",
        "sendAuthState",
        "state",
        "sendBotCommand",
        "signInWithCode",
        "code",
        "signInWithPassword",
        "password",
        "videosToJson",
        "videos",
        "",
        "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
        "",
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


# instance fields
.field private final context:Landroid/content/Context;

.field private final engine:Lcom/cineflix/android/TelegramEngine;

.field private volatile lastBotResponse:Lcom/cineflix/android/TelegramEngine$SeasonResponse;

.field private final scope:Lkotlinx/coroutines/CoroutineScope;

.field private final webView:Landroid/webkit/WebView;


# direct methods
.method public static synthetic $r8$lambda$lKLUSQxsa2u69S47iYaFedIDw94(Lkotlin/jvm/functions/Function0;)V
    .locals 0

    invoke-static {p0}, Lcom/cineflix/android/AndroidBridge;->runOnUiThread$lambda$2(Lkotlin/jvm/functions/Function0;)V

    return-void
.end method

.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0x8

    sput v0, Lcom/cineflix/android/AndroidBridge;->$stable:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/webkit/WebView;Lcom/cineflix/android/TelegramEngine;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "webView"    # Landroid/webkit/WebView;
    .param p3, "engine"    # Lcom/cineflix/android/TelegramEngine;

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "webView"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "engine"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/cineflix/android/AndroidBridge;->context:Landroid/content/Context;

    .line 28
    iput-object p2, p0, Lcom/cineflix/android/AndroidBridge;->webView:Landroid/webkit/WebView;

    .line 29
    iput-object p3, p0, Lcom/cineflix/android/AndroidBridge;->engine:Lcom/cineflix/android/TelegramEngine;

    .line 31
    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v1, v2, v1}, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job;ILjava/lang/Object;)Lkotlinx/coroutines/CompletableJob;

    move-result-object v1

    check-cast v1, Lkotlin/coroutines/CoroutineContext;

    invoke-virtual {v0, v1}, Lkotlinx/coroutines/CoroutineDispatcher;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;

    move-result-object v0

    invoke-static {v0}, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;

    move-result-object v0

    iput-object v0, p0, Lcom/cineflix/android/AndroidBridge;->scope:Lkotlinx/coroutines/CoroutineScope;

    .line 26
    return-void
.end method

.method public static final synthetic access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V
    .locals 0
    .param p0, "$this"    # Lcom/cineflix/android/AndroidBridge;
    .param p1, "queryId"    # Ljava/lang/String;
    .param p2, "success"    # Z
    .param p3, "payload"    # Ljava/lang/String;

    .line 26
    invoke-direct {p0, p1, p2, p3}, Lcom/cineflix/android/AndroidBridge;->callback(Ljava/lang/String;ZLjava/lang/String;)V

    return-void
.end method

.method public static final synthetic access$getEngine$p(Lcom/cineflix/android/AndroidBridge;)Lcom/cineflix/android/TelegramEngine;
    .locals 1
    .param p0, "$this"    # Lcom/cineflix/android/AndroidBridge;

    .line 26
    iget-object v0, p0, Lcom/cineflix/android/AndroidBridge;->engine:Lcom/cineflix/android/TelegramEngine;

    return-object v0
.end method

.method public static final synthetic access$getLastBotResponse$p(Lcom/cineflix/android/AndroidBridge;)Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    .locals 1
    .param p0, "$this"    # Lcom/cineflix/android/AndroidBridge;

    .line 26
    iget-object v0, p0, Lcom/cineflix/android/AndroidBridge;->lastBotResponse:Lcom/cineflix/android/TelegramEngine$SeasonResponse;

    return-object v0
.end method

.method public static final synthetic access$getWebView$p(Lcom/cineflix/android/AndroidBridge;)Landroid/webkit/WebView;
    .locals 1
    .param p0, "$this"    # Lcom/cineflix/android/AndroidBridge;

    .line 26
    iget-object v0, p0, Lcom/cineflix/android/AndroidBridge;->webView:Landroid/webkit/WebView;

    return-object v0
.end method

.method public static final synthetic access$sendAuthError(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;)V
    .locals 0
    .param p0, "$this"    # Lcom/cineflix/android/AndroidBridge;
    .param p1, "msg"    # Ljava/lang/String;

    .line 26
    invoke-direct {p0, p1}, Lcom/cineflix/android/AndroidBridge;->sendAuthError(Ljava/lang/String;)V

    return-void
.end method

.method public static final synthetic access$sendAuthState(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;)V
    .locals 0
    .param p0, "$this"    # Lcom/cineflix/android/AndroidBridge;
    .param p1, "state"    # Ljava/lang/String;

    .line 26
    invoke-direct {p0, p1}, Lcom/cineflix/android/AndroidBridge;->sendAuthState(Ljava/lang/String;)V

    return-void
.end method

.method public static final synthetic access$setLastBotResponse$p(Lcom/cineflix/android/AndroidBridge;Lcom/cineflix/android/TelegramEngine$SeasonResponse;)V
    .locals 0
    .param p0, "$this"    # Lcom/cineflix/android/AndroidBridge;
    .param p1, "<set-?>"    # Lcom/cineflix/android/TelegramEngine$SeasonResponse;

    .line 26
    iput-object p1, p0, Lcom/cineflix/android/AndroidBridge;->lastBotResponse:Lcom/cineflix/android/TelegramEngine$SeasonResponse;

    return-void
.end method

.method public static final synthetic access$videosToJson(Lcom/cineflix/android/AndroidBridge;Ljava/util/List;J)Ljava/lang/String;
    .locals 1
    .param p0, "$this"    # Lcom/cineflix/android/AndroidBridge;
    .param p1, "videos"    # Ljava/util/List;
    .param p2, "chatId"    # J

    .line 26
    invoke-direct {p0, p1, p2, p3}, Lcom/cineflix/android/AndroidBridge;->videosToJson(Ljava/util/List;J)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private final callback(Ljava/lang/String;ZLjava/lang/String;)V
    .locals 12
    .param p1, "queryId"    # Ljava/lang/String;
    .param p2, "success"    # Z
    .param p3, "payload"    # Ljava/lang/String;

    .line 282
    nop

    .line 283
    const-string v1, "\\"

    const-string v2, "\\\\"

    const/4 v3, 0x0

    const/4 v4, 0x4

    const/4 v5, 0x0

    move-object v0, p3

    invoke-static/range {v0 .. v5}, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 284
    const-string v7, "\'"

    const-string v8, "\\\'"

    const/4 v9, 0x0

    const/4 v10, 0x4

    const/4 v11, 0x0

    invoke-static/range {v6 .. v11}, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 285
    const-string v1, "\n"

    const-string v2, "\\n"

    invoke-static/range {v0 .. v5}, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 286
    const-string v7, "\r"

    const-string v8, ""

    invoke-static/range {v6 .. v11}, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 282
    nop

    .line 287
    .local v0, "escaped":Ljava/lang/String;
    new-instance v1, Lcom/cineflix/android/AndroidBridge$callback$1;

    invoke-direct {v1, p0, p1, p2, v0}, Lcom/cineflix/android/AndroidBridge$callback$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    invoke-direct {p0, v1}, Lcom/cineflix/android/AndroidBridge;->runOnUiThread(Lkotlin/jvm/functions/Function0;)V

    .line 293
    return-void
.end method

.method private final runOnUiThread(Lkotlin/jvm/functions/Function0;)V
    .locals 2
    .param p1, "block"    # Lkotlin/jvm/functions/Function0;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function0<",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    .line 296
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v1, Lcom/cineflix/android/AndroidBridge$$ExternalSyntheticLambda0;

    invoke-direct {v1, p1}, Lcom/cineflix/android/AndroidBridge$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function0;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 297
    return-void
.end method

.method private static final runOnUiThread$lambda$2(Lkotlin/jvm/functions/Function0;)V
    .locals 1
    .param p0, "$tmp0"    # Lkotlin/jvm/functions/Function0;

    const-string v0, "$tmp0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 296
    invoke-interface {p0}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    return-void
.end method

.method private final sendAuthError(Ljava/lang/String;)V
    .locals 12
    .param p1, "msg"    # Ljava/lang/String;

    .line 273
    const-string v1, "\'"

    const-string v2, "\\\'"

    const/4 v3, 0x0

    const/4 v4, 0x4

    const/4 v5, 0x0

    move-object v0, p1

    invoke-static/range {v0 .. v5}, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "\n"

    const-string v8, " "

    const/4 v9, 0x0

    const/4 v10, 0x4

    const/4 v11, 0x0

    invoke-static/range {v6 .. v11}, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 274
    .local v0, "escaped":Ljava/lang/String;
    new-instance v1, Lcom/cineflix/android/AndroidBridge$sendAuthError$1;

    invoke-direct {v1, p0, v0}, Lcom/cineflix/android/AndroidBridge$sendAuthError$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    invoke-direct {p0, v1}, Lcom/cineflix/android/AndroidBridge;->runOnUiThread(Lkotlin/jvm/functions/Function0;)V

    .line 277
    return-void
.end method

.method private final sendAuthState(Ljava/lang/String;)V
    .locals 1
    .param p1, "state"    # Ljava/lang/String;

    .line 267
    new-instance v0, Lcom/cineflix/android/AndroidBridge$sendAuthState$1;

    invoke-direct {v0, p0, p1}, Lcom/cineflix/android/AndroidBridge$sendAuthState$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    invoke-direct {p0, v0}, Lcom/cineflix/android/AndroidBridge;->runOnUiThread(Lkotlin/jvm/functions/Function0;)V

    .line 270
    return-void
.end method

.method private final videosToJson(Ljava/util/List;J)Ljava/lang/String;
    .locals 9
    .param p1, "videos"    # Ljava/util/List;
    .param p2, "chatId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
            ">;J)",
            "Ljava/lang/String;"
        }
    .end annotation

    .line 301
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    .line 302
    .local v0, "arr":Lorg/json/JSONArray;
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/cineflix/android/TelegramEngine$VideoInfo;

    .line 303
    .local v2, "v":Lcom/cineflix/android/TelegramEngine$VideoInfo;
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    move-object v4, v3

    .local v4, "$this$videosToJson_u24lambda_u243":Lorg/json/JSONObject;
    const/4 v5, 0x0

    .line 304
    .local v5, "$i$a$-apply-AndroidBridge$videosToJson$1":I
    const-string v6, "msgId"

    invoke-virtual {v2}, Lcom/cineflix/android/TelegramEngine$VideoInfo;->getMsgId()J

    move-result-wide v7

    invoke-virtual {v4, v6, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 305
    const-string v6, "fileName"

    invoke-virtual {v2}, Lcom/cineflix/android/TelegramEngine$VideoInfo;->getFileName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 306
    const-string v6, "fileSize"

    invoke-virtual {v2}, Lcom/cineflix/android/TelegramEngine$VideoInfo;->getFileSize()J

    move-result-wide v7

    invoke-virtual {v4, v6, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 307
    const-string v6, "mimeType"

    invoke-virtual {v2}, Lcom/cineflix/android/TelegramEngine$VideoInfo;->getMimeType()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 308
    const-string v6, "duration"

    const/4 v7, 0x0

    invoke-virtual {v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 309
    const-string v6, "width"

    invoke-virtual {v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 310
    const-string v6, "height"

    invoke-virtual {v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 311
    const-string v6, "date"

    invoke-virtual {v2}, Lcom/cineflix/android/TelegramEngine$VideoInfo;->getDate()I

    move-result v7

    invoke-virtual {v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 312
    const-string v6, "caption"

    invoke-virtual {v2}, Lcom/cineflix/android/TelegramEngine$VideoInfo;->getCaption()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 313
    const-string v6, "chatId"

    invoke-static {p2, p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 314
    const-string v6, "fileId"

    invoke-virtual {v2}, Lcom/cineflix/android/TelegramEngine$VideoInfo;->getFileId()I

    move-result v7

    invoke-virtual {v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 315
    nop

    .line 303
    .end local v4    # "$this$videosToJson_u24lambda_u243":Lorg/json/JSONObject;
    .end local v5    # "$i$a$-apply-AndroidBridge$videosToJson$1":I
    invoke-virtual {v0, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_0

    .line 317
    .end local v2    # "v":Lcom/cineflix/android/TelegramEngine$VideoInfo;
    :cond_0
    invoke-virtual {v0}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "toString(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v1
.end method


# virtual methods
.method public final cleanup()V
    .locals 3

    .line 320
    iget-object v0, p0, Lcom/cineflix/android/AndroidBridge;->scope:Lkotlinx/coroutines/CoroutineScope;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v0, v1, v2, v1}, Lkotlinx/coroutines/CoroutineScopeKt;->cancel$default(Lkotlinx/coroutines/CoroutineScope;Ljava/util/concurrent/CancellationException;ILjava/lang/Object;)V

    return-void
.end method

.method public final clickInlineButton(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "queryId"    # Ljava/lang/String;
    .param p2, "msgIdStr"    # Ljava/lang/String;
    .param p3, "buttonIndex"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    const-string v0, "queryId"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "msgIdStr"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "buttonIndex"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 174
    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge;->scope:Lkotlinx/coroutines/CoroutineScope;

    const/4 v2, 0x0

    const/4 v3, 0x0

    new-instance v0, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;

    const/4 v4, 0x0

    invoke-direct {v0, p0, p3, p1, v4}, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    move-object v4, v0

    check-cast v4, Lkotlin/jvm/functions/Function2;

    const/4 v5, 0x3

    const/4 v6, 0x0

    invoke-static/range {v1 .. v6}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 199
    return-void
.end method

.method public final getVideoMessages(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 10
    .param p1, "queryId"    # Ljava/lang/String;
    .param p2, "limitStr"    # Ljava/lang/String;
    .param p3, "minIdStr"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    const-string v0, "queryId"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "limitStr"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "minIdStr"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 226
    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge;->scope:Lkotlinx/coroutines/CoroutineScope;

    const/4 v2, 0x0

    const/4 v3, 0x0

    new-instance v0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;

    const/4 v9, 0x0

    move-object v4, v0

    move-object v5, p2

    move-object v6, p3

    move-object v7, p0

    move-object v8, p1

    invoke-direct/range {v4 .. v9}, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    move-object v4, v0

    check-cast v4, Lkotlin/jvm/functions/Function2;

    const/4 v5, 0x3

    const/4 v6, 0x0

    invoke-static/range {v1 .. v6}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 237
    return-void
.end method

.method public final logOut()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .line 114
    iget-object v0, p0, Lcom/cineflix/android/AndroidBridge;->engine:Lcom/cineflix/android/TelegramEngine;

    new-instance v1, Lcom/cineflix/android/AndroidBridge$logOut$1;

    invoke-direct {v1, p0}, Lcom/cineflix/android/AndroidBridge$logOut$1;-><init>(Lcom/cineflix/android/AndroidBridge;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    invoke-virtual {v0, v1}, Lcom/cineflix/android/TelegramEngine;->logout(Lkotlin/jvm/functions/Function0;)V

    .line 115
    return-void
.end method

.method public final loginWithPhone(Ljava/lang/String;)V
    .locals 7
    .param p1, "phone"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    const-string v0, "phone"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 54
    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge;->scope:Lkotlinx/coroutines/CoroutineScope;

    const/4 v2, 0x0

    const/4 v3, 0x0

    new-instance v0, Lcom/cineflix/android/AndroidBridge$loginWithPhone$1;

    const/4 v4, 0x0

    invoke-direct {v0, p0, p1, v4}, Lcom/cineflix/android/AndroidBridge$loginWithPhone$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    move-object v4, v0

    check-cast v4, Lkotlin/jvm/functions/Function2;

    const/4 v5, 0x3

    const/4 v6, 0x0

    invoke-static/range {v1 .. v6}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 70
    return-void
.end method

.method public final playVideo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 9
    .param p1, "chatId"    # Ljava/lang/String;
    .param p2, "msgId"    # Ljava/lang/String;
    .param p3, "fileId"    # Ljava/lang/String;
    .param p4, "fileSize"    # Ljava/lang/String;
    .param p5, "mimeType"    # Ljava/lang/String;
    .param p6, "title"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    const-string v0, "chatId"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "msgId"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "fileId"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "fileSize"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "mimeType"

    invoke-static {p5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "title"

    invoke-static {p6, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 250
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/cineflix/android/AndroidBridge;->context:Landroid/content/Context;

    const-class v3, Lcom/cineflix/android/ui/player/PlayerActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object v2, v1

    .local v2, "$this$playVideo_u24lambda_u241":Landroid/content/Intent;
    const/4 v3, 0x0

    .line 251
    .local v3, "$i$a$-apply-AndroidBridge$playVideo$intent$1":I
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 252
    invoke-static {p1}, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    const-wide/16 v5, 0x0

    if-eqz v4, :cond_0

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    goto :goto_0

    :cond_0
    move-wide v7, v5

    :goto_0
    const-string v4, "chat_id"

    invoke-virtual {v2, v4, v7, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 253
    invoke-static {p2}, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    if-eqz v4, :cond_1

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    goto :goto_1

    :cond_1
    move-wide v7, v5

    :goto_1
    const-string v4, "msg_id"

    invoke-virtual {v2, v4, v7, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 254
    invoke-static {p3}, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    const/4 v7, 0x0

    if-eqz v4, :cond_2

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    goto :goto_2

    :cond_2
    move v4, v7

    :goto_2
    const-string v8, "file_id"

    invoke-virtual {v2, v8, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 255
    invoke-static {p4}, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    if-eqz v4, :cond_3

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    :cond_3
    const-string v4, "file_size"

    invoke-virtual {v2, v4, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 256
    move-object v4, p5

    check-cast v4, Ljava/lang/CharSequence;

    invoke-interface {v4}, Ljava/lang/CharSequence;->length()I

    move-result v5

    if-nez v5, :cond_4

    const/4 v7, 0x1

    :cond_4
    if-eqz v7, :cond_5

    .line 323
    const/4 v4, 0x0

    .line 256
    .local v4, "$i$a$-ifEmpty-AndroidBridge$playVideo$intent$1$1":I
    nop

    .end local v4    # "$i$a$-ifEmpty-AndroidBridge$playVideo$intent$1$1":I
    const-string v4, "video/mp4"

    :cond_5
    check-cast v4, Ljava/lang/String;

    const-string v5, "mime_type"

    invoke-virtual {v2, v5, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 257
    invoke-virtual {v2, v0, p6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 258
    nop

    .line 250
    .end local v2    # "$this$playVideo_u24lambda_u241":Landroid/content/Intent;
    .end local v3    # "$i$a$-apply-AndroidBridge$playVideo$intent$1":I
    move-object v0, v1

    .line 259
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge;->context:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 260
    return-void
.end method

.method public final requestAuthState()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .line 39
    iget-object v0, p0, Lcom/cineflix/android/AndroidBridge;->engine:Lcom/cineflix/android/TelegramEngine;

    invoke-virtual {v0}, Lcom/cineflix/android/TelegramEngine;->getAuthState()Lkotlinx/coroutines/flow/StateFlow;

    move-result-object v0

    invoke-interface {v0}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/cineflix/android/TelegramEngine$AuthState;

    .line 40
    instance-of v1, v0, Lcom/cineflix/android/TelegramEngine$AuthState$Ready;

    if-eqz v1, :cond_0

    const-string v0, "READY"

    goto :goto_0

    .line 41
    :cond_0
    instance-of v1, v0, Lcom/cineflix/android/TelegramEngine$AuthState$WaitPhone;

    if-eqz v1, :cond_1

    const-string v0, "WAIT_PHONE"

    goto :goto_0

    .line 42
    :cond_1
    instance-of v1, v0, Lcom/cineflix/android/TelegramEngine$AuthState$WaitCode;

    if-eqz v1, :cond_2

    const-string v0, "WAIT_CODE"

    goto :goto_0

    .line 43
    :cond_2
    instance-of v0, v0, Lcom/cineflix/android/TelegramEngine$AuthState$WaitPassword;

    if-eqz v0, :cond_3

    const-string v0, "WAIT_PASSWORD"

    goto :goto_0

    .line 44
    :cond_3
    const-string v0, "UNKNOWN"

    .line 39
    :goto_0
    nop

    .line 46
    .local v0, "state":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/cineflix/android/AndroidBridge;->sendAuthState(Ljava/lang/String;)V

    .line 47
    return-void
.end method

.method public final searchMovieByPayload(Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "queryId"    # Ljava/lang/String;
    .param p2, "searchTitle"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    const-string v0, "queryId"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "searchTitle"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 208
    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge;->scope:Lkotlinx/coroutines/CoroutineScope;

    const/4 v2, 0x0

    const/4 v3, 0x0

    new-instance v0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;

    const/4 v4, 0x0

    invoke-direct {v0, p0, p2, p1, v4}, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    move-object v4, v0

    check-cast v4, Lkotlin/jvm/functions/Function2;

    const/4 v5, 0x3

    const/4 v6, 0x0

    invoke-static/range {v1 .. v6}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 217
    return-void
.end method

.method public final sendBotCommand(Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "queryId"    # Ljava/lang/String;
    .param p2, "payload"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    const-string v0, "queryId"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "payload"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 135
    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge;->scope:Lkotlinx/coroutines/CoroutineScope;

    const/4 v2, 0x0

    const/4 v3, 0x0

    new-instance v0, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;

    const/4 v4, 0x0

    invoke-direct {v0, p0, p2, p1, v4}, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    move-object v4, v0

    check-cast v4, Lkotlin/jvm/functions/Function2;

    const/4 v5, 0x3

    const/4 v6, 0x0

    invoke-static/range {v1 .. v6}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 163
    return-void
.end method

.method public final signInWithCode(Ljava/lang/String;)V
    .locals 7
    .param p1, "code"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    const-string v0, "code"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 74
    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge;->scope:Lkotlinx/coroutines/CoroutineScope;

    const/4 v2, 0x0

    const/4 v3, 0x0

    new-instance v0, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;

    const/4 v4, 0x0

    invoke-direct {v0, p0, p1, v4}, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    move-object v4, v0

    check-cast v4, Lkotlin/jvm/functions/Function2;

    const/4 v5, 0x3

    const/4 v6, 0x0

    invoke-static/range {v1 .. v6}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 91
    return-void
.end method

.method public final signInWithPassword(Ljava/lang/String;)V
    .locals 7
    .param p1, "password"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    const-string v0, "password"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 95
    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge;->scope:Lkotlinx/coroutines/CoroutineScope;

    const/4 v2, 0x0

    const/4 v3, 0x0

    new-instance v0, Lcom/cineflix/android/AndroidBridge$signInWithPassword$1;

    const/4 v4, 0x0

    invoke-direct {v0, p0, p1, v4}, Lcom/cineflix/android/AndroidBridge$signInWithPassword$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    move-object v4, v0

    check-cast v4, Lkotlin/jvm/functions/Function2;

    const/4 v5, 0x3

    const/4 v6, 0x0

    invoke-static/range {v1 .. v6}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 110
    return-void
.end method
