.class public final Lcom/cineflix/android/TelegramEngine$FileState;
.super Ljava/lang/Object;
.source "TelegramEngine.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/cineflix/android/TelegramEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "FileState"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J;\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\t2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\t\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\u00a8\u0006\u001d"
    }
    d2 = {
        "Lcom/cineflix/android/TelegramEngine$FileState;",
        "",
        "path",
        "",
        "downloadedPrefixSize",
        "",
        "downloadedSize",
        "expectedSize",
        "isCompleted",
        "",
        "(Ljava/lang/String;JJJZ)V",
        "getDownloadedPrefixSize",
        "()J",
        "getDownloadedSize",
        "getExpectedSize",
        "()Z",
        "getPath",
        "()Ljava/lang/String;",
        "component1",
        "component2",
        "component3",
        "component4",
        "component5",
        "copy",
        "equals",
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
.field private final downloadedPrefixSize:J

.field private final downloadedSize:J

.field private final expectedSize:J

.field private final isCompleted:Z

.field private final path:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJJZ)V
    .locals 1
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "downloadedPrefixSize"    # J
    .param p4, "downloadedSize"    # J
    .param p6, "expectedSize"    # J
    .param p8, "isCompleted"    # Z

    const-string v0, "path"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 410
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 411
    iput-object p1, p0, Lcom/cineflix/android/TelegramEngine$FileState;->path:Ljava/lang/String;

    .line 412
    iput-wide p2, p0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedPrefixSize:J

    .line 413
    iput-wide p4, p0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedSize:J

    .line 414
    iput-wide p6, p0, Lcom/cineflix/android/TelegramEngine$FileState;->expectedSize:J

    .line 415
    iput-boolean p8, p0, Lcom/cineflix/android/TelegramEngine$FileState;->isCompleted:Z

    .line 410
    return-void
.end method

.method public static synthetic copy$default(Lcom/cineflix/android/TelegramEngine$FileState;Ljava/lang/String;JJJZILjava/lang/Object;)Lcom/cineflix/android/TelegramEngine$FileState;
    .locals 9

    move-object v0, p0

    and-int/lit8 v1, p9, 0x1

    if-eqz v1, :cond_0

    iget-object v1, v0, Lcom/cineflix/android/TelegramEngine$FileState;->path:Ljava/lang/String;

    goto :goto_0

    :cond_0
    move-object v1, p1

    :goto_0
    and-int/lit8 v2, p9, 0x2

    if-eqz v2, :cond_1

    iget-wide v2, v0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedPrefixSize:J

    goto :goto_1

    :cond_1
    move-wide v2, p2

    :goto_1
    and-int/lit8 v4, p9, 0x4

    if-eqz v4, :cond_2

    iget-wide v4, v0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedSize:J

    goto :goto_2

    :cond_2
    move-wide v4, p4

    :goto_2
    and-int/lit8 v6, p9, 0x8

    if-eqz v6, :cond_3

    iget-wide v6, v0, Lcom/cineflix/android/TelegramEngine$FileState;->expectedSize:J

    goto :goto_3

    :cond_3
    move-wide v6, p6

    :goto_3
    and-int/lit8 v8, p9, 0x10

    if-eqz v8, :cond_4

    iget-boolean v8, v0, Lcom/cineflix/android/TelegramEngine$FileState;->isCompleted:Z

    goto :goto_4

    :cond_4
    move/from16 v8, p8

    :goto_4
    move-object p1, v1

    move-wide p2, v2

    move-wide p4, v4

    move-wide p6, v6

    move/from16 p8, v8

    invoke-virtual/range {p0 .. p8}, Lcom/cineflix/android/TelegramEngine$FileState;->copy(Ljava/lang/String;JJJZ)Lcom/cineflix/android/TelegramEngine$FileState;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public final component1()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$FileState;->path:Ljava/lang/String;

    return-object v0
.end method

.method public final component2()J
    .locals 2

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedPrefixSize:J

    return-wide v0
.end method

.method public final component3()J
    .locals 2

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedSize:J

    return-wide v0
.end method

.method public final component4()J
    .locals 2

    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$FileState;->expectedSize:J

    return-wide v0
.end method

.method public final component5()Z
    .locals 1

    iget-boolean v0, p0, Lcom/cineflix/android/TelegramEngine$FileState;->isCompleted:Z

    return v0
.end method

