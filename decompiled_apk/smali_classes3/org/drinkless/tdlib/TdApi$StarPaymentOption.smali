.class public Lorg/drinkless/tdlib/TdApi$StarPaymentOption;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarPaymentOption"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x514dd7ef


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public isAdditional:Z

.field public starCount:J

.field public storeProductId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48814
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48815
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJLjava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "str2"    # Ljava/lang/String;
    .param p7, "z8"    # Z

    .line 48801
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48802
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarPaymentOption;->currency:Ljava/lang/String;

    .line 48803
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$StarPaymentOption;->amount:J

    .line 48804
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$StarPaymentOption;->starCount:J

    .line 48805
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$StarPaymentOption;->storeProductId:Ljava/lang/String;

    .line 48806
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$StarPaymentOption;->isAdditional:Z

    .line 48807
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48811
    const v0, -0x514dd7ef

    return v0
.end method
