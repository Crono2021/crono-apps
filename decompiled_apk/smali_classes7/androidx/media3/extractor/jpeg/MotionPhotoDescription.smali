.class final Landroidx/media3/extractor/jpeg/MotionPhotoDescription;
.super Ljava/lang/Object;
.source "MotionPhotoDescription.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/jpeg/MotionPhotoDescription$ContainerItem;
    }
.end annotation


# instance fields
.field public final items:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/extractor/jpeg/MotionPhotoDescription$ContainerItem;",
            ">;"
        }
    .end annotation
.end field

.field public final photoPresentationTimestampUs:J


# direct methods
.method public constructor <init>(JLjava/util/List;)V
    .locals 0
    .param p1, "photoPresentationTimestampUs"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/List<",
            "Landroidx/media3/extractor/jpeg/MotionPhotoDescription$ContainerItem;",
            ">;)V"
        }
    .end annotation

    .line 67
    .local p3, "items":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/extractor/jpeg/MotionPhotoDescription$ContainerItem;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    iput-wide p1, p0, Landroidx/media3/extractor/jpeg/MotionPhotoDescription;->photoPresentationTimestampUs:J

    .line 69
    iput-object p3, p0, Landroidx/media3/extractor/jpeg/MotionPhotoDescription;->items:Ljava/util/List;

    .line 70
    return-void
.end method


# virtual methods
.method public getMotionPhotoMetadata(J)Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;
    .locals 29
    .param p1, "motionPhotoLength"    # J

    .line 81
    move-object/from16 v0, p0

    iget-object v1, v0, Landroidx/media3/extractor/jpeg/MotionPhotoDescription;->items:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    const/4 v2, 0x2

    const/4 v3, 0x0

    if-ge v1, v2, :cond_0

    .line 83
    return-object v3

    .line 88
    :cond_0
    const-wide/16 v1, -0x1

    .line 89
    .local v1, "photoStartPosition":J
    const-wide/16 v4, -0x1

    .line 90
    .local v4, "photoLength":J
    const-wide/16 v6, -0x1

    .line 91
    .local v6, "mp4StartPosition":J
    const-wide/16 v8, -0x1

    .line 92
    .local v8, "mp4Length":J
    const/4 v10, 0x0

    .line 93
    .local v10, "itemContainsMp4":Z
    move-wide/from16 v11, p1

    .line 94
    .local v11, "itemStartPosition":J
    move-wide/from16 v13, p1

    .line 95
    .local v13, "itemEndPosition":J
    iget-object v15, v0, Landroidx/media3/extractor/jpeg/MotionPhotoDescription;->items:Ljava/util/List;

    invoke-interface {v15}, Ljava/util/List;->size()I

    move-result v15

    add-int/lit8 v15, v15, -0x1

    .local v15, "i":I
    :goto_0
    if-ltz v15, :cond_4

    .line 96
    iget-object v3, v0, Landroidx/media3/extractor/jpeg/MotionPhotoDescription;->items:Ljava/util/List;

    invoke-interface {v3, v15}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/extractor/jpeg/MotionPhotoDescription$ContainerItem;

    .line 97
    .local v3, "item":Landroidx/media3/extractor/jpeg/MotionPhotoDescription$ContainerItem;
    move-wide/from16 v27, v13

    .end local v13    # "itemEndPosition":J
    .local v27, "itemEndPosition":J
    const-string/jumbo v13, "video/mp4"

    iget-object v14, v3, Landroidx/media3/extractor/jpeg/MotionPhotoDescription$ContainerItem;->mime:Ljava/lang/String;

    invoke-virtual {v13, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    or-int/2addr v10, v13

    .line 98
    move-wide v13, v11

    .line 99
    .end local v27    # "itemEndPosition":J
    .restart local v13    # "itemEndPosition":J
    if-nez v15, :cond_1

    .line 101
    const-wide/16 v11, 0x0

    .line 102
    move-wide/from16 v17, v11

    .end local v11    # "itemStartPosition":J
    .local v17, "itemStartPosition":J
    iget-wide v11, v3, Landroidx/media3/extractor/jpeg/MotionPhotoDescription$ContainerItem;->padding:J

    sub-long/2addr v13, v11

    move-wide/from16 v11, v17

    goto :goto_1

    .line 104
    .end local v17    # "itemStartPosition":J
    .restart local v11    # "itemStartPosition":J
    :cond_1
    move-wide/from16 v17, v13

    .end local v13    # "itemEndPosition":J
    .local v17, "itemEndPosition":J
    iget-wide v13, v3, Landroidx/media3/extractor/jpeg/MotionPhotoDescription$ContainerItem;->length:J

    sub-long/2addr v11, v13

    move-wide/from16 v13, v17

    .line 106
    .end local v17    # "itemEndPosition":J
    .restart local v13    # "itemEndPosition":J
    :goto_1
    if-eqz v10, :cond_2

    cmp-long v17, v11, v13

    if-eqz v17, :cond_2

    .line 107
    move-wide v6, v11

    .line 108
    sub-long v8, v13, v11

    .line 110
    const/4 v10, 0x0

    .line 112
    :cond_2
    if-nez v15, :cond_3

    .line 113
    move-wide v1, v11

    .line 114
    move-wide v4, v13

    .line 95
    .end local v3    # "item":Landroidx/media3/extractor/jpeg/MotionPhotoDescription$ContainerItem;
    :cond_3
    add-int/lit8 v15, v15, -0x1

    const/4 v3, 0x0

    goto :goto_0

    :cond_4
    move-wide/from16 v27, v13

    .line 117
    .end local v13    # "itemEndPosition":J
    .end local v15    # "i":I
    .restart local v27    # "itemEndPosition":J
    const-wide/16 v13, -0x1

    cmp-long v3, v6, v13

    if-eqz v3, :cond_6

    cmp-long v3, v8, v13

    if-eqz v3, :cond_6

    cmp-long v3, v1, v13

    if-eqz v3, :cond_6

    cmp-long v3, v4, v13

    if-nez v3, :cond_5

    goto :goto_2

    .line 123
    :cond_5
    new-instance v3, Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;

    iget-wide v13, v0, Landroidx/media3/extractor/jpeg/MotionPhotoDescription;->photoPresentationTimestampUs:J

    move-object/from16 v16, v3

    move-wide/from16 v17, v1

    move-wide/from16 v19, v4

    move-wide/from16 v21, v13

    move-wide/from16 v23, v6

    move-wide/from16 v25, v8

    invoke-direct/range {v16 .. v26}, Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;-><init>(JJJJJ)V

    return-object v3

    .line 121
    :cond_6
    :goto_2
    const/4 v3, 0x0

    return-object v3
.end method
