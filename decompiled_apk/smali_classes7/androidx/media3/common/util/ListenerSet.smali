.class public final Landroidx/media3/common/util/ListenerSet;
.super Ljava/lang/Object;
.source "ListenerSet.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;,
        Landroidx/media3/common/util/ListenerSet$ListenerHolder;,
        Landroidx/media3/common/util/ListenerSet$Event;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field private static final MSG_ITERATION_FINISHED:I


# instance fields
.field private final clock:Landroidx/media3/common/util/Clock;

.field private final flushingEvents:Ljava/util/ArrayDeque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayDeque<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation
.end field

.field private final handler:Landroidx/media3/common/util/HandlerWrapper;

.field private final iterationFinishedEvent:Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent<",
            "TT;>;"
        }
    .end annotation
.end field

.field private final listeners:Ljava/util/concurrent/CopyOnWriteArraySet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArraySet<",
            "Landroidx/media3/common/util/ListenerSet$ListenerHolder<",
            "TT;>;>;"
        }
    .end annotation
.end field

.field private final queuedEvents:Ljava/util/ArrayDeque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayDeque<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation
.end field

.field private released:Z

.field private final releasedLock:Ljava/lang/Object;

.field private throwsWhenUsingWrongThread:Z


# direct methods
.method public static synthetic $r8$lambda$bio3pd12v5B_9b5UeFaPn9XBQ90(Landroidx/media3/common/util/ListenerSet;Landroid/os/Message;)Z
    .locals 0

    invoke-direct {p0, p1}, Landroidx/media3/common/util/ListenerSet;->handleMessage(Landroid/os/Message;)Z

    move-result p0

    return p0
.end method

.method public constructor <init>(Landroid/os/Looper;Landroidx/media3/common/util/Clock;Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;)V
    .locals 6
    .param p1, "looper"    # Landroid/os/Looper;
    .param p2, "clock"    # Landroidx/media3/common/util/Clock;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Looper;",
            "Landroidx/media3/common/util/Clock;",
            "Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent<",
            "TT;>;)V"
        }
    .end annotation

    .line 102
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    .local p3, "iterationFinishedEvent":Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;, "Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent<TT;>;"
    new-instance v1, Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-direct {v1}, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V

    const/4 v5, 0x1

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v5}, Landroidx/media3/common/util/ListenerSet;-><init>(Ljava/util/concurrent/CopyOnWriteArraySet;Landroid/os/Looper;Landroidx/media3/common/util/Clock;Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;Z)V

    .line 108
    return-void
.end method

