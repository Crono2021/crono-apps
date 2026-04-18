.class public Lorg/drinkless/tdlib/TdApi$InputMessageReplyToExternalMessage;
.super Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageReplyToExternalMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1e1de91f


# instance fields
.field public chatId:J

.field public checklistTaskId:I

.field public messageId:J

.field public quote:Lorg/drinkless/tdlib/TdApi$InputTextQuote;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43950
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;-><init>()V

    .line 43951
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$InputTextQuote;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "inputTextQuote"    # Lorg/drinkless/tdlib/TdApi$InputTextQuote;
    .param p6, "i9"    # I

    .line 43938
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;-><init>()V

    .line 43939
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageReplyToExternalMessage;->chatId:J

    .line 43940
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageReplyToExternalMessage;->messageId:J

    .line 43941
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputMessageReplyToExternalMessage;->quote:Lorg/drinkless/tdlib/TdApi$InputTextQuote;

    .line 43942
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$InputMessageReplyToExternalMessage;->checklistTaskId:I

    .line 43943
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43947
    const v0, -0x1e1de91f

    return v0
.end method
