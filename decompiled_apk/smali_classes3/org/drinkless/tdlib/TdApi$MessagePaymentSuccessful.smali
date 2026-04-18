.class public Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessful;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessagePaymentSuccessful"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3e661911


# instance fields
.field public currency:Ljava/lang/String;

.field public invoiceChatId:J

.field public invoiceMessageId:J

.field public invoiceName:Ljava/lang/String;

.field public isFirstRecurring:Z

.field public isRecurring:Z

.field public subscriptionUntilDate:I

.field public totalAmount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52108
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 52109
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;JIZZLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "j10"    # J
    .param p8, "i9"    # I
    .param p9, "z8"    # Z
    .param p10, "z9"    # Z
    .param p11, "str2"    # Ljava/lang/String;

    .line 52092
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 52093
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessful;->invoiceChatId:J

    .line 52094
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessful;->invoiceMessageId:J

    .line 52095
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessful;->currency:Ljava/lang/String;

    .line 52096
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessful;->totalAmount:J

    .line 52097
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessful;->subscriptionUntilDate:I

    .line 52098
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessful;->isRecurring:Z

    .line 52099
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessful;->isFirstRecurring:Z

    .line 52100
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$MessagePaymentSuccessful;->invoiceName:Ljava/lang/String;

    .line 52101
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52105
    const v0, 0x3e661911

    return v0
.end method
