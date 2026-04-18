.class public Lorg/drinkless/tdlib/TdApi$EncryptGroupCallData;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EncryptGroupCallData"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Data;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1687c97a


# instance fields
.field public data:[B

.field public dataChannel:Lorg/drinkless/tdlib/TdApi$GroupCallDataChannel;

.field public groupCallId:I

.field public unencryptedPrefixSize:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43254
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43255
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$GroupCallDataChannel;[BI)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "groupCallDataChannel"    # Lorg/drinkless/tdlib/TdApi$GroupCallDataChannel;
    .param p3, "bArr"    # [B
    .param p4, "i10"    # I

    .line 43242
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43243
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$EncryptGroupCallData;->groupCallId:I

    .line 43244
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$EncryptGroupCallData;->dataChannel:Lorg/drinkless/tdlib/TdApi$GroupCallDataChannel;

    .line 43245
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$EncryptGroupCallData;->data:[B

    .line 43246
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$EncryptGroupCallData;->unencryptedPrefixSize:I

    .line 43247
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43251
    const v0, -0x1687c97a

    return v0
.end method
