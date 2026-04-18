.class public final synthetic Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lorg/drinkless/tdlib/Client$ResultHandler;


# instance fields
.field public final synthetic f$0:J

.field public final synthetic f$1:Lcom/cineflix/android/TelegramEngine;

.field public final synthetic f$2:Ljava/util/List;

.field public final synthetic f$3:Lkotlinx/coroutines/CompletableDeferred;


# direct methods
.method public synthetic constructor <init>(JLcom/cineflix/android/TelegramEngine;Ljava/util/List;Lkotlinx/coroutines/CompletableDeferred;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide p1, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$$ExternalSyntheticLambda0;->f$0:J

    iput-object p3, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$$ExternalSyntheticLambda0;->f$1:Lcom/cineflix/android/TelegramEngine;

    iput-object p4, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$$ExternalSyntheticLambda0;->f$2:Ljava/util/List;

    iput-object p5, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$$ExternalSyntheticLambda0;->f$3:Lkotlinx/coroutines/CompletableDeferred;

    return-void
.end method


# virtual methods
.method public final onResult(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 6

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$$ExternalSyntheticLambda0;->f$0:J

    iget-object v2, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$$ExternalSyntheticLambda0;->f$1:Lcom/cineflix/android/TelegramEngine;

    iget-object v3, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$$ExternalSyntheticLambda0;->f$2:Ljava/util/List;

    iget-object v4, p0, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2$$ExternalSyntheticLambda0;->f$3:Lkotlinx/coroutines/CompletableDeferred;

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/cineflix/android/TelegramEngine$getVideoMessagesHistory$2;->$r8$lambda$LtVwJWn1MekNlE0WHMg-5ivyvcE(JLcom/cineflix/android/TelegramEngine;Ljava/util/List;Lkotlinx/coroutines/CompletableDeferred;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method
