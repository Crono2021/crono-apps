.class final Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TelegramEngine.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/TelegramEngine;->getVideoMessagesHistory(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;
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
        "Ljava/util/List<",
        "+",
        "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
        ">;>;",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nTelegramEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelegramEngine.kt\ncom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,567:1\n1045#2:568\n*S KotlinDebug\n*F\n+ 1 TelegramEngine.kt\ncom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2\n*L\n543#1:568\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"
    }
    d2 = {
        "<anonymous>",
        "",
        "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
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
    c = "com.cineflix.android.TelegramEngine$getVideoMessagesHistory$2"
    f = "TelegramEngine.kt"
    i = {
        0x1
    }
    l = {
        0x211,
        0x21e
    }
    m = "invokeSuspend"
    n = {
        "collected"
    }
    s = {
        "L$0"
    }
.end annotation


# instance fields
.field final synthetic $limit:I

.field final synthetic $minId:J

.field L$0:Ljava/lang/Object;

.field label:I

.field final synthetic this$0:Lcom/cineflix/android/TelegramEngine;


# direct methods
.method public static synthetic $r8$lambda$LtVwJWn1MekNlE0WHMg-5ivyvcE(JLcom/cineflix/android/TelegramEngine;Ljava/util/List;Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static/range {p0 .. p5}, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->invokeSuspend$lambda$0(JLcom/cineflix/android/TelegramEngine;Ljava/util/List;Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method constructor <init>(Lcom/cineflix/android/TelegramEngine;IJLkotlin/coroutines/Continuation;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/cineflix/android/TelegramEngine;",
            "IJ",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    iput p2, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->$limit:I

    iput-wide p3, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->$minId:J

    const/4 v0, 0x2

    invoke-direct {p0, v0, p5}, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(ILkotlin/coroutines/Continuation;)V

    return-void
.end method

.method private static final invokeSuspend$lambda$0(JLcom/cineflix/android/TelegramEngine;Ljava/util/List;Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 6
    .param p0, "$minId"    # J
    .param p2, "this$0"    # Lcom/cineflix/android/TelegramEngine;
    .param p3, "$collected"    # Ljava/util/List;
    .param p4, "$deferred"    # Lkotlinx/coroutines/CompletableDeferred;
    .param p5, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 533
    instance-of v0, p5, Lorg/drinkless/tdlib/TdApi$Messages;

    if-eqz v0, :cond_2

    .line 534
    move-object v0, p5

    check-cast v0, Lorg/drinkless/tdlib/TdApi$Messages;

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$Messages;->messages:[Lorg/drinkless/tdlib/TdApi$Message;

    const-string v1, "messages"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    array-length v1, v0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_2

    aget-object v3, v0, v2

    .line 535
    .local v3, "msg":Lorg/drinkless/tdlib/TdApi$Message;
    iget-wide v4, v3, Lorg/drinkless/tdlib/TdApi$Message;->id:J

    cmp-long v4, v4, p0

    if-lez v4, :cond_1

    .line 536
    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-static {p2, v3}, Lcom/cineflix/android/TelegramEngine;->access$extractVideoInfo(Lcom/cineflix/android/TelegramEngine;Lorg/drinkless/tdlib/TdApi$Message;)Lcom/cineflix/android/TelegramEngine$VideoInfo;

    move-result-object v4

    if-nez v4, :cond_0

    goto :goto_1

    .line 537
    .local v4, "info":Lcom/cineflix/android/TelegramEngine$VideoInfo;
    :cond_0
    invoke-interface {p3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 534
    .end local v3    # "msg":Lorg/drinkless/tdlib/TdApi$Message;
    .end local v4    # "info":Lcom/cineflix/android/TelegramEngine$VideoInfo;
    :cond_1
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 540
    :cond_2
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-interface {p4, v0}, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z

    .line 541
    return-void
.end method


# virtual methods
.method public final create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    .locals 7
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

    new-instance v6, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;

    iget-object v1, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    iget v2, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->$limit:I

    iget-wide v3, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->$minId:J

    move-object v0, v6

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;-><init>(Lcom/cineflix/android/TelegramEngine;IJLkotlin/coroutines/Continuation;)V

    check-cast v6, Lkotlin/coroutines/Continuation;

    return-object v6
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Lkotlinx/coroutines/CoroutineScope;

    check-cast p2, Lkotlin/coroutines/Continuation;

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

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
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
            ">;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object v0

    check-cast v0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;

    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-virtual {v0, v1}, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 17

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 528
    move-object/from16 v1, p0

    iget v2, v1, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->label:I

    const/4 v3, 0x1

    packed-switch v2, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    move-object/from16 v0, p0

    .local v0, "this":Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;
    move-object/from16 v2, p1

    .local v2, "$result":Ljava/lang/Object;
    iget-object v3, v0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->L$0:Ljava/lang/Object;

    check-cast v3, Ljava/util/List;

    .local v3, "collected":Ljava/util/List;
    invoke-static {v2}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    goto/16 :goto_1

    .end local v0    # "this":Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;
    .end local v2    # "$result":Ljava/lang/Object;
    .end local v3    # "collected":Ljava/util/List;
    :pswitch_1
    move-object/from16 v2, p0

    .local v2, "this":Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;
    move-object/from16 v4, p1

    .local v4, "$result":Ljava/lang/Object;
    invoke-static {v4}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v5, v4

    goto :goto_0

    .end local v2    # "this":Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;
    .end local v4    # "$result":Ljava/lang/Object;
    :pswitch_2
    invoke-static/range {p1 .. p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object/from16 v2, p0

    .restart local v2    # "this":Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;
    move-object/from16 v4, p1

    .line 529
    .restart local v4    # "$result":Ljava/lang/Object;
    iget-object v5, v2, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    move-object v6, v2

    check-cast v6, Lkotlin/coroutines/Continuation;

    iput v3, v2, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->label:I

    invoke-static {v5, v6}, Lcom/cineflix/android/TelegramEngine;->access$getBotChatId(Lcom/cineflix/android/TelegramEngine;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v5

    if-ne v5, v0, :cond_0

    .line 528
    return-object v0

    .line 529
    :cond_0
    :goto_0
    check-cast v5, Ljava/lang/Long;

    if-eqz v5, :cond_3

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    .line 530
    .local v7, "chatId":J
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    check-cast v5, Ljava/util/List;

    .line 531
    .local v5, "collected":Ljava/util/List;
    const/4 v15, 0x0

    invoke-static {v15, v3, v15}, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job;ILjava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;

    move-result-object v3

    .line 532
    .local v3, "deferred":Lkotlinx/coroutines/CompletableDeferred;
    iget-object v6, v2, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v6}, Lcom/cineflix/android/TelegramEngine;->access$getClient$p(Lcom/cineflix/android/TelegramEngine;)Lorg/drinkless/tdlib/Client;

    move-result-object v14

    if-eqz v14, :cond_1

    new-instance v16, Lorg/drinkless/tdlib/TdApi$GetChatHistory;

    const-wide/16 v9, 0x0

    const/4 v11, 0x0

    iget v6, v2, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->$limit:I

    const/16 v12, 0xa

    invoke-static {v6, v12}, Lkotlin/ranges/RangesKt;->coerceAtLeast(II)I

    move-result v12

    const/4 v13, 0x0

    move-object/from16 v6, v16

    invoke-direct/range {v6 .. v13}, Lorg/drinkless/tdlib/TdApi$GetChatHistory;-><init>(JJIIZ)V

    move-object/from16 v6, v16

    check-cast v6, Lorg/drinkless/tdlib/TdApi$Function;

    iget-wide v10, v2, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->$minId:J

    iget-object v12, v2, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    new-instance v13, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$$ExternalSyntheticLambda0;

    move-object v9, v13

    move-object v15, v13

    move-object v13, v5

    move-object v1, v14

    move-object v14, v3

    invoke-direct/range {v9 .. v14}, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$$ExternalSyntheticLambda0;-><init>(JLcom/cineflix/android/TelegramEngine;Ljava/util/List;Lkotlinx/coroutines/CompletableDeferred;)V

    invoke-virtual {v1, v6, v15}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    nop

    .line 542
    .end local v7    # "chatId":J
    :cond_1
    new-instance v1, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$2;

    const/4 v6, 0x0

    invoke-direct {v1, v3, v6}, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$2;-><init>(Lkotlinx/coroutines/CompletableDeferred;Lkotlin/coroutines/Continuation;)V

    check-cast v1, Lkotlin/jvm/functions/Function2;

    move-object v6, v2

    check-cast v6, Lkotlin/coroutines/Continuation;

    iput-object v5, v2, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->L$0:Ljava/lang/Object;

    const/4 v7, 0x2

    iput v7, v2, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->label:I

    const-wide/16 v7, 0x2710

    invoke-static {v7, v8, v1, v6}, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v1

    .end local v3    # "deferred":Lkotlinx/coroutines/CompletableDeferred;
    if-ne v1, v0, :cond_2

    .line 528
    return-object v0

    .line 542
    :cond_2
    move-object v0, v2

    move-object v2, v4

    move-object v3, v5

    .line 543
    .end local v4    # "$result":Ljava/lang/Object;
    .end local v5    # "collected":Ljava/util/List;
    .restart local v0    # "this":Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;
    .local v2, "$result":Ljava/lang/Object;
    .local v3, "collected":Ljava/util/List;
    :goto_1
    move-object v1, v3

    check-cast v1, Ljava/lang/Iterable;

    .local v1, "$this$sortedBy$iv":Ljava/lang/Iterable;
    const/4 v4, 0x0

    .line 568
    .local v4, "$i$f$sortedBy":I
    new-instance v5, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$invokeSuspend$$inlined$sortedBy$1;

    invoke-direct {v5}, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$invokeSuspend$$inlined$sortedBy$1;-><init>()V

    check-cast v5, Ljava/util/Comparator;

    invoke-static {v1, v5}, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/List;

    move-result-object v1

    .line 543
    .end local v1    # "$this$sortedBy$iv":Ljava/lang/Iterable;
    .end local v4    # "$i$f$sortedBy":I
    return-object v1

    .line 529
    .end local v0    # "this":Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;
    .end local v3    # "collected":Ljava/util/List;
    .local v2, "this":Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;
    .local v4, "$result":Ljava/lang/Object;
    :cond_3
    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object v0

    return-object v0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
