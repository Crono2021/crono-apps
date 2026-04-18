.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotInvoicePurchase;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeBotInvoicePurchase"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1dddac0c


# instance fields
.field public productInfo:Lorg/drinkless/tdlib/TdApi$ProductInfo;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32368
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32369
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ProductInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "productInfo"    # Lorg/drinkless/tdlib/TdApi$ProductInfo;

    .line 32358
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32359
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotInvoicePurchase;->userId:J

    .line 32360
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotInvoicePurchase;->productInfo:Lorg/drinkless/tdlib/TdApi$ProductInfo;

    .line 32361
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32365
    const v0, 0x1dddac0c

    return v0
.end method
