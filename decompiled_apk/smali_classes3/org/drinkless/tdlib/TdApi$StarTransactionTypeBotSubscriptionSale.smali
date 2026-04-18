.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotSubscriptionSale;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeBotSubscriptionSale"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1f686889


# instance fields
.field public affiliate:Lorg/drinkless/tdlib/TdApi$AffiliateInfo;

.field public invoicePayload:[B

.field public productInfo:Lorg/drinkless/tdlib/TdApi$ProductInfo;

.field public subscriptionPeriod:I

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48892
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 48893
    return-void
.end method

.method public constructor <init>(JILorg/drinkless/tdlib/TdApi$ProductInfo;[BLorg/drinkless/tdlib/TdApi$AffiliateInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "productInfo"    # Lorg/drinkless/tdlib/TdApi$ProductInfo;
    .param p5, "bArr"    # [B
    .param p6, "affiliateInfo"    # Lorg/drinkless/tdlib/TdApi$AffiliateInfo;

    .line 48879
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 48880
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotSubscriptionSale;->userId:J

    .line 48881
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotSubscriptionSale;->subscriptionPeriod:I

    .line 48882
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotSubscriptionSale;->productInfo:Lorg/drinkless/tdlib/TdApi$ProductInfo;

    .line 48883
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotSubscriptionSale;->invoicePayload:[B

    .line 48884
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotSubscriptionSale;->affiliate:Lorg/drinkless/tdlib/TdApi$AffiliateInfo;

    .line 48885
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48889
    const v0, 0x1f686889

    return v0
.end method
