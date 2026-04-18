.class public Lorg/drinkless/tdlib/TdApi$PaymentReceiptTypeRegular;
.super Lorg/drinkless/tdlib/TdApi$PaymentReceiptType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaymentReceiptTypeRegular"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6188ea4a


# instance fields
.field public credentialsTitle:Ljava/lang/String;

.field public invoice:Lorg/drinkless/tdlib/TdApi$Invoice;

.field public orderInfo:Lorg/drinkless/tdlib/TdApi$OrderInfo;

.field public paymentProviderUserId:J

.field public shippingOption:Lorg/drinkless/tdlib/TdApi$ShippingOption;

.field public tipAmount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50430
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentReceiptType;-><init>()V

    .line 50431
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$Invoice;Lorg/drinkless/tdlib/TdApi$OrderInfo;Lorg/drinkless/tdlib/TdApi$ShippingOption;Ljava/lang/String;J)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "invoice"    # Lorg/drinkless/tdlib/TdApi$Invoice;
    .param p4, "orderInfo"    # Lorg/drinkless/tdlib/TdApi$OrderInfo;
    .param p5, "shippingOption"    # Lorg/drinkless/tdlib/TdApi$ShippingOption;
    .param p6, "str"    # Ljava/lang/String;
    .param p7, "j9"    # J

    .line 50416
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentReceiptType;-><init>()V

    .line 50417
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$PaymentReceiptTypeRegular;->paymentProviderUserId:J

    .line 50418
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PaymentReceiptTypeRegular;->invoice:Lorg/drinkless/tdlib/TdApi$Invoice;

    .line 50419
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$PaymentReceiptTypeRegular;->orderInfo:Lorg/drinkless/tdlib/TdApi$OrderInfo;

    .line 50420
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$PaymentReceiptTypeRegular;->shippingOption:Lorg/drinkless/tdlib/TdApi$ShippingOption;

    .line 50421
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$PaymentReceiptTypeRegular;->credentialsTitle:Ljava/lang/String;

    .line 50422
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$PaymentReceiptTypeRegular;->tipAmount:J

    .line 50423
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50427
    const v0, -0x6188ea4a

    return v0
.end method
