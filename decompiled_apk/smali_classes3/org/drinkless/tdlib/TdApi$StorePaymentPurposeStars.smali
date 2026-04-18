.class public Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeStars;
.super Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StorePaymentPurposeStars"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1872fdcf


# instance fields
.field public amount:J

.field public chatId:J

.field public currency:Ljava/lang/String;

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45630
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 45631
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJJ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "j10"    # J

    .line 45618
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 45619
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeStars;->currency:Ljava/lang/String;

    .line 45620
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeStars;->amount:J

    .line 45621
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeStars;->starCount:J

    .line 45622
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposeStars;->chatId:J

    .line 45623
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45627
    const v0, 0x1872fdcf

    return v0
.end method
