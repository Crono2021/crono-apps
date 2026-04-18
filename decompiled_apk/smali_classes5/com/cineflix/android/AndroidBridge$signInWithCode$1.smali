.class final Lcom/cineflix/android/AndroidBridge$signInWithCode$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "AndroidBridge.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/AndroidBridge;->signInWithCode(Ljava/lang/String;)V
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
    c = "com.cineflix.android.AndroidBridge$signInWithCode$1"
    f = "AndroidBridge.kt"
    i = {}
    l = {
        0x4c
    }
    m = "invokeSuspend"
    n = {}
    s = {}
.end annotation


# instance fields
.field final synthetic $code:Ljava/lang/String;

.field label:I

.field final synthetic this$0:Lcom/cineflix/android/AndroidBridge;


# direct methods
.method constructor <init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/cineflix/android/AndroidBridge;",
            "Ljava/lang/String;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lcom/cineflix/android/AndroidBridge$signInWithCode$1;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iput-object p2, p0, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->$code:Ljava/lang/String;

    const/4 v0, 0x2

    invoke-direct {p0, v0, p3}, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(ILkotlin/coroutines/Continuation;)V

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

    new-instance v0, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;

    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iget-object v2, p0, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->$code:Ljava/lang/String;

    invoke-direct {v0, v1, v2, p2}, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;-><init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;Lkotlin/coroutines/Continuation;)V

    check-cast v0, Lkotlin/coroutines/Continuation;

    return-object v0
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Lkotlinx/coroutines/CoroutineScope;

    check-cast p2, Lkotlin/coroutines/Continuation;

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

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

    invoke-virtual {p0, p1, p2}, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object v0

    check-cast v0, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;

    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-virtual {v0, v1}, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 6

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 74
    iget v1, p0, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->label:I

    packed-switch v1, :pswitch_data_0

    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_0
    move-object v0, p0

    .local v0, "this":Lcom/cineflix/android/AndroidBridge$signInWithCode$1;
    .local p1, "$result":Ljava/lang/Object;
    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v1, v0

    move-object v0, p1

    goto :goto_0

    .end local v0    # "this":Lcom/cineflix/android/AndroidBridge$signInWithCode$1;
    .end local p1    # "$result":Ljava/lang/Object;
    :pswitch_1
    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v1, p0

    .line 75
    .local v1, "this":Lcom/cineflix/android/AndroidBridge$signInWithCode$1;
    .restart local p1    # "$result":Ljava/lang/Object;
    iget-object v2, v1, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    invoke-static {v2}, Lcom/cineflix/android/AndroidBridge;->access$getEngine$p(Lcom/cineflix/android/AndroidBridge;)Lcom/cineflix/android/TelegramEngine;

    move-result-object v2

    iget-object v3, v1, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->$code:Ljava/lang/String;

    new-instance v4, Lcom/cineflix/android/AndroidBridge$signInWithCode$1$1;

    iget-object v5, v1, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    invoke-direct {v4, v5}, Lcom/cineflix/android/AndroidBridge$signInWithCode$1$1;-><init>(Lcom/cineflix/android/AndroidBridge;)V

    check-cast v4, Lkotlin/jvm/functions/Function1;

    invoke-virtual {v2, v3, v4}, Lcom/cineflix/android/TelegramEngine;->sendCode(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V

    .line 76
    new-instance v2, Lcom/cineflix/android/AndroidBridge$signInWithCode$1$timeout$1;

    iget-object v3, v1, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    const/4 v4, 0x0

    invoke-direct {v2, v3, v4}, Lcom/cineflix/android/AndroidBridge$signInWithCode$1$timeout$1;-><init>(Lcom/cineflix/android/AndroidBridge;Lkotlin/coroutines/Continuation;)V

    check-cast v2, Lkotlin/jvm/functions/Function2;

    move-object v3, v1

    check-cast v3, Lkotlin/coroutines/Continuation;

    const/4 v4, 0x1

    iput v4, v1, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->label:I

    const-wide/16 v4, 0x3a98

    invoke-static {v4, v5, v2, v3}, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v2

    if-ne v2, v0, :cond_0

    .line 74
    return-object v0

    .line 76
    :cond_0
    move-object v0, p1

    move-object p1, v2

    .line 74
    .end local p1    # "$result":Ljava/lang/Object;
    .local v0, "$result":Ljava/lang/Object;
    :goto_0
    check-cast p1, Lcom/cineflix/android/TelegramEngine$AuthState;

    .line 83
    .local p1, "timeout":Lcom/cineflix/android/TelegramEngine$AuthState;
    nop

    .line 84
    instance-of v2, p1, Lcom/cineflix/android/TelegramEngine$AuthState$Ready;

    if-eqz v2, :cond_1

    iget-object v2, v1, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    const-string v3, "READY"

    invoke-static {v2, v3}, Lcom/cineflix/android/AndroidBridge;->access$sendAuthState(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;)V

    goto :goto_1

    .line 85
    :cond_1
    instance-of v2, p1, Lcom/cineflix/android/TelegramEngine$AuthState$WaitPassword;

    if-eqz v2, :cond_2

    iget-object v2, v1, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    const-string v3, "WAIT_PASSWORD"

    invoke-static {v2, v3}, Lcom/cineflix/android/AndroidBridge;->access$sendAuthState(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;)V

    goto :goto_1

    .line 86
    :cond_2
    instance-of v2, p1, Lcom/cineflix/android/TelegramEngine$AuthState$Error;

    if-eqz v2, :cond_3

    iget-object v2, v1, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    const-string v3, "null cannot be cast to non-null type com.cineflix.android.TelegramEngine.AuthState.Error"

    invoke-static {p1, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v3, p1

    check-cast v3, Lcom/cineflix/android/TelegramEngine$AuthState$Error;

    invoke-virtual {v3}, Lcom/cineflix/android/TelegramEngine$AuthState$Error;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/cineflix/android/AndroidBridge;->access$sendAuthError(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;)V

    goto :goto_1

    .line 87
    :cond_3
    if-nez p1, :cond_4

    iget-object v2, v1, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    const-string v3, "Timeout: TDLib did not confirm code"

    invoke-static {v2, v3}, Lcom/cineflix/android/AndroidBridge;->access$sendAuthError(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;)V

    goto :goto_1

    .line 88
    :cond_4
    iget-object v2, v1, Lcom/cineflix/android/AndroidBridge$signInWithCode$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unexpected state: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/cineflix/android/AndroidBridge;->access$sendAuthError(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;)V

    .line 90
    .end local p1    # "timeout":Lcom/cineflix/android/TelegramEngine$AuthState;
    :goto_1
    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
