.class final Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TelegramEngine.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/TelegramEngine;->sendBotCommand(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
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
        "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
        ">;",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nTelegramEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelegramEngine.kt\ncom/cineflix/android/TelegramEngine$sendBotCommand$2\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,567:1\n26#2:568\n*S KotlinDebug\n*F\n+ 1 TelegramEngine.kt\ncom/cineflix/android/TelegramEngine$sendBotCommand$2\n*L\n298#1:568\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"
    }
    d2 = {
        "<anonymous>",
        "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
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
    c = "com.cineflix.android.TelegramEngine$sendBotCommand$2"
    f = "TelegramEngine.kt"
    i = {
        0x1
    }
    l = {
        0x123,
        0x135
    }
    m = "invokeSuspend"
    n = {
        "listenerKey"
    }
    s = {
        "L$0"
    }
.end annotation


# instance fields
.field final synthetic $payload:Ljava/lang/String;

.field L$0:Ljava/lang/Object;

.field label:I

.field final synthetic this$0:Lcom/cineflix/android/TelegramEngine;


# direct methods
.method public static synthetic $r8$lambda$wTAmclgJRY4nOOvKesgzkpjUIfA(Lcom/cineflix/android/TelegramEngine;Ljava/lang/String;Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 0

    invoke-static {p0, p1, p2, p3}, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->invokeSuspend$lambda$0(Lcom/cineflix/android/TelegramEngine;Ljava/lang/String;Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V

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
            "Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    iput-object p2, p0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->$payload:Ljava/lang/String;

    const/4 v0, 0x2

    invoke-direct {p0, v0, p3}, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(ILkotlin/coroutines/Continuation;)V

    return-void
.end method

.method private static final invokeSuspend$lambda$0(Lcom/cineflix/android/TelegramEngine;Ljava/lang/String;Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 1
    .param p0, "this$0"    # Lcom/cineflix/android/TelegramEngine;
    .param p1, "$listenerKey"    # Ljava/lang/String;
    .param p2, "$deferred"    # Lkotlinx/coroutines/CompletableDeferred;
    .param p3, "sendResult"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 302
    instance-of v0, p3, Lorg/drinkless/tdlib/TdApi$Error;

    if-eqz v0, :cond_0

    .line 303
    invoke-static {p0}, Lcom/cineflix/android/TelegramEngine;->access$getInlineKeyboardListeners$p(Lcom/cineflix/android/TelegramEngine;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 304
    const/4 v0, 0x0

    invoke-interface {p2, v0}, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z

    .line 306
    :cond_0
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

    new-instance v0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;

    iget-object v1, p0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    iget-object v2, p0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->$payload:Ljava/lang/String;

    invoke-direct {v0, v1, v2, p2}, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;-><init>(Lcom/cineflix/android/TelegramEngine;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    check-cast v0, Lkotlin/coroutines/Continuation;

    return-object v0
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Lkotlinx/coroutines/CoroutineScope;

    check-cast p2, Lkotlin/coroutines/Continuation;

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

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
            "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object v0

    check-cast v0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;

    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-virtual {v0, v1}, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 18

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 290
    move-object/from16 v1, p0

    iget v2, v1, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->label:I

    const/4 v3, 0x1

    packed-switch v2, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v2, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    move-object/from16 v0, p0

    .local v0, "this":Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;
    move-object/from16 v2, p1

    .local v2, "$result":Ljava/lang/Object;
    iget-object v3, v0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->L$0:Ljava/lang/Object;

    check-cast v3, Ljava/lang/String;

    .local v3, "listenerKey":Ljava/lang/String;
    invoke-static {v2}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v4, v2

    goto/16 :goto_1

    .end local v0    # "this":Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;
    .end local v2    # "$result":Ljava/lang/Object;
    .end local v3    # "listenerKey":Ljava/lang/String;
    :pswitch_1
    move-object/from16 v2, p0

    .local v2, "this":Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;
    move-object/from16 v4, p1

    .local v4, "$result":Ljava/lang/Object;
    invoke-static {v4}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v5, v4

    goto :goto_0

    .end local v2    # "this":Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;
    .end local v4    # "$result":Ljava/lang/Object;
    :pswitch_2
    invoke-static/range {p1 .. p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object/from16 v2, p0

    .restart local v2    # "this":Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;
    move-object/from16 v4, p1

    .line 291
    .restart local v4    # "$result":Ljava/lang/Object;
    iget-object v5, v2, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    move-object v6, v2

    check-cast v6, Lkotlin/coroutines/Continuation;

    iput v3, v2, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->label:I

    invoke-static {v5, v6}, Lcom/cineflix/android/TelegramEngine;->access$getBotChatId(Lcom/cineflix/android/TelegramEngine;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v5

    if-ne v5, v0, :cond_0

    .line 290
    return-object v0

    .line 291
    :cond_0
    :goto_0
    check-cast v5, Ljava/lang/Long;

    const/4 v6, 0x0

    if-eqz v5, :cond_3

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    move-wide v10, v7

    .line 292
    .local v10, "chatId":J
    invoke-static {v6, v3, v6}, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job;ILjava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;

    move-result-object v3

    .line 295
    .local v3, "deferred":Lkotlinx/coroutines/CompletableDeferred;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "kbd_"

    invoke-virtual {v5, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v7, v8}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 296
    .local v5, "listenerKey":Ljava/lang/String;
    iget-object v7, v2, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v7}, Lcom/cineflix/android/TelegramEngine;->access$getInlineKeyboardListeners$p(Lcom/cineflix/android/TelegramEngine;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v7

    check-cast v7, Ljava/util/Map;

    new-instance v8, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;

    invoke-direct {v8, v10, v11, v3}, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;-><init>(JLkotlinx/coroutines/CompletableDeferred;)V

    invoke-interface {v7, v5, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 298
    new-instance v7, Lorg/drinkless/tdlib/TdApi$FormattedText;

    iget-object v8, v2, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->$payload:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "/start "

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    .line 568
    .local v9, "$i$f$emptyArray":I
    const/4 v12, 0x0

    new-array v9, v12, [Lorg/drinkless/tdlib/TdApi$TextEntity;

    .line 298
    .end local v9    # "$i$f$emptyArray":I
    invoke-direct {v7, v8, v9}, Lorg/drinkless/tdlib/TdApi$FormattedText;-><init>(Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$TextEntity;)V

    .line 299
    .local v7, "text":Lorg/drinkless/tdlib/TdApi$FormattedText;
    iget-object v8, v2, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v8}, Lcom/cineflix/android/TelegramEngine;->access$getClient$p(Lcom/cineflix/android/TelegramEngine;)Lorg/drinkless/tdlib/Client;

    move-result-object v8

    if-eqz v8, :cond_1

    new-instance v17, Lorg/drinkless/tdlib/TdApi$SendMessage;

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    .line 300
    .end local v10    # "chatId":J
    new-instance v9, Lorg/drinkless/tdlib/TdApi$InputMessageText;

    invoke-direct {v9, v7, v6, v12}, Lorg/drinkless/tdlib/TdApi$InputMessageText;-><init>(Lorg/drinkless/tdlib/TdApi$FormattedText;Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;Z)V

    move-object v7, v9

    check-cast v7, Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 299
    .end local v7    # "text":Lorg/drinkless/tdlib/TdApi$FormattedText;
    move-object/from16 v9, v17

    move-object v12, v13

    move-object v13, v14

    move-object v14, v15

    move-object/from16 v15, v16

    move-object/from16 v16, v7

    invoke-direct/range {v9 .. v16}, Lorg/drinkless/tdlib/TdApi$SendMessage;-><init>(JLorg/drinkless/tdlib/TdApi$MessageTopic;Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;Lorg/drinkless/tdlib/TdApi$MessageSendOptions;Lorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V

    move-object/from16 v7, v17

    check-cast v7, Lorg/drinkless/tdlib/TdApi$Function;

    iget-object v9, v2, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    new-instance v10, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2$$ExternalSyntheticLambda0;

    invoke-direct {v10, v9, v5, v3}, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2$$ExternalSyntheticLambda0;-><init>(Lcom/cineflix/android/TelegramEngine;Ljava/lang/String;Lkotlinx/coroutines/CompletableDeferred;)V

    invoke-virtual {v8, v7, v10}, Lorg/drinkless/tdlib/Client;->send(Lorg/drinkless/tdlib/TdApi$Function;Lorg/drinkless/tdlib/Client$ResultHandler;)V

    nop

    .line 309
    :cond_1
    new-instance v7, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2$result$1;

    invoke-direct {v7, v3, v6}, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2$result$1;-><init>(Lkotlinx/coroutines/CompletableDeferred;Lkotlin/coroutines/Continuation;)V

    check-cast v7, Lkotlin/jvm/functions/Function2;

    move-object v6, v2

    check-cast v6, Lkotlin/coroutines/Continuation;

    iput-object v5, v2, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->L$0:Ljava/lang/Object;

    const/4 v8, 0x2

    iput v8, v2, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->label:I

    const-wide/16 v8, 0x3a98

    invoke-static {v8, v9, v7, v6}, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v3

    .end local v3    # "deferred":Lkotlinx/coroutines/CompletableDeferred;
    if-ne v3, v0, :cond_2

    .line 290
    return-object v0

    .line 309
    :cond_2
    move-object v0, v2

    move-object v2, v3

    move-object v3, v5

    .line 290
    .end local v2    # "this":Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;
    .end local v5    # "listenerKey":Ljava/lang/String;
    .restart local v0    # "this":Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;
    .local v3, "listenerKey":Ljava/lang/String;
    :goto_1
    check-cast v2, Lcom/cineflix/android/TelegramEngine$SeasonResponse;

    .line 310
    .local v2, "result":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    iget-object v5, v0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->this$0:Lcom/cineflix/android/TelegramEngine;

    invoke-static {v5}, Lcom/cineflix/android/TelegramEngine;->access$getInlineKeyboardListeners$p(Lcom/cineflix/android/TelegramEngine;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 311
    return-object v2

    .line 291
    .end local v0    # "this":Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;
    .end local v3    # "listenerKey":Ljava/lang/String;
    .local v2, "this":Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;
    :cond_3
    return-object v6

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
