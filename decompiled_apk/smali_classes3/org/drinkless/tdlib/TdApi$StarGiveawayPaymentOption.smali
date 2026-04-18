.class public Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarGiveawayPaymentOption"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x21ae9559


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public isAdditional:Z

.field public isDefault:Z

.field public starCount:J

.field public storeProductId:Ljava/lang/String;

.field public winnerOptions:[Lorg/drinkless/tdlib/TdApi$StarGiveawayWinnerOption;

.field public yearlyBoostCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52332
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52333
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJLjava/lang/String;I[Lorg/drinkless/tdlib/TdApi$StarGiveawayWinnerOption;ZZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "str2"    # Ljava/lang/String;
    .param p7, "i9"    # I
    .param p8, "starGiveawayWinnerOptionArr"    # [Lorg/drinkless/tdlib/TdApi$StarGiveawayWinnerOption;
    .param p9, "z8"    # Z
    .param p10, "z9"    # Z

    .line 52316
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52317
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;->currency:Ljava/lang/String;

    .line 52318
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;->amount:J

    .line 52319
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;->starCount:J

    .line 52320
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;->storeProductId:Ljava/lang/String;

    .line 52321
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;->yearlyBoostCount:I

    .line 52322
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;->winnerOptions:[Lorg/drinkless/tdlib/TdApi$StarGiveawayWinnerOption;

    .line 52323
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;->isDefault:Z

    .line 52324
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;->isAdditional:Z

    .line 52325
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52329
    const v0, 0x21ae9559

    return v0
.end method
