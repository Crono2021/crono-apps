.class public final Lorg/drinkless/tdlib/Client;
.super Ljava/lang/Object;
.source "Client.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/drinkless/tdlib/Client$Handler;,
        Lorg/drinkless/tdlib/Client$ResultHandler;,
        Lorg/drinkless/tdlib/Client$ExceptionHandler;,
        Lorg/drinkless/tdlib/Client$ResponseReceiver;,
        Lorg/drinkless/tdlib/Client$ExecutionException;,
        Lorg/drinkless/tdlib/Client$LogMessageHandler;
    }
.end annotation


# static fields
.field private static final clientCount:Ljava/util/concurrent/atomic/AtomicLong;

.field private static final currentQueryId:Ljava/util/concurrent/atomic/AtomicLong;

.field private static final defaultExceptionHandlers:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap<",
            "Ljava/lang/Integer;",
            "Lorg/drinkless/tdlib/Client$ExceptionHandler;",
            ">;"
        }
    .end annotation
.end field

.field private static final handlers:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap<",
            "Ljava/lang/Long;",
            "Lorg/drinkless/tdlib/Client$Handler;",
            ">;"
        }
    .end annotation
.end field

.field private static final responseReceiver:Lorg/drinkless/tdlib/Client$ResponseReceiver;

.field private static final updateHandlers:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap<",
            "Ljava/lang/Integer;",
            "Lorg/drinkless/tdlib/Client$Handler;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final nativeClientId:I


# direct methods
.method static bridge synthetic -$$Nest$sfgetclientCount()Ljava/util/concurrent/atomic/AtomicLong;
    .locals 1

    sget-object v0, Lorg/drinkless/tdlib/Client;->clientCount:Ljava/util/concurrent/atomic/AtomicLong;

    return-object v0
.end method

.method static bridge synthetic -$$Nest$sfgetdefaultExceptionHandlers()Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1

    sget-object v0, Lorg/drinkless/tdlib/Client;->defaultExceptionHandlers:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method static bridge synthetic -$$Nest$sfgethandlers()Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1

    sget-object v0, Lorg/drinkless/tdlib/Client;->handlers:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method static bridge synthetic -$$Nest$sfgetupdateHandlers()Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1

    sget-object v0, Lorg/drinkless/tdlib/Client;->updateHandlers:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method static constructor <clinit>()V
    .locals 2

    .line 109
    :try_start_0
    const-string v0, "tdjni"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_0} :catch_0

    .line 112
    goto :goto_0

    .line 110
    :catch_0
    move-exception v0

    .line 111
    .local v0, "e9":Ljava/lang/UnsatisfiedLinkError;
    invoke-virtual {v0}, Ljava/lang/UnsatisfiedLinkError;->printStackTrace()V

    .line 113
    .end local v0    # "e9":Ljava/lang/UnsatisfiedLinkError;
    :goto_0
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lorg/drinkless/tdlib/Client;->defaultExceptionHandlers:Ljava/util/concurrent/ConcurrentHashMap;

    .line 114
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lorg/drinkless/tdlib/Client;->updateHandlers:Ljava/util/concurrent/ConcurrentHashMap;

    .line 115
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lorg/drinkless/tdlib/Client;->handlers:Ljava/util/concurrent/ConcurrentHashMap;

    .line 116
    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    sput-object v0, Lorg/drinkless/tdlib/Client;->currentQueryId:Ljava/util/concurrent/atomic/AtomicLong;

    .line 117
    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    sput-object v0, Lorg/drinkless/tdlib/Client;->clientCount:Ljava/util/concurrent/atomic/AtomicLong;

    .line 118
    new-instance v0, Lorg/drinkless/tdlib/Client$ResponseReceiver;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lorg/drinkless/tdlib/Client$ResponseReceiver;-><init>(Lorg/drinkless/tdlib/Client$ResponseReceiver-IA;)V

    sput-object v0, Lorg/drinkless/tdlib/Client;->responseReceiver:Lorg/drinkless/tdlib/Client$ResponseReceiver;

    .line 119
    return-void
.end method

