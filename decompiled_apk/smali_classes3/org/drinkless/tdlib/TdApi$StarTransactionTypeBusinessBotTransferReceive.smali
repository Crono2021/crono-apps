.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBusinessBotTransferReceive;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeBusinessBotTransferReceive"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1fbd418a


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20112
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 20113
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 20103
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 20104
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBusinessBotTransferReceive;->userId:J

    .line 20105
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20109
    const v0, 0x1fbd418a

    return v0
.end method
