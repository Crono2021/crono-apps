.class public Lorg/drinkless/tdlib/TdApi$TestBytes;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestBytes"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5bdd3b22


# instance fields
.field public value:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20904
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20905
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bArr"    # [B

    .line 20895
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20896
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestBytes;->value:[B

    .line 20897
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20901
    const v0, -0x5bdd3b22

    return v0
.end method
