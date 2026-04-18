.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotInvoiceSale;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeBotInvoiceSale"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5b7d8d2f


# instance fields
.field public affiliate:Lorg/drinkless/tdlib/TdApi$AffiliateInfo;

.field public invoicePayload:[B

.field public productInfo:Lorg/drinkless/tdlib/TdApi$ProductInfo;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45414
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 45415
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ProductInfo;[BLorg/drinkless/tdlib/TdApi$AffiliateInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "productInfo"    # Lorg/drinkless/tdlib/TdApi$ProductInfo;
    .param p4, "bArr"    # [B
    .param p5, "affiliateInfo"    # Lorg/drinkless/tdlib/TdApi$AffiliateInfo;

    .line 45402
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 45403
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotInvoiceSale;->userId:J

    .line 45404
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotInvoiceSale;->productInfo:Lorg/drinkless/tdlib/TdApi$ProductInfo;

    .line 45405
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotInvoiceSale;->invoicePayload:[B

    .line 45406
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotInvoiceSale;->affiliate:Lorg/drinkless/tdlib/TdApi$AffiliateInfo;

    .line 45407
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45411
    const v0, 0x5b7d8d2f

    return v0
.end method
