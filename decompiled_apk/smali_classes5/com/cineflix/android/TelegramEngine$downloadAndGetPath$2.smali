.class final Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TelegramEngine.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/TelegramEngine;->downloadAndGetPath(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/coroutines/jvm/internal/SuspendLambda;",
        "Lkotlin/jvm/functions/Function2<",
        "Lkotlinx/coroutines/CoroutineScope;",
        "Lkotlin/coroutines/Continuation<",
        "-",
        "Ljava/lang/String;",
        ">;",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nTelegramEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelegramEngine.kt\ncom/cineflix/android/TelegramEngine$downloadAndGetPath$2\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,567:1\n72#2,2:568\n1#3:570\n*S KotlinDebug\n*F\n+ 1 TelegramEngine.kt\ncom/cineflix/android/TelegramEngine$downloadAndGetPath$2\n*L\n462#1:568,2\n462#1:570\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"
    }
    d2 = {
        "<anonymous>",
        "",
        "Lkotlinx/coroutines/CoroutineScope;"
    }
    k = 0x3
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation

.annotation runtime Lkotlin/coroutines/jvm/internal/DebugMetadata;
    c = "com.cineflix.android.TelegramEngine$downloadAndGetPath$2"
    f = "TelegramEngine.kt"
    i = {}
    l = {
        0x1d5
    }
    m = "invokeSuspend"
    n = {}
    s = {}
.end annotation


# instance fields
.field final synthetic $fileId:I

.field final synthetic $priority:I

.field label:I

.field final synthetic this$0:Lcom/cineflix/android/TelegramEngine;


