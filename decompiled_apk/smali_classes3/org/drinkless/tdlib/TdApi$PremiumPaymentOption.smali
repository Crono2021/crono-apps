.class public Lorg/drinkless/tdlib/TdApi$PremiumPaymentOption;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumPaymentOption"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x73f3a04e


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public discountPercentage:I

.field public monthCount:I

.field public paymentLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

.field public storeProductId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50486
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50487
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JIILjava/lang/String;Lorg/drinkless/tdlib/TdApi$InternalLinkType;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "i9"    # I
    .param p5, "i10"    # I
    .param p6, "str2"    # Ljava/lang/String;
    .param p7, "internalLinkType"    # Lorg/drinkless/tdlib/TdApi$InternalLinkType;

    .line 50472
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50473
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumPaymentOption;->currency:Ljava/lang/String;

    .line 50474
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$PremiumPaymentOption;->amount:J

    .line 50475
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$PremiumPaymentOption;->discountPercentage:I

    .line 50476
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$PremiumPaymentOption;->monthCount:I

    .line 50477
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$PremiumPaymentOption;->storeProductId:Ljava/lang/String;

    .line 50478
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$PremiumPaymentOption;->paymentLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

    .line 50479
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50483
    const v0, -0x73f3a04e

    return v0
.end method
