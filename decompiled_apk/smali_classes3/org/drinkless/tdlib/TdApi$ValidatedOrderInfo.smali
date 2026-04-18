.class public Lorg/drinkless/tdlib/TdApi$ValidatedOrderInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ValidatedOrderInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5a16eb5c


# instance fields
.field public orderInfoId:Ljava/lang/String;

.field public shippingOptions:[Lorg/drinkless/tdlib/TdApi$ShippingOption;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35268
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35269
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$ShippingOption;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "shippingOptionArr"    # [Lorg/drinkless/tdlib/TdApi$ShippingOption;

    .line 35258
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35259
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ValidatedOrderInfo;->orderInfoId:Ljava/lang/String;

    .line 35260
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ValidatedOrderInfo;->shippingOptions:[Lorg/drinkless/tdlib/TdApi$ShippingOption;

    .line 35261
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35265
    const v0, 0x5a16eb5c    # 1.0620007E16f

    return v0
.end method
