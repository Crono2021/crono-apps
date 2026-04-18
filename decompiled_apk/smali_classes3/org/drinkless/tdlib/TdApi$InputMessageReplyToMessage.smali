.class public Lorg/drinkless/tdlib/TdApi$InputMessageReplyToMessage;
.super Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageReplyToMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2e9cf6e8


# instance fields
.field public checklistTaskId:I

.field public messageId:J

.field public quote:Lorg/drinkless/tdlib/TdApi$InputTextQuote;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37974
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;-><init>()V

    .line 37975
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$InputTextQuote;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "inputTextQuote"    # Lorg/drinkless/tdlib/TdApi$InputTextQuote;
    .param p4, "i9"    # I

    .line 37963
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;-><init>()V

    .line 37964
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageReplyToMessage;->messageId:J

    .line 37965
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageReplyToMessage;->quote:Lorg/drinkless/tdlib/TdApi$InputTextQuote;

    .line 37966
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$InputMessageReplyToMessage;->checklistTaskId:I

    .line 37967
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37971
    const v0, -0x2e9cf6e8

    return v0
.end method
