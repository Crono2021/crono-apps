.class public Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeStars;
.super Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TelegramPaymentPurposeStars"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x47d25a65


# instance fields
.field public amount:J

.field public chatId:J

.field public currency:Ljava/lang/String;

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45822
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 45823
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJJ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "j10"    # J

    .line 45810
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 45811
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeStars;->currency:Ljava/lang/String;

    .line 45812
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeStars;->amount:J

    .line 45813
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeStars;->starCount:J

    .line 45814
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeStars;->chatId:J

    .line 45815
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45819
    const v0, 0x47d25a65

    return v0
.end method
