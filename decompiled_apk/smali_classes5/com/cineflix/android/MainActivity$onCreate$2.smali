.class public final Lcom/cineflix/android/MainActivity$onCreate$2;
.super Landroidx/activity/OnBackPressedCallback;
.source "MainActivity.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cineflix/android/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"
    }
    d2 = {
        "com/cineflix/android/MainActivity$onCreate$2",
        "Landroidx/activity/OnBackPressedCallback;",
        "handleOnBackPressed",
        "",
        "app_debug"
    }
    k = 0x1
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic this$0:Lcom/cineflix/android/MainActivity;


# direct methods
.method public static synthetic $r8$lambda$zX9L21VO3g1z7LM9tzBLI7-pD5A(Lcom/cineflix/android/MainActivity;Ljava/lang/String;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/cineflix/android/MainActivity$onCreate$2;->handleOnBackPressed$lambda$1$lambda$0(Lcom/cineflix/android/MainActivity;Ljava/lang/String;)V

    return-void
.end method

.method constructor <init>(Lcom/cineflix/android/MainActivity;)V
    .locals 1
    .param p1, "$receiver"    # Lcom/cineflix/android/MainActivity;

    iput-object p1, p0, Lcom/cineflix/android/MainActivity$onCreate$2;->this$0:Lcom/cineflix/android/MainActivity;

    .line 104
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroidx/activity/OnBackPressedCallback;-><init>(Z)V

    return-void
.end method

.method private static final handleOnBackPressed$lambda$1$lambda$0(Lcom/cineflix/android/MainActivity;Ljava/lang/String;)V
    .locals 3
    .param p0, "this$0"    # Lcom/cineflix/android/MainActivity;
    .param p1, "result"    # Ljava/lang/String;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 109
    const-string v0, "true"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 111
    invoke-static {p0}, Lcom/cineflix/android/MainActivity;->access$getWebView$p(Lcom/cineflix/android/MainActivity;)Landroid/webkit/WebView;

    move-result-object v0

    const/4 v1, 0x0

    const-string v2, "webView"

    if-nez v0, :cond_0

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 112
    invoke-static {p0}, Lcom/cineflix/android/MainActivity;->access$getWebView$p(Lcom/cineflix/android/MainActivity;)Landroid/webkit/WebView;

    move-result-object v0

    if-nez v0, :cond_1

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    move-object v1, v0

    :goto_0
    invoke-virtual {v1}, Landroid/webkit/WebView;->goBack()V

    goto :goto_1

    .line 114
    :cond_2
    invoke-virtual {p0}, Lcom/cineflix/android/MainActivity;->finish()V

    .line 117
    :cond_3
    :goto_1
    return-void
.end method


# virtual methods
.method public handleOnBackPressed()V
    .locals 8

    .line 107
    const-string v0, "webView"

    iget-object v1, p0, Lcom/cineflix/android/MainActivity$onCreate$2;->this$0:Lcom/cineflix/android/MainActivity;

    const/4 v2, 0x0

    :try_start_0
    sget-object v3, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v3, p0

    check-cast v3, Lcom/cineflix/android/MainActivity$onCreate$2;

    .local v3, "$this$handleOnBackPressed_u24lambda_u241":Lcom/cineflix/android/MainActivity$onCreate$2;
    const/4 v4, 0x0

    .line 108
    .local v4, "$i$a$-runCatching-MainActivity$onCreate$2$handleOnBackPressed$jsHandled$1":I
    invoke-static {v1}, Lcom/cineflix/android/MainActivity;->access$getWebView$p(Lcom/cineflix/android/MainActivity;)Landroid/webkit/WebView;

    move-result-object v5

    if-nez v5, :cond_0

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v2

    :cond_0
    const-string v6, "window.__cineflixBack ? window.__cineflixBack() : false"

    new-instance v7, Lcom/cineflix/android/MainActivity$onCreate$2$$ExternalSyntheticLambda0;

    invoke-direct {v7, v1}, Lcom/cineflix/android/MainActivity$onCreate$2$$ExternalSyntheticLambda0;-><init>(Lcom/cineflix/android/MainActivity;)V

    invoke-virtual {v5, v6, v7}, Landroid/webkit/WebView;->evaluateJavascript(Ljava/lang/String;Landroid/webkit/ValueCallback;)V

    .line 118
    nop

    .end local v3    # "$this$handleOnBackPressed_u24lambda_u241":Lcom/cineflix/android/MainActivity$onCreate$2;
    .end local v4    # "$i$a$-runCatching-MainActivity$onCreate$2$handleOnBackPressed$jsHandled$1":I
    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    .line 107
    invoke-static {v1}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v1

    sget-object v3, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {v1}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 118
    :goto_0
    invoke-static {v1}, Lkotlin/Result;->isSuccess-impl(Ljava/lang/Object;)Z

    move-result v1

    .line 107
    nop

    .line 120
    .local v1, "jsHandled":Z
    if-nez v1, :cond_4

    .line 121
    iget-object v3, p0, Lcom/cineflix/android/MainActivity$onCreate$2;->this$0:Lcom/cineflix/android/MainActivity;

    invoke-static {v3}, Lcom/cineflix/android/MainActivity;->access$getWebView$p(Lcom/cineflix/android/MainActivity;)Landroid/webkit/WebView;

    move-result-object v3

    if-nez v3, :cond_1

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v2

    :cond_1
    invoke-virtual {v3}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v3

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/cineflix/android/MainActivity$onCreate$2;->this$0:Lcom/cineflix/android/MainActivity;

    invoke-static {v3}, Lcom/cineflix/android/MainActivity;->access$getWebView$p(Lcom/cineflix/android/MainActivity;)Landroid/webkit/WebView;

    move-result-object v3

    if-nez v3, :cond_2

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    move-object v2, v3

    :goto_1
    invoke-virtual {v2}, Landroid/webkit/WebView;->goBack()V

    goto :goto_2

    :cond_3
    iget-object v0, p0, Lcom/cineflix/android/MainActivity$onCreate$2;->this$0:Lcom/cineflix/android/MainActivity;

    invoke-virtual {v0}, Lcom/cineflix/android/MainActivity;->finish()V

    .line 123
    :cond_4
    :goto_2
    return-void
.end method