.method private constructor <init>(Ljava/util/concurrent/CopyOnWriteArraySet;Landroid/os/Looper;Landroidx/media3/common/util/Clock;Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;Z)V
    .locals 1
    .param p2, "looper"    # Landroid/os/Looper;
    .param p3, "clock"    # Landroidx/media3/common/util/Clock;
    .param p5, "throwsWhenUsingWrongThread"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/CopyOnWriteArraySet<",
            "Landroidx/media3/common/util/ListenerSet$ListenerHolder<",
            "TT;>;>;",
            "Landroid/os/Looper;",
            "Landroidx/media3/common/util/Clock;",
            "Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent<",
            "TT;>;Z)V"
        }
    .end annotation

    .line 115
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    .local p1, "listeners":Ljava/util/concurrent/CopyOnWriteArraySet;, "Ljava/util/concurrent/CopyOnWriteArraySet<Landroidx/media3/common/util/ListenerSet$ListenerHolder<TT;>;>;"
    .local p4, "iterationFinishedEvent":Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;, "Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 116
    iput-object p3, p0, Landroidx/media3/common/util/ListenerSet;->clock:Landroidx/media3/common/util/Clock;

    .line 117
    iput-object p1, p0, Landroidx/media3/common/util/ListenerSet;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    .line 118
    iput-object p4, p0, Landroidx/media3/common/util/ListenerSet;->iterationFinishedEvent:Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;

    .line 119
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroidx/media3/common/util/ListenerSet;->releasedLock:Ljava/lang/Object;

    .line 120
    new-instance v0, Ljava/util/ArrayDeque;

    invoke-direct {v0}, Ljava/util/ArrayDeque;-><init>()V

    iput-object v0, p0, Landroidx/media3/common/util/ListenerSet;->flushingEvents:Ljava/util/ArrayDeque;

    .line 121
    new-instance v0, Ljava/util/ArrayDeque;

    invoke-direct {v0}, Ljava/util/ArrayDeque;-><init>()V

    iput-object v0, p0, Landroidx/media3/common/util/ListenerSet;->queuedEvents:Ljava/util/ArrayDeque;

    .line 124
    new-instance v0, Landroidx/media3/common/util/ListenerSet$$ExternalSyntheticLambda0;

    invoke-direct {v0, p0}, Landroidx/media3/common/util/ListenerSet$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/common/util/ListenerSet;)V

    invoke-interface {p3, p2, v0}, Landroidx/media3/common/util/Clock;->createHandler(Landroid/os/Looper;Landroid/os/Handler$Callback;)Landroidx/media3/common/util/HandlerWrapper;

    move-result-object v0

    .line 125
    .local v0, "handler":Landroidx/media3/common/util/HandlerWrapper;
    iput-object v0, p0, Landroidx/media3/common/util/ListenerSet;->handler:Landroidx/media3/common/util/HandlerWrapper;

    .line 126
    iput-boolean p5, p0, Landroidx/media3/common/util/ListenerSet;->throwsWhenUsingWrongThread:Z

    .line 127
    return-void
.end method

