.class public final Lcom/cineflix/android/TelegramEngine;
.super Ljava/lang/Object;
.source "TelegramEngine.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/cineflix/android/TelegramEngine$AuthState;,
        Lcom/cineflix/android/TelegramEngine$Companion;,
        Lcom/cineflix/android/TelegramEngine$FileState;,
        Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;,
        Lcom/cineflix/android/TelegramEngine$MsgCollector;,
        Lcom/cineflix/android/TelegramEngine$SeasonButton;,
        Lcom/cineflix/android/TelegramEngine$SeasonResponse;,
        Lcom/cineflix/android/TelegramEngine$VideoInfo;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nTelegramEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelegramEngine.kt\ncom/cineflix/android/TelegramEngine\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,567:1\n72#2,2:568\n72#2,2:572\n1#3:570\n1#3:571\n1#3:574\n314#4,11:575\n*S KotlinDebug\n*F\n+ 1 TelegramEngine.kt\ncom/cineflix/android/TelegramEngine\n*L\n159#1:568,2\n421#1:572,2\n159#1:570\n421#1:574\n547#1:575,11\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0010\u0012\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0012\u0008\u0007\u0018\u0000 `2\u00020\u0001:\u0008_`abcdefB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012J,\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010)J \u0010*\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00122\u0008\u0008\u0002\u0010+\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010,J \u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020&J\u0012\u00101\u001a\u0004\u0018\u00010$2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u0004\u0018\u00010&H\u0082@\u00a2\u0006\u0002\u00105J\u0010\u00106\u001a\u0004\u0018\u00010&H\u0086@\u00a2\u0006\u0002\u00105J\u0008\u00107\u001a\u0004\u0018\u00010\rJ\u0016\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\t2\u0006\u0010!\u001a\u00020\u0012J\u001c\u00109\u001a\u00020 2\u0014\u0010:\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010<\u0012\u0004\u0012\u00020 0;J(\u0010=\u001a\u0008\u0012\u0004\u0012\u00020$0#2\u0008\u0008\u0002\u0010>\u001a\u00020\u00122\u0008\u0008\u0002\u0010?\u001a\u00020&H\u0086@\u00a2\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020 2\u0006\u00102\u001a\u000203H\u0002J\u0010\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020JH\u0002J \u0010K\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010/\u001a\u00020&2\u0008\u0008\u0002\u0010>\u001a\u00020&J\u0008\u0010L\u001a\u00020 H\u0002J\u0014\u0010M\u001a\u00020 2\u000c\u0010N\u001a\u0008\u0012\u0004\u0012\u00020 0OJ \u0010P\u001a\u0004\u0018\u00010.2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020&J\u001c\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020$0#2\u0006\u0010R\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010SJ\u0018\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010SJ\"\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020\u00102\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020 0;J\"\u0010Z\u001a\u00020 2\u0006\u0010[\u001a\u00020\u00102\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020 0;J\"\u0010\\\u001a\u00020 2\u0006\u0010]\u001a\u00020\u00102\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020 0;J\"\u0010^\u001a\u0004\u0018\u00010\u00102\u0006\u0010!\u001a\u00020\u00122\u0008\u0008\u0002\u0010+\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010,R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000f\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R \u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u00160\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00060\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001a0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006g"
    }
    d2 = {
        "Lcom/cineflix/android/TelegramEngine;",
        "",
        "context",
        "Landroid/content/Context;",
        "(Landroid/content/Context;)V",
        "_authState",
        "Lkotlinx/coroutines/flow/MutableStateFlow;",
        "Lcom/cineflix/android/TelegramEngine$AuthState;",
        "authState",
        "Lkotlinx/coroutines/flow/StateFlow;",
        "getAuthState",
        "()Lkotlinx/coroutines/flow/StateFlow;",
        "client",
        "Lorg/drinkless/tdlib/Client;",
        "fileIdCache",
        "Ljava/util/concurrent/ConcurrentHashMap;",
        "",
        "Lkotlin/Pair;",
        "",
        "getFileIdCache",
        "()Ljava/util/concurrent/ConcurrentHashMap;",
        "filePathEmitters",
        "Lkotlinx/coroutines/CompletableDeferred;",
        "fileStates",
        "Lcom/cineflix/android/TelegramEngine$FileState;",
        "inlineKeyboardListeners",
        "Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;",
        "msgCollectors",
        "Lcom/cineflix/android/TelegramEngine$MsgCollector;",
        "scope",
        "Lkotlinx/coroutines/CoroutineScope;",
        "cancelAndDeleteVideo",
        "",
        "fileId",
        "clickInlineButton",
        "",
        "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
        "chatId",
        "",
        "msgId",
        "dataBase64",
        "(JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "downloadAndGetPath",
        "priority",
        "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "downloadRangeAndRead",
        "",
        "offset",
        "count",
        "extractVideoInfo",
        "msg",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        "getBotChatId",
        "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "getBotChatIdPublic",
        "getClient",
        "getFileStateFlow",
        "getMe",
        "onResult",
        "Lkotlin/Function1;",
        "Lorg/drinkless/tdlib/TdApi$User;",
        "getVideoMessagesHistory",
        "limit",
        "minId",
        "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "handleAuthState",
        "state",
        "Lorg/drinkless/tdlib/TdApi$AuthorizationState;",
        "handleNewMessage",
        "handleResult",
        "result",
        "Lorg/drinkless/tdlib/TdApi$Object;",
        "handleUpdateFile",
        "file",
        "Lorg/drinkless/tdlib/TdApi$File;",
        "hintDownloadOffset",
        "initClient",
        "logout",
        "onDone",
        "Lkotlin/Function0;",
        "readFilePartSync",
        "searchMovieByPayload",
        "searchTitle",
        "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "sendBotCommand",
        "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
        "payload",
        "sendCode",
        "code",
        "onError",
        "sendPassword",
        "password",
        "sendPhone",
        "phone",
        "startDownloadReturnPath",
        "AuthState",
        "Companion",
        "FileState",
        "InlineKeyboardListener",
        "MsgCollector",
        "SeasonButton",
        "SeasonResponse",
        "VideoInfo",
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

.field public static final API_HASH:Ljava/lang/String; = "8000603d2523b8a22df55c9476d9c64a"

.field public static final API_ID:I = 0x22b0766

.field public static final BOT_USERNAME:Ljava/lang/String; = "videoclubpacobot"

.field public static final Companion:Lcom/cineflix/android/TelegramEngine$Companion;

.field private static volatile INSTANCE:Lcom/cineflix/android/TelegramEngine; = null

.field private static final TAG:Ljava/lang/String; = "TelegramEngine"


# instance fields
.field private final _authState:Lkotlinx/coroutines/flow/MutableStateFlow;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlinx/coroutines/flow/MutableStateFlow<",
            "Lcom/cineflix/android/TelegramEngine$AuthState;",
            ">;"
        }
    .end annotation
.end field

.field private final authState:Lkotlinx/coroutines/flow/StateFlow;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlinx/coroutines/flow/StateFlow<",
            "Lcom/cineflix/android/TelegramEngine$AuthState;",
            ">;"
        }
    .end annotation
.end field

.field private client:Lorg/drinkless/tdlib/Client;

.field private final context:Landroid/content/Context;

.field private final fileIdCache:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap<",
            "Ljava/lang/String;",
            "Lkotlin/Pair<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private final filePathEmitters:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap<",
            "Ljava/lang/Integer;",
            "Lkotlinx/coroutines/CompletableDeferred<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private final fileStates:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap<",
            "Ljava/lang/Integer;",
            "Lkotlinx/coroutines/flow/MutableStateFlow<",
            "Lcom/cineflix/android/TelegramEngine$FileState;",
            ">;>;"
        }
    .end annotation
.end field

.field private final inlineKeyboardListeners:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap<",
            "Ljava/lang/String;",
            "Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;",
            ">;"
        }
    .end annotation
.end field

.field private final msgCollectors:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap<",
            "Ljava/lang/String;",
            "Lcom/cineflix/android/TelegramEngine$MsgCollector;",
            ">;"
        }
    .end annotation
.end field

.field private final scope:Lkotlinx/coroutines/CoroutineScope;


