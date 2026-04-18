.class public Lorg/drinkless/tdlib/TdApi$MessagePremiumGiftCode;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessagePremiumGiftCode"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x29d22e4e


# instance fields
.field public amount:J

.field public code:Ljava/lang/String;

.field public creatorId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public cryptocurrency:Ljava/lang/String;

.field public cryptocurrencyAmount:J

.field public currency:Ljava/lang/String;

.field public isFromGiveaway:Z

.field public isUnclaimed:Z

.field public monthCount:I

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53792
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 53793
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$FormattedText;ZZLjava/lang/String;JLjava/lang/String;JILorg/drinkless/tdlib/TdApi$Sticker;Ljava/lang/String;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "j5"    # J
    .param p8, "str2"    # Ljava/lang/String;
    .param p9, "j9"    # J
    .param p11, "i9"    # I
    .param p12, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p13, "str3"    # Ljava/lang/String;

    .line 53773
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 53774
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessagePremiumGiftCode;->creatorId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 53775
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessagePremiumGiftCode;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 53776
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$MessagePremiumGiftCode;->isFromGiveaway:Z

    .line 53777
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$MessagePremiumGiftCode;->isUnclaimed:Z

    .line 53778
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$MessagePremiumGiftCode;->currency:Ljava/lang/String;

    .line 53779
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$MessagePremiumGiftCode;->amount:J

    .line 53780
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$MessagePremiumGiftCode;->cryptocurrency:Ljava/lang/String;

    .line 53781
    iput-wide p9, p0, Lorg/drinkless/tdlib/TdApi$MessagePremiumGiftCode;->cryptocurrencyAmount:J

    .line 53782
    iput p11, p0, Lorg/drinkless/tdlib/TdApi$MessagePremiumGiftCode;->monthCount:I

    .line 53783
    iput-object p12, p0, Lorg/drinkless/tdlib/TdApi$MessagePremiumGiftCode;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 53784
    iput-object p13, p0, Lorg/drinkless/tdlib/TdApi$MessagePremiumGiftCode;->code:Ljava/lang/String;

    .line 53785
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53789
    const v0, 0x29d22e4e

    return v0
.end method
