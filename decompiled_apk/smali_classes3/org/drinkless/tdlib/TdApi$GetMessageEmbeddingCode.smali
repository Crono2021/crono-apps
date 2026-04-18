.class public Lorg/drinkless/tdlib/TdApi$GetMessageEmbeddingCode;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMessageEmbeddingCode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Text;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x62a4cd09


# instance fields
.field public chatId:J

.field public forAlbum:Z

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37422
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37423
    return-void
.end method

.method public constructor <init>(JJZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "z8"    # Z

    .line 37411
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37412
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMessageEmbeddingCode;->chatId:J

    .line 37413
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetMessageEmbeddingCode;->messageId:J

    .line 37414
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$GetMessageEmbeddingCode;->forAlbum:Z

    .line 37415
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37419
    const v0, 0x62a4cd09

    return v0
.end method
