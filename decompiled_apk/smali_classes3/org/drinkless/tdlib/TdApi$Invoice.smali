.class public Lorg/drinkless/tdlib/TdApi$Invoice;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Invoice"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6bf5e8c


# instance fields
.field public currency:Ljava/lang/String;

.field public isFlexible:Z

.field public isTest:Z

.field public maxTipAmount:J

.field public needEmailAddress:Z

.field public needName:Z

.field public needPhoneNumber:Z

.field public needShippingAddress:Z

.field public priceParts:[Lorg/drinkless/tdlib/TdApi$LabeledPricePart;

.field public recurringPaymentTermsOfServiceUrl:Ljava/lang/String;

.field public sendEmailAddressToProvider:Z

.field public sendPhoneNumberToProvider:Z

.field public subscriptionPeriod:I

.field public suggestedTipAmounts:[J

.field public termsOfServiceUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54650
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54651
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$LabeledPricePart;IJ[JLjava/lang/String;Ljava/lang/String;ZZZZZZZZ)V
    .locals 16
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "labeledPricePartArr"    # [Lorg/drinkless/tdlib/TdApi$LabeledPricePart;
    .param p3, "i9"    # I
    .param p4, "j5"    # J
    .param p6, "jArr"    # [J
    .param p7, "str2"    # Ljava/lang/String;
    .param p8, "str3"    # Ljava/lang/String;
    .param p9, "z8"    # Z
    .param p10, "z9"    # Z
    .param p11, "z10"    # Z
    .param p12, "z11"    # Z
    .param p13, "z12"    # Z
    .param p14, "z13"    # Z
    .param p15, "z14"    # Z
    .param p16, "z15"    # Z

    .line 54627
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54628
    move-object/from16 v1, p1

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->currency:Ljava/lang/String;

    .line 54629
    move-object/from16 v2, p2

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->priceParts:[Lorg/drinkless/tdlib/TdApi$LabeledPricePart;

    .line 54630
    move/from16 v3, p3

    iput v3, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->subscriptionPeriod:I

    .line 54631
    move-wide/from16 v4, p4

    iput-wide v4, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->maxTipAmount:J

    .line 54632
    move-object/from16 v6, p6

    iput-object v6, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->suggestedTipAmounts:[J

    .line 54633
    move-object/from16 v7, p7

    iput-object v7, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->recurringPaymentTermsOfServiceUrl:Ljava/lang/String;

    .line 54634
    move-object/from16 v8, p8

    iput-object v8, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->termsOfServiceUrl:Ljava/lang/String;

    .line 54635
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->isTest:Z

    .line 54636
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->needName:Z

    .line 54637
    move/from16 v11, p11

    iput-boolean v11, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->needPhoneNumber:Z

    .line 54638
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->needEmailAddress:Z

    .line 54639
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->needShippingAddress:Z

    .line 54640
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->sendPhoneNumberToProvider:Z

    .line 54641
    move/from16 v15, p15

    iput-boolean v15, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->sendEmailAddressToProvider:Z

    .line 54642
    move/from16 v1, p16

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Invoice;->isFlexible:Z

    .line 54643
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54647
    const v0, 0x6bf5e8c

    return v0
.end method
