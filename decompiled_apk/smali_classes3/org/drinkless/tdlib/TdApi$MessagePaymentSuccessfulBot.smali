.class public Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessfulBot;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessagePaymentSuccessfulBot"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3899b241


# instance fields
.field public currency:Ljava/lang/String;

.field public invoicePayload:[B

.field public isFirstRecurring:Z

.field public isRecurring:Z

.field public orderInfo:Lorg/drinkless/tdlib/TdApi$OrderInfo;

.field public providerPaymentChargeId:Ljava/lang/String;

.field public shippingOptionId:Ljava/lang/String;

.field public subscriptionUntilDate:I

.field public telegramPaymentChargeId:Ljava/lang/String;

.field public totalAmount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53348
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 53349
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JIZZ[BLjava/lang/String;Lorg/drinkless/tdlib/TdApi$OrderInfo;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "i9"    # I
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z
    .param p7, "bArr"    # [B
    .param p8, "str2"    # Ljava/lang/String;
    .param p9, "orderInfo"    # Lorg/drinkless/tdlib/TdApi$OrderInfo;
    .param p10, "str3"    # Ljava/lang/String;
    .param p11, "str4"    # Ljava/lang/String;

    .line 53330
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 53331
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessfulBot;->currency:Ljava/lang/String;

    .line 53332
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessfulBot;->totalAmount:J

    .line 53333
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessfulBot;->subscriptionUntilDate:I

    .line 53334
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessfulBot;->isRecurring:Z

    .line 53335
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessfulBot;->isFirstRecurring:Z

    .line 53336
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessfulBot;->invoicePayload:[B

    .line 53337
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessfulBot;->shippingOptionId:Ljava/lang/String;

    .line 53338
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessfulBot;->orderInfo:Lorg/drinkless/tdlib/TdApi$OrderInfo;

    .line 53339
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessfulBot;->telegramPaymentChargeId:Ljava/lang/String;

    .line 53340
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessfulBot;->providerPaymentChargeId:Ljava/lang/String;

    .line 53341
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53345
    const v0, -0x3899b241

    return v0
.end method
