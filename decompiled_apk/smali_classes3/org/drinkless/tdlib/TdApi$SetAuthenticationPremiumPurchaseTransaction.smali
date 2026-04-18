.class public Lorg/drinkless/tdlib/TdApi$SetAuthenticationPremiumPurchaseTransaction;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetAuthenticationPremiumPurchaseTransaction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1ae18387


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public isRestore:Z

.field public transaction:Lorg/drinkless/tdlib/TdApi$StoreTransaction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45198
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45199
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StoreTransaction;ZLjava/lang/String;J)V
    .locals 0
    .param p1, "storeTransaction"    # Lorg/drinkless/tdlib/TdApi$StoreTransaction;
    .param p2, "z8"    # Z
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "j5"    # J

    .line 45186
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45187
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetAuthenticationPremiumPurchaseTransaction;->transaction:Lorg/drinkless/tdlib/TdApi$StoreTransaction;

    .line 45188
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$SetAuthenticationPremiumPurchaseTransaction;->isRestore:Z

    .line 45189
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetAuthenticationPremiumPurchaseTransaction;->currency:Ljava/lang/String;

    .line 45190
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$SetAuthenticationPremiumPurchaseTransaction;->amount:J

    .line 45191
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45195
    const v0, -0x1ae18387

    return v0
.end method
