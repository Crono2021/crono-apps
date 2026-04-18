.class public Lorg/drinkless/tdlib/TdApi$OrderInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OrderInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2ebad96e


# instance fields
.field public emailAddress:Ljava/lang/String;

.field public name:Ljava/lang/String;

.field public phoneNumber:Ljava/lang/String;

.field public shippingAddress:Lorg/drinkless/tdlib/TdApi$Address;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44430
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44431
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Address;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "address"    # Lorg/drinkless/tdlib/TdApi$Address;

    .line 44418
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44419
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$OrderInfo;->name:Ljava/lang/String;

    .line 44420
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$OrderInfo;->phoneNumber:Ljava/lang/String;

    .line 44421
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$OrderInfo;->emailAddress:Ljava/lang/String;

    .line 44422
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$OrderInfo;->shippingAddress:Lorg/drinkless/tdlib/TdApi$Address;

    .line 44423
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44427
    const v0, 0x2ebad96e

    return v0
.end method
