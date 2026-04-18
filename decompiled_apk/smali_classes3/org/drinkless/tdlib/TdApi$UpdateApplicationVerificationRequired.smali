.class public Lorg/drinkless/tdlib/TdApi$UpdateApplicationVerificationRequired;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateApplicationVerificationRequired"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3a639e29


# instance fields
.field public cloudProjectNumber:J

.field public nonce:Ljava/lang/String;

.field public verificationId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41472
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41473
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;J)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "j9"    # J

    .line 41461
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41462
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateApplicationVerificationRequired;->verificationId:J

    .line 41463
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateApplicationVerificationRequired;->nonce:Ljava/lang/String;

    .line 41464
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateApplicationVerificationRequired;->cloudProjectNumber:J

    .line 41465
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41469
    const v0, -0x3a639e29

    return v0
.end method
