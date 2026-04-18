.class public final Lcom/cineflix/android/ui/player/PlayerActivity;
.super Landroid/app/Activity;
.source "PlayerActivity.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/cineflix/android/ui/player/PlayerActivity$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u000cH\u0017J\u0012\u0010\u0012\u001a\u00020\u000c2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0008\u0010\u0015\u001a\u00020\u000cH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"
    }
    d2 = {
        "Lcom/cineflix/android/ui/player/PlayerActivity;",
        "Landroid/app/Activity;",
        "()V",
        "player",
        "Landroidx/media3/exoplayer/ExoPlayer;",
        "playerView",
        "Landroidx/media3/ui/PlayerView;",
        "proxyServer",
        "Lcom/cineflix/android/ui/player/StreamProxyServer;",
        "scope",
        "Lkotlinx/coroutines/CoroutineScope;",
        "cleanup",
        "",
        "dispatchKeyEvent",
        "",
        "event",
        "Landroid/view/KeyEvent;",
        "onBackPressed",
        "onCreate",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onStop",
        "Companion",
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

.field public static final Companion:Lcom/cineflix/android/ui/player/PlayerActivity$Companion;

.field public static final EXTRA_CHAT_ID:Ljava/lang/String; = "chat_id"

.field public static final EXTRA_FILE_ID:Ljava/lang/String; = "file_id"

.field public static final EXTRA_FILE_SIZE:Ljava/lang/String; = "file_size"

.field public static final EXTRA_MIME_TYPE:Ljava/lang/String; = "mime_type"

.field public static final EXTRA_MSG_ID:Ljava/lang/String; = "msg_id"

.field public static final EXTRA_TITLE:Ljava/lang/String; = "title"

.field private static final TAG:Ljava/lang/String; = "PlayerActivity"


# instance fields
.field private player:Landroidx/media3/exoplayer/ExoPlayer;

.field private playerView:Landroidx/media3/ui/PlayerView;

.field private proxyServer:Lcom/cineflix/android/ui/player/StreamProxyServer;

.field private final scope:Lkotlinx/coroutines/CoroutineScope;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/cineflix/android/ui/player/PlayerActivity$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/cineflix/android/ui/player/PlayerActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/cineflix/android/ui/player/PlayerActivity;->Companion:Lcom/cineflix/android/ui/player/PlayerActivity$Companion;

    const/16 v0, 0x8

    sput v0, Lcom/cineflix/android/ui/player/PlayerActivity;->$stable:I

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .line 24
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 29
    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v1, v2, v1}, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job;ILjava/lang/Object;)Lkotlinx/coroutines/CompletableJob;

    move-result-object v1

    check-cast v1, Lkotlin/coroutines/CoroutineContext;

    invoke-virtual {v0, v1}, Lkotlinx/coroutines/CoroutineDispatcher;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;

    move-result-object v0

    invoke-static {v0}, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;

    move-result-object v0

    iput-object v0, p0, Lcom/cineflix/android/ui/player/PlayerActivity;->scope:Lkotlinx/coroutines/CoroutineScope;

    .line 24
    return-void
.end method

.method private final cleanup()V
    .locals 3

    .line 213
    :try_start_0
    iget-object v0, p0, Lcom/cineflix/android/ui/player/PlayerActivity;->player:Landroidx/media3/exoplayer/ExoPlayer;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroidx/media3/exoplayer/ExoPlayer;->release()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    .line 214
    :cond_0
    :goto_0
    :try_start_1
    iget-object v0, p0, Lcom/cineflix/android/ui/player/PlayerActivity;->proxyServer:Lcom/cineflix/android/ui/player/StreamProxyServer;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/cineflix/android/ui/player/StreamProxyServer;->stop()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    :catch_1
    move-exception v0

    .line 215
    :cond_1
    :goto_1
    iget-object v0, p0, Lcom/cineflix/android/ui/player/PlayerActivity;->scope:Lkotlinx/coroutines/CoroutineScope;

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-static {v0, v2, v1, v2}, Lkotlinx/coroutines/CoroutineScopeKt;->cancel$default(Lkotlinx/coroutines/CoroutineScope;Ljava/util/concurrent/CancellationException;ILjava/lang/Object;)V

    .line 219
    invoke-virtual {p0}, Lcom/cineflix/android/ui/player/PlayerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "file_id"

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 220
    .local v0, "fileId":I
    if-lez v0, :cond_2

    .line 221
    sget-object v1, Lcom/cineflix/android/TelegramEngine;->Companion:Lcom/cineflix/android/TelegramEngine$Companion;

    move-object v2, p0

    check-cast v2, Landroid/content/Context;

    invoke-virtual {v1, v2}, Lcom/cineflix/android/TelegramEngine$Companion;->getInstance(Landroid/content/Context;)Lcom/cineflix/android/TelegramEngine;

    move-result-object v1

    .line 222
    .local v1, "engine":Lcom/cineflix/android/TelegramEngine;
    invoke-virtual {v1, v0}, Lcom/cineflix/android/TelegramEngine;->cancelAndDeleteVideo(I)V

    .line 224
    .end local v1    # "engine":Lcom/cineflix/android/TelegramEngine;
    :cond_2
    return-void
