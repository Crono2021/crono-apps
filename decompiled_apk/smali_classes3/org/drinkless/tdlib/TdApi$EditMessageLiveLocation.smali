.class public Lorg/drinkless/tdlib/TdApi$EditMessageLiveLocation;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditMessageLiveLocation"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x70aeec6c


# instance fields
.field public chatId:J

.field public heading:I

.field public livePeriod:I

.field public location:Lorg/drinkless/tdlib/TdApi$Location;

.field public messageId:J

.field public proximityAlertRadius:I

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51254
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51255
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$Location;III)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p6, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p7, "i9"    # I
    .param p8, "i10"    # I
    .param p9, "i11"    # I

    .line 51239
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51240
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EditMessageLiveLocation;->chatId:J

    .line 51241
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$EditMessageLiveLocation;->messageId:J

    .line 51242
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$EditMessageLiveLocation;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 51243
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EditMessageLiveLocation;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 51244
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$EditMessageLiveLocation;->livePeriod:I

    .line 51245
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$EditMessageLiveLocation;->heading:I

    .line 51246
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$EditMessageLiveLocation;->proximityAlertRadius:I

    .line 51247
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51251
    const v0, -0x70aeec6c

    return v0
.end method
