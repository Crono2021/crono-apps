.class public Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeGiftedStars;
.super Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TelegramPaymentPurposeGiftedStars"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6e4975ca


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public starCount:J

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45798
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 45799
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "j9"    # J
    .param p6, "j10"    # J

    .line 45786
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 45787
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeGiftedStars;->userId:J

    .line 45788
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeGiftedStars;->currency:Ljava/lang/String;

    .line 45789
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeGiftedStars;->amount:J

    .line 45790
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeGiftedStars;->starCount:J

    .line 45791
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45795
    const v0, -0x6e4975ca

    return v0
.end method
