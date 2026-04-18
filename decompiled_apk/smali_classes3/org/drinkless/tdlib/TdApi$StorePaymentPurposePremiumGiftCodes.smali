.class public Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGiftCodes;
.super Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StorePaymentPurposePremiumGiftCodes"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3fe9cc10


# instance fields
.field public amount:J

.field public boostedChatId:J

.field public currency:Ljava/lang/String;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48944
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 48945
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;J[JLorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "j9"    # J
    .param p6, "jArr"    # [J
    .param p7, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 48931
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 48932
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGiftCodes;->boostedChatId:J

    .line 48933
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGiftCodes;->currency:Ljava/lang/String;

    .line 48934
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGiftCodes;->amount:J

    .line 48935
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGiftCodes;->userIds:[J

    .line 48936
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumGiftCodes;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 48937
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48941
    const v0, -0x3fe9cc10

    return v0
.end method
