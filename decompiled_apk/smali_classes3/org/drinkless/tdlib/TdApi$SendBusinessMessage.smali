.class public Lorg/drinkless/tdlib/TdApi$SendBusinessMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendBusinessMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BusinessMessage;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x987b403


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public chatId:J

.field public disableNotification:Z

.field public effectId:J

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public protectContent:Z

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52300
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 52301
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JLorg/drinkless/tdlib/TdApi$InputMessageReplyTo;ZZJLorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "inputMessageReplyTo"    # Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z
    .param p7, "j9"    # J
    .param p9, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p10, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 52284
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 52285
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessage;->businessConnectionId:Ljava/lang/String;

    .line 52286
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessage;->chatId:J

    .line 52287
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessage;->replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;

    .line 52288
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessage;->disableNotification:Z

    .line 52289
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessage;->protectContent:Z

    .line 52290
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessage;->effectId:J

    .line 52291
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessage;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 52292
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessage;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 52293
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52297
    const v0, 0x987b403

    return v0
.end method
