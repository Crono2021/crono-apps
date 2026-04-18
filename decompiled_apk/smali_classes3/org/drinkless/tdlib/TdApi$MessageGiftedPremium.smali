.class public Lorg/drinkless/tdlib/TdApi$MessageGiftedPremium;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageGiftedPremium"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1b2f1f86


# instance fields
.field public amount:J

.field public cryptocurrency:Ljava/lang/String;

.field public cryptocurrencyAmount:J

.field public currency:Ljava/lang/String;

.field public gifterUserId:J

.field public monthCount:I

.field public receiverUserId:J

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52868
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 52869
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$FormattedText;Ljava/lang/String;JLjava/lang/String;JILorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p6, "str"    # Ljava/lang/String;
    .param p7, "j10"    # J
    .param p9, "str2"    # Ljava/lang/String;
    .param p10, "j11"    # J
    .param p12, "i9"    # I
    .param p13, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 52851
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 52852
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedPremium;->gifterUserId:J

    .line 52853
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedPremium;->receiverUserId:J

    .line 52854
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedPremium;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 52855
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedPremium;->currency:Ljava/lang/String;

    .line 52856
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedPremium;->amount:J

    .line 52857
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedPremium;->cryptocurrency:Ljava/lang/String;

    .line 52858
    iput-wide p10, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedPremium;->cryptocurrencyAmount:J

    .line 52859
    iput p12, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedPremium;->monthCount:I

    .line 52860
    iput-object p13, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedPremium;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 52861
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52865
    const v0, -0x1b2f1f86

    return v0
.end method
