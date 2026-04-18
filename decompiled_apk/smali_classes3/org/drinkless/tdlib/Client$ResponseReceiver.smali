.class public Lorg/drinkless/tdlib/Client$ResponseReceiver;
.super Ljava/lang/Object;
.source "Client.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/Client;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ResponseReceiver"
.end annotation


# static fields
.field private static final MAX_EVENTS:I = 0x3e8


# instance fields
.field private final clientIds:[I

.field private final eventIds:[J

.field private final events:[Lorg/drinkless/tdlib/TdApi$Object;

.field public isRun:Z


# direct methods
.method private constructor <init>()V
    .locals 2

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/drinkless/tdlib/Client$ResponseReceiver;->isRun:Z

    .line 59
    const/16 v0, 0x3e8

    new-array v1, v0, [I

    iput-object v1, p0, Lorg/drinkless/tdlib/Client$ResponseReceiver;->clientIds:[I

    .line 60
    new-array v1, v0, [J

    iput-object v1, p0, Lorg/drinkless/tdlib/Client$ResponseReceiver;->eventIds:[J

    .line 61
    new-array v0, v0, [Lorg/drinkless/tdlib/TdApi$Object;

    iput-object v0, p0, Lorg/drinkless/tdlib/Client$ResponseReceiver;->events:[Lorg/drinkless/tdlib/TdApi$Object;

    .line 62
    return-void
.end method

.method synthetic constructor <init>(Lorg/drinkless/tdlib/Client$ResponseReceiver-IA;)V
    .locals 0

    invoke-direct {p0}, Lorg/drinkless/tdlib/Client$ResponseReceiver;-><init>()V

    return-void
.end method

.method private processResult(IJLorg/drinkless/tdlib/TdApi$Object;)V
    .locals 6
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "object"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 65
    const-wide/16 v0, 0x0

    cmp-long v2, p2, v0

    if-nez v2, :cond_0

    instance-of v2, p4, Lorg/drinkless/tdlib/TdApi$UpdateAuthorizationState;

    if-eqz v2, :cond_0

    move-object v2, p4

    check-cast v2, Lorg/drinkless/tdlib/TdApi$UpdateAuthorizationState;

    iget-object v2, v2, Lorg/drinkless/tdlib/TdApi$UpdateAuthorizationState;->authorizationState:Lorg/drinkless/tdlib/TdApi$AuthorizationState;

    instance-of v2, v2, Lorg/drinkless/tdlib/TdApi$AuthorizationStateClosed;

    if-eqz v2, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    .line 66
    .local v2, "z8":Z
    :goto_0
    cmp-long v0, p2, v0

    if-nez v0, :cond_1

    invoke-static {}, Lorg/drinkless/tdlib/Client;->-$$Nest$sfgetupdateHandlers()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_1

    :cond_1
    invoke-static {}, Lorg/drinkless/tdlib/Client;->-$$Nest$sfgethandlers()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v0

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_1
    check-cast v0, Lorg/drinkless/tdlib/Client$Handler;

    .line 67
    .local v0, "handler":Lorg/drinkless/tdlib/Client$Handler;
    if-eqz v0, :cond_3

    .line 69
    :try_start_0
    iget-object v1, v0, Lorg/drinkless/tdlib/Client$Handler;->resultHandler:Lorg/drinkless/tdlib/Client$ResultHandler;

    invoke-interface {v1, p4}, Lorg/drinkless/tdlib/Client$ResultHandler;->onResult(Lorg/drinkless/tdlib/TdApi$Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 81
    goto :goto_2

    .line 70
    :catchall_0
    move-exception v1

    .line 71
    .local v1, "th":Ljava/lang/Throwable;
    iget-object v3, v0, Lorg/drinkless/tdlib/Client$Handler;->exceptionHandler:Lorg/drinkless/tdlib/Client$ExceptionHandler;

    .line 72
    .local v3, "exceptionHandler":Lorg/drinkless/tdlib/Client$ExceptionHandler;
    if-nez v3, :cond_2

    .line 73
    invoke-static {}, Lorg/drinkless/tdlib/Client;->-$$Nest$sfgetdefaultExceptionHandlers()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v4

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    move-object v3, v4

    check-cast v3, Lorg/drinkless/tdlib/Client$ExceptionHandler;

    .line 75
    :cond_2
    if-eqz v3, :cond_3

    .line 77
    :try_start_1
    invoke-interface {v3, v1}, Lorg/drinkless/tdlib/Client$ExceptionHandler;->onException(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 79
    goto :goto_2

    .line 78
    :catchall_1
    move-exception v4

    .line 83
    .end local v1    # "th":Ljava/lang/Throwable;
    .end local v3    # "exceptionHandler":Lorg/drinkless/tdlib/Client$ExceptionHandler;
    :cond_3
    :goto_2
    if-eqz v2, :cond_4

    .line 84
    invoke-static {}, Lorg/drinkless/tdlib/Client;->-$$Nest$sfgetupdateHandlers()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    invoke-static {}, Lorg/drinkless/tdlib/Client;->-$$Nest$sfgetdefaultExceptionHandlers()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    invoke-static {}, Lorg/drinkless/tdlib/Client;->-$$Nest$sfgetclientCount()Ljava/util/concurrent/atomic/AtomicLong;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicLong;->decrementAndGet()J

    .line 88
    :cond_4
    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .line 93
    nop

    :goto_0
    iget-object v0, p0, Lorg/drinkless/tdlib/Client$ResponseReceiver;->clientIds:[I

    iget-object v1, p0, Lorg/drinkless/tdlib/Client$ResponseReceiver;->eventIds:[J

    iget-object v2, p0, Lorg/drinkless/tdlib/Client$ResponseReceiver;->events:[Lorg/drinkless/tdlib/TdApi$Object;

    const-wide v3, 0x40f86a0000000000L    # 100000.0

    invoke-static {v0, v1, v2, v3, v4}, Lorg/drinkless/tdlib/Client;->nativeClientReceive([I[J[Lorg/drinkless/tdlib/TdApi$Object;D)I

    move-result v0

    .line 94
    .local v0, "nativeClientReceive":I
    const/4 v1, 0x0

    .local v1, "i9":I
    :goto_1
    if-ge v1, v0, :cond_0

    .line 95
    iget-object v2, p0, Lorg/drinkless/tdlib/Client$ResponseReceiver;->clientIds:[I

    aget v2, v2, v1

    iget-object v3, p0, Lorg/drinkless/tdlib/Client$ResponseReceiver;->eventIds:[J

    aget-wide v4, v3, v1

    iget-object v3, p0, Lorg/drinkless/tdlib/Client$ResponseReceiver;->events:[Lorg/drinkless/tdlib/TdApi$Object;

    aget-object v3, v3, v1

    invoke-direct {p0, v2, v4, v5, v3}, Lorg/drinkless/tdlib/Client$ResponseReceiver;->processResult(IJLorg/drinkless/tdlib/TdApi$Object;)V

    .line 96
    iget-object v2, p0, Lorg/drinkless/tdlib/Client$ResponseReceiver;->events:[Lorg/drinkless/tdlib/TdApi$Object;

    const/4 v3, 0x0

    aput-object v3, v2, v1

    .line 94
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 98
    .end local v0    # "nativeClientReceive":I
    .end local v1    # "i9":I
    :cond_0
    goto :goto_0
.end method
