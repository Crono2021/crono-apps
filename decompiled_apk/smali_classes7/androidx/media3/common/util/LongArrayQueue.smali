.class public final Landroidx/media3/common/util/LongArrayQueue;
.super Ljava/lang/Object;
.source "LongArrayQueue.java"


# static fields
.field public static final DEFAULT_INITIAL_CAPACITY:I = 0x10


# instance fields
.field private data:[J

.field private headIndex:I

.field private size:I

.field private tailIndex:I

.field private wrapAroundMask:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 43
    const/16 v0, 0x10

    invoke-direct {p0, v0}, Landroidx/media3/common/util/LongArrayQueue;-><init>(I)V

    .line 44
    return-void
.end method

.method public constructor <init>(I)V
    .locals 3
    .param p1, "minCapacity"    # I

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    const/4 v0, 0x0

    const/4 v1, 0x1

    if-ltz p1, :cond_0

    const/high16 v2, 0x40000000    # 2.0f

    if-gt p1, v2, :cond_0

    move v2, v1

    goto :goto_0

    :cond_0
    move v2, v0

    :goto_0
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 53
    if-nez p1, :cond_1

    move v2, v1

    goto :goto_1

    :cond_1
    move v2, p1

    :goto_1
    move p1, v2

    .line 55
    invoke-static {p1}, Ljava/lang/Integer;->bitCount(I)I

    move-result v2

    if-eq v2, v1, :cond_2

    .line 56
    add-int/lit8 v2, p1, -0x1

    invoke-static {v2}, Ljava/lang/Integer;->highestOneBit(I)I

    move-result v2

    shl-int/lit8 p1, v2, 0x1

    .line 58
    :cond_2
    iput v0, p0, Landroidx/media3/common/util/LongArrayQueue;->headIndex:I

    .line 59
    const/4 v2, -0x1

    iput v2, p0, Landroidx/media3/common/util/LongArrayQueue;->tailIndex:I

    .line 60
    iput v0, p0, Landroidx/media3/common/util/LongArrayQueue;->size:I

    .line 61
    new-array v0, p1, [J

    iput-object v0, p0, Landroidx/media3/common/util/LongArrayQueue;->data:[J

    .line 62
    array-length v0, v0

    sub-int/2addr v0, v1

    iput v0, p0, Landroidx/media3/common/util/LongArrayQueue;->wrapAroundMask:I

    .line 63
    return-void
.end method

.method private doubleArraySize()V
    .locals 7

    .line 130
    iget-object v0, p0, Landroidx/media3/common/util/LongArrayQueue;->data:[J

    array-length v1, v0

    shl-int/lit8 v1, v1, 0x1

    .line 131
    .local v1, "newCapacity":I
    if-ltz v1, :cond_0

    .line 135
    new-array v2, v1, [J

    .line 136
    .local v2, "newData":[J
    array-length v3, v0

    iget v4, p0, Landroidx/media3/common/util/LongArrayQueue;->headIndex:I

    sub-int/2addr v3, v4

    .line 137
    .local v3, "itemsToRight":I
    iget v5, p0, Landroidx/media3/common/util/LongArrayQueue;->headIndex:I

    .line 138
    .local v5, "itemsToLeft":I
    const/4 v6, 0x0

    invoke-static {v0, v4, v2, v6, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 139
    iget-object v0, p0, Landroidx/media3/common/util/LongArrayQueue;->data:[J

    invoke-static {v0, v6, v2, v3, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 141
    iput v6, p0, Landroidx/media3/common/util/LongArrayQueue;->headIndex:I

    .line 142
    iget v0, p0, Landroidx/media3/common/util/LongArrayQueue;->size:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Landroidx/media3/common/util/LongArrayQueue;->tailIndex:I

    .line 143
    iput-object v2, p0, Landroidx/media3/common/util/LongArrayQueue;->data:[J

    .line 144
    array-length v0, v2

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Landroidx/media3/common/util/LongArrayQueue;->wrapAroundMask:I

    .line 145
    return-void

    .line 132
    .end local v2    # "newData":[J
    .end local v3    # "itemsToRight":I
    .end local v5    # "itemsToLeft":I
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method


# virtual methods
.method public add(J)V
    .locals 2
    .param p1, "value"    # J

    .line 67
    iget v0, p0, Landroidx/media3/common/util/LongArrayQueue;->size:I

    iget-object v1, p0, Landroidx/media3/common/util/LongArrayQueue;->data:[J

    array-length v1, v1

    if-ne v0, v1, :cond_0

    .line 68
    invoke-direct {p0}, Landroidx/media3/common/util/LongArrayQueue;->doubleArraySize()V

    .line 71
    :cond_0
    iget v0, p0, Landroidx/media3/common/util/LongArrayQueue;->tailIndex:I

    add-int/lit8 v0, v0, 0x1

    iget v1, p0, Landroidx/media3/common/util/LongArrayQueue;->wrapAroundMask:I

    and-int/2addr v0, v1

    iput v0, p0, Landroidx/media3/common/util/LongArrayQueue;->tailIndex:I

    .line 72
    iget-object v1, p0, Landroidx/media3/common/util/LongArrayQueue;->data:[J

    aput-wide p1, v1, v0

    .line 73
    iget v0, p0, Landroidx/media3/common/util/LongArrayQueue;->size:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/media3/common/util/LongArrayQueue;->size:I

    .line 74
    return-void
.end method

.method capacity()I
    .locals 1

    .line 126
    iget-object v0, p0, Landroidx/media3/common/util/LongArrayQueue;->data:[J

    array-length v0, v0

    return v0
.end method

.method public clear()V
    .locals 2

    .line 118
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/common/util/LongArrayQueue;->headIndex:I

    .line 119
    const/4 v1, -0x1

    iput v1, p0, Landroidx/media3/common/util/LongArrayQueue;->tailIndex:I

    .line 120
    iput v0, p0, Landroidx/media3/common/util/LongArrayQueue;->size:I

    .line 121
    return-void
.end method

.method public element()J
    .locals 3

    .line 99
    iget v0, p0, Landroidx/media3/common/util/LongArrayQueue;->size:I

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Landroidx/media3/common/util/LongArrayQueue;->data:[J

    iget v1, p0, Landroidx/media3/common/util/LongArrayQueue;->headIndex:I

    aget-wide v1, v0, v1

    return-wide v1

    .line 100
    :cond_0
    new-instance v0, Ljava/util/NoSuchElementException;

    invoke-direct {v0}, Ljava/util/NoSuchElementException;-><init>()V

    throw v0
.end method

.method public isEmpty()Z
    .locals 1

    .line 113
    iget v0, p0, Landroidx/media3/common/util/LongArrayQueue;->size:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public remove()J
    .locals 5

    .line 82
    iget v0, p0, Landroidx/media3/common/util/LongArrayQueue;->size:I

    if-eqz v0, :cond_0

    .line 86
    iget-object v1, p0, Landroidx/media3/common/util/LongArrayQueue;->data:[J

    iget v2, p0, Landroidx/media3/common/util/LongArrayQueue;->headIndex:I

    aget-wide v3, v1, v2

    .line 87
    .local v3, "value":J
    add-int/lit8 v2, v2, 0x1

    iget v1, p0, Landroidx/media3/common/util/LongArrayQueue;->wrapAroundMask:I

    and-int/2addr v1, v2

    iput v1, p0, Landroidx/media3/common/util/LongArrayQueue;->headIndex:I

    .line 88
    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Landroidx/media3/common/util/LongArrayQueue;->size:I

    .line 90
    return-wide v3

    .line 83
    .end local v3    # "value":J
    :cond_0
    new-instance v0, Ljava/util/NoSuchElementException;

    invoke-direct {v0}, Ljava/util/NoSuchElementException;-><init>()V

    throw v0
.end method

.method public size()I
    .locals 1

    .line 108
    iget v0, p0, Landroidx/media3/common/util/LongArrayQueue;->size:I

    return v0
.end method
