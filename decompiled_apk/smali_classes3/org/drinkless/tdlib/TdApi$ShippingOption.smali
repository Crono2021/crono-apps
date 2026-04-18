.class public Lorg/drinkless/tdlib/TdApi$ShippingOption;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ShippingOption"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x54fa4d91


# instance fields
.field public id:Ljava/lang/String;

.field public priceParts:[Lorg/drinkless/tdlib/TdApi$LabeledPricePart;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40570
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40571
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$LabeledPricePart;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "labeledPricePartArr"    # [Lorg/drinkless/tdlib/TdApi$LabeledPricePart;

    .line 40559
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40560
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ShippingOption;->id:Ljava/lang/String;

    .line 40561
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ShippingOption;->title:Ljava/lang/String;

    .line 40562
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ShippingOption;->priceParts:[Lorg/drinkless/tdlib/TdApi$LabeledPricePart;

    .line 40563
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40567
    const v0, 0x54fa4d91

    return v0
.end method