# direct methods
.method public static synthetic $r8$lambda$0r3KKnQthoDYcypbwbCTqeI58ZQ(Ljava/util/concurrent/CountDownLatch;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/cineflix/android/TelegramEngine;->downloadRangeAndRead$lambda$17(Ljava/util/concurrent/CountDownLatch;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$8q_IOg7wc2jn98RJGv5eSWUkQAo(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0}, Lcom/cineflix/android/TelegramEngine;->handleAuthState$lambda$3(Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$ASXtE8DACcc5gd_UQjNVJ7OqH9I(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0}, Lcom/cineflix/android/TelegramEngine;->cancelAndDeleteVideo$lambda$20(Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$BDPAgnwVh-4U2Kb5l1Vxi24mzY8(Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/util/concurrent/CountDownLatch;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/cineflix/android/TelegramEngine;->readFilePartSync$lambda$16(Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/util/concurrent/CountDownLatch;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$Bdhdwhd9-eB5X78dIQRq4q7a1UY(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0}, Lcom/cineflix/android/TelegramEngine;->hintDownloadOffset$lambda$15(Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$D6BvQw0mKiVLr6D3TfOyuPZo8b4(Lkotlin/jvm/functions/Function1;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/cineflix/android/TelegramEngine;->sendPhone$lambda$9(Lkotlin/jvm/functions/Function1;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$JAAtyGa_ZAEXsoIw9XYz_igyRvg(Ljava/lang/Throwable;)V
    .locals 0

    invoke-static {p0}, Lcom/cineflix/android/TelegramEngine;->initClient$lambda$1(Ljava/lang/Throwable;)V

    return-void
.end method

.method public static synthetic $r8$lambda$Mbym35Nps83HOcqiq1inWTtH5X0(Lcom/cineflix/android/TelegramEngine;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/cineflix/android/TelegramEngine;->initClient$lambda$0(Lcom/cineflix/android/TelegramEngine;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$OSABYh7hTGqpooC3k4I-XJWo7Ag(Lkotlin/jvm/functions/Function0;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/cineflix/android/TelegramEngine;->logout$lambda$12(Lkotlin/jvm/functions/Function0;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$TB98Slifa2wvcsM2BnuD_Dfta_E(Lkotlin/jvm/functions/Function1;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/cineflix/android/TelegramEngine;->getMe$lambda$13(Lkotlin/jvm/functions/Function1;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$TNqXSqD2kfWkzAXl2nXtXpUwGnA(Ljava/lang/Throwable;)V
    .locals 0

    invoke-static {p0}, Lcom/cineflix/android/TelegramEngine;->initClient$lambda$2(Ljava/lang/Throwable;)V

    return-void
.end method

.method public static synthetic $r8$lambda$XjPWJQlCsmT8px6VEuAN3g66wV8(Lkotlin/jvm/functions/Function1;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/cineflix/android/TelegramEngine;->sendPassword$lambda$11(Lkotlin/jvm/functions/Function1;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$YM0eJX8Jv_rOZqu9u1T1_O3ZPZA(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0}, Lcom/cineflix/android/TelegramEngine;->cancelAndDeleteVideo$lambda$19(Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$tB0LleDcTt6CCgGB5VoTNSoheT8(Lkotlin/jvm/functions/Function1;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/cineflix/android/TelegramEngine;->sendCode$lambda$10(Lkotlin/jvm/functions/Function1;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$vW82ETCQaG7HfvORymQsAFoAWO8(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0}, Lcom/cineflix/android/TelegramEngine;->handleNewMessage$lambda$6(Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/cineflix/android/TelegramEngine$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/cineflix/android/TelegramEngine$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/cineflix/android/TelegramEngine;->Companion:Lcom/cineflix/android/TelegramEngine$Companion;

    const/16 v0, 0x8

    sput v0, Lcom/cineflix/android/TelegramEngine;->$stable:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/cineflix/android/TelegramEngine;->context:Landroid/content/Context;

    .line 33
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-static {v0, v1, v0}, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job;ILjava/lang/Object;)Lkotlinx/coroutines/CompletableJob;

    move-result-object v0

    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;

    move-result-object v1

    check-cast v1, Lkotlin/coroutines/CoroutineContext;

    invoke-interface {v0, v1}, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;

    move-result-object v0

    invoke-static {v0}, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;

    move-result-object v0

    iput-object v0, p0, Lcom/cineflix/android/TelegramEngine;->scope:Lkotlinx/coroutines/CoroutineScope;

    .line 47
    sget-object v0, Lcom/cineflix/android/TelegramEngine$AuthState$Unknown;->INSTANCE:Lcom/cineflix/android/TelegramEngine$AuthState$Unknown;

    invoke-static {v0}, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;

    move-result-object v0

    iput-object v0, p0, Lcom/cineflix/android/TelegramEngine;->_authState:Lkotlinx/coroutines/flow/MutableStateFlow;

    .line 48
    invoke-static {v0}, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;

    move-result-object v0

    iput-object v0, p0, Lcom/cineflix/android/TelegramEngine;->authState:Lkotlinx/coroutines/flow/StateFlow;

    .line 52
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/cineflix/android/TelegramEngine;->filePathEmitters:Ljava/util/concurrent/ConcurrentHashMap;

    .line 55
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/cineflix/android/TelegramEngine;->fileIdCache:Ljava/util/concurrent/ConcurrentHashMap;

    .line 89
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/cineflix/android/TelegramEngine;->msgCollectors:Ljava/util/concurrent/ConcurrentHashMap;

    .line 97
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/cineflix/android/TelegramEngine;->inlineKeyboardListeners:Ljava/util/concurrent/ConcurrentHashMap;

    .line 100
    nop

    .line 101
    invoke-direct {p0}, Lcom/cineflix/android/TelegramEngine;->initClient()V

    .line 102
    nop

    .line 418
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/cineflix/android/TelegramEngine;->fileStates:Ljava/util/concurrent/ConcurrentHashMap;

    .line 16
    return-void
.end method

.method public static final synthetic access$extractVideoInfo(Lcom/cineflix/android/TelegramEngine;Lorg/drinkless/tdlib/TdApi$Message;)Lcom/cineflix/android/TelegramEngine$VideoInfo;
    .locals 1
    .param p0, "$this"    # Lcom/cineflix/android/TelegramEngine;
    .param p1, "msg"    # Lorg/drinkless/tdlib/TdApi$Message;

    .line 16
    invoke-direct {p0, p1}, Lcom/cineflix/android/TelegramEngine;->extractVideoInfo(Lorg/drinkless/tdlib/TdApi$Message;)Lcom/cineflix/android/TelegramEngine$VideoInfo;

    move-result-object v0

    return-object v0
.end method

.method public static final synthetic access$getBotChatId(Lcom/cineflix/android/TelegramEngine;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 1
    .param p0, "$this"    # Lcom/cineflix/android/TelegramEngine;
    .param p1, "$completion"    # Lkotlin/coroutines/Continuation;

    .line 16
    invoke-direct {p0, p1}, Lcom/cineflix/android/TelegramEngine;->getBotChatId(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static final synthetic access$getClient$p(Lcom/cineflix/android/TelegramEngine;)Lorg/drinkless/tdlib/Client;
    .locals 1
    .param p0, "$this"    # Lcom/cineflix/android/TelegramEngine;

    .line 16
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    return-object v0
.end method

.method public static final synthetic access$getFilePathEmitters$p(Lcom/cineflix/android/TelegramEngine;)Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1
    .param p0, "$this"    # Lcom/cineflix/android/TelegramEngine;

    .line 16
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->filePathEmitters:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method public static final synthetic access$getINSTANCE$cp()Lcom/cineflix/android/TelegramEngine;
    .locals 1

    .line 16
    sget-object v0, Lcom/cineflix/android/TelegramEngine;->INSTANCE:Lcom/cineflix/android/TelegramEngine;

    return-object v0
.end method

.method public static final synthetic access$getInlineKeyboardListeners$p(Lcom/cineflix/android/TelegramEngine;)Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1
    .param p0, "$this"    # Lcom/cineflix/android/TelegramEngine;

    .line 16
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->inlineKeyboardListeners:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method public static final synthetic access$getMsgCollectors$p(Lcom/cineflix/android/TelegramEngine;)Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1
    .param p0, "$this"    # Lcom/cineflix/android/TelegramEngine;

    .line 16
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->msgCollectors:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method public static final synthetic access$setINSTANCE$cp(Lcom/cineflix/android/TelegramEngine;)V
    .locals 0
    .param p0, "<set-?>"    # Lcom/cineflix/android/TelegramEngine;

    .line 16
    sput-object p0, Lcom/cineflix/android/TelegramEngine;->INSTANCE:Lcom/cineflix/android/TelegramEngine;

    return-void
.end method

.method private static final cancelAndDeleteVideo$lambda$19(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0
    .param p0, "it"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 563
    return-void
.end method

.method private static final cancelAndDeleteVideo$lambda$20(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0
    .param p0, "it"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 564
    return-void
.end method

.method public static synthetic downloadAndGetPath$default(Lcom/cineflix/android/TelegramEngine;IILkotlin/coroutines/Continuation;ILjava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 460
    and-int/lit8 p4, p4, 0x2

    if-eqz p4, :cond_0

    const/16 p2, 0x20

    :cond_0
    invoke-virtual {p0, p1, p2, p3}, Lcom/cineflix/android/TelegramEngine;->downloadAndGetPath(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method private static final downloadRangeAndRead$lambda$17(Ljava/util/concurrent/CountDownLatch;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 1
    .param p0, "$downloadLatch"    # Ljava/util/concurrent/CountDownLatch;
    .param p1, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    const-string v0, "$downloadLatch"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 508
    invoke-virtual {p0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 509
    return-void
.end method

.method private final extractVideoInfo(Lorg/drinkless/tdlib/TdApi$Message;)Lcom/cineflix/android/TelegramEngine$VideoInfo;
    .locals 35
    .param p1, "msg"    # Lorg/drinkless/tdlib/TdApi$Message;

    .line 219
    move-object/from16 v1, p1

    .line 220
    const/4 v2, 0x0

    :try_start_0
    iget-object v0, v1, Lorg/drinkless/tdlib/TdApi$Message;->content:Lorg/drinkless/tdlib/TdApi$MessageContent;

    .line 221
    .local v0, "c":Lorg/drinkless/tdlib/TdApi$MessageContent;
    instance-of v3, v0, Lorg/drinkless/tdlib/TdApi$MessageDocument;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    const-string v4, "text"

    const-string v5, "video/mp4"

    const-string v7, "fileName"

    const/4 v8, 0x0

    if-eqz v3, :cond_5

    .line 222
    :try_start_1
    move-object v3, v0

    check-cast v3, Lorg/drinkless/tdlib/TdApi$MessageDocument;

    iget-object v3, v3, Lorg/drinkless/tdlib/TdApi$MessageDocument;->document:Lorg/drinkless/tdlib/TdApi$Document;

    .line 223
    .local v3, "doc":Lorg/drinkless/tdlib/TdApi$Document;
    iget-object v9, v3, Lorg/drinkless/tdlib/TdApi$Document;->mimeType:Ljava/lang/String;

    .line 224
    .local v9, "mime":Ljava/lang/String;
    invoke-static {v9}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    move-object v10, v9

    check-cast v10, Ljava/lang/CharSequence;

    const-string v11, "video"

    check-cast v11, Ljava/lang/CharSequence;

    const/4 v12, 0x2

    invoke-static {v10, v11, v8, v12, v2}, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_1

    .line 225
    iget-object v10, v3, Lorg/drinkless/tdlib/TdApi$Document;->fileName:Ljava/lang/String;

    invoke-static {v10, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v11, ".mp4"

    invoke-static {v10, v11, v8, v12, v2}, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_1

    .line 226
    iget-object v10, v3, Lorg/drinkless/tdlib/TdApi$Document;->fileName:Ljava/lang/String;

    invoke-static {v10, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v11, ".mkv"

    invoke-static {v10, v11, v8, v12, v2}, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_0

    goto :goto_0

    :cond_0
    move v10, v8

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v10, 0x1

    .line 224
    :goto_1
    nop

    .line 227
    .local v10, "isMedia":Z
    if-nez v10, :cond_2

    return-object v2

    .line 228
    :cond_2
    nop

    .line 229
    iget-wide v12, v1, Lorg/drinkless/tdlib/TdApi$Message;->id:J

    .line 230
    iget-wide v14, v1, Lorg/drinkless/tdlib/TdApi$Message;->chatId:J

    .line 231
    iget-object v11, v3, Lorg/drinkless/tdlib/TdApi$Document;->document:Lorg/drinkless/tdlib/TdApi$File;

    iget v11, v11, Lorg/drinkless/tdlib/TdApi$File;->id:I

    .line 232
    iget-object v2, v3, Lorg/drinkless/tdlib/TdApi$Document;->fileName:Ljava/lang/String;

    invoke-static {v2, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 233
    iget-object v7, v3, Lorg/drinkless/tdlib/TdApi$Document;->document:Lorg/drinkless/tdlib/TdApi$File;

    iget-wide v6, v7, Lorg/drinkless/tdlib/TdApi$File;->size:J

    .line 234
    move-object/from16 v17, v9

    check-cast v17, Ljava/lang/CharSequence;

    invoke-interface/range {v17 .. v17}, Ljava/lang/CharSequence;->length()I

    move-result v18

    if-nez v18, :cond_3

    const/16 v16, 0x1

    goto :goto_2

    :cond_3
    move/from16 v16, v8

    :goto_2
    if-eqz v16, :cond_4

    .line 571
    const/4 v8, 0x0

    .line 234
    .local v8, "$i$a$-ifEmpty-TelegramEngine$extractVideoInfo$1":I
    nop

    .end local v8    # "$i$a$-ifEmpty-TelegramEngine$extractVideoInfo$1":I
    goto :goto_3

    :cond_4
    move-object/from16 v5, v17

    :goto_3
    move-object/from16 v20, v5

    check-cast v20, Ljava/lang/String;

    .line 235
    move-object v5, v0

    check-cast v5, Lorg/drinkless/tdlib/TdApi$MessageDocument;

    iget-object v5, v5, Lorg/drinkless/tdlib/TdApi$MessageDocument;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    iget-object v5, v5, Lorg/drinkless/tdlib/TdApi$FormattedText;->text:Ljava/lang/String;

    invoke-static {v5, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 236
    iget v4, v1, Lorg/drinkless/tdlib/TdApi$Message;->date:I

    .line 228
    new-instance v8, Lcom/cineflix/android/TelegramEngine$VideoInfo;

    move/from16 v16, v11

    move-object v11, v8

    move-object/from16 v17, v2

    move-wide/from16 v18, v6

    move-object/from16 v21, v5

    move/from16 v22, v4

    invoke-direct/range {v11 .. v22}, Lcom/cineflix/android/TelegramEngine$VideoInfo;-><init>(JJILjava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    move-object v2, v8

    .end local v3    # "doc":Lorg/drinkless/tdlib/TdApi$Document;
    .end local v9    # "mime":Ljava/lang/String;
    .end local v10    # "isMedia":Z
    goto :goto_6

    .line 239
    :cond_5
    instance-of v2, v0, Lorg/drinkless/tdlib/TdApi$MessageVideo;

    if-eqz v2, :cond_8

    .line 240
    move-object v2, v0

    check-cast v2, Lorg/drinkless/tdlib/TdApi$MessageVideo;

    iget-object v2, v2, Lorg/drinkless/tdlib/TdApi$MessageVideo;->video:Lorg/drinkless/tdlib/TdApi$Video;

    .line 241
    .local v2, "vid":Lorg/drinkless/tdlib/TdApi$Video;
    nop

    .line 242
    iget-wide v9, v1, Lorg/drinkless/tdlib/TdApi$Message;->id:J

    .line 243
    iget-wide v11, v1, Lorg/drinkless/tdlib/TdApi$Message;->chatId:J

    .line 244
    iget-object v3, v2, Lorg/drinkless/tdlib/TdApi$Video;->video:Lorg/drinkless/tdlib/TdApi$File;

    iget v3, v3, Lorg/drinkless/tdlib/TdApi$File;->id:I

    .line 245
    iget-object v6, v2, Lorg/drinkless/tdlib/TdApi$Video;->fileName:Ljava/lang/String;

    invoke-static {v6, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 246
    iget-object v7, v2, Lorg/drinkless/tdlib/TdApi$Video;->video:Lorg/drinkless/tdlib/TdApi$File;

    iget-wide v13, v7, Lorg/drinkless/tdlib/TdApi$File;->size:J

    .line 247
    iget-object v7, v2, Lorg/drinkless/tdlib/TdApi$Video;->mimeType:Ljava/lang/String;

    check-cast v7, Ljava/lang/CharSequence;

    invoke-interface {v7}, Ljava/lang/CharSequence;->length()I

    move-result v15

    if-nez v15, :cond_6

    const/16 v16, 0x1

    goto :goto_4

    :cond_6
    move/from16 v16, v8

    :goto_4
    if-eqz v16, :cond_7

    .line 571
    const/4 v7, 0x0

    .line 247
    .local v7, "$i$a$-ifEmpty-TelegramEngine$extractVideoInfo$2":I
    nop

    .end local v7    # "$i$a$-ifEmpty-TelegramEngine$extractVideoInfo$2":I
    goto :goto_5

    :cond_7
    move-object v5, v7

    :goto_5
    const-string v7, "ifEmpty(...)"

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    move-object/from16 v32, v5

    check-cast v32, Ljava/lang/String;

    .line 248
    move-object v5, v0

    check-cast v5, Lorg/drinkless/tdlib/TdApi$MessageVideo;

    iget-object v5, v5, Lorg/drinkless/tdlib/TdApi$MessageVideo;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    iget-object v5, v5, Lorg/drinkless/tdlib/TdApi$FormattedText;->text:Ljava/lang/String;

    invoke-static {v5, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 249
    iget v4, v1, Lorg/drinkless/tdlib/TdApi$Message;->date:I

    .line 241
    new-instance v7, Lcom/cineflix/android/TelegramEngine$VideoInfo;

    move-object/from16 v23, v7

    move-wide/from16 v24, v9

    move-wide/from16 v26, v11

    move/from16 v28, v3

    move-object/from16 v29, v6

    move-wide/from16 v30, v13

    move-object/from16 v33, v5

    move/from16 v34, v4

    invoke-direct/range {v23 .. v34}, Lcom/cineflix/android/TelegramEngine$VideoInfo;-><init>(JJILjava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-object v2, v7

    .end local v2    # "vid":Lorg/drinkless/tdlib/TdApi$Video;
    goto :goto_6

    .line 252
    :cond_8
    const/4 v2, 0x0

    .end local v0    # "c":Lorg/drinkless/tdlib/TdApi$MessageContent;
    :goto_6
    goto :goto_7

    .line 254
    :catch_0
    move-exception v0

    const/4 v2, 0x0

    .line 219
    :goto_7
    return-object v2
.end method

.method private final getBotChatId(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 9
    .param p1, "$completion"    # Lkotlin/coroutines/Continuation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Ljava/lang/Long;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 547
    const/4 v0, 0x0

    .line 575
    .local v0, "$i$f$suspendCancellableCoroutine":I
    move-object v1, p1

    .local v1, "uCont$iv":Lkotlin/coroutines/Continuation;
    const/4 v2, 0x0

    .line 576
    .local v2, "$i$a$-suspendCoroutineUninterceptedOrReturn-CancellableContinuationKt$suspendCancellableCoroutine$2$iv":I
    new-instance v3, Lkotlinx/coroutines/CancellableContinuationImpl;

    invoke-static {v1}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->intercepted(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object v4

    const/4 v5, 0x1

    invoke-direct {v3, v4, v5}, Lkotlinx/coroutines/CancellableContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;I)V

    .line 582
    .local v3, "cancellable$iv":Lkotlinx/coroutines/CancellableContinuationImpl;
    invoke-virtual {v3}, Lkotlinx/coroutines/CancellableContinuationImpl;->initCancellability()V

    .line 583
    move-object v4, v3

    check-cast v4, Lkotlinx/coroutines/CancellableContinuation;

    .local v4, "cont":Lkotlinx/coroutines/CancellableContinuation;
    const/4 v5, 0x0

    .line 548
    .local v5, "$i$a$-suspendCancellableCoroutine-TelegramEngine$getBotChatId$2":I
    invoke-static {p0}, Lcom/cineflix/android/TelegramEngine;->access$getClient$p(Lcom/cineflix/android/TelegramEngine;)Lorg/drinkless/tdlib/Client;

    move-result-object v6

    if-eqz v6, :cond_0

    new-instance v7, Lorg/drinkless/tdlib/TdApi$SearchPublicChat;

    const-string v8, "videoclubpacobot"

    invoke-direct {v7, v8}, Lorg/drinkless/tdlib/TdApi$SearchPublicChat;-><init>(Ljava/lang/String;)V

    check-cast v7, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v8, Lcom/cineflix/android/TelegramEngine$getBotChatId$2$1;

    invoke-direct {v8, v4}, Lcom/cineflix/android/TelegramEngine$getBotChatId$2$1;-><init>(Lkotlinx/coroutines/CancellableContinuation;)V

    check-cast v8, Lorg/drinkless/tdlib/Client$ResultHandler;

    invoke-virtual {v6, v7, v8}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    .line 551
    :cond_0
    nop

    .line 583
    .end local v4    # "cont":Lkotlinx/coroutines/CancellableContinuation;
    .end local v5    # "$i$a$-suspendCancellableCoroutine-TelegramEngine$getBotChatId$2":I
    nop

    .line 584
    invoke-virtual {v3}, Lkotlinx/coroutines/CancellableContinuationImpl;->getResult()Ljava/lang/Object;

    move-result-object v1

    .line 575
    .end local v1    # "uCont$iv":Lkotlin/coroutines/Continuation;
    .end local v2    # "$i$a$-suspendCoroutineUninterceptedOrReturn-CancellableContinuationKt$suspendCancellableCoroutine$2$iv":I
    .end local v3    # "cancellable$iv":Lkotlinx/coroutines/CancellableContinuationImpl;
    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v2

    if-ne v1, v2, :cond_1

    invoke-static {p1}, Lkotlin/coroutines/jvm/internal/DebugProbesKt;->probeCoroutineSuspended(Lkotlin/coroutines/Continuation;)V

    .line 585
    :cond_1
    nop

    .line 551
    .end local v0    # "$i$f$suspendCancellableCoroutine":I
    return-object v1
.end method

.method private static final getMe$lambda$13(Lkotlin/jvm/functions/Function1;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 1
    .param p0, "$onResult"    # Lkotlin/jvm/functions/Function1;
    .param p1, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    const-string v0, "$onResult"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 283
    instance-of v0, p1, Lorg/drinkless/tdlib/TdApi$User;

    if-eqz v0, :cond_0

    move-object v0, p1

    check-cast v0, Lorg/drinkless/tdlib/TdApi$User;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-interface {p0, v0}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 284
    return-void
.end method

.method public static synthetic getVideoMessagesHistory$default(Lcom/cineflix/android/TelegramEngine;IJLkotlin/coroutines/Continuation;ILjava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 527
    and-int/lit8 p6, p5, 0x1

    if-eqz p6, :cond_0

    const/16 p1, 0x32

    :cond_0
    and-int/lit8 p5, p5, 0x2

    if-eqz p5, :cond_1

    const-wide/16 p2, 0x0

    :cond_1
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/cineflix/android/TelegramEngine;->getVideoMessagesHistory(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method private final handleAuthState(Lorg/drinkless/tdlib/TdApi$AuthorizationState;)V
    .locals 20
    .param p1, "state"    # Lorg/drinkless/tdlib/TdApi$AuthorizationState;

    .line 124
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Auth state: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "TelegramEngine"

    invoke-static {v3, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 125
    nop

    .line 126
    instance-of v2, v1, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitTdlibParameters;

    if-eqz v2, :cond_0

    .line 127
    new-instance v2, Ljava/io/File;

    iget-object v3, v0, Lcom/cineflix/android/TelegramEngine;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v3

    const-string v4, "tdlib_data"

    invoke-direct {v2, v3, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    .line 128
    .local v2, "dbPath":Ljava/lang/String;
    iget-object v3, v0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    if-eqz v3, :cond_6

    new-instance v4, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;

    .line 129
    const/4 v6, 0x0

    const/4 v9, 0x0

    .line 130
    const/4 v10, 0x1

    const/4 v11, 0x1

    const/4 v12, 0x1

    const/4 v13, 0x1

    .line 131
    const v14, 0x22b0766

    const-string v15, "8000603d2523b8a22df55c9476d9c64a"

    .line 132
    const-string v16, "es"

    const-string v17, "Android"

    const-string v18, "14"

    const-string v19, "Cineflix/2.0"

    .line 128
    move-object v5, v4

    move-object v7, v2

    move-object v8, v2

    invoke-direct/range {v5 .. v19}, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;-><init>(ZLjava/lang/String;Ljava/lang/String;[BZZZZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    check-cast v4, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v5, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda12;

    invoke-direct {v5}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda12;-><init>()V

    invoke-virtual {v3, v4, v5}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    goto :goto_0

    .line 135
    .end local v2    # "dbPath":Ljava/lang/String;
    :cond_0
    instance-of v2, v1, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitPhoneNumber;

    if-eqz v2, :cond_1

    iget-object v2, v0, Lcom/cineflix/android/TelegramEngine;->_authState:Lkotlinx/coroutines/flow/MutableStateFlow;

    sget-object v3, Lcom/cineflix/android/TelegramEngine$AuthState$WaitPhone;->INSTANCE:Lcom/cineflix/android/TelegramEngine$AuthState$WaitPhone;

    invoke-interface {v2, v3}, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V

    goto :goto_0

    .line 136
    :cond_1
    instance-of v2, v1, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitCode;

    if-eqz v2, :cond_2

    iget-object v2, v0, Lcom/cineflix/android/TelegramEngine;->_authState:Lkotlinx/coroutines/flow/MutableStateFlow;

    sget-object v3, Lcom/cineflix/android/TelegramEngine$AuthState$WaitCode;->INSTANCE:Lcom/cineflix/android/TelegramEngine$AuthState$WaitCode;

    invoke-interface {v2, v3}, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V

    goto :goto_0

    .line 137
    :cond_2
    instance-of v2, v1, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitPassword;

    if-eqz v2, :cond_3

    iget-object v2, v0, Lcom/cineflix/android/TelegramEngine;->_authState:Lkotlinx/coroutines/flow/MutableStateFlow;

    sget-object v3, Lcom/cineflix/android/TelegramEngine$AuthState$WaitPassword;->INSTANCE:Lcom/cineflix/android/TelegramEngine$AuthState$WaitPassword;

    invoke-interface {v2, v3}, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V

    goto :goto_0

    .line 138
    :cond_3
    instance-of v2, v1, Lorg/drinkless/tdlib/TdApi$AuthorizationStateReady;

    if-eqz v2, :cond_4

    iget-object v2, v0, Lcom/cineflix/android/TelegramEngine;->_authState:Lkotlinx/coroutines/flow/MutableStateFlow;

    sget-object v3, Lcom/cineflix/android/TelegramEngine$AuthState$Ready;->INSTANCE:Lcom/cineflix/android/TelegramEngine$AuthState$Ready;

    invoke-interface {v2, v3}, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V

    goto :goto_0

    .line 139
    :cond_4
    instance-of v2, v1, Lorg/drinkless/tdlib/TdApi$AuthorizationStateLoggingOut;

    if-eqz v2, :cond_5

    iget-object v2, v0, Lcom/cineflix/android/TelegramEngine;->_authState:Lkotlinx/coroutines/flow/MutableStateFlow;

    sget-object v3, Lcom/cineflix/android/TelegramEngine$AuthState$LoggingOut;->INSTANCE:Lcom/cineflix/android/TelegramEngine$AuthState$LoggingOut;

    invoke-interface {v2, v3}, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V

    goto :goto_0

    .line 140
    :cond_5
    instance-of v2, v1, Lorg/drinkless/tdlib/TdApi$AuthorizationStateClosed;

    if-eqz v2, :cond_6

    .line 141
    const/4 v2, 0x0

    iput-object v2, v0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    .line 142
    iget-object v2, v0, Lcom/cineflix/android/TelegramEngine;->_authState:Lkotlinx/coroutines/flow/MutableStateFlow;

    sget-object v3, Lcom/cineflix/android/TelegramEngine$AuthState$Unknown;->INSTANCE:Lcom/cineflix/android/TelegramEngine$AuthState$Unknown;

    invoke-interface {v2, v3}, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V

    .line 143
    invoke-direct/range {p0 .. p0}, Lcom/cineflix/android/TelegramEngine;->initClient()V

    .line 147
    :cond_6
    :goto_0
    return-void
.end method

.method private static final handleAuthState$lambda$3(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0
    .param p0, "it"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 133
    return-void
.end method

.method private final handleNewMessage(Lorg/drinkless/tdlib/TdApi$Message;)V
    .locals 22
    .param p1, "msg"    # Lorg/drinkless/tdlib/TdApi$Message;

    .line 170
    move-object/from16 v1, p0

    move-object/from16 v2, p1

    iget-object v3, v2, Lorg/drinkless/tdlib/TdApi$Message;->content:Lorg/drinkless/tdlib/TdApi$MessageContent;

    .line 171
    .local v3, "content":Lorg/drinkless/tdlib/TdApi$MessageContent;
    instance-of v0, v3, Lorg/drinkless/tdlib/TdApi$MessageDocument;

    if-nez v0, :cond_1

    instance-of v0, v3, Lorg/drinkless/tdlib/TdApi$MessageVideo;

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    move v5, v0

    .line 174
    .local v5, "isVideo":Z
    iget-object v0, v1, Lcom/cineflix/android/TelegramEngine;->inlineKeyboardListeners:Ljava/util/concurrent/ConcurrentHashMap;

    check-cast v0, Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map$Entry;

    invoke-interface {v6}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .local v7, "key":Ljava/lang/String;
    invoke-interface {v6}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;

    .line 175
    .local v6, "listener":Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;
    iget-wide v8, v2, Lorg/drinkless/tdlib/TdApi$Message;->chatId:J

    invoke-virtual {v6}, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->getChatId()J

    move-result-wide v10

    cmp-long v8, v8, v10

    if-nez v8, :cond_9

    invoke-virtual {v6}, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->getDeferred()Lkotlinx/coroutines/CompletableDeferred;

    move-result-object v8

    invoke-interface {v8}, Lkotlinx/coroutines/CompletableDeferred;->isCompleted()Z

    move-result v8

    if-nez v8, :cond_9

    .line 176
    iget-object v8, v2, Lorg/drinkless/tdlib/TdApi$Message;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 177
    .local v8, "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    instance-of v9, v8, Lorg/drinkless/tdlib/TdApi$ReplyMarkupInlineKeyboard;

    if-eqz v9, :cond_8

    .line 178
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    check-cast v9, Ljava/util/List;

    .line 179
    .local v9, "buttons":Ljava/util/List;
    move-object v10, v8

    check-cast v10, Lorg/drinkless/tdlib/TdApi$ReplyMarkupInlineKeyboard;

    iget-object v10, v10, Lorg/drinkless/tdlib/TdApi$ReplyMarkupInlineKeyboard;->rows:[[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;

    const-string v11, "rows"

    invoke-static {v10, v11}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v10, [[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;

    move-object v11, v10

    check-cast v11, [Ljava/lang/Object;

    array-length v11, v11

    const/4 v12, 0x0

    :goto_3
    if-ge v12, v11, :cond_4

    aget-object v13, v10, v12

    .line 180
    .local v13, "row":[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    invoke-static {v13}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    array-length v14, v13

    const/4 v15, 0x0

    :goto_4
    if-ge v15, v14, :cond_3

    aget-object v4, v13, v15

    .line 181
    .local v4, "btn":Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    move-object/from16 v17, v0

    iget-object v0, v4, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;->type:Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;

    .line 182
    .local v0, "t":Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
    move-object/from16 v18, v8

    .end local v8    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .local v18, "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    instance-of v8, v0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeCallback;

    if-eqz v8, :cond_2

    .line 183
    new-instance v8, Lcom/cineflix/android/TelegramEngine$SeasonButton;

    .line 184
    move-object/from16 v16, v10

    iget-object v10, v4, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;->text:Ljava/lang/String;

    move-object/from16 v19, v4

    .end local v4    # "btn":Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    .local v19, "btn":Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    const-string v4, "text"

    invoke-static {v10, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 185
    move-object v4, v0

    check-cast v4, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeCallback;

    iget-object v4, v4, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeCallback;->data:[B

    move-object/from16 v20, v0

    .end local v0    # "t":Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
    .local v20, "t":Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
    const/4 v0, 0x2

    invoke-static {v4, v0}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v0

    const-string v4, "encodeToString(...)"

    invoke-static {v0, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 186
    move-object v4, v13

    move/from16 v21, v14

    .end local v13    # "row":[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    .local v4, "row":[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    iget-wide v13, v2, Lorg/drinkless/tdlib/TdApi$Message;->id:J

    .line 183
    invoke-direct {v8, v10, v0, v13, v14}, Lcom/cineflix/android/TelegramEngine$SeasonButton;-><init>(Ljava/lang/String;Ljava/lang/String;J)V

    invoke-interface {v9, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_5

    .line 182
    .end local v19    # "btn":Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    .end local v20    # "t":Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
    .restart local v0    # "t":Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
    .local v4, "btn":Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    .restart local v13    # "row":[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    :cond_2
    move-object/from16 v20, v0

    move-object/from16 v19, v4

    move-object/from16 v16, v10

    move-object v4, v13

    move/from16 v21, v14

    .line 180
    .end local v0    # "t":Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
    .end local v13    # "row":[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    .local v4, "row":[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    :goto_5
    add-int/lit8 v15, v15, 0x1

    move-object v13, v4

    move-object/from16 v10, v16

    move-object/from16 v0, v17

    move-object/from16 v8, v18

    move/from16 v14, v21

    goto :goto_4

    .end local v4    # "row":[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    .end local v18    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .restart local v8    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .restart local v13    # "row":[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    :cond_3
    move-object/from16 v17, v0

    move-object/from16 v18, v8

    move-object/from16 v16, v10

    move-object v4, v13

    .line 179
    .end local v8    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .end local v13    # "row":[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
    .restart local v18    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    add-int/lit8 v12, v12, 0x1

    goto :goto_3

    .line 191
    .end local v18    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .restart local v8    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    :cond_4
    move-object/from16 v17, v0

    move-object/from16 v18, v8

    .end local v8    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .restart local v18    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    instance-of v0, v3, Lorg/drinkless/tdlib/TdApi$MessageText;

    const/4 v4, 0x0

    if-eqz v0, :cond_5

    move-object v0, v3

    check-cast v0, Lorg/drinkless/tdlib/TdApi$MessageText;

    goto :goto_6

    :cond_5
    move-object v0, v4

    :goto_6
    if-eqz v0, :cond_6

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$MessageText;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    if-eqz v0, :cond_6

    iget-object v4, v0, Lorg/drinkless/tdlib/TdApi$FormattedText;->text:Ljava/lang/String;

    :cond_6
    if-nez v4, :cond_7

    const-string v0, ""

    move-object v15, v0

    goto :goto_7

    :cond_7
    move-object v15, v4

    .line 192
    .local v15, "bodyText":Ljava/lang/String;
    :goto_7
    new-instance v0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;

    iget-wide v11, v2, Lorg/drinkless/tdlib/TdApi$Message;->id:J

    iget-wide v13, v2, Lorg/drinkless/tdlib/TdApi$Message;->chatId:J

    move-object v10, v0

    move-object/from16 v16, v9

    invoke-direct/range {v10 .. v16}, Lcom/cineflix/android/TelegramEngine$SeasonResponse;-><init>(JJLjava/lang/String;Ljava/util/List;)V

    .line 193
    .local v0, "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    invoke-virtual {v6}, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->getDeferred()Lkotlinx/coroutines/CompletableDeferred;

    move-result-object v4

    invoke-interface {v4, v0}, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z

    .line 194
    iget-object v4, v1, Lcom/cineflix/android/TelegramEngine;->inlineKeyboardListeners:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v4, v7}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-object/from16 v0, v17

    goto/16 :goto_2

    .line 177
    .end local v0    # "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    .end local v9    # "buttons":Ljava/util/List;
    .end local v15    # "bodyText":Ljava/lang/String;
    .end local v18    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .restart local v8    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    :cond_8
    move-object/from16 v17, v0

    move-object/from16 v18, v8

    .end local v8    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .restart local v18    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    goto/16 :goto_2

    .line 175
    .end local v18    # "kb":Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    :cond_9
    move-object/from16 v17, v0

    goto/16 :goto_2

    .line 200
    .end local v6    # "listener":Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;
    .end local v7    # "key":Ljava/lang/String;
    :cond_a
    iget-object v0, v1, Lcom/cineflix/android/TelegramEngine;->msgCollectors:Ljava/util/concurrent/ConcurrentHashMap;

    check-cast v0, Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_b
    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_d

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/cineflix/android/TelegramEngine$MsgCollector;

    .line 201
    .local v4, "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    iget-wide v6, v2, Lorg/drinkless/tdlib/TdApi$Message;->chatId:J

    invoke-virtual {v4}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getChatId()J

    move-result-wide v8

    cmp-long v6, v6, v8

    if-nez v6, :cond_b

    iget-wide v6, v2, Lorg/drinkless/tdlib/TdApi$Message;->id:J

    invoke-virtual {v4}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getAfterMsgId()J

    move-result-wide v8

    cmp-long v6, v6, v8

    if-lez v6, :cond_b

    if-eqz v5, :cond_b

    .line 202
    invoke-direct/range {p0 .. p1}, Lcom/cineflix/android/TelegramEngine;->extractVideoInfo(Lorg/drinkless/tdlib/TdApi$Message;)Lcom/cineflix/android/TelegramEngine$VideoInfo;

    move-result-object v6

    if-nez v6, :cond_c

    goto :goto_8

    .line 203
    .local v6, "info":Lcom/cineflix/android/TelegramEngine$VideoInfo;
    :cond_c
    invoke-virtual {v4}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getVideos()Ljava/util/List;

    move-result-object v7

    monitor-enter v7

    .line 571
    const/4 v8, 0x0

    .line 203
    .local v8, "$i$a$-synchronized-TelegramEngine$handleNewMessage$1":I
    :try_start_0
    invoke-virtual {v4}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getVideos()Ljava/util/List;

    move-result-object v9

    invoke-interface {v9, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .end local v8    # "$i$a$-synchronized-TelegramEngine$handleNewMessage$1":I
    monitor-exit v7

    .line 204
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    invoke-virtual {v4, v7, v8}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->setLastReceived(J)V

    .end local v4    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .end local v6    # "info":Lcom/cineflix/android/TelegramEngine$VideoInfo;
    goto :goto_8

    .line 203
    .restart local v4    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .restart local v6    # "info":Lcom/cineflix/android/TelegramEngine$VideoInfo;
    :catchall_0
    move-exception v0

    monitor-exit v7

    throw v0

    .line 209
    .end local v4    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .end local v6    # "info":Lcom/cineflix/android/TelegramEngine$VideoInfo;
    :cond_d
    if-eqz v5, :cond_f

    .line 210
    invoke-direct/range {p0 .. p1}, Lcom/cineflix/android/TelegramEngine;->extractVideoInfo(Lorg/drinkless/tdlib/TdApi$Message;)Lcom/cineflix/android/TelegramEngine$VideoInfo;

    move-result-object v0

    if-nez v0, :cond_e

    return-void

    .line 211
    .local v0, "info":Lcom/cineflix/android/TelegramEngine$VideoInfo;
    :cond_e
    iget-wide v6, v2, Lorg/drinkless/tdlib/TdApi$Message;->chatId:J

    iget-wide v8, v2, Lorg/drinkless/tdlib/TdApi$Message;->id:J

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, ":"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 212
    .local v4, "cacheKey":Ljava/lang/String;
    iget-object v6, v1, Lcom/cineflix/android/TelegramEngine;->fileIdCache:Ljava/util/concurrent/ConcurrentHashMap;

    check-cast v6, Ljava/util/Map;

    new-instance v7, Lkotlin/Pair;

    invoke-virtual {v0}, Lcom/cineflix/android/TelegramEngine$VideoInfo;->getFileId()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v0}, Lcom/cineflix/android/TelegramEngine$VideoInfo;->getMimeType()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v7, v8, v9}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v6, v4, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 214
    iget-object v6, v1, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    if-eqz v6, :cond_f

    new-instance v15, Lorg/drinkless/tdlib/TdApi$DownloadFile;

    invoke-virtual {v0}, Lcom/cineflix/android/TelegramEngine$VideoInfo;->getFileId()I

    move-result v8

    const/4 v9, 0x1

    const-wide/16 v10, 0x0

    const-wide/16 v12, 0x0

    const/4 v14, 0x0

    move-object v7, v15

    invoke-direct/range {v7 .. v14}, Lorg/drinkless/tdlib/TdApi$DownloadFile;-><init>(IIJJZ)V

    check-cast v15, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v7, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda3;

    invoke-direct {v7}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda3;-><init>()V

    invoke-virtual {v6, v15, v7}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    .line 216
    .end local v0    # "info":Lcom/cineflix/android/TelegramEngine$VideoInfo;
    .end local v4    # "cacheKey":Ljava/lang/String;
    :cond_f
    return-void
.end method

.method private static final handleNewMessage$lambda$6(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0
    .param p0, "it"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 214
    return-void
.end method

.method private final handleResult(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 2
    .param p1, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 115
    nop

    .line 116
    instance-of v0, p1, Lorg/drinkless/tdlib/TdApi$UpdateAuthorizationState;

    if-eqz v0, :cond_0

    move-object v0, p1

    check-cast v0, Lorg/drinkless/tdlib/TdApi$UpdateAuthorizationState;

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$UpdateAuthorizationState;->authorizationState:Lorg/drinkless/tdlib/TdApi$AuthorizationState;

    const-string v1, "authorizationState"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/cineflix/android/TelegramEngine;->handleAuthState(Lorg/drinkless/tdlib/TdApi$AuthorizationState;)V

    goto :goto_0

    .line 117
    :cond_0
    instance-of v0, p1, Lorg/drinkless/tdlib/TdApi$UpdateFile;

    if-eqz v0, :cond_1

    move-object v0, p1

    check-cast v0, Lorg/drinkless/tdlib/TdApi$UpdateFile;

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$UpdateFile;->file:Lorg/drinkless/tdlib/TdApi$File;

    const-string v1, "file"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/cineflix/android/TelegramEngine;->handleUpdateFile(Lorg/drinkless/tdlib/TdApi$File;)V

    goto :goto_0

    .line 118
    :cond_1
    instance-of v0, p1, Lorg/drinkless/tdlib/TdApi$UpdateNewMessage;

    if-eqz v0, :cond_2

    move-object v0, p1

    check-cast v0, Lorg/drinkless/tdlib/TdApi$UpdateNewMessage;

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$UpdateNewMessage;->message:Lorg/drinkless/tdlib/TdApi$Message;

    const-string v1, "message"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/cineflix/android/TelegramEngine;->handleNewMessage(Lorg/drinkless/tdlib/TdApi$Message;)V

    .line 121
    :cond_2
    :goto_0
    return-void
.end method

.method private final handleUpdateFile(Lorg/drinkless/tdlib/TdApi$File;)V
    .locals 18
    .param p1, "file"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 150
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    iget-object v2, v1, Lorg/drinkless/tdlib/TdApi$File;->local:Lorg/drinkless/tdlib/TdApi$LocalFile;

    const/4 v3, 0x0

    if-eqz v2, :cond_0

    iget-object v2, v2, Lorg/drinkless/tdlib/TdApi$LocalFile;->path:Ljava/lang/String;

    goto :goto_0

    :cond_0
    move-object v2, v3

    .line 151
    .local v2, "p":Ljava/lang/String;
    :goto_0
    move-object v4, v2

    check-cast v4, Ljava/lang/CharSequence;

    const/4 v5, 0x0

    const/4 v6, 0x1

    if-eqz v4, :cond_2

    invoke-interface {v4}, Ljava/lang/CharSequence;->length()I

    move-result v4

    if-nez v4, :cond_1

    goto :goto_1

    :cond_1
    move v4, v5

    goto :goto_2

    :cond_2
    :goto_1
    move v4, v6

    :goto_2
    if-nez v4, :cond_3

    .line 152
    iget-object v4, v0, Lcom/cineflix/android/TelegramEngine;->filePathEmitters:Ljava/util/concurrent/ConcurrentHashMap;

    iget v7, v1, Lorg/drinkless/tdlib/TdApi$File;->id:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v7}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lkotlinx/coroutines/CompletableDeferred;

    .line 153
    .local v4, "deferred":Lkotlinx/coroutines/CompletableDeferred;
    if-eqz v4, :cond_3

    invoke-interface {v4}, Lkotlinx/coroutines/CompletableDeferred;->isCompleted()Z

    move-result v7

    if-nez v7, :cond_3

    .line 154
    invoke-interface {v4, v2}, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z

    .line 159
    .end local v4    # "deferred":Lkotlinx/coroutines/CompletableDeferred;
    :cond_3
    iget-object v4, v0, Lcom/cineflix/android/TelegramEngine;->fileStates:Ljava/util/concurrent/ConcurrentHashMap;

    check-cast v4, Ljava/util/concurrent/ConcurrentMap;

    .local v4, "$this$getOrPut$iv":Ljava/util/concurrent/ConcurrentMap;
    iget v7, v1, Lorg/drinkless/tdlib/TdApi$File;->id:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    .local v7, "key$iv":Ljava/lang/Object;
    const/4 v8, 0x0

    .line 568
    .local v8, "$i$f$getOrPut":I
    invoke-interface {v4, v7}, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    if-nez v9, :cond_5

    .line 569
    const/4 v9, 0x0

    .line 159
    .local v9, "$i$a$-getOrPut-TelegramEngine$handleUpdateFile$flow$1":I
    invoke-static {v3}, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;

    move-result-object v9

    .line 569
    .end local v9    # "$i$a$-getOrPut-TelegramEngine$handleUpdateFile$flow$1":I
    nop

    .line 570
    .local v9, "default$iv":Ljava/lang/Object;
    const/4 v10, 0x0

    .line 569
    .local v10, "$i$a$-let-MapsKt__MapsJVMKt$getOrPut$1$iv":I
    invoke-interface {v4, v7, v9}, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    if-nez v11, :cond_4

    goto :goto_3

    :cond_4
    move-object v9, v11

    .line 568
    .end local v9    # "default$iv":Ljava/lang/Object;
    .end local v10    # "$i$a$-let-MapsKt__MapsJVMKt$getOrPut$1$iv":I
    :cond_5
    :goto_3
    nop

    .line 159
    .end local v4    # "$this$getOrPut$iv":Ljava/util/concurrent/ConcurrentMap;
    .end local v7    # "key$iv":Ljava/lang/Object;
    .end local v8    # "$i$f$getOrPut":I
    move-object v4, v9

    check-cast v4, Lkotlinx/coroutines/flow/MutableStateFlow;

    .line 160
    .local v4, "flow":Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v15, Lcom/cineflix/android/TelegramEngine$FileState;

    .line 161
    iget-object v7, v1, Lorg/drinkless/tdlib/TdApi$File;->local:Lorg/drinkless/tdlib/TdApi$LocalFile;

    if-eqz v7, :cond_6

    iget-object v3, v7, Lorg/drinkless/tdlib/TdApi$LocalFile;->path:Ljava/lang/String;

    :cond_6
    if-nez v3, :cond_7

    const-string v3, ""

    :cond_7
    move-object v8, v3

    .line 162
    iget-object v3, v1, Lorg/drinkless/tdlib/TdApi$File;->local:Lorg/drinkless/tdlib/TdApi$LocalFile;

    const-wide/16 v9, 0x0

    if-eqz v3, :cond_8

    iget-wide v11, v3, Lorg/drinkless/tdlib/TdApi$LocalFile;->downloadedPrefixSize:J

    goto :goto_4

    :cond_8
    move-wide v11, v9

    .line 163
    :goto_4
    iget-object v3, v1, Lorg/drinkless/tdlib/TdApi$File;->local:Lorg/drinkless/tdlib/TdApi$LocalFile;

    if-eqz v3, :cond_9

    iget-wide v9, v3, Lorg/drinkless/tdlib/TdApi$LocalFile;->downloadedSize:J

    :cond_9
    move-wide v13, v9

    .line 164
    iget-wide v9, v1, Lorg/drinkless/tdlib/TdApi$File;->expectedSize:J

    .line 165
    iget-object v3, v1, Lorg/drinkless/tdlib/TdApi$File;->local:Lorg/drinkless/tdlib/TdApi$LocalFile;

    if-eqz v3, :cond_a

    iget-boolean v3, v3, Lorg/drinkless/tdlib/TdApi$LocalFile;->isDownloadingCompleted:Z

    if-ne v3, v6, :cond_a

    move v5, v6

    .line 160
    :cond_a
    move-object v7, v15

    move-wide/from16 v16, v9

    move-wide v9, v11

    move-wide v11, v13

    move-wide/from16 v13, v16

    move-object v3, v15

    move v15, v5

    invoke-direct/range {v7 .. v15}, Lcom/cineflix/android/TelegramEngine$FileState;-><init>(Ljava/lang/String;JJJZ)V

    invoke-interface {v4, v3}, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V

    .line 167
    return-void
.end method

.method public static synthetic hintDownloadOffset$default(Lcom/cineflix/android/TelegramEngine;IJJILjava/lang/Object;)V
    .locals 6

    .line 474
    and-int/lit8 p6, p6, 0x4

    if-eqz p6, :cond_0

    const-wide/32 p4, 0x200000

    :cond_0
    move-wide v4, p4

    move-object v0, p0

    move v1, p1

    move-wide v2, p2

    invoke-virtual/range {v0 .. v5}, Lcom/cineflix/android/TelegramEngine;->hintDownloadOffset(IJJ)V

    return-void
.end method

.method private static final hintDownloadOffset$lambda$15(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0
    .param p0, "it"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 477
    return-void
.end method

.method private final initClient()V
    .locals 3

    .line 105
    const-string v0, "TelegramEngine"

    const-string v1, "Initializing TDLib client..."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 106
    new-instance v0, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda8;

    invoke-direct {v0, p0}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda8;-><init>(Lcom/cineflix/android/TelegramEngine;)V

    new-instance v1, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda9;

    invoke-direct {v1}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda9;-><init>()V

    new-instance v2, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda10;

    invoke-direct {v2}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda10;-><init>()V

    invoke-static {v0, v1, v2}, Lorg/drinkless/tdlib/Client;->create(Lorg/drinkless/tdlib/Client$ResultHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;)Lorg/drinkless/tdlib/Client;

    move-result-object v0

    iput-object v0, p0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    .line 111
    return-void
.end method

.method private static final initClient$lambda$0(Lcom/cineflix/android/TelegramEngine;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 1
    .param p0, "this$0"    # Lcom/cineflix/android/TelegramEngine;
    .param p1, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 107
    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-direct {p0, p1}, Lcom/cineflix/android/TelegramEngine;->handleResult(Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method private static final initClient$lambda$1(Ljava/lang/Throwable;)V
    .locals 3
    .param p0, "error"    # Ljava/lang/Throwable;

    .line 108
    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "TDLib Error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "TelegramEngine"

    invoke-static {v1, v0, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    return-void
.end method

.method private static final initClient$lambda$2(Ljava/lang/Throwable;)V
    .locals 3
    .param p0, "error"    # Ljava/lang/Throwable;

    .line 109
    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "TDLib Default Error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "TelegramEngine"

    invoke-static {v1, v0, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    return-void
.end method

.method private static final logout$lambda$12(Lkotlin/jvm/functions/Function0;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 1
    .param p0, "$onDone"    # Lkotlin/jvm/functions/Function0;
    .param p1, "it"    # Lorg/drinkless/tdlib/TdApi$Object;

    const-string v0, "$onDone"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 278
    invoke-interface {p0}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    return-void
.end method

.method private static final readFilePartSync$lambda$16(Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/util/concurrent/CountDownLatch;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 2
    .param p0, "$chunk"    # Lkotlin/jvm/internal/Ref$ObjectRef;
    .param p1, "$latch"    # Ljava/util/concurrent/CountDownLatch;
    .param p2, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    const-string v0, "$chunk"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$latch"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 486
    instance-of v0, p2, Lorg/drinkless/tdlib/TdApi$Data;

    if-eqz v0, :cond_1

    .line 487
    move-object v0, p2

    check-cast v0, Lorg/drinkless/tdlib/TdApi$Data;

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$Data;->data:[B

    const-string v1, "data"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    array-length v0, v0

    const/4 v1, 0x1

    if-nez v0, :cond_0

    move v0, v1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    xor-int/2addr v0, v1

    if-eqz v0, :cond_1

    .line 488
    move-object v0, p2

    check-cast v0, Lorg/drinkless/tdlib/TdApi$Data;

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$Data;->data:[B

    iput-object v0, p0, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    .line 491
    :cond_1
    invoke-virtual {p1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 492
    return-void
.end method

.method private static final sendCode$lambda$10(Lkotlin/jvm/functions/Function1;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 2
    .param p0, "$onError"    # Lkotlin/jvm/functions/Function1;
    .param p1, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    const-string v0, "$onError"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 267
    instance-of v0, p1, Lorg/drinkless/tdlib/TdApi$Error;

    if-eqz v0, :cond_0

    move-object v0, p1

    check-cast v0, Lorg/drinkless/tdlib/TdApi$Error;

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$Error;->message:Ljava/lang/String;

    const-string v1, "message"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-interface {p0, v0}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 268
    :cond_0
    return-void
.end method

.method private static final sendPassword$lambda$11(Lkotlin/jvm/functions/Function1;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 2
    .param p0, "$onError"    # Lkotlin/jvm/functions/Function1;
    .param p1, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    const-string v0, "$onError"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 273
    instance-of v0, p1, Lorg/drinkless/tdlib/TdApi$Error;

    if-eqz v0, :cond_0

    move-object v0, p1

    check-cast v0, Lorg/drinkless/tdlib/TdApi$Error;

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$Error;->message:Ljava/lang/String;

    const-string v1, "message"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-interface {p0, v0}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 274
    :cond_0
    return-void
.end method

.method private static final sendPhone$lambda$9(Lkotlin/jvm/functions/Function1;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 2
    .param p0, "$onError"    # Lkotlin/jvm/functions/Function1;
    .param p1, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    const-string v0, "$onError"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 261
    instance-of v0, p1, Lorg/drinkless/tdlib/TdApi$Error;

    if-eqz v0, :cond_0

    move-object v0, p1

    check-cast v0, Lorg/drinkless/tdlib/TdApi$Error;

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$Error;->message:Ljava/lang/String;

    const-string v1, "message"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-interface {p0, v0}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 262
    :cond_0
    return-void
.end method

.method public static synthetic startDownloadReturnPath$default(Lcom/cineflix/android/TelegramEngine;IILkotlin/coroutines/Continuation;ILjava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 429
    and-int/lit8 p4, p4, 0x2

    if-eqz p4, :cond_0

    const/16 p2, 0x20

    :cond_0
    invoke-virtual {p0, p1, p2, p3}, Lcom/cineflix/android/TelegramEngine;->startDownloadReturnPath(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final cancelAndDeleteVideo(I)V
    .locals 3
    .param p1, "fileId"    # I

    .line 562
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "\ud83e\uddf9 Cleaning up TDLib cache for fileId: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "TelegramEngine"

    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 563
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    if-eqz v0, :cond_0

    new-instance v1, Lorg/drinkless/tdlib/TdApi$CancelDownloadFile;

    const/4 v2, 0x0

    invoke-direct {v1, p1, v2}, Lorg/drinkless/tdlib/TdApi$CancelDownloadFile;-><init>(IZ)V

    check-cast v1, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v2, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda6;

    invoke-direct {v2}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda6;-><init>()V

    invoke-virtual {v0, v1, v2}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    .line 564
    :cond_0
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    if-eqz v0, :cond_1

    new-instance v1, Lorg/drinkless/tdlib/TdApi$DeleteFile;

    invoke-direct {v1, p1}, Lorg/drinkless/tdlib/TdApi$DeleteFile;-><init>(I)V

    check-cast v1, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v2, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda7;

    invoke-direct {v2}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda7;-><init>()V

    invoke-virtual {v0, v1, v2}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    .line 565
    :cond_1
    return-void
.end method

.method public final clickInlineButton(JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 10
    .param p1, "chatId"    # J
    .param p3, "msgId"    # J
    .param p5, "dataBase64"    # Ljava/lang/String;
    .param p6, "$completion"    # Lkotlin/coroutines/Continuation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ",
            "Ljava/lang/String;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
            ">;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 320
    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;

    move-result-object v0

    check-cast v0, Lkotlin/coroutines/CoroutineContext;

    new-instance v9, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;

    const/4 v8, 0x0

    move-object v1, v9

    move-object v2, p5

    move-wide v3, p1

    move-wide v5, p3

    move-object v7, p0

    invoke-direct/range {v1 .. v8}, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;-><init>(Ljava/lang/String;JJLcom/cineflix/android/TelegramEngine;Lkotlin/coroutines/Continuation;)V

    check-cast v9, Lkotlin/jvm/functions/Function2;

    move-object/from16 v1, p6

    invoke-static {v0, v9, v1}, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v0

    .line 355
    return-object v0
.end method

.method public final downloadAndGetPath(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 3
    .param p1, "fileId"    # I
    .param p2, "priority"    # I
    .param p3, "$completion"    # Lkotlin/coroutines/Continuation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 461
    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;

    move-result-object v0

    check-cast v0, Lkotlin/coroutines/CoroutineContext;

    new-instance v1, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;

    const/4 v2, 0x0

    invoke-direct {v1, p0, p1, p2, v2}, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;-><init>(Lcom/cineflix/android/TelegramEngine;IILkotlin/coroutines/Continuation;)V

    check-cast v1, Lkotlin/jvm/functions/Function2;

    invoke-static {v0, v1, p3}, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v0

    .line 471
    return-object v0
.end method

.method public final downloadRangeAndRead(IJJ)[B
    .locals 13
    .param p1, "fileId"    # I
    .param p2, "offset"    # J
    .param p4, "count"    # J

    .line 506
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 507
    .local v0, "downloadLatch":Ljava/util/concurrent/CountDownLatch;
    move-object v1, p0

    iget-object v2, v1, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    const/4 v3, 0x0

    if-eqz v2, :cond_0

    new-instance v12, Lorg/drinkless/tdlib/TdApi$DownloadFile;

    const/16 v6, 0x20

    const/4 v11, 0x1

    move-object v4, v12

    move v5, p1

    move-wide v7, p2

    move-wide/from16 v9, p4

    invoke-direct/range {v4 .. v11}, Lorg/drinkless/tdlib/TdApi$DownloadFile;-><init>(IIJJZ)V

    check-cast v12, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v4, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda14;

    invoke-direct {v4, v0}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda14;-><init>(Ljava/util/concurrent/CountDownLatch;)V

    invoke-virtual {v2, v12, v4}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    sget-object v2, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    goto :goto_0

    :cond_0
    move-object v2, v3

    :goto_0
    if-nez v2, :cond_1

    .line 509
    return-object v3

    .line 512
    :cond_1
    const-wide/16 v4, 0x7530

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v4, v5, v2}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 513
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "downloadRangeAndRead TIMEOUT offset="

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-wide v4, p2

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v6, " count="

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-wide/from16 v6, p4

    invoke-virtual {v2, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v8, "TelegramEngine"

    invoke-static {v8, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 514
    return-object v3

    .line 518
    :cond_2
    move-wide v4, p2

    move-wide/from16 v6, p4

    invoke-virtual/range {p0 .. p5}, Lcom/cineflix/android/TelegramEngine;->readFilePartSync(IJJ)[B

    move-result-object v2

    return-object v2
.end method

.method public final getAuthState()Lkotlinx/coroutines/flow/StateFlow;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlinx/coroutines/flow/StateFlow<",
            "Lcom/cineflix/android/TelegramEngine$AuthState;",
            ">;"
        }
    .end annotation

    .line 48
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->authState:Lkotlinx/coroutines/flow/StateFlow;

    return-object v0
.end method

.method public final getBotChatIdPublic(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 1
    .param p1, "$completion"    # Lkotlin/coroutines/Continuation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Ljava/lang/Long;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 554
    invoke-direct {p0, p1}, Lcom/cineflix/android/TelegramEngine;->getBotChatId(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final getClient()Lorg/drinkless/tdlib/Client;
    .locals 1

    .line 556
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    return-object v0
.end method

.method public final getFileIdCache()Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/ConcurrentHashMap<",
            "Ljava/lang/String;",
            "Lkotlin/Pair<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .line 55
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->fileIdCache:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method public final getFileStateFlow(I)Lkotlinx/coroutines/flow/StateFlow;
    .locals 6
    .param p1, "fileId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lkotlinx/coroutines/flow/StateFlow<",
            "Lcom/cineflix/android/TelegramEngine$FileState;",
            ">;"
        }
    .end annotation

    .line 421
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->fileStates:Ljava/util/concurrent/ConcurrentHashMap;

    check-cast v0, Ljava/util/concurrent/ConcurrentMap;

    .local v0, "$this$getOrPut$iv":Ljava/util/concurrent/ConcurrentMap;
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .local v1, "key$iv":Ljava/lang/Object;
    const/4 v2, 0x0

    .line 572
    .local v2, "$i$f$getOrPut":I
    invoke-interface {v0, v1}, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-nez v3, :cond_1

    .line 573
    const/4 v3, 0x0

    .line 421
    .local v3, "$i$a$-getOrPut-TelegramEngine$getFileStateFlow$1":I
    const/4 v4, 0x0

    invoke-static {v4}, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;

    move-result-object v3

    .line 573
    .end local v3    # "$i$a$-getOrPut-TelegramEngine$getFileStateFlow$1":I
    nop

    .line 574
    .local v3, "default$iv":Ljava/lang/Object;
    const/4 v4, 0x0

    .line 573
    .local v4, "$i$a$-let-MapsKt__MapsJVMKt$getOrPut$1$iv":I
    invoke-interface {v0, v1, v3}, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    if-nez v5, :cond_0

    goto :goto_0

    :cond_0
    move-object v3, v5

    .line 572
    .end local v3    # "default$iv":Ljava/lang/Object;
    .end local v4    # "$i$a$-let-MapsKt__MapsJVMKt$getOrPut$1$iv":I
    :cond_1
    :goto_0
    nop

    .line 421
    .end local v0    # "$this$getOrPut$iv":Ljava/util/concurrent/ConcurrentMap;
    .end local v1    # "key$iv":Ljava/lang/Object;
    .end local v2    # "$i$f$getOrPut":I
    const-string v0, "getOrPut(...)"

    invoke-static {v3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v3, Lkotlinx/coroutines/flow/StateFlow;

    return-object v3
.end method

.method public final getMe(Lkotlin/jvm/functions/Function1;)V
    .locals 3
    .param p1, "onResult"    # Lkotlin/jvm/functions/Function1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Lorg/drinkless/tdlib/TdApi$User;",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "onResult"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 282
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    if-eqz v0, :cond_0

    new-instance v1, Lorg/drinkless/tdlib/TdApi$GetMe;

    invoke-direct {v1}, Lorg/drinkless/tdlib/TdApi$GetMe;-><init>()V

    check-cast v1, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v2, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda5;

    invoke-direct {v2, p1}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda5;-><init>(Lkotlin/jvm/functions/Function1;)V

    invoke-virtual {v0, v1, v2}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    .line 285
    :cond_0
    return-void
.end method

.method public final getVideoMessagesHistory(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 8
    .param p1, "limit"    # I
    .param p2, "minId"    # J
    .param p4, "$completion"    # Lkotlin/coroutines/Continuation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IJ",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
            ">;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 528
    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;

    move-result-object v0

    check-cast v0, Lkotlin/coroutines/CoroutineContext;

    new-instance v7, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;

    const/4 v6, 0x0

    move-object v1, v7

    move-object v2, p0

    move v3, p1

    move-wide v4, p2

    invoke-direct/range {v1 .. v6}, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;-><init>(Lcom/cineflix/android/TelegramEngine;IJLkotlin/coroutines/Continuation;)V

    check-cast v7, Lkotlin/jvm/functions/Function2;

    invoke-static {v0, v7, p4}, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v0

    .line 544
    return-object v0
.end method

.method public final hintDownloadOffset(IJJ)V
    .locals 10
    .param p1, "fileId"    # I
    .param p2, "offset"    # J
    .param p4, "limit"    # J

    .line 477
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    if-eqz v0, :cond_0

    new-instance v9, Lorg/drinkless/tdlib/TdApi$DownloadFile;

    const/16 v3, 0x20

    const/4 v8, 0x0

    move-object v1, v9

    move v2, p1

    move-wide v4, p2

    move-wide v6, p4

    invoke-direct/range {v1 .. v8}, Lorg/drinkless/tdlib/TdApi$DownloadFile;-><init>(IIJJZ)V

    check-cast v9, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v1, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda13;

    invoke-direct {v1}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda13;-><init>()V

    invoke-virtual {v0, v9, v1}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    .line 478
    :cond_0
    return-void
.end method

.method public final logout(Lkotlin/jvm/functions/Function0;)V
    .locals 3
    .param p1, "onDone"    # Lkotlin/jvm/functions/Function0;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function0<",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "onDone"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 278
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    if-eqz v0, :cond_0

    new-instance v1, Lorg/drinkless/tdlib/TdApi$LogOut;

    invoke-direct {v1}, Lorg/drinkless/tdlib/TdApi$LogOut;-><init>()V

    check-cast v1, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v2, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda0;

    invoke-direct {v2, p1}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function0;)V

    invoke-virtual {v0, v1, v2}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    .line 279
    :cond_0
    return-void
.end method

.method public final readFilePartSync(IJJ)[B
    .locals 12
    .param p1, "fileId"    # I
    .param p2, "offset"    # J
    .param p4, "count"    # J

    .line 482
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 483
    .local v0, "latch":Ljava/util/concurrent/CountDownLatch;
    new-instance v1, Lkotlin/jvm/internal/Ref$ObjectRef;

    invoke-direct {v1}, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V

    .line 485
    .local v1, "chunk":Lkotlin/jvm/internal/Ref$ObjectRef;
    move-object v2, p0

    iget-object v3, v2, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    const/4 v4, 0x0

    if-eqz v3, :cond_0

    new-instance v11, Lorg/drinkless/tdlib/TdApi$ReadFilePart;

    move-object v5, v11

    move v6, p1

    move-wide v7, p2

    move-wide/from16 v9, p4

    invoke-direct/range {v5 .. v10}, Lorg/drinkless/tdlib/TdApi$ReadFilePart;-><init>(IJJ)V

    check-cast v11, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v5, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda2;

    invoke-direct {v5, v1, v0}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/util/concurrent/CountDownLatch;)V

    invoke-virtual {v3, v11, v5}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    sget-object v3, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    goto :goto_0

    :cond_0
    move-object v3, v4

    :goto_0
    if-nez v3, :cond_1

    .line 492
    return-object v4

    .line 494
    :cond_1
    const-wide/16 v3, 0xbb8

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v3, v4, v5}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    .line 495
    iget-object v3, v1, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    check-cast v3, [B

    return-object v3
.end method

.method public final searchMovieByPayload(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 3
    .param p1, "searchTitle"    # Ljava/lang/String;
    .param p2, "$completion"    # Lkotlin/coroutines/Continuation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
            ">;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 362
    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;

    move-result-object v0

    check-cast v0, Lkotlin/coroutines/CoroutineContext;

    new-instance v1, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;

    const/4 v2, 0x0

    invoke-direct {v1, p0, p1, v2}, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;-><init>(Lcom/cineflix/android/TelegramEngine;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    check-cast v1, Lkotlin/jvm/functions/Function2;

    invoke-static {v0, v1, p2}, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v0

    .line 406
    return-object v0
.end method

.method public final sendBotCommand(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 3
    .param p1, "payload"    # Ljava/lang/String;
    .param p2, "$completion"    # Lkotlin/coroutines/Continuation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 290
    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;

    move-result-object v0

    check-cast v0, Lkotlin/coroutines/CoroutineContext;

    new-instance v1, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;

    const/4 v2, 0x0

    invoke-direct {v1, p0, p1, v2}, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;-><init>(Lcom/cineflix/android/TelegramEngine;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    check-cast v1, Lkotlin/jvm/functions/Function2;

    invoke-static {v0, v1, p2}, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v0

    .line 312
    return-object v0
.end method

.method public final sendCode(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V
    .locals 3
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "onError"    # Lkotlin/jvm/functions/Function1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Ljava/lang/String;",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "code"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "onError"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 266
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    if-eqz v0, :cond_0

    new-instance v1, Lorg/drinkless/tdlib/TdApi$CheckAuthenticationCode;

    invoke-direct {v1, p1}, Lorg/drinkless/tdlib/TdApi$CheckAuthenticationCode;-><init>(Ljava/lang/String;)V

    check-cast v1, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v2, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda11;

    invoke-direct {v2, p2}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda11;-><init>(Lkotlin/jvm/functions/Function1;)V

    invoke-virtual {v0, v1, v2}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    .line 269
    :cond_0
    return-void
.end method

.method public final sendPassword(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V
    .locals 3
    .param p1, "password"    # Ljava/lang/String;
    .param p2, "onError"    # Lkotlin/jvm/functions/Function1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Ljava/lang/String;",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "password"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "onError"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 272
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    if-eqz v0, :cond_0

    new-instance v1, Lorg/drinkless/tdlib/TdApi$CheckAuthenticationPassword;

    invoke-direct {v1, p1}, Lorg/drinkless/tdlib/TdApi$CheckAuthenticationPassword;-><init>(Ljava/lang/String;)V

    check-cast v1, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v2, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda1;

    invoke-direct {v2, p2}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function1;)V

    invoke-virtual {v0, v1, v2}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    .line 275
    :cond_0
    return-void
.end method

.method public final sendPhone(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V
    .locals 3
    .param p1, "phone"    # Ljava/lang/String;
    .param p2, "onError"    # Lkotlin/jvm/functions/Function1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Ljava/lang/String;",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "phone"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "onError"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 260
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine;->client:Lorg/drinkless/tdlib/Client;

    if-eqz v0, :cond_0

    new-instance v1, Lorg/drinkless/tdlib/TdApi$SetAuthenticationPhoneNumber;

    const/4 v2, 0x0

    invoke-direct {v1, p1, v2}, Lorg/drinkless/tdlib/TdApi$SetAuthenticationPhoneNumber;-><init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$PhoneNumberAuthenticationSettings;)V

    check-cast v1, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v2, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda4;

    invoke-direct {v2, p2}, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda4;-><init>(Lkotlin/jvm/functions/Function1;)V

    invoke-virtual {v0, v1, v2}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    .line 263
    :cond_0
    return-void
.end method

.method public final startDownloadReturnPath(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 3
    .param p1, "fileId"    # I
    .param p2, "priority"    # I
    .param p3, "$completion"    # Lkotlin/coroutines/Continuation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 430
    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;

    move-result-object v0

    check-cast v0, Lkotlin/coroutines/CoroutineContext;

    new-instance v1, Lcom/cineflix/android/TelegramEngine$startDownloadReturnPath$2;

    const/4 v2, 0x0

    invoke-direct {v1, p1, p2, p0, v2}, Lcom/cineflix/android/TelegramEngine$startDownloadReturnPath$2;-><init>(IILcom/cineflix/android/TelegramEngine;Lkotlin/coroutines/Continuation;)V

    check-cast v1, Lkotlin/jvm/functions/Function2;

    invoke-static {v0, v1, p3}, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v0

    .line 453
    return-object v0
.end method
