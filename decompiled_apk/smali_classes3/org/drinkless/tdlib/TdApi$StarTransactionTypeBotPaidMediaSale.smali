.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotPaidMediaSale;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeBotPaidMediaSale"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3da7d1b4


# instance fields
.field public affiliate:Lorg/drinkless/tdlib/TdApi$AffiliateInfo;

.field public media:[Lorg/drinkless/tdlib/TdApi$PaidMedia;

.field public payload:Ljava/lang/String;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45438
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 45439
    return-void
.end method

.method public constructor <init>(J[Lorg/drinkless/tdlib/TdApi$PaidMedia;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$AffiliateInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "paidMediaArr"    # [Lorg/drinkless/tdlib/TdApi$PaidMedia;
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "affiliateInfo"    # Lorg/drinkless/tdlib/TdApi$AffiliateInfo;

    .line 45426
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 45427
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotPaidMediaSale;->userId:J

    .line 45428
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotPaidMediaSale;->media:[Lorg/drinkless/tdlib/TdApi$PaidMedia;

    .line 45429
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotPaidMediaSale;->payload:Ljava/lang/String;

    .line 45430
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotPaidMediaSale;->affiliate:Lorg/drinkless/tdlib/TdApi$AffiliateInfo;

    .line 45431
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45435
    const v0, -0x3da7d1b4

    return v0
.end method
