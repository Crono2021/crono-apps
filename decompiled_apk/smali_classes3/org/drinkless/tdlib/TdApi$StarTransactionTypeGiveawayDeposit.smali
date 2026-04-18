.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiveawayDeposit;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeGiveawayDeposit"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4e9dff3a


# instance fields
.field public chatId:J

.field public giveawayMessageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32608
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32609
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 32598
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32599
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiveawayDeposit;->chatId:J

    .line 32600
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiveawayDeposit;->giveawayMessageId:J

    .line 32601
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32605
    const v0, -0x4e9dff3a

    return v0
.end method
