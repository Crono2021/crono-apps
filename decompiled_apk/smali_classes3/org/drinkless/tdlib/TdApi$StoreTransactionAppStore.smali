.class public Lorg/drinkless/tdlib/TdApi$StoreTransactionAppStore;
.super Lorg/drinkless/tdlib/TdApi$StoreTransaction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoreTransactionAppStore"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x60e41d49


# instance fields
.field public receipt:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20328
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoreTransaction;-><init>()V

    .line 20329
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bArr"    # [B

    .line 20319
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoreTransaction;-><init>()V

    .line 20320
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoreTransactionAppStore;->receipt:[B

    .line 20321
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20325
    const v0, 0x60e41d49

    return v0
.end method
