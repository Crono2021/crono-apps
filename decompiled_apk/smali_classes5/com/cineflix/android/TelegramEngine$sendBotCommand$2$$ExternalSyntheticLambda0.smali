.class public final synthetic Lcom/cineflix/android/TelegramEngine$sendBotCommand$2$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lorg/drinkless/tdlib/Client$ResultHandler;


# instance fields
.field public final synthetic f$0:Lcom/cineflix/android/TelegramEngine;

.field public final synthetic f$1:Ljava/lang/String;

.field public final synthetic f$2:Lkotlinx/coroutines/CompletableDeferred;


# direct methods
.method public synthetic constructor <init>(Lcom/cineflix/android/TelegramEngine;Ljava/lang/String;Lkotlinx/coroutines/CompletableDeferred;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2$$ExternalSyntheticLambda0;->f$0:Lcom/cineflix/android/TelegramEngine;

    iput-object p2, p0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2$$ExternalSyntheticLambda0;->f$1:Ljava/lang/String;

    iput-object p3, p0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2$$ExternalSyntheticLambda0;->f$2:Lkotlinx/coroutines/CompletableDeferred;

    return-void
.end method


# virtual methods
.method public final onResult(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 3

    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2$$ExternalSyntheticLambda0;->f$0:Lcom/cineflix/android/TelegramEngine;

    iget-object v1, p0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2$$ExternalSyntheticLambda0;->f$1:Ljava/lang/String;

    iget-object v2, p0, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2$$ExternalSyntheticLambda0;->f$2:Lkotlinx/coroutines/CompletableDeferred;

    invoke-static {v0, v1, v2, p1}, Lcom/cineflix/android/TelegramEngine$sendBotCommand$2;->$r8$lambda$wTAmclgJRY4nOOvKesgzkpjUIfA(Lcom/cineflix/android/TelegramEngine;Ljava/lang/String;Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method
