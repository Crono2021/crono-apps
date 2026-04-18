.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidReactionSend;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeChannelPaidReactionSend"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3fd99840


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32428
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32429
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 32418
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32419
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidReactionSend;->chatId:J

    .line 32420
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidReactionSend;->messageId:J

    .line 32421
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32425
    const v0, -0x3fd99840    # -2.6000824f

    return v0
.end method
