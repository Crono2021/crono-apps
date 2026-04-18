.class public Lorg/drinkless/tdlib/TdApi$SendPaymentForm;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendPaymentForm"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PaymentResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3991c776


# instance fields
.field public credentials:Lorg/drinkless/tdlib/TdApi$InputCredentials;

.field public inputInvoice:Lorg/drinkless/tdlib/TdApi$InputInvoice;

.field public orderInfoId:Ljava/lang/String;

.field public paymentFormId:J

.field public shippingOptionId:Ljava/lang/String;

.field public tipAmount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50738
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 50739
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputInvoice;JLjava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$InputCredentials;J)V
    .locals 0
    .param p1, "inputInvoice"    # Lorg/drinkless/tdlib/TdApi$InputInvoice;
    .param p2, "j5"    # J
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "str2"    # Ljava/lang/String;
    .param p6, "inputCredentials"    # Lorg/drinkless/tdlib/TdApi$InputCredentials;
    .param p7, "j9"    # J

    .line 50724
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 50725
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SendPaymentForm;->inputInvoice:Lorg/drinkless/tdlib/TdApi$InputInvoice;

    .line 50726
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$SendPaymentForm;->paymentFormId:J

    .line 50727
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SendPaymentForm;->orderInfoId:Ljava/lang/String;

    .line 50728
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SendPaymentForm;->shippingOptionId:Ljava/lang/String;

    .line 50729
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$SendPaymentForm;->credentials:Lorg/drinkless/tdlib/TdApi$InputCredentials;

    .line 50730
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$SendPaymentForm;->tipAmount:J

    .line 50731
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50735
    const v0, -0x3991c776

    return v0
.end method
