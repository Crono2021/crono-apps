.class public Lorg/drinkless/tdlib/TdApi$CanPurchaseFromStore;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CanPurchaseFromStore"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3caa9368


# instance fields
.field public purpose:Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9438
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 9439
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;)V
    .locals 0
    .param p1, "storePaymentPurpose"    # Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;

    .line 9429
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 9430
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CanPurchaseFromStore;->purpose:Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;

    .line 9431
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9435
    const v0, 0x3caa9368

    return v0
.end method
