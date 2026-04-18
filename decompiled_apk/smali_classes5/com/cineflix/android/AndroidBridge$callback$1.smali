.class final Lcom/cineflix/android/AndroidBridge$callback$1;
.super Lkotlin/jvm/internal/Lambda;
.source "AndroidBridge.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/AndroidBridge;->callback(Ljava/lang/String;ZLjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function0<",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\u0008\u0002"
    }
    d2 = {
        "<anonymous>",
        "",
        "invoke"
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
.field final synthetic $escaped:Ljava/lang/String;

.field final synthetic $queryId:Ljava/lang/String;

.field final synthetic $success:Z

.field final synthetic this$0:Lcom/cineflix/android/AndroidBridge;


# direct methods
.method constructor <init>(Lcom/cineflix/android/AndroidBridge;Ljava/lang/String;ZLjava/lang/String;)V
    .locals 1

    iput-object p1, p0, Lcom/cineflix/android/AndroidBridge$callback$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    iput-object p2, p0, Lcom/cineflix/android/AndroidBridge$callback$1;->$queryId:Ljava/lang/String;

    iput-boolean p3, p0, Lcom/cineflix/android/AndroidBridge$callback$1;->$success:Z

    iput-object p4, p0, Lcom/cineflix/android/AndroidBridge$callback$1;->$escaped:Ljava/lang/String;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 287
    invoke-virtual {p0}, Lcom/cineflix/android/AndroidBridge$callback$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .locals 6

    .line 288
    iget-object v0, p0, Lcom/cineflix/android/AndroidBridge$callback$1;->this$0:Lcom/cineflix/android/AndroidBridge;

    invoke-static {v0}, Lcom/cineflix/android/AndroidBridge;->access$getWebView$p(Lcom/cineflix/android/AndroidBridge;)Landroid/webkit/WebView;

    move-result-object v0

    .line 289
    iget-object v1, p0, Lcom/cineflix/android/AndroidBridge$callback$1;->$queryId:Ljava/lang/String;

    iget-boolean v2, p0, Lcom/cineflix/android/AndroidBridge$callback$1;->$success:Z

    iget-object v3, p0, Lcom/cineflix/android/AndroidBridge$callback$1;->$escaped:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "window.onTelegramCallback && window.onTelegramCallback(\'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "\', "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\')"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 290
    nop

    .line 288
    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/webkit/WebView;->evaluateJavascript(Ljava/lang/String;Landroid/webkit/ValueCallback;)V

    .line 292
    return-void
.end method
