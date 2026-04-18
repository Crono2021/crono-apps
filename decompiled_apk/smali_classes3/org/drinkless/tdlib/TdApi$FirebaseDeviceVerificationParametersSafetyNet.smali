.class public Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParametersSafetyNet;
.super Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParameters;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FirebaseDeviceVerificationParametersSafetyNet"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2b96b2f1


# instance fields
.field public nonce:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11940
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParameters;-><init>()V

    .line 11941
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bArr"    # [B

    .line 11931
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParameters;-><init>()V

    .line 11932
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParametersSafetyNet;->nonce:[B

    .line 11933
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11937
    const v0, 0x2b96b2f1

    return v0
.end method