.end method


# virtual methods
.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/KeyEvent;

    const-string v0, "event"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 203
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_2

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    .line 204
    iget-object v0, p0, Lcom/cineflix/android/ui/player/PlayerActivity;->playerView:Landroidx/media3/ui/PlayerView;

    const/4 v2, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerView;->isControllerFullyVisible()Z

    move-result v0

    if-ne v0, v1, :cond_0

    move v2, v1

    :cond_0
    if-eqz v2, :cond_2

    .line 205
    iget-object v0, p0, Lcom/cineflix/android/ui/player/PlayerActivity;->playerView:Landroidx/media3/ui/PlayerView;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroidx/media3/ui/PlayerView;->hideController()V

    .line 206
    :cond_1
    return v1

    .line 209
    :cond_2
    invoke-super {p0, p1}, Landroid/app/Activity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public onBackPressed()V
    .locals 0
    .annotation runtime Lkotlin/Deprecated;
        message = "Deprecated in Java"
    .end annotation

    .line 197
    invoke-direct {p0}, Lcom/cineflix/android/ui/player/PlayerActivity;->cleanup()V

    .line 198
    invoke-virtual {p0}, Lcom/cineflix/android/ui/player/PlayerActivity;->finish()V

    .line 199
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 24
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 63
    move-object/from16 v0, p0

    invoke-super/range {p0 .. p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 66
    invoke-virtual/range {p0 .. p0}, Lcom/cineflix/android/ui/player/PlayerActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    .line 67
    nop

    .line 66
    const/16 v2, 0x1006

    invoke-virtual {v1, v2}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 72
    invoke-virtual/range {p0 .. p0}, Lcom/cineflix/android/ui/player/PlayerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "file_id"

    const/4 v3, -0x1

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    .line 73
    .local v1, "fileId":I
    invoke-virtual/range {p0 .. p0}, Lcom/cineflix/android/ui/player/PlayerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "file_size"

    const-wide/16 v4, 0x0

    invoke-virtual {v2, v3, v4, v5}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v2

    .line 74
    .local v2, "fileSize":J
    invoke-virtual/range {p0 .. p0}, Lcom/cineflix/android/ui/player/PlayerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v6

    const-string v7, "mime_type"

    invoke-virtual {v6, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    if-nez v6, :cond_0

    const-string v6, "video/mp4"

    :cond_0
    move-object v10, v6

    .line 75
    .local v10, "mimeType":Ljava/lang/String;
    invoke-virtual/range {p0 .. p0}, Lcom/cineflix/android/ui/player/PlayerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v6

    const-string v7, "title"

    invoke-virtual {v6, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    if-nez v6, :cond_1

    const-string v6, ""

    :cond_1
    move-object v11, v6

    .line 76
    .local v11, "title":Ljava/lang/String;
    sget-object v6, Lcom/cineflix/android/TelegramEngine;->Companion:Lcom/cineflix/android/TelegramEngine$Companion;

    move-object v7, v0

    check-cast v7, Landroid/content/Context;

    invoke-virtual {v6, v7}, Lcom/cineflix/android/TelegramEngine$Companion;->getInstance(Landroid/content/Context;)Lcom/cineflix/android/TelegramEngine;

    move-result-object v12

    .line 78
    .local v12, "engine":Lcom/cineflix/android/TelegramEngine;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "\u25b6 onCreate \u2014 fileId="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " fileSize="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " mimeType="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " title="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const-string v13, "PlayerActivity"

    invoke-static {v13, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 80
    const/4 v14, 0x1

    if-gtz v1, :cond_2

    .line 81
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "INVALID fileId="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " \u2014 aborting"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v13, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 82
    move-object v4, v0

    check-cast v4, Landroid/content/Context;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Error: fileId inv\u00e1lido ("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    check-cast v5, Ljava/lang/CharSequence;

    invoke-static {v4, v5, v14}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/Toast;->show()V

    .line 83
    invoke-virtual/range {p0 .. p0}, Lcom/cineflix/android/ui/player/PlayerActivity;->finish()V

    .line 84
    return-void

    .line 88
    :cond_2
    move-wide v6, v2

    .line 89
    .local v6, "effectiveFileSize":J
    cmp-long v4, v6, v4

    if-gtz v4, :cond_5

    .line 91
    invoke-virtual {v12}, Lcom/cineflix/android/TelegramEngine;->getFileIdCache()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v4

    check-cast v4, Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lkotlin/Pair;

    .line 92
    .local v5, "pair":Lkotlin/Pair;
    invoke-virtual {v5}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Number;

    invoke-virtual {v8}, Ljava/lang/Number;->intValue()I

    move-result v8

    if-ne v8, v1, :cond_3

    .line 93
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "fileSize was 0, found fileId="

    invoke-virtual {v4, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v8, " in cache but no size info available"

    invoke-virtual {v4, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v13, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 94
    nop

    .line 98
    .end local v5    # "pair":Lkotlin/Pair;
    :cond_4
    const-wide/32 v6, 0x77359400

    .line 99
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Using default fileSize="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v13, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move-wide v15, v6

    goto :goto_0

    .line 89
    :cond_5
    move-wide v15, v6

    .line 103
    .end local v6    # "effectiveFileSize":J
    .local v15, "effectiveFileSize":J
    :goto_0
    new-instance v17, Lcom/cineflix/android/ui/player/StreamProxyServer;

    .line 104
    nop

    .line 105
    nop

    .line 106
    nop

    .line 107
    nop

    .line 103
    move-object/from16 v4, v17

    move-object v5, v12

    move v6, v1

    move-wide v7, v15

    move-object v9, v10

    invoke-direct/range {v4 .. v9}, Lcom/cineflix/android/ui/player/StreamProxyServer;-><init>(Lcom/cineflix/android/TelegramEngine;IJLjava/lang/String;)V

    .line 109
    .local v4, "proxy":Lcom/cineflix/android/ui/player/StreamProxyServer;
    invoke-virtual {v4}, Lcom/cineflix/android/ui/player/StreamProxyServer;->start()V

    .line 110
    iput-object v4, v0, Lcom/cineflix/android/ui/player/PlayerActivity;->proxyServer:Lcom/cineflix/android/ui/player/StreamProxyServer;

    .line 111
    invoke-virtual {v4}, Lcom/cineflix/android/ui/player/StreamProxyServer;->getListeningPort()I

    move-result v5

    .line 112
    .local v5, "port":I
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "\u25b6 StreamProxyServer started on port "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v13, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 119
    iget-object v6, v0, Lcom/cineflix/android/ui/player/PlayerActivity;->scope:Lkotlinx/coroutines/CoroutineScope;

    const/16 v18, 0x0

    const/16 v19, 0x0

    new-instance v7, Lcom/cineflix/android/ui/player/PlayerActivity$onCreate$1;

    const/4 v8, 0x0

    invoke-direct {v7, v1, v12, v8}, Lcom/cineflix/android/ui/player/PlayerActivity$onCreate$1;-><init>(ILcom/cineflix/android/TelegramEngine;Lkotlin/coroutines/Continuation;)V

    move-object/from16 v20, v7

    check-cast v20, Lkotlin/jvm/functions/Function2;

    const/16 v21, 0x3

    const/16 v22, 0x0

    move-object/from16 v17, v6

    invoke-static/range {v17 .. v22}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 132
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "http://127.0.0.1:"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/stream"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 133
    .local v6, "streamUrl":Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "\u25b6 ExoPlayer stream URL: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v13, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 135
    new-instance v7, Landroidx/media3/ui/PlayerView;

    move-object v8, v0

    check-cast v8, Landroid/content/Context;

    invoke-direct {v7, v8}, Landroidx/media3/ui/PlayerView;-><init>(Landroid/content/Context;)V

    iput-object v7, v0, Lcom/cineflix/android/ui/player/PlayerActivity;->playerView:Landroidx/media3/ui/PlayerView;

    .line 136
    invoke-virtual {v7, v14}, Landroidx/media3/ui/PlayerView;->setUseController(Z)V

    .line 137
    iget-object v7, v0, Lcom/cineflix/android/ui/player/PlayerActivity;->playerView:Landroidx/media3/ui/PlayerView;

    check-cast v7, Landroid/view/View;

    invoke-virtual {v0, v7}, Lcom/cineflix/android/ui/player/PlayerActivity;->setContentView(Landroid/view/View;)V

    .line 140
    const/16 v7, 0x3a98

    .line 141
    .local v7, "minBufferMs":I
    const v8, 0xc350

    .line 142
    .local v8, "maxBufferMs":I
    const/16 v9, 0x1388

    .line 143
    .local v9, "bufferForPlaybackMs":I
    const/16 v13, 0x2710

    .line 145
    .local v13, "bufferForPlaybackAfterRebufferMs":I
    new-instance v14, Landroidx/media3/exoplayer/DefaultLoadControl$Builder;

    invoke-direct {v14}, Landroidx/media3/exoplayer/DefaultLoadControl$Builder;-><init>()V

    .line 146
    move/from16 v18, v1

    .end local v1    # "fileId":I
    .local v18, "fileId":I
    new-instance v1, Landroidx/media3/exoplayer/upstream/DefaultAllocator;

    move-wide/from16 v19, v2

    .end local v2    # "fileSize":J
    .local v19, "fileSize":J
    const/high16 v2, 0x10000

    const/4 v3, 0x1

    invoke-direct {v1, v3, v2}, Landroidx/media3/exoplayer/upstream/DefaultAllocator;-><init>(ZI)V

    invoke-virtual {v14, v1}, Landroidx/media3/exoplayer/DefaultLoadControl$Builder;->setAllocator(Landroidx/media3/exoplayer/upstream/DefaultAllocator;)Landroidx/media3/exoplayer/DefaultLoadControl$Builder;

    move-result-object v1

    .line 147
    invoke-virtual {v1, v7, v8, v9, v13}, Landroidx/media3/exoplayer/DefaultLoadControl$Builder;->setBufferDurationsMs(IIII)Landroidx/media3/exoplayer/DefaultLoadControl$Builder;

    move-result-object v1

    .line 148
    invoke-virtual {v1, v3}, Landroidx/media3/exoplayer/DefaultLoadControl$Builder;->setPrioritizeTimeOverSizeThresholds(Z)Landroidx/media3/exoplayer/DefaultLoadControl$Builder;

    move-result-object v1

    .line 149
    invoke-virtual {v1}, Landroidx/media3/exoplayer/DefaultLoadControl$Builder;->build()Landroidx/media3/exoplayer/DefaultLoadControl;

    move-result-object v1

    const-string v2, "build(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 145
    nop

    .line 152
    .local v1, "loadControl":Landroidx/media3/exoplayer/DefaultLoadControl;
    new-instance v3, Landroidx/media3/datasource/DefaultHttpDataSource$Factory;

    invoke-direct {v3}, Landroidx/media3/datasource/DefaultHttpDataSource$Factory;-><init>()V

    .line 153
    const v14, 0xea60

    invoke-virtual {v3, v14}, Landroidx/media3/datasource/DefaultHttpDataSource$Factory;->setConnectTimeoutMs(I)Landroidx/media3/datasource/DefaultHttpDataSource$Factory;

    move-result-object v3

    .line 154
    invoke-virtual {v3, v14}, Landroidx/media3/datasource/DefaultHttpDataSource$Factory;->setReadTimeoutMs(I)Landroidx/media3/datasource/DefaultHttpDataSource$Factory;

    move-result-object v3

    .line 155
    const/4 v14, 0x1

    invoke-virtual {v3, v14}, Landroidx/media3/datasource/DefaultHttpDataSource$Factory;->setAllowCrossProtocolRedirects(Z)Landroidx/media3/datasource/DefaultHttpDataSource$Factory;

    move-result-object v3

    const-string v14, "setAllowCrossProtocolRedirects(...)"

    invoke-static {v3, v14}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 152
    nop

    .line 157
    .local v3, "dataSourceFactory":Landroidx/media3/datasource/DefaultHttpDataSource$Factory;
    new-instance v14, Landroidx/media3/exoplayer/source/DefaultMediaSourceFactory;

    move-object/from16 v21, v4

    .end local v4    # "proxy":Lcom/cineflix/android/ui/player/StreamProxyServer;
    .local v21, "proxy":Lcom/cineflix/android/ui/player/StreamProxyServer;
    move-object v4, v3

    check-cast v4, Landroidx/media3/datasource/DataSource$Factory;

    invoke-direct {v14, v4}, Landroidx/media3/exoplayer/source/DefaultMediaSourceFactory;-><init>(Landroidx/media3/datasource/DataSource$Factory;)V

    move-object v4, v14

    .line 160
    .local v4, "mediaSourceFactory":Landroidx/media3/exoplayer/source/DefaultMediaSourceFactory;
    new-instance v14, Landroidx/media3/exoplayer/DefaultRenderersFactory;

    move-object/from16 v22, v3

    .end local v3    # "dataSourceFactory":Landroidx/media3/datasource/DefaultHttpDataSource$Factory;
    .local v22, "dataSourceFactory":Landroidx/media3/datasource/DefaultHttpDataSource$Factory;
    move-object v3, v0

    check-cast v3, Landroid/content/Context;

    invoke-direct {v14, v3}, Landroidx/media3/exoplayer/DefaultRenderersFactory;-><init>(Landroid/content/Context;)V

    .line 161
    const/4 v3, 0x1

    invoke-virtual {v14, v3}, Landroidx/media3/exoplayer/DefaultRenderersFactory;->setExtensionRendererMode(I)Landroidx/media3/exoplayer/DefaultRenderersFactory;

    move-result-object v14

    const-string v3, "setExtensionRendererMode(...)"

    invoke-static {v14, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 160
    move-object v3, v14

    .line 163
    .local v3, "renderersFactory":Landroidx/media3/exoplayer/DefaultRenderersFactory;
    new-instance v14, Landroidx/media3/exoplayer/ExoPlayer$Builder;

    move/from16 v23, v5

    .end local v5    # "port":I
    .local v23, "port":I
    move-object v5, v0

    check-cast v5, Landroid/content/Context;

    invoke-direct {v14, v5}, Landroidx/media3/exoplayer/ExoPlayer$Builder;-><init>(Landroid/content/Context;)V

    .line 164
    move-object v5, v3

    check-cast v5, Landroidx/media3/exoplayer/RenderersFactory;

    invoke-virtual {v14, v5}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setRenderersFactory(Landroidx/media3/exoplayer/RenderersFactory;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    move-result-object v5

    .line 165
    move-object v14, v4

    check-cast v14, Landroidx/media3/exoplayer/source/MediaSource$Factory;

    invoke-virtual {v5, v14}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setMediaSourceFactory(Landroidx/media3/exoplayer/source/MediaSource$Factory;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    move-result-object v5

    .line 166
    move-object v14, v1

    check-cast v14, Landroidx/media3/exoplayer/LoadControl;

    invoke-virtual {v5, v14}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setLoadControl(Landroidx/media3/exoplayer/LoadControl;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    move-result-object v5

    .line 167
    invoke-virtual {v5}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->build()Landroidx/media3/exoplayer/ExoPlayer;

    move-result-object v5

    invoke-static {v5, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 163
    move-object v2, v5

    .line 169
    .local v2, "exo":Landroidx/media3/exoplayer/ExoPlayer;
    iget-object v5, v0, Lcom/cineflix/android/ui/player/PlayerActivity;->playerView:Landroidx/media3/ui/PlayerView;

    if-nez v5, :cond_6

    goto :goto_1

    :cond_6
    move-object v14, v2

    check-cast v14, Landroidx/media3/common/Player;

    invoke-virtual {v5, v14}, Landroidx/media3/ui/PlayerView;->setPlayer(Landroidx/media3/common/Player;)V

    .line 170
    :goto_1
    iput-object v2, v0, Lcom/cineflix/android/ui/player/PlayerActivity;->player:Landroidx/media3/exoplayer/ExoPlayer;

    .line 172
    invoke-static {v6}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-static {v5}, Landroidx/media3/common/MediaItem;->fromUri(Landroid/net/Uri;)Landroidx/media3/common/MediaItem;

    move-result-object v5

    const-string v14, "fromUri(...)"

    invoke-static {v5, v14}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 173
    .local v5, "mediaItem":Landroidx/media3/common/MediaItem;
    invoke-interface {v2, v5}, Landroidx/media3/exoplayer/ExoPlayer;->setMediaItem(Landroidx/media3/common/MediaItem;)V

    .line 174
    invoke-interface {v2}, Landroidx/media3/exoplayer/ExoPlayer;->prepare()V

    .line 175
    const/4 v14, 0x1

    invoke-interface {v2, v14}, Landroidx/media3/exoplayer/ExoPlayer;->setPlayWhenReady(Z)V

    .line 177
    new-instance v14, Lcom/cineflix/android/ui/player/PlayerActivity$onCreate$2;

    invoke-direct {v14, v0}, Lcom/cineflix/android/ui/player/PlayerActivity$onCreate$2;-><init>(Lcom/cineflix/android/ui/player/PlayerActivity;)V

    check-cast v14, Landroidx/media3/common/Player$Listener;

    invoke-interface {v2, v14}, Landroidx/media3/exoplayer/ExoPlayer;->addListener(Landroidx/media3/common/Player$Listener;)V

    .line 188
    return-void
.end method

.method protected onStop()V
    .locals 0

    .line 191
    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    .line 192
    invoke-direct {p0}, Lcom/cineflix/android/ui/player/PlayerActivity;->cleanup()V

    .line 193
    return-void
.end method
