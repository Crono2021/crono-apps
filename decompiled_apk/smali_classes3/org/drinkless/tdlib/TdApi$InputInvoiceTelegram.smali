.class public Lorg/drinkless/tdlib/TdApi$InputInvoiceTelegram;
.super Lorg/drinkless/tdlib/TdApi$InputInvoice;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInvoiceTelegram"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x69130113


# instance fields
.field public purpose:Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14712
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInvoice;-><init>()V

    .line 14713
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;)V
    .locals 0
    .param p1, "telegramPaymentPurpose"    # Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;

    .line 14703
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInvoice;-><init>()V

    .line 14704
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInvoiceTelegram;->purpose:Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;

    .line 14705
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14709
    const v0, -0x69130113

    return v0
.end method
