.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotPaidMediaPurchase;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeBotPaidMediaPurchase"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3a366d85


# instance fields
.field public media:[Lorg/drinkless/tdlib/TdApi$PaidMedia;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32388
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32389
    return-void
.end method

.method public constructor <init>(J[Lorg/drinkless/tdlib/TdApi$PaidMedia;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "paidMediaArr"    # [Lorg/drinkless/tdlib/TdApi$PaidMedia;

    .line 32378
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32379
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotPaidMediaPurchase;->userId:J

    .line 32380
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBotPaidMediaPurchase;->media:[Lorg/drinkless/tdlib/TdApi$PaidMedia;

    .line 32381
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32385
    const v0, 0x3a366d85

    return v0
.end method
