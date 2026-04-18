.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeExternalAudio;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeExternalAudio"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x757d0013


# instance fields
.field public duration:I

.field public mimeType:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38326
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 38327
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "i9"    # I

    .line 38315
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 38316
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeExternalAudio;->url:Ljava/lang/String;

    .line 38317
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeExternalAudio;->mimeType:Ljava/lang/String;

    .line 38318
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeExternalAudio;->duration:I

    .line 38319
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38323
    const v0, -0x757d0013

    return v0
.end method
