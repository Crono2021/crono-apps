.class final Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TelegramEngine.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/TelegramEngine;->clickInlineButton(JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
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
    value = "SMAP\nTelegramEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelegramEngine.kt\ncom/cineflix/android/TelegramEngine$clickInlineButton$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,567:1\n1#2:568\n*E\n"
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
    c = "com.cineflix.android.TelegramEngine$clickInlineButton$2"
    f = "TelegramEngine.kt"
    i = {
        0x0,
        0x0,
        0x1,
        0x1,
        0x1,
        0x1,
        0x1
    }
    l = {
        0x155,
        0x15c
    }
    m = "invokeSuspend"
    n = {
        "collectorKey",
        "collector",
        "collectorKey",
        "collector",
        "silenceMs",
        "maxWait",
        "start"
    }
    s = {
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
.field final synthetic $chatId:J

.field final synthetic $dataBase64:Ljava/lang/String;

.field final synthetic $msgId:J

.field J$0:J

.field J$1:J

.field J$2:J

.field L$0:Ljava/lang/Object;

.field L$1:Ljava/lang/Object;

.field label:I

.field final synthetic this$0:Lcom/cineflix/android/TelegramEngine;


# direct methods
.method public static synthetic $r8$lambda$pQyJWDSST0uPHhjAmytUvTqIOc0(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->invokeSuspend$lambda$0(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method

.method constructor <init>(Ljava/lang/String;JJLcom/cineflix/android/TelegramEngine;Lkotlin/coroutines/Continuation;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "JJ",
            "Lcom/cineflix/android/TelegramEngine;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->$dataBase64:Ljava/lang/String;

    iput-wide p2, p0, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->$chatId:J

    iput-wide p4, p0, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->$msgId:J

    iput-object p6, p0, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    const/4 v0, 0x2

    invoke-direct {p0, v0, p7}, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(ILkotlin/coroutines/Continuation;)V

    return-void
.end method

.method private static final invokeSuspend$lambda$0(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 5
    .param p0, "$callbackDeferred"    # Lkotlinx/coroutines/CompletableDeferred;
    .param p1, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 332
    instance-of v0, p1, Lorg/drinkless/tdlib/TdApi$Error;

    const-string v1, "TelegramEngine"

    if-eqz v0, :cond_0

    .line 333
    move-object v0, p1

    check-cast v0, Lorg/drinkless/tdlib/TdApi$Error;

    iget v0, v0, Lorg/drinkless/tdlib/TdApi$Error;->code:I

    move-object v2, p1

    check-cast v2, Lorg/drinkless/tdlib/TdApi$Error;

    iget-object v2, v2, Lorg/drinkless/tdlib/TdApi$Error;->message:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "GetCallbackQueryAnswer error ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "): "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " \u2014 still waiting for bot messages"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 335
    :cond_0
    const-string v0, "GetCallbackQueryAnswer OK"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 337
    :goto_0
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-interface {p0, v0}, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z

    .line 338
    return-void
.end method


# virtual methods
.method public final create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    .locals 9
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

    new-instance v8, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;

    iget-object v1, p0, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->$dataBase64:Ljava/lang/String;

    iget-wide v2, p0, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->$chatId:J

    iget-wide v4, p0, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->$msgId:J

    iget-object v6, p0, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    move-object v0, v8

    move-object v7, p2

    invoke-direct/range {v0 .. v7}, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;-><init>(Ljava/lang/String;JJLcom/cineflix/android/TelegramEngine;Lkotlin/coroutines/Continuation;)V

    check-cast v8, Lkotlin/coroutines/Continuation;

    return-object v8
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Lkotlinx/coroutines/CoroutineScope;

    check-cast p2, Lkotlin/coroutines/Continuation;

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

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

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object v0

    check-cast v0, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;

    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-virtual {v0, v1}, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 22

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 320
    move-object/from16 v1, p0

    iget v2, v1, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->label:I

    const/4 v3, 0x1

    packed-switch v2, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v2, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    move-object/from16 v2, p0

    .local v2, "this":Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;
    move-object/from16 v4, p1

    .local v4, "$result":Ljava/lang/Object;
    iget-wide v5, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->J$2:J

    .local v5, "start":J
    iget-wide v7, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->J$1:J

    .local v7, "maxWait":J
    iget-wide v9, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->J$0:J

    .local v9, "silenceMs":J
    iget-object v11, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->L$1:Ljava/lang/Object;

    check-cast v11, Lcom/cineflix/android/TelegramEngine$MsgCollector;

    .local v11, "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    iget-object v12, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->L$0:Ljava/lang/Object;

    check-cast v12, Ljava/lang/String;

    .local v12, "collectorKey":Ljava/lang/String;
    invoke-static {v4}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    goto/16 :goto_1

    .end local v2    # "this":Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;
    .end local v4    # "$result":Ljava/lang/Object;
    .end local v5    # "start":J
    .end local v7    # "maxWait":J
    .end local v9    # "silenceMs":J
    .end local v11    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .end local v12    # "collectorKey":Ljava/lang/String;
    :pswitch_1
    move-object/from16 v2, p0

    .restart local v2    # "this":Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;
    move-object/from16 v4, p1

    .restart local v4    # "$result":Ljava/lang/Object;
    iget-object v5, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->L$1:Ljava/lang/Object;

    check-cast v5, Lcom/cineflix/android/TelegramEngine$MsgCollector;

    .local v5, "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    iget-object v6, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->L$0:Ljava/lang/Object;

    check-cast v6, Ljava/lang/String;

    .local v6, "collectorKey":Ljava/lang/String;
    invoke-static {v4}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    goto/16 :goto_0

    .end local v2    # "this":Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;
    .end local v4    # "$result":Ljava/lang/Object;
    .end local v5    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .end local v6    # "collectorKey":Ljava/lang/String;
    :pswitch_2
    invoke-static/range {p1 .. p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object/from16 v2, p0

    .restart local v2    # "this":Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;
    move-object/from16 v4, p1

    .line 321
    .restart local v4    # "$result":Ljava/lang/Object;
    iget-object v5, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->$dataBase64:Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {v5, v6}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v5

    .line 322
    .local v5, "dataBytes":[B
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "click_"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 323
    .restart local v6    # "collectorKey":Ljava/lang/String;
    new-instance v17, Lcom/cineflix/android/TelegramEngine$MsgCollector;

    iget-wide v8, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->$chatId:J

    iget-wide v10, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->$msgId:J

    const/4 v12, 0x0

    const-wide/16 v13, 0x0

    const/16 v15, 0xc

    const/16 v16, 0x0

    move-object/from16 v7, v17

    invoke-direct/range {v7 .. v16}, Lcom/cineflix/android/TelegramEngine$MsgCollector;-><init>(JJLjava/util/List;JILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 324
    .local v7, "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    iget-object v8, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v8}, Lcom/cineflix/android/TelegramEngine;->access$getMsgCollectors$p(Lcom/cineflix/android/TelegramEngine;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v8

    check-cast v8, Ljava/util/Map;

    invoke-interface {v8, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 328
    const/4 v8, 0x0

    invoke-static {v8, v3, v8}, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job;ILjava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;

    move-result-object v9

    .line 329
    .local v9, "callbackDeferred":Lkotlinx/coroutines/CompletableDeferred;
    iget-object v10, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v10}, Lcom/cineflix/android/TelegramEngine;->access$getClient$p(Lcom/cineflix/android/TelegramEngine;)Lorg/drinkless/tdlib/Client;

    move-result-object v10

    if-eqz v10, :cond_0

    new-instance v17, Lorg/drinkless/tdlib/TdApi$GetCallbackQueryAnswer;

    .line 330
    iget-wide v12, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->$chatId:J

    iget-wide v14, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->$msgId:J

    new-instance v11, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayloadData;

    invoke-direct {v11, v5}, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayloadData;-><init>([B)V

    move-object/from16 v16, v11

    check-cast v16, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;

    .line 329
    .end local v5    # "dataBytes":[B
    move-object/from16 v11, v17

    invoke-direct/range {v11 .. v16}, Lorg/drinkless/tdlib/TdApi$GetCallbackQueryAnswer;-><init>(JJLorg/drinkless/tdlib/TdApi$CallbackQueryPayload;)V

    move-object/from16 v5, v17

    check-cast v5, Lorg/drinkless/tdlib/TdApi$Function;

    new-instance v11, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2$$ExternalSyntheticLambda0;

    invoke-direct {v11, v9}, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2$$ExternalSyntheticLambda0;-><init>(Lkotlinx/coroutines/CompletableDeferred;)V

    invoke-virtual {v10, v5, v11}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    nop

    .line 341
    :cond_0
    new-instance v5, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2$2;

    invoke-direct {v5, v9, v8}, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2$2;-><init>(Lkotlinx/coroutines/CompletableDeferred;Lkotlin/coroutines/Continuation;)V

    check-cast v5, Lkotlin/jvm/functions/Function2;

    move-object v8, v2

    check-cast v8, Lkotlin/coroutines/Continuation;

    iput-object v6, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->L$0:Ljava/lang/Object;

    iput-object v7, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->L$1:Ljava/lang/Object;

    iput v3, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->label:I

    const-wide/16 v10, 0x1f40

    invoke-static {v10, v11, v5, v8}, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v5

    .end local v9    # "callbackDeferred":Lkotlinx/coroutines/CompletableDeferred;
    if-ne v5, v0, :cond_1

    .line 320
    return-object v0

    .line 341
    :cond_1
    move-object v5, v7

    .line 344
    .end local v7    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .local v5, "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    :goto_0
    const-wide/16 v7, 0x5dc

    .line 345
    .local v7, "silenceMs":J
    const-wide/16 v9, 0x2ee0

    .line 346
    .local v9, "maxWait":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v11

    move-wide/from16 v18, v11

    move-object v11, v5

    move-object v12, v6

    move-wide/from16 v5, v18

    move-wide/from16 v20, v7

    move-wide v7, v9

    move-wide/from16 v9, v20

    .line 347
    .end local v6    # "collectorKey":Ljava/lang/String;
    .local v5, "start":J
    .local v7, "maxWait":J
    .local v9, "silenceMs":J
    .restart local v11    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .restart local v12    # "collectorKey":Ljava/lang/String;
    :cond_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v13

    sub-long/2addr v13, v5

    cmp-long v13, v13, v7

    if-gez v13, :cond_4

    .line 348
    move-object v13, v2

    check-cast v13, Lkotlin/coroutines/Continuation;

    iput-object v12, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->L$0:Ljava/lang/Object;

    iput-object v11, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->L$1:Ljava/lang/Object;

    iput-wide v9, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->J$0:J

    iput-wide v7, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->J$1:J

    iput-wide v5, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->J$2:J

    const/4 v14, 0x2

    iput v14, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->label:I

    const-wide/16 v14, 0xc8

    invoke-static {v14, v15, v13}, Lkotlinx/coroutines/DelayKt;->delay(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v13

    if-ne v13, v0, :cond_3

    .line 320
    return-object v0

    .line 349
    :cond_3
    :goto_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v13

    invoke-virtual {v11}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getLastReceived()J

    move-result-wide v15

    sub-long/2addr v13, v15

    .line 350
    .local v13, "since":J
    invoke-virtual {v11}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getVideos()Ljava/util/List;

    move-result-object v15

    monitor-enter v15

    .line 568
    const/16 v16, 0x0

    .line 350
    .local v16, "$i$a$-synchronized-TelegramEngine$clickInlineButton$2$hasVideos$1":I
    :try_start_0
    invoke-virtual {v11}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getVideos()Ljava/util/List;

    move-result-object v17

    check-cast v17, Ljava/util/Collection;

    invoke-interface/range {v17 .. v17}, Ljava/util/Collection;->isEmpty()Z

    move-result v17
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    xor-int/lit8 v17, v17, 0x1

    .end local v16    # "$i$a$-synchronized-TelegramEngine$clickInlineButton$2$hasVideos$1":I
    monitor-exit v15

    move/from16 v15, v17

    .line 351
    .local v15, "hasVideos":Z
    cmp-long v16, v13, v9

    if-ltz v16, :cond_2

    if-eqz v15, :cond_2

    goto :goto_2

    .line 350
    .end local v5    # "start":J
    .end local v7    # "maxWait":J
    .end local v9    # "silenceMs":J
    .end local v11    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .end local v12    # "collectorKey":Ljava/lang/String;
    .end local v13    # "since":J
    .end local v15    # "hasVideos":Z
    :catchall_0
    move-exception v0

    monitor-exit v15

    throw v0

    .line 353
    .restart local v11    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .restart local v12    # "collectorKey":Ljava/lang/String;
    :cond_4
    :goto_2
    iget-object v0, v2, Lcom/cineflix/android/TelegramEngine$clickInlineButton$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v0}, Lcom/cineflix/android/TelegramEngine;->access$getMsgCollectors$p(Lcom/cineflix/android/TelegramEngine;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v0

    invoke-virtual {v0, v12}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 354
    .end local v12    # "collectorKey":Ljava/lang/String;
    invoke-virtual {v11}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getVideos()Ljava/util/List;

    move-result-object v3

    monitor-enter v3

    .line 568
    const/4 v0, 0x0

    .line 354
    .local v0, "$i$a$-synchronized-TelegramEngine$clickInlineButton$2$3":I
    :try_start_1
    invoke-virtual {v11}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->getVideos()Ljava/util/List;

    move-result-object v5

    check-cast v5, Ljava/lang/Iterable;

    invoke-static {v5}, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;

    move-result-object v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .end local v0    # "$i$a$-synchronized-TelegramEngine$clickInlineButton$2$3":I
    .end local v11    # "collector":Lcom/cineflix/android/TelegramEngine$MsgCollector;
    monitor-exit v3

    return-object v5

    :catchall_1
    move-exception v0

    monitor-exit v3

    throw v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
