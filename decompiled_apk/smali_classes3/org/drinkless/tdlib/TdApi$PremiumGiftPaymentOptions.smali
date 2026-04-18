.class public Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOptions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumGiftPaymentOptions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5051dff8


# instance fields
.field public options:[Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOption;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17808
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 17809
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOption;)V
    .locals 0
    .param p1, "premiumGiftPaymentOptionArr"    # [Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOption;

    .line 17799
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 17800
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOptions;->options:[Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOption;

    .line 17801
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17805
    const v0, -0x5051dff8

    return v0
.end method
