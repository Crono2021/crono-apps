.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBusinessBotTransferSend;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeBusinessBotTransferSend"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x48ca7526


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20130
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 20131
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 20121
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 20122
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeBusinessBotTransferSend;->userId:J

    .line 20123
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20127
    const v0, 0x48ca7526

    return v0
.end method
