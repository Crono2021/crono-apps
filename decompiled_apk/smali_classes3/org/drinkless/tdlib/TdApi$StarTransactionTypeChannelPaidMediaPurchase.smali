.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidMediaPurchase;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeChannelPaidMediaPurchase"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4ec1273a


# instance fields
.field public chatId:J

.field public media:[Lorg/drinkless/tdlib/TdApi$PaidMedia;

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40658
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 40659
    return-void
.end method

.method public constructor <init>(JJ[Lorg/drinkless/tdlib/TdApi$PaidMedia;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "paidMediaArr"    # [Lorg/drinkless/tdlib/TdApi$PaidMedia;

    .line 40647
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 40648
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidMediaPurchase;->chatId:J

    .line 40649
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidMediaPurchase;->messageId:J

    .line 40650
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidMediaPurchase;->media:[Lorg/drinkless/tdlib/TdApi$PaidMedia;

    .line 40651
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40655
    const v0, -0x4ec1273a

    return v0
.end method
