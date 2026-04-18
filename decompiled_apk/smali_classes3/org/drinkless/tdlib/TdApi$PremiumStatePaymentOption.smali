.class public Lorg/drinkless/tdlib/TdApi$PremiumStatePaymentOption;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumStatePaymentOption"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7d06b579


# instance fields
.field public isCurrent:Z

.field public isUpgrade:Z

.field public lastTransactionId:Ljava/lang/String;

.field public paymentOption:Lorg/drinkless/tdlib/TdApi$PremiumPaymentOption;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44718
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44719
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PremiumPaymentOption;ZZLjava/lang/String;)V
    .locals 0
    .param p1, "premiumPaymentOption"    # Lorg/drinkless/tdlib/TdApi$PremiumPaymentOption;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "str"    # Ljava/lang/String;

    .line 44706
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44707
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumStatePaymentOption;->paymentOption:Lorg/drinkless/tdlib/TdApi$PremiumPaymentOption;

    .line 44708
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PremiumStatePaymentOption;->isCurrent:Z

    .line 44709
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PremiumStatePaymentOption;->isUpgrade:Z

    .line 44710
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$PremiumStatePaymentOption;->lastTransactionId:Ljava/lang/String;

    .line 44711
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44715
    const v0, 0x7d06b579

    return v0
.end method
