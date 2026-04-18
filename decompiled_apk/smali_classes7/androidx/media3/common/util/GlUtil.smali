.class public final Landroidx/media3/common/util/GlUtil;
.super Ljava/lang/Object;
.source "GlUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/common/util/GlUtil$Api17;,
        Landroidx/media3/common/util/GlUtil$GlException;,
        Landroidx/media3/common/util/GlUtil$Api18;
    }
.end annotation


# static fields
.field public static final EGL_CONFIG_ATTRIBUTES_RGBA_1010102:[I

.field public static final EGL_CONFIG_ATTRIBUTES_RGBA_8888:[I

.field private static final EGL_GL_COLORSPACE_BT2020_PQ_EXT:I = 0x3340

.field private static final EGL_GL_COLORSPACE_KHR:I = 0x309d

.field private static final EGL_WINDOW_SURFACE_ATTRIBUTES_BT2020_PQ:[I

.field private static final EGL_WINDOW_SURFACE_ATTRIBUTES_NONE:[I

.field private static final EXTENSION_COLORSPACE_BT2020_PQ:Ljava/lang/String; = "EGL_EXT_gl_colorspace_bt2020_pq"

.field private static final EXTENSION_PROTECTED_CONTENT:Ljava/lang/String; = "EGL_EXT_protected_content"

.field private static final EXTENSION_SURFACELESS_CONTEXT:Ljava/lang/String; = "EGL_KHR_surfaceless_context"

.field private static final EXTENSION_YUV_TARGET:Ljava/lang/String; = "GL_EXT_YUV_target"

.field private static final GL_FENCE_SYNC_FAILED:J = 0x0L

.field public static final HOMOGENEOUS_COORDINATE_VECTOR_SIZE:I = 0x4

.field public static final LENGTH_NDC:F = 2.0f


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 68
    const/16 v0, 0xf

    new-array v1, v0, [I

    fill-array-data v1, :array_0

    sput-object v1, Landroidx/media3/common/util/GlUtil;->EGL_CONFIG_ATTRIBUTES_RGBA_8888:[I

    .line 79
    new-array v0, v0, [I

    fill-array-data v0, :array_1

    sput-object v0, Landroidx/media3/common/util/GlUtil;->EGL_CONFIG_ATTRIBUTES_RGBA_1010102:[I

    .line 105
    const/16 v0, 0x309d

    const/16 v1, 0x3340

    const/16 v2, 0x3038

    filled-new-array {v0, v1, v2, v2}, [I

    move-result-object v0

    sput-object v0, Landroidx/media3/common/util/GlUtil;->EGL_WINDOW_SURFACE_ATTRIBUTES_BT2020_PQ:[I

    .line 109
    filled-new-array {v2}, [I

    move-result-object v0

    sput-object v0, Landroidx/media3/common/util/GlUtil;->EGL_WINDOW_SURFACE_ATTRIBUTES_NONE:[I

    return-void

    nop

    :array_0
    .array-data 4
        0x3040
        0x4
        0x3024
        0x8
        0x3023
        0x8
        0x3022
        0x8
        0x3021
        0x8
        0x3025
        0x0
        0x3026
        0x0
        0x3038
    .end array-data

    :array_1
    .array-data 4
        0x3040
        0x4
        0x3024
        0xa
        0x3023
        0xa
        0x3022
        0xa
        0x3021
        0x2
        0x3025
        0x0
        0x3026
        0x0
        0x3038
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .line 112
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static assertValidTextureSize(II)V
    .locals 5
    .param p0, "width"    # I
    .param p1, "height"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 475
    const/4 v0, 0x1

    new-array v1, v0, [I

    .line 476
    .local v1, "maxTextureSizeBuffer":[I
    const/16 v2, 0xd33

    const/4 v3, 0x0

    invoke-static {v2, v1, v3}, Landroid/opengl/GLES20;->glGetIntegerv(I[II)V

    .line 477
    aget v2, v1, v3

    .line 478
    .local v2, "maxTextureSize":I
    if-lez v2, :cond_0

    goto :goto_0

    :cond_0
    move v0, v3

    :goto_0
    const-string v3, "Create a OpenGL context first or run the GL methods on an OpenGL thread."

    invoke-static {v0, v3}, Landroidx/media3/common/util/Assertions;->checkState(ZLjava/lang/Object;)V

    .line 482
    if-ltz p0, :cond_2

    if-ltz p1, :cond_2

    .line 485
    if-gt p0, v2, :cond_1

    if-gt p1, v2, :cond_1

    .line 489
    return-void

    .line 486
    :cond_1
    new-instance v0, Landroidx/media3/common/util/GlUtil$GlException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "width or height is greater than GL_MAX_TEXTURE_SIZE "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v3}, Landroidx/media3/common/util/GlUtil$GlException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 483
    :cond_2
    new-instance v0, Landroidx/media3/common/util/GlUtil$GlException;

    const-string/jumbo v3, "width or height is less than 0"

    invoke-direct {v0, v3}, Landroidx/media3/common/util/GlUtil$GlException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static awaitSyncObject(J)V
    .locals 2
    .param p0, "syncObject"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 423
    const-wide/16 v0, 0x0

    cmp-long v0, p0, v0

    if-nez v0, :cond_0

    .line 425
    invoke-static {}, Landroid/opengl/GLES20;->glFinish()V

    goto :goto_0

    .line 428
    :cond_0
    invoke-static {p0, p1}, Landroidx/media3/common/util/GlUtil$Api18;->waitSync(J)V

    .line 430
    :goto_0
    return-void
.end method

.method public static bindTexture(II)V
    .locals 2
    .param p0, "textureTarget"    # I
    .param p1, "texId"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 678
    invoke-static {p0, p1}, Landroid/opengl/GLES20;->glBindTexture(II)V

    .line 679
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 680
    const/16 v0, 0x2800

    const/16 v1, 0x2601

    invoke-static {p0, v0, v1}, Landroid/opengl/GLES20;->glTexParameteri(III)V

    .line 681
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 682
    const/16 v0, 0x2801

    invoke-static {p0, v0, v1}, Landroid/opengl/GLES20;->glTexParameteri(III)V

    .line 683
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 684
    const/16 v0, 0x2802

    const v1, 0x812f

    invoke-static {p0, v0, v1}, Landroid/opengl/GLES20;->glTexParameteri(III)V

    .line 685
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 686
    const/16 v0, 0x2803

    invoke-static {p0, v0, v1}, Landroid/opengl/GLES20;->glTexParameteri(III)V

    .line 687
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 688
    return-void
.end method

.method public static checkGlError()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 443
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 444
    .local v0, "errorMessageBuilder":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .line 446
    .local v1, "foundError":Z
    :goto_0
    invoke-static {}, Landroid/opengl/GLES20;->glGetError()I

    move-result v2

    move v3, v2

    .local v3, "error":I
    if-eqz v2, :cond_2

    .line 447
    if-eqz v1, :cond_0

    .line 448
    const/16 v2, 0xa

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 450
    :cond_0
    invoke-static {v3}, Landroid/opengl/GLU;->gluErrorString(I)Ljava/lang/String;

    move-result-object v2

    .line 451
    .local v2, "errorString":Ljava/lang/String;
    if-nez v2, :cond_1

    .line 452
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "error code: 0x"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 454
    :cond_1
    const-string v4, "glError: "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 455
    const/4 v1, 0x1

    .line 456
    .end local v2    # "errorString":Ljava/lang/String;
    goto :goto_0

    .line 457
    :cond_2
    if-nez v1, :cond_3

    .line 460
    return-void

    .line 458
    :cond_3
    new-instance v2, Landroidx/media3/common/util/GlUtil$GlException;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Landroidx/media3/common/util/GlUtil$GlException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public static checkGlException(ZLjava/lang/String;)V
    .locals 1
    .param p0, "expression"    # Z
    .param p1, "errorMessage"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 758
    if-eqz p0, :cond_0

    .line 761
    return-void

    .line 759
    :cond_0
    new-instance v0, Landroidx/media3/common/util/GlUtil$GlException;

    invoke-direct {v0, p1}, Landroidx/media3/common/util/GlUtil$GlException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static clearFocusedBuffers()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 499
    const/4 v0, 0x0

    invoke-static {v0, v0, v0, v0}, Landroid/opengl/GLES20;->glClearColor(FFFF)V

    .line 500
    const/high16 v0, 0x3f800000    # 1.0f

    invoke-static {v0}, Landroid/opengl/GLES20;->glClearDepthf(F)V

    .line 501
    const/16 v0, 0x4100

    invoke-static {v0}, Landroid/opengl/GLES20;->glClear(I)V

    .line 502
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 503
    return-void
.end method

.method public static create4x4IdentityMatrix()[F
    .locals 1

    .line 136
    const/16 v0, 0x10

    new-array v0, v0, [F

    .line 137
    .local v0, "matrix":[F
    invoke-static {v0}, Landroidx/media3/common/util/GlUtil;->setToIdentity([F)V

    .line 138
    return-object v0
.end method

.method private static createBuffer(I)Ljava/nio/FloatBuffer;
    .locals 2
    .param p0, "capacity"    # I

    .line 571
    mul-int/lit8 v0, p0, 0x4

    invoke-static {v0}, Ljava/nio/ByteBuffer;->allocateDirect(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 572
    .local v0, "byteBuffer":Ljava/nio/ByteBuffer;
    invoke-static {}, Ljava/nio/ByteOrder;->nativeOrder()Ljava/nio/ByteOrder;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->asFloatBuffer()Ljava/nio/FloatBuffer;

    move-result-object v1

    return-object v1
.end method

.method public static createBuffer([F)Ljava/nio/FloatBuffer;
    .locals 1
    .param p0, "data"    # [F

    .line 562
    array-length v0, p0

    invoke-static {v0}, Landroidx/media3/common/util/GlUtil;->createBuffer(I)Ljava/nio/FloatBuffer;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/nio/FloatBuffer;->put([F)Ljava/nio/FloatBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/nio/FloatBuffer;->flip()Ljava/nio/Buffer;

    move-result-object v0

    check-cast v0, Ljava/nio/FloatBuffer;

    return-object v0
.end method

.method public static createEglContext(Landroid/opengl/EGLContext;Landroid/opengl/EGLDisplay;I[I)Landroid/opengl/EGLContext;
    .locals 3
    .param p0, "sharedContext"    # Landroid/opengl/EGLContext;
    .param p1, "eglDisplay"    # Landroid/opengl/EGLDisplay;
    .param p2, "openGlVersion"    # I
    .param p3, "configAttributes"    # [I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 269
    sget-object v0, Landroidx/media3/common/util/GlUtil;->EGL_CONFIG_ATTRIBUTES_RGBA_8888:[I

    .line 270
    invoke-static {p3, v0}, Ljava/util/Arrays;->equals([I[I)Z

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-nez v0, :cond_1

    sget-object v0, Landroidx/media3/common/util/GlUtil;->EGL_CONFIG_ATTRIBUTES_RGBA_1010102:[I

    .line 271
    invoke-static {p3, v0}, Ljava/util/Arrays;->equals([I[I)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    move v0, v1

    goto :goto_1

    :cond_1
    :goto_0
    move v0, v2

    .line 269
    :goto_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 272
    const/4 v0, 0x2

    if-eq p2, v0, :cond_2

    const/4 v0, 0x3

    if-ne p2, v0, :cond_3

    :cond_2
    move v1, v2

    :cond_3
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 273
    invoke-static {p0, p1, p2, p3}, Landroidx/media3/common/util/GlUtil$Api17;->createEglContext(Landroid/opengl/EGLContext;Landroid/opengl/EGLDisplay;I[I)Landroid/opengl/EGLContext;

    move-result-object v0

    return-object v0
.end method

.method public static createEglContext(Landroid/opengl/EGLDisplay;)Landroid/opengl/EGLContext;
    .locals 3
    .param p0, "eglDisplay"    # Landroid/opengl/EGLDisplay;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 248
    sget-object v0, Landroid/opengl/EGL14;->EGL_NO_CONTEXT:Landroid/opengl/EGLContext;

    const/4 v1, 0x2

    sget-object v2, Landroidx/media3/common/util/GlUtil;->EGL_CONFIG_ATTRIBUTES_RGBA_8888:[I

    invoke-static {v0, p0, v1, v2}, Landroidx/media3/common/util/GlUtil;->createEglContext(Landroid/opengl/EGLContext;Landroid/opengl/EGLDisplay;I[I)Landroid/opengl/EGLContext;

    move-result-object v0

    return-object v0
.end method

.method public static createEglSurface(Landroid/opengl/EGLDisplay;Ljava/lang/Object;IZ)Landroid/opengl/EGLSurface;
    .locals 3
    .param p0, "eglDisplay"    # Landroid/opengl/EGLDisplay;
    .param p1, "surface"    # Ljava/lang/Object;
    .param p2, "colorTransfer"    # I
    .param p3, "isEncoderInputSurface"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 297
    const/4 v0, 0x3

    if-eq p2, v0, :cond_4

    const/16 v0, 0xa

    if-ne p2, v0, :cond_0

    goto :goto_0

    .line 300
    :cond_0
    const/4 v0, 0x6

    if-ne p2, v0, :cond_2

    .line 301
    sget-object v0, Landroidx/media3/common/util/GlUtil;->EGL_CONFIG_ATTRIBUTES_RGBA_1010102:[I

    .line 302
    .local v0, "configAttributes":[I
    if-eqz p3, :cond_1

    .line 307
    sget-object v1, Landroidx/media3/common/util/GlUtil;->EGL_WINDOW_SURFACE_ATTRIBUTES_NONE:[I

    .local v1, "windowAttributes":[I
    goto :goto_1

    .line 310
    .end local v1    # "windowAttributes":[I
    :cond_1
    sget-object v1, Landroidx/media3/common/util/GlUtil;->EGL_WINDOW_SURFACE_ATTRIBUTES_BT2020_PQ:[I

    .restart local v1    # "windowAttributes":[I
    goto :goto_1

    .line 312
    .end local v0    # "configAttributes":[I
    .end local v1    # "windowAttributes":[I
    :cond_2
    const/4 v0, 0x7

    if-ne p2, v0, :cond_3

    .line 313
    const-string v0, "Outputting HLG to the screen is not supported."

    invoke-static {p3, v0}, Landroidx/media3/common/util/Assertions;->checkArgument(ZLjava/lang/Object;)V

    .line 314
    sget-object v0, Landroidx/media3/common/util/GlUtil;->EGL_CONFIG_ATTRIBUTES_RGBA_1010102:[I

    .line 315
    .restart local v0    # "configAttributes":[I
    sget-object v1, Landroidx/media3/common/util/GlUtil;->EGL_WINDOW_SURFACE_ATTRIBUTES_NONE:[I

    .restart local v1    # "windowAttributes":[I
    goto :goto_1

    .line 317
    .end local v0    # "configAttributes":[I
    .end local v1    # "windowAttributes":[I
    :cond_3
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unsupported color transfer: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 298
    :cond_4
    :goto_0
    sget-object v0, Landroidx/media3/common/util/GlUtil;->EGL_CONFIG_ATTRIBUTES_RGBA_8888:[I

    .line 299
    .restart local v0    # "configAttributes":[I
    sget-object v1, Landroidx/media3/common/util/GlUtil;->EGL_WINDOW_SURFACE_ATTRIBUTES_NONE:[I

    .line 319
    .restart local v1    # "windowAttributes":[I
    :goto_1
    invoke-static {p0, p1, v0, v1}, Landroidx/media3/common/util/GlUtil$Api17;->createEglSurface(Landroid/opengl/EGLDisplay;Ljava/lang/Object;[I[I)Landroid/opengl/EGLSurface;

    move-result-object v2

    return-object v2
.end method

.method public static createExternalTexture()I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 580
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->generateTexture()I

    move-result v0

    .line 581
    .local v0, "texId":I
    const v1, 0x8d65

    invoke-static {v1, v0}, Landroidx/media3/common/util/GlUtil;->bindTexture(II)V

    .line 582
    return v0
.end method

.method public static createFboForTexture(I)I
    .locals 5
    .param p0, "texId"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 696
    const/4 v0, 0x1

    new-array v1, v0, [I

    .line 697
    .local v1, "fboId":[I
    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/opengl/GLES20;->glGenFramebuffers(I[II)V

    .line 698
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 699
    aget v0, v1, v2

    const v3, 0x8d40

    invoke-static {v3, v0}, Landroid/opengl/GLES20;->glBindFramebuffer(II)V

    .line 700
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 701
    const v0, 0x8ce0

    const/16 v4, 0xde1

    invoke-static {v3, v0, v4, p0, v2}, Landroid/opengl/GLES20;->glFramebufferTexture2D(IIIII)V

    .line 703
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 704
    aget v0, v1, v2

    return v0
.end method

.method public static createFocusedPlaceholderEglSurface(Landroid/opengl/EGLContext;Landroid/opengl/EGLDisplay;)Landroid/opengl/EGLSurface;
    .locals 3
    .param p0, "eglContext"    # Landroid/opengl/EGLContext;
    .param p1, "eglDisplay"    # Landroid/opengl/EGLDisplay;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 359
    sget-object v0, Landroidx/media3/common/util/GlUtil;->EGL_CONFIG_ATTRIBUTES_RGBA_8888:[I

    .line 361
    .local v0, "configAttributes":[I
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->isSurfacelessContextExtensionSupported()Z

    move-result v1

    const/4 v2, 0x1

    if-eqz v1, :cond_0

    .line 362
    sget-object v1, Landroid/opengl/EGL14;->EGL_NO_SURFACE:Landroid/opengl/EGLSurface;

    goto :goto_0

    .line 363
    :cond_0
    invoke-static {p1, v2, v2, v0}, Landroidx/media3/common/util/GlUtil;->createPbufferSurface(Landroid/opengl/EGLDisplay;II[I)Landroid/opengl/EGLSurface;

    move-result-object v1

    :goto_0
    nop

    .line 365
    .local v1, "eglSurface":Landroid/opengl/EGLSurface;
    invoke-static {p1, p0, v1, v2, v2}, Landroidx/media3/common/util/GlUtil;->focusEglSurface(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;Landroid/opengl/EGLSurface;II)V

    .line 366
    return-object v1
.end method

.method public static createGlSyncFence()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 390
    invoke-static {}, Landroidx/media3/common/util/GlUtil$Api17;->getContextMajorVersion()I

    move-result v0

    const/4 v1, 0x3

    if-lt v0, v1, :cond_0

    invoke-static {}, Landroidx/media3/common/util/GlUtil$Api18;->createSyncFence()J

    move-result-wide v0

    goto :goto_0

    :cond_0
    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0
.end method

.method private static createPbufferSurface(Landroid/opengl/EGLDisplay;II[I)Landroid/opengl/EGLSurface;
    .locals 3
    .param p0, "eglDisplay"    # Landroid/opengl/EGLDisplay;
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "configAttributes"    # [I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 334
    const/16 v0, 0x3056

    const/16 v1, 0x3038

    const/16 v2, 0x3057

    filled-new-array {v2, p1, v0, p2, v1}, [I

    move-result-object v0

    .line 340
    .local v0, "pbufferAttributes":[I
    invoke-static {p0, p3, v0}, Landroidx/media3/common/util/GlUtil$Api17;->createEglPbufferSurface(Landroid/opengl/EGLDisplay;[I[I)Landroid/opengl/EGLSurface;

    move-result-object v1

    return-object v1
.end method

.method public static createTexture(IIZ)I
    .locals 2
    .param p0, "width"    # I
    .param p1, "height"    # I
    .param p2, "useHighPrecisionColorComponents"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 616
    if-eqz p2, :cond_1

    .line 617
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x12

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    const-string v1, "GLES30 extensions are not supported below API 18."

    invoke-static {v0, v1}, Landroidx/media3/common/util/Assertions;->checkState(ZLjava/lang/Object;)V

    .line 618
    const v0, 0x881a

    const/16 v1, 0x140b

    invoke-static {p0, p1, v0, v1}, Landroidx/media3/common/util/GlUtil;->createTextureUninitialized(IIII)I

    move-result v0

    return v0

    .line 620
    :cond_1
    const/16 v0, 0x1908

    const/16 v1, 0x1401

    invoke-static {p0, p1, v0, v1}, Landroidx/media3/common/util/GlUtil;->createTextureUninitialized(IIII)I

    move-result v0

    return v0
.end method

.method public static createTexture(Landroid/graphics/Bitmap;)I
    .locals 1
    .param p0, "bitmap"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 593
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->generateTexture()I

    move-result v0

    .line 594
    .local v0, "texId":I
    invoke-static {v0, p0}, Landroidx/media3/common/util/GlUtil;->setTexture(ILandroid/graphics/Bitmap;)V

    .line 595
    return v0
.end method

.method private static createTextureUninitialized(IIII)I
    .locals 11
    .param p0, "width"    # I
    .param p1, "height"    # I
    .param p2, "internalFormat"    # I
    .param p3, "type"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 635
    invoke-static {p0, p1}, Landroidx/media3/common/util/GlUtil;->assertValidTextureSize(II)V

    .line 636
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->generateTexture()I

    move-result v0

    .line 637
    .local v0, "texId":I
    const/16 v1, 0xde1

    invoke-static {v1, v0}, Landroidx/media3/common/util/GlUtil;->bindTexture(II)V

    .line 638
    const/16 v2, 0xde1

    const/4 v3, 0x0

    const/4 v7, 0x0

    const/16 v8, 0x1908

    const/4 v10, 0x0

    move v4, p2

    move v5, p0

    move v6, p1

    move v9, p3

    invoke-static/range {v2 .. v10}, Landroid/opengl/GLES20;->glTexImage2D(IIIIIIIILjava/nio/Buffer;)V

    .line 648
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 649
    return v0
.end method

.method public static createVertexBuffer(Ljava/util/List;)[F
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "[F>;)[F"
        }
    .end annotation

    .line 148
    .local p0, "vertexList":Ljava/util/List;, "Ljava/util/List<[F>;"
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x4

    mul-int/2addr v0, v1

    new-array v0, v0, [F

    .line 149
    .local v0, "vertexBuffer":[F
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_0

    .line 150
    nop

    .line 151
    invoke-interface {p0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    mul-int/lit8 v4, v2, 0x4

    .line 150
    const/4 v5, 0x0

    invoke-static {v3, v5, v0, v4, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 149
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 157
    .end local v2    # "i":I
    :cond_0
    return-object v0
.end method

.method public static deleteFbo(I)V
    .locals 3
    .param p0, "fboId"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 742
    filled-new-array {p0}, [I

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v2, v0, v1}, Landroid/opengl/GLES20;->glDeleteFramebuffers(I[II)V

    .line 743
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 744
    return-void
.end method

.method public static deleteRbo(I)V
    .locals 3
    .param p0, "rboId"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 748
    filled-new-array {p0}, [I

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v2, v0, v1}, Landroid/opengl/GLES20;->glDeleteRenderbuffers(I[II)V

    .line 750
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 751
    return-void
.end method

.method public static deleteSyncObject(J)V
    .locals 2
    .param p0, "syncObject"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 400
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x12

    if-lt v0, v1, :cond_0

    .line 401
    invoke-static {p0, p1}, Landroidx/media3/common/util/GlUtil$Api18;->deleteSyncObject(J)V

    .line 403
    :cond_0
    return-void
.end method

.method public static deleteSyncObjectQuietly(J)V
    .locals 2
    .param p0, "syncObject"    # J

    .line 407
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x12

    if-lt v0, v1, :cond_0

    .line 410
    :try_start_0
    invoke-static {p0, p1}, Landroidx/media3/common/util/GlUtil$Api18;->deleteSyncObject(J)V
    :try_end_0
    .catch Landroidx/media3/common/util/GlUtil$GlException; {:try_start_0 .. :try_end_0} :catch_0

    .line 413
    goto :goto_0

    .line 411
    :catch_0
    move-exception v0

    .line 415
    :cond_0
    :goto_0
    return-void
.end method

.method public static deleteTexture(I)V
    .locals 3
    .param p0, "textureId"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 713
    filled-new-array {p0}, [I

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v2, v0, v1}, Landroid/opengl/GLES20;->glDeleteTextures(I[II)V

    .line 714
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 715
    return-void
.end method

.method public static destroyEglContext(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)V
    .locals 0
    .param p0, "eglDisplay"    # Landroid/opengl/EGLDisplay;
    .param p1, "eglContext"    # Landroid/opengl/EGLContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 727
    invoke-static {p0, p1}, Landroidx/media3/common/util/GlUtil$Api17;->destroyEglContext(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)V

    .line 728
    return-void
.end method

.method public static destroyEglSurface(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)V
    .locals 0
    .param p0, "eglDisplay"    # Landroid/opengl/EGLDisplay;
    .param p1, "eglSurface"    # Landroid/opengl/EGLSurface;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 737
    invoke-static {p0, p1}, Landroidx/media3/common/util/GlUtil$Api17;->destroyEglSurface(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)V

    .line 738
    return-void
.end method

.method public static focusEglSurface(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;Landroid/opengl/EGLSurface;II)V
    .locals 6
    .param p0, "eglDisplay"    # Landroid/opengl/EGLDisplay;
    .param p1, "eglContext"    # Landroid/opengl/EGLContext;
    .param p2, "eglSurface"    # Landroid/opengl/EGLSurface;
    .param p3, "width"    # I
    .param p4, "height"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 513
    const/4 v3, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v4, p3

    move v5, p4

    invoke-static/range {v0 .. v5}, Landroidx/media3/common/util/GlUtil$Api17;->focusRenderTarget(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;Landroid/opengl/EGLSurface;III)V

    .line 515
    return-void
.end method

.method public static focusFramebuffer(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;Landroid/opengl/EGLSurface;III)V
    .locals 0
    .param p0, "eglDisplay"    # Landroid/opengl/EGLDisplay;
    .param p1, "eglContext"    # Landroid/opengl/EGLContext;
    .param p2, "eglSurface"    # Landroid/opengl/EGLSurface;
    .param p3, "framebuffer"    # I
    .param p4, "width"    # I
    .param p5, "height"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 530
    invoke-static/range {p0 .. p5}, Landroidx/media3/common/util/GlUtil$Api17;->focusRenderTarget(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;Landroid/opengl/EGLSurface;III)V

    .line 531
    return-void
.end method

.method public static focusFramebufferUsingCurrentContext(III)V
    .locals 3
    .param p0, "framebuffer"    # I
    .param p1, "width"    # I
    .param p2, "height"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 546
    const/4 v0, 0x1

    new-array v0, v0, [I

    .line 547
    .local v0, "boundFramebuffer":[I
    const v1, 0x8ca6

    const/4 v2, 0x0

    invoke-static {v1, v0, v2}, Landroid/opengl/GLES20;->glGetIntegerv(I[II)V

    .line 548
    aget v1, v0, v2

    if-eq v1, p0, :cond_0

    .line 549
    const v1, 0x8d40

    invoke-static {v1, p0}, Landroid/opengl/GLES20;->glBindFramebuffer(II)V

    .line 551
    :cond_0
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 552
    invoke-static {v2, v2, p1, p2}, Landroid/opengl/GLES20;->glViewport(IIII)V

    .line 553
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 554
    return-void
.end method

.method public static generateTexture()I
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 654
    const/4 v0, 0x1

    new-array v1, v0, [I

    .line 655
    .local v1, "texId":[I
    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/opengl/GLES20;->glGenTextures(I[II)V

    .line 656
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 657
    aget v0, v1, v2

    return v0
.end method

.method public static getContextMajorVersion()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 377
    invoke-static {}, Landroidx/media3/common/util/GlUtil$Api17;->getContextMajorVersion()I

    move-result v0

    int-to-long v0, v0

    return-wide v0
.end method

.method public static getCurrentContext()Landroid/opengl/EGLContext;
    .locals 1

    .line 435
    invoke-static {}, Landroidx/media3/common/util/GlUtil$Api17;->getCurrentContext()Landroid/opengl/EGLContext;

    move-result-object v0

    return-object v0
.end method

.method public static getDefaultEglDisplay()Landroid/opengl/EGLDisplay;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 235
    invoke-static {}, Landroidx/media3/common/util/GlUtil$Api17;->getDefaultEglDisplay()Landroid/opengl/EGLDisplay;

    move-result-object v0

    return-object v0
.end method

.method public static getNormalizedCoordinateBounds()[F
    .locals 1

    .line 116
    const/16 v0, 0x10

    new-array v0, v0, [F

    fill-array-data v0, :array_0

    return-object v0

    :array_0
    .array-data 4
        -0x40800000    # -1.0f
        -0x40800000    # -1.0f
        0x0
        0x3f800000    # 1.0f
        0x3f800000    # 1.0f
        -0x40800000    # -1.0f
        0x0
        0x3f800000    # 1.0f
        -0x40800000    # -1.0f
        0x3f800000    # 1.0f
        0x0
        0x3f800000    # 1.0f
        0x3f800000    # 1.0f
        0x3f800000    # 1.0f
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

.method public static getTextureCoordinateBounds()[F
    .locals 1

    .line 126
    const/16 v0, 0x10

    new-array v0, v0, [F

    fill-array-data v0, :array_0

    return-object v0

    :array_0
    .array-data 4
        0x0
        0x0
        0x0
        0x3f800000    # 1.0f
        0x3f800000    # 1.0f
        0x0
        0x0
        0x3f800000    # 1.0f
        0x0
        0x3f800000    # 1.0f
        0x0
        0x3f800000    # 1.0f
        0x3f800000    # 1.0f
        0x3f800000    # 1.0f
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

.method public static isBt2020PqExtensionSupported()Z
    .locals 2

    .line 229
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x11

    if-lt v0, v1, :cond_0

    const-string v0, "EGL_EXT_gl_colorspace_bt2020_pq"

    invoke-static {v0}, Landroidx/media3/common/util/GlUtil$Api17;->isExtensionSupported(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public static isProtectedContentExtensionSupported(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .line 166
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x18

    const/4 v2, 0x0

    if-ge v0, v1, :cond_0

    .line 167
    return v2

    .line 169
    :cond_0
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x1a

    if-ge v0, v1, :cond_2

    const-string/jumbo v0, "samsung"

    sget-object v3, Landroidx/media3/common/util/Util;->MANUFACTURER:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "XT1650"

    sget-object v3, Landroidx/media3/common/util/Util;->MODEL:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 174
    :cond_1
    return v2

    .line 176
    :cond_2
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    if-ge v0, v1, :cond_3

    .line 178
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 179
    const-string v1, "android.hardware.vr.high_performance"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 181
    return v2

    .line 184
    :cond_3
    const-string v0, "EGL_EXT_protected_content"

    invoke-static {v0}, Landroidx/media3/common/util/GlUtil$Api17;->isExtensionSupported(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isSurfacelessContextExtensionSupported()Z
    .locals 2

    .line 195
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x11

    if-lt v0, v1, :cond_0

    const-string v0, "EGL_KHR_surfaceless_context"

    invoke-static {v0}, Landroidx/media3/common/util/GlUtil$Api17;->isExtensionSupported(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public static isYuvTargetExtensionSupported()Z
    .locals 4

    .line 205
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x11

    const/4 v2, 0x0

    if-ge v0, v1, :cond_0

    .line 206
    return v2

    .line 209
    :cond_0
    invoke-static {}, Landroidx/media3/common/util/GlUtil$Api17;->getCurrentContext()Landroid/opengl/EGLContext;

    move-result-object v0

    sget-object v1, Landroid/opengl/EGL14;->EGL_NO_CONTEXT:Landroid/opengl/EGLContext;

    invoke-static {v0, v1}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    const/16 v1, 0x1f03

    if-eqz v0, :cond_1

    .line 212
    :try_start_0
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->getDefaultEglDisplay()Landroid/opengl/EGLDisplay;

    move-result-object v0

    .line 213
    .local v0, "eglDisplay":Landroid/opengl/EGLDisplay;
    invoke-static {v0}, Landroidx/media3/common/util/GlUtil;->createEglContext(Landroid/opengl/EGLDisplay;)Landroid/opengl/EGLContext;

    move-result-object v3

    .line 214
    .local v3, "eglContext":Landroid/opengl/EGLContext;
    invoke-static {v3, v0}, Landroidx/media3/common/util/GlUtil;->createFocusedPlaceholderEglSurface(Landroid/opengl/EGLContext;Landroid/opengl/EGLDisplay;)Landroid/opengl/EGLSurface;

    .line 215
    invoke-static {v1}, Landroid/opengl/GLES20;->glGetString(I)Ljava/lang/String;

    move-result-object v1

    .line 216
    .local v1, "glExtensions":Ljava/lang/String;
    invoke-static {v0, v3}, Landroidx/media3/common/util/GlUtil;->destroyEglContext(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)V
    :try_end_0
    .catch Landroidx/media3/common/util/GlUtil$GlException; {:try_start_0 .. :try_end_0} :catch_0

    .line 219
    .end local v0    # "eglDisplay":Landroid/opengl/EGLDisplay;
    .end local v3    # "eglContext":Landroid/opengl/EGLContext;
    goto :goto_0

    .line 217
    .end local v1    # "glExtensions":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 218
    .local v0, "e":Landroidx/media3/common/util/GlUtil$GlException;
    return v2

    .line 221
    .end local v0    # "e":Landroidx/media3/common/util/GlUtil$GlException;
    :cond_1
    invoke-static {v1}, Landroid/opengl/GLES20;->glGetString(I)Ljava/lang/String;

    move-result-object v1

    .line 224
    .restart local v1    # "glExtensions":Ljava/lang/String;
    :goto_0
    if-eqz v1, :cond_2

    const-string v0, "GL_EXT_YUV_target"

    invoke-virtual {v1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    const/4 v2, 0x1

    :cond_2
    return v2
.end method

.method public static setTexture(ILandroid/graphics/Bitmap;)V
    .locals 2
    .param p0, "texId"    # I
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 662
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    invoke-static {v0, v1}, Landroidx/media3/common/util/GlUtil;->assertValidTextureSize(II)V

    .line 663
    const/16 v0, 0xde1

    invoke-static {v0, p0}, Landroidx/media3/common/util/GlUtil;->bindTexture(II)V

    .line 664
    const/4 v1, 0x0

    invoke-static {v0, v1, p1, v1}, Landroid/opengl/GLUtils;->texImage2D(IILandroid/graphics/Bitmap;I)V

    .line 665
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 666
    return-void
.end method

.method public static setToIdentity([F)V
    .locals 1
    .param p0, "matrix"    # [F

    .line 143
    const/4 v0, 0x0

    invoke-static {p0, v0}, Landroid/opengl/Matrix;->setIdentityM([FI)V

    .line 144
    return-void
.end method
