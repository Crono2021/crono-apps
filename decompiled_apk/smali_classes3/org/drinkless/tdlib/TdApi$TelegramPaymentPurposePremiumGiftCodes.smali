.class public Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiftCodes;
.super Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TelegramPaymentPurposePremiumGiftCodes"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6f12aeb4


# instance fields
.field public amount:J

.field public boostedChatId:J

.field public currency:Ljava/lang/String;

.field public monthCount:I

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50822
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 50823
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;J[JILorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "j9"    # J
    .param p6, "jArr"    # [J
    .param p7, "i9"    # I
    .param p8, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 50808
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 50809
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiftCodes;->boostedChatId:J

    .line 50810
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiftCodes;->currency:Ljava/lang/String;

    .line 50811
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiftCodes;->amount:J

    .line 50812
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiftCodes;->userIds:[J

    .line 50813
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiftCodes;->monthCount:I

    .line 50814
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiftCodes;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 50815
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50819
    const v0, -0x6f12aeb4

    return v0
.end method
