.class public Lorg/drinkless/tdlib/TdApi$PaymentReceiptTypeStars;
.super Lorg/drinkless/tdlib/TdApi$PaymentReceiptType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaymentReceiptTypeStars"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1194074c


# instance fields
.field public starCount:J

.field public transactionId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29264
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentReceiptType;-><init>()V

    .line 29265
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 29254
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentReceiptType;-><init>()V

    .line 29255
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$PaymentReceiptTypeStars;->starCount:J

    .line 29256
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PaymentReceiptTypeStars;->transactionId:Ljava/lang/String;

    .line 29257
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29261
    const v0, 0x1194074c

    return v0
.end method
