.class public final Lcom/cineflix/android/TelegramEngine$Companion;
.super Ljava/lang/Object;
.source "TelegramEngine.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/cineflix/android/TelegramEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nTelegramEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelegramEngine.kt\ncom/cineflix/android/TelegramEngine$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,567:1\n1#2:568\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"
    }
    d2 = {
        "Lcom/cineflix/android/TelegramEngine$Companion;",
        "",
        "()V",
        "API_HASH",
        "",
        "API_ID",
        "",
        "BOT_USERNAME",
        "INSTANCE",
        "Lcom/cineflix/android/TelegramEngine;",
        "TAG",
        "getInstance",
        "context",
        "Landroid/content/Context;",
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


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    invoke-direct {p0}, Lcom/cineflix/android/TelegramEngine$Companion;-><init>()V

    return-void
.end method


# virtual methods
.method public final getInstance(Landroid/content/Context;)Lcom/cineflix/android/TelegramEngine;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 28
    invoke-static {}, Lcom/cineflix/android/TelegramEngine;->access$getINSTANCE$cp()Lcom/cineflix/android/TelegramEngine;

    move-result-object v0

    if-nez v0, :cond_1

    monitor-enter p0

    const/4 v0, 0x0

    .line 29
    .local v0, "$i$a$-synchronized-TelegramEngine$Companion$getInstance$1":I
    :try_start_0
    invoke-static {}, Lcom/cineflix/android/TelegramEngine;->access$getINSTANCE$cp()Lcom/cineflix/android/TelegramEngine;

    move-result-object v1

    if-nez v1, :cond_0

    new-instance v1, Lcom/cineflix/android/TelegramEngine;

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "getApplicationContext(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/cineflix/android/TelegramEngine;-><init>(Landroid/content/Context;)V

    move-object v2, v1

    .line 568
    .local v2, "it":Lcom/cineflix/android/TelegramEngine;
    const/4 v3, 0x0

    .line 29
    .local v3, "$i$a$-also-TelegramEngine$Companion$getInstance$1$1":I
    sget-object v4, Lcom/cineflix/android/TelegramEngine;->Companion:Lcom/cineflix/android/TelegramEngine$Companion;

    invoke-static {v2}, Lcom/cineflix/android/TelegramEngine;->access$setINSTANCE$cp(Lcom/cineflix/android/TelegramEngine;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 28
    .end local v0    # "$i$a$-synchronized-TelegramEngine$Companion$getInstance$1":I
    .end local v2    # "it":Lcom/cineflix/android/TelegramEngine;
    .end local v3    # "$i$a$-also-TelegramEngine$Companion$getInstance$1$1":I
    :cond_0
    monitor-exit p0

    move-object v0, v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 30
    :cond_1
    :goto_0
    return-object v0
.end method
