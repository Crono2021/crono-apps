.class public Lorg/drinkless/tdlib/TdApi$PaymentFormTypeRegular;
.super Lorg/drinkless/tdlib/TdApi$PaymentFormType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaymentFormTypeRegular"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x24a98672


# instance fields
.field public additionalPaymentOptions:[Lorg/drinkless/tdlib/TdApi$PaymentOption;

.field public canSaveCredentials:Z

.field public invoice:Lorg/drinkless/tdlib/TdApi$Invoice;

.field public needPassword:Z

.field public paymentProvider:Lorg/drinkless/tdlib/TdApi$PaymentProvider;

.field public paymentProviderUserId:J

.field public savedCredentials:[Lorg/drinkless/tdlib/TdApi$SavedCredentials;

.field public savedOrderInfo:Lorg/drinkless/tdlib/TdApi$OrderInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52172
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentFormType;-><init>()V

    .line 52173
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Invoice;JLorg/drinkless/tdlib/TdApi$PaymentProvider;[Lorg/drinkless/tdlib/TdApi$PaymentOption;Lorg/drinkless/tdlib/TdApi$OrderInfo;[Lorg/drinkless/tdlib/TdApi$SavedCredentials;ZZ)V
    .locals 0
    .param p1, "invoice"    # Lorg/drinkless/tdlib/TdApi$Invoice;
    .param p2, "j5"    # J
    .param p4, "paymentProvider"    # Lorg/drinkless/tdlib/TdApi$PaymentProvider;
    .param p5, "paymentOptionArr"    # [Lorg/drinkless/tdlib/TdApi$PaymentOption;
    .param p6, "orderInfo"    # Lorg/drinkless/tdlib/TdApi$OrderInfo;
    .param p7, "savedCredentialsArr"    # [Lorg/drinkless/tdlib/TdApi$SavedCredentials;
    .param p8, "z8"    # Z
    .param p9, "z9"    # Z

    .line 52156
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentFormType;-><init>()V

    .line 52157
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PaymentFormTypeRegular;->invoice:Lorg/drinkless/tdlib/TdApi$Invoice;

    .line 52158
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$PaymentFormTypeRegular;->paymentProviderUserId:J

    .line 52159
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$PaymentFormTypeRegular;->paymentProvider:Lorg/drinkless/tdlib/TdApi$PaymentProvider;

    .line 52160
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$PaymentFormTypeRegular;->additionalPaymentOptions:[Lorg/drinkless/tdlib/TdApi$PaymentOption;

    .line 52161
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$PaymentFormTypeRegular;->savedOrderInfo:Lorg/drinkless/tdlib/TdApi$OrderInfo;

    .line 52162
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$PaymentFormTypeRegular;->savedCredentials:[Lorg/drinkless/tdlib/TdApi$SavedCredentials;

    .line 52163
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$PaymentFormTypeRegular;->canSaveCredentials:Z

    .line 52164
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$PaymentFormTypeRegular;->needPassword:Z

    .line 52165
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52169
    const v0, -0x24a98672

    return v0
.end method
