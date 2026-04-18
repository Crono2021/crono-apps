.class public final Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;
.super Ljava/lang/Object;
.source "TelegramEngine.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/cineflix/android/TelegramEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "InlineKeyboardListener"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u00c6\u0003J%\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0010\u0008\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b\u00a8\u0006\u0016"
    }
    d2 = {
        "Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;",
        "",
        "chatId",
        "",
        "deferred",
        "Lkotlinx/coroutines/CompletableDeferred;",
        "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
        "(JLkotlinx/coroutines/CompletableDeferred;)V",
        "getChatId",
        "()J",
        "getDeferred",
        "()Lkotlinx/coroutines/CompletableDeferred;",
        "component1",
        "component2",
        "copy",
        "equals",
        "",
        "other",
        "hashCode",
        "",
        "toString",
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


# static fields
.field public static final $stable:I


# instance fields
.field private final chatId:J

.field private final deferred:Lkotlinx/coroutines/CompletableDeferred;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlinx/coroutines/CompletableDeferred<",
            "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0x8

    sput v0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->$stable:I

    return-void
.end method

.method public constructor <init>(JLkotlinx/coroutines/CompletableDeferred;)V
    .locals 1
    .param p1, "chatId"    # J
    .param p3, "deferred"    # Lkotlinx/coroutines/CompletableDeferred;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Lkotlinx/coroutines/CompletableDeferred<",
            "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
            ">;)V"
        }
    .end annotation

    const-string v0, "deferred"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 93
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 94
    iput-wide p1, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->chatId:J

    .line 95
    iput-object p3, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->deferred:Lkotlinx/coroutines/CompletableDeferred;

    .line 93
    return-void
.end method

.method public static synthetic copy$default(Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;JLkotlinx/coroutines/CompletableDeferred;ILjava/lang/Object;)Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;
    .locals 0

    and-int/lit8 p5, p4, 0x1

    if-eqz p5, :cond_0

    iget-wide p1, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->chatId:J

    :cond_0
    and-int/lit8 p4, p4, 0x2

    if-eqz p4, :cond_1

    iget-object p3, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->deferred:Lkotlinx/coroutines/CompletableDeferred;

    :cond_1
    invoke-virtual {p0, p1, p2, p3}, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->copy(JLkotlinx/coroutines/CompletableDeferred;)Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final component1()J
    .locals 2

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->chatId:J

    return-wide v0
.end method

.method public final component2()Lkotlinx/coroutines/CompletableDeferred;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlinx/coroutines/CompletableDeferred<",
            "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->deferred:Lkotlinx/coroutines/CompletableDeferred;

    return-object v0
.end method

.method public final copy(JLkotlinx/coroutines/CompletableDeferred;)Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Lkotlinx/coroutines/CompletableDeferred<",
            "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
            ">;)",
            "Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;"
        }
    .end annotation

    const-string v0, "deferred"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;

    invoke-direct {v0, p1, p2, p3}, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;-><init>(JLkotlinx/coroutines/CompletableDeferred;)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 7

    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    return v0

    :cond_0
    instance-of v1, p1, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;

    const/4 v2, 0x0

    if-nez v1, :cond_1

    return v2

    :cond_1
    move-object v1, p1

    check-cast v1, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;

    iget-wide v3, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->chatId:J

    iget-wide v5, v1, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->chatId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_2

    return v2

    :cond_2
    iget-object v3, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->deferred:Lkotlinx/coroutines/CompletableDeferred;

    iget-object v1, v1, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->deferred:Lkotlinx/coroutines/CompletableDeferred;

    invoke-static {v3, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    return v2

    :cond_3
    return v0
.end method

.method public final getChatId()J
    .locals 2

    .line 94
    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->chatId:J

    return-wide v0
.end method

.method public final getDeferred()Lkotlinx/coroutines/CompletableDeferred;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlinx/coroutines/CompletableDeferred<",
            "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
            ">;"
        }
    .end annotation

    .line 95
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->deferred:Lkotlinx/coroutines/CompletableDeferred;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->chatId:J

    invoke-static {v0, v1}, Ljava/lang/Long;->hashCode(J)I

    move-result v0

    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->deferred:Lkotlinx/coroutines/CompletableDeferred;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    add-int/2addr v1, v2

    return v1
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->chatId:J

    iget-object v2, p0, Lcom/cineflix/android/TelegramEngine$InlineKeyboardListener;->deferred:Lkotlinx/coroutines/CompletableDeferred;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "InlineKeyboardListener(chatId="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", deferred="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
