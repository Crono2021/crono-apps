.class public Lorg/drinkless/tdlib/TdApi$MessageInvoice;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageInvoice"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xfadfd46


# instance fields
.field public currency:Ljava/lang/String;

.field public isTest:Z

.field public needShippingAddress:Z

.field public paidMedia:Lorg/drinkless/tdlib/TdApi$PaidMedia;

.field public paidMediaCaption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public productInfo:Lorg/drinkless/tdlib/TdApi$ProductInfo;

.field public receiptMessageId:J

.field public startParameter:Ljava/lang/String;

.field public totalAmount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52936
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 52937
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ProductInfo;Ljava/lang/String;JLjava/lang/String;ZZJLorg/drinkless/tdlib/TdApi$PaidMedia;Lorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "productInfo"    # Lorg/drinkless/tdlib/TdApi$ProductInfo;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "j5"    # J
    .param p5, "str2"    # Ljava/lang/String;
    .param p6, "z8"    # Z
    .param p7, "z9"    # Z
    .param p8, "j9"    # J
    .param p10, "paidMedia"    # Lorg/drinkless/tdlib/TdApi$PaidMedia;
    .param p11, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 52919
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 52920
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageInvoice;->productInfo:Lorg/drinkless/tdlib/TdApi$ProductInfo;

    .line 52921
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageInvoice;->currency:Ljava/lang/String;

    .line 52922
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$MessageInvoice;->totalAmount:J

    .line 52923
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$MessageInvoice;->startParameter:Ljava/lang/String;

    .line 52924
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$MessageInvoice;->isTest:Z

    .line 52925
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$MessageInvoice;->needShippingAddress:Z

    .line 52926
    iput-wide p8, p0, Lorg/drinkless/tdlib/TdApi$MessageInvoice;->receiptMessageId:J

    .line 52927
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$MessageInvoice;->paidMedia:Lorg/drinkless/tdlib/TdApi$PaidMedia;

    .line 52928
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$MessageInvoice;->paidMediaCaption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 52929
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52933
    const v0, 0xfadfd46

    return v0
.end method