.method private constructor <init>(Lorg/drinkless/tdlib/Client$ResultHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;)V
    .locals 4
    .param p1, "resultHandler"    # Lorg/drinkless/tdlib/Client$ResultHandler;
    .param p2, "exceptionHandler"    # Lorg/drinkless/tdlib/Client$ExceptionHandler;
    .param p3, "exceptionHandler2"    # Lorg/drinkless/tdlib/Client$ExceptionHandler;

    .line 121
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 122
    sget-object v0, Lorg/drinkless/tdlib/Client;->clientCount:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->incrementAndGet()J

    .line 123
    invoke-static {}, Lorg/drinkless/tdlib/Client;->createNativeClient()I

    move-result v0

    .line 124
    .local v0, "createNativeClient":I
    iput v0, p0, Lorg/drinkless/tdlib/Client;->nativeClientId:I

    .line 125
    if-eqz p1, :cond_0

    .line 126
    sget-object v1, Lorg/drinkless/tdlib/Client;->updateHandlers:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    new-instance v3, Lorg/drinkless/tdlib/Client$Handler;

    invoke-direct {v3, p1, p2}, Lorg/drinkless/tdlib/Client$Handler;-><init>(Lorg/drinkless/tdlib/Client$ResultHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;)V

    invoke-virtual {v1, v2, v3}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 128
    :cond_0
    if-eqz p3, :cond_1

    .line 129
    sget-object v1, Lorg/drinkless/tdlib/Client;->defaultExceptionHandlers:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2, p3}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 131
    :cond_1
    new-instance v1, Lorg/drinkless/tdlib/TdApi$GetOption;

    const-string v2, "version"

    invoke-direct {v1, v2}, Lorg/drinkless/tdlib/TdApi$GetOption;-><init>(Ljava/lang/String;)V

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2, v2}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;)V

    .line 132
    return-void
.end method

.method public static create(Lorg/drinkless/tdlib/Client$ResultHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;)Lorg/drinkless/tdlib/Client;
    .locals 5
    .param p0, "resultHandler"    # Lorg/drinkless/tdlib/Client$ResultHandler;
    .param p1, "exceptionHandler"    # Lorg/drinkless/tdlib/Client$ExceptionHandler;
    .param p2, "exceptionHandler2"    # Lorg/drinkless/tdlib/Client$ExceptionHandler;

    .line 135
    new-instance v0, Lorg/drinkless/tdlib/Client;

    invoke-direct {v0, p0, p1, p2}, Lorg/drinkless/tdlib/Client;-><init>(Lorg/drinkless/tdlib/Client$ResultHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;)V

    .line 136
    .local v0, "client":Lorg/drinkless/tdlib/Client;
    sget-object v1, Lorg/drinkless/tdlib/Client;->responseReceiver:Lorg/drinkless/tdlib/Client$ResponseReceiver;

    .line 137
    .local v1, "responseReceiver2":Lorg/drinkless/tdlib/Client$ResponseReceiver;
    monitor-enter v1

    .line 139
    :try_start_0
    iget-boolean v2, v1, Lorg/drinkless/tdlib/Client$ResponseReceiver;->isRun:Z

    if-nez v2, :cond_0

    .line 140
    const/4 v2, 0x1

    iput-boolean v2, v1, Lorg/drinkless/tdlib/Client$ResponseReceiver;->isRun:Z

    .line 141
    new-instance v3, Ljava/lang/Thread;

    const-string v4, "TDLib thread"

    invoke-direct {v3, v1, v4}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    .line 142
    .local v3, "thread":Ljava/lang/Thread;
    invoke-virtual {v3, v2}, Ljava/lang/Thread;->setDaemon(Z)V

    .line 143
    invoke-virtual {v3}, Ljava/lang/Thread;->start()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 147
    .end local v3    # "thread":Ljava/lang/Thread;
    :cond_0
    nop

    .line 148
    :try_start_1
    monitor-exit v1

    .line 149
    return-object v0

    .line 145
    :catchall_0
    move-exception v2

    .line 146
    .local v2, "th":Ljava/lang/Throwable;
    nop

    .end local v0    # "client":Lorg/drinkless/tdlib/Client;
    .end local v1    # "responseReceiver2":Lorg/drinkless/tdlib/Client$ResponseReceiver;
    .end local p0    # "resultHandler":Lorg/drinkless/tdlib/Client$ResultHandler;
    .end local p1    # "exceptionHandler":Lorg/drinkless/tdlib/Client$ExceptionHandler;
    .end local p2    # "exceptionHandler2":Lorg/drinkless/tdlib/Client$ExceptionHandler;
    throw v2

    .line 148
    .end local v2    # "th":Ljava/lang/Throwable;
    .restart local v0    # "client":Lorg/drinkless/tdlib/Client;
    .restart local v1    # "responseReceiver2":Lorg/drinkless/tdlib/Client$ResponseReceiver;
    .restart local p0    # "resultHandler":Lorg/drinkless/tdlib/Client$ResultHandler;
    .restart local p1    # "exceptionHandler":Lorg/drinkless/tdlib/Client$ExceptionHandler;
    .restart local p2    # "exceptionHandler2":Lorg/drinkless/tdlib/Client$ExceptionHandler;
    :catchall_1
    move-exception v2

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    throw v2
.end method

