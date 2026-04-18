.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageEdited;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageEdited"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2159fd1a


# instance fields
.field public chatId:J

.field public editDate:I

.field public messageId:J

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46110
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46111
    return-void
.end method

.method public constructor <init>(JJILorg/drinkless/tdlib/TdApi$ReplyMarkup;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 46098
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46099
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageEdited;->chatId:J

    .line 46100
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageEdited;->messageId:J

    .line 46101
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageEdited;->editDate:I

    .line 46102
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageEdited;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 46103
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46107
    const v0, -0x2159fd1a

    return v0
.end method
