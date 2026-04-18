.class public Lorg/drinkless/tdlib/TdApi$ValidateOrderInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ValidateOrderInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ValidatedOrderInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4a67a031


# instance fields
.field public allowSave:Z

.field public inputInvoice:Lorg/drinkless/tdlib/TdApi$InputInvoice;

.field public orderInfo:Lorg/drinkless/tdlib/TdApi$OrderInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42066
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42067
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputInvoice;Lorg/drinkless/tdlib/TdApi$OrderInfo;Z)V
    .locals 0
    .param p1, "inputInvoice"    # Lorg/drinkless/tdlib/TdApi$InputInvoice;
    .param p2, "orderInfo"    # Lorg/drinkless/tdlib/TdApi$OrderInfo;
    .param p3, "z8"    # Z

    .line 42055
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42056
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ValidateOrderInfo;->inputInvoice:Lorg/drinkless/tdlib/TdApi$InputInvoice;

    .line 42057
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ValidateOrderInfo;->orderInfo:Lorg/drinkless/tdlib/TdApi$OrderInfo;

    .line 42058
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ValidateOrderInfo;->allowSave:Z

    .line 42059
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42063
    const v0, -0x4a67a031

    return v0
.end method