.method private handleMessage(Landroid/os/Message;)Z
    .locals 4
    .param p1, "message"    # Landroid/os/Message;

    .line 293
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/common/util/ListenerSet$ListenerHolder;

    .line 294
    .local v1, "holder":Landroidx/media3/common/util/ListenerSet$ListenerHolder;, "Landroidx/media3/common/util/ListenerSet$ListenerHolder<TT;>;"
    iget-object v2, p0, Landroidx/media3/common/util/ListenerSet;->iterationFinishedEvent:Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ListenerSet$ListenerHolder;->iterationFinished(Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;)V

    .line 295
    iget-object v2, p0, Landroidx/media3/common/util/ListenerSet;->handler:Landroidx/media3/common/util/HandlerWrapper;

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Landroidx/media3/common/util/HandlerWrapper;->hasMessages(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 299
    goto :goto_1

    .line 301
    .end local v1    # "holder":Landroidx/media3/common/util/ListenerSet$ListenerHolder;, "Landroidx/media3/common/util/ListenerSet$ListenerHolder<TT;>;"
    :cond_0
    goto :goto_0

    .line 302
    :cond_1
    :goto_1
    const/4 v0, 0x1

    return v0
.end method

.method static synthetic lambda$queueEvent$0(Ljava/util/concurrent/CopyOnWriteArraySet;ILandroidx/media3/common/util/ListenerSet$Event;)V
    .locals 2
    .param p0, "listenerSnapshot"    # Ljava/util/concurrent/CopyOnWriteArraySet;
    .param p1, "eventFlag"    # I
    .param p2, "event"    # Landroidx/media3/common/util/ListenerSet$Event;

    .line 222
    invoke-virtual {p0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/common/util/ListenerSet$ListenerHolder;

    .line 223
    .local v1, "holder":Landroidx/media3/common/util/ListenerSet$ListenerHolder;, "Landroidx/media3/common/util/ListenerSet$ListenerHolder<TT;>;"
    invoke-virtual {v1, p1, p2}, Landroidx/media3/common/util/ListenerSet$ListenerHolder;->invoke(ILandroidx/media3/common/util/ListenerSet$Event;)V

    .line 224
    .end local v1    # "holder":Landroidx/media3/common/util/ListenerSet$ListenerHolder;, "Landroidx/media3/common/util/ListenerSet$ListenerHolder<TT;>;"
    goto :goto_0

    .line 225
    :cond_0
    return-void
.end method

.method private verifyCurrentThread()V
    .locals 2

    .line 306
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    iget-boolean v0, p0, Landroidx/media3/common/util/ListenerSet;->throwsWhenUsingWrongThread:Z

    if-nez v0, :cond_0

    .line 307
    return-void

    .line 309
    :cond_0
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    iget-object v1, p0, Landroidx/media3/common/util/ListenerSet;->handler:Landroidx/media3/common/util/HandlerWrapper;

    invoke-interface {v1}, Landroidx/media3/common/util/HandlerWrapper;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v1

    if-ne v0, v1, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 310
    return-void
.end method


# virtual methods
.method public add(Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 172
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    .local p1, "listener":Ljava/lang/Object;, "TT;"
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 173
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->releasedLock:Ljava/lang/Object;

    monitor-enter v0

    .line 174
    :try_start_0
    iget-boolean v1, p0, Landroidx/media3/common/util/ListenerSet;->released:Z

    if-eqz v1, :cond_0

    .line 175
    monitor-exit v0

    return-void

    .line 177
    :cond_0
    iget-object v1, p0, Landroidx/media3/common/util/ListenerSet;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    new-instance v2, Landroidx/media3/common/util/ListenerSet$ListenerHolder;

    invoke-direct {v2, p1}, Landroidx/media3/common/util/ListenerSet$ListenerHolder;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v1, v2}, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z

    .line 178
    monitor-exit v0

    .line 179
    return-void

    .line 178
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public clear()V
    .locals 1

    .line 200
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    invoke-direct {p0}, Landroidx/media3/common/util/ListenerSet;->verifyCurrentThread()V

    .line 201
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->clear()V

    .line 202
    return-void
.end method

.method public copy(Landroid/os/Looper;Landroidx/media3/common/util/Clock;Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;)Landroidx/media3/common/util/ListenerSet;
    .locals 7
    .param p1, "looper"    # Landroid/os/Looper;
    .param p2, "clock"    # Landroidx/media3/common/util/Clock;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Looper;",
            "Landroidx/media3/common/util/Clock;",
            "Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent<",
            "TT;>;)",
            "Landroidx/media3/common/util/ListenerSet<",
            "TT;>;"
        }
    .end annotation

    .line 158
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    .local p3, "iterationFinishedEvent":Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;, "Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent<TT;>;"
    new-instance v6, Landroidx/media3/common/util/ListenerSet;

    iget-object v1, p0, Landroidx/media3/common/util/ListenerSet;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    iget-boolean v5, p0, Landroidx/media3/common/util/ListenerSet;->throwsWhenUsingWrongThread:Z

    move-object v0, v6

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v5}, Landroidx/media3/common/util/ListenerSet;-><init>(Ljava/util/concurrent/CopyOnWriteArraySet;Landroid/os/Looper;Landroidx/media3/common/util/Clock;Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;Z)V

    return-object v6
.end method

.method public copy(Landroid/os/Looper;Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;)Landroidx/media3/common/util/ListenerSet;
    .locals 1
    .param p1, "looper"    # Landroid/os/Looper;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Looper;",
            "Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent<",
            "TT;>;)",
            "Landroidx/media3/common/util/ListenerSet<",
            "TT;>;"
        }
    .end annotation

    .line 141
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    .local p2, "iterationFinishedEvent":Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;, "Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent<TT;>;"
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->clock:Landroidx/media3/common/util/Clock;

    invoke-virtual {p0, p1, v0, p2}, Landroidx/media3/common/util/ListenerSet;->copy(Landroid/os/Looper;Landroidx/media3/common/util/Clock;Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;)Landroidx/media3/common/util/ListenerSet;

    move-result-object v0

    return-object v0
.end method

