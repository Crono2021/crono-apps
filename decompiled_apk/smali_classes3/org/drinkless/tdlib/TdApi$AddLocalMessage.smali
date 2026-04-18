.class public Lorg/drinkless/tdlib/TdApi$AddLocalMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddLocalMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x9e8485f


# instance fields
.field public chatId:J

.field public disableNotification:Z

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46500
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46501
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;ZLorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p4, "inputMessageReplyTo"    # Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;
    .param p5, "z8"    # Z
    .param p6, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 46487
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46488
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AddLocalMessage;->chatId:J

    .line 46489
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AddLocalMessage;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 46490
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AddLocalMessage;->replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;

    .line 46491
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$AddLocalMessage;->disableNotification:Z

    .line 46492
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$AddLocalMessage;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 46493
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46497
    const v0, -0x9e8485f

    return v0
.end method
