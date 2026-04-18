.class public Lorg/drinkless/tdlib/TdApi$PaymentReceipt;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaymentReceipt"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2d313392


# instance fields
.field public date:I

.field public productInfo:Lorg/drinkless/tdlib/TdApi$ProductInfo;

.field public sellerBotUserId:J

.field public type:Lorg/drinkless/tdlib/TdApi$PaymentReceiptType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44622
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44623
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ProductInfo;IJLorg/drinkless/tdlib/TdApi$PaymentReceiptType;)V
    .locals 0
    .param p1, "productInfo"    # Lorg/drinkless/tdlib/TdApi$ProductInfo;
    .param p2, "i9"    # I
    .param p3, "j5"    # J
    .param p5, "paymentReceiptType"    # Lorg/drinkless/tdlib/TdApi$PaymentReceiptType;

    .line 44610
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44611
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PaymentReceipt;->productInfo:Lorg/drinkless/tdlib/TdApi$ProductInfo;

    .line 44612
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$PaymentReceipt;->date:I

    .line 44613
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$PaymentReceipt;->sellerBotUserId:J

    .line 44614
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$PaymentReceipt;->type:Lorg/drinkless/tdlib/TdApi$PaymentReceiptType;

    .line 44615
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44619
    const v0, 0x2d313392

    return v0
.end method
