.class public Lorg/drinkless/tdlib/TdApi$PaymentForm;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaymentForm"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7720ffb3


# instance fields
.field public id:J

.field public productInfo:Lorg/drinkless/tdlib/TdApi$ProductInfo;

.field public sellerBotUserId:J

.field public type:Lorg/drinkless/tdlib/TdApi$PaymentFormType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44574
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44575
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$PaymentFormType;JLorg/drinkless/tdlib/TdApi$ProductInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "paymentFormType"    # Lorg/drinkless/tdlib/TdApi$PaymentFormType;
    .param p4, "j9"    # J
    .param p6, "productInfo"    # Lorg/drinkless/tdlib/TdApi$ProductInfo;

    .line 44562
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44563
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$PaymentForm;->id:J

    .line 44564
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PaymentForm;->type:Lorg/drinkless/tdlib/TdApi$PaymentFormType;

    .line 44565
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$PaymentForm;->sellerBotUserId:J

    .line 44566
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$PaymentForm;->productInfo:Lorg/drinkless/tdlib/TdApi$ProductInfo;

    .line 44567
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44571
    const v0, 0x7720ffb3

    return v0
.end method
