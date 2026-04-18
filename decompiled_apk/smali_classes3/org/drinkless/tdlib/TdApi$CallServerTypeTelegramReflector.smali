.class public Lorg/drinkless/tdlib/TdApi$CallServerTypeTelegramReflector;
.super Lorg/drinkless/tdlib/TdApi$CallServerType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallServerTypeTelegramReflector"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x32af3515


# instance fields
.field public isTcp:Z

.field public peerTag:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23444
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallServerType;-><init>()V

    .line 23445
    return-void
.end method

.method public constructor <init>([BZ)V
    .locals 0
    .param p1, "bArr"    # [B
    .param p2, "z8"    # Z

    .line 23434
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallServerType;-><init>()V

    .line 23435
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CallServerTypeTelegramReflector;->peerTag:[B

    .line 23436
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$CallServerTypeTelegramReflector;->isTcp:Z

    .line 23437
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23441
    const v0, 0x32af3515

    return v0
.end method
