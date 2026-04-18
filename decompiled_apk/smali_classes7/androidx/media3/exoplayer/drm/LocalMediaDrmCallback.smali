.class public final Landroidx/media3/exoplayer/drm/LocalMediaDrmCallback;
.super Ljava/lang/Object;
.source "LocalMediaDrmCallback.java"

# interfaces
.implements Landroidx/media3/exoplayer/drm/MediaDrmCallback;


# instance fields
.field private final keyResponse:[B


# direct methods
.method public constructor <init>([B)V
    .locals 1
    .param p1, "keyResponse"    # [B

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    iput-object v0, p0, Landroidx/media3/exoplayer/drm/LocalMediaDrmCallback;->keyResponse:[B

    .line 40
    return-void
.end method


# virtual methods
.method public executeKeyRequest(Ljava/util/UUID;Landroidx/media3/exoplayer/drm/ExoMediaDrm$KeyRequest;)[B
    .locals 1
    .param p1, "uuid"    # Ljava/util/UUID;
    .param p2, "request"    # Landroidx/media3/exoplayer/drm/ExoMediaDrm$KeyRequest;

    .line 49
    iget-object v0, p0, Landroidx/media3/exoplayer/drm/LocalMediaDrmCallback;->keyResponse:[B

    return-object v0
.end method

.method public executeProvisionRequest(Ljava/util/UUID;Landroidx/media3/exoplayer/drm/ExoMediaDrm$ProvisionRequest;)[B
    .locals 1
    .param p1, "uuid"    # Ljava/util/UUID;
    .param p2, "request"    # Landroidx/media3/exoplayer/drm/ExoMediaDrm$ProvisionRequest;

    .line 44
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method
