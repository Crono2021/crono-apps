.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeSuggestedPostPaymentSend;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeSuggestedPostPaymentSend"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1e545c75


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20184
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 20185
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 20175
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 20176
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeSuggestedPostPaymentSend;->chatId:J

    .line 20177
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20181
    const v0, 0x1e545c75

    return v0
.end method
