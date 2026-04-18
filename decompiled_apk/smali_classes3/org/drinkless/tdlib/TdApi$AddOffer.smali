.class public Lorg/drinkless/tdlib/TdApi$AddOffer;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddOffer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x28ad631b


# instance fields
.field public chatId:J

.field public messageId:J

.field public options:Lorg/drinkless/tdlib/TdApi$MessageSendOptions;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35420
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35421
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$MessageSendOptions;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "messageSendOptions"    # Lorg/drinkless/tdlib/TdApi$MessageSendOptions;

    .line 35409
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35410
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AddOffer;->chatId:J

    .line 35411
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$AddOffer;->messageId:J

    .line 35412
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$AddOffer;->options:Lorg/drinkless/tdlib/TdApi$MessageSendOptions;

    .line 35413
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35417
    const v0, 0x28ad631b

    return v0
.end method
