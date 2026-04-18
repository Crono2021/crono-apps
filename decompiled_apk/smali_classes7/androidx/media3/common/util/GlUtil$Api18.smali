.class final Landroidx/media3/common/util/GlUtil$Api18;
.super Ljava/lang/Object;
.source "GlUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/common/util/GlUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Api18"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 935
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createSyncFence()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 939
    const v0, 0x9117

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/opengl/GLES30;->glFenceSync(II)J

    move-result-wide v0

    .line 940
    .local v0, "syncObject":J
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 945
    invoke-static {}, Landroid/opengl/GLES20;->glFlush()V

    .line 946
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 947
    return-wide v0
.end method

.method public static deleteSyncObject(J)V
    .locals 0
    .param p0, "syncObject"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 952
    invoke-static {p0, p1}, Landroid/opengl/GLES30;->glDeleteSync(J)V

    .line 953
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 954
    return-void
.end method

.method public static waitSync(J)V
    .locals 3
    .param p0, "syncObject"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/util/GlUtil$GlException;
        }
    .end annotation

    .line 958
    const/4 v0, 0x0

    const-wide/16 v1, -0x1

    invoke-static {p0, p1, v0, v1, v2}, Landroid/opengl/GLES30;->glWaitSync(JIJ)V

    .line 959
    invoke-static {}, Landroidx/media3/common/util/GlUtil;->checkGlError()V

    .line 960
    return-void
.end method
