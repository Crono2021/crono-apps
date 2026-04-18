.class public final Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1;
.super Ljava/lang/Object;
.source "SingleProcessDataStore.kt"

# interfaces
.implements Landroidx/datastore/core/InitializerApi;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/datastore/core/SingleProcessDataStore;->readAndInit(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroidx/datastore/core/InitializerApi<",
        "TT;>;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nSingleProcessDataStore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SingleProcessDataStore.kt\nandroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,497:1\n109#2,11:498\n*S KotlinDebug\n*F\n+ 1 SingleProcessDataStore.kt\nandroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1\n*L\n329#1:498,11\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001JD\u0010\u0002\u001a\u00028\u000021\u0010\u0003\u001a-\u0008\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\u0008\u0019\u00a8\u0006\u000b"
    }
    d2 = {
        "androidx/datastore/core/SingleProcessDataStore$readAndInit$api$1",
        "Landroidx/datastore/core/InitializerApi;",
        "updateData",
        "transform",
        "Lkotlin/Function2;",
        "Lkotlin/ParameterName;",
        "name",
        "t",
        "Lkotlin/coroutines/Continuation;",
        "",
        "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "datastore-core"
    }
    k = 0x1
    mv = {
        0x1,
        0x5,
        0x1
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic $initData:Lkotlin/jvm/internal/Ref$ObjectRef;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/internal/Ref$ObjectRef<",
            "TT;>;"
        }
    .end annotation
.end field

.field final synthetic $initializationComplete:Lkotlin/jvm/internal/Ref$BooleanRef;

.field final synthetic $updateLock:Lkotlinx/coroutines/sync/Mutex;

