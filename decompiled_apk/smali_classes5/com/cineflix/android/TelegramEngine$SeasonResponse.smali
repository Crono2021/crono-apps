.class public final Lcom/cineflix/android/TelegramEngine$SeasonResponse;
.super Ljava/lang/Object;
.source "TelegramEngine.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/cineflix/android/TelegramEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "SeasonResponse"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H\u00c6\u0003J7\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\u00a8\u0006\u001d"
    }
    d2 = {
        "Lcom/cineflix/android/TelegramEngine$SeasonResponse;",
        "",
        "messageId",
        "",
        "chatId",
        "text",
        "",
        "buttons",
        "",
        "Lcom/cineflix/android/TelegramEngine$SeasonButton;",
        "(JJLjava/lang/String;Ljava/util/List;)V",
        "getButtons",
        "()Ljava/util/List;",
        "getChatId",
        "()J",
        "getMessageId",
        "getText",
        "()Ljava/lang/String;",
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
.field private final buttons:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$SeasonButton;",
            ">;"
        }
    .end annotation
.end field

.field private final chatId:J

.field private final messageId:J

.field private final text:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0x8

    sput v0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->$stable:I

    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;Ljava/util/List;)V
    .locals 1
    .param p1, "messageId"    # J
    .param p3, "chatId"    # J
    .param p5, "text"    # Ljava/lang/String;
    .param p6, "buttons"    # Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$SeasonButton;",
            ">;)V"
        }
    .end annotation

    const-string v0, "text"

    invoke-static {p5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "buttons"

    invoke-static {p6, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 76
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    iput-wide p1, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->messageId:J

    .line 78
    iput-wide p3, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->chatId:J

    .line 79
    iput-object p5, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->text:Ljava/lang/String;

    .line 80
    iput-object p6, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->buttons:Ljava/util/List;

    .line 76
    return-void
.end method

.method public static synthetic copy$default(Lcom/cineflix/android/TelegramEngine$SeasonResponse;JJLjava/lang/String;Ljava/util/List;ILjava/lang/Object;)Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    .locals 7

    and-int/lit8 p8, p7, 0x1

    if-eqz p8, :cond_0

    iget-wide p1, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->messageId:J

    :cond_0
    move-wide v1, p1

    and-int/lit8 p1, p7, 0x2

    if-eqz p1, :cond_1

    iget-wide p3, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->chatId:J

    :cond_1
    move-wide v3, p3

    and-int/lit8 p1, p7, 0x4

    if-eqz p1, :cond_2

    iget-object p5, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->text:Ljava/lang/String;

    :cond_2
    move-object v5, p5

    and-int/lit8 p1, p7, 0x8

    if-eqz p1, :cond_3

    iget-object p6, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->buttons:Ljava/util/List;

    :cond_3
    move-object v6, p6

    move-object v0, p0

    invoke-virtual/range {v0 .. v6}, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->copy(JJLjava/lang/String;Ljava/util/List;)Lcom/cineflix/android/TelegramEngine$SeasonResponse;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final component1()J
    .locals 2

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->messageId:J

    return-wide v0
.end method

.method public final component2()J
    .locals 2

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->chatId:J

    return-wide v0
.end method

.method public final component3()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->text:Ljava/lang/String;

    return-object v0
.end method

.method public final component4()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$SeasonButton;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->buttons:Ljava/util/List;

    return-object v0
.end method

.method public final copy(JJLjava/lang/String;Ljava/util/List;)Lcom/cineflix/android/TelegramEngine$SeasonResponse;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$SeasonButton;",
            ">;)",
            "Lcom/cineflix/android/TelegramEngine$SeasonResponse;"
        }
    .end annotation

    const-string v0, "text"

    invoke-static {p5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "buttons"

    invoke-static {p6, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;

    move-object v1, v0

    move-wide v2, p1

    move-wide v4, p3

    move-object v6, p5

    move-object v7, p6

    invoke-direct/range {v1 .. v7}, Lcom/cineflix/android/TelegramEngine$SeasonResponse;-><init>(JJLjava/lang/String;Ljava/util/List;)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 7

    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    return v0

    :cond_0
    instance-of v1, p1, Lcom/cineflix/android/TelegramEngine$SeasonResponse;

    const/4 v2, 0x0

    if-nez v1, :cond_1

    return v2

    :cond_1
    move-object v1, p1

    check-cast v1, Lcom/cineflix/android/TelegramEngine$SeasonResponse;

    iget-wide v3, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->messageId:J

    iget-wide v5, v1, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->messageId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_2

    return v2

    :cond_2
    iget-wide v3, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->chatId:J

    iget-wide v5, v1, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->chatId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_3

    return v2

    :cond_3
    iget-object v3, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->text:Ljava/lang/String;

    iget-object v4, v1, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->text:Ljava/lang/String;

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    return v2

    :cond_4
    iget-object v3, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->buttons:Ljava/util/List;

    iget-object v1, v1, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->buttons:Ljava/util/List;

    invoke-static {v3, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_5

    return v2

    :cond_5
    return v0
.end method

.method public final getButtons()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/cineflix/android/TelegramEngine$SeasonButton;",
            ">;"
        }
    .end annotation

    .line 80
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->buttons:Ljava/util/List;

    return-object v0
.end method

.method public final getChatId()J
    .locals 2

    .line 78
    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->chatId:J

    return-wide v0
.end method

.method public final getMessageId()J
    .locals 2

    .line 77
    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->messageId:J

    return-wide v0
.end method

.method public final getText()Ljava/lang/String;
    .locals 1

    .line 79
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->text:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->messageId:J

    invoke-static {v0, v1}, Ljava/lang/Long;->hashCode(J)I

    move-result v0

    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->chatId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->hashCode(J)I

    move-result v2

    add-int/2addr v1, v2

    mul-int/lit8 v0, v1, 0x1f

    iget-object v2, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->text:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->buttons:Ljava/util/List;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    add-int/2addr v1, v2

    return v1
.end method

.method public toString()Ljava/lang/String;
    .locals 8

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->messageId:J

    iget-wide v2, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->chatId:J

    iget-object v4, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->text:Ljava/lang/String;

    iget-object v5, p0, Lcom/cineflix/android/TelegramEngine$SeasonResponse;->buttons:Ljava/util/List;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "SeasonResponse(messageId="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", chatId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", text="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", buttons="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
