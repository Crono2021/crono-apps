.class public Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeStarGiveaway;
.super Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StorePaymentPurposeStarGiveaway"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xc96d899


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public parameters:Lorg/drinkless/tdlib/TdApi$GiveawayParameters;

.field public starCount:J

.field public winnerCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48970
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 48971
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$GiveawayParameters;Ljava/lang/String;JIJ)V
    .locals 0
    .param p1, "giveawayParameters"    # Lorg/drinkless/tdlib/TdApi$GiveawayParameters;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "j5"    # J
    .param p5, "i9"    # I
    .param p6, "j9"    # J

    .line 48957
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 48958
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeStarGiveaway;->parameters:Lorg/drinkless/tdlib/TdApi$GiveawayParameters;

    .line 48959
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeStarGiveaway;->currency:Ljava/lang/String;

    .line 48960
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeStarGiveaway;->amount:J

    .line 48961
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeStarGiveaway;->winnerCount:I

    .line 48962
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeStarGiveaway;->starCount:J

    .line 48963
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48967
    const v0, 0xc96d899

    return v0
.end method
