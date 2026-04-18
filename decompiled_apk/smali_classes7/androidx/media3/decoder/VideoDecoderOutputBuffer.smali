.class public Landroidx/media3/decoder/VideoDecoderOutputBuffer;
.super Landroidx/media3/decoder/DecoderOutputBuffer;
.source "VideoDecoderOutputBuffer.java"


# static fields
.field public static final COLORSPACE_BT2020:I = 0x3

.field public static final COLORSPACE_BT601:I = 0x1

.field public static final COLORSPACE_BT709:I = 0x2

.field public static final COLORSPACE_UNKNOWN:I


# instance fields
.field public colorspace:I

.field public data:Ljava/nio/ByteBuffer;

.field public decoderPrivate:I

.field public format:Landroidx/media3/common/Format;

.field public height:I

.field public mode:I

.field private final owner:Landroidx/media3/decoder/DecoderOutputBuffer$Owner;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/media3/decoder/DecoderOutputBuffer$Owner<",
            "Landroidx/media3/decoder/VideoDecoderOutputBuffer;",
            ">;"
        }
    .end annotation
.end field

.field public supplementalData:Ljava/nio/ByteBuffer;

.field public width:I

.field public yuvPlanes:[Ljava/nio/ByteBuffer;

.field public yuvStrides:[I


# direct methods
.method public constructor <init>(Landroidx/media3/decoder/DecoderOutputBuffer$Owner;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/decoder/DecoderOutputBuffer$Owner<",
            "Landroidx/media3/decoder/VideoDecoderOutputBuffer;",
            ">;)V"
        }
    .end annotation

    .line 67
    .local p1, "owner":Landroidx/media3/decoder/DecoderOutputBuffer$Owner;, "Landroidx/media3/decoder/DecoderOutputBuffer$Owner<Landroidx/media3/decoder/VideoDecoderOutputBuffer;>;"
    invoke-direct {p0}, Landroidx/media3/decoder/DecoderOutputBuffer;-><init>()V

    .line 68
    iput-object p1, p0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->owner:Landroidx/media3/decoder/DecoderOutputBuffer$Owner;

    .line 69
    return-void
.end method

.method private static isSafeToMultiply(II)Z
    .locals 1
    .param p0, "a"    # I
    .param p1, "b"    # I

    .line 172
    if-ltz p0, :cond_1

    if-ltz p1, :cond_1

    if-lez p1, :cond_0

    const v0, 0x7fffffff

    div-int/2addr v0, p1

    if-ge p0, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    :goto_0
    return v0
.end method


# virtual methods
.method public init(JILjava/nio/ByteBuffer;)V
    .locals 2
    .param p1, "timeUs"    # J
    .param p3, "mode"    # I
    .param p4, "supplementalData"    # Ljava/nio/ByteBuffer;

    .line 87
    iput-wide p1, p0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->timeUs:J

    .line 88
    iput p3, p0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->mode:I

    .line 89
    if-eqz p4, :cond_2

    invoke-virtual {p4}, Ljava/nio/ByteBuffer;->hasRemaining()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 90
    const/high16 v0, 0x10000000

    invoke-virtual {p0, v0}, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->addFlag(I)V

    .line 91
    invoke-virtual {p4}, Ljava/nio/ByteBuffer;->limit()I

    move-result v0

    .line 92
    .local v0, "size":I
    iget-object v1, p0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->supplementalData:Ljava/nio/ByteBuffer;

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->capacity()I

    move-result v1

    if-ge v1, v0, :cond_0

    goto :goto_0

    .line 95
    :cond_0
    iget-object v1, p0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->supplementalData:Ljava/nio/ByteBuffer;

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    goto :goto_1

    .line 93
    :cond_1
    :goto_0
    invoke-static {v0}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v1

    iput-object v1, p0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->supplementalData:Ljava/nio/ByteBuffer;

    .line 97
    :goto_1
    iget-object v1, p0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->supplementalData:Ljava/nio/ByteBuffer;

    invoke-virtual {v1, p4}, Ljava/nio/ByteBuffer;->put(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;

    .line 98
    iget-object v1, p0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->supplementalData:Ljava/nio/ByteBuffer;

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 99
    const/4 v1, 0x0

    invoke-virtual {p4, v1}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 100
    .end local v0    # "size":I
    goto :goto_2

    .line 101
    :cond_2
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->supplementalData:Ljava/nio/ByteBuffer;

    .line 103
    :goto_2
    return-void
.end method

.method public initForPrivateFrame(II)V
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I

    .line 163
    iput p1, p0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->width:I

    .line 164
    iput p2, p0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->height:I

    .line 165
    return-void
.end method

.method public initForYuvFrame(IIIII)Z
    .locals 17
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "yStride"    # I
    .param p4, "uvStride"    # I
    .param p5, "colorspace"    # I

    .line 111
    move-object/from16 v0, p0

    move/from16 v1, p2

    move/from16 v2, p3

    move/from16 v3, p4

    move/from16 v4, p1

    iput v4, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->width:I

    .line 112
    iput v1, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->height:I

    .line 113
    move/from16 v5, p5

    iput v5, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->colorspace:I

    .line 114
    int-to-long v6, v1

    const-wide/16 v8, 0x1

    add-long/2addr v6, v8

    const-wide/16 v8, 0x2

    div-long/2addr v6, v8

    long-to-int v6, v6

    .line 115
    .local v6, "uvHeight":I
    invoke-static {v2, v1}, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->isSafeToMultiply(II)Z

    move-result v7

    const/4 v8, 0x0

    if-eqz v7, :cond_7

    invoke-static {v3, v6}, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->isSafeToMultiply(II)Z

    move-result v7

    if-nez v7, :cond_0

    goto/16 :goto_3

    .line 118
    :cond_0
    mul-int v7, v2, v1

    .line 119
    .local v7, "yLength":I
    mul-int v9, v3, v6

    .line 120
    .local v9, "uvLength":I
    mul-int/lit8 v10, v9, 0x2

    add-int/2addr v10, v7

    .line 121
    .local v10, "minimumYuvSize":I
    const/4 v11, 0x2

    invoke-static {v9, v11}, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->isSafeToMultiply(II)Z

    move-result v12

    if-eqz v12, :cond_6

    if-ge v10, v7, :cond_1

    goto :goto_2

    .line 126
    :cond_1
    iget-object v12, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->data:Ljava/nio/ByteBuffer;

    if-eqz v12, :cond_3

    invoke-virtual {v12}, Ljava/nio/ByteBuffer;->capacity()I

    move-result v12

    if-ge v12, v10, :cond_2

    goto :goto_0

    .line 129
    :cond_2
    iget-object v12, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->data:Ljava/nio/ByteBuffer;

    invoke-virtual {v12, v8}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 130
    iget-object v12, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->data:Ljava/nio/ByteBuffer;

    invoke-virtual {v12, v10}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    goto :goto_1

    .line 127
    :cond_3
    :goto_0
    invoke-static {v10}, Ljava/nio/ByteBuffer;->allocateDirect(I)Ljava/nio/ByteBuffer;

    move-result-object v12

    iput-object v12, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->data:Ljava/nio/ByteBuffer;

    .line 133
    :goto_1
    iget-object v12, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->yuvPlanes:[Ljava/nio/ByteBuffer;

    const/4 v13, 0x3

    if-nez v12, :cond_4

    .line 134
    new-array v12, v13, [Ljava/nio/ByteBuffer;

    iput-object v12, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->yuvPlanes:[Ljava/nio/ByteBuffer;

    .line 137
    :cond_4
    iget-object v12, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->data:Ljava/nio/ByteBuffer;

    .line 138
    .local v12, "data":Ljava/nio/ByteBuffer;
    iget-object v14, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->yuvPlanes:[Ljava/nio/ByteBuffer;

    .line 141
    .local v14, "yuvPlanes":[Ljava/nio/ByteBuffer;
    invoke-virtual {v12}, Ljava/nio/ByteBuffer;->slice()Ljava/nio/ByteBuffer;

    move-result-object v15

    aput-object v15, v14, v8

    .line 142
    aget-object v15, v14, v8

    invoke-virtual {v15, v7}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 143
    invoke-virtual {v12, v7}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 144
    invoke-virtual {v12}, Ljava/nio/ByteBuffer;->slice()Ljava/nio/ByteBuffer;

    move-result-object v15

    const/16 v16, 0x1

    aput-object v15, v14, v16

    .line 145
    aget-object v15, v14, v16

    invoke-virtual {v15, v9}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 146
    add-int v15, v7, v9

    invoke-virtual {v12, v15}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 147
    invoke-virtual {v12}, Ljava/nio/ByteBuffer;->slice()Ljava/nio/ByteBuffer;

    move-result-object v15

    aput-object v15, v14, v11

    .line 148
    aget-object v15, v14, v11

    invoke-virtual {v15, v9}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 149
    iget-object v15, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->yuvStrides:[I

    if-nez v15, :cond_5

    .line 150
    new-array v13, v13, [I

    iput-object v13, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->yuvStrides:[I

    .line 152
    :cond_5
    iget-object v13, v0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->yuvStrides:[I

    aput v2, v13, v8

    .line 153
    aput v3, v13, v16

    .line 154
    aput v3, v13, v11

    .line 155
    return v16

    .line 122
    .end local v12    # "data":Ljava/nio/ByteBuffer;
    .end local v14    # "yuvPlanes":[Ljava/nio/ByteBuffer;
    :cond_6
    :goto_2
    return v8

    .line 116
    .end local v7    # "yLength":I
    .end local v9    # "uvLength":I
    .end local v10    # "minimumYuvSize":I
    :cond_7
    :goto_3
    return v8
.end method

.method public release()V
    .locals 1

    .line 73
    iget-object v0, p0, Landroidx/media3/decoder/VideoDecoderOutputBuffer;->owner:Landroidx/media3/decoder/DecoderOutputBuffer$Owner;

    invoke-interface {v0, p0}, Landroidx/media3/decoder/DecoderOutputBuffer$Owner;->releaseOutputBuffer(Landroidx/media3/decoder/DecoderOutputBuffer;)V

    .line 74
    return-void
.end method
