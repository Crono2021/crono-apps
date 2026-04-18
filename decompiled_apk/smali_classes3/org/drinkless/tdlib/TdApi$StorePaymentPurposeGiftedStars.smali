.class public Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeGiftedStars;
.super Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StorePaymentPurposeGiftedStars"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3544a624


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public starCount:J

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45582
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 45583
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "j9"    # J
    .param p6, "j10"    # J

    .line 45570
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 45571
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeGiftedStars;->userId:J

    .line 45572
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeGiftedStars;->currency:Ljava/lang/String;

    .line 45573
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeGiftedStars;->amount:J

    .line 45574
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeGiftedStars;->starCount:J

    .line 45575
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45579
    const v0, 0x3544a624

    return v0
.end method
