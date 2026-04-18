.class public Lorg/drinkless/tdlib/TdApi$StarTransaction;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransaction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7f820a90


# instance fields
.field public date:I

.field public id:Ljava/lang/String;

.field public isRefund:Z

.field public starAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

.field public type:Lorg/drinkless/tdlib/TdApi$StarTransactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48866
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48867
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$StarAmount;ZILorg/drinkless/tdlib/TdApi$StarTransactionType;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "starAmount"    # Lorg/drinkless/tdlib/TdApi$StarAmount;
    .param p3, "z8"    # Z
    .param p4, "i9"    # I
    .param p5, "starTransactionType"    # Lorg/drinkless/tdlib/TdApi$StarTransactionType;

    .line 48853
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48854
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransaction;->id:Ljava/lang/String;

    .line 48855
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StarTransaction;->starAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 48856
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransaction;->isRefund:Z

    .line 48857
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$StarTransaction;->date:I

    .line 48858
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$StarTransaction;->type:Lorg/drinkless/tdlib/TdApi$StarTransactionType;

    .line 48859
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48863
    const v0, 0x7f820a90

    return v0
.end method
