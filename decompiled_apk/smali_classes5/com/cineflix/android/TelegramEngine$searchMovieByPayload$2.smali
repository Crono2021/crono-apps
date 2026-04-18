.class final Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TelegramEngine.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/TelegramEngine;->searchMovieByPayload(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
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
    value = "SMAP\nTelegramEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelegramEngine.kt\ncom/cineflix/android/TelegramEngine$searchMovieByPayload$2\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,567:1\n26#2:568\n1#3:569\n*S KotlinDebug\n*F\n+ 1 TelegramEngine.kt\ncom/cineflix/android/TelegramEngine$searchMovieByPayload$2\n*L\n380#1:568\n*E\n"
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
    c = "com.cineflix.android.TelegramEngine$searchMovieByPayload$2"
    f = "TelegramEngine.kt"
    i = {
        0x1,
        0x2,
        0x2,
        0x3,
        0x3,
        0x4,
        0x4,
        0x4,
        0x4,
        0x4
    }
    l = {
        0x16b,
        0x174,
        0x182,
        0x188,
        0x18d
    }
    m = "invokeSuspend"
    n = {
        "chatId",
        "collectorKey",
        "collector",
        "collectorKey",
        "collector",
        "collectorKey",
        "collector",
        "silenceMs",
        "maxExtra",
        "start"
    }
    s = {
        "J$0",
        "L$0",
        "L$1",
        "L$0",
        "L$1",
        "L$0",
        "L$1",
        "J$0",
        "J$1",
        "J$2"
    }
.end annotation


# instance fields
.field final synthetic $searchTitle:Ljava/lang/String;

.field J$0:J

.field J$1:J

.field J$2:J

.field L$0:Ljava/lang/Object;

.field L$1:Ljava/lang/Object;

.field label:I

.field final synthetic this$0:Lcom/cineflix/android/TelegramEngine;


# direct methods
.method public static synthetic $r8$lambda$aZra8qqVeD4n21R75_4HeY4VJfk(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->invokeSuspend$lambda$1(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method public static synthetic $r8$lambda$itl7HpLAxv3Aircrkd-XErX-MV8(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->invokeSuspend$lambda$0(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method constructor <init>(Lcom/cineflix/android/TelegramEngine;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/cineflix/android/TelegramEngine;",
            "Ljava/lang/String;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    iput-object p2, p0, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->$searchTitle:Ljava/lang/String;

    const/4 v0, 0x2

    invoke-direct {p0, v0, p3}, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(ILkotlin/coroutines/Continuation;)V

    return-void
.end method

.method private static final invokeSuspend$lambda$0(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 3
    .param p0, "$anchorDeferred"    # Lkotlinx/coroutines/CompletableDeferred;
    .param p1, "hist"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 368
    instance-of v0, p1, Lorg/drinkless/tdlib/TdApi$Messages;

    if-eqz v0, :cond_1

    move-object v0, p1

    check-cast v0, Lorg/drinkless/tdlib/TdApi$Messages;

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$Messages;->messages:[Lorg/drinkless/tdlib/TdApi$Message;

    const-string v1, "messages"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, [Ljava/lang/Object;

    array-length v0, v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-nez v0, :cond_0

    move v0, v1

    goto :goto_0

    :cond_0
    move v0, v2

    :goto_0
    xor-int/2addr v0, v1

    if-eqz v0, :cond_1

    .line 369
    move-object v0, p1

    check-cast v0, Lorg/drinkless/tdlib/TdApi$Messages;

    iget-object v0, v0, Lorg/drinkless/tdlib/TdApi$Messages;->messages:[Lorg/drinkless/tdlib/TdApi$Message;

    aget-object v0, v0, v2

    iget-wide v0, v0, Lorg/drinkless/tdlib/TdApi$Message;->id:J

    goto :goto_1

    :cond_1
    const-wide/16 v0, 0x0

    .line 368
    :goto_1
    nop

    .line 370
    .local v0, "lastId":J
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {p0, v2}, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z

    .line 371
    return-void
.end method

.method private static final invokeSuspend$lambda$1(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 1
    .param p0, "$sendDeferred"    # Lkotlinx/coroutines/CompletableDeferred;
    .param p1, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 384
    instance-of v0, p1, Lorg/drinkless/tdlib/TdApi$Error;

    xor-int/lit8 v0, v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-interface {p0, v0}, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z

    return-void
.end method


# virtual methods
.method public final create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    .locals 3
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

    new-instance v0, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;

    iget-object v1, p0, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    iget-object v2, p0, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->$searchTitle:Ljava/lang/String;

    invoke-direct {v0, v1, v2, p2}, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;-><init>(Lcom/cineflix/android/TelegramEngine;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    check-cast v0, Lkotlin/coroutines/Continuation;

    return-object v0
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Lkotlinx/coroutines/CoroutineScope;

    check-cast p2, Lkotlin/coroutines/Continuation;

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

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

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object v0

    check-cast v0, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;

    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-virtual {v0, v1}, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 26

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 362
    move-object/from16 v1, p0

    iget v2, v1, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->label:I

    const/4 v3, 0x1

    const/4 v4, 0x0

    packed-switch v2, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    move-object/from16 v2, p0

    .local v2, "this":Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;
    move-object/from16 v4, p1

    .local v4, "$result":Ljava/lang/Object;
    iget-wide v5, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->J$2:J

    .local v5, "start":J
    iget-wide v7, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->J$1:J

    .local v7, "maxExtra":J
    iget-wide v9, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->J$0:J

    .local v9, "silenceMs":J
    iget-object v11, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->L$1:Ljava/lang/Object;

    check-cast v11, Lcom/cineflix/android/TelegramEngine$MsgCollector;

    .local v11, "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    iget-object v12, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->L$0:Ljava/lang/Object;

    check-cast v12, Ljava/lang/String;

    .local v12, "collectorKey":Ljava/lang/String;
    invoke-static {v4}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    goto/16 :goto_4

    .end local v2    # "this":Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;
    .end local v4    # "$result":Ljava/lang/Object;
    .end local v5    # "start":J
    .end local v7    # "maxExtra":J
    .end local v9    # "silenceMs":J
    .end local v11    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .end local v12    # "collectorKey":Ljava/lang/String;
    :pswitch_1
    move-object/from16 v2, p0

    .restart local v2    # "this":Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;
    move-object/from16 v4, p1

    .restart local v4    # "$result":Ljava/lang/Object;
    iget-object v5, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->L$1:Ljava/lang/Object;

    check-cast v5, Lcom/cineflix/android/TelegramEngine$MsgCollector;

    .local v5, "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    iget-object v6, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->L$0:Ljava/lang/Object;

    check-cast v6, Ljava/lang/String;

    .local v6, "collectorKey":Ljava/lang/String;
    invoke-static {v4}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    goto/16 :goto_3

    .end local v2    # "this":Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;
    .end local v4    # "$result":Ljava/lang/Object;
    .end local v5    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .end local v6    # "collectorKey":Ljava/lang/String;
    :pswitch_2
    move-object/from16 v2, p0

    .restart local v2    # "this":Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;
    move-object/from16 v4, p1

    .restart local v4    # "$result":Ljava/lang/Object;
    iget-object v5, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->L$1:Ljava/lang/Object;

    check-cast v5, Lcom/cineflix/android/TelegramEngine$MsgCollector;

    .restart local v5    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    iget-object v6, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->L$0:Ljava/lang/Object;

    check-cast v6, Ljava/lang/String;

    .restart local v6    # "collectorKey":Ljava/lang/String;
    invoke-static {v4}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v3, v6

    move-object v6, v4

    goto/16 :goto_2

    .end local v2    # "this":Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;
    .end local v4    # "$result":Ljava/lang/Object;
    .end local v5    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .end local v6    # "collectorKey":Ljava/lang/String;
    :pswitch_3
    move-object/from16 v2, p0

    .restart local v2    # "this":Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;
    move-object/from16 v5, p1

    .local v5, "$result":Ljava/lang/Object;
    iget-wide v6, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->J$0:J

    .local v6, "chatId":J
    invoke-static {v5}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-wide/from16 v17, v6

    move-object v6, v5

    goto/16 :goto_1

    .end local v2    # "this":Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;
    .end local v5    # "$result":Ljava/lang/Object;
    .end local v6    # "chatId":J
    :pswitch_4
    move-object/from16 v2, p0

    .restart local v2    # "this":Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;
    move-object/from16 v5, p1

    .restart local v5    # "$result":Ljava/lang/Object;
    invoke-static {v5}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v6, v5

    goto :goto_0

    .end local v2    # "this":Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;
    .end local v5    # "$result":Ljava/lang/Object;
    :pswitch_5
    invoke-static/range {p1 .. p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object/from16 v2, p0

    .restart local v2    # "this":Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;
    move-object/from16 v5, p1

    .line 363
    .restart local v5    # "$result":Ljava/lang/Object;
    iget-object v6, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    move-object v7, v2

    check-cast v7, Lkotlin/coroutines/Continuation;

    iput v3, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->label:I

    invoke-static {v6, v7}, Lcom/cineflix/android/TelegramEngine;->access$getBotChatId(Lcom/cineflix/android/TelegramEngine;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v6

    if-ne v6, v0, :cond_0

    .line 362
    return-object v0

    .line 363
    :cond_0
    move-object/from16 v22, v6

    move-object v6, v5

    move-object/from16 v5, v22

    .end local v5    # "$result":Ljava/lang/Object;
    .local v6, "$result":Ljava/lang/Object;
    :goto_0
    check-cast v5, Ljava/lang/Long;

    if-eqz v5, :cond_b

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    .line 366
    .local v7, "chatId":J
    invoke-static {v4, v3, v4}, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job;ILjava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;

    move-result-object v5

    .line 367
    .local v5, "anchorDeferred":Lkotlinx/coroutines/CompletableDeferred;
    iget-object v9, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v9}, Lcom/cineflix/android/TelegramEngine;->access$getClient$p(Lcom/cineflix/android/TelegramEngine;)Lorg/drinkless/tdlib/Client;

    move-result-object v15

    if-eqz v15, :cond_1

    new-instance v17, Lorg/drinkless/tdlib/TdApi$GetChatHistory;

    const-wide/16 v12, 0x0

    const/4 v14, 0x0

    const/16 v16, 0x1

    const/16 v18, 0x0

    move-object/from16 v9, v17

    move-wide v10, v7

    move-object v3, v15

    move/from16 v15, v16

    move/from16 v16, v18

    invoke-direct/range {v9 .. v16}, Lorg/drinkless/tdlib/TdApi$GetChatHistory;-><init>(JJIIZ)V

    move-object/from16 v9, v17

    check-cast v9, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v10, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2$$ExternalSyntheticLambda0;

    invoke-direct {v10, v5}, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2$$ExternalSyntheticLambda0;-><init>(Lkotlinx/coroutines/CompletableDeferred;)V

    invoke-virtual {v3, v9, v10}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    .line 372
    :cond_1
    move-object v3, v2

    check-cast v3, Lkotlin/coroutines/Continuation;

    iput-wide v7, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->J$0:J

    const/4 v9, 0x2

    iput v9, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->label:I

    invoke-interface {v5, v3}, Lkotlinx/coroutines/CompletableDeferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v5

    .end local v5    # "anchorDeferred":Lkotlinx/coroutines/CompletableDeferred;
    if-ne v5, v0, :cond_2

    .line 362
    return-object v0

    .line 372
    :cond_2
    move-wide/from16 v17, v7

    .end local v7    # "chatId":J
    .local v17, "chatId":J
    :goto_1
    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->longValue()J

    move-result-wide v20

    .line 375
    .local v20, "anchorMsgId":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "peli_"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v7, v8}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 376
    .local v3, "collectorKey":Ljava/lang/String;
    new-instance v5, Lcom/cineflix/android/TelegramEngine$MsgCollector;

    const/4 v12, 0x0

    const-wide/16 v13, 0x0

    const/16 v15, 0xc

    const/16 v16, 0x0

    move-object v7, v5

    move-wide/from16 v8, v17

    move-wide/from16 v10, v20

    invoke-direct/range {v7 .. v16}, Lcom/cineflix/android/TelegramEngine$MsgCollector;-><init>(JJLjava/util/List;JILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 377
    .end local v20    # "anchorMsgId":J
    .local v5, "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    iget-object v7, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v7}, Lcom/cineflix/android/TelegramEngine;->access$getMsgCollectors$p(Lcom/cineflix/android/TelegramEngine;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v7

    check-cast v7, Ljava/util/Map;

    invoke-interface {v7, v3, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 380
    new-instance v7, Lorg/drinkless/tdlib/TdApi$FormattedText;

    iget-object v8, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->$searchTitle:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "/peli "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    .line 568
    .local v9, "$i$f$emptyArray":I
    const/4 v10, 0x0

    new-array v9, v10, [Lorg/drinkless/tdlib/TdApi$TextEntity;

    .line 380
    .end local v9    # "$i$f$emptyArray":I
    invoke-direct {v7, v8, v9}, Lorg/drinkless/tdlib/TdApi$FormattedText;-><init>(Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$TextEntity;)V

    .line 381
    .local v7, "text":Lorg/drinkless/tdlib/TdApi$FormattedText;
    const/4 v8, 0x1

    invoke-static {v4, v8, v4}, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job;ILjava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;

    move-result-object v15

    .line 382
    .local v15, "sendDeferred":Lkotlinx/coroutines/CompletableDeferred;
    iget-object v8, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v8}, Lcom/cineflix/android/TelegramEngine;->access$getClient$p(Lcom/cineflix/android/TelegramEngine;)Lorg/drinkless/tdlib/Client;

    move-result-object v14

    if-eqz v14, :cond_3

    new-instance v16, Lorg/drinkless/tdlib/TdApi$SendMessage;

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/16 v20, 0x0

    .line 383
    .end local v17    # "chatId":J
    new-instance v8, Lorg/drinkless/tdlib/TdApi$InputMessageText;

    invoke-direct {v8, v7, v4, v10}, Lorg/drinkless/tdlib/TdApi$InputMessageText;-><init>(Lorg/drinkless/tdlib/TdApi$FormattedText;Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;Z)V

    move-object v4, v8

    check-cast v4, Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 382
    .end local v7    # "text":Lorg/drinkless/tdlib/TdApi$FormattedText;
    move-object/from16 v7, v16

    move-wide/from16 v8, v17

    move-object v10, v11

    move-object v11, v12

    move-object v12, v13

    move-object/from16 v13, v20

    move-object v1, v14

    move-object v14, v4

    invoke-direct/range {v7 .. v14}, Lorg/drinkless/tdlib/TdApi$SendMessage;-><init>(JLorg/drinkless/tdlib/TdApi$MessageTopic;Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;Lorg/drinkless/tdlib/TdApi$MessageSendOptions;Lorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V

    move-object/from16 v4, v16

    check-cast v4, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v7, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2$$ExternalSyntheticLambda1;

    invoke-direct {v7, v15}, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2$$ExternalSyntheticLambda1;-><init>(Lkotlinx/coroutines/CompletableDeferred;)V

    invoke-virtual {v1, v4, v7}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    nop

    .line 386
    :cond_3
    move-object v1, v2

    check-cast v1, Lkotlin/coroutines/Continuation;

    iput-object v3, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->L$0:Ljava/lang/Object;

    iput-object v5, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->L$1:Ljava/lang/Object;

    const/4 v4, 0x3

    iput v4, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->label:I

    invoke-interface {v15, v1}, Lkotlinx/coroutines/CompletableDeferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v4

    .end local v15    # "sendDeferred":Lkotlinx/coroutines/CompletableDeferred;
    if-ne v4, v0, :cond_4

    .line 362
    return-object v0

    .line 386
    :cond_4
    :goto_2
    check-cast v4, Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_5

    .line 387
    iget-object v0, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v0}, Lcom/cineflix/android/TelegramEngine;->access$getMsgCollectors$p(Lcom/cineflix/android/TelegramEngine;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 388
    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object v0

    return-object v0

    .line 392
    :cond_5
    move-object v1, v2

    check-cast v1, Lkotlin/coroutines/Continuation;

    iput-object v3, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->L$0:Ljava/lang/Object;

    iput-object v5, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->L$1:Ljava/lang/Object;

    const/4 v4, 0x4

    iput v4, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->label:I

    const-wide/16 v7, 0xfa0

    invoke-static {v7, v8, v1}, Lkotlinx/coroutines/DelayKt;->delay(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v1

    if-ne v1, v0, :cond_6

    .line 362
    return-object v0

    .line 392
    :cond_6
    move-object v4, v6

    move-object v6, v3

    .line 393
    .end local v3    # "collectorKey":Ljava/lang/String;
    .restart local v4    # "$result":Ljava/lang/Object;
    .local v6, "collectorKey":Ljava/lang/String;
    :goto_3
    const-wide/16 v7, 0x5dc

    .line 394
    .local v7, "silenceMs":J
    const-wide/16 v9, 0x1f40

    .line 395
    .local v9, "maxExtra":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v11

    move-wide/from16 v22, v11

    move-object v11, v5

    move-object v12, v6

    move-wide/from16 v5, v22

    move-wide/from16 v24, v7

    move-wide v7, v9

    move-wide/from16 v9, v24

    .line 396
    .end local v6    # "collectorKey":Ljava/lang/String;
    .local v5, "start":J
    .local v7, "maxExtra":J
    .local v9, "silenceMs":J
    .restart local v11    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .restart local v12    # "collectorKey":Ljava/lang/String;
    :cond_7
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v13

    sub-long/2addr v13, v5

    cmp-long v1, v13, v7

    if-gez v1, :cond_a

    .line 397
    move-object v1, v2

    check-cast v1, Lkotlin/coroutines/Continuation;

    iput-object v12, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->L$0:Ljava/lang/Object;

    iput-object v11, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->L$1:Ljava/lang/Object;

    iput-wide v9, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->J$0:J

    iput-wide v7, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->J$1:J

    iput-wide v5, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->J$2:J

    const/4 v3, 0x5

    iput v3, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->label:I

    const-wide/16 v13, 0xc8

    invoke-static {v13, v14, v1}, Lkotlinx/coroutines/DelayKt;->delay(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v1

    if-ne v1, v0, :cond_8

    .line 362
    return-object v0

    .line 398
    :cond_8
    :goto_4
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v13

    invoke-virtual {v11}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getLastReceived()J

    move-result-wide v15

    sub-long/2addr v13, v15

    .line 399
    .local v13, "since":J
    invoke-virtual {v11}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getVideos()Ljava/util/List;

    move-result-object v1

    monitor-enter v1

    .line 569
    const/4 v3, 0x0

    .line 399
    .local v3, "$i$a$-synchronized-TelegramEngine$searchMovieByPayload$2$hasVideos$1":I
    :try_start_0
    invoke-virtual {v11}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getVideos()Ljava/util/List;

    move-result-object v15

    check-cast v15, Ljava/util/Collection;

    invoke-interface {v15}, Ljava/util/Collection;->isEmpty()Z

    move-result v15
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const/16 v16, 0x1

    xor-int/lit8 v15, v15, 0x1

    .end local v3    # "$i$a$-synchronized-TelegramEngine$searchMovieByPayload$2$hasVideos$1":I
    monitor-exit v1

    move v1, v15

    .line 400
    .local v1, "hasVideos":Z
    cmp-long v3, v13, v9

    if-ltz v3, :cond_9

    if-nez v1, :cond_a

    .line 401
    :cond_9
    cmp-long v3, v13, v9

    if-ltz v3, :cond_7

    if-nez v1, :cond_7

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v17

    sub-long v17, v17, v5

    const-wide/16 v19, 0xbb8

    cmp-long v3, v17, v19

    if-lez v3, :cond_7

    goto :goto_5

    .line 399
    .end local v1    # "hasVideos":Z
    .end local v5    # "start":J
    .end local v7    # "maxExtra":J
    .end local v9    # "silenceMs":J
    .end local v11    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .end local v12    # "collectorKey":Ljava/lang/String;
    .end local v13    # "since":J
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    .line 404
    .restart local v11    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .restart local v12    # "collectorKey":Ljava/lang/String;
    :cond_a
    :goto_5
    iget-object v0, v2, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v0}, Lcom/cineflix/android/TelegramEngine;->access$getMsgCollectors$p(Lcom/cineflix/android/TelegramEngine;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v0

    invoke-virtual {v0, v12}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 405
    .end local v12    # "collectorKey":Ljava/lang/String;
    invoke-virtual {v11}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getVideos()Ljava/util/List;

    move-result-object v1

    monitor-enter v1

    .line 569
    const/4 v0, 0x0

    .line 405
    .local v0, "$i$a$-synchronized-TelegramEngine$searchMovieByPayload$2$3":I
    :try_start_1
    invoke-virtual {v11}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getVideos()Ljava/util/List;

    move-result-object v3

    check-cast v3, Ljava/lang/Iterable;

    invoke-static {v3}, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;

    move-result-object v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .end local v0    # "$i$a$-synchronized-TelegramEngine$searchMovieByPayload$2$3":I
    .end local v11    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    monitor-exit v1

    return-object v3

    :catchall_1
    move-exception v0

    monitor-exit v1

    throw v0

    .line 363
    .end local v4    # "$result":Ljava/lang/Object;
    .local v6, "$result":Ljava/lang/Object;
    :cond_b
    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object v0

    return-object v0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
