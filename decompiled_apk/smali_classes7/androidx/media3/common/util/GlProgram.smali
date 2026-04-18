.class public final Landroidx/media3/common/util/GlProgram;
.super Ljava/lang/Object;
.source "GlProgram.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/common/util/GlProgram$Attribute;,
        Landroidx/media3/common/util/GlProgram$Uniform;
    }
.end annotation


# static fields
.field private static final GL_SAMPLER_EXTERNAL_2D_Y2Y_EXT:I = 0x8be7


# instance fields
.field private final attributeByName:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/media3/common/util/GlProgram$Attribute;",
            ">;"
        }
    .end annotation
.end field

.field private final attributes:[Landroidx/media3/common/util/GlProgram$Attribute;

.field private final programId:I

.field private final uniformByName:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/media3/common/util/GlProgram$Uniform;",
            ">;"
        }
    .end annotation
.end field

.field private final uniforms:[Landroidx/media3/common/util/GlProgram$Uniform;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "vertexShaderFilePath"    # Ljava/lang/String;
    .param p3, "fragmentShaderFilePath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 59
    nop

    .line 60
    invoke-static {p1, p2}, Landroidx/media3/common/util/Util;->loadAsset(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 61
    invoke-static {p1, p3}, Landroidx/media3/common/util/Util;->loadAsset(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 59
    invoke-direct {p0, v0, v1}, Landroidx/media3/common/util/GlProgram;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "vertexShaderGlsl"    # Ljava/lang/String;
    .param p2, "fragmentShaderGlsl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 74
    invoke-static {}, Landroid/opengl/GLES20;->glCreateProgram()I

    move-result v0

    iput v0, p0, Landroidx/media3/common/util/GlProgram;->programId:I

    .line 75
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 78
    const v1, 0x8b31

    invoke-static {v0, v1, p1}, Landroidx/media3/common/util/GlProgram;->addShader(IILjava/lang/String;)V

    .line 79
    const v1, 0x8b30

    invoke-static {v0, v1, p2}, Landroidx/media3/common/util/GlProgram;->addShader(IILjava/lang/String;)V

    .line 82
    invoke-static {v0}, Landroid/opengl/GLES20;->glLinkProgram(I)V

    .line 83
    const/4 v1, 0x0

    filled-new-array {v1}, [I

    move-result-object v2

    .line 84
    .local v2, "linkStatus":[I
    const v3, 0x8b82

    invoke-static {v0, v3, v2, v1}, Landroid/opengl/GLES20;->glGetProgramiv(II[II)V

    .line 85
    aget v3, v2, v1

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    move v3, v4

    goto :goto_0

    :cond_0
    move v3, v1

    :goto_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unable to link shader program: \n"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 87
    invoke-static {v0}, Landroid/opengl/GLES20;->glGetProgramInfoLog(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 85
    invoke-static {v3, v5}, Landroidx/media3/common/util/GlUtil;->checkGlException(ZLjava/lang/String;)V

    .line 88
    invoke-static {v0}, Landroid/opengl/GLES20;->glUseProgram(I)V

    .line 89
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    iput-object v3, p0, Landroidx/media3/common/util/GlProgram;->attributeByName:Ljava/util/Map;

    .line 90
    new-array v3, v4, [I

    .line 91
    .local v3, "attributeCount":[I
    const v5, 0x8b89

    invoke-static {v0, v5, v3, v1}, Landroid/opengl/GLES20;->glGetProgramiv(II[II)V

    .line 92
    aget v0, v3, v1

    new-array v0, v0, [Landroidx/media3/common/util/GlProgram$Attribute;

    iput-object v0, p0, Landroidx/media3/common/util/GlProgram;->attributes:[Landroidx/media3/common/util/GlProgram$Attribute;

    .line 93
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    aget v5, v3, v1

    if-ge v0, v5, :cond_1

    .line 94
    iget v5, p0, Landroidx/media3/common/util/GlProgram;->programId:I

    invoke-static {v5, v0}, Landroidx/media3/common/util/GlProgram$Attribute;->create(II)Landroidx/media3/common/util/GlProgram$Attribute;

    move-result-object v5

    .line 95
    .local v5, "attribute":Landroidx/media3/common/util/GlProgram$Attribute;
    iget-object v6, p0, Landroidx/media3/common/util/GlProgram;->attributes:[Landroidx/media3/common/util/GlProgram$Attribute;

    aput-object v5, v6, v0

    .line 96
    iget-object v6, p0, Landroidx/media3/common/util/GlProgram;->attributeByName:Ljava/util/Map;

    iget-object v7, v5, Landroidx/media3/common/util/GlProgram$Attribute;->name:Ljava/lang/String;

    invoke-interface {v6, v7, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 93
    .end local v5    # "attribute":Landroidx/media3/common/util/GlProgram$Attribute;
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 98
    .end local v0    # "i":I
    :cond_1
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/media3/common/util/GlProgram;->uniformByName:Ljava/util/Map;

    .line 99
    new-array v0, v4, [I

    .line 100
    .local v0, "uniformCount":[I
    iget v4, p0, Landroidx/media3/common/util/GlProgram;->programId:I

    const v5, 0x8b86

    invoke-static {v4, v5, v0, v1}, Landroid/opengl/GLES20;->glGetProgramiv(II[II)V

    .line 101
    aget v4, v0, v1

    new-array v4, v4, [Landroidx/media3/common/util/GlProgram$Uniform;

    iput-object v4, p0, Landroidx/media3/common/util/GlProgram;->uniforms:[Landroidx/media3/common/util/GlProgram$Uniform;

    .line 102
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_2
    aget v5, v0, v1

    if-ge v4, v5, :cond_2

    .line 103
    iget v5, p0, Landroidx/media3/common/util/GlProgram;->programId:I

    invoke-static {v5, v4}, Landroidx/media3/common/util/GlProgram$Uniform;->create(II)Landroidx/media3/common/util/GlProgram$Uniform;

    move-result-object v5

    .line 104
    .local v5, "uniform":Landroidx/media3/common/util/GlProgram$Uniform;
    iget-object v6, p0, Landroidx/media3/common/util/GlProgram;->uniforms:[Landroidx/media3/common/util/GlProgram$Uniform;

    aput-object v5, v6, v4

    .line 105
    iget-object v6, p0, Landroidx/media3/common/util/GlProgram;->uniformByName:Ljava/util/Map;

    iget-object v7, v5, Landroidx/media3/common/util/GlProgram$Uniform;->name:Ljava/lang/String;

    invoke-interface {v6, v7, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    .end local v5    # "uniform":Landroidx/media3/common/util/GlProgram$Uniform;
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 107
    .end local v4    # "i":I
    :cond_2
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 108
    return-void
.end method

.method static synthetic access$000([B)I
    .locals 1
    .param p0, "x0"    # [B

    .line 36
    invoke-static {p0}, Landroidx/media3/common/util/GlProgram;->getCStringLength([B)I

    move-result v0

    return v0
.end method

.method static synthetic access$100(ILjava/lang/String;)I
    .locals 1
    .param p0, "x0"    # I
    .param p1, "x1"    # Ljava/lang/String;

    .line 36
    invoke-static {p0, p1}, Landroidx/media3/common/util/GlProgram;->getAttributeLocation(ILjava/lang/String;)I

    move-result v0

    return v0
.end method

.method static synthetic access$200(ILjava/lang/String;)I
    .locals 1
    .param p0, "x0"    # I
    .param p1, "x1"    # Ljava/lang/String;

    .line 36
    invoke-static {p0, p1}, Landroidx/media3/common/util/GlProgram;->getUniformLocation(ILjava/lang/String;)I

    move-result v0

    return v0
.end method

.method private static addShader(IILjava/lang/String;)V
    .locals 5
    .param p0, "programId"    # I
    .param p1, "type"    # I
    .param p2, "glsl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 111
    invoke-static {p1}, Landroid/opengl/GLES20;->glCreateShader(I)I

    move-result v0

    .line 112
    .local v0, "shader":I
    invoke-static {v0, p2}, Landroid/opengl/GLES20;->glShaderSource(ILjava/lang/String;)V

    .line 113
    invoke-static {v0}, Landroid/opengl/GLES20;->glCompileShader(I)V

    .line 115
    const/4 v1, 0x0

    filled-new-array {v1}, [I

    move-result-object v2

    .line 116
    .local v2, "result":[I
    const v3, 0x8b81

    invoke-static {v0, v3, v2, v1}, Landroid/opengl/GLES20;->glGetShaderiv(II[II)V

    .line 117
    aget v3, v2, v1

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    move v1, v4

    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 118
    invoke-static {v0}, Landroid/opengl/GLES20;->glGetShaderInfoLog(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", source: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 117
    invoke-static {v1, v3}, Landroidx/media3/common/util/GlUtil;->checkGlException(ZLjava/lang/String;)V

    .line 120
    invoke-static {p0, v0}, Landroid/opengl/GLES20;->glAttachShader(II)V

    .line 121
    invoke-static {v0}, Landroid/opengl/GLES20;->glDeleteShader(I)V

    .line 122
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 123
    return-void
.end method

.method private static getAttributeLocation(ILjava/lang/String;)I
    .locals 1
    .param p0, "programId"    # I
    .param p1, "attributeName"    # Ljava/lang/String;

    .line 126
    invoke-static {p0, p1}, Landroid/opengl/GLES20;->glGetAttribLocation(ILjava/lang/String;)I

    move-result v0

    return v0
.end method

.method private getAttributeLocation(Ljava/lang/String;)I
    .locals 1
    .param p1, "attributeName"    # Ljava/lang/String;

    .line 131
    iget v0, p0, Landroidx/media3/common/util/GlProgram;->programId:I

    invoke-static {v0, p1}, Landroidx/media3/common/util/GlProgram;->getAttributeLocation(ILjava/lang/String;)I

    move-result v0

    return v0
.end method

.method private static getCStringLength([B)I
    .locals 2
    .param p0, "cString"    # [B

    .line 219
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p0

    if-ge v0, v1, :cond_1

    .line 220
    aget-byte v1, p0, v0

    if-nez v1, :cond_0

    .line 221
    return v0

    .line 219
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 224
    .end local v0    # "i":I
    :cond_1
    array-length v0, p0

    return v0
.end method

.method private static getUniformLocation(ILjava/lang/String;)I
    .locals 1
    .param p0, "programId"    # I
    .param p1, "uniformName"    # Ljava/lang/String;

    .line 135
    invoke-static {p0, p1}, Landroid/opengl/GLES20;->glGetUniformLocation(ILjava/lang/String;)I

    move-result v0

    return v0
.end method


# virtual methods
.method public bindAttributesAndUniforms()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 209
    iget-object v0, p0, Landroidx/media3/common/util/GlProgram;->attributes:[Landroidx/media3/common/util/GlProgram$Attribute;

    array-length v1, v0

    const/4 v2, 0x0

    move v3, v2

    :goto_0
    if-ge v3, v1, :cond_0

    aget-object v4, v0, v3

    .line 210
    .local v4, "attribute":Landroidx/media3/common/util/GlProgram$Attribute;
    invoke-virtual {v4}, Landroidx/media3/common/util/GlProgram$Attribute;->bind()V

    .line 209
    .end local v4    # "attribute":Landroidx/media3/common/util/GlProgram$Attribute;
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 212
    :cond_0
    iget-object v0, p0, Landroidx/media3/common/util/GlProgram;->uniforms:[Landroidx/media3/common/util/GlProgram$Uniform;

    array-length v1, v0

    :goto_1
    if-ge v2, v1, :cond_1

    aget-object v3, v0, v2

    .line 213
    .local v3, "uniform":Landroidx/media3/common/util/GlProgram$Uniform;
    invoke-virtual {v3}, Landroidx/media3/common/util/GlProgram$Uniform;->bind()V

    .line 212
    .end local v3    # "uniform":Landroidx/media3/common/util/GlProgram$Uniform;
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 215
    :cond_1
    return-void
.end method

.method public delete()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 155
    iget v0, p0, Landroidx/media3/common/util/GlProgram;->programId:I

    invoke-static {v0}, Landroid/opengl/GLES20;->glDeleteProgram(I)V

    .line 156
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 157
    return-void
.end method

.method public getAttributeArrayLocationAndEnable(Ljava/lang/String;)I
    .locals 1
    .param p1, "attributeName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 164
    invoke-direct {p0, p1}, Landroidx/media3/common/util/GlProgram;->getAttributeLocation(Ljava/lang/String;)I

    move-result v0

    .line 165
    .local v0, "location":I
    invoke-static {v0}, Landroid/opengl/GLES20;->glEnableVertexAttribArray(I)V

    .line 166
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 167
    return v0
.end method

.method public getUniformLocation(Ljava/lang/String;)I
    .locals 1
    .param p1, "uniformName"    # Ljava/lang/String;

    .line 140
    iget v0, p0, Landroidx/media3/common/util/GlProgram;->programId:I

    invoke-static {v0, p1}, Landroidx/media3/common/util/GlProgram;->getUniformLocation(ILjava/lang/String;)I

    move-result v0

    return v0
.end method

.method public setBufferAttribute(Ljava/lang/String;[FI)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "values"    # [F
    .param p3, "size"    # I

    .line 172
    iget-object v0, p0, Landroidx/media3/common/util/GlProgram;->attributeByName:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/GlProgram$Attribute;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/GlProgram$Attribute;

    invoke-virtual {v0, p2, p3}, Landroidx/media3/common/util/GlProgram$Attribute;->setBuffer([FI)V

    .line 173
    return-void
.end method

.method public setFloatUniform(Ljava/lang/String;F)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # F

    .line 199
    iget-object v0, p0, Landroidx/media3/common/util/GlProgram;->uniformByName:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/GlProgram$Uniform;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/GlProgram$Uniform;

    invoke-virtual {v0, p2}, Landroidx/media3/common/util/GlProgram$Uniform;->setFloat(F)V

    .line 200
    return-void
.end method

.method public setFloatsUniform(Ljava/lang/String;[F)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # [F

    .line 204
    iget-object v0, p0, Landroidx/media3/common/util/GlProgram;->uniformByName:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/GlProgram$Uniform;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/GlProgram$Uniform;

    invoke-virtual {v0, p2}, Landroidx/media3/common/util/GlProgram$Uniform;->setFloats([F)V

    .line 205
    return-void
.end method

.method public setIntUniform(Ljava/lang/String;I)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # I

    .line 189
    iget-object v0, p0, Landroidx/media3/common/util/GlProgram;->uniformByName:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/GlProgram$Uniform;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/GlProgram$Uniform;

    invoke-virtual {v0, p2}, Landroidx/media3/common/util/GlProgram$Uniform;->setInt(I)V

    .line 190
    return-void
.end method

.method public setIntsUniform(Ljava/lang/String;[I)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # [I

    .line 194
    iget-object v0, p0, Landroidx/media3/common/util/GlProgram;->uniformByName:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/GlProgram$Uniform;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/GlProgram$Uniform;

    invoke-virtual {v0, p2}, Landroidx/media3/common/util/GlProgram$Uniform;->setInts([I)V

    .line 195
    return-void
.end method

.method public setSamplerTexIdUniform(Ljava/lang/String;II)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "texId"    # I
    .param p3, "texUnitIndex"    # I

    .line 184
    iget-object v0, p0, Landroidx/media3/common/util/GlProgram;->uniformByName:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/GlProgram$Uniform;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/GlProgram$Uniform;

    invoke-virtual {v0, p2, p3}, Landroidx/media3/common/util/GlProgram$Uniform;->setSamplerTexId(II)V

    .line 185
    return-void
.end method

.method public use()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 149
    iget v0, p0, Landroidx/media3/common/util/GlProgram;->programId:I

    invoke-static {v0}, Landroid/opengl/GLES20;->glUseProgram(I)V

    .line 150
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 151
    return-void
.end method
