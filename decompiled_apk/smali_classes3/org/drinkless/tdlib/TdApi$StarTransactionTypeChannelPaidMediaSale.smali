.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidMediaSale;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeChannelPaidMediaSale"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3226a4d


# instance fields
.field public media:[Lorg/drinkless/tdlib/TdApi$PaidMedia;

.field public messageId:J

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40680
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 40681
    return-void
.end method

.method public constructor <init>(JJ[Lorg/drinkless/tdlib/TdApi$PaidMedia;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "paidMediaArr"    # [Lorg/drinkless/tdlib/TdApi$PaidMedia;

    .line 40669
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 40670
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidMediaSale;->userId:J

    .line 40671
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidMediaSale;->messageId:J

    .line 40672
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidMediaSale;->media:[Lorg/drinkless/tdlib/TdApi$PaidMedia;

    .line 40673
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40677
    const v0, 0x3226a4d

    return v0
.end method
