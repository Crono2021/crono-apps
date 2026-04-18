.class public Lorg/drinkless/tdlib/TdApi$InputInvoiceMessage;
.super Lorg/drinkless/tdlib/TdApi$InputInvoice;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInvoiceMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x58dcea10


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27304
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInvoice;-><init>()V

    .line 27305
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 27294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInvoice;-><init>()V

    .line 27295
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InputInvoiceMessage;->chatId:J

    .line 27296
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$InputInvoiceMessage;->messageId:J

    .line 27297
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27301
    const v0, 0x58dcea10

    return v0
.end method
