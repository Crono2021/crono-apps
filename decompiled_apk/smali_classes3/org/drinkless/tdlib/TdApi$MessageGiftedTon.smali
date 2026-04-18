.class public Lorg/drinkless/tdlib/TdApi$MessageGiftedTon;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageGiftedTon"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2daf9e1b


# instance fields
.field public gifterUserId:J

.field public receiverUserId:J

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public tonAmount:J

.field public transactionId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48086
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 48087
    return-void
.end method

.method public constructor <init>(JJJLjava/lang/String;Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "j10"    # J
    .param p7, "str"    # Ljava/lang/String;
    .param p8, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 48073
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 48074
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedTon;->gifterUserId:J

    .line 48075
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedTon;->receiverUserId:J

    .line 48076
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedTon;->tonAmount:J

    .line 48077
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedTon;->transactionId:Ljava/lang/String;

    .line 48078
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$MessageGiftedTon;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 48079
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48083
    const v0, 0x2daf9e1b

    return v0
.end method