.method public flushEvents()V
    .locals 3

    .line 230
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    invoke-direct {p0}, Landroidx/media3/common/util/ListenerSet;->verifyCurrentThread()V

    .line 231
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->queuedEvents:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 232
    return-void

    .line 234
    :cond_0
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->handler:Landroidx/media3/common/util/HandlerWrapper;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroidx/media3/common/util/HandlerWrapper;->hasMessages(I)Z

    move-result v0

    if-nez v0, :cond_1

    .line 235
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->handler:Landroidx/media3/common/util/HandlerWrapper;

    invoke-interface {v0, v1}, Landroidx/media3/common/util/HandlerWrapper;->obtainMessage(I)Landroidx/media3/common/util/HandlerWrapper$Message;

    move-result-object v1

    invoke-interface {v0, v1}, Landroidx/media3/common/util/HandlerWrapper;->sendMessageAtFrontOfQueue(Landroidx/media3/common/util/HandlerWrapper$Message;)Z

    .line 237
    :cond_1
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->flushingEvents:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    .line 238
    .local v0, "recursiveFlushInProgress":Z
    iget-object v1, p0, Landroidx/media3/common/util/ListenerSet;->flushingEvents:Ljava/util/ArrayDeque;

    iget-object v2, p0, Landroidx/media3/common/util/ListenerSet;->queuedEvents:Ljava/util/ArrayDeque;

    invoke-virtual {v1, v2}, Ljava/util/ArrayDeque;->addAll(Ljava/util/Collection;)Z

    .line 239
    iget-object v1, p0, Landroidx/media3/common/util/ListenerSet;->queuedEvents:Ljava/util/ArrayDeque;

    invoke-virtual {v1}, Ljava/util/ArrayDeque;->clear()V

    .line 240
    if-eqz v0, :cond_2

    .line 242
    return-void

    .line 244
    :cond_2
    :goto_0
    iget-object v1, p0, Landroidx/media3/common/util/ListenerSet;->flushingEvents:Ljava/util/ArrayDeque;

    invoke-virtual {v1}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    .line 245
    iget-object v1, p0, Landroidx/media3/common/util/ListenerSet;->flushingEvents:Ljava/util/ArrayDeque;

    invoke-virtual {v1}, Ljava/util/ArrayDeque;->peekFirst()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V

    .line 246
    iget-object v1, p0, Landroidx/media3/common/util/ListenerSet;->flushingEvents:Ljava/util/ArrayDeque;

    invoke-virtual {v1}, Ljava/util/ArrayDeque;->removeFirst()Ljava/lang/Object;

    goto :goto_0

    .line 248
    :cond_3
    return-void
.end method

.method public queueEvent(ILandroidx/media3/common/util/ListenerSet$Event;)V
    .locals 3
    .param p1, "eventFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroidx/media3/common/util/ListenerSet$Event<",
            "TT;>;)V"
        }
    .end annotation

    .line 218
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    .local p2, "event":Landroidx/media3/common/util/ListenerSet$Event;, "Landroidx/media3/common/util/ListenerSet$Event<TT;>;"
    invoke-direct {p0}, Landroidx/media3/common/util/ListenerSet;->verifyCurrentThread()V

    .line 219
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;

    iget-object v1, p0, Landroidx/media3/common/util/ListenerSet;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-direct {v0, v1}, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>(Ljava/util/Collection;)V

    .line 220
    .local v0, "listenerSnapshot":Ljava/util/concurrent/CopyOnWriteArraySet;, "Ljava/util/concurrent/CopyOnWriteArraySet<Landroidx/media3/common/util/ListenerSet$ListenerHolder<TT;>;>;"
    iget-object v1, p0, Landroidx/media3/common/util/ListenerSet;->queuedEvents:Ljava/util/ArrayDeque;

    new-instance v2, Landroidx/media3/common/util/ListenerSet$$ExternalSyntheticLambda1;

    invoke-direct {v2, v0, p1, p2}, Landroidx/media3/common/util/ListenerSet$$ExternalSyntheticLambda1;-><init>(Ljava/util/concurrent/CopyOnWriteArraySet;ILandroidx/media3/common/util/ListenerSet$Event;)V

    invoke-virtual {v1, v2}, Ljava/util/ArrayDeque;->add(Ljava/lang/Object;)Z

    .line 226
    return-void
.end method

