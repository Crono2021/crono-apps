.class public Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGiveaway;
.super Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StorePaymentPurposePremiumGiveaway"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4da47aaa


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public parameters:Lorg/drinkless/tdlib/TdApi$GiveawayParameters;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40856
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 40857
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$GiveawayParameters;Ljava/lang/String;J)V
    .locals 0
    .param p1, "giveawayParameters"    # Lorg/drinkless/tdlib/TdApi$GiveawayParameters;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "j5"    # J

    .line 40845
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 40846
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGiveaway;->parameters:Lorg/drinkless/tdlib/TdApi$GiveawayParameters;

    .line 40847
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGiveaway;->currency:Ljava/lang/String;

    .line 40848
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGiveaway;->amount:J

    .line 40849
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40853
    const v0, 0x4da47aaa    # 3.449378E8f

    return v0
.end method
