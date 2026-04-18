.class public final Lcom/cineflix/android/TelegramEngine$MsgCollector;
.super Ljava/lang/Object;
.source "TelegramEngine.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/cineflix/android/TelegramEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "MsgCollector"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J7\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u001a\u0010\u0008\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000b\"\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\u00a8\u0006\u001e"
    }
    d2 = {
        "Lcom/cineflix/android/TelegramEngine$MsgCollector;",
        "",
        "chatId",
        "",
        "afterMsgId",
        "videos",
        "",
        "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
        "lastReceived",
        "(JJLjava/util/List;J)V",
        "getAfterMsgId",
        "()J",
        "getChatId",
        "getLastReceived",
        "setLastReceived",
        "(J)V",
        "getVideos",
        "()Ljava/util/List;",
        "component1",
        "component2",
        "component3",
        "component4",
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
.field private final afterMsgId:J

.field private final chatId:J

.field private volatile lastReceived:J

.field private final videos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0x8

    sput v0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->$stable:I

    return-void
.end method

.method public constructor <init>(JJLjava/util/List;J)V
    .locals 1
    .param p1, "chatId"    # J
    .param p3, "afterMsgId"    # J
    .param p5, "videos"    # Ljava/util/List;
    .param p6, "lastReceived"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ",
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
            ">;J)V"
        }
    .end annotation

    const-string v0, "videos"

    invoke-static {p5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    iput-wide p1, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->chatId:J

    .line 60
    iput-wide p3, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->afterMsgId:J

    .line 61
    iput-object p5, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->videos:Ljava/util/List;

    .line 62
    iput-wide p6, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->lastReceived:J

    .line 58
    return-void
.end method

.method public synthetic constructor <init>(JJLjava/util/List;JILkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 9

    .line 58
    and-int/lit8 v0, p8, 0x4

    if-eqz v0, :cond_0

    .line 61
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast v0, Ljava/util/List;

    move-object v6, v0

    goto :goto_0

    .line 58
    :cond_0
    move-object v6, p5

    :goto_0
    and-int/lit8 v0, p8, 0x8

    if-eqz v0, :cond_1

    .line 62
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    move-wide v7, v0

    goto :goto_1

    .line 58
    :cond_1
    move-wide v7, p6

    :goto_1
    move-object v1, p0

    move-wide v2, p1

    move-wide v4, p3

    invoke-direct/range {v1 .. v8}, Lcom/cineflix/android/TelegramEngine$MsgCollector;-><init>(JJLjava/util/List;J)V

    .line 63
    return-void
.end method

.method public static synthetic copy$default(Lcom/cineflix/android/TelegramEngine$MsgCollector;JJLjava/util/List;JILjava/lang/Object;)Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .locals 8

    move-object v0, p0

    and-int/lit8 v1, p8, 0x1

    if-eqz v1, :cond_0

    iget-wide v1, v0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->chatId:J

    goto :goto_0

    :cond_0
    move-wide v1, p1

    :goto_0
    and-int/lit8 v3, p8, 0x2

    if-eqz v3, :cond_1

    iget-wide v3, v0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->afterMsgId:J

    goto :goto_1

    :cond_1
    move-wide v3, p3

    :goto_1
    and-int/lit8 v5, p8, 0x4

    if-eqz v5, :cond_2

    iget-object v5, v0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->videos:Ljava/util/List;

    goto :goto_2

    :cond_2
    move-object v5, p5

    :goto_2
    and-int/lit8 v6, p8, 0x8

    if-eqz v6, :cond_3

    iget-wide v6, v0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->lastReceived:J

    goto :goto_3

    :cond_3
    move-wide v6, p6

    :goto_3
    move-wide p1, v1

    move-wide p3, v3

    move-object p5, v5

    move-wide p6, v6

    invoke-virtual/range {p0 .. p7}, Lcom/cineflix/android/TelegramEngine$MsgCollector;->copy(JJLjava/util/List;J)Lcom/cineflix/android/TelegramEngine$MsgCollector;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public final component1()J
    .locals 2

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->chatId:J

    return-wide v0
.end method

.method public final component2()J
    .locals 2

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->afterMsgId:J

    return-wide v0
.end method

.method public final component3()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->videos:Ljava/util/List;

    return-object v0
.end method

.method public final component4()J
    .locals 2

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->lastReceived:J

    return-wide v0
.end method

.method public final copy(JJLjava/util/List;J)Lcom/cineflix/android/TelegramEngine$MsgCollector;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ",
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
            ">;J)",
            "Lcom/cineflix/android/TelegramEngine$MsgCollector;"
        }
    .end annotation

    const-string v0, "videos"

    move-object v9, p5

    invoke-static {p5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lcom/cineflix/android/TelegramEngine$MsgCollector;

    move-object v1, v0

    move-wide v2, p1

    move-wide v4, p3

    move-object v6, p5

    move-wide/from16 v7, p6

    invoke-direct/range {v1 .. v8}, Lcom/cineflix/android/TelegramEngine$MsgCollector;-><init>(JJLjava/util/List;J)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 7

    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    return v0

    :cond_0
    instance-of v1, p1, Lcom/cineflix/android/TelegramEngine$MsgCollector;

    const/4 v2, 0x0

    if-nez v1, :cond_1

    return v2

    :cond_1
    move-object v1, p1

    check-cast v1, Lcom/cineflix/android/TelegramEngine$MsgCollector;

    iget-wide v3, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->chatId:J

    iget-wide v5, v1, Lcom/cineflix/android/TelegramEngine$MsgCollector;->chatId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_2

    return v2

    :cond_2
    iget-wide v3, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->afterMsgId:J

    iget-wide v5, v1, Lcom/cineflix/android/TelegramEngine$MsgCollector;->afterMsgId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_3

    return v2

    :cond_3
    iget-object v3, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->videos:Ljava/util/List;

    iget-object v4, v1, Lcom/cineflix/android/TelegramEngine$MsgCollector;->videos:Ljava/util/List;

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    return v2

    :cond_4
    iget-wide v3, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->lastReceived:J

    iget-wide v5, v1, Lcom/cineflix/android/TelegramEngine$MsgCollector;->lastReceived:J

    cmp-long v1, v3, v5

    if-eqz v1, :cond_5

    return v2

    :cond_5
    return v0
.end method

.method public final getAfterMsgId()J
    .locals 2

    .line 60
    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->afterMsgId:J

    return-wide v0
.end method

.method public final getChatId()J
    .locals 2

    .line 59
    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->chatId:J

    return-wide v0
.end method

.method public final getLastReceived()J
    .locals 2

    .line 62
    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->lastReceived:J

    return-wide v0
.end method

.method public final getVideos()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$VideoInfo;",
            ">;"
        }
    .end annotation

    .line 61
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->videos:Ljava/util/List;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->chatId:J

    invoke-static {v0, v1}, Ljava/lang/Long;->hashCode(J)I

    move-result v0

    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->afterMsgId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->hashCode(J)I

    move-result v2

    add-int/2addr v1, v2

    mul-int/lit8 v0, v1, 0x1f

    iget-object v2, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->videos:Ljava/util/List;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->lastReceived:J

    invoke-static {v2, v3}, Ljava/lang/Long;->hashCode(J)I

    move-result v2

    add-int/2addr v1, v2

    return v1
.end method

.method public final setLastReceived(J)V
    .locals 0
    .param p1, "<set-?>"    # J

    .line 62
    iput-wide p1, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->lastReceived:J

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 9

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->chatId:J

    iget-wide v2, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->afterMsgId:J

    iget-object v4, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->videos:Ljava/util/List;

    iget-wide v5, p0, Lcom/cineflix/android/TelegramEngine$MsgCollector;->lastReceived:J

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "MsgCollector(chatId="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", afterMsgId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", videos="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", lastReceived="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
