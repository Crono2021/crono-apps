.class public Lorg/drinkless/tdlib/Client$ExecutionException;
.super Ljava/lang/Exception;
.source "Client.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/Client;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ExecutionException"
.end annotation


# instance fields
.field public final error:Lorg/drinkless/tdlib/TdApi$Error;


# direct methods
.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Error;)V
    .locals 2
    .param p1, "error"    # Lorg/drinkless/tdlib/TdApi$Error;

    .line 28
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v1, p1, Lorg/drinkless/tdlib/TdApi$Error;->code:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ": "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p1, Lorg/drinkless/tdlib/TdApi$Error;->message:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 29
    iput-object p1, p0, Lorg/drinkless/tdlib/Client$ExecutionException;->error:Lorg/drinkless/tdlib/TdApi$Error;

    .line 30
    return-void
.end method
