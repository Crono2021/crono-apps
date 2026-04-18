.class final Lcom/cineflix/android/TelegramEngine$getBotChatId$2$1;
.super Ljava/lang/Object;
.source "TelegramEngine.kt"

# interfaces
.implements Lorg/drinkless/tdlib/Client$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/TelegramEngine;->getBotChatId(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\u0008\u0005"
    }
    d2 = {
        "<anonymous>",
        "",
        "result",
        "Lorg/drinkless/tdlib/TdApi$Object;",
        "kotlin.jvm.PlatformType",
        "onResult"
    }
    k = 0x3
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic $cont:Lkotlinx/coroutines/CancellableContinuation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlinx/coroutines/CancellableContinuation<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lkotlinx/coroutines/CancellableContinuation;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlinx/coroutines/CancellableContinuation<",
            "-",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/cineflix/android/TelegramEngine$getBotChatId$2$1;->$cont:Lkotlinx/coroutines/CancellableContinuation;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onResult(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 3
    .param p1, "result"    # Lorg/drinkless/tdlib/TdApi$Object;

    .line 549
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$getBotChatId$2$1;->$cont:Lkotlinx/coroutines/CancellableContinuation;

    instance-of v1, p1, Lorg/drinkless/tdlib/TdApi$Chat;

    if-eqz v1, :cond_0

    move-object v1, p1

    check-cast v1, Lorg/drinkless/tdlib/TdApi$Chat;

    iget-wide v1, v1, Lorg/drinkless/tdlib/TdApi$Chat;->id:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    sget-object v2, Lcom/cineflix/android/TelegramEngine$getBotChatId$2$1$1;->INSTANCE:Lcom/cineflix/android/TelegramEngine$getBotChatId$2$1$1;

    check-cast v2, Lkotlin/jvm/functions/Function1;

    invoke-interface {v0, v1, v2}, Lkotlinx/coroutines/CancellableContinuation;->resume(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V

    .line 550
    return-void
.end method
