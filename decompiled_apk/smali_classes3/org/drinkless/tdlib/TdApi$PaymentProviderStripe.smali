.class public Lorg/drinkless/tdlib/TdApi$PaymentProviderStripe;
.super Lorg/drinkless/tdlib/TdApi$PaymentProvider;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaymentProviderStripe"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1614e19b


# instance fields
.field public needCardholderName:Z

.field public needCountry:Z

.field public needPostalCode:Z

.field public publishableKey:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44598
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentProvider;-><init>()V

    .line 44599
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZZZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "z10"    # Z

    .line 44586
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentProvider;-><init>()V

    .line 44587
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PaymentProviderStripe;->publishableKey:Ljava/lang/String;

    .line 44588
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PaymentProviderStripe;->needCountry:Z

    .line 44589
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PaymentProviderStripe;->needPostalCode:Z

    .line 44590
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$PaymentProviderStripe;->needCardholderName:Z

    .line 44591
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44595
    const v0, 0x1614e19b

    return v0
.end method
