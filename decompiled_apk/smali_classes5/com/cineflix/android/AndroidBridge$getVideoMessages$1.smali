.class final Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "AndroidBridge.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/AndroidBridge;->getVideoMessages(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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
    c = "com.cineflix.android.AndroidBridge$getVideoMessages$1"
    f = "AndroidBridge.kt"
    i = {
        0x1
    }
    l = {
        0xe6,
        0xe7
    }
    m = "invokeSuspend"
    n = {
        "videos"
    }
    s = {
        "L$0"
    }
.end annotation


# instance fields
.field final synthetic $limitStr:Ljava/lang/String;

.field final synthetic $minIdStr:Ljava/lang/String;

.field final synthetic $queryId:Ljava/lang/String;

.field L$0:Ljava/lang/Object;

.field label:I

.field final synthetic this$0:Lcom/cineflix/android/AndroidBridge;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/cineflix/android/AndroidBridge;",
            "Ljava/lang/String;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->$limitStr:Ljava/lang/String;

    iput-object p2, p0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->$minIdStr:Ljava/lang/String;

    iput-object p3, p0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iput-object p4, p0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->$queryId:Ljava/lang/String;

    const/4 v0, 0x2

    invoke-direct {p0, v0, p5}, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(ILkotlin/coroutines/Continuation;)V

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

    new-instance v6, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;

    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->$limitStr:Ljava/lang/String;

    iget-object v2, p0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->$minIdStr:Ljava/lang/String;

    iget-object v3, p0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v4, p0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->$queryId:Ljava/lang/String;

    move-object v0, v6

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    check-cast v6, Lkotlin/coroutines/Continuation;

    return-object v6
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Lkotlinx/coroutines/CoroutineScope;

    check-cast p2, Lkotlin/coroutines/Continuation;

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

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

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object v0

    check-cast v0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;

    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-virtual {v0, v1}, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 11

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 226
    iget v1, p0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->label:I

    const/4 v2, 0x1

    const-wide/16 v3, 0x0

    packed-switch v1, :pswitch_data_0

    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_0
    move-object v0, p0

    .local v0, "this":Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;
    .local p1, "$result":Ljava/lang/Object;
    iget-object v1, v0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->L$0:Ljava/lang/Object;

    check-cast v1, Ljava/util/List;

    .local v1, "videos":Ljava/util/List;
    :try_start_0
    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v5, v1

    move-object v1, p1

    goto/16 :goto_3

    .line 233
    .end local v1    # "videos":Ljava/util/List;
    :catch_0
    move-exception v1

    goto/16 :goto_4

    .line 226
    .end local v0    # "this":Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;
    .end local p1    # "$result":Ljava/lang/Object;
    :pswitch_1
    move-object v1, p0

    .local v1, "this":Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;
    .restart local p1    # "$result":Ljava/lang/Object;
    :try_start_1
    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-object v5, v1

    move-object v1, p1

    goto :goto_2

    .line 233
    :catch_1
    move-exception v0

    move-object v10, v1

    move-object v1, v0

    move-object v0, v10

    goto/16 :goto_4

    .line 226
    .end local v1    # "this":Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;
    .end local p1    # "$result":Ljava/lang/Object;
    :pswitch_2
    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v1, p0

    .line 227
    .restart local v1    # "this":Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;
    .restart local p1    # "$result":Ljava/lang/Object;
    nop

    .line 228
    :try_start_2
    iget-object v5, v1, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->$limitStr:Ljava/lang/String;

    invoke-static {v5}, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v5

    if-eqz v5, :cond_0

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    goto :goto_0

    :cond_0
    const/16 v5, 0x32

    .line 229
    .local v5, "limit":I
    :goto_0
    iget-object v6, v1, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->$minIdStr:Ljava/lang/String;

    invoke-static {v6}, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v6

    if-eqz v6, :cond_1

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    goto :goto_1

    :cond_1
    move-wide v6, v3

    .line 230
    .local v6, "minId":J
    :goto_1
    iget-object v8, v1, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    invoke-static {v8}, Lcom/cineflix/android/AndroidBridge;->access$getEngine$p(Lcom/cineflix/android/AndroidBridge;)Lcom/cineflix/android/TelegramEngine;

    move-result-object v8

    move-object v9, v1

    check-cast v9, Lkotlin/coroutines/Continuation;

    iput v2, v1, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->label:I

    invoke-virtual {v8, v5, v6, v7, v9}, Lcom/cineflix/android/TelegramEngine;->getVideoMessagesHistory(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v8
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .end local v5    # "limit":I
    .end local v6    # "minId":J
    if-ne v8, v0, :cond_2

    .line 226
    return-object v0

    .line 230
    :cond_2
    move-object v5, v1

    move-object v1, p1

    move-object p1, v8

    .line 226
    .end local p1    # "$result":Ljava/lang/Object;
    .local v1, "$result":Ljava/lang/Object;
    .local v5, "this":Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;
    :goto_2
    :try_start_3
    check-cast p1, Ljava/util/List;

    .line 231
    .local p1, "videos":Ljava/util/List;
    iget-object v6, v5, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    invoke-static {v6}, Lcom/cineflix/android/AndroidBridge;->access$getEngine$p(Lcom/cineflix/android/AndroidBridge;)Lcom/cineflix/android/TelegramEngine;

    move-result-object v6

    move-object v7, v5

    check-cast v7, Lkotlin/coroutines/Continuation;

    iput-object p1, v5, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->L$0:Ljava/lang/Object;

    const/4 v8, 0x2

    iput v8, v5, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->label:I

    invoke-virtual {v6, v7}, Lcom/cineflix/android/TelegramEngine;->getBotChatIdPublic(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v6
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    if-ne v6, v0, :cond_3

    .line 226
    return-object v0

    .line 231
    :cond_3
    move-object v0, v5

    move-object v5, p1

    move-object p1, v6

    .end local p1    # "videos":Ljava/util/List;
    .restart local v0    # "this":Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;
    .local v5, "videos":Ljava/util/List;
    :goto_3
    :try_start_4
    check-cast p1, Ljava/lang/Long;

    if-eqz p1, :cond_4

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    .line 232
    .local v3, "chatId":J
    :cond_4
    iget-object p1, v0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v6, v0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->$queryId:Ljava/lang/String;

    invoke-static {p1, v5, v3, v4}, Lcom/cineflix/android/AndroidBridge;->access$videosToJson(Lcom/cineflix/android/AndroidBridge;Ljava/util/List;J)Ljava/lang/String;

    move-result-object v7

    invoke-static {p1, v6, v2, v7}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    .end local v3    # "chatId":J
    .end local v5    # "videos":Ljava/util/List;
    goto :goto_5

    .line 233
    :catch_2
    move-exception p1

    move-object v10, v1

    move-object v1, p1

    move-object p1, v10

    goto :goto_4

    .end local v0    # "this":Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;
    .local v5, "this":Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;
    :catch_3
    move-exception p1

    move-object v0, v5

    move-object v10, v1

    move-object v1, p1

    move-object p1, v10

    .line 234
    .end local v5    # "this":Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;
    .restart local v0    # "this":Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;
    .local v1, "e":Ljava/lang/Exception;
    .local p1, "$result":Ljava/lang/Object;
    :goto_4
    iget-object v2, v0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v3, v0, Lcom/cineflix/android/AndroidBridge$getVideoMessages$1;->$queryId:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    .end local v1    # "e":Ljava/lang/Exception;
    if-nez v1, :cond_5

    const-string v1, "Error desconocido"

    :cond_5
    const/4 v4, 0x0

    invoke-static {v2, v3, v4, v1}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V

    move-object v1, p1

    .line 236
    .end local p1    # "$result":Ljava/lang/Object;
    .local v1, "$result":Ljava/lang/Object;
    :goto_5
    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
