.class public Lorg/drinkless/tdlib/TdApi$AnswerShippingQuery;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AnswerShippingQuery"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x19e77d6c


# instance fields
.field public errorMessage:Ljava/lang/String;

.field public shippingOptions:[Lorg/drinkless/tdlib/TdApi$ShippingOption;

.field public shippingQueryId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35662
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35663
    return-void
.end method

.method public constructor <init>(J[Lorg/drinkless/tdlib/TdApi$ShippingOption;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "shippingOptionArr"    # [Lorg/drinkless/tdlib/TdApi$ShippingOption;
    .param p4, "str"    # Ljava/lang/String;

    .line 35651
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35652
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AnswerShippingQuery;->shippingQueryId:J

    .line 35653
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AnswerShippingQuery;->shippingOptions:[Lorg/drinkless/tdlib/TdApi$ShippingOption;

    .line 35654
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AnswerShippingQuery;->errorMessage:Ljava/lang/String;

    .line 35655
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35659
    const v0, -0x19e77d6c

    return v0
.end method
