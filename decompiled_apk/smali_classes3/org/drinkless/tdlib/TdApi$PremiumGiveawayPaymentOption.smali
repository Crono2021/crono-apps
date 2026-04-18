.class public Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOption;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumGiveawayPaymentOption"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4184cb88


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public monthCount:I

.field public storeProductId:Ljava/lang/String;

.field public storeProductQuantity:I

.field public winnerCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50458
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50459
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JIILjava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "i9"    # I
    .param p5, "i10"    # I
    .param p6, "str2"    # Ljava/lang/String;
    .param p7, "i11"    # I

    .line 50444
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50445
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOption;->currency:Ljava/lang/String;

    .line 50446
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOption;->amount:J

    .line 50447
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOption;->winnerCount:I

    .line 50448
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOption;->monthCount:I

    .line 50449
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOption;->storeProductId:Ljava/lang/String;

    .line 50450
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOption;->storeProductQuantity:I

    .line 50451
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50455
    const v0, 0x4184cb88

    return v0
.end method