.method public final copy(Ljava/lang/String;JJJZ)Lcom/cineflix/android/TelegramEngine$FileState;
    .locals 11

    const-string v0, "path"

    move-object v10, p1

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lcom/cineflix/android/TelegramEngine$FileState;

    move-object v1, v0

    move-object v2, p1

    move-wide v3, p2

    move-wide v5, p4

    move-wide/from16 v7, p6

    move/from16 v9, p8

    invoke-direct/range {v1 .. v9}, Lcom/cineflix/android/TelegramEngine$FileState;-><init>(Ljava/lang/String;JJJZ)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 7

    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    return v0

    :cond_0
    instance-of v1, p1, Lcom/cineflix/android/TelegramEngine$FileState;

    const/4 v2, 0x0

    if-nez v1, :cond_1

    return v2

    :cond_1
    move-object v1, p1

    check-cast v1, Lcom/cineflix/android/TelegramEngine$FileState;

    iget-object v3, p0, Lcom/cineflix/android/TelegramEngine$FileState;->path:Ljava/lang/String;

    iget-object v4, v1, Lcom/cineflix/android/TelegramEngine$FileState;->path:Ljava/lang/String;

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    return v2

    :cond_2
    iget-wide v3, p0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedPrefixSize:J

    iget-wide v5, v1, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedPrefixSize:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_3

    return v2

    :cond_3
    iget-wide v3, p0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedSize:J

    iget-wide v5, v1, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedSize:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_4

    return v2

    :cond_4
    iget-wide v3, p0, Lcom/cineflix/android/TelegramEngine$FileState;->expectedSize:J

    iget-wide v5, v1, Lcom/cineflix/android/TelegramEngine$FileState;->expectedSize:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_5

    return v2

    :cond_5
    iget-boolean v3, p0, Lcom/cineflix/android/TelegramEngine$FileState;->isCompleted:Z

    iget-boolean v1, v1, Lcom/cineflix/android/TelegramEngine$FileState;->isCompleted:Z

    if-eq v3, v1, :cond_6

    return v2

    :cond_6
    return v0
.end method

.method public final getDownloadedPrefixSize()J
    .locals 2

    .line 412
    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedPrefixSize:J

    return-wide v0
.end method

.method public final getDownloadedSize()J
    .locals 2

    .line 413
    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedSize:J

    return-wide v0
.end method

.method public final getExpectedSize()J
    .locals 2

    .line 414
    iget-wide v0, p0, Lcom/cineflix/android/TelegramEngine$FileState;->expectedSize:J

    return-wide v0
.end method

.method public final getPath()Ljava/lang/String;
    .locals 1

    .line 411
    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$FileState;->path:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$FileState;->path:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedPrefixSize:J

    invoke-static {v2, v3}, Ljava/lang/Long;->hashCode(J)I

    move-result v2

    add-int/2addr v1, v2

    mul-int/lit8 v0, v1, 0x1f

    iget-wide v2, p0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedSize:J

    invoke-static {v2, v3}, Ljava/lang/Long;->hashCode(J)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lcom/cineflix/android/TelegramEngine$FileState;->expectedSize:J

    invoke-static {v2, v3}, Ljava/lang/Long;->hashCode(J)I

    move-result v2

    add-int/2addr v1, v2

    mul-int/lit8 v0, v1, 0x1f

    iget-boolean v2, p0, Lcom/cineflix/android/TelegramEngine$FileState;->isCompleted:Z

    invoke-static {v2}, Ljava/lang/Boolean;->hashCode(Z)I

    move-result v2

    add-int/2addr v0, v2

    return v0
.end method

.method public final isCompleted()Z
    .locals 1

    .line 415
    iget-boolean v0, p0, Lcom/cineflix/android/TelegramEngine$FileState;->isCompleted:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 10

    iget-object v0, p0, Lcom/cineflix/android/TelegramEngine$FileState;->path:Ljava/lang/String;

    iget-wide v1, p0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedPrefixSize:J

    iget-wide v3, p0, Lcom/cineflix/android/TelegramEngine$FileState;->downloadedSize:J

    iget-wide v5, p0, Lcom/cineflix/android/TelegramEngine$FileState;->expectedSize:J

    iget-boolean v7, p0, Lcom/cineflix/android/TelegramEngine$FileState;->isCompleted:Z

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "FileState(path="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v8, ", downloadedPrefixSize="

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", downloadedSize="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", expectedSize="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", isCompleted="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