.method private static native createNativeClient()I
.end method

.method public static execute(Lorg/drinkless/tdlib/TdApi$Function;)Lorg/drinkless/tdlib/TdApi$Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lorg/drinkless/tdlib/TdApi$Object;",
            ">(",
            "Lorg/drinkless/tdlib/TdApi$Function<",
            "TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/drinkless/tdlib/Client$ExecutionException;
        }
    .end annotation

    .line 155
    .local p0, "function":Lorg/drinkless/tdlib/TdApi$Function;, "Lorg/drinkless/tdlib/TdApi$Function<TT;>;"
    invoke-static {p0}, Lorg/drinkless/tdlib/Client;->nativeClientExecute(Lorg/drinkless/tdlib/TdApi$Function;)Lorg/drinkless/tdlib/TdApi$Object;

    move-result-object v0

    .line 156
    .local v0, "result":Lorg/drinkless/tdlib/TdApi$Object;
    instance-of v1, v0, Lorg/drinkless/tdlib/TdApi$Error;

    if-nez v1, :cond_0

    .line 159
    return-object v0

    .line 157
    :cond_0
    new-instance v1, Lorg/drinkless/tdlib/Client$ExecutionException;

    move-object v2, v0

    check-cast v2, Lorg/drinkless/tdlib/TdApi$Error;

    invoke-direct {v1, v2}, Lorg/drinkless/tdlib/Client$ExecutionException;-><init>(Lorg/drinkless/tdlib/TdApi$Error;)V

    throw v1
.end method

.method private static native nativeClientExecute(Lorg/drinkless/tdlib/TdApi$Function;)Lorg/drinkless/tdlib/TdApi$Object;
.end method

.method public static native nativeClientReceive([I[J[Lorg/drinkless/tdlib/TdApi$Object;D)I
.end method

.method private static native nativeClientSend(IJLorg/drinkless/tdlib/TdApi$Function;)V
.end method

.method private static native nativeClientSetLogMessageHandler(ILorg/drinkless/tdlib/Client$LogMessageHandler;)V
.end method

.method public static setLogMessageHandler(ILorg/drinkless/tdlib/Client$LogMessageHandler;)V
    .locals 0
    .param p0, "i9"    # I
    .param p1, "logMessageHandler"    # Lorg/drinkless/tdlib/Client$LogMessageHandler;

    .line 172
    invoke-static {p0, p1}, Lorg/drinkless/tdlib/Client;->nativeClientSetLogMessageHandler(ILorg/drinkless/tdlib/Client$LogMessageHandler;)V

    .line 173
    return-void
.end method


# virtual methods
.method public send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V
    .locals 1
    .param p1, "function"    # Lorg/drinkless/tdlib/TdApi$Function;
    .param p2, "resultHandler"    # Lorg/drinkless/tdlib/Client$ResultHandler;

    .line 184
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;)V

    .line 185
    return-void
.end method

.method public send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;)V
    .locals 5
    .param p1, "function"    # Lorg/drinkless/tdlib/TdApi$Function;
    .param p2, "resultHandler"    # Lorg/drinkless/tdlib/Client$ResultHandler;
    .param p3, "exceptionHandler"    # Lorg/drinkless/tdlib/Client$ExceptionHandler;

    .line 176
    sget-object v0, Lorg/drinkless/tdlib/Client;->currentQueryId:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->incrementAndGet()J

    move-result-wide v0

    .line 177
    .local v0, "incrementAndGet":J
    if-eqz p2, :cond_0

    .line 178
    sget-object v2, Lorg/drinkless/tdlib/Client;->handlers:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    new-instance v4, Lorg/drinkless/tdlib/Client$Handler;

    invoke-direct {v4, p2, p3}, Lorg/drinkless/tdlib/Client$Handler;-><init>(Lorg/drinkless/tdlib/Client$ResultHandler;Lorg/drinkless/tdlib/Client$ExceptionHandler;)V

    invoke-virtual {v2, v3, v4}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 180
    :cond_0
    iget v2, p0, Lorg/drinkless/tdlib/Client;->nativeClientId:I

    invoke-static {v2, v0, v1, p1}, Lorg/drinkless/tdlib/Client;->nativeClientSend(IJLorg/drinkless/tdlib/TdApi$Function;)V

    .line 181
    return-void
.end method
