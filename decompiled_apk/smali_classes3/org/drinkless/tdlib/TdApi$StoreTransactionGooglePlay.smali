.class public Lorg/drinkless/tdlib/TdApi$StoreTransactionGooglePlay;
.super Lorg/drinkless/tdlib/TdApi$StoreTransaction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoreTransactionGooglePlay"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x41356639


# instance fields
.field public packageName:Ljava/lang/String;

.field public purchaseToken:Ljava/lang/String;

.field public storeProductId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40878
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoreTransaction;-><init>()V

    .line 40879
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;

    .line 40867
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoreTransaction;-><init>()V

    .line 40868
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoreTransactionGooglePlay;->packageName:Ljava/lang/String;

    .line 40869
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StoreTransactionGooglePlay;->storeProductId:Ljava/lang/String;

    .line 40870
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StoreTransactionGooglePlay;->purchaseToken:Ljava/lang/String;

    .line 40871
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40875
    const v0, 0x41356639

    return v0
.end method
