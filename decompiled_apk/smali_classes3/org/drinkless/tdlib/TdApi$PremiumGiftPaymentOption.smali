.class public Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOption;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumGiftPaymentOption"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1426c4a3


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public discountPercentage:I

.field public monthCount:I

.field public starCount:J

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public storeProductId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51704
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51705
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJIILjava/lang/String;Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "i9"    # I
    .param p7, "i10"    # I
    .param p8, "str2"    # Ljava/lang/String;
    .param p9, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 51689
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51690
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOption;->currency:Ljava/lang/String;

    .line 51691
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOption;->amount:J

    .line 51692
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOption;->starCount:J

    .line 51693
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOption;->discountPercentage:I

    .line 51694
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOption;->monthCount:I

    .line 51695
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOption;->storeProductId:Ljava/lang/String;

    .line 51696
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiftPaymentOption;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 51697
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51701
    const v0, -0x1426c4a3

    return v0
.end method
