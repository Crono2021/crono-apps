.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidReactionReceive;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeChannelPaidReactionReceive"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x23d6f9eb


# instance fields
.field public messageId:J

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32408
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32409
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 32398
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32399
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidReactionReceive;->userId:J

    .line 32400
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelPaidReactionReceive;->messageId:J

    .line 32401
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32405
    const v0, 0x23d6f9eb

    return v0
.end method
