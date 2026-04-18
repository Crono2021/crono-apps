.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeEmbeddedAudioPlayer;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeEmbeddedAudioPlayer"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x220b429c


# instance fields
.field public duration:I

.field public height:I

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$Photo;

.field public url:Ljava/lang/String;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47930
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 47931
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;III)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "i11"    # I

    .line 47917
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 47918
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeEmbeddedAudioPlayer;->url:Ljava/lang/String;

    .line 47919
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeEmbeddedAudioPlayer;->thumbnail:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 47920
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeEmbeddedAudioPlayer;->duration:I

    .line 47921
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeEmbeddedAudioPlayer;->width:I

    .line 47922
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeEmbeddedAudioPlayer;->height:I

    .line 47923
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47927
    const v0, 0x220b429c

    return v0
.end method
