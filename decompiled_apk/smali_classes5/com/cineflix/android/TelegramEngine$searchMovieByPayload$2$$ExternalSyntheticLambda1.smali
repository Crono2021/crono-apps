.class public final synthetic Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lorg/drinkless/tdlib/Client$ResultHandler;


# instance fields
.field public final synthetic f$0:Lkotlinx/coroutines/CompletableDeferred;


# direct methods
.method public synthetic constructor <init>(Lkotlinx/coroutines/CompletableDeferred;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2$$ExternalSyntheticLambda1;->f$0:Lkotlinx/coroutines/CompletableDeferred;

    return-void
.end method


# virtual methods
.method public final onResult(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 1

    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2$$ExternalSyntheticLambda1;->f$0:Lkotlinx/coroutines/CompletableDeferred;

    invoke-static {v0, p1}, Lcom/cineflix/android/TelegramEngine$searchMovieByPayload$2;->$r8$lambda$aZra8qqVeD4n21R75_4HeY4VJfk(Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method
