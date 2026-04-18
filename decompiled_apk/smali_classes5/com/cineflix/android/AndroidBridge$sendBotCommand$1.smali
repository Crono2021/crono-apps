.class final Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "AndroidBridge.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/AndroidBridge;->sendBotCommand(Ljava/lang/String;Ljava/lang/String;)V
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
        "Lkotlin/Unit;",
        ">;",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"
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
    c = "com.cineflix.android.AndroidBridge$sendBotCommand$1"
    f = "AndroidBridge.kt"
    i = {}
    l = {
        0x89
    }
    m = "invokeSuspend"
    n = {}
    s = {}
.end annotation


# instance fields
.field final synthetic $payload:Ljava/lang/String;

.field final synthetic $queryId:Ljava/lang/String;

.field label:I

.field final synthetic this$0:Lcom/cineflix/android/AndroidBridge;


# direct methods
.method constructor <init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/cineflix/android/AndroidBridge;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iput-object p2, p0, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->$payload:Ljava/lang/String;

    iput-object p3, p0, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->$queryId:Ljava/lang/String;

    const/4 v0, 0x2

    invoke-direct {p0, v0, p4}, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(ILkotlin/coroutines/Continuation;)V

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

    new-instance v0, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;

    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v2, p0, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->$payload:Ljava/lang/String;

    iget-object v3, p0, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->$queryId:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, p2}, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    check-cast v0, Lkotlin/coroutines/Continuation;

    return-object v0
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Lkotlinx/coroutines/CoroutineScope;

    check-cast p2, Lkotlin/coroutines/Continuation;

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

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
            "Lkotlin/Unit;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object v0

    check-cast v0, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;

    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-virtual {v0, v1}, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 17

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 135
    move-object/from16 v1, p0

    iget v2, v1, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->label:I

    const/4 v3, 0x1

    const/4 v4, 0x0

    packed-switch v2, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v2, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    move-object/from16 v2, p0

    .local v2, "this":Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;
    move-object/from16 v5, p1

    .local v5, "$result":Ljava/lang/Object;
    :try_start_0
    invoke-static {v5}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v6, v5

    goto :goto_0

    .line 159
    :catch_0
    move-exception v0

    goto/16 :goto_2

    .line 135
    .end local v2    # "this":Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;
    .end local v5    # "$result":Ljava/lang/Object;
    :pswitch_1
    invoke-static/range {p1 .. p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object/from16 v2, p0

    .restart local v2    # "this":Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;
    move-object/from16 v5, p1

    .line 136
    .restart local v5    # "$result":Ljava/lang/Object;
    nop

    .line 137
    :try_start_1
    iget-object v6, v2, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    invoke-static {v6}, Lcom/cineflix/android/AndroidBridge;->access$getEngine$p(Lcom/cineflix/android/AndroidBridge;)Lcom/cineflix/android/TelegramEngine;

    move-result-object v6

    iget-object v7, v2, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->$payload:Ljava/lang/String;

    move-object v8, v2

    check-cast v8, Lkotlin/coroutines/Continuation;

    iput v3, v2, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->label:I

    invoke-virtual {v6, v7, v8}, Lcom/cineflix/android/TelegramEngine;->sendBotCommand(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v6
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    if-ne v6, v0, :cond_0

    .line 135
    return-object v0

    .line 137
    :cond_0
    move-object/from16 v16, v6

    move-object v6, v5

    move-object/from16 v5, v16

    .line 135
    .end local v5    # "$result":Ljava/lang/Object;
    .local v6, "$result":Ljava/lang/Object;
    :goto_0
    :try_start_2
    check-cast v5, Lcom/cineflix/android/TelegramEngine$SeasonResponse;

    move-object v0, v5

    .line 138
    .local v0, "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    if-nez v0, :cond_1

    .line 139
    .end local v0    # "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    iget-object v0, v2, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v3, v2, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->$queryId:Ljava/lang/String;

    const-string v5, "Bot no respondi\u00f3"

    invoke-static {v0, v3, v4, v5}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V

    .line 140
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0

    .line 143
    .restart local v0    # "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    :cond_1
    iget-object v5, v2, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    invoke-static {v5, v0}, Lcom/cineflix/android/AndroidBridge;->access$setLastBotResponse$p(Lcom/cineflix/android/AndroidBridge;Lcom/cineflix/android/TelegramEngine$SeasonResponse;)V

    .line 144
    new-instance v5, Lorg/json/JSONArray;

    invoke-direct {v5}, Lorg/json/JSONArray;-><init>()V

    .line 145
    .local v5, "buttons":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->getButtons()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    move v8, v4

    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v9
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    const-string v10, "text"

    if-eqz v9, :cond_2

    move v9, v8

    .local v9, "index":I
    add-int/2addr v8, v3

    :try_start_3
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/cineflix/android/TelegramEngine$SeasonButton;

    .line 146
    .local v11, "btn":Lcom/cineflix/android/TelegramEngine$SeasonButton;
    new-instance v12, Lorg/json/JSONObject;

    invoke-direct {v12}, Lorg/json/JSONObject;-><init>()V

    move-object v13, v12

    .local v13, "$this$invokeSuspend_u24lambda_u240":Lorg/json/JSONObject;
    const/4 v14, 0x0

    .line 147
    .local v14, "$i$a$-apply-AndroidBridge$sendBotCommand$1$1":I
    invoke-virtual {v11}, Lcom/cineflix/android/TelegramEngine$SeasonButton;->getText()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v13, v10, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 148
    const-string v10, "data"

    invoke-static {v9}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v13, v10, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 149
    const-string v10, "msgId"

    invoke-virtual {v0}, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->getMessageId()J

    move-result-wide v3

    invoke-virtual {v13, v10, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 150
    nop

    .line 146
    .end local v13    # "$this$invokeSuspend_u24lambda_u240":Lorg/json/JSONObject;
    .end local v14    # "$i$a$-apply-AndroidBridge$sendBotCommand$1$1":I
    invoke-virtual {v5, v12}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    const/4 v3, 0x1

    const/4 v4, 0x0

    goto :goto_1

    .line 152
    .end local v9    # "index":I
    .end local v11    # "btn":Lcom/cineflix/android/TelegramEngine$SeasonButton;
    :cond_2
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    move-object v4, v3

    .local v4, "$this$invokeSuspend_u24lambda_u241":Lorg/json/JSONObject;
    const/4 v7, 0x0

    .line 153
    .local v7, "$i$a$-apply-AndroidBridge$sendBotCommand$1$result$1":I
    const-string v8, "messageId"

    invoke-virtual {v0}, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->getMessageId()J

    move-result-wide v11

    invoke-virtual {v4, v8, v11, v12}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 154
    const-string v8, "chatId"

    invoke-virtual {v0}, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->getChatId()J

    move-result-wide v11

    invoke-virtual {v4, v8, v11, v12}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 155
    const-string v8, "buttons"

    invoke-virtual {v4, v8, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 156
    invoke-virtual {v0}, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->getText()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v10, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 157
    nop

    .line 152
    .end local v4    # "$this$invokeSuspend_u24lambda_u241":Lorg/json/JSONObject;
    .end local v7    # "$i$a$-apply-AndroidBridge$sendBotCommand$1$result$1":I
    nop

    .line 158
    .local v3, "result":Lorg/json/JSONObject;
    iget-object v4, v2, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v7, v2, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->$queryId:Ljava/lang/String;

    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v8

    const-string v9, "toString(...)"

    invoke-static {v8, v9}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v9, 0x1

    invoke-static {v4, v7, v9, v8}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    .end local v0    # "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    .end local v3    # "result":Lorg/json/JSONObject;
    .end local v5    # "buttons":Lorg/json/JSONArray;
    goto :goto_3

    .line 159
    :catch_1
    move-exception v0

    move-object v5, v6

    .line 160
    .end local v6    # "$result":Ljava/lang/Object;
    .local v0, "e":Ljava/lang/Exception;
    .local v5, "$result":Ljava/lang/Object;
    :goto_2
    iget-object v3, v2, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v4, v2, Lcom/cineflix/android/AndroidBridge$sendBotCommand$1;->$queryId:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    .end local v0    # "e":Ljava/lang/Exception;
    if-nez v0, :cond_3

    const-string v0, "Error desconocido"

    :cond_3
    const/4 v6, 0x0

    invoke-static {v3, v4, v6, v0}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V

    move-object v6, v5

    .line 162
    .end local v5    # "$result":Ljava/lang/Object;
    .restart local v6    # "$result":Ljava/lang/Object;
    :goto_3
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