.field final synthetic this$0:Landroidx/datastore/core/SingleProcessDataStore;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/datastore/core/SingleProcessDataStore<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lkotlinx/coroutines/sync/Mutex;Lkotlin/jvm/internal/Ref$BooleanRef;Lkotlin/jvm/internal/Ref$ObjectRef;Landroidx/datastore/core/SingleProcessDataStore;)V
    .locals 0
    .param p1, "$updateLock"    # Lkotlinx/coroutines/sync/Mutex;
    .param p2, "$initializationComplete"    # Lkotlin/jvm/internal/Ref$BooleanRef;
    .param p3, "$initData"    # Lkotlin/jvm/internal/Ref$ObjectRef;
    .param p4, "$receiver"    # Landroidx/datastore/core/SingleProcessDataStore;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlinx/coroutines/sync/Mutex;",
            "Lkotlin/jvm/internal/Ref$BooleanRef;",
            "Lkotlin/jvm/internal/Ref$ObjectRef<",
            "TT;>;",
            "Landroidx/datastore/core/SingleProcessDataStore<",
            "TT;>;)V"
        }
    .end annotation

    iput-object p1, p0, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1;->$updateLock:Lkotlinx/coroutines/sync/Mutex;

    iput-object p2, p0, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1;->$initializationComplete:Lkotlin/jvm/internal/Ref$BooleanRef;

    iput-object p3, p0, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1;->$initData:Lkotlin/jvm/internal/Ref$ObjectRef;

    iput-object p4, p0, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1;->this$0:Landroidx/datastore/core/SingleProcessDataStore;

    .line 327
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public updateData(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function2<",
            "-TT;-",
            "Lkotlin/coroutines/Continuation<",
            "-TT;>;+",
            "Ljava/lang/Object;",
            ">;",
            "Lkotlin/coroutines/Continuation<",
            "-TT;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    instance-of v0, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;

    if-eqz v0, :cond_0

    move-object v0, p2

    check-cast v0, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;

    iget v1, v0, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->label:I

    const/high16 v2, -0x80000000

    and-int/2addr v1, v2

    if-eqz v1, :cond_0

    iget p2, v0, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->label:I

    sub-int/2addr p2, v2

    iput p2, v0, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->label:I

    goto :goto_0

    :cond_0
    new-instance v0, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;

    invoke-direct {v0, p0, p2}, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;-><init>(Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1;Lkotlin/coroutines/Continuation;)V

    :goto_0
    move-object p2, v0

    .local p2, "$continuation":Lkotlin/coroutines/Continuation;
    iget-object v0, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->result:Ljava/lang/Object;

    .local v0, "$result":Ljava/lang/Object;
    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v1

    .line 328
    iget v2, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->label:I

    const/4 v3, 0x0

    const/4 v4, 0x0

    packed-switch v2, :pswitch_data_0

    .line 329
    .end local v0    # "$result":Ljava/lang/Object;
    .end local p2    # "$continuation":Lkotlin/coroutines/Continuation;
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 328
    .restart local v0    # "$result":Ljava/lang/Object;
    .restart local p2    # "$continuation":Lkotlin/coroutines/Continuation;
    :pswitch_0
    move-object p1, v3

    .local p1, "owner$iv":Ljava/lang/Object;
    move v1, v4

    .local v1, "$i$f$withLock":I
    move-object v2, v3

    .local v2, "newData":Ljava/lang/Object;
    .local v3, "$this$withLock_u24default$iv":Lkotlinx/coroutines/sync/Mutex;
    .local v4, "$i$a$-withLock$default-SingleProcessDataStore$readAndInit$api$1$updateData$2":I
    const/4 v1, 0x0

    const/4 v4, 0x0

    iget-object v2, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$2:Ljava/lang/Object;

    iget-object v5, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$1:Ljava/lang/Object;

    check-cast v5, Lkotlin/jvm/internal/Ref$ObjectRef;

    const/4 p1, 0x0

    iget-object v6, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$0:Ljava/lang/Object;

    move-object v3, v6

    check-cast v3, Lkotlinx/coroutines/sync/Mutex;

    :try_start_0
    invoke-static {v0}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto/16 :goto_3

    .line 508
    .end local v2    # "newData":Ljava/lang/Object;
    .end local v4    # "$i$a$-withLock$default-SingleProcessDataStore$readAndInit$api$1$updateData$2":I
    :catchall_0
    move-exception v2

    goto/16 :goto_5

    .line 328
    .end local v1    # "$i$f$withLock":I
    .end local v3    # "$this$withLock_u24default$iv":Lkotlinx/coroutines/sync/Mutex;
    .end local p1    # "owner$iv":Ljava/lang/Object;
    :pswitch_1
    move-object p1, v3

    .restart local p1    # "owner$iv":Ljava/lang/Object;
    move v2, v4

    .local v2, "$i$f$withLock":I
    .restart local v3    # "$this$withLock_u24default$iv":Lkotlinx/coroutines/sync/Mutex;
    .restart local v4    # "$i$a$-withLock$default-SingleProcessDataStore$readAndInit$api$1$updateData$2":I
    const/4 v2, 0x0

    const/4 v4, 0x0

    iget-object v5, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$2:Ljava/lang/Object;

    check-cast v5, Landroidx/datastore/core/SingleProcessDataStore;

    iget-object v6, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$1:Ljava/lang/Object;

    check-cast v6, Lkotlin/jvm/internal/Ref$ObjectRef;

    const/4 p1, 0x0

    iget-object v7, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$0:Ljava/lang/Object;

    move-object v3, v7

    check-cast v3, Lkotlinx/coroutines/sync/Mutex;

    :try_start_1
    invoke-static {v0}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-object v7, v0

    move-object v10, v6

    move-object v6, v5

    move-object v5, v10

    goto/16 :goto_2

    .line 508
    .end local v4    # "$i$a$-withLock$default-SingleProcessDataStore$readAndInit$api$1$updateData$2":I
    :catchall_1
    move-exception v1

    move v10, v2

    move-object v2, v1

    move v1, v10

    goto/16 :goto_5

    .line 328
    .end local v2    # "$i$f$withLock":I
    .end local v3    # "$this$withLock_u24default$iv":Lkotlinx/coroutines/sync/Mutex;
    .end local p1    # "owner$iv":Ljava/lang/Object;
    :pswitch_2
    move-object v2, v3

    .local v2, "owner$iv":Ljava/lang/Object;
    .restart local v3    # "$this$withLock_u24default$iv":Lkotlinx/coroutines/sync/Mutex;
    .local v4, "$i$f$withLock":I
    .local p1, "transform":Lkotlin/jvm/functions/Function2;
    const/4 v4, 0x0

    iget-object v5, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$4:Ljava/lang/Object;

    check-cast v5, Landroidx/datastore/core/SingleProcessDataStore;

    iget-object v6, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$3:Ljava/lang/Object;

    check-cast v6, Lkotlin/jvm/internal/Ref$ObjectRef;

    iget-object v7, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$2:Ljava/lang/Object;

    check-cast v7, Lkotlin/jvm/internal/Ref$BooleanRef;

    const/4 v2, 0x0

    iget-object v8, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$1:Ljava/lang/Object;

    move-object v3, v8

    check-cast v3, Lkotlinx/coroutines/sync/Mutex;

    iget-object v8, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$0:Ljava/lang/Object;

    move-object p1, v8

    check-cast p1, Lkotlin/jvm/functions/Function2;

    invoke-static {v0}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    goto :goto_1

    .end local v2    # "owner$iv":Ljava/lang/Object;
    .end local v3    # "$this$withLock_u24default$iv":Lkotlinx/coroutines/sync/Mutex;
    .end local v4    # "$i$f$withLock":I
    .end local p1    # "transform":Lkotlin/jvm/functions/Function2;
    :pswitch_3
    invoke-static {v0}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v2, p0

    .line 329
    .local v2, "this":Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1;
    .restart local p1    # "transform":Lkotlin/jvm/functions/Function2;
    iget-object v3, v2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1;->$updateLock:Lkotlinx/coroutines/sync/Mutex;

    .restart local v3    # "$this$withLock_u24default$iv":Lkotlinx/coroutines/sync/Mutex;
    iget-object v7, v2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1;->$initializationComplete:Lkotlin/jvm/internal/Ref$BooleanRef;

    iget-object v6, v2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1;->$initData:Lkotlin/jvm/internal/Ref$ObjectRef;

    iget-object v4, v2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1;->this$0:Landroidx/datastore/core/SingleProcessDataStore;

    .line 498
    const/4 v5, 0x0

    .local v5, "owner$iv":Ljava/lang/Object;
    const/4 v8, 0x0

    .line 499
    .local v8, "$i$f$withLock":I
    nop

    .line 503
    iput-object p1, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$0:Ljava/lang/Object;

    iput-object v3, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$1:Ljava/lang/Object;

    iput-object v7, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$2:Ljava/lang/Object;

    iput-object v6, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$3:Ljava/lang/Object;

    iput-object v4, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$4:Ljava/lang/Object;

    const/4 v9, 0x1

    iput v9, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->label:I

    invoke-interface {v3, v5, p2}, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "this":Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1;
    if-ne v2, v1, :cond_1

    .line 328
    return-object v1

    .line 503
    :cond_1
    move-object v2, v5

    move-object v5, v4

    move v4, v8

    .line 504
    .end local v5    # "owner$iv":Ljava/lang/Object;
    .end local v8    # "$i$f$withLock":I
    .local v2, "owner$iv":Ljava/lang/Object;
    .restart local v4    # "$i$f$withLock":I
    :goto_1
    nop

    .line 505
    const/4 v8, 0x0

    .line 330
    .local v8, "$i$a$-withLock$default-SingleProcessDataStore$readAndInit$api$1$updateData$2":I
    :try_start_2
    iget-boolean v7, v7, Lkotlin/jvm/internal/Ref$BooleanRef;->element:Z

    if-nez v7, :cond_5

    .line 337
    iget-object v7, v6, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    iput-object v3, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$0:Ljava/lang/Object;

    iput-object v6, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$1:Ljava/lang/Object;

    iput-object v5, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$2:Ljava/lang/Object;

    const/4 v9, 0x0

    iput-object v9, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$3:Ljava/lang/Object;

    iput-object v9, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$4:Ljava/lang/Object;

    const/4 v9, 0x2

    iput v9, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->label:I

    invoke-interface {p1, v7, p2}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .end local p1    # "transform":Lkotlin/jvm/functions/Function2;
    if-ne v7, v1, :cond_2

    .line 328
    return-object v1

    .line 337
    :cond_2
    move-object p1, v2

    move v2, v4

    move v4, v8

    move-object v10, v6

    move-object v6, v5

    move-object v5, v10

    .end local v8    # "$i$a$-withLock$default-SingleProcessDataStore$readAndInit$api$1$updateData$2":I
    .local v2, "$i$f$withLock":I
    .local v4, "$i$a$-withLock$default-SingleProcessDataStore$readAndInit$api$1$updateData$2":I
    .local p1, "owner$iv":Ljava/lang/Object;
    :goto_2
    nop

    .line 338
    .local v7, "newData":Ljava/lang/Object;
    :try_start_3
    iget-object v8, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    invoke-static {v7, v8}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_4

    .line 339
    iput-object v3, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$0:Ljava/lang/Object;

    iput-object v5, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$1:Ljava/lang/Object;

    iput-object v7, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->L$2:Ljava/lang/Object;

    const/4 v8, 0x3

    iput v8, p2, Landroidx/datastore/core/SingleProcessDataStore$readAndInit$api$1$updateData$1;->label:I

    invoke-virtual {v6, v7, p2}, Landroidx/datastore/core/SingleProcessDataStore;->writeData$datastore_core(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    if-ne v6, v1, :cond_3

    .line 328
    return-object v1

    .line 339
    :cond_3
    move v1, v2

    move-object v2, v7

    .line 340
    .end local v7    # "newData":Ljava/lang/Object;
    .restart local v1    # "$i$f$withLock":I
    .local v2, "newData":Ljava/lang/Object;
    :goto_3
    :try_start_4
    iput-object v2, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    move-object v7, v2

    goto :goto_4

    .line 338
    .end local v1    # "$i$f$withLock":I
    .local v2, "$i$f$withLock":I
    .restart local v7    # "newData":Ljava/lang/Object;
    :cond_4
    move v1, v2

    .line 343
    .end local v2    # "$i$f$withLock":I
    .restart local v1    # "$i$f$withLock":I
    :goto_4
    iget-object v2, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 507
    .end local v4    # "$i$a$-withLock$default-SingleProcessDataStore$readAndInit$api$1$updateData$2":I
    .end local v7    # "newData":Ljava/lang/Object;
    invoke-interface {v3, p1}, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V

    .line 505
    nop

    .line 329
    .end local v1    # "$i$f$withLock":I
    .end local v3    # "$this$withLock_u24default$iv":Lkotlinx/coroutines/sync/Mutex;
    .end local p1    # "owner$iv":Ljava/lang/Object;
    return-object v2

    .line 331
    .local v2, "owner$iv":Ljava/lang/Object;
    .restart local v3    # "$this$withLock_u24default$iv":Lkotlinx/coroutines/sync/Mutex;
    .local v4, "$i$f$withLock":I
    .restart local v8    # "$i$a$-withLock$default-SingleProcessDataStore$readAndInit$api$1$updateData$2":I
    .local p1, "transform":Lkotlin/jvm/functions/Function2;
    :cond_5
    :try_start_5
    new-instance v1, Ljava/lang/IllegalStateException;

    .line 332
    const-string v5, "InitializerApi.updateData should not be called after initialization is complete."

    .line 331
    invoke-direct {v1, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .end local v0    # "$result":Ljava/lang/Object;
    .end local v2    # "owner$iv":Ljava/lang/Object;
    .end local v3    # "$this$withLock_u24default$iv":Lkotlinx/coroutines/sync/Mutex;
    .end local v4    # "$i$f$withLock":I
    .end local p2    # "$continuation":Lkotlin/coroutines/Continuation;
    throw v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 508
    .end local v8    # "$i$a$-withLock$default-SingleProcessDataStore$readAndInit$api$1$updateData$2":I
    .end local p1    # "transform":Lkotlin/jvm/functions/Function2;
    .restart local v0    # "$result":Ljava/lang/Object;
    .restart local v2    # "owner$iv":Ljava/lang/Object;
    .restart local v3    # "$this$withLock_u24default$iv":Lkotlinx/coroutines/sync/Mutex;
    .restart local v4    # "$i$f$withLock":I
    .restart local p2    # "$continuation":Lkotlin/coroutines/Continuation;
    :catchall_2
    move-exception p1

    move v1, v4

    move-object v10, v2

    move-object v2, p1

    move-object p1, v10

    .line 507
    .end local v2    # "owner$iv":Ljava/lang/Object;
    .end local v4    # "$i$f$withLock":I
    .restart local v1    # "$i$f$withLock":I
    .local p1, "owner$iv":Ljava/lang/Object;
    :goto_5
    invoke-interface {v3, p1}, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V

    throw v2

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
