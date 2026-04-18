.class public Lorg/drinkless/tdlib/TdApi$MessageReplyToMessage;
.super Lorg/drinkless/tdlib/TdApi$MessageReplyTo;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageReplyToMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7bdc3879


# instance fields
.field public chatId:J

.field public checklistTaskId:I

.field public content:Lorg/drinkless/tdlib/TdApi$MessageContent;

.field public messageId:J

.field public origin:Lorg/drinkless/tdlib/TdApi$MessageOrigin;

.field public originSendDate:I

.field public quote:Lorg/drinkless/tdlib/TdApi$TextQuote;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51554
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageReplyTo;-><init>()V

    .line 51555
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$TextQuote;ILorg/drinkless/tdlib/TdApi$MessageOrigin;ILorg/drinkless/tdlib/TdApi$MessageContent;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "textQuote"    # Lorg/drinkless/tdlib/TdApi$TextQuote;
    .param p6, "i9"    # I
    .param p7, "messageOrigin"    # Lorg/drinkless/tdlib/TdApi$MessageOrigin;
    .param p8, "i10"    # I
    .param p9, "messageContent"    # Lorg/drinkless/tdlib/TdApi$MessageContent;

    .line 51539
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageReplyTo;-><init>()V

    .line 51540
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyToMessage;->chatId:J

    .line 51541
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyToMessage;->messageId:J

    .line 51542
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyToMessage;->quote:Lorg/drinkless/tdlib/TdApi$TextQuote;

    .line 51543
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyToMessage;->checklistTaskId:I

    .line 51544
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyToMessage;->origin:Lorg/drinkless/tdlib/TdApi$MessageOrigin;

    .line 51545
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyToMessage;->originSendDate:I

    .line 51546
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyToMessage;->content:Lorg/drinkless/tdlib/TdApi$MessageContent;

    .line 51547
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51551
    const v0, -0x7bdc3879

    return v0
.end method
