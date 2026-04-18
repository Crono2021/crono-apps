.class public Lorg/drinkless/tdlib/TdApi$UpdateNewPreCheckoutQuery;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewPreCheckoutQuery"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2a3871c9


# instance fields
.field public currency:Ljava/lang/String;

.field public id:J

.field public invoicePayload:[B

.field public orderInfo:Lorg/drinkless/tdlib/TdApi$OrderInfo;

.field public senderUserId:J

.field public shippingOptionId:Ljava/lang/String;

.field public totalAmount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51824
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 51825
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;J[BLjava/lang/String;Lorg/drinkless/tdlib/TdApi$OrderInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "j10"    # J
    .param p8, "bArr"    # [B
    .param p9, "str2"    # Ljava/lang/String;
    .param p10, "orderInfo"    # Lorg/drinkless/tdlib/TdApi$OrderInfo;

    .line 51809
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 51810
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewPreCheckoutQuery;->id:J

    .line 51811
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewPreCheckoutQuery;->senderUserId:J

    .line 51812
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewPreCheckoutQuery;->currency:Ljava/lang/String;

    .line 51813
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewPreCheckoutQuery;->totalAmount:J

    .line 51814
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewPreCheckoutQuery;->invoicePayload:[B

    .line 51815
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewPreCheckoutQuery;->shippingOptionId:Ljava/lang/String;

    .line 51816
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewPreCheckoutQuery;->orderInfo:Lorg/drinkless/tdlib/TdApi$OrderInfo;

    .line 51817
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51821
    const v0, 0x2a3871c9

    return v0
.end method