# direct methods
.method public static synthetic $r8$lambda$bjMSE-yT62VyH2LpuWSvfUXpLaU(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->invokeSuspend$lambda$1(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method constructor <init>(Lcom/cineflix/android/TelegramEngine;IILkotlin/coroutines/Continuation;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/cineflix/android/TelegramEngine;",
            "II",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    iput p2, p0, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->$fileId:I

    iput p3, p0, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->$priority:I

    const/4 v0, 0x2

    invoke-direct {p0, v0, p4}, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(ILkotlin/coroutines/Continuation;)V

    return-void
.end method

.method private static final invokeSuspend$lambda$1(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 2
    .param p0, "$deferred"    # Lkotlinx/coroutines/CompletableDeferred;
    .param p1, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 464
    instance-of v0, p1, Lorg/drinkless/tdlib/TdApi$File;

    if-eqz v0, :cond_3

    .line 465
    move-object v0, p1

    check-cast v0, Lorg/drinkless/tdlib/TdApi$File;

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$File;->local:Lorg/drinkless/tdlib/TdApi$LocalFile;

    if-eqz v0, :cond_0

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$LocalFile;->path:Ljava/lang/String;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 466
    .local v0, "p":Ljava/lang/String;
    :goto_0
    move-object v1, v0

    check-cast v1, Ljava/lang/CharSequence;

    if-eqz v1, :cond_2

    invoke-interface {v1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    if-nez v1, :cond_1

    goto :goto_1

    :cond_1
    const/4 v1, 0x0

    goto :goto_2

    :cond_2
    :goto_1
    const/4 v1, 0x1

    :goto_2
    if-nez v1, :cond_3

    invoke-interface {p0, v0}, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z

    .line 468
    .end local v0    # "p":Ljava/lang/String;
    :cond_3
    return-void
.end method


# virtual methods
.method public final create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lkotlin/coroutines/Continuation<",
            "*>;)",
            "Lkotlin/coroutines/Continuation<",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation

    new-instance v0, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;

    iget-object v1, p0, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    iget v2, p0, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->$fileId:I

    iget v3, p0, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->$priority:I

    invoke-direct {v0, v1, v2, v3, p2}, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;-><init>(Lcom/cineflix/android/TelegramEngine;IILkotlin/coroutines/Continuation;)V

    check-cast v0, Lkotlin/coroutines/Continuation;

    return-object v0
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Lkotlinx/coroutines/CoroutineScope;

    check-cast p2, Lkotlin/coroutines/Continuation;

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlinx/coroutines/CoroutineScope;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object v0

    check-cast v0, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;

    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-virtual {v0, v1}, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 18

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 461
    move-object/from16 v1, p0

    iget v2, v1, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->label:I

    packed-switch v2, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v2, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    move-object/from16 v0, p0

    .local v0, "this":Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;
    move-object/from16 v2, p1

    .local v2, "$result":Ljava/lang/Object;
    invoke-static {v2}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v3, v2

    goto :goto_1

    .end local v0    # "this":Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;
    .end local v2    # "$result":Ljava/lang/Object;
    :pswitch_1
    invoke-static/range {p1 .. p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object/from16 v2, p0

    .local v2, "this":Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;
    move-object/from16 v3, p1

    .line 462
    .local v3, "$result":Ljava/lang/Object;
    iget-object v4, v2, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v4}, Lcom/cineflix/android/TelegramEngine;->access$getFilePathEmitters$p(Lcom/cineflix/android/TelegramEngine;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v4

    check-cast v4, Ljava/util/concurrent/ConcurrentMap;

    .local v4, "$this$getOrPut$iv":Ljava/util/concurrent/ConcurrentMap;
    iget v5, v2, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->$fileId:I

    invoke-static {v5}, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;

    move-result-object v5

    .local v5, "key$iv":Ljava/lang/Object;
    const/4 v6, 0x0

    .line 568
    .local v6, "$i$f$getOrPut":I
    invoke-interface {v4, v5}, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    const/4 v8, 0x1

    const/4 v9, 0x0

    if-nez v7, :cond_1

    .line 569
    const/4 v7, 0x0

    .line 462
    .local v7, "$i$a$-getOrPut-TelegramEngine$downloadAndGetPath$2$deferred$1":I
    invoke-static {v9, v8, v9}, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job;ILjava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;

    move-result-object v7

    .line 569
    .end local v7    # "$i$a$-getOrPut-TelegramEngine$downloadAndGetPath$2$deferred$1":I
    nop

    .line 570
    .local v7, "default$iv":Ljava/lang/Object;
    const/4 v10, 0x0

    .line 569
    .local v10, "$i$a$-let-MapsKt__MapsJVMKt$getOrPut$1$iv":I
    invoke-interface {v4, v5, v7}, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    if-nez v11, :cond_0

    goto :goto_0

    :cond_0
    move-object v7, v11

    .line 568
    .end local v4    # "$this$getOrPut$iv":Ljava/util/concurrent/ConcurrentMap;
    .end local v5    # "key$iv":Ljava/lang/Object;
    .end local v7    # "default$iv":Ljava/lang/Object;
    .end local v10    # "$i$a$-let-MapsKt__MapsJVMKt$getOrPut$1$iv":I
    :cond_1
    :goto_0
    nop

    .line 462
    .end local v6    # "$i$f$getOrPut":I
    move-object v4, v7

    check-cast v4, Lkotlinx/coroutines/CompletableDeferred;

    .line 463
    .local v4, "deferred":Lkotlinx/coroutines/CompletableDeferred;
    iget-object v5, v2, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v5}, Lcom/cineflix/android/TelegramEngine;->access$getClient$p(Lcom/cineflix/android/TelegramEngine;)Lorg/drinkless/tdlib/Client;

    move-result-object v5

    if-eqz v5, :cond_2

    new-instance v6, Lorg/drinkless/tdlib/TdApi$DownloadFile;

    iget v11, v2, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->$fileId:I

    iget v12, v2, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->$priority:I

    const-wide/16 v13, 0x0

    const-wide/16 v15, 0x0

    const/16 v17, 0x0

    move-object v10, v6

    invoke-direct/range {v10 .. v17}, Lorg/drinkless/tdlib/TdApi$DownloadFile;-><init>(IIJJZ)V

    check-cast v6, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v7, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2$$ExternalSyntheticLambda0;

    invoke-direct {v7, v4}, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2$$ExternalSyntheticLambda0;-><init>(Lkotlinx/coroutines/CompletableDeferred;)V

    invoke-virtual {v5, v6, v7}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    .line 469
    :cond_2
    new-instance v5, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2$2;

    invoke-direct {v5, v4, v9}, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2$2;-><init>(Lkotlinx/coroutines/CompletableDeferred;Lkotlin/coroutines/Continuation;)V

    check-cast v5, Lkotlin/jvm/functions/Function2;

    move-object v6, v2

    check-cast v6, Lkotlin/coroutines/Continuation;

    iput v8, v2, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->label:I

    const-wide/32 v7, 0x1d4c0

    invoke-static {v7, v8, v5, v6}, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "deferred":Lkotlinx/coroutines/CompletableDeferred;
    if-ne v4, v0, :cond_3

    .line 461
    return-object v0

    .line 469
    :cond_3
    move-object v0, v2

    move-object v2, v4

    .end local v2    # "this":Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;
    .restart local v0    # "this":Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;
    :goto_1
    check-cast v2, Ljava/lang/String;

    if-eqz v2, :cond_4

    return-object v2

    .line 470
    :cond_4
    new-instance v2, Ljava/lang/Exception;

    iget v4, v0, Lcom/cineflix/android/TelegramEngine$downloadAndGetPath$2;->$fileId:I

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "TDLib download timeout for fileId="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v2

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
