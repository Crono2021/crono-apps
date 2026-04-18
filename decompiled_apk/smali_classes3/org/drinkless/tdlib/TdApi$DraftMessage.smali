.class public Lorg/drinkless/tdlib/TdApi$DraftMessage;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DraftMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x45711c0a


# instance fields
.field public date:I

.field public effectId:J

.field public inputMessageText:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;

.field public suggestedPostInfo:Lorg/drinkless/tdlib/TdApi$InputSuggestedPostInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47020
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47021
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;ILorg/drinkless/tdlib/TdApi$InputMessageContent;JLorg/drinkless/tdlib/TdApi$InputSuggestedPostInfo;)V
    .locals 0
    .param p1, "inputMessageReplyTo"    # Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;
    .param p2, "i9"    # I
    .param p3, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;
    .param p4, "j5"    # J
    .param p6, "inputSuggestedPostInfo"    # Lorg/drinkless/tdlib/TdApi$InputSuggestedPostInfo;

    .line 47007
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47008
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DraftMessage;->replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;

    .line 47009
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$DraftMessage;->date:I

    .line 47010
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$DraftMessage;->inputMessageText:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 47011
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$DraftMessage;->effectId:J

    .line 47012
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$DraftMessage;->suggestedPostInfo:Lorg/drinkless/tdlib/TdApi$InputSuggestedPostInfo;

    .line 47013
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47017
    const v0, -0x45711c0a

    return v0
.end method
