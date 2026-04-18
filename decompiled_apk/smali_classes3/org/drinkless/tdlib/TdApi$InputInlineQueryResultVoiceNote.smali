.class public Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVoiceNote;
.super Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInlineQueryResultVoiceNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6ab256b7


# instance fields
.field public id:Ljava/lang/String;

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public title:Ljava/lang/String;

.field public voiceNoteDuration:I

.field public voiceNoteUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50038
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 50039
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "i9"    # I
    .param p5, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p6, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 50024
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 50025
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVoiceNote;->id:Ljava/lang/String;

    .line 50026
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVoiceNote;->title:Ljava/lang/String;

    .line 50027
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVoiceNote;->voiceNoteUrl:Ljava/lang/String;

    .line 50028
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVoiceNote;->voiceNoteDuration:I

    .line 50029
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVoiceNote;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 50030
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVoiceNote;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 50031
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50035
    const v0, -0x6ab256b7

    return v0
.end method
