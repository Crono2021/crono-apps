.class final Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "AndroidBridge.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/AndroidBridge;->searchMovieByPayload(Ljava/lang/String;Ljava/lang/String;)V
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
    c = "com.cineflix.android.AndroidBridge$searchMovieByPayload$1"
    f = "AndroidBridge.kt"
    i = {
        0x1
    }
    l = {
        0xd2,
        0xd3
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
.field final synthetic $queryId:Ljava/lang/String;

.field final synthetic $searchTitle:Ljava/lang/String;

.field L$0:Ljava/lang/Object;

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
            "Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iput-object p2, p0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->$searchTitle:Ljava/lang/String;

    iput-object p3, p0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->$queryId:Ljava/lang/String;

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

    new-instance v0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;

    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v2, p0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->$searchTitle:Ljava/lang/String;

    iget-object v3, p0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->$queryId:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, p2}, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    check-cast v0, Lkotlin/coroutines/Continuation;

    return-object v0
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Lkotlinx/coroutines/CoroutineScope;

    check-cast p2, Lkotlin/coroutines/Continuation;

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

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

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object v0

    check-cast v0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;

    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-virtual {v0, v1}, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 9

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 208
    iget v1, p0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->label:I

    const/4 v2, 0x1

    packed-switch v1, :pswitch_data_0

    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_0
    move-object v0, p0

    .local v0, "this":Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;
    .local p1, "$result":Ljava/lang/Object;
    iget-object v1, v0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->L$0:Ljava/lang/Object;

    check-cast v1, Ljava/util/List;

    .local v1, "videos":Ljava/util/List;
    :try_start_0
    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v3, v1

    move-object v1, p1

    goto :goto_1

    .line 213
    .end local v1    # "videos":Ljava/util/List;
    :catch_0
    move-exception v1

    goto/16 :goto_3

    .line 208
    .end local v0    # "this":Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;
    .end local p1    # "$result":Ljava/lang/Object;
    :pswitch_1
    move-object v1, p0

    .local v1, "this":Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;
    .restart local p1    # "$result":Ljava/lang/Object;
    :try_start_1
    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-object v3, v1

    move-object v1, p1

    goto :goto_0

    .line 213
    :catch_1
    move-exception v0

    move-object v8, v1

    move-object v1, v0

    move-object v0, v8

    goto/16 :goto_3

    .line 208
    .end local v1    # "this":Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;
    .end local p1    # "$result":Ljava/lang/Object;
    :pswitch_2
    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v1, p0

    .line 209
    .restart local v1    # "this":Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;
    .restart local p1    # "$result":Ljava/lang/Object;
    nop

    .line 210
    :try_start_2
    iget-object v3, v1, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    invoke-static {v3}, Lcom/cineflix/android/AndroidBridge;->access$getEngine$p(Lcom/cineflix/android/AndroidBridge;)Lcom/cineflix/android/TelegramEngine;

    move-result-object v3

    iget-object v4, v1, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->$searchTitle:Ljava/lang/String;

    move-object v5, v1

    check-cast v5, Lkotlin/coroutines/Continuation;

    iput v2, v1, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->label:I

    invoke-virtual {v3, v4, v5}, Lcom/cineflix/android/TelegramEngine;->searchMovieByPayload(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v3
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    if-ne v3, v0, :cond_0

    .line 208
    return-object v0

    .line 210
    :cond_0
    move-object v8, v1

    move-object v1, p1

    move-object p1, v3

    move-object v3, v8

    .line 208
    .end local p1    # "$result":Ljava/lang/Object;
    .local v1, "$result":Ljava/lang/Object;
    .local v3, "this":Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;
    :goto_0
    :try_start_3
    check-cast p1, Ljava/util/List;

    .line 211
    .local p1, "videos":Ljava/util/List;
    iget-object v4, v3, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    invoke-static {v4}, Lcom/cineflix/android/AndroidBridge;->access$getEngine$p(Lcom/cineflix/android/AndroidBridge;)Lcom/cineflix/android/TelegramEngine;

    move-result-object v4

    move-object v5, v3

    check-cast v5, Lkotlin/coroutines/Continuation;

    iput-object p1, v3, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->L$0:Ljava/lang/Object;

    const/4 v6, 0x2

    iput v6, v3, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->label:I

    invoke-virtual {v4, v5}, Lcom/cineflix/android/TelegramEngine;->getBotChatIdPublic(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v4
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    if-ne v4, v0, :cond_1

    .line 208
    return-object v0

    .line 211
    :cond_1
    move-object v0, v3

    move-object v3, p1

    move-object p1, v4

    .end local p1    # "videos":Ljava/util/List;
    .restart local v0    # "this":Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;
    .local v3, "videos":Ljava/util/List;
    :goto_1
    :try_start_4
    check-cast p1, Ljava/lang/Long;

    if-eqz p1, :cond_2

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    goto :goto_2

    :cond_2
    const-wide/16 v4, 0x0

    .line 212
    .local v4, "chatId":J
    :goto_2
    iget-object p1, v0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v6, v0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->$queryId:Ljava/lang/String;

    invoke-static {p1, v3, v4, v5}, Lcom/cineflix/android/AndroidBridge;->access$videosToJson(Lcom/cineflix/android/AndroidBridge;Ljava/util/List;J)Ljava/lang/String;

    move-result-object v7

    invoke-static {p1, v6, v2, v7}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    .end local v3    # "videos":Ljava/util/List;
    .end local v4    # "chatId":J
    goto :goto_4

    .line 213
    :catch_2
    move-exception p1

    move-object v8, v1

    move-object v1, p1

    move-object p1, v8

    goto :goto_3

    .end local v0    # "this":Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;
    .local v3, "this":Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;
    :catch_3
    move-exception p1

    move-object v0, v3

    move-object v8, v1

    move-object v1, p1

    move-object p1, v8

    .line 214
    .end local v3    # "this":Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;
    .restart local v0    # "this":Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;
    .local v1, "e":Ljava/lang/Exception;
    .local p1, "$result":Ljava/lang/Object;
    :goto_3
    iget-object v2, v0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v3, v0, Lcom/cineflix/android/AndroidBridge$searchMovieByPayload$1;->$queryId:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    .end local v1    # "e":Ljava/lang/Exception;
    if-nez v1, :cond_3

    const-string v1, "Error desconocido"

    :cond_3
    const/4 v4, 0x0

    invoke-static {v2, v3, v4, v1}, Lcom/cineflix/android/AndroidBridge;->access$callback(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V

    move-object v1, p1

    .line 216
    .end local p1    # "$result":Ljava/lang/Object;
    .local v1, "$result":Ljava/lang/Object;
    :goto_4
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
