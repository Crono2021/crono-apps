.class final Landroidx/media3/common/util/GlProgram$Uniform;
.super Ljava/lang/Object;
.source "GlProgram.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/common/util/GlProgram;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Uniform"
.end annotation


# instance fields
.field private final floatValue:[F

.field private final intValue:[I

.field private final location:I

.field public final name:Ljava/lang/String;

.field private texIdValue:I

.field private texUnitIndex:I

.field private final type:I


# direct methods
.method private constructor <init>(Ljava/lang/String;II)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "location"    # I
    .param p3, "type"    # I

    .line 348
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 349
    iput-object p1, p0, Landroidx/media3/common/util/GlProgram$Uniform;->name:Ljava/lang/String;

    .line 350
    iput p2, p0, Landroidx/media3/common/util/GlProgram$Uniform;->location:I

    .line 351
    iput p3, p0, Landroidx/media3/common/util/GlProgram$Uniform;->type:I

    .line 352
    const/16 v0, 0x10

    new-array v0, v0, [F

    iput-object v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->floatValue:[F

    .line 353
    const/4 v0, 0x4

    new-array v0, v0, [I

    iput-object v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->intValue:[I

    .line 354
    return-void
.end method

.method public static create(II)Landroidx/media3/common/util/GlProgram$Uniform;
    .locals 16
    .param p0, "programId"    # I
    .param p1, "index"    # I

    .line 312
    move/from16 v11, p0

    const/4 v0, 0x1

    new-array v12, v0, [I

    .line 313
    .local v12, "length":[I
    const v1, 0x8b87

    const/4 v13, 0x0

    invoke-static {v11, v1, v12, v13}, Landroid/opengl/GLES20;->glGetProgramiv(II[II)V

    .line 316
    new-array v14, v0, [I

    .line 317
    .local v14, "type":[I
    aget v1, v12, v13

    new-array v15, v1, [B

    .line 319
    .local v15, "nameBytes":[B
    aget v2, v12, v13

    new-array v3, v0, [I

    const/4 v4, 0x0

    new-array v5, v0, [I

    const/4 v6, 0x0

    const/4 v8, 0x0

    const/4 v10, 0x0

    move/from16 v0, p0

    move/from16 v1, p1

    move-object v7, v14

    move-object v9, v15

    invoke-static/range {v0 .. v10}, Landroid/opengl/GLES20;->glGetActiveUniform(III[II[II[II[BI)V

    .line 331
    new-instance v0, Ljava/lang/String;

    invoke-static {v15}, Landroidx/media3/common/util/GlProgram;->access$000([B)I

    move-result v1

    invoke-direct {v0, v15, v13, v1}, Ljava/lang/String;-><init>([BII)V

    .line 332
    .local v0, "name":Ljava/lang/String;
    invoke-static {v11, v0}, Landroidx/media3/common/util/GlProgram;->access$200(ILjava/lang/String;)I

    move-result v1

    .line 334
    .local v1, "location":I
    new-instance v2, Landroidx/media3/common/util/GlProgram$Uniform;

    aget v3, v14, v13

    invoke-direct {v2, v0, v1, v3}, Landroidx/media3/common/util/GlProgram$Uniform;-><init>(Ljava/lang/String;II)V

    return-object v2
.end method


# virtual methods
.method public bind()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 394
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->type:I

    const/4 v1, 0x1

    const/4 v2, 0x0

    sparse-switch v0, :sswitch_data_0

    .line 450
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unexpected uniform type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroidx/media3/common/util/GlProgram$Uniform;->type:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 436
    :sswitch_0
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->texIdValue:I

    if-eqz v0, :cond_1

    .line 439
    const v0, 0x84c0

    iget v1, p0, Landroidx/media3/common/util/GlProgram$Uniform;->texUnitIndex:I

    add-int/2addr v1, v0

    invoke-static {v1}, Landroid/opengl/GLES20;->glActiveTexture(I)V

    .line 440
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 442
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->type:I

    const v1, 0x8b5e    # 4.9996E-41f

    if-ne v0, v1, :cond_0

    .line 443
    const/16 v0, 0xde1

    goto :goto_0

    .line 444
    :cond_0
    const v0, 0x8d65

    :goto_0
    iget v1, p0, Landroidx/media3/common/util/GlProgram$Uniform;->texIdValue:I

    .line 441
    invoke-static {v0, v1}, Landroidx/media3/common/util/GlUtil;->bindTexture(II)V

    .line 446
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->location:I

    iget v1, p0, Landroidx/media3/common/util/GlProgram$Uniform;->texUnitIndex:I

    invoke-static {v0, v1}, Landroid/opengl/GLES20;->glUniform1i(II)V

    .line 447
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 448
    goto :goto_1

    .line 437
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "No call to setSamplerTexId() before bind."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 429
    :sswitch_1
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->location:I

    iget-object v3, p0, Landroidx/media3/common/util/GlProgram$Uniform;->floatValue:[F

    invoke-static {v0, v1, v2, v3, v2}, Landroid/opengl/GLES20;->glUniformMatrix4fv(IIZ[FI)V

    .line 431
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 432
    goto :goto_1

    .line 424
    :sswitch_2
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->location:I

    iget-object v3, p0, Landroidx/media3/common/util/GlProgram$Uniform;->floatValue:[F

    invoke-static {v0, v1, v2, v3, v2}, Landroid/opengl/GLES20;->glUniformMatrix3fv(IIZ[FI)V

    .line 426
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 427
    goto :goto_1

    .line 408
    :sswitch_3
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->location:I

    iget-object v3, p0, Landroidx/media3/common/util/GlProgram$Uniform;->intValue:[I

    invoke-static {v0, v1, v3, v2}, Landroid/opengl/GLES20;->glUniform4iv(II[II)V

    .line 409
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 410
    goto :goto_1

    .line 404
    :sswitch_4
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->location:I

    iget-object v3, p0, Landroidx/media3/common/util/GlProgram$Uniform;->intValue:[I

    invoke-static {v0, v1, v3, v2}, Landroid/opengl/GLES20;->glUniform3iv(II[II)V

    .line 405
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 406
    goto :goto_1

    .line 400
    :sswitch_5
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->location:I

    iget-object v3, p0, Landroidx/media3/common/util/GlProgram$Uniform;->intValue:[I

    invoke-static {v0, v1, v3, v2}, Landroid/opengl/GLES20;->glUniform2iv(II[II)V

    .line 401
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 402
    goto :goto_1

    .line 420
    :sswitch_6
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->location:I

    iget-object v3, p0, Landroidx/media3/common/util/GlProgram$Uniform;->floatValue:[F

    invoke-static {v0, v1, v3, v2}, Landroid/opengl/GLES20;->glUniform3fv(II[FI)V

    .line 421
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 422
    goto :goto_1

    .line 416
    :sswitch_7
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->location:I

    iget-object v3, p0, Landroidx/media3/common/util/GlProgram$Uniform;->floatValue:[F

    invoke-static {v0, v1, v3, v2}, Landroid/opengl/GLES20;->glUniform2fv(II[FI)V

    .line 417
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 418
    goto :goto_1

    .line 412
    :sswitch_8
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->location:I

    iget-object v3, p0, Landroidx/media3/common/util/GlProgram$Uniform;->floatValue:[F

    invoke-static {v0, v1, v3, v2}, Landroid/opengl/GLES20;->glUniform1fv(II[FI)V

    .line 413
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 414
    goto :goto_1

    .line 396
    :sswitch_9
    iget v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->location:I

    iget-object v3, p0, Landroidx/media3/common/util/GlProgram$Uniform;->intValue:[I

    invoke-static {v0, v1, v3, v2}, Landroid/opengl/GLES20;->glUniform1iv(II[II)V

    .line 397
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 398
    nop

    .line 452
    :goto_1
    return-void

    nop

    :sswitch_data_0
    .sparse-switch
        0x1404 -> :sswitch_9
        0x1406 -> :sswitch_8
        0x8b50 -> :sswitch_7
        0x8b51 -> :sswitch_6
        0x8b53 -> :sswitch_5
        0x8b54 -> :sswitch_4
        0x8b55 -> :sswitch_3
        0x8b5b -> :sswitch_2
        0x8b5c -> :sswitch_1
        0x8b5e -> :sswitch_0
        0x8be7 -> :sswitch_0
        0x8d66 -> :sswitch_0
    .end sparse-switch
.end method

.method public setFloat(F)V
    .locals 2
    .param p1, "value"    # F

    .line 379
    iget-object v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->floatValue:[F

    const/4 v1, 0x0

    aput p1, v0, v1

    .line 380
    return-void
.end method

.method public setFloats([F)V
    .locals 3
    .param p1, "value"    # [F

    .line 384
    iget-object v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->floatValue:[F

    array-length v1, p1

    const/4 v2, 0x0

    invoke-static {p1, v2, v0, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 385
    return-void
.end method

.method public setInt(I)V
    .locals 2
    .param p1, "value"    # I

    .line 369
    iget-object v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->intValue:[I

    const/4 v1, 0x0

    aput p1, v0, v1

    .line 370
    return-void
.end method

.method public setInts([I)V
    .locals 3
    .param p1, "value"    # [I

    .line 374
    iget-object v0, p0, Landroidx/media3/common/util/GlProgram$Uniform;->intValue:[I

    array-length v1, p1

    const/4 v2, 0x0

    invoke-static {p1, v2, v0, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 375
    return-void
.end method

.method public setSamplerTexId(II)V
    .locals 0
    .param p1, "texId"    # I
    .param p2, "texUnitIndex"    # I

    .line 363
    iput p1, p0, Landroidx/media3/common/util/GlProgram$Uniform;->texIdValue:I

    .line 364
    iput p2, p0, Landroidx/media3/common/util/GlProgram$Uniform;->texUnitIndex:I

    .line 365
    return-void
.end method
