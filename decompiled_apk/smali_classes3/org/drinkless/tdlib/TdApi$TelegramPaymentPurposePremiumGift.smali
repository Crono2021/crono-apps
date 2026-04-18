.class public Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGift;
.super Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TelegramPaymentPurposePremiumGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5f626dc6


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public monthCount:I

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49048
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 49049
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJILorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "i9"    # I
    .param p7, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 49035
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 49036
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGift;->currency:Ljava/lang/String;

    .line 49037
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGift;->amount:J

    .line 49038
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGift;->userId:J

    .line 49039
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGift;->monthCount:I

    .line 49040
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGift;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 49041
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49045
    const v0, -0x5f626dc6

    return v0
.end method
