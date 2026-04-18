.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeEmbeddedVideoPlayer;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeEmbeddedVideoPlayer"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x584044fd


# instance fields
.field public duration:I

.field public height:I

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$Photo;

.field public url:Ljava/lang/String;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47956
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 47957
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;III)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "i11"    # I

    .line 47943
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 47944
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeEmbeddedVideoPlayer;->url:Ljava/lang/String;

    .line 47945
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeEmbeddedVideoPlayer;->thumbnail:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 47946
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeEmbeddedVideoPlayer;->duration:I

    .line 47947
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeEmbeddedVideoPlayer;->width:I

    .line 47948
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeEmbeddedVideoPlayer;->height:I

    .line 47949
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47953
    const v0, -0x584044fd

    return v0
.end method
