.class public Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGift;
.super Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StorePaymentPurposePremiumGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x25ac26b


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45606
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 45607
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJLorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 45594
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 45595
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGift;->currency:Ljava/lang/String;

    .line 45596
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGift;->amount:J

    .line 45597
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGift;->userId:J

    .line 45598
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGift;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 45599
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45603
    const v0, -0x25ac26b

    return v0
.end method
