.class public Lorg/drinkless/tdlib/TdApi$MessageGiftedStars;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageGiftedStars"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x41bdbea7


# instance fields
.field public amount:J

.field public cryptocurrency:Ljava/lang/String;

.field public cryptocurrencyAmount:J

.field public currency:Ljava/lang/String;

.field public gifterUserId:J

.field public receiverUserId:J

.field public starCount:J

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public transactionId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52902
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 52903
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;JLjava/lang/String;JJLjava/lang/String;Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "j10"    # J
    .param p8, "str2"    # Ljava/lang/String;
    .param p9, "j11"    # J
    .param p11, "j12"    # J
    .param p13, "str3"    # Ljava/lang/String;
    .param p14, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 52885
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 52886
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedStars;->gifterUserId:J

    .line 52887
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedStars;->receiverUserId:J

    .line 52888
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedStars;->currency:Ljava/lang/String;

    .line 52889
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedStars;->amount:J

    .line 52890
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedStars;->cryptocurrency:Ljava/lang/String;

    .line 52891
    iput-wide p9, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedStars;->cryptocurrencyAmount:J

    .line 52892
    iput-wide p11, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedStars;->starCount:J

    .line 52893
    iput-object p13, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedStars;->transactionId:Ljava/lang/String;

    .line 52894
    iput-object p14, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedStars;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 52895
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52899
    const v0, 0x41bdbea7

    return v0
.end method
