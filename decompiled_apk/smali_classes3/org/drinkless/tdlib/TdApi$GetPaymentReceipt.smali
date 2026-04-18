.class public Lorg/drinkless/tdlib/TdApi$GetPaymentReceipt;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPaymentReceipt"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PaymentReceipt;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3c6cb956


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26564
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26565
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 26554
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26555
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetPaymentReceipt;->chatId:J

    .line 26556
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetPaymentReceipt;->messageId:J

    .line 26557
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26561
    const v0, 0x3c6cb956

    return v0
.end method