.method public release()V
    .locals 3

    .line 269
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    invoke-direct {p0}, Landroidx/media3/common/util/ListenerSet;->verifyCurrentThread()V

    .line 270
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->releasedLock:Ljava/lang/Object;

    monitor-enter v0

    .line 271
    const/4 v1, 0x1

    :try_start_0
    iput-boolean v1, p0, Landroidx/media3/common/util/ListenerSet;->released:Z

    .line 272
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 273
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/common/util/ListenerSet$ListenerHolder;

    .line 274
    .local v1, "listenerHolder":Landroidx/media3/common/util/ListenerSet$ListenerHolder;, "Landroidx/media3/common/util/ListenerSet$ListenerHolder<TT;>;"
    iget-object v2, p0, Landroidx/media3/common/util/ListenerSet;->iterationFinishedEvent:Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ListenerSet$ListenerHolder;->release(Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;)V

    .line 275
    .end local v1    # "listenerHolder":Landroidx/media3/common/util/ListenerSet$ListenerHolder;, "Landroidx/media3/common/util/ListenerSet$ListenerHolder<TT;>;"
    goto :goto_0

    .line 276
    :cond_0
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->clear()V

    .line 277
    return-void

    .line 272
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method public remove(Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 189
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    .local p1, "listener":Ljava/lang/Object;, "TT;"
    invoke-direct {p0}, Landroidx/media3/common/util/ListenerSet;->verifyCurrentThread()V

    .line 190
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/common/util/ListenerSet$ListenerHolder;

    .line 191
    .local v1, "listenerHolder":Landroidx/media3/common/util/ListenerSet$ListenerHolder;, "Landroidx/media3/common/util/ListenerSet$ListenerHolder<TT;>;"
    iget-object v2, v1, Landroidx/media3/common/util/ListenerSet$ListenerHolder;->listener:Ljava/lang/Object;

    invoke-virtual {v2, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 192
    iget-object v2, p0, Landroidx/media3/common/util/ListenerSet;->iterationFinishedEvent:Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ListenerSet$ListenerHolder;->release(Landroidx/media3/common/util/ListenerSet$IterationFinishedEvent;)V

    .line 193
    iget-object v2, p0, Landroidx/media3/common/util/ListenerSet;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v2, v1}, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z

    .line 195
    .end local v1    # "listenerHolder":Landroidx/media3/common/util/ListenerSet$ListenerHolder;, "Landroidx/media3/common/util/ListenerSet$ListenerHolder<TT;>;"
    :cond_0
    goto :goto_0

    .line 196
    :cond_1
    return-void
.end method

.method public sendEvent(ILandroidx/media3/common/util/ListenerSet$Event;)V
    .locals 0
    .param p1, "eventFlag"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroidx/media3/common/util/ListenerSet$Event<",
            "TT;>;)V"
        }
    .end annotation

    .line 259
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    .local p2, "event":Landroidx/media3/common/util/ListenerSet$Event;, "Landroidx/media3/common/util/ListenerSet$Event<TT;>;"
    invoke-virtual {p0, p1, p2}, Landroidx/media3/common/util/ListenerSet;->queueEvent(ILandroidx/media3/common/util/ListenerSet$Event;)V

    .line 260
    invoke-virtual {p0}, Landroidx/media3/common/util/ListenerSet;->flushEvents()V

    .line 261
    return-void
.end method

.method public setThrowsWhenUsingWrongThread(Z)V
    .locals 0
    .param p1, "throwsWhenUsingWrongThread"    # Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 289
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    iput-boolean p1, p0, Landroidx/media3/common/util/ListenerSet;->throwsWhenUsingWrongThread:Z

    .line 290
    return-void
.end method

.method public size()I
    .locals 1

    .line 206
    .local p0, "this":Landroidx/media3/common/util/ListenerSet;, "Landroidx/media3/common/util/ListenerSet<TT;>;"
    invoke-direct {p0}, Landroidx/media3/common/util/ListenerSet;->verifyCurrentThread()V

    .line 207
    iget-object v0, p0, Landroidx/media3/common/util/ListenerSet;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->size()I

    move-result v0

    return v0
.end method
