.class public Lorg/drinkless/tdlib/TdApi$RefundStarPayment;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RefundStarPayment"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6b895fab


# instance fields
.field public telegramPaymentChargeId:Ljava/lang/String;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29848
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29849
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 29838
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29839
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$RefundStarPayment;->userId:J

    .line 29840
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$RefundStarPayment;->telegramPaymentChargeId:Ljava/lang/String;

    .line 29841
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29845
    const v0, -0x6b895fab

    return v0
.end method
