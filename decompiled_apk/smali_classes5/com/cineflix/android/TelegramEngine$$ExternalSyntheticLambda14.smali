.class public final synthetic Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda14;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lorg/drinkless/tdlib/Client$ResultHandler;


# instance fields
.field public final synthetic f$0:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method public synthetic constructor <init>(Ljava/util/concurrent/CountDownLatch;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda14;->f$0:Ljava/util/concurrent/CountDownLatch;

    return-void
.end method


# virtual methods
.method public final onResult(Lorg/drinkless/tdlib/TdApi$Object;)V
    .locals 1

    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$$ExternalSyntheticLambda14;->f$0:Ljava/util/concurrent/CountDownLatch;

    invoke-static {v0, p1}, Lcom/cineflix/android/TelegramEngine;->$r8$lambda$0r3KKnQthoDYcypbwbCTqeI58ZQ(Ljava/util/concurrent/CountDownLatch;Lorg/drinkless/tdlib/TdApi$Object;)V

    return-void
.end method
