.class public Lorg/drinkless/tdlib/TdApi$GetPaymentForm;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPaymentForm"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PaymentForm;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x72b0892c


# instance fields
.field public inputInvoice:Lorg/drinkless/tdlib/TdApi$InputInvoice;

.field public theme:Lorg/drinkless/tdlib/TdApi$ThemeParameters;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26544
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26545
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputInvoice;Lorg/drinkless/tdlib/TdApi$ThemeParameters;)V
    .locals 0
    .param p1, "inputInvoice"    # Lorg/drinkless/tdlib/TdApi$InputInvoice;
    .param p2, "themeParameters"    # Lorg/drinkless/tdlib/TdApi$ThemeParameters;

    .line 26534
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26535
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetPaymentForm;->inputInvoice:Lorg/drinkless/tdlib/TdApi$InputInvoice;

    .line 26536
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetPaymentForm;->theme:Lorg/drinkless/tdlib/TdApi$ThemeParameters;

    .line 26537
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26541
    const v0, -0x72b0892c

    return v0
.end method
