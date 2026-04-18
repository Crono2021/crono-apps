.class final Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "AndroidBridge.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/AndroidBridge;->clickInlineButton(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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
    c = "com.cineflix.android.AndroidBridge$clickInlineButton$1"
    f = "AndroidBridge.kt"
    i = {
        0x0,
        0x0,
        0x0,
        0x1
    }
    l = {
        0xbc,
        0xc1
    }
    m = "invokeSuspend"
    n = {
        "$this$launch",
        "response",
        "button",
        "chatId"
    }
    s = {
        "L$0",
        "L$1",
        "L$2",
        "J$0"
    }
.end annotation


# instance fields
.field final synthetic $buttonIndex:Ljava/lang/String;

.field final synthetic $queryId:Ljava/lang/String;

.field J$0:J

.field private synthetic L$0:Ljava/lang/Object;

.field L$1:Ljava/lang/Object;

.field L$2:Ljava/lang/Object;

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
            "Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iput-object p2, p0, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->$buttonIndex:Ljava/lang/String;

    iput-object p3, p0, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->$queryId:Ljava/lang/String;

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

    new-instance v0, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;

    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v2, p0, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->$buttonIndex:Ljava/lang/String;

    iget-object v3, p0, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->$queryId:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, p2}, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    iput-object p1, v0, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->L$0:Ljava/lang/Object;

    check-cast v0, Lkotlin/coroutines/Continuation;

    return-object v0
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Lkotlinx/coroutines/CoroutineScope;

    check-cast p2, Lkotlin/coroutines/Continuation;

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

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

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object v0

    check-cast v0, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;

    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-virtual {v0, v1}, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 20

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 174
    move-object/from16 v1, p0

    iget v2, v1, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->label:I

    const/4 v3, 0x1

    const/4 v4, 0x0

    packed-switch v2, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v2, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    move-object/from16 v2, p0

    .local v2, "this":Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;
    move-object/from16 v5, p1

    .local v5, "$result":Ljava/lang/Object;
    iget-wide v6, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->J$0:J

    .local v6, "chatId":J
    :try_start_0
    invoke-static {v5}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-wide v9, v6

    move-object v6, v5

    goto/16 :goto_1

    .end local v2    # "this":Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;
    .end local v5    # "$result":Ljava/lang/Object;
    .end local v6    # "chatId":J
    :pswitch_1
    move-object/from16 v2, p0

    .restart local v2    # "this":Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;
    move-object/from16 v5, p1

    .restart local v5    # "$result":Ljava/lang/Object;
    iget-object v6, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->L$2:Ljava/lang/Object;

    check-cast v6, Lcom/cineflix/android/TelegramEngine$SeasonButton;

    .local v6, "button":Lcom/cineflix/android/TelegramEngine$SeasonButton;
    iget-object v7, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->L$1:Ljava/lang/Object;

    check-cast v7, Lcom/cineflix/android/TelegramEngine$SeasonResponse;

    .local v7, "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    iget-object v8, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->L$0:Ljava/lang/Object;

    check-cast v8, Lkotlinx/coroutines/CoroutineScope;

    .local v8, "$this$launch":Lkotlinx/coroutines/CoroutineScope;
    :try_start_1
    invoke-static {v5}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-object v9, v8

    move-object v8, v7

    move-object v7, v6

    move-object v6, v5

    goto/16 :goto_0

    .end local v2    # "this":Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;
    .end local v5    # "$result":Ljava/lang/Object;
    .end local v6    # "button":Lcom/cineflix/android/TelegramEngine$SeasonButton;
    .end local v7    # "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    .end local v8    # "$this$launch":Lkotlinx/coroutines/CoroutineScope;
    :pswitch_2
    invoke-static/range {p1 .. p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object/from16 v2, p0

    .restart local v2    # "this":Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;
    move-object/from16 v5, p1

    .restart local v5    # "$result":Ljava/lang/Object;
    iget-object v6, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->L$0:Ljava/lang/Object;

    move-object v8, v6

    check-cast v8, Lkotlinx/coroutines/CoroutineScope;

    .line 175
    .restart local v8    # "$this$launch":Lkotlinx/coroutines/CoroutineScope;
    nop

    .line 176
    :try_start_2
    iget-object v6, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    invoke-static {v6}, Lcom/cineflix/android/AndroidBridge;->access$getLastBotResponse$p(Lcom/cineflix/android/AndroidBridge;)Lcom/cineflix/android/TelegramEngine$SeasonResponse;

    move-result-object v6

    if-nez v6, :cond_0

    iget-object v0, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v3, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->$queryId:Ljava/lang/String;

    const/4 v6, 0x0

    .line 177
    .local v6, "$i$a$-run-AndroidBridge$clickInlineButton$1$response$1":I
    const-string v7, "No hay respuesta del bot en memoria \u2014 reinicia la b\u00fasqueda"

    invoke-static {v0, v3, v4, v7}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V

    .line 178
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0

    .end local v6    # "$i$a$-run-AndroidBridge$clickInlineButton$1$response$1":I
    :cond_0
    move-object v7, v6

    .line 180
    .restart local v7    # "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    iget-object v6, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->$buttonIndex:Ljava/lang/String;

    invoke-static {v6}, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v6

    if-eqz v6, :cond_5

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    .line 182
    nop

    .line 184
    .local v6, "idx":I
    invoke-virtual {v7}, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->getButtons()Ljava/util/List;

    move-result-object v9

    invoke-static {v9, v6}, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List;I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/cineflix/android/TelegramEngine$SeasonButton;

    if-nez v9, :cond_1

    iget-object v0, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v3, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->$queryId:Ljava/lang/String;

    const/4 v9, 0x0

    .line 185
    .local v9, "$i$a$-run-AndroidBridge$clickInlineButton$1$button$1":I
    invoke-virtual {v7}, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->getButtons()Ljava/util/List;

    move-result-object v10

    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v10

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Bot\u00f3n "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " no encontrado (total: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ")"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v0, v3, v4, v10}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V

    .line 186
    .end local v6    # "idx":I
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0

    .end local v9    # "$i$a$-run-AndroidBridge$clickInlineButton$1$button$1":I
    :cond_1
    move-object v6, v9

    .line 188
    .local v6, "button":Lcom/cineflix/android/TelegramEngine$SeasonButton;
    iget-object v9, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    invoke-static {v9}, Lcom/cineflix/android/AndroidBridge;->access$getEngine$p(Lcom/cineflix/android/AndroidBridge;)Lcom/cineflix/android/TelegramEngine;

    move-result-object v9

    move-object v10, v2

    check-cast v10, Lkotlin/coroutines/Continuation;

    iput-object v8, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->L$0:Ljava/lang/Object;

    iput-object v7, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->L$1:Ljava/lang/Object;

    iput-object v6, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->L$2:Ljava/lang/Object;

    iput v3, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->label:I

    invoke-virtual {v9, v10}, Lcom/cineflix/android/TelegramEngine;->getBotChatIdPublic(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v9
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    if-ne v9, v0, :cond_2

    .line 174
    return-object v0

    .line 188
    :cond_2
    move-object/from16 v19, v6

    move-object v6, v5

    move-object v5, v9

    move-object v9, v8

    move-object v8, v7

    move-object/from16 v7, v19

    .end local v5    # "$result":Ljava/lang/Object;
    .local v6, "$result":Ljava/lang/Object;
    .local v7, "button":Lcom/cineflix/android/TelegramEngine$SeasonButton;
    .local v8, "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    .local v9, "$this$launch":Lkotlinx/coroutines/CoroutineScope;
    :goto_0
    :try_start_3
    check-cast v5, Ljava/lang/Long;

    if-eqz v5, :cond_4

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    .line 190
    .end local v9    # "$this$launch":Lkotlinx/coroutines/CoroutineScope;
    move-wide v9, v10

    .line 193
    .local v9, "chatId":J
    iget-object v5, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    invoke-static {v5}, Lcom/cineflix/android/AndroidBridge;->access$getEngine$p(Lcom/cineflix/android/AndroidBridge;)Lcom/cineflix/android/TelegramEngine;

    move-result-object v12

    invoke-virtual {v8}, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->getMessageId()J

    move-result-wide v15

    invoke-virtual {v7}, Lcom/cineflix/android/TelegramEngine$SeasonButton;->getDataBase64()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v18, v2

    check-cast v18, Lkotlin/coroutines/Continuation;

    const/4 v5, 0x0

    iput-object v5, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->L$0:Ljava/lang/Object;

    iput-object v5, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->L$1:Ljava/lang/Object;

    iput-object v5, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->L$2:Ljava/lang/Object;

    iput-wide v9, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->J$0:J

    const/4 v5, 0x2

    iput v5, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->label:I

    move-wide v13, v9

    invoke-virtual/range {v12 .. v18}, Lcom/cineflix/android/TelegramEngine;->clickInlineButton(JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v5

    .end local v7    # "button":Lcom/cineflix/android/TelegramEngine$SeasonButton;
    .end local v8    # "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    if-ne v5, v0, :cond_3

    .line 174
    return-object v0

    :cond_3
    :goto_1
    check-cast v5, Ljava/util/List;

    move-object v0, v5

    .line 194
    .local v0, "videos":Ljava/util/List;
    iget-object v5, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v7, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->$queryId:Ljava/lang/String;

    invoke-static {v5, v0, v9, v10}, Lcom/cineflix/android/AndroidBridge;->access$videosToJson(Lcom/cineflix/android/AndroidBridge;Ljava/util/List;J)Ljava/lang/String;

    move-result-object v8

    invoke-static {v5, v7, v3, v8}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V

    .end local v0    # "videos":Ljava/util/List;
    .end local v9    # "chatId":J
    goto :goto_3

    .line 188
    .local v9, "$this$launch":Lkotlinx/coroutines/CoroutineScope;
    :cond_4
    iget-object v0, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v3, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->$queryId:Ljava/lang/String;

    .end local v9    # "$this$launch":Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0x0

    .line 189
    .local v5, "$i$a$-run-AndroidBridge$clickInlineButton$1$chatId$1":I
    const-string v7, "No se pudo obtener chatId del bot"

    invoke-static {v0, v3, v4, v7}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V

    .line 190
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    return-object v0

    .line 195
    .end local v5    # "$i$a$-run-AndroidBridge$clickInlineButton$1$chatId$1":I
    :catch_0
    move-exception v0

    move-object v5, v6

    goto :goto_2

    .line 180
    .end local v6    # "$result":Ljava/lang/Object;
    .local v5, "$result":Ljava/lang/Object;
    .local v7, "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    .local v8, "$this$launch":Lkotlinx/coroutines/CoroutineScope;
    :cond_5
    :try_start_4
    iget-object v0, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v3, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->$queryId:Ljava/lang/String;

    iget-object v6, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->$buttonIndex:Ljava/lang/String;

    const/4 v9, 0x0

    .line 181
    .local v9, "$i$a$-run-AndroidBridge$clickInlineButton$1$idx$1":I
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "\u00cdndice de bot\u00f3n inv\u00e1lido: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v0, v3, v4, v6}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V

    .line 182
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    return-object v0

    .line 195
    .end local v7    # "response":Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    .end local v8    # "$this$launch":Lkotlinx/coroutines/CoroutineScope;
    .end local v9    # "$i$a$-run-AndroidBridge$clickInlineButton$1$idx$1":I
    :catch_1
    move-exception v0

    .line 196
    .local v0, "e":Ljava/lang/Exception;
    :goto_2
    iget-object v3, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v6, v2, Lcom/cineflix/android/AndroidBridge$clickInlineButton$1;->$queryId:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    .end local v0    # "e":Ljava/lang/Exception;
    if-nez v0, :cond_6

    const-string v0, "Error desconocido"

    :cond_6
    invoke-static {v3, v6, v4, v0}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V

    move-object v6, v5

    .line 198
    .end local v5    # "$result":Ljava/lang/Object;
    .restart local v6    # "$result":Ljava/lang/Object;
    :goto_3
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
