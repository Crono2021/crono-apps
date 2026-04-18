.class public Lorg/drinkless/tdlib/TdApi$TestCallBytes;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestCallBytes"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$TestBytes;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2bdea557


# instance fields
.field public f8021x:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20924
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20925
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bArr"    # [B

    .line 20915
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20916
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestCallBytes;->f8021x:[B

    .line 20917
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20921
    const v0, -0x2bdea557

    return v0
.end method
