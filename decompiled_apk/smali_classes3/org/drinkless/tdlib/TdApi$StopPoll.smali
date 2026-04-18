.class public Lorg/drinkless/tdlib/TdApi$StopPoll;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StopPoll"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x62e80aad


# instance fields
.field public chatId:J

.field public messageId:J

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40790
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40791
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$ReplyMarkup;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 40779
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40780
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StopPoll;->chatId:J

    .line 40781
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StopPoll;->messageId:J

    .line 40782
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$StopPoll;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 40783
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40787
    const v0, 0x62e80aad

    return v0
.end method
