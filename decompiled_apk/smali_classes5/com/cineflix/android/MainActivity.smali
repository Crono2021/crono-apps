.class public final Lcom/cineflix/android/MainActivity;
.super Landroidx/activity/ComponentActivity;
.source "MainActivity.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0015J\u0008\u0010\u000f\u001a\u00020\u000cH\u0014J\u0008\u0010\u0010\u001a\u00020\u000cH\u0014J\u0008\u0010\u0011\u001a\u00020\u000cH\u0014J\u0010\u0010\u0012\u001a\u00020\u000c2\u0006\u0010\u0013\u001a\u00020\u000eH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"
    }
    d2 = {
        "Lcom/cineflix/android/MainActivity;",
        "Landroidx/activity/ComponentActivity;",
        "()V",
        "bridge",
        "Lcom/cineflix/android/AndroidBridge;",
        "engine",
        "Lcom/cineflix/android/TelegramEngine;",
        "isAndroidTV",
        "",
        "webView",
        "Landroid/webkit/WebView;",
        "onCreate",
        "",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onDestroy",
        "onPause",
        "onResume",
        "onSaveInstanceState",
        "outState",
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


# static fields
.field public static final $stable:I


# instance fields
.field private bridge:Lcom/cineflix/android/AndroidBridge;

.field private engine:Lcom/cineflix/android/TelegramEngine;

.field private isAndroidTV:Z

.field private webView:Landroid/webkit/WebView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0x8

    sput v0, Lcom/cineflix/android/MainActivity;->$stable:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 18
    invoke-direct {p0}, Landroidx/activity/ComponentActivity;-><init>()V

    return-void
.end method

.method public static final synthetic access$getWebView$p(Lcom/cineflix/android/MainActivity;)Landroid/webkit/WebView;
    .locals 1
    .param p0, "$this"    # Lcom/cineflix/android/MainActivity;

    .line 18
    iget-object v0, p0, Lcom/cineflix/android/MainActivity;->webView:Landroid/webkit/WebView;

    return-object v0
.end method

.method public static final synthetic access$isAndroidTV$p(Lcom/cineflix/android/MainActivity;)Z
    .locals 1
    .param p0, "$this"    # Lcom/cineflix/android/MainActivity;

    .line 18
    iget-boolean v0, p0, Lcom/cineflix/android/MainActivity;->isAndroidTV:Z

    return v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 27
    invoke-super {p0, p1}, Landroidx/activity/ComponentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 30
    const-string v0, "uimode"

    invoke-virtual {p0, v0}, Lcom/cineflix/android/MainActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type android.app.UiModeManager"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/app/UiModeManager;

    .line 31
    .local v0, "uiModeManager":Landroid/app/UiModeManager;
    invoke-virtual {v0}, Landroid/app/UiModeManager;->getCurrentModeType()I

    move-result v1

    const/4 v2, 0x4

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-ne v1, v2, :cond_0

    move v1, v4

    goto :goto_0

    :cond_0
    move v1, v3

    :goto_0
    iput-boolean v1, p0, Lcom/cineflix/android/MainActivity;->isAndroidTV:Z

    .line 32
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Android TV mode: "

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "CineflixMain"

    invoke-static {v2, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 34
    sget-object v1, Lcom/cineflix/android/TelegramEngine;->Companion:Lcom/cineflix/android/TelegramEngine$Companion;

    move-object v5, p0

    check-cast v5, Landroid/content/Context;

    invoke-virtual {v1, v5}, Lcom/cineflix/android/TelegramEngine$Companion;->getInstance(Landroid/content/Context;)Lcom/cineflix/android/TelegramEngine;

    move-result-object v1

    iput-object v1, p0, Lcom/cineflix/android/MainActivity;->engine:Lcom/cineflix/android/TelegramEngine;

    .line 36
    new-instance v1, Landroid/webkit/WebView;

    move-object v5, p0

    check-cast v5, Landroid/content/Context;

    invoke-direct {v1, v5}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    move-object v5, v1

    .local v5, "$this$onCreate_u24lambda_u241":Landroid/webkit/WebView;
    const/4 v6, 0x0

    .line 37
    .local v6, "$i$a$-apply-MainActivity$onCreate$1":I
    invoke-virtual {v5}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v7

    .local v7, "$this$onCreate_u24lambda_u241_u24lambda_u240":Landroid/webkit/WebSettings;
    const/4 v8, 0x0

    .line 38
    .local v8, "$i$a$-apply-MainActivity$onCreate$1$1":I
    invoke-virtual {v7, v4}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 39
    invoke-virtual {v7, v4}, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V

    .line 40
    invoke-virtual {v7, v4}, Landroid/webkit/WebSettings;->setAllowFileAccess(Z)V

    .line 41
    invoke-virtual {v7, v4}, Landroid/webkit/WebSettings;->setAllowContentAccess(Z)V

    .line 42
    invoke-virtual {v7, v4}, Landroid/webkit/WebSettings;->setDatabaseEnabled(Z)V

    .line 43
    invoke-virtual {v7, v3}, Landroid/webkit/WebSettings;->setMediaPlaybackRequiresUserGesture(Z)V

    .line 45
    invoke-virtual {v7, v4}, Landroid/webkit/WebSettings;->setAllowFileAccessFromFileURLs(Z)V

    .line 47
    invoke-virtual {v7, v4}, Landroid/webkit/WebSettings;->setAllowUniversalAccessFromFileURLs(Z)V

    .line 48
    nop

    .line 37
    .end local v7    # "$this$onCreate_u24lambda_u241_u24lambda_u240":Landroid/webkit/WebSettings;
    .end local v8    # "$i$a$-apply-MainActivity$onCreate$1$1":I
    nop

    .line 51
    new-instance v3, Lcom/cineflix/android/AndroidBridge;

    move-object v4, p0

    check-cast v4, Landroid/content/Context;

    iget-object v7, p0, Lcom/cineflix/android/MainActivity;->engine:Lcom/cineflix/android/TelegramEngine;

    if-nez v7, :cond_1

    const-string v7, "engine"

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v7, 0x0

    :cond_1
    invoke-direct {v3, v4, v5, v7}, Lcom/cineflix/android/AndroidBridge;-><init>(Landroid/content/Context;Landroid/webkit/WebView;Lcom/cineflix/android/TelegramEngine;)V

    iput-object v3, p0, Lcom/cineflix/android/MainActivity;->bridge:Lcom/cineflix/android/AndroidBridge;

    .line 52
    const-string v4, "AndroidBridge"

    invoke-virtual {v5, v3, v4}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 55
    new-instance v3, Landroidx/webkit/WebViewAssetLoader$Builder;

    invoke-direct {v3}, Landroidx/webkit/WebViewAssetLoader$Builder;-><init>()V

    .line 56
    new-instance v4, Landroidx/webkit/WebViewAssetLoader$AssetsPathHandler;

    move-object v7, p0

    check-cast v7, Landroid/content/Context;

    invoke-direct {v4, v7}, Landroidx/webkit/WebViewAssetLoader$AssetsPathHandler;-><init>(Landroid/content/Context;)V

    check-cast v4, Landroidx/webkit/WebViewAssetLoader$PathHandler;

    const-string v7, "/assets/"

    invoke-virtual {v3, v7, v4}, Landroidx/webkit/WebViewAssetLoader$Builder;->addPathHandler(Ljava/lang/String;Landroidx/webkit/WebViewAssetLoader$PathHandler;)Landroidx/webkit/WebViewAssetLoader$Builder;

    move-result-object v3

    .line 57
    invoke-virtual {v3}, Landroidx/webkit/WebViewAssetLoader$Builder;->build()Landroidx/webkit/WebViewAssetLoader;

    move-result-object v3

    const-string v4, "build(...)"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 55
    nop

    .line 59
    .local v3, "assetLoader":Landroidx/webkit/WebViewAssetLoader;
    new-instance v4, Lcom/cineflix/android/MainActivity$onCreate$1$2;

    invoke-direct {v4, v3, p0}, Lcom/cineflix/android/MainActivity$onCreate$1$2;-><init>(Landroidx/webkit/WebViewAssetLoader;Lcom/cineflix/android/MainActivity;)V

    check-cast v4, Landroid/webkit/WebViewClient;

    invoke-virtual {v5, v4}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 81
    new-instance v4, Lcom/cineflix/android/MainActivity$onCreate$1$3;

    invoke-direct {v4}, Lcom/cineflix/android/MainActivity$onCreate$1$3;-><init>()V

    check-cast v4, Landroid/webkit/WebChromeClient;

    invoke-virtual {v5, v4}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 92
    if-eqz p1, :cond_2

    .line 93
    invoke-virtual {v5, p1}, Landroid/webkit/WebView;->restoreState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;

    .line 94
    const-string v4, "WebView state restored from savedInstanceState"

    invoke-static {v2, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 96
    :cond_2
    const-string v4, "https://cineflix-production-19e3.up.railway.app/"

    invoke-virtual {v5, v4}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 97
    const-string v4, "WebView loading fresh URL"

    invoke-static {v2, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 99
    :goto_1
    nop

    .line 36
    .end local v3    # "assetLoader":Landroidx/webkit/WebViewAssetLoader;
    .end local v5    # "$this$onCreate_u24lambda_u241":Landroid/webkit/WebView;
    .end local v6    # "$i$a$-apply-MainActivity$onCreate$1":I
    iput-object v1, p0, Lcom/cineflix/android/MainActivity;->webView:Landroid/webkit/WebView;

    .line 101
    check-cast v1, Landroid/view/View;

    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Landroid/view/View;->setKeepScreenOn(Z)V

    invoke-virtual {p0, v1}, Lcom/cineflix/android/MainActivity;->setContentView(Landroid/view/View;)V

    .line 104
    invoke-virtual {p0}, Lcom/cineflix/android/MainActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;

    move-result-object v1

    move-object v2, p0

    check-cast v2, Landroidx/lifecycle/LifecycleOwner;

    new-instance v3, Lcom/cineflix/android/MainActivity$onCreate$2;

    invoke-direct {v3, p0}, Lcom/cineflix/android/MainActivity$onCreate$2;-><init>(Lcom/cineflix/android/MainActivity;)V

    check-cast v3, Landroidx/activity/OnBackPressedCallback;

    invoke-virtual {v1, v2, v3}, Landroidx/activity/OnBackPressedDispatcher;->addCallback(Landroidx/lifecycle/LifecycleOwner;Landroidx/activity/OnBackPressedCallback;)V

    .line 125
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .line 148
    iget-object v0, p0, Lcom/cineflix/android/MainActivity;->bridge:Lcom/cineflix/android/AndroidBridge;

    if-nez v0, :cond_0

    const-string v0, "bridge"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_0
    invoke-virtual {v0}, Lcom/cineflix/android/AndroidBridge;->cleanup()V

    .line 149
    invoke-super {p0}, Landroidx/activity/ComponentActivity;->onDestroy()V

    .line 150
    return-void
.end method

.method protected onPause()V
    .locals 3

    .line 135
    invoke-super {p0}, Landroidx/activity/ComponentActivity;->onPause()V

    .line 136
    iget-object v0, p0, Lcom/cineflix/android/MainActivity;->webView:Landroid/webkit/WebView;

    const/4 v1, 0x0

    const-string v2, "webView"

    if-nez v0, :cond_0

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    invoke-virtual {v0}, Landroid/webkit/WebView;->onPause()V

    .line 137
    iget-object v0, p0, Lcom/cineflix/android/MainActivity;->webView:Landroid/webkit/WebView;

    if-nez v0, :cond_1

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    move-object v1, v0

    :goto_0
    invoke-virtual {v1}, Landroid/webkit/WebView;->pauseTimers()V

    .line 138
    return-void
.end method

.method protected onResume()V
    .locals 3

    .line 142
    invoke-super {p0}, Landroidx/activity/ComponentActivity;->onResume()V

    .line 143
    iget-object v0, p0, Lcom/cineflix/android/MainActivity;->webView:Landroid/webkit/WebView;

    const/4 v1, 0x0

    const-string v2, "webView"

    if-nez v0, :cond_0

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    invoke-virtual {v0}, Landroid/webkit/WebView;->resumeTimers()V

    .line 144
    iget-object v0, p0, Lcom/cineflix/android/MainActivity;->webView:Landroid/webkit/WebView;

    if-nez v0, :cond_1

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    move-object v1, v0

    :goto_0
    invoke-virtual {v1}, Landroid/webkit/WebView;->onResume()V

    .line 145
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    const-string v0, "outState"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 129
    invoke-super {p0, p1}, Landroidx/activity/ComponentActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 130
    iget-object v0, p0, Lcom/cineflix/android/MainActivity;->webView:Landroid/webkit/WebView;

    if-nez v0, :cond_0

    const-string v0, "webView"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_0
    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->saveState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;

    .line 131
    return-void
.end method
