.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentMediaAlbum;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentMediaAlbum"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2c9c1691


# instance fields
.field public hasAudios:Z

.field public hasDocuments:Z

.field public hasPhotos:Z

.field public hasVideos:Z

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48476
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 48477
    return-void
.end method

.method public constructor <init>(IZZZZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "z10"    # Z
    .param p5, "z11"    # Z

    .line 48463
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 48464
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentMediaAlbum;->totalCount:I

    .line 48465
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentMediaAlbum;->hasPhotos:Z

    .line 48466
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentMediaAlbum;->hasVideos:Z

    .line 48467
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentMediaAlbum;->hasAudios:Z

    .line 48468
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentMediaAlbum;->hasDocuments:Z

    .line 48469
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48473
    const v0, -0x2c9c1691

    return v0
.end method
