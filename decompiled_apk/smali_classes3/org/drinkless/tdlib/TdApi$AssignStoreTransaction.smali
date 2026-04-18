.class public Lorg/drinkless/tdlib/TdApi$AssignStoreTransaction;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AssignStoreTransaction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x79f69414


# instance fields
.field public purpose:Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;

.field public transaction:Lorg/drinkless/tdlib/TdApi$StoreTransaction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22904
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22905
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StoreTransaction;Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;)V
    .locals 0
    .param p1, "storeTransaction"    # Lorg/drinkless/tdlib/TdApi$StoreTransaction;
    .param p2, "storePaymentPurpose"    # Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;

    .line 22894
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22895
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AssignStoreTransaction;->transaction:Lorg/drinkless/tdlib/TdApi$StoreTransaction;

    .line 22896
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AssignStoreTransaction;->purpose:Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;

    .line 22897
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22901
    const v0, -0x79f69414

    return v0
.end method
