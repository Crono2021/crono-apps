.class public Lorg/drinkless/tdlib/TdApi$TonTransactionTypeSuggestedPostPayment;
.super Lorg/drinkless/tdlib/TdApi$TonTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TonTransactionTypeSuggestedPostPayment"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x17a1b0f1


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21422
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TonTransactionType;-><init>()V

    .line 21423
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 21413
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TonTransactionType;-><init>()V

    .line 21414
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TonTransactionTypeSuggestedPostPayment;->chatId:J

    .line 21415
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21419
    const v0, -0x17a1b0f1

    return v0
.end method
