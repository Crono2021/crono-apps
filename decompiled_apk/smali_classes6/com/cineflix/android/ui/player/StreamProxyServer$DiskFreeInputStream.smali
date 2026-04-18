.class final Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;
.super Ljava/io/InputStream;
.source "StreamProxyServer.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/cineflix/android/ui/player/StreamProxyServer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "DiskFreeInputStream"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u0012\n\u0002\u0008\u0008\u0008\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\nJ(\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0008\u0010\u0015\u001a\u00020\u0005H\u0016J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"
    }
    d2 = {
        "Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;",
        "Ljava/io/InputStream;",
        "engine",
        "Lcom/cineflix/android/TelegramEngine;",
        "fileId",
        "",
        "startOffset",
        "",
        "lengthRequested",
        "totalFileSize",
        "(Lcom/cineflix/android/TelegramEngine;IJJJ)V",
        "currentPosition",
        "endPosition",
        "prefetchBuffer",
        "",
        "prefetchOffset",
        "deliverFromChunk",
        "chunk",
        "b",
        "off",
        "len",
        "read",
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
.field private currentPosition:J

.field private final endPosition:J

.field private final engine:Lcom/cineflix/android/TelegramEngine;

.field private final fileId:I

.field private final lengthRequested:J

.field private prefetchBuffer:[B

.field private prefetchOffset:J

.field private final startOffset:J

.field private final totalFileSize:J


# direct methods
.method public constructor <init>(Lcom/cineflix/android/TelegramEngine;IJJJ)V
    .locals 2
    .param p1, "engine"    # Lcom/cineflix/android/TelegramEngine;
    .param p2, "fileId"    # I
    .param p3, "startOffset"    # J
    .param p5, "lengthRequested"    # J
    .param p7, "totalFileSize"    # J

    const-string v0, "engine"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 108
    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 103
    iput-object p1, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->engine:Lcom/cineflix/android/TelegramEngine;

    .line 104
    iput p2, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->fileId:I

    .line 105
    iput-wide p3, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->startOffset:J

    .line 106
    iput-wide p5, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->lengthRequested:J

    .line 107
    iput-wide p7, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->totalFileSize:J

    .line 110
    iput-wide p3, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    .line 111
    add-long v0, p3, p5

    iput-wide v0, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->endPosition:J

    .line 115
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->prefetchOffset:J

    .line 102
    return-void
.end method

.method private final deliverFromChunk([B[BII)I
    .locals 5
    .param p1, "chunk"    # [B
    .param p2, "b"    # [B
    .param p3, "off"    # I
    .param p4, "len"    # I

    .line 172
    iput-object p1, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->prefetchBuffer:[B

    .line 173
    iget-wide v0, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    iput-wide v0, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->prefetchOffset:J

    .line 174
    array-length v0, p1

    invoke-static {p4, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 175
    .local v0, "toRead":I
    const/4 v1, 0x0

    invoke-static {p1, v1, p2, p3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 176
    iget-wide v1, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    int-to-long v3, v0

    add-long/2addr v1, v3

    iput-wide v1, p0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    .line 177
    return v0
.end method


# virtual methods
.method public read()I
    .locals 4

    .line 118
    const/4 v0, 0x1

    new-array v1, v0, [B

    .line 119
    .local v1, "b":[B
    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2, v0}, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->read([BII)I

    move-result v0

    const/4 v3, -0x1

    if-ne v0, v3, :cond_0

    goto :goto_0

    :cond_0
    aget-byte v0, v1, v2

    and-int/lit16 v3, v0, 0xff

    :goto_0
    return v3
.end method

.method public read([BII)I
    .locals 22
    .param p1, "b"    # [B
    .param p2, "off"    # I
    .param p3, "len"    # I

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, p2

    move/from16 v3, p3

    const-string v4, "b"

    invoke-static {v1, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 123
    iget-wide v4, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    iget-wide v6, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->endPosition:J

    cmp-long v6, v4, v6

    const/4 v7, -0x1

    if-ltz v6, :cond_0

    return v7

    .line 126
    :cond_0
    iget-object v6, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->prefetchBuffer:[B

    .line 127
    .local v6, "pb":[B
    if-eqz v6, :cond_1

    .line 128
    iget-wide v8, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->prefetchOffset:J

    cmp-long v10, v4, v8

    if-ltz v10, :cond_1

    .line 129
    array-length v10, v6

    int-to-long v10, v10

    add-long/2addr v10, v8

    cmp-long v10, v4, v10

    if-gez v10, :cond_1

    .line 131
    sub-long/2addr v4, v8

    long-to-int v4, v4

    .line 132
    .local v4, "bufferIdx":I
    array-length v5, v6

    sub-int/2addr v5, v4

    .line 133
    .local v5, "available":I
    invoke-static {v3, v5}, Ljava/lang/Math;->min(II)I

    move-result v7

    .line 134
    .local v7, "toRead":I
    invoke-static {v6, v4, v1, v2, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 135
    iget-wide v8, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    int-to-long v10, v7

    add-long/2addr v8, v10

    iput-wide v8, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    .line 136
    return v7

    .line 140
    .end local v4    # "bufferIdx":I
    .end local v5    # "available":I
    .end local v7    # "toRead":I
    :cond_1
    nop

    .line 141
    int-to-long v4, v3

    const-wide/32 v8, 0x200000

    invoke-static {v4, v5, v8, v9}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v4

    .line 142
    iget-wide v8, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->endPosition:J

    iget-wide v10, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    sub-long/2addr v8, v10

    invoke-static {v4, v5, v8, v9}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v14

    .line 140
    nop

    .line 146
    .local v14, "toFetch":J
    iget-object v10, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->engine:Lcom/cineflix/android/TelegramEngine;

    iget v11, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->fileId:I

    iget-wide v12, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    invoke-virtual/range {v10 .. v15}, Lcom/cineflix/android/TelegramEngine;->readFilePartSync(IJJ)[B

    move-result-object v4

    .line 147
    .local v4, "fastChunk":[B
    const/4 v5, 0x0

    const/4 v8, 0x1

    if-eqz v4, :cond_3

    array-length v9, v4

    if-nez v9, :cond_2

    move v9, v8

    goto :goto_0

    :cond_2
    move v9, v5

    :goto_0
    xor-int/2addr v9, v8

    if-eqz v9, :cond_3

    .line 148
    invoke-direct {v0, v4, v1, v2, v3}, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->deliverFromChunk([B[BII)I

    move-result v5

    return v5

    .line 154
    :cond_3
    iget-object v9, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->engine:Lcom/cineflix/android/TelegramEngine;

    iget v10, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->fileId:I

    iget-wide v11, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    move-object/from16 v16, v9

    move/from16 v17, v10

    move-wide/from16 v18, v11

    move-wide/from16 v20, v14

    invoke-virtual/range {v16 .. v21}, Lcom/cineflix/android/TelegramEngine;->downloadRangeAndRead(IJJ)[B

    move-result-object v9

    .line 155
    .local v9, "syncChunk":[B
    if-eqz v9, :cond_5

    array-length v10, v9

    if-nez v10, :cond_4

    move v10, v8

    goto :goto_1

    :cond_4
    move v10, v5

    :goto_1
    xor-int/2addr v8, v10

    if-eqz v8, :cond_5

    .line 156
    invoke-direct {v0, v9, v1, v2, v3}, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->deliverFromChunk([B[BII)I

    move-result v5

    return v5

    .line 160
    :cond_5
    iget-object v8, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->engine:Lcom/cineflix/android/TelegramEngine;

    iget v10, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->fileId:I

    invoke-virtual {v8, v10}, Lcom/cineflix/android/TelegramEngine;->getFileStateFlow(I)Lkotlinx/coroutines/flow/StateFlow;

    move-result-object v8

    invoke-interface {v8}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/cineflix/android/TelegramEngine$FileState;

    .line 161
    .local v8, "state":Lcom/cineflix/android/TelegramEngine$FileState;
    const-string v10, "StreamProxy"

    if-eqz v8, :cond_6

    invoke-virtual {v8}, Lcom/cineflix/android/TelegramEngine$FileState;->isCompleted()Z

    move-result v11

    if-eqz v11, :cond_6

    iget-wide v11, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    invoke-virtual {v8}, Lcom/cineflix/android/TelegramEngine$FileState;->getExpectedSize()J

    move-result-wide v16

    cmp-long v11, v11, v16

    if-ltz v11, :cond_6

    .line 162
    iget-wide v11, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "EOF reached at position="

    invoke-virtual {v5, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v11, v12}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v10, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 163
    return v7

    .line 167
    :cond_6
    iget-wide v11, v0, Lcom/cineflix/android/ui/player/StreamProxyServer$DiskFreeInputStream;->currentPosition:J

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "Transient fetch failure at position="

    invoke-virtual {v7, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v11, v12}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v11, ", returning 0"

    invoke-virtual {v7, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v10, v7}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 168
    return v5
.end method
