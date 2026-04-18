.class public Lorg/drinkless/tdlib/TdApi$EditBusinessMessageLiveLocation;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditBusinessMessageLiveLocation"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BusinessMessage;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1d80ae1f


# instance fields
.field public businessConnectionId:Ljava/lang/String;

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

    .line 52012
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 52013
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJLorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$Location;III)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p7, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p8, "i9"    # I
    .param p9, "i10"    # I
    .param p10, "i11"    # I

    .line 51996
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51997
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageLiveLocation;->businessConnectionId:Ljava/lang/String;

    .line 51998
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageLiveLocation;->chatId:J

    .line 51999
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageLiveLocation;->messageId:J

    .line 52000
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageLiveLocation;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 52001
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageLiveLocation;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 52002
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageLiveLocation;->livePeriod:I

    .line 52003
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageLiveLocation;->heading:I

    .line 52004
    iput p10, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageLiveLocation;->proximityAlertRadius:I

    .line 52005
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52009
    const v0, 0x1d80ae1f

    return v0
.end method
